package com.minis.core;

import java.util.EventObject;

public class ApplicationEvent extends EventObject {
    private static  final  long serialVersionID = 1L;
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
