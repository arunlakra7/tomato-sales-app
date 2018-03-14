package com.relay.service;

import com.relay.pojo.TomatoSale;

import java.util.Collection;

/**
 * A service responsible for carrying operations related to the tomato sales that happened in the market.
 */
public interface TomatoSalesService {

	/**
	 * Returns a collection of latest tomato sales sorted by {@link TomatoSale#timestamp} with a size equal to the one requested.
	 *
	 * @param size a collection of this size is returned
	 * @return a list of {@link TomatoSale}
	 */
	Collection<TomatoSale> queryLatestTomatoSales(Integer size);

}
