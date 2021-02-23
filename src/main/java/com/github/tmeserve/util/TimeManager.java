package com.github.tmeserve.util;

import com.github.tmeserve.DeathSwap;
import com.github.tmeserve.Game;

import org.bukkit.scheduler.BukkitRunnable;

public class TimeManager extends BukkitRunnable {
    
    private DeathSwap plugin;
    private Game game;
    private int[] notices;
    private int time;

    // Use variables to change how long it would run for//last

    public TimeManager(DeathSwap plugin)//, Game game)
    {
        this.plugin = plugin;
        // this.game = game;
        this.time = 3;
    }
    

    @Override
    public void run()
    {
        // Do stuff
        // I do not think I will need to use this for multiple use case
        // So it would be used for 1 thing in itself and that thing only
        // For right now the use case is the only use case I would need timer for.

        if (time == 0)
            return;

        this.plugin.getLogger().info("time = : " + this.time);
        
        
        this.time--;
    }

}
