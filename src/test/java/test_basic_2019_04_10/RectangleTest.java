package test_basic_2019_04_10;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RectangleTest {
	
	@Test
	public void testCalculatedArea(){
		
		Rectangle rect = new Rectangle(10,20);
	
		double area = rect.calculatearea();
		
		System.out.println("This area is: " + area);
		
		assertEquals(100, area, 0.0001);

	}

}
