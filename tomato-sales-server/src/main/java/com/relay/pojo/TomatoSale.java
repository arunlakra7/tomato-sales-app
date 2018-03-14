package com.relay.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

/**
 * A plain pojo consisting attributes of a tomato sale.
 */
@Data
@Builder(toBuilder = true)
@JsonPOJOBuilder(withPrefix = "")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class TomatoSale {

	private final UUID id;
	private final Integer tomatoes;
	private final String provider;
	private final LocalDate timestamp;

}
