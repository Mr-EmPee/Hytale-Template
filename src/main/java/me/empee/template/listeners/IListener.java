package me.empee.template.listeners;

import com.hypixel.hytale.event.IBaseEvent;

public interface IListener<EventType extends IBaseEvent<?>> {

  Class<EventType> getEvent();

  void handle(EventType event);

}
