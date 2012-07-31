package zangelo.math;

import java.text.NumberFormat;

public class Complex {
	private static NumberFormat fmt = NumberFormat.getInstance();
	
	static {
		fmt.setMaximumFractionDigits(4);
	}
	
	
	public Complex() { }
	public Complex(double re,double im) { 
		this.re = re;
		this.im = im;
	}
	
	public Complex(double re) { 
		this.re = re;
		this.im = 0d;
	}
	
	public Complex clone() { 
		return new Complex(re,im);
	}
	
	public double re = 0d;
	public double im = 0d; 
	
	/**
	 * Adds a complex value to the one represented by
	 * this object.
	 * @param b
	 */
	public void add(Complex c) { 
		re += c.re;
		im += c.im;
	}
	
	/**
	 * Adds a scalar value to the complex value represented
	 * by this object.
	 * @param b
	 */
	public void add(double b) { 
		re += b;
	}
	
	/**
	 * Subtracts a complex value from the complex value 
	 * represented by this object.
	 * @param c
	 */
	public void sub(Complex c) { 
		re -= c.re;
		im -= c.im;
	}
	
	/**
	 * Scalar multiply
	 * @param b scalar factor
	 */
	public void mul(double b) { 
		re *= b;
		im *= b;
	}
	
	/**
	 * Complex multiply
	 * @param f multiplying factor
	 */
	public void mul(Complex f) { 
		//(a+bi)(c+di) = ac + a*di + c*bi + bi*di = (ac - bd) + i(ad + cb) 
		
		double a,b,c,d;
		a = this.re; b = this.im;
		c = f.re; d = f.im;
		
		this.re = a*c - b*d;
		this.im = a*d + c*b;
	}
	
	public String toString() { 
		String sign = ((im < 0)?"-":"+");
		return "("+fmt.format(re)+","+fmt.format(im)+"i)";
	}
	
	public double mag() { 
		return Math.sqrt((re*re)+(im*im));
	}
}
