package com.user888mk.web_application.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@Data
@Builder
public class EventDto {

    private Long id;
    private String name;
    @DateTimeFormat(pattern = "yyy-MM-dd'T'HH:mm")
    private LocalDateTime startTime;
    @DateTimeFormat(pattern = "yyy-MM-dd'T'HH:mm")
    private LocalDateTime endTime;
    private String type;
    private String photoUrl;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

}
