package com.densoft.courier.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourierResponse {
private String consignmentNumber;
private String deliveryStatus;
private String expectedDate;
}
