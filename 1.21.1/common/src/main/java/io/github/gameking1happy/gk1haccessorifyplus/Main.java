package io.github.gameking1happy.gk1haccessorifyplus;

import io.github.gameking1happy.gk1haccessorifyplus.packs.Packs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.github.gameking1happy.gk1hcore.Main.addClass;
import static io.github.gameking1happy.gk1hcore.platform.Services.PLATFORM;

/**
 * The main class for the mod.
 */
@SuppressWarnings("CanBeFinal")
public class Main {
    /**
     * The mod ID.
     */
    public static final String MOD_ID = "gk1haccessorifyplus";
    /**
     * The mod name.
     */
    public static final String MOD_NAME = "GK1H Accessorify+";
    /**
     * The mod logger.
     */
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
    /**
     * Common method for initializing the mod.
     */
    public static void init() {
        LOG.info("Hello from Common init on {}! we are currently in a {} environment!", PLATFORM.getPlatformName(), PLATFORM.getEnvironmentName());
        addClass(new Packs());
    }
}