package com.theguy2134.darkworld;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class DarkWorldMod implements ModInitializer {
    public static final String MOD_ID = "darkworld";

    public static final Block DARK_FOUNTAIN = new DarkFountainBlock(
            Block.Settings.create().strength(3.0f).requiresTool()
    );

    @Override
    public void onInitialize() {
        Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, "dark_fountain"), DARK_FOUNTAIN);
        Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "dark_fountain"),
                new BlockItem(DARK_FOUNTAIN, new Item.Settings()));
    }
}
