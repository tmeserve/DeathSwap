package com.github.tmeserve.commands;

import com.github.tmeserve.DeathSwap;
import com.github.tmeserve.Game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Start implements CommandExecutor {

    private DeathSwap plugin;

    public Start(DeathSwap plugin)
    {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender instanceof Player && cmd.getName().equalsIgnoreCase("start"))
        {
            if (!sender.hasPermission("deathswap.host.start"))
            {
                sender.sendMessage(ChatColor.RED + "You do not have permission to run this command");
                return true;
            }
            Game g = new Game(this.plugin);
            this.plugin.setGame(g);
            // g.resetTimeManager();
            
            this.plugin.getServer().getPluginManager().registerEvents(this.plugin.getGame(), this.plugin);
            Bukkit.broadcastMessage(ChatColor.RED + "Death Swap Starting...");
        }


        return true;
    }

}
