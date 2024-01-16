package com.user888mk.web_application.service;

import com.user888mk.web_application.dto.ClubDto;
import com.user888mk.web_application.models.Club;

import java.util.List;


public interface ClubService {

    List<ClubDto> findAllClubs();

    Club saveClub(ClubDto clubDto);

    ClubDto findClubById(long clubId);

    void updateClub(ClubDto club);

    void delete(long clubId);

    List<ClubDto> searchClubs(String query);
}
