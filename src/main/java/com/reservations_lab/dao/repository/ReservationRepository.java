package com.reservations_lab.dao.repository;

import com.reservations_lab.dao.entity.ReservationEntity;
import com.reservations_lab.model.enums.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.Optional;

public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {
    Optional<ReservationEntity> findByTableNameAndDateAndStatusIs(String tableName, Date date,Status status);
    Optional<ReservationEntity> findAllByIdAndStatusIs(Long id, Status status);


}
