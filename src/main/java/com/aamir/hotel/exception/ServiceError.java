package com.aamir.hotel.exception;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiceError {

    String msg;
    String errorCode;

}
