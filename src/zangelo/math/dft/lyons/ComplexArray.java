package zangelo.math.dft.lyons;

import java.io.OutputStream;
import java.io.PrintWriter;

public class ComplexArray {
	public ComplexArray(int N) {
		this.re = new double[N];
		this.im = new double[N];
	}
	
	public double[] re() { return re; }
	public double[] im() { return im; }
	public int size() { return re.length; }
	
	private double[] re;
	private double[] im;
	
	public void print() { 
		print(System.out);
	}
	
	public void print(OutputStream os) { 
		PrintWriter out = new PrintWriter(os);
		
		for(int i=0;i<size();i++) { 
			out.print(re[i]);
			
			if(im[i] >= 0d) { 
				out.println(" + ");
			} else { 
				out.println(" - ");
			}
			
			out.print(im[i]);
			out.println("i");
		}
		
		out.close();
	}
}
