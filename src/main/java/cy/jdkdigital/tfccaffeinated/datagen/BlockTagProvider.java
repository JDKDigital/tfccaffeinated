package cy.jdkdigital.tfccaffeinated.datagen;

import cy.jdkdigital.tfccaffeinated.TFCCaffeinated;
import cy.jdkdigital.tfccaffeinated.registry.CaffeinatedRegistrator;
import net.dries007.tfc.common.TFCTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends BlockTagsProvider
{
    public BlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
        super(output, provider, TFCCaffeinated.MODID, helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.LEAVES).add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "plant/coffea_leaves")));
        tag(BlockTags.SAPLINGS).add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "plant/coffea_sapling")));
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "plant/coffea_branch")))
                .add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "plant/coffea_growing_branch")));

        tag(TFCTags.Blocks.FRUIT_TREE_LEAVES)
                .add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "plant/coffea_leaves")));
        tag(TFCTags.Blocks.FRUIT_TREE_BRANCH)
                .add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "plant/coffea_branch")))
                .add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "plant/coffea_growing_branch")));
        tag(TFCTags.Blocks.FRUIT_TREE_SAPLING)
                .add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "plant/coffea_sapling")));

        tag(BlockTags.REPLACEABLE)
                .add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "fluid/espresso")))
                .add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "fluid/black_coffee")))
                .add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "fluid/green_tea")))
                .add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "fluid/black_tea")));

        tag(BlockTags.create(ResourceLocation.parse("tfc:crops")))
                .add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "crop/cassava")))
                .add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "crop/tea")));
        tag(BlockTags.create(ResourceLocation.parse("tfc:plants")))
                .add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "wild_crop/wild_cassava")))
                .add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "wild_crop/wild_tea")));
        tag(BlockTags.create(ResourceLocation.parse("tfc:wild_crops")))
                .add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "wild_crop/wild_cassava")))
                .add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "wild_crop/wild_tea")));
        tag(BlockTags.create(ResourceLocation.parse("tfc:can_be_snow_piled")))
                .add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "wild_crop/wild_cassava")))
                .add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "wild_crop/wild_tea")));
        tag(BlockTags.create(ResourceLocation.parse("tfc:mineable_with_sharp_tool")))
                .add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "crop/cassava")))
                .add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "crop/tea")))
                .add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "wild_crop/wild_cassava")))
                .add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "wild_crop/wild_tea")))
                .add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "dead_crop/dead_cassava")))
                .add(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "dead_crop/dead_tea")));
    }

    @Override
    public String getName() {
        return "Productive Farming Block Tags Provider";
    }
}
