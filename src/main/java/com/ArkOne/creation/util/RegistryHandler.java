package com.ArkOne.creation.util;

import com.ArkOne.creation.Creation;
import com.ArkOne.creation.armor.MarvelArmor;
import com.ArkOne.creation.block.BlockItemBase;
import com.ArkOne.creation.block.JumpBlock;
import com.ArkOne.creation.block.MarvelOre;
import com.ArkOne.creation.block.RunBlock;
import com.ArkOne.creation.enchantment.SuperSharpnessEnchantment;
import com.ArkOne.creation.enchantment.VampireEnchantment;
import com.ArkOne.creation.entity.KiannaEntity;
import com.ArkOne.creation.item.ItemBase;
import com.ArkOne.creation.tool.*;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Creation.Mod_ID,bus = Mod.EventBusSubscriber.Bus.FORGE,value = Dist.CLIENT)
public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Creation.Mod_ID);

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Creation.Mod_ID);

    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS,Creation.Mod_ID);

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,Creation.Mod_ID);

    //初始化
    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENCHANTMENTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //注册表

    //实体
    public static final RegistryObject<EntityType<KiannaEntity>> KIANNA_ENTITY = ENTITIES.register("kianna",
            ()->EntityType.Builder.of(KiannaEntity::new,EntityClassification.MONSTER).sized(0.6f,1.8f).build(new ResourceLocation(Creation.Mod_ID,"kianna").toString()));


    //附魔书
    public static final RegistryObject<Enchantment> VAMPIRE = ENCHANTMENTS.register("vampire",
            ()->new VampireEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentType.WEAPON,EquipmentSlotType.MAINHAND));
    public static final RegistryObject<Enchantment> SUPER_SHARPNESS = ENCHANTMENTS.register("super_sharpness",
            ()->new SuperSharpnessEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentType.WEAPON,EquipmentSlotType.MAINHAND));
    public static final RegistryObject<Enchantment> COBWEB_WALKER = ENCHANTMENTS.register("cobweb_walker",
            ()->new VampireEnchantment(Enchantment.Rarity.RARE, EnchantmentType.ARMOR_FEET,EquipmentSlotType.FEET));

    //物品
    public static final RegistryObject<Item> STAR = ITEMS.register("star",ItemBase::new);
    public static final RegistryObject<Item> MARVEL_INGOT = ITEMS.register("marvel_ingot",ItemBase::new);

    //工具
    public static final RegistryObject<AxeItem> AXE = ITEMS.register("marvel_axe",
            ()->new AxeItem(MarvelTools.MARVEL_AXE,12,-2.8F,new Item.Properties().tab(Creation.TOOL_TAB)));
    public static final RegistryObject<PickaxeItem> PICKAXE = ITEMS.register("marvel_pickaxe",
            ()->new PickaxeItem(MarvelTools.MARVEL_PICKAXE,8,-2.5F,new Item.Properties().tab(Creation.TOOL_TAB)));
    public static final RegistryObject<ShovelItem> SHOVEL = ITEMS.register("marvel_shovel",
            ()->new ShovelItem(MarvelTools.MARVEL_SHOVEL,8,-2.8F,new Item.Properties().tab(Creation.TOOL_TAB)));
    public static final RegistryObject<HoeItem> HOE = ITEMS.register("marvel_hoe",
            ()->new HoeItem(MarvelTools.MARVEL_HOE,4,0.0F,new Item.Properties().tab(Creation.TOOL_TAB)));


    //剑
    public static final RegistryObject<VampireSword> VAMPIRE_SWORD = ITEMS.register("vampire_sword", VampireSword::new);
    public static final RegistryObject<SwordItem> MARVEL_SWORD = ITEMS.register("marvel_sword",
            ()->new SwordItem(MarvelTools.MARVEL_SWORD,10,-2.0F,new Item.Properties().tab(Creation.TOOL_TAB)));

    //弓
    public static final RegistryObject<Item> UNIQUE_BOW = ITEMS.register("unique_bow",
            ()-> new BowItem(new Item.Properties().tab(Creation.TOOL_TAB).durability(1000)));

    public static final RegistryObject<Item> CUSTOME_BOW = ITEMS.register("custome_bow",CustomBowItem::new);

    //盔甲
    public static final RegistryObject<ArmorItem> MARVEL_HELMET = ITEMS.register("marvel_helmet",
            ()->new ArmorItem(MarvelArmor.MARVEL_HELMET, EquipmentSlotType.HEAD,new Item.Properties().tab(Creation.TOOL_TAB)));
    public static final RegistryObject<ArmorItem> MARVEL_CHESTPLATE = ITEMS.register("marvel_chestplate",
            ()->new ArmorItem(MarvelArmor.MARVEL_CHESTPLATE, EquipmentSlotType.CHEST,new Item.Properties().tab(Creation.TOOL_TAB)));
    public static final RegistryObject<ArmorItem> MARVEL_LEGGINGS = ITEMS.register("marvel_leggings",
            ()->new ArmorItem(MarvelArmor.MARVEL_LEGGINGS, EquipmentSlotType.LEGS,new Item.Properties().tab(Creation.TOOL_TAB)));
    public static final RegistryObject<ArmorItem> MARVEL_BOOTS = ITEMS.register("marvel_boots",
            ()->new ArmorItem(MarvelArmor.MARVEL_BOOTS, EquipmentSlotType.FEET,new Item.Properties().tab(Creation.TOOL_TAB)));


    //方块放地上
    public static final RegistryObject<Block> MARVEL_ORE = BLOCKS.register("marvel_ore", MarvelOre::new);
    public static final RegistryObject<Block> JUMP_BLOCK = BLOCKS.register("jump_block", JumpBlock::new);
    public static final RegistryObject<Block> RUN_BLOCK = BLOCKS.register("run_block", RunBlock::new);

    //方块在手上
    public static final RegistryObject<Item> MARVEL_ORE_ITEM = ITEMS.register("marvel_ore",()-> new BlockItemBase(MARVEL_ORE.get()));
    public static final RegistryObject<Item> JUMP_BLOCK_ITEM = ITEMS.register("jump_block",()-> new BlockItemBase(JUMP_BLOCK.get()));
    public static final RegistryObject<Item> RUN_BLOCK_ITEM = ITEMS.register("run_block",()-> new BlockItemBase(RUN_BLOCK.get()));


}
