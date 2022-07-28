package dev.magthe.lifeforalife


import dev.magthe.lifeforalife.commands.HealthCommand
import dev.magthe.lifeforalife.listeners.PlayerDeathListener
import org.bukkit.plugin.java.JavaPlugin

class LifeForALife : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
        logger.info("Loading Plugin...")
        getCommand("health")?.setExecutor(HealthCommand())
        server.pluginManager.registerEvents(PlayerDeathListener(), this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}