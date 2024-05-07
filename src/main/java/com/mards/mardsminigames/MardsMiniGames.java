package com.mards.mardsminigames;

import com.mards.mardsminigames.commands.MyCommand;
import com.mards.mardsminigames.commands.MyTabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class MardsMiniGames extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Objects.requireNonNull(this.getCommand("mardsminigame")).setExecutor(new MyCommand(this));
        Objects.requireNonNull(this.getCommand("mardsminigame")).setTabCompleter(new MyTabCompleter());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
