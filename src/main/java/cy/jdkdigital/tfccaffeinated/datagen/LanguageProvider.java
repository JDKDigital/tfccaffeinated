package cy.jdkdigital.tfccaffeinated.datagen;

import cy.jdkdigital.tfccaffeinated.TFCCaffeinated;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemNameBlockItem;

public class LanguageProvider extends net.minecraftforge.common.data.LanguageProvider
{
    public LanguageProvider(PackOutput output) {
        super(output, TFCCaffeinated.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        TFCCaffeinated.BLOCKS.getEntries().forEach(holder -> {
            add(holder.get(), capName(BuiltInRegistries.BLOCK.getKey(holder.get()).getPath()));
        });
        TFCCaffeinated.ITEMS.getEntries().forEach(holder -> {
            if (!(holder.get() instanceof BlockItem) || holder.get() instanceof ItemNameBlockItem) {
                var regName = BuiltInRegistries.ITEM.getKey(holder.get()).getPath();
                add(holder.get(), capName(regName));
            }
        });

        add("fluid.tfccaffeinated.espresso", "Espresso");
        add("fluid.tfccaffeinated.black_coffee", "Black Coffee");
        add("fluid.tfccaffeinated.black_tea", "Black Tea");
        add("fluid.tfccaffeinated.green_tea", "Green Tea");
    }

    @Override
    public String getName() {
        return "TFC: Caffeinated translation provider";
    }

    private String capName(String name) {
        String[] subNameParts = name.replace("growing_", "").split("/");
        String[] nameParts = subNameParts[subNameParts.length - 1].split("_");

        for (int i = 0; i < nameParts.length; i++) {
            nameParts[i] = nameParts[i].substring(0, 1).toUpperCase() + nameParts[i].substring(1);
        }

        return String.join(" ", nameParts);
    }
}
