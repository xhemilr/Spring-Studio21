package com.studio21.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "service_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceId;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "product_desc")
    private String productDesc;

    @Column(name = "price")
    private Double price;

    @Column(name = "received_date")
    private LocalDate receivedDate;

    @Column(name = "completed_date")
    private LocalDate completedDate;

    @Column(name = "service_status")
    private boolean serviceStatus;

    @Column(name = "payment_status")
    private boolean paymentStatus;

    @Column(name = "service_desc")
    private String serviceDesc;

//    @ManyToOne
//    @JoinColumn(name = "user_user_id")
    @Column(name = "user_user_id")
    private int userId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "contact_person")
    private String contactPerson;
}
