package com.example.springbootcache.events;

import lombok.Getter;
import lombok.Setter;

/**
 * @author "Tojaliyev Asliddin"
 * @since 20/08/22 14:31 (Saturday)
 * Spring-boot-cache/IntelliJ IDEA
 */
@Getter
@Setter
public class GenericSpringEvent<T> {
    private T what;
    protected boolean success;

    public GenericSpringEvent(T what, boolean success) {
        this.what = what;
        this.success = success;
    }
}
