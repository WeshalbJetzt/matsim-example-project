package test_basic_2019_04_10;

public class Rectangle {
	
	private double width;
	private double height;
	
	public Rectangle(double width, double height){
		this.width = width;
		this.height = height;
	}
	
	public double calculatearea(){
		return width*height;
	}
	
}
