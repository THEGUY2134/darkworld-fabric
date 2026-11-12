package com.theguy2134.darkworld;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public final class DarkWorldModKeys {
    public static final RegistryKey<World> DARK_WORLD =
            RegistryKey.of(RegistryKeys.WORLD, Identifier.of(DarkWorldMod.MOD_ID, "dark_world"));

    private DarkWorldModKeys() {}
}
