package zangelo.math.dft;

import zangelo.math.Complex;

public class DftResult {
	private int numPoints;
	
	public DftResult(int numPoints) { 
		this.numPoints = numPoints;
		
		tdIndVals = new double[numPoints];
		tdDepVals = new double[numPoints];
		
		fdIndVals = new double[numPoints];
		fdDepValsMag = new double[numPoints];
		
		fdDepVals = new Complex[numPoints];
	}
	
	//time domain values
	public double[] tdIndVals,
					tdDepVals;
	
	//frequency domain values
	public double[] fdIndVals,
					fdDepValsMag;
	public Complex[] fdDepVals;
}
