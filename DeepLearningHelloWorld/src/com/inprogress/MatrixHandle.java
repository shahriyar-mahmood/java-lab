package com.inprogress;

import org.jblas.DoubleMatrix;
import org.jblas.MatrixFunctions;

public class MatrixHandle {
	public static void main(String[] args) {
		double[][] data = new double[][] {
			{1, 1, 1, 1},
			{0, 0, 0, 0},
			{1, 0, 1, 0}
		};
		
		DoubleMatrix matrix = new DoubleMatrix(data);
		DoubleMatrix vector = new DoubleMatrix(new double[]{1, 0, 0, 0});
		DoubleMatrix result = matrix.mmul(vector);
		System.out.println(matrix.rows + "x" + matrix.columns + ":" + matrix);
		System.out.println(vector.rows + "x" + vector.columns + ":" + vector);
		System.out.println(result.rows + "x" + result.columns + ":" + result);
	}
	
	/**
	 * sigmoid function
	 * 
	 * S(t) = 1 / (1 + e^(-1))
	 * 
	 * @param matrix
	 * @return
	 */
	/*public DoubleMatrix sigmoid(DoubleMatrix t) {
		t.muli(-1);
		MatrixFunctions.expi(t);
		DoubleMatrix ones = DoubleMatrix.ones(t.rows, t.columns);
		return out;
	}*/
	
	public double sigmoid(double t) {
		return 1 / (1 + Math.exp(-t));
	}
	
	public DoubleMatrix sigmoidReg(DoubleMatrix t) {
		DoubleMatrix output = new DoubleMatrix(t.rows, t.columns);
		double value;
		double sigval;
		
		for (int row = 0; row < t.rows; row++) {
			for (int col = 0; col < t.columns; col++) {
				value  = t.get(row, col);
				sigval = sigmoid(value);
				output.put(row, col, sigval);
			}
		}
		return output;
	}

}
