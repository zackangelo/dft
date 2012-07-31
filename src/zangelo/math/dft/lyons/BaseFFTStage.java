package zangelo.math.dft.lyons;

import zangelo.math.Complex;

public abstract class BaseFFTStage implements FFTStage {
	public static Complex[] odd(Complex[] all) {
		Complex[] odd = new Complex[all.length/2];
		
		for(int n=0;n<odd.length;n++) { 
			odd[n] = all[2*n+1];
		}
		
		return odd;
	}
	
	public static Complex[] even(Complex[] all) { 
		Complex[] even = new Complex[all.length/2];
		
		for(int n=0;n<even.length;n++) {
			even[n] = all[2*n];
		}
		
		return even;
	}
	
	
	/**
	 * Computes the twiddle factor for the 
	 * parameters given

	 * @return
	 */
	public static Complex W(int m, int n, int N) {
		Complex W = new Complex();
		double exp = 2*Math.PI*n*m/N;
		
		W.re = Math.cos(exp);
		W.im = Math.sin(exp) * -1;
		
		return W;
	}
}
