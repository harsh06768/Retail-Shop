package com.retail.online.OnlineRetailShop.repository;

import com.retail.online.OnlineRetailShop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
