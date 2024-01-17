package com.user888mk.web_application.controller;

import com.user888mk.web_application.dto.EventDto;
import com.user888mk.web_application.models.Event;
import com.user888mk.web_application.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/events")
    public String eventList(Model model){
        List<EventDto> events = eventService.findAllEvents();
        model.addAttribute("events",events);
        return "events-list";
    }

    @GetMapping("/events/{clubId}/new")
    public String createEventForm(@PathVariable("clubId")
                                  long clubId, Model model) {
        Event event = new Event();
        model.addAttribute("clubId", clubId);
        model.addAttribute("event", event);
        return "event-create";
    }

    @PostMapping("/events/{clubId}")
    public String createEvent(@PathVariable("clubId") long clubId, @ModelAttribute("event") EventDto eventDto,
                              Model model) {

        eventService.createEvent(clubId, eventDto);
        return "redirect:/clubs/" + clubId;
    }
}
