/* Utilizing code from ThisIsAreku/InventorySQL/ */
/* Will attempt to make it my own later */

package in.idig.iDigPlayer.config;

import in.idig.iDigPlayer.iDigPlayer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {

	public static String dbDatabase = null;
	public static String dbHost = null;
	public static String dbPass = null;
	public static String dbTable = null;
	public static String dbUser = null;

	public static boolean check_plugin_updates = true;
	public static boolean lightweight_mode = false;
	public static boolean checkChest = false;
	public static boolean noCreative = true;
	public static boolean multiworld = true;
	public static int afterLoginDelay = 20;

	public static boolean backup_enabled = true;
	public static long backup_interval = 0;
	public static int backup_cleanup_days = 0;

	public static List<String> update_events = new ArrayList<String>();

	public static long check_interval = 0;

	public static boolean allow_unsafe_ench = false;

	public static boolean debug = false;

	@SuppressWarnings("unchecked")
	public Config(iDigPlayer plugin) throws IOException,
			InvalidConfigurationException {
		File file = new File(plugin.getDataFolder(), "config.yml");
		if (!plugin.getDataFolder().exists())
			plugin.getDataFolder().mkdirs();
		if (!file.exists())
			copy(plugin.getResource("config.yml"), file);

		plugin.getConfig().load(file);

		YamlConfiguration defaults = new YamlConfiguration();
		defaults.load(plugin.getResource("config.yml"));
		plugin.getConfig().addDefaults(defaults);
		plugin.getConfig().options().copyDefaults(true);

		Config.dbHost = plugin.getConfig().getString("mysql.host");
		Config.dbUser = plugin.getConfig().getString("mysql.user");
		Config.dbPass = plugin.getConfig().getString("mysql.pass");
		Config.dbDatabase = plugin.getConfig().getString("mysql.db");
		Config.dbTable = plugin.getConfig().getString("mysql.table");
		Config.check_interval = plugin.getConfig().getInt("check-interval");
		Config.check_plugin_updates = plugin.getConfig().getBoolean(
				"check-plugin-updates");
		Config.noCreative = plugin.getConfig().getBoolean("no-creative");
		Config.afterLoginDelay = plugin.getConfig().getInt("after-login-delay");
		Config.multiworld = plugin.getConfig().getBoolean("multiworld");

		Config.backup_enabled = plugin.getConfig().getBoolean("backup.enabled");
		Config.backup_interval = plugin.getConfig().getInt("backup.interval");
		Config.backup_cleanup_days = plugin.getConfig().getInt(
				"backup.cleanup-days");

		Config.allow_unsafe_ench = plugin.getConfig().getBoolean("allow-unsafe-ench");

		Config.debug = plugin.getConfig().getBoolean("debug");

		Config.update_events = (ArrayList<String>) plugin.getConfig().getList(
				"update-events");
		/*
		if (Config.update_events == null) {
			Config.update_events = new ArrayList<String>();
			iDigPlayer.log(Level.WARNING,
					"No update event ! Data will only be updated when using the command");
		}

		Boolean lm = plugin.getConfig().getBoolean("lightweight-mode");
		if ((iDigPlayer.reload_count > 0) && (lm != Config.lightweight_mode)) {
			iDigPlayer.log(Level.WARNING,
					"Changing the 'lightweight-mode' require a full server restart !");
			iDigPlayer.log(Level.WARNING,
					"Results can be unpredictable until the server was not stopped then started.");
		} else if ((iDigPlayer.reload_count == 0) && lm) {
			iDigPlayer.log("InventorySQL is running in LIGHTWEIGHT MODE");
		} 
		Config.lightweight_mode = lm;
*/
		Config.check_interval *= 20;
		Config.backup_interval *= 20;
		Config.afterLoginDelay *= 20;
		plugin.getConfig().save(file);
	}

	private void copy(InputStream src, File dst) throws IOException {
		OutputStream out = new FileOutputStream(dst);

		// Transfer bytes from in to out
		byte[] buf = new byte[1024];
		int len;
		while ((len = src.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		src.close();
		out.close();
	}
}