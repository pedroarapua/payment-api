package com.organization.payment.v1.dto;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class PaymentClientRequestDto implements Serializable {

  private static final long serialVersionUID = 5267931934989313385L;

  @NotNull(message = "Please provide the client id of Payment")
  private UUID id;
}
