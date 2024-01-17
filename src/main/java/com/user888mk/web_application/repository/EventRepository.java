package com.user888mk.web_application.repository;

import com.user888mk.web_application.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
