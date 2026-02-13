package me.empee.template.commands;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import jakarta.inject.Singleton;
import me.empee.template.ui.ExampleUI;

@Singleton
public class ExampleCommand extends AbstractPlayerCommand {

  public ExampleCommand() {
    super("example", "this is an example command");
  }

  protected void execute(
      CommandContext commandContext, Store<EntityStore> store, Ref<EntityStore> ref, PlayerRef playerRef, World world
  ) {
    Player player = store.getComponent(ref, Player.getComponentType());
    player.getPageManager().openCustomPage(ref, store, new ExampleUI(playerRef));
  }
}
