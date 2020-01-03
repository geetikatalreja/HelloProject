package HelloTest;
import org.junit.Test;

import HelloProject.HelloClass;

import static org.junit.Assert.assertEquals;

public class Hello1Test {
	String message = "Hello World";
	String message1 = "Hello World";
	HelloClass hell = new HelloClass(message);
	
	@Test
	   public void testPrintMessage() {	
		assertEquals(message1,hell.printMessage());
	}
}
