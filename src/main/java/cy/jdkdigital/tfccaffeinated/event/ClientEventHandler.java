package cy.jdkdigital.tfccaffeinated.event;

import cy.jdkdigital.tfccaffeinated.TFCCaffeinated;
import cy.jdkdigital.tfccaffeinated.common.item.CaffeineDrinkItem;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.model.DynamicFluidContainerModel;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = TFCCaffeinated.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler
{
    @SubscribeEvent
    public static void init(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            TFCCaffeinated.ITEMS.getEntries().forEach(item -> {
                if (item.get() instanceof CaffeineDrinkItem) {
                    ItemProperties.register(item.get(), ResourceLocation.withDefaultNamespace("filled"), (stack, level, entity, i) -> CaffeineDrinkItem.getOverride(stack));
                }
            });
        });
    }

    @SubscribeEvent
    public static void onItemColors(RegisterColorHandlersEvent.Item event) {
        TFCCaffeinated.FLUIDS.getEntries().forEach(entry -> {
            if (entry.getKey().location().getNamespace().equals(TFCCaffeinated.MODID)) {
                event.register(new DynamicFluidContainerModel.Colors(), entry.get().getBucket());
            }
        });
    }
}
