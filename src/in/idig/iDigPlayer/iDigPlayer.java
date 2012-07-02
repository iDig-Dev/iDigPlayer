package in.idig.iDigPlayer;

import in.idig.iDigPlayer.config.Config;

import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;


public class iDigPlayer extends JavaPlugin{
	iDigPlayer iDig = this;
	
	private Logger log = Logger.getLogger("Minecraft");
	private CommandsHandler commandsHandler;

	public CommandsHandler getCommandsHandler() {
		return commandsHandler;
	}
	
	public void onEnable(){
		commandsHandler = new CommandsHandler(this);
		getCommand("player").setExecutor(commandsHandler);
		String PluginVersion = version();
		//TODO: Clean up loading message
		this.logMessage("***************************");
		this.logMessage("*   iDig Player Enabled    *");
		this.logMessage("*   iDigPlayer" + PluginVersion +"    *");
		this.logMessage("***************************");
		iDig.logMessage("Testing Logger");
		//TODO: Load Configuration file
		//TODO: Launch mysql connection
	}

	public void onDisable(){
		//TODO: Close all transactions
		this.logMessage("***************************");
		this.logMessage("*   iDigPlayer Disabled :-)   *");
		this.logMessage("***************************");
	}

	public void logMessage(String msg){
		PluginDescriptionFile pdFile = this.getDescription();
		this.log.info(pdFile.getName() + " " + pdFile.getVersion() + ": " + msg);
	}

	public String version(){
		PluginDescriptionFile pdFile = this.getDescription();
		return pdFile.getVersion();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (true)
			sender.sendMessage(ChatColor.RED + "iDig CommandSender Linked in");
		return true;
	}

}
