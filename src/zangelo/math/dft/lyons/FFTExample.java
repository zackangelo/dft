package zangelo.math.dft.lyons;

import zangelo.math.Complex;

public class FFTExample {

	public static void po(Complex[] o) { 
		for(int i=0;i<o.length;i++) { 
			System.out.println(o[i]);
		}
	}
	public static void main(String[] args) { 
		Complex[] input = new Complex[] { 
			new Complex(0.3535d), 
			new Complex(0.3535d),
			new Complex(0.6464d), 
			new Complex(1.0607d),
			new Complex(0.3535d), 
			new Complex(-1.0607d),
			new Complex(-1.3535d), 
			new Complex(-0.3535d)
		};
		
		FFTStage fftStage = new FFTStageOne();
		
		Complex[] output = fftStage.compute(input.clone());
		po(output);
		
		System.out.println("\n");
		
		fftStage = new FFTStageTwo();
		output = fftStage.compute(input.clone());
		po(output);
		
		System.out.println("\n");
		
		fftStage = new FFTStageThree();
		output = fftStage.compute(input.clone());
		po(output);
	}
}
