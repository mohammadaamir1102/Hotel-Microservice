package com.aamir.hotel.service;

import com.aamir.hotel.dto.PaginationDTO;
import com.aamir.hotel.entity.Hotel;
import com.aamir.hotel.exception.ResourceNotFoundException;
import com.aamir.hotel.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface HotelService {

    Hotel saveHotel(Hotel hotel);

    List<Hotel> findAllHotel();

    Hotel findById(Long hotelId) throws ResourceNotFoundException;

    Map findAllHotels(PaginationDTO paginationDTO) throws ServiceException;
}
