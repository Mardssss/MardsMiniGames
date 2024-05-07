package com.mards.mardsminigames.minigames;

import com.mards.mardsminigames.MardsMiniGames;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CatchCatch implements Listener {
    List<Player> hunters;
    List<Player> victims;
    BukkitTask task;
    private int durationInSeconds = 120; // 5 minutes (300 seconds)
    private boolean gameStarted;
    private MardsMiniGames plugin;

    public CatchCatch(MardsMiniGames plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
        this.gameStarted = false;
        this.hunters = new ArrayList<>();
        this.victims = new ArrayList<>();
    }
    public void startGame() {
        this.gameStarted = true;
        assignRandomHunter();

        // Start a timer for the minigame to end
        new BukkitRunnable() {
            @Override
            public void run() {
                endGame();
            }
        }.runTaskLater(plugin, durationInSeconds * 20); // Convert seconds to ticks
    }
    private void assignRandomHunter() {
        List<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());

        // Shuffle the list to randomize the order of players
        Collections.shuffle(players);

        // Check if there are any online players
        if (!players.isEmpty()) {
            Player hunter = players.get(0); // Select the first player as the hunter
            hunters.add(hunter);
            hunter.sendMessage("You are the hunter!");
        }
    }

    @EventHandler
    public void onHunterCatch(EntityDamageByEntityEvent event) {
        if (gameStarted && event.getEntity()
                instanceof Player &&
                event.getDamager() instanceof Player) {
            Player victim = (Player) event.getEntity();
            Player attacker = (Player) event.getDamager();

            // Check if the attacker is the hunter and the
            if (attacker.equals(hunters)) {
                // Check if the victim is one of the runners
                if (victims.equals(victim)) {
                    // The victim is a runner and has been caught
                    victims.remove(victim);
                    hunters.add(victim);
                }
            }
        }
    }
    private void endGame() {
        // Implement your logic to end the minigame here
        gameStarted = false;
        Player winner = victims.get(0);
        hunters.clear();
        victims.clear();
        Bukkit.broadcastMessage("The Catch minigame has ended! winner "+winner.getName());
    }

}
