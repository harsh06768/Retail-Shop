package com.retail.online.OnlineRetailShop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {
    @Id
    @SequenceGenerator(name = "CartCidsequence", sequenceName = "cartSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "CartCidsequence")
    @JsonIgnore
    private Long cid;
    private String cartId;
    private Long prodId;
}
