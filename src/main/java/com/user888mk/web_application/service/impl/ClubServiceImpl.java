package com.user888mk.web_application.service.impl;

import com.user888mk.web_application.dto.ClubDto;
import com.user888mk.web_application.models.Club;
import com.user888mk.web_application.repository.ClubRepository;
import com.user888mk.web_application.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {

    private ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> allClubs = clubRepository.findAll();
        return allClubs.stream().map(club -> mapToDto(club)).collect(Collectors.toList());
    }

    private ClubDto mapToDto(Club club) {

        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())

                .build();

        return clubDto;
    }
}
