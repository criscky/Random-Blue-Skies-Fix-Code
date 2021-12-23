package com.criscky.randfix.mixin;

import com.legacy.blue_skies.events.SkiesPlayerEvents;
import com.legacy.blue_skies.util.EntityUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.eventbus.api.Cancelable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SkiesPlayerEvents.DungeonBalancingChecks.class)
public class Example {
    private static final Logger LOGGER = LogManager.getLogger();

    @Inject(at = @At("HEAD"), method = "Lcom/legacy/blue_skies/events/SkiesPlayerEvents$DungeonBalancingChecks;playerCanPlaceInDungeon(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/Block;)Z",remap = false, cancellable = true)
    private static void playerCanPlaceInDungeon_mixin(PlayerEntity player, BlockPos pos, Block placingBlock, CallbackInfoReturnable<Boolean> cir) {
        //LOGGER.info("Trying to prevent crash on placing");
        if (player instanceof FakePlayer) {
            cir.setReturnValue(!EntityUtil.isInDungeon(player.level, pos));
        }
    }

    @Inject(at = @At("HEAD"), method = "Lcom/legacy/blue_skies/events/SkiesPlayerEvents$DungeonBalancingChecks;playerCanBreakDungeon(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/math/BlockPos;)Z",remap = false, cancellable = true)
    private static void playerCanBreakDungeon_mixin(PlayerEntity player, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        //LOGGER.info("Trying to prevent crash breaking");
        if (player instanceof FakePlayer) {
            cir.setReturnValue(!EntityUtil.isInDungeon(player.level, pos));
        }
    }
}
