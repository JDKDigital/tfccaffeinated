package cy.jdkdigital.tfccaffeinated.common.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class CaffeineDrinkItem extends Item
{
    public CaffeineDrinkItem(Properties pProperties) {
        super(pProperties);
    }

    public static float getOverride(ItemStack stack) {
        if (stack.getTag() != null && !stack.getTag().getString("mug").isEmpty()) {
            return 1f;
        }
        return 0f;
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        var remainder = stack.getItem().getCraftingRemainingItem();
        if (entity instanceof ServerPlayer player) {
            CriteriaTriggers.CONSUME_ITEM.trigger(player, stack);
            player.awardStat(Stats.ITEM_USED.get(this));
            // TODO apply effects
//            player.removeEffect(MobEffects.POISON);
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2400), null);
        }
        super.finishUsingItem(stack, level, entity);

        if (stack.isEmpty()) {
            return new ItemStack(remainder);
        } else {
            if (entity instanceof Player player && !player.getAbilities().instabuild) {
                ItemStack mug = new ItemStack(remainder);
                if (!player.getInventory().add(mug)) {
                    player.drop(mug, false);
                }
            }
            return stack;
        }
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }
}
