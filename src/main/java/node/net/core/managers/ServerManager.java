package node.net.core.managers;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.bukkit.entity.Player;

import java.util.Map;

public final class ServerManager {

    public final static Map<String, ServerInfo> getServers() {
        return ProxyServer.getInstance().getServers();
    }

    public final static ServerInfo getServer(final String serverName) {
        return getServers().get(serverName);
    }

    public final static boolean sendPlayer(final Player player, final String serverName) {
        return sendPlayer(player, getServer(serverName));
    }

    public final static boolean sendPlayer(final Player player, final ServerInfo serverInfo) {
        if (!(player instanceof ProxiedPlayer proxiedPlayer)) return false;
        if (serverInfo == null) return false;
        proxiedPlayer.connect(serverInfo);
        return true;
    }
}
