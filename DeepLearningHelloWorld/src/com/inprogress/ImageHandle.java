package com.inprogress;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageHandle {
	
	static final String jpg = "jpg";
	private BufferedImage image;
	
	public ImageHandle() {
		super();
	}

	public BufferedImage toGrayScale(BufferedImage inputImage) {
		BufferedImage outputImage = inputImage;
		int width = outputImage.getWidth();
		int height = outputImage.getHeight();
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Color color = new Color(outputImage.getRGB(j, i));
				int red = (int) (color.getRed() * 0.299); // find out why 0.299, same for blue & green
				int blue = (int) (color.getBlue() * 0.587);
				int green = (int) (color.getGreen() * 0.114);
				int gray = red + blue + green;
				Color grayColor = new Color(gray, gray, gray);
				outputImage.setRGB(j, i, grayColor.getRGB());
			}
		}
		
		return outputImage;
		//File output = new File(grayImageName);
		//ImageIO.write(image, jpg , output);
	}
	
	public BufferedImage resize(BufferedImage inputImage, int scaledWidth, int scaledHeight ) {
		BufferedImage outputImage = new BufferedImage(scaledWidth, scaledHeight, inputImage.getType());
		Graphics2D g2d = outputImage.createGraphics();
		g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
		g2d.dispose();
		return outputImage;
	}
	
	public double[] getPixelArray(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		int size = width * height;
		double[] pixels = new double[size];
		
		int index = 0;
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				pixels[index] = image.getRGB(col, row);
				index++;
			}
		}
		return pixels;
	}
	
	public static void main(String[] args) throws IOException {
		ImageHandle ih = new ImageHandle();
		BufferedImage image = ImageIO.read(new File("input/1.jpg"));
		BufferedImage grayImage = ih.toGrayScale(image);
		BufferedImage resizedImage = ih.resize(grayImage, 28, 28);
		
		double[] pixelArray = ih.getPixelArray(resizedImage);
		for (double d : pixelArray) {
			System.out.println(d);
		}
		System.out.println("size: " + pixelArray.length);
		/*File output = new File("input/gray1.jpg");
		ImageIO.write(grayImage, jpg , output);*/
		
	}

}
