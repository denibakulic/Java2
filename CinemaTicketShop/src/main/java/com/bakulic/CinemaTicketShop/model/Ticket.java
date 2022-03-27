package com.bakulic.CinemaTicketShop.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int ticketId;

    @Column(name = "status")
    private String status;

    @Column(name="number")
    private Integer seatNumber;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idProjection")
    private Projection projection;

}