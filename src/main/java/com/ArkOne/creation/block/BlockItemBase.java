package com.ArkOne.creation.block;

import com.ArkOne.creation.Creation;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class BlockItemBase extends BlockItem {
    public BlockItemBase(Block block) {
        super(block,new Properties().tab(Creation.ITEM_TAB));
    }
}
