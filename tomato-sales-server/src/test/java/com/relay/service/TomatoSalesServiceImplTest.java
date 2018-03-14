package com.relay.service;

import com.relay.pojo.TomatoSale;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TomatoSalesServiceImplTest {

	@InjectMocks
	private TomatoSalesServiceImpl service;

	@Test
	public void noticeContractForConnectionShouldCallClient() {

		final int actualSize = 10;
		final Collection<TomatoSale> expectedTomatoSales = service.queryLatestTomatoSales(actualSize);
		final int expectedSize = expectedTomatoSales.size();

		Assert.assertEquals(actualSize, expectedSize);
	}

}
