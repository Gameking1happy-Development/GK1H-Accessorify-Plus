package io.github.gameking1happy.gk1haccessorifyplus.client;

import io.github.gameking1happy.gk1haccessorifyplus.compat.netheriteextras.TotemOfNeverdyingAccessory;
import net.fabricmc.api.ClientModInitializer;

import static io.github.gameking1happy.gk1hcore.compat.CompatFlags.NetExt;
import static me.pajic.accessorify.Main.CONFIG;

/**
 * Fabric client-side code.
 */
@SuppressWarnings("unused")
public class FabricClient implements ClientModInitializer {
    /**
     * Runs the Fabric mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {
        Client.initclient();
        if (CONFIG.accessorySettings.totemOfUndyingAccessory.get()) {
            if (NetExt) {
                TotemOfNeverdyingAccessory.clientInit();
            }
        }
    }
}
