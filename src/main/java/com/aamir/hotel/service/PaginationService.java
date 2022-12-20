package com.aamir.hotel.service;


import com.aamir.hotel.dto.PaginationDTO;
import com.aamir.hotel.exception.ServiceException;
import org.springframework.data.domain.Pageable;

public interface PaginationService {
    Pageable getPagination(PaginationDTO paginationDTO) throws ServiceException;

}
