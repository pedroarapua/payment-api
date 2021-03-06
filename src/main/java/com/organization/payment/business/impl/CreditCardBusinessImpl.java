package com.organization.payment.business.impl;

import br.com.moip.validators.CreditCard;

import com.organization.payment.business.CreditCardBusiness;
import com.organization.payment.entity.CreditCardEntity;
import com.organization.payment.repository.CreditCardRepository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreditCardBusinessImpl implements CreditCardBusiness {

  private final CreditCardRepository creditCardRepository;

  @Autowired
  public CreditCardBusinessImpl(final CreditCardRepository creditCardRepository) {
    this.creditCardRepository = creditCardRepository;
  }

  @Override
  public CreditCardEntity save(final CreditCardEntity creditCard) {
    creditCard.setIssuer(new CreditCard(creditCard.getNumber()).getBrand().toString());
    return this.creditCardRepository.save(creditCard);
  }
  
  @Override
  public Optional<CreditCardEntity> findById(UUID id) {
    return this.creditCardRepository.findById(id);
  }
}
