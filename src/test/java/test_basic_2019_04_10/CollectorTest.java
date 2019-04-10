package test_basic_2019_04_10;

import java.util.List;

import org.junit.Test;

public class CollectorTest {

	@Test
	
	public void listExample(){
		
		List<Rectangle> myList = new ArrayList<>();
		myList.add(new Rectangle(10,20));
		myList.add(new Rectangle(10,200));
		myList.add(new Rectangle(10,2));
		myList.add(new Rectangle(10,10));
		myList.add(new Rectangle(10,20000));
		
		for(Rectangle rect : myList) {
			
			System.out.println("The area is: " + rect.calculatearea());
			
		}
		
	}
}
