package net.xtsusaku.mc.xTSKBlockAddon.Item;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import net.xtsusaku.mc.xTSKBlockAddon.xTSKBlockAddon;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CopperBlock extends AbstractCompressedBlock {

    public CopperBlock(ItemGroup itemGroup) {
        super(itemGroup, new ItemStack(Material.FLINT), "X_SF_COPPER", "&6COPPER Block");
    }

    public SlimefunItem registerBlock(ItemGroup itemGroup) {
        SlimefunItemStack SFItemStack = new SlimefunItemStack(idPrefix + "_BLOCK", Material.COAL_BLOCK, compressedName);

        ItemStack[] recipe = {
                singleItem, singleItem, singleItem,
                singleItem, singleItem, singleItem,
                singleItem, singleItem, singleItem};

        SlimefunItem item = new SlimefunItem(itemGroup, SFItemStack, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        item.register(xTSKBlockAddon.getInstance());

        return item;
    }

    public SlimefunItem registerReverse(ItemGroup itemGroup) {
        SlimefunItemStack SFItemStack = new SlimefunItemStack(idPrefix + "_REVERSE", Material.FLINT, "&fReverse " + compressedName);

        ItemStack[] recipe = {sfItem().getItem()};

        ItemStack result = singleItem.clone();
        result.setAmount(9);

        SlimefunItem item = new SlimefunItem(itemGroup, SFItemStack, RecipeType.ENHANCED_CRAFTING_TABLE, recipe, result);
        item.setHidden(true);
        item.register(xTSKBlockAddon.getInstance());

        return item;
    }

}
