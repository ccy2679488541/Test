package com.ArkOne.creation.armor;

import com.ArkOne.creation.Creation;
import com.ArkOne.creation.util.RegistryHandler;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

import java.util.function.Supplier;

public enum MarvelArmor implements IArmorMaterial {
    MARVEL_HELMET(Creation.Mod_ID + ":marvel",1000,5,
    20, SoundEvents.ARMOR_EQUIP_GENERIC,4.0F,0.0F,()->{return Ingredient.of(RegistryHandler.MARVEL_INGOT.get());}),
    MARVEL_CHESTPLATE(Creation.Mod_ID + ":marvel",1000,10,
            20, SoundEvents.ARMOR_EQUIP_GENERIC,4.0F,0.0F,()->{return Ingredient.of(RegistryHandler.MARVEL_INGOT.get());}),
    MARVEL_LEGGINGS(Creation.Mod_ID + ":marvel",1000,8,
            20, SoundEvents.ARMOR_EQUIP_GENERIC,4.0F,0.0F,()->{return Ingredient.of(RegistryHandler.MARVEL_INGOT.get());}),
    MARVEL_BOOTS(Creation.Mod_ID + ":marvel",1000,5,
            20, SoundEvents.ARMOR_EQUIP_GENERIC,4.0F,0.0F,()->{return Ingredient.of(RegistryHandler.MARVEL_INGOT.get());});

    private static final int MAX_DAMAGE_ARRAY = 1; //分别和maxDamageFactor相乘就是各部位耐久
    private final String name;
    private final int maxDamageFactor;
    private final int damageReductionAmountArray;//护甲值
    private final int enchantability;
    private final SoundEvent soundEvent;//穿盔甲的声音
    private final float tpighness;//韧性
    private final float knockbackResistance;//击退抗性
    private final Supplier<Ingredient> repairMaterial;

    MarvelArmor(String name, int maxDamageFactor, int damageReductionAmountArray
        , int enchantability, SoundEvent soundEvent, float tpighness, float knockbackResistance, Supplier<Ingredient> repairMaterial){
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.tpighness = tpighness;
        this.knockbackResistance = knockbackResistance;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlotType equipmentSlotType) {
        return MAX_DAMAGE_ARRAY * this.maxDamageFactor;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlotType equipmentSlotType) {
        return damageReductionAmountArray;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.tpighness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }
}
