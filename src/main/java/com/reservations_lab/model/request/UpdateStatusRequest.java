package com.reservations_lab.model.request;

import com.reservations_lab.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStatusRequest {
    private Status status;
}
