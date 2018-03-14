package com.relay.service;

import com.relay.pojo.TomatoSale;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
final class TomatoSalesServiceImpl implements TomatoSalesService {

	static final List<String> PROVIDERS = Arrays.asList("Heinz", "Hunt's", "Del Monte", "Le Ol' Granma");
	private static final int MINIMUM_RANGE = 1;
	private static final int MAXIMUM_RANGE = 2000;
	private static final LocalDate FIRST_DATE_OF_CURRENT_YEAR = LocalDate.now().withDayOfYear(1);

	@Override
	public Collection<TomatoSale> queryLatestTomatoSales(final Integer size) {
		Assert.notNull(size, "Requested size must not be null");

		final List<TomatoSale> result = new ArrayList<>(size);

		for (int i = 0; i < size; i++) {

			final UUID id = UUID.randomUUID();
			final Integer tomatoes = ThreadLocalRandom.current().nextInt(MINIMUM_RANGE, MAXIMUM_RANGE + 1);
			final String provider = PROVIDERS.get(ThreadLocalRandom.current().nextInt(PROVIDERS.size()));
			final long randomEpochDay = ThreadLocalRandom.current().nextLong(FIRST_DATE_OF_CURRENT_YEAR.toEpochDay(), LocalDate.now().toEpochDay());
			final LocalDate timestamp = LocalDate.ofEpochDay(randomEpochDay);
			final TomatoSale tomatoSale = TomatoSale.builder().id(id).tomatoes(tomatoes).provider(provider).timestamp(timestamp).build();
			result.add(tomatoSale);
		}
		// sort the list of tomato sales by descending timestamp
		final Comparator<TomatoSale> timestampComparator = (t1, t2) -> t2.getTimestamp().compareTo(t1.getTimestamp());
		result.sort(timestampComparator);
		return Collections.unmodifiableCollection(result);
	}
}
