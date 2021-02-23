package com.github.tmeserve;

import java.util.ArrayList;

import com.github.tmeserve.commands.Start;
import com.github.tmeserve.commands.Swap;
import com.github.tmeserve.util.LambdaRunnable;
import com.github.tmeserve.util.TimeManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class DeathSwap extends JavaPlugin
{

    private static DeathSwap plugin;
    private Game game;
    // private TimeManager timeManager;

    @Override
    public void onEnable()
    {
        plugin = this;
         
        getLogger().info(ChatColor.GREEN + "Death Swap has been enabled!");

        this.getCommand("start").setExecutor(new Start(this.plugin));
        this.getCommand("swap").setExecutor(new Swap(this.plugin));

        // timeManager = new TimeManager(this.plugin);

        // timeManager.runTaskTimer(this.plugin, 0L, 20L);


        // new LambdaRunnable(() -> getLogger().info("")).runTaskLater(plugin, delay)
    }

    @Override
    public void onDisable()
    {
        getLogger().info(ChatColor.GREEN + "See you again, SpigotMC!");
    }

    public static DeathSwap getPlugin()
    {
        return plugin;
    }

    public void setGame(Game game)
    {
        this.game = game;
    }

    public Game getGame()
    {
        return this.game;
    }
}