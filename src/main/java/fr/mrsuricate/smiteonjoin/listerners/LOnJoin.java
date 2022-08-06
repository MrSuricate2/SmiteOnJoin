package fr.mrsuricate.smiteonjoin.listerners;

import fr.mrsuricate.smiteonjoin.Main;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

public class LOnJoin implements Listener {

    private final Main main = Main.getInstance();

    @EventHandler
    public void onLogin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(main.fileConfig);
        YamlConfiguration yamlConfiguration1 = YamlConfiguration.loadConfiguration(main.fileMessage);
        if (player.hasPermission("smiteonjoin.enable") || player.isOp()){
            player.getWorld().strikeLightningEffect(player.getLocation());
            if (yamlConfiguration.getBoolean("SmiteOnJoin.message")){
                String message = Objects.requireNonNull(yamlConfiguration1.getString("SmiteOnJoin.message")).replace("&","§");
                if (main.placeholder){
                    message = PlaceholderAPI.setPlaceholders(player,message);
                }
                Bukkit.broadcastMessage(message);
            }
        }
    }

}
