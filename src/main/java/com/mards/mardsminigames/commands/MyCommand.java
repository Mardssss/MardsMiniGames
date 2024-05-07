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
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {
        if (args.length == 1){
            return false;
        }
        if (args.length == 2){
            // minigame someminigame
            if (args[0].equalsIgnoreCase("catch-catch")){
                catchCatch = new CatchCatch(plugin,120);
                catchCatch.startGame();
            }
        }
        return false;
    }
}
