package net.xtsusaku.mc.xTSKBlockAddon.Item;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import net.xtsusaku.mc.xTSKBlockAddon.xTSKBlockAddon;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class CopperBlock {

    private static SlimefunItem sfItem;

    public CopperBlock(ItemGroup itemGroup) {
        sfItem = registerCopperBlock(itemGroup);
        registerCopper(itemGroup);
    }

    public static SlimefunItem sfItem() {
        return sfItem;
    }

    public SlimefunItem registerCopperBlock(ItemGroup itemGroup) {
        SlimefunItemStack SFItemStack = new SlimefunItemStack("X_COPPER_BLOCK", Material.COPPER_BLOCK, "&6Copper Block");

        ItemStack[] recipe = {
                SlimefunItems.COPPER_INGOT, SlimefunItems.COPPER_INGOT, SlimefunItems.COPPER_INGOT,
                SlimefunItems.COPPER_INGOT, SlimefunItems.COPPER_INGOT, SlimefunItems.COPPER_INGOT,
                SlimefunItems.COPPER_INGOT, SlimefunItems.COPPER_INGOT, SlimefunItems.COPPER_INGOT};

        SlimefunItem item = new SlimefunItem(itemGroup, SFItemStack, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        item.register(xTSKBlockAddon.getInstance());

        return item;
    }

    public void registerCopper(ItemGroup itemGroup) {
        SlimefunItemStack SFItemStack = new SlimefunItemStack("X_COPPER", Material.COPPER_INGOT, "Reverse Copper");

        ItemStack[] recipe = {sfItem().getItem()};

        ItemStack result = SlimefunItems.COPPER_INGOT.clone();
        result.setAmount(9);

        SlimefunItem item = new SlimefunItem(itemGroup, SFItemStack, RecipeType.ENHANCED_CRAFTING_TABLE, recipe, result);
//        item.setHidden(true);
        item.register(xTSKBlockAddon.getInstance());
    }

}
