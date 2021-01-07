package com.travel.travel.services;

import com.travel.travel.entity.Hotel;
import com.travel.travel.repository.HotelRepo;
import com.travel.travel.viewmodel.HotelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelServices {

    private HotelRepo hotelRepo;

    @Autowired
    public HotelServices(HotelRepo hotelRepo){
        this.hotelRepo = hotelRepo;
    }

    public List<HotelDto> getAllHotels() {
        return hotelRepo.findAll()
                .stream()
                .map(HotelDto::new)
                .collect(Collectors.toList());
    }

    public Hotel saveHotel(HotelDto hotelDto) {
        Hotel hotel = new Hotel();
        hotel.setName(hotelDto.getName());
        hotel.setRatingScore(hotelDto.getRatingScore());
        hotel.setPhoneNumber(hotelDto.getPhoneNumber());
        hotel.setLocation(hotelDto.getLocation());
        hotel.setNumberOfRooms(hotelDto.getNumberOfRooms());
        hotel.setManagerId(hotelDto.getManagerId());
        hotel.setAvaliableTime(hotelDto.getAvailableTime());
        return hotelRepo.save(hotel);
    }

    public Optional<Hotel> findById(long id) {
        return hotelRepo.findById(id);
    }

    public void delete(Hotel hotel) {
        hotelRepo.delete(hotel);
    }
}
