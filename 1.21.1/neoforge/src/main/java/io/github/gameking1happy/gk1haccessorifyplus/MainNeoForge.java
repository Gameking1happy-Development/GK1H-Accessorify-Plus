package io.github.gameking1happy.gk1haccessorifyplus;

import io.github.gameking1happy.gk1haccessorifyplus.compat.netheriteextras.TotemOfNeverdyingAccessory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import static io.github.gameking1happy.gk1haccessorifyplus.Main.MOD_ID;

/**
 * The NeoForge main class for the mod.
 */
@SuppressWarnings("unused")
@Mod(MOD_ID)
public class MainNeoForge {
    /**
     * Runs the NeoForge mod initializer.
     * @param modEventBus Mod event bus.
     */
    public MainNeoForge(IEventBus modEventBus) {
        Main.init();
        modEventBus.addListener(TotemOfNeverdyingAccessory::init);
    }
}