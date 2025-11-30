package io.github.gameking1happy.gk1haccessorifyplus;

import io.github.gameking1happy.gk1haccessorifyplus.compat.netheriteextras.TotemOfNeverdyingAccessory;
import net.fabricmc.api.ModInitializer;

import static io.github.gameking1happy.gk1hcore.compat.CompatFlags.NetExt;
import static me.pajic.accessorify.Main.CONFIG;

/**
 * The Fabric main class for the mod.
 */
@SuppressWarnings("unused")
public class MainFabric implements ModInitializer {
    /**
     * Runs the Fabric mod initializer.
     */
    @Override
    public void onInitialize() {
        Main.init();
        if (CONFIG.accessorySettings.totemOfUndyingAccessory.get()) {
            if (NetExt) {
                TotemOfNeverdyingAccessory.init();
            }
        }
    }
}