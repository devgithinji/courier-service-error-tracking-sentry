package com.densoft.courier.api.service;

import java.util.Random;
import java.util.UUID;

import javax.management.ServiceNotFoundException;

import com.densoft.courier.api.dto.CourierRequest;
import com.densoft.courier.api.dto.CourierResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;



import io.sentry.Sentry;

@Service
public class CourierService {

	public CourierResponse processCourier(CourierRequest request) {

		CourierResponse response = null;

		Sentry.init("https://c6c47c14baed4bc5905d1eb64e67a8bf@sentry.io/1354466");

		try {
			if (!isServiceAvailable(request.getPin())) {
				throw new ServiceNotFoundException("service not available for your location " + request.getPin());
			}
			if (request.getWeight() > 2) {
				throw new NotAcceptableStatusException("weight shouldn't be more than 1.5 kg");
			}

		} catch (Exception e) {
			Sentry.capture(e);
			return response = new CourierResponse("**", "failure", "couldn't process");

		}
		// if everything ok , then call rest API to dispatch courier
		response = new CourierResponse(UUID.randomUUID().toString(), "process", "21/12/2018");
		return response;
	}

	// check service availability

	public boolean isServiceAvailable(String pin) {
		return new Random().nextBoolean();
	}

}
