package com.user888mk.web_application.service.impl;

import com.user888mk.web_application.dto.ClubDto;
import com.user888mk.web_application.models.Club;
import com.user888mk.web_application.models.UserEntity;
import com.user888mk.web_application.repository.ClubRepository;
import com.user888mk.web_application.repository.UserRepository;
import com.user888mk.web_application.security.SecurityUtil;
import com.user888mk.web_application.service.ClubService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.user888mk.web_application.mapper.ClubMapper.mapClubDtoToClub;
import static com.user888mk.web_application.mapper.ClubMapper.mapClubToClubDto;

@Service
@RequiredArgsConstructor
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;
    private final UserRepository userRepository;

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
        String sessionUser = SecurityUtil.getSessionUser();
        UserEntity user = userRepository.findByUsername(sessionUser);
        Club club = mapClubDtoToClub(clubDto);
        club.setCreatedBy(user);
        return clubRepository.save(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        String sessionUser = SecurityUtil.getSessionUser();
        UserEntity user = userRepository.findByUsername(sessionUser);
        Club club = mapClubDtoToClub(clubDto);
        club.setCreatedBy(user);
        clubRepository.save(club);
    }

}
