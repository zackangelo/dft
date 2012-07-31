package zangelo.math.dft.lyons;

import zangelo.math.Complex;

/**
 * I've split the FFT explanation in Lyon's book 
 * into stages.
 * 
 * FFT explanation starts on pg132. 
 * 
 * @author zangelo
 *
 */
public interface FFTStage {
	public Complex[] compute(Complex[] in);
}
