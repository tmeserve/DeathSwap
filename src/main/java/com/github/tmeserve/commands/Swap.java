package com.github.tmeserve.commands;

import com.github.tmeserve.DeathSwap;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Swap implements CommandExecutor
{
    private DeathSwap plugin;

    public Swap(DeathSwap plugin)
    {
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender instanceof Player && cmd.getName().equalsIgnoreCase("swap"))
        {
            if (!sender.hasPermission("deathswap.testing.swap"))
            {
                sender.sendMessage(ChatColor.RED + "You do not have permission to run this command");
                return true;
            }
            boolean result = plugin.getGame().performSwap();

            if (!result)
                sender.sendMessage(ChatColor.RED + "The game is currently not active");
        }


        return true;
    }

}
