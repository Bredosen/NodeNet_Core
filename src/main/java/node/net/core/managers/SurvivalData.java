package node.net.core.managers;

import node.net.core.utilities.DataContainer;

public final class SurvivalData extends DataContainer {

    //<editor-fold desc="Constructor">
    private final static SurvivalData instance;

    static {
        instance = new SurvivalData("\\Survival", "SurvivalData");
    }

    public SurvivalData(String path, String fileName) {
        super(path, fileName);
    }

    public final static SurvivalData getInstance() {
        return instance;
    }
    //</editor-fold>
}
