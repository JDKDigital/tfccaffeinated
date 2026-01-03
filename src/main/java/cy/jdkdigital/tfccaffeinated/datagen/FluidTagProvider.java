package cy.jdkdigital.tfccaffeinated.datagen;

import cy.jdkdigital.tfccaffeinated.registry.CaffeinatedRegistrator;
import net.dries007.tfc.common.TFCTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;

import java.util.concurrent.CompletableFuture;

public class FluidTagProvider extends FluidTagsProvider
{
    public FluidTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider) {
        super(pOutput, pProvider);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(FluidTags.create(ResourceLocation.parse("tfc:ingredients")))
                .add(CaffeinatedRegistrator.ESPRESSO_FLUID.getSource())
                .add(CaffeinatedRegistrator.BLACK_COFFEE_FLUID.getSource())
                .add(CaffeinatedRegistrator.BLACK_TEA_FLUID.getSource())
                .add(CaffeinatedRegistrator.GREEN_TEA_FLUID.getSource());
    }

    @Override
    public String getName() {
        return "TFC: Caffeinated Fluid Tags Provider";
    }
}
