package fr.mrsuricate.smiteonjoin;

import fr.mrsuricate.smiteonjoin.managers.MFiles;
import fr.mrsuricate.smiteonjoin.managers.MListeners;
import fr.mrsuricate.smiteonjoin.managers.MLoad;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Level;

public final class Main extends JavaPlugin {

    //Instance du Plugin
    private static Main instance;

    public File fileConfig = new File(getDataFolder().getPath() + "/config.yml");
    public File fileMessage = new File(getDataFolder().getPath() + "/message.yml");

    public boolean placeholder = false;

    public static Main getInstance() {
        return instance;
    }

    //Manager
    private MLoad loadManager;
    private MFiles filesManager;
    private MListeners eventsManager;



    @Override
    public void onEnable() {
        instance = this;

        loadManager = new MLoad();
        eventsManager = new MListeners();
        filesManager = new MFiles();

        loadManager.pluginLoad();
    }

    @Override
    public void onDisable() {
        loadManager.pluginUnLoad();
    }

    public MListeners getEventsManager() {
        return eventsManager;
    }

    public MFiles getFilesManager() {
        return filesManager;
    }

    public void logConsole(Level level, String msg) {
        getLogger().log(level, msg);
    }
}
