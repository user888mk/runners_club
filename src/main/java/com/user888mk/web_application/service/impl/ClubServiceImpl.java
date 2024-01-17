package com.user888mk.web_application.service.impl;

import com.user888mk.web_application.dto.ClubDto;
import com.user888mk.web_application.models.Club;
import com.user888mk.web_application.repository.ClubRepository;
import com.user888mk.web_application.service.ClubService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.user888mk.web_application.mapper.ClubMapper.mapClubDtoToClub;
import static com.user888mk.web_application.mapper.ClubMapper.mapClubToClubDto;

@Service
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> allClubs = clubRepository.findAll();
        return allClubs.stream().map(club -> mapClubToClubDto(club)).collect(Collectors.toList());
    }

    @Override
    public ClubDto findClubById(long clubId) {
        Club club = clubRepository.findById(clubId).orElseThrow(() -> new EntityNotFoundException("Not found club with id"));
        return mapClubToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club = mapClubDtoToClub(clubDto);
        clubRepository.save(club);
    }

    @Override
    public void delete(long clubId) {
        clubRepository.deleteById(clubId);
    }

    @Override
    public List<ClubDto> searchClubs(String query) {
        List<Club> clubs = clubRepository.searchClubs(query);
        return clubs.stream().map(club -> mapClubToClubDto(club)).collect(Collectors.toList());
    }

    @Override
    public Club saveClub(ClubDto clubDto) {
        Club club = mapClubDtoToClub(clubDto);
        return clubRepository.save(club);
    }


}
