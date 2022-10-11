package github.gzhc.delaytest;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("delay").setExecutor(new DelayCommand());
    }

}
