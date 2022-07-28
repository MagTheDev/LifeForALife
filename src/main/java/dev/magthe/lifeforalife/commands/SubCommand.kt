package dev.magthe.lifeforalife.commands

import org.bukkit.entity.Player

abstract class SubCommand {

    abstract val name: String

    abstract val description: String

    abstract val syntax: String

    /**
     * @param player --> the player that invoked the command
     * @param args --> the arguments passed to the command line, but the subcommand is removed
     */
    abstract fun perform(player: Player, args: Array<String>)
}