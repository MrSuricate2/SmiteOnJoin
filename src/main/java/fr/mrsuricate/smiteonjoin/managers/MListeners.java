package fr.mrsuricate.smiteonjoin.managers;

import fr.mrsuricate.smiteonjoin.Main;
import fr.mrsuricate.smiteonjoin.listerners.LOnJoin;
import org.bukkit.plugin.PluginManager;

public class MListeners {

    private final Main main = Main.getInstance();

    public void initEvents() {
        PluginManager pm = main.getServer().getPluginManager();

        pm.registerEvents(new LOnJoin(), main);
    }

}
