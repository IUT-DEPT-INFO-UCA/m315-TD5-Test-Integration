package p1.fromFowlerMocks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import p1.fromFowlerMocks.Order;
import p1.fromFowlerMocks.Warehouse;

import static org.easymock.EasyMock.*;

class OrderStateTester {
	private static String DIET_COKE = "Diet Coke";
	private static String SPRITE = "Sprite";
	Warehouse warehouseMock;
	
	@BeforeEach
	protected void setUp() throws Exception {
		//Fixture with secondary object(s)
		warehouseMock = createMock(Warehouse.class);
	}
	
	@Test
	public void testOrderIsFilledIfEnoughInWarehouse(){
		//Expectations
		expect(warehouseMock.hasInventory(DIET_COKE,5)).andReturn(true);
		warehouseMock.remove(DIET_COKE,5);
		replay(warehouseMock);
		
		Order order = new Order(DIET_COKE,5);
		order.fill(warehouseMock);
		// Primary object test
		assertTrue(order.isFilled());
		
// Secondary object test(s)
		verify(warehouseMock);
	}

	/**
	 * This test must fail because the mocked object is never called
	 */
	@Disabled
	@Test
	public void testBadCallToMock(){
		warehouseMock.remove("cola",2);
		replay(warehouseMock);
		verify(warehouseMock);
	}
	
	/**
	 * This test must fail ...
	 */
	@Disabled
	@Test
	public void testUnexpectedCallToMock(){
		warehouseMock.remove("cola",2);
		replay(warehouseMock);
		Order order = new Order(SPRITE,11);
		order.fill(warehouseMock);
		verify(warehouseMock);

	}
	
	
	
}
