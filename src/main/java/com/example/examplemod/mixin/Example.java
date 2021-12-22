package com.example.examplemod.mixin;

import com.legacy.blue_skies.events.SkiesPlayerEvents;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SkiesPlayerEvents.DungeonBalancingChecks.class)
public class Example {

    @Inject(at = @At("HEAD"), method = "Lcom/legacy/blue_skies/events/SkiesPlayerEvents$DungeonBalancingChecks;playerCanPlaceInDungeon(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/Block;)Z",remap = false)
    private static void playerCanPlaceInDungeon_mixin(PlayerEntity player, BlockPos pos, Block placingBlock, CallbackInfoReturnable<Boolean> cir) {
        System.out.println("Yes it worked!!");
    }
}
