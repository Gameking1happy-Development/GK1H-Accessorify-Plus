package io.github.gameking1happy.gk1haccessorifyplus.compat.netheriteextras;

import io.wispforest.accessories.api.client.AccessoriesRendererRegistry;
import io.wispforest.accessories.api.slot.SlotReference;
import me.pajic.accessorify.accessories.SlotCopyingAccessory;
import me.pajic.accessorify.util.ModUtil;
import me.pajic.accessorify.util.MultiVersionUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

/**
 * Totem of Neverdying compat.
 */
@SuppressWarnings("unused")
public class TotemOfNeverdyingAccessory implements SlotCopyingAccessory {

    /**
     * Main init.
     */
    public static void init() {
        RegistryEntryAddedCallback.event(BuiltInRegistries.ITEM).register((i, rl, item) -> {
            if (rl.equals(MultiVersionUtil.parse("netheriteextras:totem_of_neverdying"))) {
                MultiVersionUtil.registerAccessory(item, new TotemOfNeverdyingAccessory());
            }
        });
    }

    /**
     * Client init.
     */
    @Environment(EnvType.CLIENT)
    public static void clientInit() {
        RegistryEntryAddedCallback.event(BuiltInRegistries.ITEM).register((i, rl, item) -> {
            if (rl.equals(MultiVersionUtil.parse("netheriteextras:totem_of_neverdying"))) {
                AccessoriesRendererRegistry.registerNoRenderer(Items.TOTEM_OF_UNDYING);
            }
        });
    }

    @Override
    public String getPath() {
        return "add_charm_6";
    }

    @Override
    public String getSlot() {
        return "charm";
    }

    @Override
    public boolean canEquip(ItemStack stack, SlotReference reference) {
        return !MultiVersionUtil.isAnotherEquipped(stack, reference, ModUtil::isTotem);
    }
}
