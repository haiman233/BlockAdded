package net.xtsusaku.mc.xTSKBlockAddon;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import net.xtsusaku.mc.xTSKBlockAddon.Item.CompressedBlock.AbstractCompressedBlock;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import javax.annotation.Nonnull;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class xTSKBlockAddon extends JavaPlugin implements SlimefunAddon {

    private static xTSKBlockAddon instance;

    private ItemGroup blockAddonGroup;
    private Research metalResearch;
    private final NamespacedKey researchKey = new NamespacedKey(this, "new_metal_blocks");

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
        blockAddonGroup = new ItemGroup(blockAddonGroupId, itemGroupItem);
        metalResearch = new Research(researchKey, 171216233, "New Metal-Blocks!", 16);

        loadItems();

        metalResearch.register();
    }

    public void loadItems(){
        Reflections reflections = new Reflections("net.xtsusaku.mc.xTSKBlockAddon.Item.CompressedBlock.MetalBlocks");

        Set<Class<? extends AbstractCompressedBlock>> allClasses = reflections.getSubTypesOf(AbstractCompressedBlock.class);

        allClasses.forEach(cBlock -> {
            try {
                AbstractCompressedBlock ACB = cBlock.getDeclaredConstructor(ItemGroup.class).newInstance(blockAddonGroup);
                metalResearch.addItems(ACB.sfItem());
                metalResearch.addItems(ACB.sfItemReverse());
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });

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
    @Nonnull
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }

}
