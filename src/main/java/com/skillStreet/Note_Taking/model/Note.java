package com.skillStreet.Note_Taking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 8, max = 32, message = "Title must be between 8 and 32 characters")
    private String title;

    @NotBlank
    @Size(min = 20, max = 500, message = "Content must be between 20 and 500 characters")
    private String content;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // hide this in json but not in database table column
    private LocalDateTime creationOrInundationTime;

}
