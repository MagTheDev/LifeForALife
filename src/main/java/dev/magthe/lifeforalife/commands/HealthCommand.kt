package dev.magthe.lifeforalife.commands

import dev.magthe.lifeforalife.commands.subcommands.AddHeartSubcommand
import dev.magthe.lifeforalife.commands.subcommands.RemoveHeartSubcommand
import dev.magthe.lifeforalife.commands.subcommands.ResetHeartSubcommand
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class HealthCommand : CommandExecutor {

    private var subcommands: ArrayList<SubCommand> = ArrayList()

    init {
        subcommands.add(AddHeartSubcommand())
        subcommands.add(RemoveHeartSubcommand())
        subcommands.add(ResetHeartSubcommand())
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {

        var args = args?.toMutableList()

        if (sender !is Player) {
            sender.sendMessage("The console cannot run this command")
            return false
        }

        if (args?.isNotEmpty() == true) {
            for (subcommand in subcommands) {
                if ( subcommand.name == args[0] ) {
                    args.removeAt(0)
                    subcommand.perform(sender, args.toTypedArray())
                }
            }
        }

        return true
    }


}