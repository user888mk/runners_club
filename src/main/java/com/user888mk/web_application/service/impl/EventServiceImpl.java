package com.user888mk.web_application.service.impl;

import com.user888mk.web_application.dto.EventDto;
import com.user888mk.web_application.models.Club;
import com.user888mk.web_application.models.Event;
import com.user888mk.web_application.repository.ClubRepository;
import com.user888mk.web_application.repository.EventRepository;
import com.user888mk.web_application.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.user888mk.web_application.mapper.EventMapper.mapEventDtoToEvent;
import static com.user888mk.web_application.mapper.EventMapper.mapEventToEventDto;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final ClubRepository clubRepository;

    @Override
    public void createEvent(long clubId, EventDto eventDto) {
        Club club = clubRepository.findById(clubId).get();
        Event event = mapEventDtoToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);
    }

    @Override
    public List<EventDto> findAllEvents() {
        List<Event> event = eventRepository.findAll();
        return event.stream()
                .map(event1 -> mapEventToEventDto(event1))
                .collect(Collectors.toList());

    }


}
