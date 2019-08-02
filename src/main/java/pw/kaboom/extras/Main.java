package pw.kaboom.extras;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.plugin.java.JavaPlugin;

import com.destroystokyo.paper.profile.PlayerProfile;

public class Main extends JavaPlugin {
	int fallingBlockCount;
	HashMap<UUID, Long> commandMillisList = new HashMap<>();
	HashMap<UUID, Long> interactMillisList = new HashMap<>();
	HashMap<String, PlayerProfile> playerProfile = new HashMap<>();
	HashSet<String> consoleCommandBlacklist = new HashSet<>();
	HashSet<BlockFace> faces = new HashSet<>();
	HashSet<Material> fallingBlockList = new HashSet<>();
	HashSet<Material> nonSolidBlockList = new HashSet<>();
	HashSet<Material> nonSolidDoubleBlockList = new HashSet<>();
	HashSet<Material> nonSolidSingularBlockList = new HashSet<>();
	HashSet<Material> nonSolidWallMountedBlockList = new HashSet<>();

	public void onLoad() {
		/* Fill lists */
		Collections.addAll(
			consoleCommandBlacklist,
			"essentials:action",
			"essentials:adventure",
			"essentials:adventuremode",
			"essentials:afk",
			"essentials:amsg",
			"essentials:away",
			"essentials:ban",
			"essentials:banip",
			"essentials:bc",
			"essentials:bcast",
			"essentials:bcastw",
			"essentials:bcw",
			"essentials:broadcast",
			"essentials:broadcastworld",
			"essentials:ci",
			"essentials:clean",
			"essentials:clear",
			"essentials:clearinvent",
			"essentials:clearinventory",
			"essentials:creative",
			"essentials:creativemode",
			"essentials:describe",
			"essentials:eaction",
			"essentials:eadventure",
			"essentials:eadventuremode",
			"essentials:eafk",
			"essentials:eat",
			"essentials:eamsg",
			"essentials:eaway",
			"essentials:eban",
			"essentials:ebanip",
			"essentials:ebc",
			"essentials:ebcast",
			"essentials:ebcastw",
			"essentials:ebcw",
			"essentials:ebroadcast",
			"essentials:ebroadcastworld",
			"essentials:eci",
			"essentials:eco",
			"essentials:economy",
			"essentials:eclean",
			"essentials:eclear",
			"essentials:eclearinvent",
			"essentials:eclearinventory",
			"essentials:ecreative",
			"essentials:ecreativemode",
			"essentials:edescribe",
			"essentials:eeat",
			"essentials:eeco",
			"essentials:eeconomy",
			"essentials:eemail",
			"essentials:efeed",
			"essentials:egamemode",
			"essentials:egm",
			"essentials:egma",
			"essentials:egmc",
			"essentials:egms",
			"essentials:egmsp",
			"essentials:egmt",
			"essentials:eheal",
			"essentials:ehelpop",
			"essentials:ejail",
			"essentials:ekick",
			"essentials:ekill",
			"essentials:email",
			"essentials:eme",
			"essentials:ememo",
			"essentials:emute",
			"essentials:emsg",
			"essentials:enuke",
			"essentials:epardon",
			"essentials:epardonip",
			"essentials:epm",
			"essentials:eshoutworld",
			"essentials:esilence",
			"essentials:esudo",
			"essentials:esurvival",
			"essentials:esurvivalmode",
			"essentials:etele",
			"essentials:eteleport",
			"essentials:etell",
			"essentials:etempban",
			"essentials:etjail",
			"essentials:etogglejail",
			"essentials:etp",
			"essentials:etp2p",
			"essentials:etpaall",
			"essentials:etpall",
			"essentials:etppos",
			"essentials:etptoggle",
			"essentials:eunban",
			"essentials:eunbanip",
			"essentials:ev",
			"essentials:evanish",
			"essentials:ewarp",
			"essentials:ewarps",
			"essentials:ewhisper",
			"essentials:feed",
			"essentials:gamemode",
			"essentials:gm",
			"essentials:gma",
			"essentials:gmc",
			"essentials:gms",
			"essentials:gmsp",
			"essentials:gmt",
			"essentials:heal",
			"essentials:helpop",
			"essentials:jail",
			"essentials:kick",
			"essentials:kill",
			"essentials:m",
			"essentials:mail",
			"essentials:me",
			"essentials:memo",
			"essentials:mute",
			"essentials:msg",
			"essentials:nuke",
			"essentials:pardon",
			"essentials:pardonip",
			"essentials:pm",
			"essentials:shoutworld",
			"essentials:silence",
			"essentials:sp",
			"essentials:spec",
			"essentials:spectator",
			"essentials:sudo",
			"essentials:survival",
			"essentials:survivalmode",
			"essentials:t",
			"essentials:tele",
			"essentials:teleport",
			"essentials:tell",
			"essentials:tempban",
			"essentials:tjail",
			"essentials:togglejail",
			"essentials:tp",
			"essentials:tp2p",
			"essentials:tpaall",
			"essentials:tpall",
			"essentials:tppos",
			"essentials:tptoggle",
			"essentials:unban",
			"essentials:unbanip",
			"essentials:v",
			"essentials:vanish",
			"essentials:w",
			"essentials:warp",
			"essentials:warps",
			"essentials:whisper",
			"extras:cc",
			"extras:clearchat",
			"minecraft:clear",
			"minecraft:effect",
			"minecraft:execute",
			"minecraft:gamemode",
			"minecraft:gamerule",
			"minecraft:kill",
			"minecraft:me",
			"minecraft:say",
			"minecraft:spreadplayers",
			"minecraft:tell",
			"minecraft:tellraw",
			"minecraft:title",
			"minecraft:tp",
			"action",
			"adventure",
			"adventuremode",
			"afk",
			"amsg",
			"away",
			"ban",
			"banip",
			"bc",
			"bcast",
			"bcastw",
			"bcw",
			"broadcast",
			"broadcastworld",
			"cc",
			"ci",
			"clean",
			"clear",
			"clearchat",
			"clearinvent",
			"clearinventory",
			"creative",
			"creativemode",
			"describe",
			"eaction",
			"eadventure",
			"eadventuremode",
			"eafk",
			"eamsg",
			"eat",
			"eaway",
			"eban",
			"ebanip",
			"ebc",
			"ebcast",
			"ebcastw",
			"ebcw",
			"ebroadcast",
			"ebroadcastworld",
			"eci",
			"eclean",
			"eclear",
			"eclearinvent",
			"eclearinventory",
			"ecreativemode",
			"eco",
			"economy",
			"edescribe",
			"eeat",
			"eeco",
			"eeconomy",
			"eecreative",
			"eemail",
			"efeed",
			"effect",
			"egamemode",
			"egm",
			"egma",
			"egmc",
			"egms",
			"egmsp",
			"egmt",
			"eheal",
			"ehelpop",
			"ejail",
			"ekick",
			"ekill",
			"email",
			"eme",
			"ememo",
			"emute",
			"emsg",
			"enuke",
			"epardon",
			"epardonip",
			"epm",
			"eshoutworld",
			"esilence",
			"esudo",
			"esurvival",
			"esurvivalmode",
			"etele",
			"eteleport",
			"etell",
			"etempban",
			"etjail",
			"etogglejail",
			"etp",
			"etp2p",
			"etpaall",
			"etpall",
			"etppos",
			"etptoggle",
			"eunban",
			"eunbanip",
			"ev",
			"evanish",
			"ewarp",
			"ewarps",
			"ewhisper",
			"execute",
			"feed",
			"gamemode",
			"gamerule",
			"gm",
			"gma",
			"gmc",
			"gms",
			"gmsp",
			"gmt",
			"heal",
			"helpop",
			"jail",
			"kill",
			"m",
			"mail",
			"me",
			"memo",
			"mute",
			"msg",
			"nuke",
			"paper:paper",
			"paper",
			"pardon",
			"pardonip",
			"pm",
			"shoutworld",
			"say",
			"silence",
			"sp",
			"spec",
			"spectator",
			"spigot:spigot",
			"spigot",
			"spreadplayers",
			"sudo",
			"survival",
			"survivalmode",
			"t",
			"tele",
			"teleport",
			"tell",
			"tempban",
			"title",
			"tjail",
			"togglejail",
			"tp",
			"tp2p",
			"tpaall",
			"tpall",
			"tppos",
			"tptoggle",
			"unban",
			"unbanip",
			"v",
			"vanish",
			"w",
			"warp",
			"warps",
			"whisper"
		);

		Collections.addAll(
			faces,
			BlockFace.NORTH,
			BlockFace.SOUTH,
			BlockFace.WEST,
			BlockFace.EAST,
			BlockFace.UP,
			BlockFace.DOWN
		);

		Collections.addAll(
			fallingBlockList,
			Material.ANVIL,
			Material.GRAVEL,
			Material.SAND
		);

		Collections.addAll(
			nonSolidDoubleBlockList,
			Material.GRASS,
			Material.SIGN,
			Material.OAK_DOOR,
			Material.IRON_DOOR,
			Material.CACTUS,
			Material.SUGAR_CANE,
			Material.CAKE,
			Material.DAYLIGHT_DETECTOR,
			Material.BLACK_CARPET,
			Material.BLUE_CARPET,
			Material.BROWN_CARPET,
			Material.CYAN_CARPET,
			Material.GRAY_CARPET,
			Material.GREEN_CARPET,
			Material.LIGHT_BLUE_CARPET,
			Material.LIGHT_GRAY_CARPET,
			Material.LIME_CARPET,
			Material.MAGENTA_CARPET,
			Material.ORANGE_CARPET,
			Material.PINK_CARPET,
			Material.PURPLE_CARPET,
			Material.RED_CARPET,
			Material.WHITE_CARPET,
			Material.YELLOW_CARPET,
			Material.BLACK_BANNER,
			Material.BLUE_BANNER,
			Material.BROWN_BANNER,
			Material.CYAN_BANNER,
			Material.GRAY_BANNER,
			Material.GREEN_BANNER,
			Material.LIGHT_BLUE_BANNER,
			Material.LIGHT_GRAY_BANNER,
			Material.LIME_BANNER,
			Material.MAGENTA_BANNER,
			Material.ORANGE_BANNER,
			Material.PINK_BANNER,
			Material.PURPLE_BANNER,
			Material.RED_BANNER,
			Material.WHITE_BANNER,
			Material.YELLOW_BANNER,
			Material.SPRUCE_DOOR,
			Material.BIRCH_DOOR,
			Material.JUNGLE_DOOR,
			Material.ACACIA_DOOR,
			Material.DARK_OAK_DOOR,
			Material.KELP,
			Material.TALL_SEAGRASS,
			Material.TALL_GRASS,
			Material.SUNFLOWER,
			Material.LARGE_FERN,
			Material.LILAC,
			Material.ROSE_BUSH,
			Material.PEONY
		);

		Collections.addAll(
			nonSolidSingularBlockList,
			Material.ACACIA_SAPLING,
			Material.BIRCH_SAPLING,
			Material.DARK_OAK_SAPLING,
			Material.JUNGLE_SAPLING,
			Material.OAK_SAPLING,
			Material.SPRUCE_SAPLING,
			Material.BLACK_BED,
			Material.BLUE_BED,
			Material.BROWN_BED,
			Material.CYAN_BED,
			Material.GRAY_BED,
			Material.GREEN_BED,
			Material.LIGHT_BLUE_BED,
			Material.LIGHT_GRAY_BED,
			Material.LIME_BED,
			Material.MAGENTA_BED,
			Material.ORANGE_BED,
			Material.PINK_BED,
			Material.PURPLE_BED,
			Material.RED_BED,
			Material.WHITE_BED,
			Material.YELLOW_BED,
			Material.POWERED_RAIL,
			Material.DETECTOR_RAIL,
			Material.DEAD_BUSH,
			Material.AZURE_BLUET,
			Material.ALLIUM,
			Material.BLUE_ORCHID,
			Material.DANDELION,
			Material.FERN,
			Material.ORANGE_TULIP,
			Material.PINK_TULIP,
			Material.POPPY,
			Material.RED_TULIP,
			Material.WHITE_TULIP,
			Material.OXEYE_DAISY,
			Material.BROWN_MUSHROOM,
			Material.RED_MUSHROOM,
			Material.FIRE,
			Material.WHEAT,
			Material.RAIL,
			Material.STONE_PRESSURE_PLATE,
			Material.ACACIA_PRESSURE_PLATE,
			Material.BIRCH_PRESSURE_PLATE,
			Material.DARK_OAK_PRESSURE_PLATE,
			Material.JUNGLE_PRESSURE_PLATE,
			Material.OAK_PRESSURE_PLATE,
			Material.SPRUCE_PRESSURE_PLATE,
			Material.SNOW,
			Material.REPEATER,
			Material.PUMPKIN_STEM,
			Material.MELON_STEM,
			Material.LILY_PAD,
			Material.FLOWER_POT,
			Material.CARROT,
			Material.POTATO,
			Material.HEAVY_WEIGHTED_PRESSURE_PLATE,
			Material.LIGHT_WEIGHTED_PRESSURE_PLATE,
			Material.COMPARATOR,
			Material.ACTIVATOR_RAIL,
			Material.BEETROOTS,
			Material.NETHER_WART_BLOCK,
			Material.SEAGRASS,
			Material.BRAIN_CORAL,
			Material.BUBBLE_CORAL,
			Material.DEAD_BRAIN_CORAL,
			Material.DEAD_BUBBLE_CORAL,
			Material.DEAD_FIRE_CORAL,
			Material.DEAD_HORN_CORAL,
			Material.DEAD_TUBE_CORAL,
			Material.FIRE_CORAL,
			Material.HORN_CORAL,
			Material.TUBE_CORAL,
			Material.SEA_PICKLE
		);

		Collections.addAll(
			nonSolidWallMountedBlockList,
			Material.TORCH,
			Material.WALL_TORCH,
			Material.LADDER,
			Material.WALL_SIGN,
			Material.LEVER,
			Material.REDSTONE_WIRE,
			Material.REDSTONE_TORCH,
			Material.REDSTONE_WALL_TORCH,
			Material.STONE_BUTTON,
			Material.ACACIA_TRAPDOOR,
			Material.BIRCH_TRAPDOOR,
			Material.DARK_OAK_TRAPDOOR,
			Material.JUNGLE_TRAPDOOR,
			Material.OAK_TRAPDOOR,
			Material.SPRUCE_TRAPDOOR,
			Material.VINE,
			Material.COCOA,
			Material.TRIPWIRE_HOOK,
			Material.ACACIA_BUTTON,
			Material.BIRCH_BUTTON,
			Material.DARK_OAK_BUTTON,
			Material.JUNGLE_BUTTON,
			Material.OAK_BUTTON,
			Material.SPRUCE_BUTTON,
			Material.IRON_TRAPDOOR,
			Material.BLACK_WALL_BANNER,
			Material.BLUE_WALL_BANNER,
			Material.BROWN_WALL_BANNER,
			Material.CYAN_WALL_BANNER,
			Material.GRAY_WALL_BANNER,
			Material.GREEN_WALL_BANNER,
			Material.LIGHT_BLUE_WALL_BANNER,
			Material.LIGHT_GRAY_WALL_BANNER,
			Material.LIME_WALL_BANNER,
			Material.MAGENTA_WALL_BANNER,
			Material.ORANGE_WALL_BANNER,
			Material.PINK_WALL_BANNER,
			Material.PURPLE_WALL_BANNER,
			Material.RED_WALL_BANNER,
			Material.WHITE_WALL_BANNER,
			Material.YELLOW_WALL_BANNER,
			Material.NETHER_PORTAL,
			Material.END_PORTAL,
			Material.BRAIN_CORAL_FAN,
			Material.BRAIN_CORAL_WALL_FAN,
			Material.BUBBLE_CORAL_FAN,
			Material.BUBBLE_CORAL_WALL_FAN,
			Material.DEAD_BRAIN_CORAL_FAN,
			Material.DEAD_BRAIN_CORAL_WALL_FAN,
			Material.DEAD_BUBBLE_CORAL_FAN,
			Material.DEAD_BUBBLE_CORAL_WALL_FAN,
			Material.DEAD_FIRE_CORAL_FAN,
			Material.DEAD_FIRE_CORAL_WALL_FAN,
			Material.DEAD_HORN_CORAL_FAN,
			Material.DEAD_HORN_CORAL_WALL_FAN,
			Material.DEAD_TUBE_CORAL_FAN,
			Material.DEAD_TUBE_CORAL_WALL_FAN,
			Material.FIRE_CORAL_FAN,
			Material.FIRE_CORAL_WALL_FAN,
			Material.HORN_CORAL_FAN,
			Material.HORN_CORAL_WALL_FAN,
			Material.TUBE_CORAL_FAN,
			Material.TUBE_CORAL_WALL_FAN
		);

		this.nonSolidBlockList.addAll(nonSolidDoubleBlockList);
		this.nonSolidBlockList.addAll(nonSolidSingularBlockList);
		this.nonSolidBlockList.addAll(nonSolidWallMountedBlockList);
	}

