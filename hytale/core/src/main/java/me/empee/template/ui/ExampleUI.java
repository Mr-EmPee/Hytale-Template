package me.empee.template.ui;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.protocol.packets.interface_.CustomPageLifetime;
import com.hypixel.hytale.server.core.entity.entities.player.pages.CustomUIPage;
import com.hypixel.hytale.server.core.ui.builder.UICommandBuilder;
import com.hypixel.hytale.server.core.ui.builder.UIEventBuilder;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

public class ExampleUI extends CustomUIPage {

  public ExampleUI(PlayerRef playerRef) {
    super(playerRef, CustomPageLifetime.CanDismiss);
  }

  public void build(Ref<EntityStore> ref, UICommandBuilder uiCommandBuilder, UIEventBuilder uiEventBuilder, Store<EntityStore> store) {
    uiCommandBuilder.append("ExampleUI.ui");
  }
}
