package io.github.gameking1happy.gk1haccessorifyplus.mixin.netheriteextras;

import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import me.pajic.accessorify.Main;
import me.pajic.accessorify.util.ModUtil;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.hafemann.netheriteextras.item.ModItems;

/**
 * Makes the Totem of Neverdying show its floating display instead of the Totem of Undying's floating display.
 */
@IfModLoaded("netheriteextras")
@Mixin(ClientPacketListener.class)
public class TotemFloatingDisplayMixin {
    @Inject(
            method = "findTotem",
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/player/Player;getItemInHand(Lnet/minecraft/world/InteractionHand;)Lnet/minecraft/world/item/ItemStack;"
            )},
            cancellable = true
    )
    private static void onGetActiveTotemOfUndying(Player player, CallbackInfoReturnable<ItemStack> cir) {
        if (Main.CONFIG.accessorySettings.totemOfUndyingAccessory.get()) {
            ItemStack itemStack = ModUtil.getAccessoryStack(player, ModItems.TOTEM_OF_NEVERDYING).right();
            if (itemStack.is(ModItems.TOTEM_OF_NEVERDYING)) {
                cir.setReturnValue(itemStack);
            }
        }
    }
}
