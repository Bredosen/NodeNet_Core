package node.net.core.managers;

import node.net.core.NodeNet;
import org.bukkit.event.Listener;

public final class EventManager {

    public final static void registerEvent(final Listener listener) {
        NodeNet.getInstance().getServer().getPluginManager().registerEvents(listener, NodeNet.getInstance());
    }
}
