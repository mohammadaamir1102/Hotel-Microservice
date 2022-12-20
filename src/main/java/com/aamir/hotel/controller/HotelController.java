package com.aamir.hotel.controller;

import com.aamir.hotel.dto.PaginationDTO;
import com.aamir.hotel.entity.Hotel;
import com.aamir.hotel.exception.ResourceNotFoundException;
import com.aamir.hotel.exception.ServiceException;
import com.aamir.hotel.service.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/hotels")
@RestController
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/saveHotel")
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
        log.info("/* inside the HotelController, hotel {} */ ", hotel);
        Hotel saveHotel = hotelService.saveHotel(hotel);
        log.info("/* saved Successfully , hotel {} */ ", saveHotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveHotel);
    }

    @GetMapping("/findAllHotel")
    public ResponseEntity<List<Hotel>> findAllHotel() {
        List<Hotel> hotels = hotelService.findAllHotel();
        log.info("/* hotel {} */ ", hotels);
        return ResponseEntity.status(HttpStatus.OK).body(hotels);
    }

    @GetMapping("/findByHotelId/{hotelId}")
    public ResponseEntity<Hotel> findByHotelId(@PathVariable Long hotelId) throws ResourceNotFoundException {
        log.info("/* hotel id  {} */ ", hotelId);
        Hotel hotel = hotelService.findById(hotelId);
        log.info("/* hotel data {} */ ", hotel);
        return ResponseEntity.status(HttpStatus.OK).body(hotel);
    }

    @GetMapping("/findAllHotels/{page}/{offset}")
    public ResponseEntity<Map> findAllHotels(@PathVariable Long page, @PathVariable Long offset) throws ServiceException {
        PaginationDTO paginationDTO = new PaginationDTO();
        paginationDTO.setPageNumber(page.intValue());
        paginationDTO.setOffset(offset.intValue());
        log.info("/* pagination is  {} */ ", paginationDTO);
        Map allHotels = hotelService.findAllHotels(paginationDTO);
        log.info("/* all hotels {} */ ", allHotels);
        return ResponseEntity.status(HttpStatus.OK).body(allHotels);
    }
}
