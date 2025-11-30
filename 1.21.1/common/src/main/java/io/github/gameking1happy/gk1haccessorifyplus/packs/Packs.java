package io.github.gameking1happy.gk1haccessorifyplus.packs;

import io.github.gameking1happy.gk1hcore.packs.AddPacks;
import me.pajic.accessorify.Main;
import org.jetbrains.annotations.NotNull;

import static io.github.gameking1happy.gk1hcore.compat.CompatFlags.*;
import static io.github.gameking1happy.gk1hcore.packs.AddPackPreset.addCDP;
import static io.github.gameking1happy.gk1haccessorifyplus.Main.*;
import static io.github.gameking1happy.gk1hcore.platform.Services.PLATFORM;
import static me.pajic.accessorify.config.SlotMode.UNIQUE_SLOT;

/**
 * Class to add packs.
 */
@SuppressWarnings("unused")
public class Packs implements AddPacks {
    /**
     * @param modContainerOrEvent ModContainer for Fabric, AddPackFindersEvent for NeoForge.
     */
    public void addPacks(@NotNull Object modContainerOrEvent) {
        if (NetExt && Main.CONFIG.accessorySettings.totemOfUndyingAccessory.get()) {
            addCDP(modContainerOrEvent, getModID(), prependPath("totemofneverdying"));
        }
        if (PLATFORM.getPlatformName().equals("NeoForge") && ReinfShu && GK1HTags && Main.CONFIG.accessorySettings.shulkerBoxAccessory.get()) {
            addCDP(modContainerOrEvent, getModID(), "reinfshulker");
        }
    }

    /**
     * Checks Accessorify's slot mode and prepends string accordingly.
     * @param path String to prepend.
     * @return Prepends with "unique/" if {@link me.pajic.accessorify.config.SlotMode#UNIQUE_SLOT}, otherwise prepends with "default/".
     */
    public static @NotNull String prependPath(@NotNull String path) {
        return (Main.CONFIG.slotMode.get() == UNIQUE_SLOT) ? "unique/" : "default/" + path;
    }
    /**
     * @return Returns the mod ID.
     */
    @Override
    public @NotNull String getModID() {
        return MOD_ID;
    }
}
