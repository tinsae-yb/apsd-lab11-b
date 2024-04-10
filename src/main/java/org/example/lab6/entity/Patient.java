package org.example.lab6.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Entity
@Data
public class Patient extends User {
    @OneToOne
    private Address mailingAddress;
    private LocalDate dateOfBirth;

    private String patientNo;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
}
