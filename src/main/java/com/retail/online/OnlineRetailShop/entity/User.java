package com.retail.online.OnlineRetailShop.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    private Long userId;
    private String userName;
    private String mobileNumber;
    private String address;
    @Column(unique=true)
    @JsonIgnore
    private String cartId;

}
