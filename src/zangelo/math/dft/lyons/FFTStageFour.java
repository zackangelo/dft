package zangelo.math.dft.lyons;

import zangelo.math.Complex;

public class FFTStageFour extends BaseFFTStage {

	@Override
	public Complex[] compute(Complex[] in) {
		if(in.length == 0) throw new IllegalArgumentException("No data in input array!");
		return fft(in);
	}
	
	protected Complex[] fft(Complex[] in) { 
		int N = in.length;
		
		if(N == 1) return new Complex[] { in[0] };
		
		if((N%2) != 0) throw new IllegalArgumentException("FFT input must be a power of two");
		
		Complex[] fftEven = fft(even(in));
		Complex[] fftOdd = fft(odd(in));
		
	}

}
