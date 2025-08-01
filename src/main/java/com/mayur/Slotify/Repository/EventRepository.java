package com.mayur.Slotify.Repository;

import com.mayur.Slotify.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Event findByTitle(String title);
}