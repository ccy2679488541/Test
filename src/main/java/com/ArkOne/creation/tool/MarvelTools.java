package com.ArkOne.creation.tool;

import com.ArkOne.creation.util.RegistryHandler;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import java.util.function.Supplier;

public enum MarvelTools implements IItemTier {

    //工具函数声明
    MARVEL_SWORD(5,3000,12.0F,-1.0F,25,
            ()->{return Ingredient.of(RegistryHandler.MARVEL_INGOT.get());}),
    MARVEL_AXE(5,3000,12.0F,-1.0F,25,
            ()->{return Ingredient.of(RegistryHandler.MARVEL_INGOT.get());}),
    MARVEL_PICKAXE(5,3000,12.0F,-1.0F,25,
                         ()->{return Ingredient.of(RegistryHandler.MARVEL_INGOT.get());}),
    MARVEL_SHOVEL(5,3000,12.0F,-1.5F,25,
                         ()->{return Ingredient.of(RegistryHandler.MARVEL_INGOT.get());}),
    MARVEL_HOE(5,3000,12.0F,-1.0F,25,
                         ()->{return Ingredient.of(RegistryHandler.MARVEL_INGOT.get());});

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    //工具函数定义
    MarvelTools(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }


    @Override
    public int getUses() {
        return maxUses;
    }

    @Override
    public float getSpeed() {
        return efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamage;
    }

    @Override
    public int getLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairMaterial.get();
    }
}
