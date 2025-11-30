package io.github.gameking1happy.gk1haccessorifyplus.data;

import io.github.gameking1happy.gk1haccessorifyplus.data.netheriteextras.ToNDefaultItemTagsProvider;
import io.github.gameking1happy.gk1haccessorifyplus.data.netheriteextras.ToNUniqueItemTagsProvider;
import io.github.gameking1happy.gk1haccessorifyplus.data.reinfshulker.ReinfShulkerItemTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static io.github.gameking1happy.gk1haccessorifyplus.Main.MOD_ID;

/**
 * GatherDataEventSubscribe class for datagen.
 */
@EventBusSubscriber(modid = MOD_ID)
public class GatherDataEventSubscribe {
    /**
     * @param event GatherDataEvent.
     */
    @SubscribeEvent
    public static void gatherData(@NotNull GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        PackOutput ToNDefaultOutput = generator.getPackOutput("default/totemofneverdying");
        PackOutput ToNUniqueOutput = generator.getPackOutput("unique/totemofneverdying");
        PackOutput ReinfShulkerOutput = generator.getPackOutput("reinfshulker");
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        BlockTagsProvider blockTagsProvider = new MyBlockTagsProvider(output, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new ToNDefaultItemTagsProvider(ToNDefaultOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new ToNUniqueItemTagsProvider(ToNUniqueOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new ReinfShulkerItemTagsProvider(ReinfShulkerOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
    }
}