package com.example.springbootcache.events;

import lombok.SneakyThrows;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author "Tojaliyev Asliddin"
 * @since 20/08/22 11:49 (Saturday)
 * Spring-boot-cache/IntelliJ IDEA
 */
@Component
public class BookEventHandler {
    @EventListener(condition = "#bookCreateEvent.success")
    @SneakyThrows
    public void createBookListener(GenericSpringEvent<BookCreateEvent> bookCreateEvent){
        TimeUnit.SECONDS.sleep(2);
        System.out.println("CREATING.............. " + bookCreateEvent.getWhat());
    }

    @EventListener(condition = "!#bookCreateEvent.success")
    @SneakyThrows
    public void createBookListener2(GenericSpringEvent<BookCreateEvent> bookCreateEvent){
        TimeUnit.SECONDS.sleep(2);
        System.out.println("CREATING.............. " + bookCreateEvent.getWhat());
    }
}
