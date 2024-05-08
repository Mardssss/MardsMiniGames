package com.mards.mardsminigames.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyTabCompleter implements TabCompleter {
    private static final String[] COMMANDS = {"catch-catch"};

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        //create new array
        final List<String> completions = new ArrayList<>();
        if (args.length == 1) {
            // Completion for the first argument (sub-command)
            StringUtil.copyPartialMatches(args[0], Arrays.asList(COMMANDS), completions);
        }
        return completions;
    }
}
