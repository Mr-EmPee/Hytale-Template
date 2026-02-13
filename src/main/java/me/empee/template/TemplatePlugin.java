package me.empee.template;

import com.hypixel.hytale.event.IBaseEvent;
import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.command.system.AbstractCommand;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import io.avaje.inject.BeanScope;
import me.empee.template.listeners.IListener;

import java.lang.reflect.Type;
import java.util.List;

public class TemplatePlugin extends JavaPlugin {

  public static final HytaleLogger log = HytaleLogger.forEnclosingClass();

  private BeanScope beanScope;

  public TemplatePlugin(JavaPluginInit init) {
    super(init);
  }

  @Override
  protected void setup() {
    beanScope = BeanScope.builder()
                         .classLoader(getClass().getClassLoader())
                         .build();

    List<AbstractCommand> commands = beanScope.list(AbstractCommand.class);

    for (AbstractCommand command : commands) {
      log.atInfo().log("Registering command %s", command.getName());
      getCommandRegistry().registerCommand(command);
    }

    List<IListener<IBaseEvent<?>>> eventListeners = beanScope.list((Type) IListener.class);

    for (IListener<IBaseEvent<?>> eventListener : eventListeners) {
      log.atInfo().log("Registering event listener %s", eventListener.getClass().getName());
      getEventRegistry().registerGlobal(eventListener.getEvent(), eventListener::handle);
    }
  }

  @Override
  protected void shutdown() {
    beanScope.close();
  }

}