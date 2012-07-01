package in.idig.iDigCommands;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandsHandler implements CommandExecutor{
	
	//Commented out to test main logging function
	//private Logger logger = Logger.getLogger("Minecraft");

	public CommandsHandler(iDigCommands iDigCommands){
		// TODO Auto-generated constructor stub
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		try {
			if (args.length == 0) {
				sender.sendMessage(ChatColor.LIGHT_PURPLE + "iDigPlayer by the iDig Dev team");
				sender.sendMessage(ChatColor.LIGHT_PURPLE + "Type /player help for help");
			} else {
				final String command = args[0].toLowerCase();
				if (command.equals("help")) {
					sender.sendMessage(ChatColor.DARK_AQUA + "iDigPlayer Help:");
					//TODO: Add help info
					sender.sendMessage(ChatColor.GOLD + "'");
				
				} // Command: /player commands 
				else if (command.equals("commands")) {
					sender.sendMessage(ChatColor.DARK_AQUA + "iDigPlayer Commands:");
					//TODO: Add command list here

				} // Command: /player permissions 
				else if (command.equals("permissions")) {
					sender.sendMessage(ChatColor.DARK_AQUA + "You've got the following permissions:");
				} else if (command.equals("hide")) {
					
				} else if (command.equals("page")) {
					
				
				} else if (command.equals("me")) {
					if (sender instanceof Player) {
						//TODO: Fix this permission name
						//if (logblock.hasPermission(sender, "logblock.me")) {
							
						
					} else
						sender.sendMessage(ChatColor.RED + "You have to be a player.");
				} // Unknown Command has been passed to the plugin
				else
					sender.sendMessage(ChatColor.RED + "Unknown command '" + args[0] + "'");
			}
		} catch (final IllegalArgumentException ex) {
			sender.sendMessage(ChatColor.RED + ex.getMessage());
		} catch (final Exception ex) {
			sender.sendMessage(ChatColor.RED + "Error, check log");
			logger.log(Level.WARNING, "[LogBlock] Exception in commands handler: ", ex);
		}
		return true;
	}
}
