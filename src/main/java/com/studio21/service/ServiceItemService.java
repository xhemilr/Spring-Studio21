package com.studio21.service;

import com.studio21.model.ServiceItem;

import java.util.List;
import java.util.Optional;

public interface ServiceItemService {

    ServiceItem save(ServiceItem item);

    Optional<ServiceItem> findById(int id);

    List<ServiceItem> findAll();

    long count();

    void delete(ServiceItem item);
}
