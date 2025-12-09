package io.github.gameking1happy.gk1haccessorifyplus.packs;

import io.github.gameking1happy.gk1hcore.packs.AddPacks;
import me.pajic.accessorify.Accessorify;
import org.jetbrains.annotations.NotNull;

import static io.github.gameking1happy.gk1haccessorifyplus.Main.MOD_ID;
import static io.github.gameking1happy.gk1hcore.compat.CompatFlags.*;
import static io.github.gameking1happy.gk1hcore.packs.AddPackPreset.addCDP;
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
        if (ReinfShu && GK1HTags && Accessorify.CONFIG.accessorySettings.shulkerBoxAccessory.get()) {
            addCDP(modContainerOrEvent, getModID(), "reinfshulker");
        }
    }

    /**
     * Checks Accessorify's slot mode and prepends string accordingly.
     * @param path String to prepend.
     * @return Prepends with "unique/" if {@link me.pajic.accessorify.config.SlotMode#UNIQUE_SLOT}, otherwise prepends with "default/".
     */
    public static @NotNull String prependPath(@NotNull String path) {
        return (Accessorify.CONFIG.slotMode.get() == UNIQUE_SLOT) ? "unique/" + path : "default/" + path;
    }
    /**
     * @return Returns the mod ID.
     */
    @Override
    public @NotNull String getModID() {
        return MOD_ID;
    }
}
