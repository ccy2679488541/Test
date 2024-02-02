package com.ArkOne.creation.util;

import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;

public class ModItemProperties {
    public static void addBowProperties(){
        //可以添加其他弓
        makeBow(RegistryHandler.UNIQUE_BOW.get());
        makeBow(RegistryHandler.CUSTOME_BOW.get());
    }

    private static void makeBow(Item item){
        ItemModelsProperties.register(item, new ResourceLocation("pull"), (itemStack, modelResourceLocation, livingEntity) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return livingEntity.getUseItem() != itemStack ? 0.0F : (float)(itemStack.getUseDuration() - livingEntity.getUseItemRemainingTicks()) / 20.0F;
            }
        });
        ItemModelsProperties.register(item, new ResourceLocation("pulling"), (itemStack, modelResourceLocation, livingEntity) -> {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F;
        });
    }
}
