package com.ArkOne.creation.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.enchantment.DamageEnchantment;

public class SuperSharpnessEnchantment extends Enchantment {

    public SuperSharpnessEnchantment(Enchantment.Rarity rarity, EnchantmentType enchantmentType, EquipmentSlotType... p_i46731_3_) {
        super(rarity, enchantmentType, p_i46731_3_);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public float getDamageBonus(int level, CreatureAttribute attribute) {
        return 4.0F + (level-1) * 2.0F;
    }
    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return stack.getItem() instanceof SwordItem || stack.getItem() instanceof AxeItem;
    }

    @Override
    protected boolean checkCompatibility(Enchantment enchantment) {
        if (enchantment instanceof DamageEnchantment) {
            return false;
        }
        return super.checkCompatibility(enchantment);
    }
}
