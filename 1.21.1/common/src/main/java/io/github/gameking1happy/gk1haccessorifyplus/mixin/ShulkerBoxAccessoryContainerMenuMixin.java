package io.github.gameking1happy.gk1haccessorifyplus.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import io.github.gameking1happy.gk1haccessorifyplus.compat.reinfshulker.ReinfShulkerCompat;
import me.pajic.accessorify.menu.ShulkerBoxAccessoryContainerMenu;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import static io.github.gameking1happy.gk1hcore.compat.CompatFlags.GK1HTags;
import static io.github.gameking1happy.gk1hcore.compat.CompatFlags.ReinfShu;

/**
 * Menu compat.
 */
@Mixin(ShulkerBoxAccessoryContainerMenu.class)
public class ShulkerBoxAccessoryContainerMenuMixin {
    @Shadow
    @Final
    private ItemStack shulker;
    /**
     * @param original Original value.
     * @param i IDK.
     * @param inventory Inventory.
     * @param player Player.
     * @return Menu.
     */
    @ModifyReturnValue(method = "createMenu(ILnet/minecraft/world/entity/player/Inventory;Lnet/minecraft/world/entity/player/Player;)Lnet/minecraft/world/inventory/AbstractContainerMenu;",
    at = @At("RETURN"))
    public @Nullable AbstractContainerMenu RSBreturn(AbstractContainerMenu original, int i, @NotNull Inventory inventory, @NotNull Player player) {
        return (ReinfShu && GK1HTags) ? ReinfShulkerCompat.createMenu(i, inventory, (ShulkerBoxAccessoryContainerMenu) (Object) this, shulker.getItem()) : original;
    }
}
