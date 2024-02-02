package com.ArkOne.creation.tool;

import com.ArkOne.creation.Creation;
import com.ArkOne.creation.util.RegistryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class VampireSword extends SwordItem {

    public static final IItemTier EXAMPLE_MATERIAL = new IItemTier() {
        @Override
        public int getUses() {
            return 3000;
        }

        @Override
        public float getSpeed() {
            return 0.0F;
        }

        @Override
        public float getAttackDamageBonus() {
            return -1.0F;
        }

        @Override
        public int getLevel() {
            return 5;
        }

        @Override
        public int getEnchantmentValue() {
            return 25;
        }

        @Override
        public Ingredient getRepairIngredient() {
            // 这里填写修复剑所需的材料
            return Ingredient.of(RegistryHandler.MARVEL_INGOT.get());
        }
    };


    public VampireSword() {
        super(EXAMPLE_MATERIAL, 10, -2.0F, new Properties().tab(Creation.TOOL_TAB));
    }

    public static ActionResultType onItemRightClick(World world, PlayerEntity player, ItemStack itemStack) {
        // 在这里添加你的右键效果逻辑
        if(!world.isClientSide){
            player.sendMessage(new StringTextComponent("冲刺！"),player.getUUID());
        }

        return ActionResultType.SUCCESS;
    }
}
