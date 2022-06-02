package com.visionlibrary.model;

import com.visionlibrary.model.enums.Category;
import com.visionlibrary.model.enums.Language;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String author;

    private String publishingHouse;

    private String collection;

    private boolean available;

    private Language language;

    private int numberOfPages;

    private int yearOfLaunch;

    private Category category;

    @Column
    private String bookCode;
}
