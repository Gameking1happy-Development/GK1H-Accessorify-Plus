package io.github.gameking1happy.gk1haccessorifyplus.compat.netheriteextras;

import net.minecraft.world.item.ItemStack;
import xyz.hafemann.netheriteextras.item.ModItems;

/**
 * Compat for Netherite Extras.
 */
public class NetheriteExtrasCompat {

    /**
     * @param stack Item stack.
     * @return boolean
     */
    public static boolean isTotem(ItemStack stack) {
        return stack.is(ModItems.TOTEM_OF_NEVERDYING);
    }
}
