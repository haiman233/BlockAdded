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
    private static SlimefunItem sfItemReverse;

    public CopperBlock(ItemGroup itemGroup) {
        sfItem = registerBlock(itemGroup);
        sfItemReverse = registerReverse(itemGroup);
    }

    public static SlimefunItem sfItem() {
        return sfItem;
    }

    public static SlimefunItem sfItemReverse() {
        return sfItemReverse;
    }

    public SlimefunItem registerBlock(ItemGroup itemGroup) {
        SlimefunItemStack SFItemStack = new SlimefunItemStack("X_COPPER_BLOCK", Material.COPPER_BLOCK, "&6Copper Block");

        ItemStack[] recipe = {
                SlimefunItems.COPPER_INGOT, SlimefunItems.COPPER_INGOT, SlimefunItems.COPPER_INGOT,
                SlimefunItems.COPPER_INGOT, SlimefunItems.COPPER_INGOT, SlimefunItems.COPPER_INGOT,
                SlimefunItems.COPPER_INGOT, SlimefunItems.COPPER_INGOT, SlimefunItems.COPPER_INGOT};

        SlimefunItem item = new SlimefunItem(itemGroup, SFItemStack, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        item.register(xTSKBlockAddon.getInstance());

        return item;
    }

    public SlimefunItem registerReverse(ItemGroup itemGroup) {
        SlimefunItemStack SFItemStack = new SlimefunItemStack("X_SF_COPPER", Material.COPPER_INGOT, "Reverse Copper");

        ItemStack[] recipe = {sfItem().getItem()};

        ItemStack result = SlimefunItems.COPPER_INGOT.clone();
        result.setAmount(9);

        SlimefunItem item = new SlimefunItem(itemGroup, SFItemStack, RecipeType.ENHANCED_CRAFTING_TABLE, recipe, result);
        item.setHidden(true);
        item.register(xTSKBlockAddon.getInstance());

        return item;
    }

}
