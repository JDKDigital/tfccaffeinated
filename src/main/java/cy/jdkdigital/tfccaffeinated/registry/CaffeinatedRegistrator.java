package cy.jdkdigital.tfccaffeinated.registry;

import cy.jdkdigital.tfccaffeinated.TFCCaffeinated;
import cy.jdkdigital.tfccaffeinated.common.item.CaffeineDrinkItem;
import net.dries007.tfc.common.blockentities.BerryBushBlockEntity;
import net.dries007.tfc.common.blockentities.CropBlockEntity;
import net.dries007.tfc.common.blockentities.FarmlandBlockEntity;
import net.dries007.tfc.common.blockentities.TFCBlockEntities;
import net.dries007.tfc.common.blocks.ExtendedProperties;
import net.dries007.tfc.common.blocks.TFCBlockStateProperties;
import net.dries007.tfc.common.blocks.crop.*;
import net.dries007.tfc.common.blocks.plant.fruit.*;
import net.dries007.tfc.common.fluids.*;
import net.dries007.tfc.common.items.TFCItems;
import net.dries007.tfc.util.climate.ClimateRange;
import net.dries007.tfc.util.registry.RegistrationHelpers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class CaffeinatedRegistrator
{
    public static void init() {
        registerTree("coffea");

        registerCrop("cassava", true, FarmlandBlockEntity.NutrientType.POTASSIUM);
        registerCrop("tea", false, FarmlandBlockEntity.NutrientType.NITROGEN);
    }

    public static RegistryObject<Item> UNFIRED_MUG = registerItem("unfired_mug");
    public static RegistryObject<Item> UNFIRED_DECORATED_MUG = registerItem("unfired_decorated_mug");
    public static RegistryObject<Item> MUG = registerItem("mug");
    public static RegistryObject<Item> GLAZED_MUG = registerItem("glazed_mug");
    public static RegistryObject<Item> JAR_WITH_STRAW = registerItem("jar_with_straw");
    public static RegistryObject<Item> COFEE_BEAN = registerItem("food/coffee_beans");
    public static RegistryObject<Item> ROASTED_COFEE_BEAN = registerItem("food/roasted_coffee_beans");
    public static RegistryObject<Item> GROUND_COFEE = registerItem("food/ground_coffee");
    public static RegistryObject<Item> TEA_LEAVES = registerItem("food/tea_leaves");
    public static RegistryObject<Item> BLACK_TEA_LEAVES = registerItem("food/black_tea_leaves");
    public static RegistryObject<Item> CASSAVA = registerItem("food/cassava");
    public static RegistryObject<Item> TAPIOCA_STARCH = registerItem("food/tapioca_starch");
    public static RegistryObject<Item> RAW_BOBA_BALLS = registerItem("food/raw_boba_balls");
    public static RegistryObject<Item> BOBA_BALLS = registerItem("food/boba_balls");
    public static RegistryObject<Item> WHIPPED_CREAM = registerItem("food/whipped_cream");

    static FoodProperties DRINK = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.1F).alwaysEat().build();
    public static RegistryObject<Item> BLACK_COFFEE = registerItem("drink/black_coffee", () -> new CaffeineDrinkItem(new Item.Properties().food(DRINK).craftRemainder(MUG.get())));
    public static RegistryObject<Item> DOUBLE_ESPRESSO = registerItem("drink/double_espresso", () -> new CaffeineDrinkItem(new Item.Properties().food(DRINK).craftRemainder(MUG.get())));
    public static RegistryObject<Item> LATTE = registerItem("drink/latte", () -> new CaffeineDrinkItem(new Item.Properties().food(DRINK).craftRemainder(MUG.get())));
    public static RegistryObject<Item> MOCHA = registerItem("drink/mocha", () -> new CaffeineDrinkItem(new Item.Properties().food(DRINK).craftRemainder(MUG.get())));
    public static RegistryObject<Item> AMERICANO = registerItem("drink/americano", () -> new CaffeineDrinkItem(new Item.Properties().food(DRINK).craftRemainder(MUG.get())));
    public static RegistryObject<Item> ROMANO = registerItem("drink/romano", () -> new CaffeineDrinkItem(new Item.Properties().food(DRINK).craftRemainder(MUG.get())));
    public static RegistryObject<Item> IRISH_COFFEE = registerItem("drink/irish_coffee", () -> new CaffeineDrinkItem(new Item.Properties().food(DRINK).craftRemainder(MUG.get())));
    public static RegistryObject<Item> AFFOGATO = registerItem("drink/affogato", () -> new CaffeineDrinkItem(new Item.Properties().food(DRINK).craftRemainder(MUG.get())));
    public static RegistryObject<Item> GREEN_TEA = registerItem("drink/green_tea", () -> new CaffeineDrinkItem(new Item.Properties().food(DRINK).craftRemainder(MUG.get())));
    public static RegistryObject<Item> BLACK_TEA = registerItem("drink/black_tea", () -> new CaffeineDrinkItem(new Item.Properties().food(DRINK).craftRemainder(MUG.get())));
    public static RegistryObject<Item> GLAZED_BLACK_COFFEE = registerItem("gdrink/black_coffee", () -> new CaffeineDrinkItem(new Item.Properties().food(DRINK).craftRemainder(MUG.get())));
    public static RegistryObject<Item> GLAZED_DOUBLE_ESPRESSO = registerItem("gdrink/double_espresso", () -> new CaffeineDrinkItem(new Item.Properties().food(DRINK).craftRemainder(MUG.get())));
    public static RegistryObject<Item> GLAZED_LATTE = registerItem("gdrink/latte", () -> new CaffeineDrinkItem(new Item.Properties().food(DRINK).craftRemainder(MUG.get())));
    public static RegistryObject<Item> GLAZED_MOCHA = registerItem("gdrink/mocha", () -> new CaffeineDrinkItem(new Item.Properties().food(DRINK).craftRemainder(MUG.get())));
    public static RegistryObject<Item> GLAZED_AMERICANO = registerItem("gdrink/americano", () -> new CaffeineDrinkItem(new Item.Properties().food(DRINK).craftRemainder(MUG.get())));
    public static RegistryObject<Item> GLAZED_ROMANO = registerItem("gdrink/romano", () -> new CaffeineDrinkItem(new Item.Properties().food(DRINK).craftRemainder(MUG.get())));
    public static RegistryObject<Item> GLAZED_IRISH_COFFEE = registerItem("gdrink/irish_coffee", () -> new CaffeineDrinkItem(new Item.Properties().food(DRINK).craftRemainder(MUG.get())));
    public static RegistryObject<Item> GLAZED_AFFOGATO = registerItem("gdrink/affogato", () -> new CaffeineDrinkItem(new Item.Properties().food(DRINK).craftRemainder(MUG.get())));
    public static RegistryObject<Item> GLAZED_GREEN_TEA = registerItem("gdrink/green_tea", () -> new CaffeineDrinkItem(new Item.Properties().food(DRINK).craftRemainder(MUG.get())));
    public static RegistryObject<Item> GLAZED_BLACK_TEA = registerItem("gdrink/black_tea", () -> new CaffeineDrinkItem(new Item.Properties().food(DRINK).craftRemainder(MUG.get())));
    public static RegistryObject<Item> BOBA_TEA = registerItem("drink/boba_tea", () -> new CaffeineDrinkItem(new Item.Properties().food(DRINK).craftRemainder(TFCItems.EMPTY_JAR.get())));


    public static FluidRegistryObject<MixingFluid> ESPRESSO_FLUID = registerFluid("espresso", 0xffc56a2a);
    public static FluidRegistryObject<MixingFluid> BLACK_COFFEE_FLUID = registerFluid("black_coffee", 0xff221414);
    public static FluidRegistryObject<MixingFluid> GREEN_TEA_FLUID = registerFluid("green_tea", 0xff8e891d);
    public static FluidRegistryObject<MixingFluid> BLACK_TEA_FLUID = registerFluid("black_tea", 0xff440507);

    public static RegistryObject<Item> registerItem(String name) {
        return registerItem(name, () -> new Item(new Item.Properties()));
    }

    public static RegistryObject<Item> registerItem(String name, FoodProperties food) {
        return registerItem(name, () -> new Item(new Item.Properties().food(food)));
    }

    public static RegistryObject<Item> registerItem(String name, ItemSupplier<Item> itemFactory) {
        return TFCCaffeinated.ITEMS.register(name, () -> itemFactory.create(new Item.Properties()));
    }

    public static RegistryObject<Item> registerItem(String name, Supplier<Item> supplier) {
        return TFCCaffeinated.ITEMS.register(name, supplier);
    }

    public static RegistryObject<Block> registerBlock(String name, Supplier<Block> supplier) {
        return registerBlock(name, supplier, true);
    }

    public static RegistryObject<Block> registerBlock(String name, Supplier<Block> supplier, boolean hasItem) {
        var block = TFCCaffeinated.BLOCKS.register(name, supplier);
        if (hasItem) {
            registerItem(name, () -> new BlockItem(block.get(), new Item.Properties()));
        }
        return block;
    }

    public static FluidRegistryObject<MixingFluid> registerFluid(String name, Integer color) {
        // fluid bucket
        var bucketItem = registerItem("bucket/" + name, () -> new BucketItem(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, name)), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
        // fluid block
        registerBlock("fluid/" + name, () -> new LiquidBlock((FlowingFluid) BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "flowing_" + name)), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()), false);

        return registerFluid(
                name,
                properties -> properties.block(RegistryObject.create(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "fluid/" + name), ForgeRegistries.BLOCKS)).bucket(bucketItem),
                makeFluidProperties()
                        .descriptionId("fluid.tfccaffeinated." + name)
                        .canConvertToSource(false),
                new FluidTypeClientProperties(color, TFCFluids.WATER_STILL, TFCFluids.WATER_FLOW, TFCFluids.WATER_OVERLAY, null),
                MixingFluid.Source::new,
                MixingFluid.Flowing::new
        );
    }

    static private FluidType.Properties makeFluidProperties() {
        return FluidType.Properties.create()
                .adjacentPathType(BlockPathTypes.WATER)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                .canConvertToSource(true)
                .canDrown(true)
                .canExtinguish(true)
                .canHydrate(false)
                .canPushEntity(true)
                .canSwim(true)
                .supportsBoating(true);
    }

    // copied from Firmalife FLFluids.java
    private static <F extends FlowingFluid> FluidRegistryObject<F> registerFluid(String name, Consumer<ForgeFlowingFluid.Properties> builder, FluidType.Properties typeProperties, FluidTypeClientProperties clientProperties, Function<ForgeFlowingFluid.Properties, F> sourceFactory, Function<ForgeFlowingFluid.Properties, F> flowingFactory)
    {
        // Names `metal/foo` to `metal/flowing_foo`
        final int index = name.lastIndexOf('/');
        final String flowingName = index == -1 ? "flowing_" + name : name.substring(0, index) + "/flowing_" + name.substring(index + 1);

        return RegistrationHelpers.registerFluid(TFCFluids.FLUID_TYPES, TFCCaffeinated.FLUIDS, name, name, flowingName, builder, () -> new ExtendedFluidType(typeProperties, clientProperties), sourceFactory, flowingFactory);
    }

    public static void registerTree(String name) {
        var climateRange = ClimateRange.MANAGER.register(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "plant/" + name + "_tree"));
        var stages = new Lifecycle[] {
                Lifecycle.DORMANT,
                Lifecycle.DORMANT,
                Lifecycle.HEALTHY,
                Lifecycle.HEALTHY,
                Lifecycle.FLOWERING,
                Lifecycle.FRUITING,
                Lifecycle.DORMANT,
                Lifecycle.DORMANT,
                Lifecycle.HEALTHY,
                Lifecycle.HEALTHY,
                Lifecycle.FLOWERING,
                Lifecycle.FRUITING,
        };

        var leaves = registerBlock("plant/" + name + "_leaves", () -> new FruitTreeLeavesBlock(ExtendedProperties.of().mapColor(FruitTreeLeavesBlock::getMapColor).strength(0.5F).sound(SoundType.GRASS).randomTicks().noOcclusion().blockEntity(TFCBlockEntities.BERRY_BUSH).serverTicks(BerryBushBlockEntity::serverTick).flammableLikeLeaves(), COFEE_BEAN, stages, climateRange, 0xffBE8C53));
        var branch = registerBlock("plant/" + name + "_branch", () -> new FruitTreeBranchBlock(ExtendedProperties.of(MapColor.WOOD).sound(SoundType.SCAFFOLDING).randomTicks().strength(1.0f).pushReaction(PushReaction.DESTROY).flammableLikeLogs(), climateRange), false);
        var growingBranch = registerBlock("plant/" + name + "_growing_branch", () -> new GrowingFruitTreeBranchBlock(ExtendedProperties.of(MapColor.WOOD).sound(SoundType.SCAFFOLDING).randomTicks().strength(1.0f).pushReaction(PushReaction.DESTROY).blockEntity(TFCBlockEntities.TICK_COUNTER).flammableLikeLogs(), branch, leaves, climateRange), false);
        var sapling = registerBlock("plant/" + name + "_sapling", () -> new FruitTreeSaplingBlock(ExtendedProperties.of(MapColor.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.GRASS).blockEntity(TFCBlockEntities.TICK_COUNTER).flammableLikeLeaves(), growingBranch, 10, climateRange, stages));
        var pottedSapling = registerBlock("plant/potted/" + name + "_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, sapling, BlockBehaviour.Properties.copy(Blocks.POTTED_ACACIA_SAPLING)), false);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "plant/" + name + "_sapling"), pottedSapling);
    }

    static Map<String, RegistryObject<Block>> crops = new HashMap<>();
    public static void registerCrop(String name, boolean doubleCrop, FarmlandBlockEntity.NutrientType primaryNutrient) {
        var climateRange = ClimateRange.MANAGER.register(ResourceLocation.fromNamespaceAndPath(TFCCaffeinated.MODID, "crop/" + name));

        var seeds = registerItem("seeds/" + name + "_seeds", () -> new ItemNameBlockItem(crops.get(name).get(), new Item.Properties()));

        // dead
        var deadBlock = doubleCrop ?
                registerBlock("dead_crop/dead_" + name, () -> new DeadClimbingCropBlock(dead(), climateRange), false) :
                registerBlock("dead_crop/dead_" + name, () -> new DeadCropBlock(dead(), climateRange), false);

        // plant
        var cropBlock = doubleCrop ?
                registerBlock("crop/" + name, () -> new DoubleCropBlock(doubleCrop(), 2, 6, deadBlock, seeds, primaryNutrient, climateRange)
                {
                    @Override
                    public IntegerProperty getAgeProperty() {
                        return TFCBlockStateProperties.getAgeProperty(6);
                    }
                }, false) :
                registerBlock("crop/" + name, () -> new DefaultCropBlock(crop(), 6, deadBlock, seeds, primaryNutrient, climateRange)
                {
                    @Override
                    public IntegerProperty getAgeProperty() {
                        return TFCBlockStateProperties.getAgeProperty(6);
                    }
                }, false);
        crops.put(name, cropBlock);

        // wild
        var wildBlock = doubleCrop ?
                registerBlock("wild_crop/wild_" + name, () -> new WildDoubleCropBlock(dead().randomTicks())) :
                registerBlock("wild_crop/wild_" + name, () -> new WildCropBlock(dead().randomTicks()));
    }

    private static ExtendedProperties doubleCrop() {
        return dead().blockEntity(TFCBlockEntities.CROP).serverTicks(CropBlockEntity::serverTickBottomPartOnly);
    }

    private static ExtendedProperties crop() {
        return dead().blockEntity(TFCBlockEntities.CROP).serverTicks(CropBlockEntity::serverTick);
    }

    private static ExtendedProperties dead() {
        return ExtendedProperties.of(MapColor.PLANT).noCollission().randomTicks().strength(0.4F).sound(SoundType.CROP).flammable(60, 30);
    }

    public static Item bucket(String name) {
        var rL = ResourceLocation.parse(name);
        return bucket(rL.getNamespace(), rL.getPath());
    }

    public static Item bucket(String modid, String name) {
        return BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(modid, "bucket/" + name));
    }

    @FunctionalInterface
    public interface ItemSupplier<T extends Item>
    {
        T create(Item.Properties properties);
    }
}
