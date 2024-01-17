package com.user888mk.web_application.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ClubDto {

    private Long id;
    @NotEmpty(message = "Club title should be not empty")
    private String title;
    @NotEmpty(message = "Photo link should be not empty")
    private String photoUrl;
    @NotEmpty(message = "Content should be not empty")
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private List<EventDto> events;
}