package cy.jdkdigital.tfccaffeinated.registry;

import cy.jdkdigital.tfccaffeinated.TFCCaffeinated;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.Fluid;

public class CaffeinatedTags
{
    public static class Items {
        public static TagKey<Item> MUGS = ItemTags.create(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "mugs"));
        public static TagKey<Item> TEA_BUCKETS = ItemTags.create(ResourceLocation.parse("forge:buckets/tea"));
        public static TagKey<Item> MILK_BUCKETS = ItemTags.create(ResourceLocation.parse("forge:buckets/milk"));
        public static TagKey<Item> WHISKEY_BUCKETS = ItemTags.create(ResourceLocation.parse("forge:buckets/whiskey"));
        public static TagKey<Item> ICE_CREAMS = ItemTags.create(ResourceLocation.parse("forge:ice_creams"));
    }
    public static class Blocks {

    }
    public static class Fluids {
        public static TagKey<Fluid> TEAS = FluidTags.create(ResourceLocation.parse("forge:teas"));
        public static TagKey<Fluid> WHISKEYS = FluidTags.create(ResourceLocation.parse("forge:whiskeys"));
    }
}
