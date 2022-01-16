package net.xtsusaku.mc.xTSKBlockAddon.Item.CompressedBlock;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public abstract class AbstractCompressedBlock {

    protected SlimefunItem sfItem;
    protected SlimefunItem sfItemReverse;

    protected final ItemStack singleItem;
    protected final Material compressedMaterial;
    protected final Material uncompressedMaterial;

    protected final String idPrefix;
    protected final String compressedName;

    public AbstractCompressedBlock(ItemGroup itemGroup, ItemStack singleItem, Material compressedMaterial, Material uncompressedMaterial, String idPrefix, String compressedName) {
        this.compressedName = compressedName;
        this.singleItem = singleItem;
        this.idPrefix = idPrefix;

        this.compressedMaterial = compressedMaterial;
        this.uncompressedMaterial = uncompressedMaterial;

        sfItem = registerBlock(itemGroup);
        sfItemReverse = registerReverse(itemGroup);
    }

    public SlimefunItem sfItem() {
        return sfItem;
    }

    public SlimefunItem sfItemReverse() {
        return sfItemReverse;
    }

    public abstract SlimefunItem registerBlock(ItemGroup itemGroup);

    public abstract SlimefunItem registerReverse(ItemGroup itemGroup);

}
