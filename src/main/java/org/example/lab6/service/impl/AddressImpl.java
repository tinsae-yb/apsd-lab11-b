package org.example.lab6.service.impl;

import lombok.AllArgsConstructor;
import org.example.lab6.entity.Address;
import org.example.lab6.entity.User;
import org.example.lab6.repo.AddressRepository;
import org.example.lab6.repo.UserRepository;
import org.example.lab6.service.AddressService;
import org.example.lab6.service.UserService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressImpl implements AddressService {


    private AddressRepository addressRepository;
    @Override
    public Address newAddress(Address address) {
        return addressRepository.save(address);
    }


}
