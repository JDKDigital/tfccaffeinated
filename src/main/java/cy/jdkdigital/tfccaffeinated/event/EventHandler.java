package cy.jdkdigital.tfccaffeinated.event;

import cy.jdkdigital.tfccaffeinated.TFCCaffeinated;
import net.dries007.tfc.common.blockentities.TFCBlockEntities;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.HashSet;

@Mod.EventBusSubscriber(modid = TFCCaffeinated.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventHandler
{
    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            // Trees
            modifyBlockEntity(TFCBlockEntities.BERRY_BUSH.get(), BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "plant/coffea_leaves")));
            modifyBlockEntity(TFCBlockEntities.TICK_COUNTER.get(), BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "plant/coffea_growing_branch")));
            modifyBlockEntity(TFCBlockEntities.TICK_COUNTER.get(), BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "plant/coffea_sapling")));
            // Crops
            modifyBlockEntity(TFCBlockEntities.CROP.get(), BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "crop/cassava")));
            modifyBlockEntity(TFCBlockEntities.CROP.get(), BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "crop/tea")));
        });
    }

    private static void modifyBlockEntity(BlockEntityType<?> BE, Block block) {
        var blocks = new HashSet<>(BE.validBlocks);
        blocks.add(block);
        BE.validBlocks = blocks;
    }

    @SubscribeEvent
    public static void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTab().equals(TFCCaffeinated.CAFFEINATED_TAB.get())) {
            TFCCaffeinated.ITEMS.getEntries().forEach(event::accept);
        }
    }
}
