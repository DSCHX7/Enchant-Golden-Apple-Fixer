package com.funcsheep.egafixer;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = egafixer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    @SubscribeEvent
    public static void onItemUseFinish(LivingEntityUseItemEvent.Finish event) {
        ItemStack itemStack = event.getItem();
        LivingEntity entity = event.getEntityLiving();

        // 检查是否是附魔金苹果
        if (itemStack.getItem() == Items.ENCHANTED_GOLDEN_APPLE) {
            if (entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) entity;

                // 清除原有的效果
                player.removePotionEffect(Effects.REGENERATION);
                player.removePotionEffect(Effects.ABSORPTION);
                player.removePotionEffect(Effects.FIRE_RESISTANCE);
                player.removePotionEffect(Effects.RESISTANCE);

                // 添加 1.8 版本的效果
                // 恢复生命值 V (Regeneration V - 30秒)
                player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 600, 4));
                // 伤害吸收 IV (Absorption IV - 2分钟)
                player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 2400, 3));
                // 抗火 (Fire Resistance - 5分钟)
                player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 6000, 0));
                // 抗性提升 V (Resistance V - 5分钟)
                player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 6000, 1));

            }
        }
    }
}
