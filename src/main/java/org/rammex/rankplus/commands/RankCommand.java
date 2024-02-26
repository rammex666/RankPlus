package org.rammex.rankplus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.rammex.rankplus.RankPlus;

public class RankCommand implements CommandExecutor {
    RankPlus plugin;
    public RankCommand(RankPlus plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String arg, @NotNull String[] args) {
        return false;
    }
}
