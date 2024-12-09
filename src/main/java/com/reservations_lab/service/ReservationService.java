package com.reservations_lab.service;

import com.reservations_lab.dao.entity.ReservationEntity;
import com.reservations_lab.model.enums.Status;
import com.reservations_lab.model.request.CreateReservationRequest;
import com.reservations_lab.model.request.UpdateStatusRequest;

import java.util.List;

public interface ReservationService {
    void createReservation(CreateReservationRequest request);
    void updateStatus(Long id, UpdateStatusRequest request);
    ReservationEntity getReservationById(Long id);
    List<ReservationEntity> findAllByIdAndStatusIs(Long id, Status status);
}
