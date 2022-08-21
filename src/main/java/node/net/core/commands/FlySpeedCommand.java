package node.net.core.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public final class FlySpeedCommand extends BukkitCommand {
    public FlySpeedCommand(final String name) {
        super(name);
        setUsage("/<command> [speed] {player}");
        setDescription("Set player fly speed");
    }

    @Override
    public boolean execute(final CommandSender sender, final String commandLabel, final String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only player");
            return true;
        }

        if (args.length == 1) {
            try {

                final int speed = Integer.parseInt(args[0]);
                if (speed < -10 || speed > 10) {
                    player.sendMessage("Please use integer between [-10 - 10]");
                    return true;
                }
                player.setFlySpeed((float) (speed / 10f));
                player.sendMessage("Fly speed = " + speed);
            } catch (Exception exception) {
                player.sendMessage("Please use valid integer");
            }
        }
        return true;
    }
}
