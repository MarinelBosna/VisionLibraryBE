package com.visionlibrary.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Review {

    @Id
    private Long idReview;
}
