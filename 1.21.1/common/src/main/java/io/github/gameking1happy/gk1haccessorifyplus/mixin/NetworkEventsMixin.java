package io.github.gameking1happy.gk1haccessorifyplus.mixin;

import io.github.gameking1happy.gk1haccessorifyplus.compat.reinfshulker.ReinfShulkerCompat;
import me.pajic.accessorify.network.NetworkEvents;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import static io.github.gameking1happy.gk1hcore.compat.CompatFlags.*;

/**
 * Has correct box size given instead of always 27.
 */
@Mixin(NetworkEvents.class)
public class NetworkEventsMixin {
    @ModifyArg(method = "openShulkerBox(Lnet/minecraft/server/level/ServerPlayer;I)V",
            at = @At(value = "INVOKE", target = "Lme/pajic/accessorify/menu/ShulkerBoxAccessoryContainerMenu;<init>(Lnet/minecraft/world/item/ItemStack;I)V"))
    private static int boxSize(ItemStack shulker, int size) {
        return (REINF_SHU && GK1H_TAGS) ? ReinfShulkerCompat.getInventorySizeForReinfShulker(shulker.getItem()) : size;
    }
}
