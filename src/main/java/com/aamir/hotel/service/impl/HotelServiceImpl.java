package com.aamir.hotel.service.impl;

import com.aamir.hotel.dto.PaginationDTO;
import com.aamir.hotel.entity.Hotel;
import com.aamir.hotel.exception.ResourceNotFoundException;
import com.aamir.hotel.exception.ServiceException;
import com.aamir.hotel.repo.HotelRepository;
import com.aamir.hotel.service.HotelService;
import com.aamir.hotel.service.PaginationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private PaginationService paginationService;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> findAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel findById(Long hotelId) throws ResourceNotFoundException {
        return hotelRepository.findById(hotelId).orElseThrow(
                () -> new ResourceNotFoundException("Hotel id: " + hotelId + " is not Exist !"));
    }

    @Override
    public Map findAllHotels(PaginationDTO paginationDTO) throws ServiceException {
        Page<Hotel> hotels = hotelRepository.findAll(paginationService.getPagination(paginationDTO));
        log.info("/* hotel records {} */", hotels);
        Map<String, Object> datamap = new HashMap<>();
        datamap.put("data", hotels);
        datamap.put("totalPage", hotels.getTotalPages());
        datamap.put("currentPage", hotels.getNumber());
        datamap.put("currentPage", hotels.getNumber());
        datamap.put("totalRecords", hotels.getSize());
        return datamap;
    }
}
