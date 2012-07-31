package zangelo.math.dft.lyons;

import zangelo.math.Complex;

/**
 * This stage consolidates both even and odd into a single loop.
 * 
 * They use a constant twiddle factor so we've cut the cos/sin calcs
 * in half.
 * 
 * @author zangelo
 *
 */
public class FFTStageThree extends BaseFFTStage {

	@Override
	public Complex[] compute(Complex[] in) {
		int N = in.length;
		
		Complex[] even = even(in);
		Complex[] odd = odd(in);
		
		Complex[] X = new Complex[N];
		
		for(int m=0;m<N;m++) { 
			Complex evenResult = new Complex();
			Complex oddResult = new Complex();
			
			for(int n=0;n<N/2;n++) {
				Complex W = W(m,n,N/2);
				
				Complex xEven = even[n].clone();
				Complex xOdd = odd[n].clone();
				
				xEven.mul(W);
				xOdd.mul(W);
				
				evenResult.add(xEven);
				oddResult.add(xOdd);
			}
			
			// twiddle factor outside of the odd summation
			Complex oddW = W(m,1,N);
			oddResult.mul(oddW);
			
			evenResult.add(oddResult);
			X[m] = evenResult;
		}
		
		return X;
	}

}