	public void onEnable() {
		/* Commands */
		this.getCommand("clearchat").setExecutor(new CommandClearChat());
		this.getCommand("console").setExecutor(new CommandConsole());
		this.getCommand("destroyentities").setExecutor(new CommandDestroyEntities());
		this.getCommand("enchantall").setExecutor(new CommandEnchantAll());
		this.getCommand("herobrine").setExecutor(new CommandHerobrine(this));
		this.getCommand("jumpscare").setExecutor(new CommandJumpscare());
		this.getCommand("prefix").setExecutor(new CommandPrefix(this));
		this.getCommand("pumpkin").setExecutor(new CommandPumpkin());
		this.getCommand("skin").setExecutor(new CommandSkin(this));
		this.getCommand("spawn").setExecutor(new CommandSpawn());
		this.getCommand("spidey").setExecutor(new CommandSpidey());
		this.getCommand("tellraw").setExecutor(new CommandTellraw());
		this.getCommand("unloadchunks").setExecutor(new CommandUnloadChunks());
		this.getCommand("username").setExecutor(new CommandUsername(this));

		/* Block-related modules */
		this.getServer().getPluginManager().registerEvents(new BlockCheck(), this);
		/*new TileEntityCheck(this).runTaskTimerAsynchronously(this, 0, 400);*/
		this.getServer().getPluginManager().registerEvents(new BlockPhysics(this), this);

		/* Entity-related modules */
		this.getServer().getPluginManager().registerEvents(new EntityExplosion(), this);
		this.getServer().getPluginManager().registerEvents(new EntityKnockback(), this);
		this.getServer().getPluginManager().registerEvents(new EntitySpawn(), this);

		/* Player-related modules */
		this.getServer().getPluginManager().registerEvents(new PlayerChat(this), this);
		this.getServer().getPluginManager().registerEvents(new PlayerCommand(this), this);
		this.getServer().getPluginManager().registerEvents(new PlayerConnection(this), this);
		this.getServer().getPluginManager().registerEvents(new PlayerDamage(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerInteract(this), this);

		/* Server-related modules */
		new AutosaveCheck().runTaskTimerAsynchronously(this, 0, 20);
		this.getServer().getPluginManager().registerEvents(new ServerCommand(this), this);
		this.getServer().getPluginManager().registerEvents(new ServerPing(), this);
	}
}
