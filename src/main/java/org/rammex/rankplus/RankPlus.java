package org.rammex.rankplus;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.rammex.rankplus.commands.RankCommand;
import org.rammex.rankplus.utils.Metrics;

import java.io.File;
import java.io.IOException;

public final class RankPlus extends JavaPlugin {
    File dir = getDataFolder();
    File rk = new File(dir, "ranks.yml");
    FileConfiguration rkconf;

    File data = new File(dir, "data.yml");
    FileConfiguration dataconf;

    @Override
    public void onEnable() {
        // Load Plugin Files
        int pluginId = 	21132;
        Metrics metrics = new Metrics(this, pluginId);
        loadMessages();
        loadFiles();
        saveDefaultConfig();
        getConfig();


        // Load Plugin Events
        this.getCommand("ranksplus").setExecutor(new RankCommand(this));

        // Load Plugin Commands
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void loadMessages() {
        String version = this.getDescription().getVersion();
        // ANSI green color code
        String ansiGreen = "\u001B[32m";
        // ANSI reset code
        String ansiReset = "\u001B[0m";

        this.getLogger().info(ansiGreen + "[RankPlus] v" + version + " has been enabled!" + ansiReset);
    }

    void loadFiles(){
        //rk
        rk = new File(getDataFolder(), "ranks.yml");
        if (!rk.exists()) {
            rk.getParentFile().mkdirs();
            saveResource("ranks.yml", false);
            String ansiYellow = "\u001B[33m";
            String ansiReset = "\u001B[0m";
            this.getLogger().info(ansiYellow + "[RankPlus] ranks.yml loaded successfully !" + ansiReset);
        }

        rkconf = new YamlConfiguration();
        try {
            rkconf.load(rk);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        //data
        data = new File(getDataFolder()+"/data", "data.yml");
        if (!data.exists()) {
            data.getParentFile().mkdirs();
            saveResource("data/data.yml", false);
            String ansiYellow = "\u001B[33m";
            String ansiReset = "\u001B[0m";
            this.getLogger().info(ansiYellow + "[RankPlus] data.yml loaded successfully !" + ansiReset);
        }

        dataconf = new YamlConfiguration();
        try {
            dataconf.load(data);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getrk(){
        return this.rkconf;
    }

    public FileConfiguration getdata(){
        return this.dataconf;
    }
}
