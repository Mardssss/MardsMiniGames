package com.mards.mardsminigames.commands;

import com.mards.mardsminigames.MardsMiniGames;
import com.mards.mardsminigames.minigames.CatchCatch;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MyCommand implements CommandExecutor {
    private final MardsMiniGames plugin;
    private CatchCatch catchCatch;

    public MyCommand(MardsMiniGames plugin) {
        this.plugin = plugin;
        this.catchCatch = new CatchCatch(plugin,120);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) {
            sender.sendMessage("Usage: /mardsminigame <minigame>");
            return true; // Correct usage message sent, returning true
        }

        if (args[0].equalsIgnoreCase("catch-catch")) {
            if (!sender.hasPermission("mardsminigame.play.catch-catch")) {
                sender.sendMessage("You don't have permission to play Catch Catch!");
                return true; // Sender doesn't have permission, returning true
            }
            catchCatch.startGame();
            return true; // Game started, returning true
        }

        // If the provided minigame is not recognized, send usage message
        sender.sendMessage("Unknown minigame. Available options: catch-catch");
        return true;
    }
}
