package zangelo.math.dft;

import zangelo.math.Complex;
import zangelo.math.Function2d;

public class DiscreteFourierTransform {
	private Function2d tdFunc;	//function we're transforming
	private int sampleRate; 	//sampling rate in hertz
	private int numPoints;
	
	public static final double TWOPI = 2 * Math.PI;
	
	
	public DiscreteFourierTransform(Function2d timeDomainFunc, int sampleRate,
			int numPoints) {
		super();
		this.tdFunc = timeDomainFunc;
		this.sampleRate = sampleRate;
		this.numPoints = numPoints;
	}
	
	private void calcTimeDomain(DftResult result) { 
		double deltaX = 1d/sampleRate;
		
		for(int i=0;i<numPoints;i++) { 
			double ind = deltaX * i;
			result.tdIndVals[i] = ind;
			result.tdDepVals[i] = tdFunc.eval(ind);
		}
		
	}
	
	private void calcFreqDomain(DftResult result) {
		calcFreqDomainIndep(result);
		for(int m=0;m<numPoints;m++) { 
			Complex mRes = new Complex();
			
			for(int n=0;n<numPoints;n++) { 
				Complex nRes = new Complex();
				
				double freq = (TWOPI*n*m) / numPoints;
				double td = result.tdDepVals[n];
				
				double cos = Math.cos(freq);
				double sin = Math.sin(freq);
				
				nRes.re = td * cos;
				nRes.im = (-1) * td * sin;
			
				mRes.add(nRes);
			}
			
			result.fdDepVals[m] = mRes;
		}
	}
	
	private void calcFreqDomainIndep(DftResult result) {
		for(int i=0;i<numPoints;i++) { 
			result.fdIndVals[i] = i*(sampleRate/numPoints);
		}
	}

	public DftResult calculate() { 
		DftResult result = new DftResult(numPoints);
		
		calcTimeDomain(result);
		calcFreqDomain(result);
		
		return result;
	}
			
}
