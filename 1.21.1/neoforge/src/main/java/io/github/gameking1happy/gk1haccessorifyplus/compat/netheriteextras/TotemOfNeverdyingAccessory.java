package io.github.gameking1happy.gk1haccessorifyplus.compat.netheriteextras;

import io.wispforest.accessories.api.client.AccessoriesRendererRegistry;
import io.wispforest.accessories.api.slot.SlotReference;
import me.pajic.accessorify.accessories.SlotCopyingAccessory;
import me.pajic.accessorify.util.ModUtil;
import me.pajic.accessorify.util.MultiVersionUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.registries.ModifyRegistriesEvent;
import net.neoforged.neoforge.registries.callback.AddCallback;

/**
 * Totem of Neverdying compat.
 */
public class TotemOfNeverdyingAccessory implements SlotCopyingAccessory {

    /**
     * Main init.
     * @param event ModifyRegistriesEvent.
     */
    @SubscribeEvent
    public static void init(ModifyRegistriesEvent event) {
        event.getRegistry(Registries.ITEM).addCallback((AddCallback<Item>) (registry, id, key, value) -> {
            if (key.location().equals(MultiVersionUtil.parse("netheriteextras:totem_of_neverdying"))) {
                MultiVersionUtil.registerAccessory(value, new TotemOfNeverdyingAccessory());
            }
        });
    }

    /**
     * Client init.
     * @param event ModifyRegistriesEvent.
     */
    @SubscribeEvent
    public static void clientInit(ModifyRegistriesEvent event) {
        event.getRegistry(Registries.ITEM).addCallback((AddCallback<Item>) (registry, id, key, value) -> {
            if (key.location().equals(MultiVersionUtil.parse("netheriteextras:totem_of_neverdying"))) {
                AccessoriesRendererRegistry.registerNoRenderer(value);
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
