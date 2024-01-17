package com.user888mk.web_application.service;

import com.user888mk.web_application.dto.EventDto;

import java.util.List;

public interface EventService {

    void createEvent(long clubId,EventDto eventDto);

    List<EventDto> findAllEvents();

    EventDto findEventsById(long eventId);

    void updateEvent(EventDto eventDto);
}
