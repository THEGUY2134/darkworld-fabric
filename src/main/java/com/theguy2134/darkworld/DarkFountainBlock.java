package com.theguy2134.darkworld;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DarkFountainBlock extends Block {
    public DarkFountainBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos,
                                 PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        }
        if (!(player instanceof ServerPlayerEntity serverPlayer)) {
            return ActionResult.PASS;
        }

        ServerWorld destination = serverPlayer.getServer().getWorld(DarkWorldModKeys.DARK_WORLD);
        if (destination == null) {
            serverPlayer.sendMessage(Text.literal("The Dark World is not available in this save yet."), true);
            return ActionResult.CONSUME;
        }

        serverPlayer.teleport(destination, 0.5, 80.0, 0.5, Set.of(),
                serverPlayer.getYaw(), serverPlayer.getPitch());
        serverPlayer.sendMessage(Text.literal("The Dark Fountain carries you into the Dark World..."), false);
        return ActionResult.CONSUME;
    }
}
