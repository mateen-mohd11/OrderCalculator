import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class FooTest {

	private Map<String, Order> orderMap;
	private Map<String, Order> nullOrderMap;
	
	@Before
	public void setupOrderMap() throws Exception{
		orderMap = new HashMap<String, Order>();

		Order c = new Order();

		c.add(new OrderLine(new Item("book", (float) 12.49), 1));
		c.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
		c.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));

		orderMap.put("Order 1", c);

		c = new Order();

		c.add(new OrderLine(new Item("imported box of chocolate", 10), 1));
		c.add(new OrderLine(new Item("imported bottle of perfume", (float) 47.50), 1));
		
		orderMap.put("Order 2", c);
	}
	
	@Test
	public void sizeTest(){
		assertEquals(2, orderMap.size());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void nullOrderMapTest() throws Exception{
		nullOrderMap = new HashMap<String, Order>();
		Order c = new Order();
		c.add(null);
	}
	
	@Test
	public void roundingTest(){
		calculator cal = new calculator();
		double d = cal.rounding(12.4566d);
		assertEquals(12.46, d,2);
	}
}
