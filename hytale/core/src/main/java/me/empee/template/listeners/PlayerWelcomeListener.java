package me.empee.template.listeners;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import jakarta.inject.Singleton;
import me.empee.utils.models.markers.IListener;

@Singleton
public class PlayerWelcomeListener implements IListener<PlayerReadyEvent> {

  public Class<PlayerReadyEvent> getEvent() {
    return PlayerReadyEvent.class;
  }

  public void handle(PlayerReadyEvent event) {
    Player player = event.getPlayer();
    player.sendMessage(Message.raw("Welcome " + player.getDisplayName()));
  }

}