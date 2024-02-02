package com.ArkOne.creation.item;

import com.ArkOne.creation.Creation;
import net.minecraft.item.Item;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Item.Properties().tab(Creation.ITEM_TAB));
    }
}
