package com.github.tmeserve;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.github.tmeserve.data.CircularLinkedList;
import com.github.tmeserve.util.LambdaRunnable;
import com.github.tmeserve.util.TimeManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Game implements Listener{

    private DeathSwap plugin;
    private List<Player> swappable;
    private TimeManager timeManager;
    private List<LambdaRunnable> runnables;

    public Game(DeathSwap plugin)
    {
        this.plugin = plugin;
        this.swappable = new ArrayList<>(Bukkit.getOnlinePlayers());
    }
    
    public boolean performSwap()
    {
        int amount = this.swappable.size();

        if (amount == 1)
            return false;

        List<Player> temp = new ArrayList<>(this.swappable);
        Collections.shuffle(temp);

        for (int i = 0; i < amount; i++)
        {
            Player p1 = temp.get(i);
            Player p2;
            if (amount - 1 == i)
                p2 = temp.get(0);
            else
                p2 = temp.get(i + 1);

            Location locToTeleport = p2.getLocation();

            p1.teleport(locToTeleport);
            p1.sendMessage(ChatColor.AQUA + "You are swapping with " + p2.getName());
        }

        // resetTimeManager();

        return true;
    }

    private void resetRunnable()
    {
        
    }

    private void addRunnable(LambdaRunnable l)
    {
        this.runnables.add(l);
    }

    private void removeRunnable(int i)
    {
        this.runnables.remove(i);
    }

    private void removeRunnable(LambdaRunnable l)
    {
        this.runnables.remove(l);
    }

    private void resetTimeManager()
    {
        timeManager = new TimeManager(this.plugin);

        timeManager.runTaskTimer(this.plugin, 0, 20L);
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e)
    {
        Player p = e.getEntity();
        if (this.swappable.contains(p))
        {
            this.swappable.remove(p);
            if (this.swappable.size() == 1)
            {
                String playerName = this.swappable.get(0).getName();
                Bukkit.broadcastMessage(ChatColor.GREEN + playerName + " has won the death swap");
                this.swappable.remove(0);
            }
        }
        
    }

}
