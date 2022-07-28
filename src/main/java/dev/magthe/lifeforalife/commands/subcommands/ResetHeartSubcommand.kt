package dev.magthe.lifeforalife.commands.subcommands

import dev.magthe.lifeforalife.commands.SubCommand
import dev.magthe.lifeforalife.utils.PlayerUtils.resetPlayerHealth
import org.bukkit.Bukkit
import org.bukkit.entity.Player

class ResetHeartSubcommand : SubCommand() {
    override val name: String
        get() = "reset"
    override val description: String
        get() = "A subcommand that reset's player's hearts to the baseline"
    override val syntax: String
        get() = "reset <player name>"

    override fun perform(player: Player, args: Array<String>) {

        if (args.isEmpty()) {
            resetPlayerHealth(player)
            return
        }

        val target = Bukkit.getPlayerExact(args[0]) ?: run {
            player.sendMessage("§cThe player ${args[0]} cannot be found")
            return
        }

        resetPlayerHealth(target)

    }


}