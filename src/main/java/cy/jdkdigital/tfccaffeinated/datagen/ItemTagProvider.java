package cy.jdkdigital.tfccaffeinated.datagen;

import cy.jdkdigital.tfccaffeinated.TFCCaffeinated;
import cy.jdkdigital.tfccaffeinated.registry.CaffeinatedRegistrator;
import cy.jdkdigital.tfccaffeinated.registry.CaffeinatedTags;
import net.dries007.tfc.common.TFCTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends ItemTagsProvider
{
    public ItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> future, CompletableFuture<TagLookup<Block>> provider, ExistingFileHelper helper) {
        super(output, future, provider, TFCCaffeinated.MODID, helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(CaffeinatedTags.Items.MUGS)
                .add(CaffeinatedRegistrator.MUG.get(), CaffeinatedRegistrator.GLAZED_MUG.get());
        tag(CaffeinatedTags.Items.TEA_BUCKETS)
                .add(CaffeinatedRegistrator.bucket("tfccaffeinated", "black_tea"), CaffeinatedRegistrator.bucket("tfccaffeinated", "green_tea"));
        tag(CaffeinatedTags.Items.MILK_BUCKETS)
                .add(Items.MILK_BUCKET)
                .add(CaffeinatedRegistrator.bucket("firmalife", "coconut_milk"))
                .add(CaffeinatedRegistrator.bucket("firmalife", "yak_milk"))
                .add(CaffeinatedRegistrator.bucket("firmalife", "goat_milk"));
        tag(CaffeinatedTags.Items.ICE_CREAMS)
                .add(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("firmalife", "food/vanilla_ice_cream")))
                .add(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("firmalife", "food/strawberry_ice_cream")))
                .add(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("firmalife", "food/chocolate_ice_cream")));
        tag(CaffeinatedTags.Items.WHISKEY_BUCKETS)
                .add(CaffeinatedRegistrator.bucket("tfc", "whiskey"))
                .add(CaffeinatedRegistrator.bucket("tfc", "corn_whiskey"))
                .add(CaffeinatedRegistrator.bucket("tfc", "rye_whiskey"));
        tag(ItemTags.create(ResourceLocation.parse("tfc:clay_recycle_5"))).add(CaffeinatedRegistrator.UNFIRED_MUG.get(), CaffeinatedRegistrator.UNFIRED_DECORATED_MUG.get());

        tag(ItemTags.create(ResourceLocation.parse("tfc:seeds")))
                .add(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "seeds/cassava_seeds")))
                .add(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "seeds/tea_seeds")));
        tag(ItemTags.create(ResourceLocation.parse("tfc:wild_crops")))
                .add(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "wild_crop/wild_cassava")))
                .add(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "wild_crop/wild_tea")));
    }

    @Override
    public String getName() {
        return "TFC: Caffeinated Item Tags Provider";
    }
}
