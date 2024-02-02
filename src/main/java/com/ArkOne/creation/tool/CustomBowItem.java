package com.ArkOne.creation.tool;

import com.ArkOne.creation.Creation;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.*;

public class CustomBowItem extends BowItem {

    public CustomBowItem() {
        super(new Item.Properties()
                .tab(Creation.TOOL_TAB)
                .durability(1000) // 设置耐久度
                .rarity(Rarity.UNCOMMON) // 设置稀有度
        );
    }

    @Override
    public UseAction getUseAnimation(ItemStack stack) {
        return UseAction.BOW; // 设置使用动作为弓的动画
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000; // 设置弓的最大使用时长（ticks）
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.STRING; // 设置弓的修复材料为绳子
    }

    @Override
    public boolean canBeDepleted() {
        return true; // 设置弓可以被耗尽耐久
    }

    @Override
    public int getDamage(ItemStack stack) {
        return 0; // 设置弓的基础耐久消耗
    }

    @Override
    public AbstractArrowEntity customArrow(AbstractArrowEntity arrow) {
        arrow.setSecondsOnFire(10);
        arrow.setBaseDamage(10.0);
        return super.customArrow(arrow);
    }

    // 其他自定义方法和逻辑

}
