package com.minis.core;

import com.apple.eawt.ApplicationEvent;

public interface ApplicationEventPublisher {
    void publicEvent(ApplicationEvent event);
}
