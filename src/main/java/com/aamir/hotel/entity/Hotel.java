package com.aamir.hotel.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "HOTEL_MICRO")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HOTEL_ID")
    @SequenceGenerator(name = "SEQ_HOTEL_ID", sequenceName = "SEQ_HOTEL_ID", allocationSize = 1)
    @Column(name = "HOTEL_ID", unique = true, nullable = false)
    private Long hotelId;
    @Column(name = "HOTEL_NAME")
    private String name;
    @Column(name = "HOTEL_LOCATION")
    private String location;
    @Column(name = "HOTEL_ABOUT")
    private String about;

}
