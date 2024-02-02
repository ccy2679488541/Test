package com.ArkOne.creation.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class RunBlock extends Block{
    public RunBlock() {
        super(AbstractBlock.Properties.of(Material.STONE)
                .strength(4,10)
                .sound(SoundType.BONE_BLOCK)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops()
                . speedFactor(2 )
        );
    }
}
