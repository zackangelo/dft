package zangelo.math.dft.lyons;

import zangelo.math.Complex;

/**
 * FFT stage 1, plain ol' DFT. 
 * 
 * page 132, eq 4-12
 * 
 * @author zangelo
 *
 */
public class FFTStageOne extends BaseFFTStage {
	
	@Override
	public Complex[] compute(Complex[] in) {
		int N = in.length;
		
		Complex[] out = new Complex[N];
		for(int m=0;m<N;m++) { 
			out[m] = new Complex(); //set to (0,0i)
			
			for(int n=0;n<N;n++) { 
				Complex W = W(m,n,N);
				Complex inAtN = in[n].clone();
				
				inAtN.mul(W);
				
				out[m].add(inAtN);
			}
		}
		
		return out;
	}

	/**
	 *  X(m) = Sum[n=0 to N-1] { x(n) * e^(-i2{pi}nm/N) }
	 *  e^(ix) = cos(x) + isin(x)
	 */
	

}
