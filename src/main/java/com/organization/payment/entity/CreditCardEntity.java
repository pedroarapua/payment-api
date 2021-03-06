package com.organization.payment.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.annotations.Type;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Builder
@Entity
@Table(name = "credit_cards")
public class CreditCardEntity implements Serializable {

  private static final long serialVersionUID = -956876697219527005L;

  @Id
  @Type(type = "uuid-char")
  private UUID id;

  @Column
  private String number;

  @Column
  private String holderName;

  @Column
  private Integer month;

  @Column
  private Integer year;

  @Column
  private String issuer;
  
  @Column
  private String cvv;

  @ManyToOne(optional = false)
  @JoinColumn(name = "buyer_id")
  private BuyerEntity buyer;
  
  @OneToMany(mappedBy = "creditCard")
  private List<PaymentEntity> payments;

  @PrePersist
  protected void prePersist() {
    this.id = UUID.randomUUID();
  }

}
