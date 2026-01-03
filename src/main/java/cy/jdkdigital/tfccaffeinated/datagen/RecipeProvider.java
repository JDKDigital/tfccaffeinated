package cy.jdkdigital.tfccaffeinated.datagen;

import cy.jdkdigital.tfccaffeinated.TFCCaffeinated;
import cy.jdkdigital.tfccaffeinated.registry.CaffeinatedRegistrator;
import cy.jdkdigital.tfccaffeinated.registry.CaffeinatedTags;
import net.dries007.tfc.common.items.Food;
import net.dries007.tfc.common.items.TFCItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class RecipeProvider extends net.minecraft.data.recipes.RecipeProvider
{
    public RecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CaffeinatedRegistrator.UNFIRED_DECORATED_MUG.get())
                .requires(CaffeinatedRegistrator.UNFIRED_MUG.get())
                .requires(Tags.Items.DYES_BLUE)
                .requires(Tags.Items.DYES_ORANGE)
                .unlockedBy(getHasName(CaffeinatedRegistrator.UNFIRED_DECORATED_MUG.get()), has(CaffeinatedRegistrator.UNFIRED_DECORATED_MUG.get()))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "crafting/unfired_decorated_mug"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CaffeinatedRegistrator.JAR_WITH_STRAW.get())
                .requires(TFCItems.EMPTY_JAR.get())
                .requires(TFCItems.STRAW.get())
                .unlockedBy(getHasName(TFCItems.EMPTY_JAR.get()), has(TFCItems.EMPTY_JAR.get()))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "crafting/jar_with_straw"));

        // Drinks
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CaffeinatedRegistrator.BOBA_TEA.get(), 1)
                .requires(CaffeinatedTags.Items.TEA_BUCKETS)
                .requires(CaffeinatedTags.Items.MILK_BUCKETS)
                .requires(CaffeinatedRegistrator.BOBA_BALLS.get())
                .requires(CaffeinatedRegistrator.JAR_WITH_STRAW.get())
                .unlockedBy("has_tea", has(CaffeinatedTags.Items.TEA_BUCKETS))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "drink/boba_1"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CaffeinatedRegistrator.BOBA_TEA.get(), 2)
                .requires(CaffeinatedTags.Items.TEA_BUCKETS)
                .requires(CaffeinatedTags.Items.MILK_BUCKETS)
                .requires(CaffeinatedRegistrator.BOBA_BALLS.get())
                .requires(CaffeinatedRegistrator.BOBA_BALLS.get())
                .requires(CaffeinatedRegistrator.JAR_WITH_STRAW.get())
                .requires(CaffeinatedRegistrator.JAR_WITH_STRAW.get())
                .unlockedBy("has_tea", has(CaffeinatedTags.Items.TEA_BUCKETS))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "drink/boba_2"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CaffeinatedRegistrator.BOBA_TEA.get(), 3)
                .requires(CaffeinatedTags.Items.TEA_BUCKETS)
                .requires(CaffeinatedTags.Items.MILK_BUCKETS)
                .requires(CaffeinatedRegistrator.BOBA_BALLS.get())
                .requires(CaffeinatedRegistrator.BOBA_BALLS.get())
                .requires(CaffeinatedRegistrator.BOBA_BALLS.get())
                .requires(CaffeinatedRegistrator.JAR_WITH_STRAW.get())
                .requires(CaffeinatedRegistrator.JAR_WITH_STRAW.get())
                .requires(CaffeinatedRegistrator.JAR_WITH_STRAW.get())
                .unlockedBy("has_tea", has(CaffeinatedTags.Items.TEA_BUCKETS))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "drink/boba_3"));

        drinkRecipeBuilder(consumer, CaffeinatedRegistrator.GREEN_TEA, CaffeinatedRegistrator.MUG.get(), 4, "tfccaffeinated:green_tea");
        drinkRecipeBuilder(consumer, CaffeinatedRegistrator.GLAZED_GREEN_TEA, CaffeinatedRegistrator.GLAZED_MUG.get(), 4, "tfccaffeinated:green_tea");

        drinkRecipeBuilder(consumer, CaffeinatedRegistrator.BLACK_TEA, CaffeinatedRegistrator.MUG.get(), 4, "tfccaffeinated:black_tea");
        drinkRecipeBuilder(consumer, CaffeinatedRegistrator.GLAZED_BLACK_TEA, CaffeinatedRegistrator.GLAZED_MUG.get(), 4, "tfccaffeinated:black_tea");

        drinkRecipeBuilder(consumer, CaffeinatedRegistrator.DOUBLE_ESPRESSO, CaffeinatedRegistrator.MUG.get(), 2, "tfccaffeinated:espresso");
        drinkRecipeBuilder(consumer, CaffeinatedRegistrator.GLAZED_DOUBLE_ESPRESSO, CaffeinatedRegistrator.GLAZED_MUG.get(), 2, "tfccaffeinated:espresso");

        drinkRecipeBuilder(consumer, CaffeinatedRegistrator.BLACK_COFFEE, CaffeinatedRegistrator.MUG.get(), 4, "tfccaffeinated:black_coffee");
        drinkRecipeBuilder(consumer, CaffeinatedRegistrator.GLAZED_BLACK_COFFEE, CaffeinatedRegistrator.GLAZED_MUG.get(), 4, "tfccaffeinated:black_coffee");

        drinkRecipeBuilder(consumer, CaffeinatedRegistrator.IRISH_COFFEE, CaffeinatedRegistrator.MUG.get(), 5, List.of(CaffeinatedRegistrator.WHIPPED_CREAM.get()), null, "tfccaffeinated:black_coffee", "tfccaffeinated:black_coffee", "#forge:buckets/whiskey");
        drinkRecipeBuilder(consumer, CaffeinatedRegistrator.GLAZED_IRISH_COFFEE, CaffeinatedRegistrator.GLAZED_MUG.get(), 5, List.of(CaffeinatedRegistrator.WHIPPED_CREAM.get()), null, "tfccaffeinated:black_coffee", "tfccaffeinated:black_coffee", "#forge:buckets/whiskey");

        drinkRecipeBuilder(consumer, CaffeinatedRegistrator.ROMANO, CaffeinatedRegistrator.MUG.get(), 4, List.of(TFCItems.FOOD.get(Food.LEMON).get()), null, "tfccaffeinated:espresso");
        drinkRecipeBuilder(consumer, CaffeinatedRegistrator.GLAZED_ROMANO, CaffeinatedRegistrator.GLAZED_MUG.get(), 4, List.of(CaffeinatedRegistrator.WHIPPED_CREAM.get()), null, "tfccaffeinated:espresso");

        drinkRecipeBuilder(consumer, CaffeinatedRegistrator.AFFOGATO, CaffeinatedRegistrator.MUG.get(), 4, null, List.of(CaffeinatedTags.Items.ICE_CREAMS), "tfccaffeinated:espresso");
        drinkRecipeBuilder(consumer, CaffeinatedRegistrator.GLAZED_AFFOGATO, CaffeinatedRegistrator.GLAZED_MUG.get(), 4, null, List.of(CaffeinatedTags.Items.ICE_CREAMS), "tfccaffeinated:espresso");

        drinkRecipeBuilder(consumer, CaffeinatedRegistrator.LATTE, CaffeinatedRegistrator.MUG.get(), 4, "tfccaffeinated:espresso", "#forge:buckets/milk", "#forge:buckets/milk", "#forge:buckets/milk");
        drinkRecipeBuilder(consumer, CaffeinatedRegistrator.GLAZED_LATTE, CaffeinatedRegistrator.GLAZED_MUG.get(), 4, "tfccaffeinated:espresso", "#forge:buckets/milk", "#forge:buckets/milk", "#forge:buckets/milk");

        drinkRecipeBuilder(consumer, CaffeinatedRegistrator.AMERICANO, CaffeinatedRegistrator.MUG.get(), 4, List.of(Items.WATER_BUCKET), null, "tfccaffeinated:espresso");
        drinkRecipeBuilder(consumer, CaffeinatedRegistrator.GLAZED_AMERICANO, CaffeinatedRegistrator.GLAZED_MUG.get(), 4, List.of(Items.WATER_BUCKET), null, "tfccaffeinated:espresso");

        drinkRecipeBuilder(consumer, CaffeinatedRegistrator.MOCHA, CaffeinatedRegistrator.MUG.get(), 4, List.of(CaffeinatedRegistrator.WHIPPED_CREAM.get()), null, "tfccaffeinated:espresso", "firmalife:chocolate");
        drinkRecipeBuilder(consumer, CaffeinatedRegistrator.GLAZED_MOCHA, CaffeinatedRegistrator.GLAZED_MUG.get(), 4, List.of(CaffeinatedRegistrator.WHIPPED_CREAM.get()), null, "tfccaffeinated:espresso", "firmalife:chocolate");
    }

    private static void drinkRecipeBuilder(Consumer<FinishedRecipe> consumer, RegistryObject<Item> drink, Item mug, Integer maxCount, String... fluids) {
        drinkRecipeBuilder(consumer, drink, mug, maxCount, null, null, fluids);
    }
    private static void drinkRecipeBuilder(Consumer<FinishedRecipe> consumer, RegistryObject<Item> drink, Item mug, Integer maxCount, @Nullable List<Item> additionalItems, @Nullable List<TagKey<Item>> additionalTags, String... fluids) {
        for (int count = 1; count <= maxCount; count++) {
            var builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, drink.get(), count);

            for (String fluid: fluids) {
                if (fluid.startsWith("#")) {
                    builder.requires(ItemTags.create(ResourceLocation.parse(fluid.replace("#", ""))));
                } else {
                    builder.requires(CaffeinatedRegistrator.bucket(fluid));
                }
            }

            if (additionalItems != null && !additionalItems.isEmpty()) {
                additionalItems.forEach(builder::requires);
            }
            if (additionalTags != null && !additionalTags.isEmpty()) {
                additionalTags.forEach(builder::requires);
            }

            for (int i = 1; i <= count; i++) {
                builder.requires(mug);
            }

            builder.unlockedBy(getHasName(mug), has(mug));

            builder
                .save(consumer, ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "drink/" + drink.getId().getPath() + "_" + count));
        }
    }
}
