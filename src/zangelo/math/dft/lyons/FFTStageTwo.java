package zangelo.math.dft.lyons;

import zangelo.math.Complex;

public class FFTStageTwo extends BaseFFTStage {

	@Override
	public Complex[] compute(Complex[] in) {
		
//		Well, after actually understanding the FFT algorithm, I now know that this check does 
//		nothing outside of a recursive FFT implementation. 
		if(in.length % 2 != 0)  {
			throw new IllegalArgumentException("Size must be power of two");
		}
		
		int N = in.length;
		Complex[] X = new Complex[N];		//dft result array
		
		Complex[] inEven = even(in);
		Complex[] inOdd = odd(in);
		
		for(int m=0;m<N;m++) {
			Complex evenResult = new Complex();
			
			//compute even 
			for(int n=0;n<N/2;n++) { 
				Complex W = W(m,2*n,N);
				Complex x = inEven[n].clone();
				x.mul(W);
				evenResult.add(x);
			}
			
			Complex oddResult = new Complex();
			
			//compute odd
			for(int n=0;n<N/2;n++) { 
				Complex W = W(m,2*n+1,N);
				Complex x = inOdd[n].clone();
				x.mul(W);
				oddResult.add(x);
			}
			
			evenResult.add(oddResult);
			X[m] = evenResult;
		}
		
		return X;
	}

}
