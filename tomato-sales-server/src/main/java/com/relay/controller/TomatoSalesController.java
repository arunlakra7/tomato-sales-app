package com.relay.controller;

import com.relay.pojo.TomatoSale;
import com.relay.service.TomatoSalesService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tomatosale")
public class TomatoSalesController {

	static final String DEFAULT_VALUE = "3";

	private final TomatoSalesService tomatoSalesService;

	@Autowired
	public TomatoSalesController(final TomatoSalesService tomatoSalesService) {
		this.tomatoSalesService = tomatoSalesService;
	}

	/**
	 * A simple GET rest end point responsible for getting a list of latest tomato sales.
	 *
	 * @param size a list of this size is returned and it is optional with a default value of three
	 * @return a list of {@link TomatoSale}
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public Collection<TomatoSale> queryTomatoSales(@RequestParam(value = "size", required = false, defaultValue = DEFAULT_VALUE) final Integer size) {
		return tomatoSalesService.queryLatestTomatoSales(size);
	}
}
