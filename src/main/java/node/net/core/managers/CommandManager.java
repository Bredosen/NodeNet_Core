package node.net.core.managers;

import node.net.core.NodeNet;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.defaults.BukkitCommand;

public final class CommandManager {

    public final static CommandMap commandMap;

    static {
        commandMap = NodeNet.getInstance().getServer().getCommandMap();
    }


    public final static boolean registerCommand(final BukkitCommand command) {
        return getCommandMap().register(command.getName(), command);
    }

    public final static Command getCommand(final String commandName) {
        return getCommandMap().getCommand(commandName);
    }

    public final static void disableCommand(final Command command) {
        command.unregister(getCommandMap());
    }

    public final static boolean disableCommand(final String commandName) {
        Command command = getCommand(commandName);
        if (command == null) return false;
        return command.unregister(getCommandMap());
    }


    public final static CommandMap getCommandMap() {
        return commandMap;
    }
}
