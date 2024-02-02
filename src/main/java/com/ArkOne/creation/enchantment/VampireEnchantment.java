package com.ArkOne.creation.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

public class VampireEnchantment extends Enchantment {

    public VampireEnchantment(Rarity rarity, EnchantmentType enchantmentType, EquipmentSlotType... p_i46731_3_) {
        super(rarity, enchantmentType, p_i46731_3_);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void doPostAttack(LivingEntity livingEntity, Entity target, int level) {
        livingEntity.heal(level);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return stack.getItem() instanceof SwordItem || stack.getItem() instanceof AxeItem;
    }
}
