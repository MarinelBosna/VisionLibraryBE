package com.visionlibrary.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
public class Review {

    @Id
    private Long id;

    private String description;

    private String reviewCode;

    @ManyToOne
    @JsonBackReference
    private Book book;
    

}
