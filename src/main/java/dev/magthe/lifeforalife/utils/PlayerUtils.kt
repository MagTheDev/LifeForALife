package dev.magthe.lifeforalife.utils

import org.bukkit.attribute.Attribute
import org.bukkit.entity.Player
import kotlin.math.abs

object PlayerUtils {

    fun increasePlayerHealth(player: Player, amount: Int) {
        val base = player.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.baseValue ?: return
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.baseValue = base + amount * 2
    }

    fun decreasePlayerHealth(player: Player, amount: Int) {
        val base = player.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.baseValue ?: return
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.baseValue = base - amount * 2
    }

    fun resetPlayerHealth(player: Player) {

        val base = player.getAttribute(Attribute.GENERIC_MAX_HEALTH)!!.baseValue
        val delta = base - 20

        if (delta > 0) {
            decreasePlayerHealth(player, abs(delta / 2 ).toInt())
        } else if (delta < 0) {
            increasePlayerHealth(player, abs(delta / 2).toInt())
        }

    }

}