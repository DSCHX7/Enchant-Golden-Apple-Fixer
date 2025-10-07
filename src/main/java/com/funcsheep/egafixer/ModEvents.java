package com.funcsheep.egafixer;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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
            if (entity instanceof Player) {
                Player player = (Player) entity;

                // 清除原有的效果
                player.removeEffect(MobEffects.REGENERATION);
                player.removeEffect(MobEffects.ABSORPTION);
                player.removeEffect(MobEffects.FIRE_RESISTANCE);
                player.removeEffect(MobEffects.DAMAGE_RESISTANCE);

                // 添加 1.8 版本的效果
                // 恢复生命值 V (Regeneration V - 30秒)
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 4));
                // 伤害吸收 IV (Absorption IV - 2分钟)
                player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3));
                // 抗火 (Fire Resistance - 5分钟)
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0));
                // 抗性提升 I (Resistance I - 5分钟)
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0));
            }
        }
    }
}
