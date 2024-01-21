package com.user888mk.web_application.mapper;

import com.user888mk.web_application.dto.ClubDto;
import com.user888mk.web_application.models.Club;

import java.util.stream.Collectors;

import static com.user888mk.web_application.mapper.EventMapper.mapEventToEventDto;

public class ClubMapper {
    public static Club mapClubDtoToClub(ClubDto clubDto) {
        return Club
                .builder()
                .id(clubDto.getId())
                .title(clubDto.getTitle())
                .photoUrl(clubDto.getPhotoUrl())
                .content(clubDto.getContent())
                .createdOn(clubDto.getCreatedOn())
                .updatedOn(clubDto.getUpdatedOn())
                .createdBy(clubDto.getCreatedBy())
                .build();

    }
    public static ClubDto mapClubToClubDto(Club club) {

        return ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .createdBy(club.getCreatedBy())
                .events(club.getEvents().stream()
                        .map(event -> mapEventToEventDto(event))
                        .collect(Collectors.toList()))
                .build();
    }
}
