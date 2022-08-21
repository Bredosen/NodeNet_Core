package node.net.core.utilities;

import node.net.core.NodeNet;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;

public class DataContainer {

    //<editor-fold desc="Variables">
    private final String path;
    private final String fileName;

    private File file;
    private FileConfiguration config;
    //</editor-fold>

    //<editor-fold desc="Constructors">
    public DataContainer(final String path, final String fileName) {
        this.path = path;
        this.fileName = fileName;
    }

    public DataContainer(final String fileName) {
        this("", fileName);
    }
    //</editor-fold>

    public final boolean exists() {
        return getFile().exists() || getFile().isFile();
    }

    public final boolean create() {
        File directory = new File(getFile().getParent());
        if (!directory.mkdirs()) return false;
        try {
            return getFile().createNewFile();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    //<editor-fold desc="Getters">
    public final String getPath() {
        return path;
    }

    public final String getFileName() {
        return fileName;
    }


    public final File getFile() {
        if (this.file == null) this.file = new File(NodeNet.getInstance().getDataFolder() + getPath(), getFileName() + ".yml");
        return this.file;
    }


    public final FileConfiguration getConfig() {
        return this.config;
    }
    //</editor-fold>
}
