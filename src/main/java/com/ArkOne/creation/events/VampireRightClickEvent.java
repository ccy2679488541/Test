package com.ArkOne.creation.events;


import com.ArkOne.creation.Creation;
import com.ArkOne.creation.tool.VampireSword;
import com.ArkOne.creation.util.RegistryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = Creation.Mod_ID,bus = Mod.EventBusSubscriber.Bus.FORGE,value = Dist.CLIENT)
public class VampireRightClickEvent {

    @SubscribeEvent
    public static void onClick(PlayerInteractEvent.RightClickItem event) {
        //获取手中的物品
        ItemStack heldItem = event.getPlayer().getMainHandItem();

        if (heldItem.getItem().getRegistryName().equals(RegistryHandler.VAMPIRE_SWORD.get().getRegistryName())) {
            ActionResultType resultType = VampireSword.onItemRightClick(event.getWorld(), event.getPlayer(), heldItem);
            if (resultType == ActionResultType.SUCCESS) {
                // 取消事件，告诉Minecraft我们已经处理了右键点击
                event.setCancellationResult(ActionResultType.SUCCESS);
                event.setCanceled(true);
                //朝视线方向移动
                applyDashMovement(event.getPlayer());
                //buff
                applyEffects(event.getPlayer());
            }
        }
    }

    private static void applyDashMovement(PlayerEntity player) {
        double speed = 2.0; // 设置速度

        // 获取玩家的视线方向
        float yaw = player.yRot;
        float pitch = player.xRot; // 获取玩家的仰俯角

        // 根据方向和速度设置玩家的速度，包括水平和垂直方向
        double directionX = -Math.sin(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch));
        double directionY = -Math.sin(Math.toRadians(pitch));
        double directionZ = Math.cos(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch));
        double magnitude = Math.sqrt(directionX * directionX + directionY * directionY + directionZ * directionZ);
        //冲刺!
        player.setDeltaMovement(directionX / magnitude * speed, directionY / magnitude * speed, directionZ / magnitude * speed);
    }

    private static void applyEffects(PlayerEntity player) {
        // 给予速度效果 10秒3级
        player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 10, 2));

    }
}









