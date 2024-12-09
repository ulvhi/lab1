package com.reservations_lab.controller;

import com.reservations_lab.dao.entity.ReservationEntity;
import com.reservations_lab.model.request.CreateReservationRequest;
import com.reservations_lab.model.request.UpdateStatusRequest;
import com.reservations_lab.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;
    @PostMapping
    public void createReservation(@RequestBody CreateReservationRequest reservation){
        reservationService.createReservation(reservation);
    }
    @GetMapping("{id}")
    public ReservationEntity getReservationById(@PathVariable Long id){
        return reservationService.getReservationById(id);
    }
    @PatchMapping("/{id}/subscriptionAmount")

    public void updateSubscriptionAmount(@PathVariable long id, @RequestBody UpdateStatusRequest reservation){
        reservationService.updateStatus(id, reservation);
    }
    @GetMapping("/active/{id}")
    public ReservationEntity getReservationById(@PathVariable Long id){
        return reservationService.findAllByIdAndStatusIs(id);
    }
}
