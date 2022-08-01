package fr.mrsuricate.smiteonjoin;

import fr.mrsuricate.smiteonjoin.managers.MFiles;
import fr.mrsuricate.smiteonjoin.managers.MListeners;
import fr.mrsuricate.smiteonjoin.managers.MLoad;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Level;

public final class Main extends JavaPlugin {

    //Instance du Plugin
    private static Main instance;

    public File fileConfig = new File(getDataFolder().getPath() + "/config.yml");
    public FileConfiguration fileConfigConfig;
    public File fileMessage = new File(getDataFolder().getPath() + "/message.yml");
    public FileConfiguration fileConfigMessage;

    public static Main getInstance() {
        return instance;
    }

    //Manager
    private MLoad loadManager;
    private MFiles managerFiles;
    private MListeners eventsManager;



    @Override
    public void onEnable() {
        instance = this;

        loadManager = new MLoad();
        eventsManager = new MListeners();
        managerFiles = new MFiles();

        loadManager.pluginLoad();
    }

    @Override
    public void onDisable() {
        loadManager.pluginUnLoad();
    }

    public MLoad getLoadManager() {
        return loadManager;
    }

    public MListeners getEventsManager() {
        return eventsManager;
    }

    public MFiles getManagerFiles() {
        return managerFiles;
    }

    public void logConsole(Level level, String msg) {
        getLogger().log(level, msg);
    }
}
