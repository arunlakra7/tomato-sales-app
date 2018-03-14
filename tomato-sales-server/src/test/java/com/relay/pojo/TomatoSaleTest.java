package com.relay.pojo;

import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.Test;

public class TomatoSaleTest {

	@Test
	public void testEqualsAndHashCode() {
		EqualsVerifier.forClass(TomatoSale.class).allFieldsShouldBeUsed().verify();
	}
}
