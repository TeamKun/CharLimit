package net.kunmc.lab.charlimit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class CharLimit extends JavaPlugin implements Listener {
    int num = 4;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        if (message.length() > num)
            event.setMessage(message.substring(0, num));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        num = Integer.parseInt(args[0]);
        sender.sendMessage("set " + num);
        return true;
    }
}
