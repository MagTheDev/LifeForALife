package dev.magthe.lifeforalife.commands.subcommands

import dev.magthe.lifeforalife.commands.SubCommand
import org.bukkit.Bukkit
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.attribute.Attribute
import org.bukkit.entity.Player

class RemoveHeartSubcommand : SubCommand() {
    override val name: String
        get() = "remove"
    override val description: String
        get() = "A subcommand that removes hearts from a player"
    override val syntax: String
        get() = "remove <num of hearts> <player name>"

    override fun perform(player: Player, args: Array<String>) {
        if (args.isEmpty()) {
            return
        }

        val target = Bukkit.getPlayerExact(args[1]) ?: run {
            player.sendMessage("§cThe player ${args[1]} cannot be found")
            return
        }

        try {
            args[0].toInt()
        } catch (e: NumberFormatException) {
            player.sendMessage("§cThe number ${args[0]} cannot be parsed. Most likely it is not a number")
            return
        }

        val targetCurrentMaxHealth = target.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.baseValue ?: return
        target.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.baseValue = targetCurrentMaxHealth - (args[0].toInt() * 2)

        target.sendMessage("§c${player.name} removed ${args[0]} heart/s from you")
        target.playSound(target.location, Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f)
        target.spawnParticle(Particle.FLAME, target.location, 15, 1.0, 1.0, 1.0)


    }

}