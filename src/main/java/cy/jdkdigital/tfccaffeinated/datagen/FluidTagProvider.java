package cy.jdkdigital.tfccaffeinated.datagen;

import cy.jdkdigital.tfccaffeinated.registry.CaffeinatedRegistrator;
import cy.jdkdigital.tfccaffeinated.registry.CaffeinatedTags;
import net.dries007.tfc.common.TFCTags;
import net.dries007.tfc.common.fluids.TFCFluids;
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

        tag(CaffeinatedTags.Fluids.TEAS)
                .add(CaffeinatedRegistrator.BLACK_TEA_FLUID.getSource())
                .add(CaffeinatedRegistrator.GREEN_TEA_FLUID.getSource());

        tag(CaffeinatedTags.Fluids.WHISKEYS)
                .addOptional(ResourceLocation.parse("tfc:whiskey"))
                .addOptional(ResourceLocation.parse("tfc:corn_whiskey"))
                .addOptional(ResourceLocation.parse("tfc:rye_whiskey"));
    }

    @Override
    public String getName() {
        return "TFC: Caffeinated Fluid Tags Provider";
    }
}
