package net.xtsusaku.mc.xTSKBlockAddon;

import net.xtsusaku.mc.xTSKBlockAddon.Item.FlintBlock;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

public class xTSKBlockAddon extends JavaPlugin implements SlimefunAddon {

    private static xTSKBlockAddon instance;

    public static xTSKBlockAddon getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        // Read something from your config.yml
        Config cfg = new Config(this);

        ItemStack itemGroupItem = new CustomItemStack(Material.IRON_BLOCK, "&aBlock Addon", "", "&a> Click to open");
        NamespacedKey blockAddonGroupId = new NamespacedKey(this, "block_addon");
        ItemGroup blockAddonGroup = new ItemGroup(blockAddonGroupId, itemGroupItem);

        new FlintBlock(blockAddonGroup);
    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return "https://github.com/xtsusaku/BlockAdded/issues";
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }

}
