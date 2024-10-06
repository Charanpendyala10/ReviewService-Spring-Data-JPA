package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking extends BaseModel{

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Review review;// 1:1 mapping relation b/w booking and review. Composition.

    @Enumerated(value= EnumType.STRING)
    private BookingStatus bookingStatus;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endTime;

    private long totalDistance;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Passenger passenger;

}
