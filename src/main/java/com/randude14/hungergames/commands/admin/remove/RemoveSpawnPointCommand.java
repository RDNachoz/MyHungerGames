package com.randude14.hungergames.commands.admin.remove;

import com.randude14.hungergames.Defaults.Commands;
import com.randude14.hungergames.GameManager;
import com.randude14.hungergames.HungerGames;
import com.randude14.hungergames.Lang;
import com.randude14.hungergames.commands.SubCommand;
import com.randude14.hungergames.listeners.SessionListener;
import com.randude14.hungergames.listeners.SessionListener.SessionType;
import com.randude14.hungergames.utils.ChatUtils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RemoveSpawnPointCommand extends SubCommand{

	public RemoveSpawnPointCommand() {
		super(Commands.ADMIN_REMOVE_SPAWNPOINT);
	}

	@Override
	public boolean handle(CommandSender cs, Command cmd, String[] args) {
	    Player player = (Player) cs;	    
	    
	    if (args.length < 1) {
		    ChatUtils.helpCommand(player, command.getUsage(), HungerGames.CMD_ADMIN);
		    return true;
	    }
	    
	    game = GameManager.getGame(args[0]);
	    if(game == null) {
		    ChatUtils.error(player, Lang.getNotExist().replace("<item>", args[0]));
		    return true;
	    }
	    
	    SessionListener.addSession(SessionType.SPAWN_REMOVER, player, game.getName());
	    ChatUtils.send(player, ChatColor.GREEN, "Hit a spawn point to remove it from %s.", game.getName());
	    return true;
	}
	
}
