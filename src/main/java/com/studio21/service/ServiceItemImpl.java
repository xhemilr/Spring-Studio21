package com.studio21.service;

import com.studio21.model.ServiceItem;
import com.studio21.repository.ServiceItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceItemImpl implements ServiceItemService {

    @Autowired
    private ServiceItemRepository serviceItemRepository;

    @Override
    public List<ServiceItem> findAll() {
        return (List<ServiceItem>) serviceItemRepository.findAll();
    }

    @Override
    public ServiceItem save(ServiceItem item) {
        return serviceItemRepository.save(item);
    }

    @Override
    public Optional<ServiceItem> findById(int id) {
        return serviceItemRepository.findById(id);
    }

    @Override
    public long count() {
        return serviceItemRepository.count();
    }

    @Override
    public void delete(ServiceItem item) {
        serviceItemRepository.delete(item);
    }
}
