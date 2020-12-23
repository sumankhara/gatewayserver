package com.optimagrowth.gateway.filters;

import static com.optimagrowth.gateway.GatewayServerConstants.*;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

@Component
public class FilterUtils {

	public String getCorrelationId(HttpHeaders requestHeaders) {
		if (requestHeaders.get(CORRELATION_ID) != null) {
			return requestHeaders.get(CORRELATION_ID).stream().findFirst().get();
		} else {
			return null;
		}
	}

	public ServerWebExchange setCorrelationId(ServerWebExchange exchange, String correlationId) {
		return setRequestHeader(exchange, CORRELATION_ID, correlationId);
	}

	public ServerWebExchange setRequestHeader(ServerWebExchange exchange, String name, String value) {
		return exchange.mutate().request(exchange.getRequest().mutate().header(name, value).build()).build();
	}
}
