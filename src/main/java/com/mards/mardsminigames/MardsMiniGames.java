package com.mards.mardsminigames;

import com.mards.mardsminigames.minigames.CatchCatch;
import org.bukkit.plugin.java.JavaPlugin;

public final class MardsMiniGames extends JavaPlugin {
    public CatchCatch catchCatch;

    @Override
    public void onEnable() {
        // Plugin startup logic
        catchCatch = new CatchCatch(this);
        catchCatch.startGame();


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
