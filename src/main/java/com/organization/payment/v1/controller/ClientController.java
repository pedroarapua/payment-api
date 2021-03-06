package com.organization.payment.v1.controller;

import com.organization.payment.business.ClientBusiness;
import com.organization.payment.entity.ClientEntity;
import com.organization.payment.v1.dto.ClientRequestDto;
import com.organization.payment.v1.dto.ClientResponseDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/paymentapi/clients")
@Api(value = "Client")
public class ClientController {

  private final ClientBusiness clientBusiness; 
  private final ModelMapper modelMapper;
  
  @Autowired public ClientController(
      final ClientBusiness clientBusiness,
      final ModelMapper modelMapper) { 
    this.clientBusiness = clientBusiness;
    this.modelMapper = modelMapper;
  }

  @ApiOperation(value = "Create a new Client")
  @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(code = HttpStatus.CREATED)
  @ResponseBody
  public ClientResponseDto post(@RequestBody @Valid final ClientRequestDto clientRequestDto) {
    
    ClientEntity clientEntity = this.modelMapper.map(clientRequestDto, ClientEntity.class);
    ClientResponseDto clientDtoResponse = this.modelMapper.map(
        this.clientBusiness.save(clientEntity), ClientResponseDto.class);

    return clientDtoResponse;
  }

}
