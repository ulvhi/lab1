package com.reservations_lab.service;

import com.reservations_lab.dao.entity.ReservationEntity;
import com.reservations_lab.dao.repository.ReservationRepository;
import com.reservations_lab.model.enums.Status;
import com.reservations_lab.model.request.CreateReservationRequest;
import com.reservations_lab.model.request.UpdateStatusRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceHandler implements ReservationService {
    private final ReservationRepository reservationRepository;
    private ReservationEntity fetchCustomerIfExist(Long id) {
        return reservationRepository.findById(id).
                orElseThrow(RuntimeException::new);
    };

    @Override
    public void createReservation(CreateReservationRequest request) {
        ReservationEntity builder = ReservationEntity.builder()
                .tableName(request.getTableName())
                .customer(request.getCustomer())
                .date(request.getDate())
                .members_count(request.getMembers_count())
                .build();

        reservationRepository.findByTableNameAndDateAndStatusIs(request.getTableName(),request.getDate(), Status.ACTIVE).orElse(reservationRepository.save(builder));
    }

    @Override
    public void updateStatus(Long id, UpdateStatusRequest request) {
        var customer = fetchCustomerIfExist(id);
        customer.setStatus(request.getStatus());
        reservationRepository.save(customer);
    }

    @Override
    public ReservationEntity getReservationById(Long id) {
        return reservationRepository.findById(id).orElseThrow(RuntimeException::new);
    }



    @Override
    public List<ReservationEntity> findAllByIdAndStatusIs(Long id) {
        return List.of(reservationRepository.findAllByIdAndStatusIs(id, Status.ACTIVE).
                orElseThrow(RuntimeException::new));
    }
}
