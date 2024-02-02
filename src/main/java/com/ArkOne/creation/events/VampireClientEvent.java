package com.ArkOne.creation.events;

import com.ArkOne.creation.Creation;
import com.ArkOne.creation.util.RegistryHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Creation.Mod_ID,bus = Mod.EventBusSubscriber.Bus.FORGE,value = Dist.CLIENT)
public class VampireClientEvent {

    @SubscribeEvent //事件处理方法,在特定的事件发生时调用
    public static void Vampire(AttackEntityEvent event){
        // 检查攻击者是否是玩家，被攻击的实体是否存在
        if (event.getPlayer() != null && event.getTarget() != null) {
            PlayerEntity player = (PlayerEntity) event.getPlayer();
            Entity target = (Entity) event.getTarget();

            // 获取玩家手持的物品
            ItemStack heldItem = player.getMainHandItem();

            if (!player.getMainHandItem().isEmpty() && heldItem.getItem().getRegistryName().equals(RegistryHandler.VAMPIRE_SWORD.get().getRegistryName())) {
                float healAmount = 3.0F;
                // 回复玩家血量
                player.heal(healAmount);
            }
        }
    }
}
