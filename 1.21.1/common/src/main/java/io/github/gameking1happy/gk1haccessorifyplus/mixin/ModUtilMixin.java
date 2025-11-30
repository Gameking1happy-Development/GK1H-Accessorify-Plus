package io.github.gameking1happy.gk1haccessorifyplus.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import io.github.gameking1happy.gk1haccessorifyplus.compat.netheriteextras.NetheriteExtrasCompat;
import me.pajic.accessorify.util.ModUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static io.github.gameking1happy.gk1hcore.compat.CompatFlags.NetExt;

/**
 * For Netherite Extras compat.
 */
@Mixin(ModUtil.class)
public class ModUtilMixin {
    @WrapOperation(
            method = "isTotem(Lnet/minecraft/world/item/ItemStack;)Z",
            at =
    @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z")
    )
    private static boolean NetheriteExtrasisTotem(ItemStack stack, Item item, Operation<Boolean> original) {
        return original.call(stack, item) || (NetExt && NetheriteExtrasCompat.isTotem(stack));
    }
}