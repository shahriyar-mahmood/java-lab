package com.inprogress;

import java.util.ArrayList;

import org.jblas.DoubleMatrix;
import org.jblas.benchmark.Main;

public class NeuralNetwork {
	
	Sigmoid activation = new Sigmoid();
	
	int inputLayerSize;
	int hiddenLayerSize;
	int outputLayerSize;
	
	int hiddenLayerCount;
	
	DoubleMatrix w1;
	DoubleMatrix w2;
	
	ArrayList<DoubleMatrix> weights = new ArrayList<DoubleMatrix>();
	
	public NeuralNetwork(int inputLayerSize, int hiddenLayerSize, int outputLayerSize) {
		super();
		this.inputLayerSize = inputLayerSize;
		this.hiddenLayerSize = hiddenLayerSize;
		this.outputLayerSize = outputLayerSize;
		
		w1 = DoubleMatrix.randn(hiddenLayerSize, inputLayerSize);
		w2 = DoubleMatrix.randn(hiddenLayerSize, outputLayerSize);
	}
	
	public NeuralNetwork(int inputLayerSize, int hiddenLayerSize, int outputLayerSize, int hiddenLayerCount) {
		super();
		this.inputLayerSize = inputLayerSize;
		this.hiddenLayerSize = hiddenLayerSize;
		this.outputLayerSize = outputLayerSize;
		this.hiddenLayerCount = hiddenLayerCount;
		
		while (hiddenLayerCount != 0) {
			weights.add(DoubleMatrix.randn(inputLayerSize, hiddenLayerSize));
			hiddenLayerCount--;
		}
		weights.add(DoubleMatrix.randn(hiddenLayerSize, outputLayerSize));
	}
	
	public DoubleMatrix forwardPropagation(DoubleMatrix input) {
		DoubleMatrix hidden = w1.mmul(input);
		DoubleMatrix activatedHidden = activation.sigmoid(hidden);
		DoubleMatrix output = w2.mmul(activatedHidden);
		DoubleMatrix activatedOutput = activation.sigmoid(output);
		return activatedOutput;
	}
	
	public DoubleMatrix forwardPropagationReal(DoubleMatrix input) {
		DoubleMatrix neuron = input;
		DoubleMatrix activatedHidden;
		for (DoubleMatrix weight : weights) {
			activatedHidden = next(neuron, weight);
			neuron = activatedHidden;
		}
		return neuron;
	}
	
	private DoubleMatrix next(DoubleMatrix neuron, DoubleMatrix weight) {
		DoubleMatrix hidden = neuron.mmul(weight);
		return activation.sigmoid(hidden);
	}

}
