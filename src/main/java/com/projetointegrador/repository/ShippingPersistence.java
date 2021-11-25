package com.projetointegrador.repository;

import com.projetointegrador.entity.Shipping;
import com.projetointegrador.entity.States;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShippingPersistence extends JpaRepository<Shipping, String> {

    Shipping findByShippingId(String shippingId);

//    Shipping findShipping(Shipping shipping);

}
