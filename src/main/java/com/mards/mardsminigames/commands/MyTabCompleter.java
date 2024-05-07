package com.mards.mardsminigames.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.*;

public class MyTabCompleter implements TabCompleter {

    //create a static array of values
    private static final String[] COMMANDS = { "mardsminigame" };
    private static final String[] COMMANDS_2 = {"catch-catch"};
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        //create new array
        final List<String> completions = new ArrayList<>();
        if (args.length == 1) {
            // Completion for the first argument (sub-command)
            StringUtil.copyPartialMatches(args[0], Arrays.asList(COMMANDS), completions);
        } else if (args.length == 2) {
            // Completion for the second argument
            StringUtil.copyPartialMatches(args[1], Arrays.asList(COMMANDS_2), completions);
        }
        return completions;
    }
}
