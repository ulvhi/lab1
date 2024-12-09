package com.reservations_lab.dao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.reservations_lab.model.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "reservations")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tableName;
    private String customer;
    private Date date;
    private Status status;
    private int members_count;
}
