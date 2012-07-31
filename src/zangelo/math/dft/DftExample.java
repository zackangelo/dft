package zangelo.math.dft;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DecimalDV;

import zangelo.math.Function2d;

public class DftExample {

	private static final double TWOPI = 2*Math.PI;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Function2d exampleOne = new Function2d() { 
			@Override
			public double eval(double t) {
				return Math.sin(TWOPI*1000*t) + 
						0.5*Math.sin(TWOPI*2000*t+(3*Math.PI/4));
			}
		};
		
		DiscreteFourierTransform dft = 
			new DiscreteFourierTransform(exampleOne,16000,1024);
		
		long startTime = System.currentTimeMillis();
		
		DftResult result = dft.calculate();
		
		double totalTime = (System.currentTimeMillis() - startTime) / 1000d;
		
		NumberFormat fmt =  NumberFormat.getInstance();
		
		fmt.setMaximumFractionDigits(7);
		fmt.setMinimumFractionDigits(7);
		
		System.out.println("DFT took " + fmt.format(totalTime) + " seconds!");
		
		return;
	}

}
