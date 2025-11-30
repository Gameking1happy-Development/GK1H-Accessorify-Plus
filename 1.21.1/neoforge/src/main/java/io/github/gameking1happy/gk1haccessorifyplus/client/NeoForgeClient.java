package io.github.gameking1happy.gk1haccessorifyplus.client;

import io.github.gameking1happy.gk1haccessorifyplus.compat.netheriteextras.TotemOfNeverdyingAccessory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import static io.github.gameking1happy.gk1haccessorifyplus.Main.MOD_ID;

/**
 * NeoForge client-side code.
 */
@SuppressWarnings("unused")
@Mod(value = MOD_ID, dist = Dist.CLIENT)
public class NeoForgeClient {
    /**
     * Runs the NeoForge client-side mod initializer.
     * @param modEventBus Mod event bus.
     */
    public NeoForgeClient(IEventBus modEventBus) {
        Client.initclient();
        modEventBus.addListener(TotemOfNeverdyingAccessory::clientInit);
    }
}
