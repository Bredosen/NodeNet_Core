package node.net.core;

import node.net.core.commands.FlySpeedCommand;
import node.net.core.managers.CommandManager;
import node.net.core.managers.SurvivalData;
import org.bukkit.plugin.java.JavaPlugin;

public final class NodeNet extends JavaPlugin {

    //<editor-fold desc="Singleton">
    private static NodeNet instance;

    public final static NodeNet getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        NodeNet.instance = this;
    }
    //</editor-fold>

    @Override
    public void onEnable() {
        // Plugin startup logic
        CommandManager.registerCommand(new FlySpeedCommand("FlySpeed"));

        SurvivalData.getInstance().create();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
