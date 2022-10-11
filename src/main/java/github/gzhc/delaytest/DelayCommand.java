package github.gzhc.delaytest;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class DelayCommand implements CommandExecutor {

    private static final HashMap<UUID, Long> times;

    static {
        times = new HashMap<>();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        final Long t = this.times.get(p.getUniqueId());
        if (t != null && System.currentTimeMillis() - t < 1000L) {
            p.sendMessage("U can't use that command so frequently!");
            return true;
        }
        this.times.put(p.getUniqueId(), System.currentTimeMillis());
        //do something
        return false;
    }
}
