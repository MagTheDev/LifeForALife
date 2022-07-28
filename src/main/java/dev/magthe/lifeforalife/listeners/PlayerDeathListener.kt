package dev.magthe.lifeforalife.listeners


import dev.magthe.lifeforalife.utils.PlayerUtils.decreasePlayerHealth
import dev.magthe.lifeforalife.utils.PlayerUtils.increasePlayerHealth
import dev.magthe.lifeforalife.utils.WorldUtils.broadcastMessage
import dev.magthe.lifeforalife.utils.WorldUtils.broadcastMessageExceptFor
import dev.magthe.lifeforalife.utils.WorldUtils.playSoundForAllPlayers
import org.bukkit.GameMode
import org.bukkit.Sound
import org.bukkit.attribute.Attribute
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent

class PlayerDeathListener : Listener {
    @EventHandler
    fun onPlayerKilled(e: PlayerDeathEvent) {
        e.deathMessage(null)

        val victim = e.entity
        val killer = victim.killer

        if ( killer !is Player) {

            broadcastMessageExceptFor(victim, "§u§c${victim.name} has been slain")
            decreasePlayerHealth(victim, 1)
        } else {

            if (killer != victim) {
                increasePlayerHealth(killer, 1)
                decreasePlayerHealth(victim, 1)

                playSoundForAllPlayers(Sound.ENTITY_DRAGON_FIREBALL_EXPLODE)
                broadcastMessage("§6${killer.name} has slain ${victim.name} for §k${2} hearts!")
            }
        }

        if (victim.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.baseValue!! <= 0) {
            victim.sendMessage("§4§kANGER§r§4 A weakling like you should not walk this earth ")
            victim.gameMode = GameMode.SPECTATOR
        } else {
            victim.sendMessage("For your §uweakness you loose a heart")
            killer?.sendMessage("§gFor your achievements, we grant you another heart")
        }

    }
}