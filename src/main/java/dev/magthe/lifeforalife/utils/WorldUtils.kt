package dev.magthe.lifeforalife.utils

import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.entity.Player

object WorldUtils {

    fun broadcastMessage(message: String) {
        for (player in Bukkit.getOnlinePlayers()) {
            player.sendMessage(message)
        }
    }

    fun broadcastMessageExceptFor(target: Player, message: String) {
        for (player in Bukkit.getOnlinePlayers()) {
            if (target == player) {
                continue
            }
            player.sendMessage(message)
        }
    }

    fun playSoundForAllPlayers(sound: Sound, volume: Float = 1.0f, pitch: Float = 1.0f) {
        for (player in Bukkit.getOnlinePlayers()) {
            val loc = player.location
            player.playSound(loc, sound, volume, pitch)
        }
    }

}