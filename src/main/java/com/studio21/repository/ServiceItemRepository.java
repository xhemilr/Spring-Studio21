package com.studio21.repository;

import com.studio21.model.ServiceItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceItemRepository extends CrudRepository<ServiceItem, Integer> {
}
