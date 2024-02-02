package com.ArkOne.creation;

import com.ArkOne.creation.entity.KiannaEntity;
import com.ArkOne.creation.entity.model.KiannaEntityModel;
import com.ArkOne.creation.entity.render.KiannaEntityRender;
import com.ArkOne.creation.util.ModItemProperties;
import com.ArkOne.creation.util.RegistryHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.IModBusEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("creation")
public class Creation
{
    public static final String Mod_ID = "creation";
    private static final Logger LOGGER = LogManager.getLogger();

    public Creation() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCilientSetupEvent);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::SetupAttributes);

        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);
    }


    //这是一个事件处理方法，在模组进行初始化时被调用。在这个方法中，你可以执行一些需要在模组加载时进行的操作。
    private void setup(final FMLCommonSetupEvent event) {

    }

    //这是另一个事件处理方法，专门处理客户端初始化时的操作。
    private void doClientStuff(final FMLClientSetupEvent event) {
        ModItemProperties.addBowProperties();
    }


    @SubscribeEvent
    public void onCilientSetupEvent(FMLClientSetupEvent event){
        event.enqueueWork(()->{
            Minecraft mc = Minecraft.getInstance();
            EntityRendererManager manager = mc.getEntityRenderDispatcher();
            manager.register(RegistryHandler.KIANNA_ENTITY.get(),new KiannaEntityRender(manager,new KiannaEntityModel(),0.6f));
        });
    }

    @SubscribeEvent
    public void SetupAttributes(EntityAttributeCreationEvent event){
        event.put(RegistryHandler.KIANNA_ENTITY.get(), KiannaEntity.createAttributes().build());
    }


    //物品栏注册表
    public static final ItemGroup ITEM_TAB =new ItemGroup("ItemTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(RegistryHandler.STAR.get());
        }
    };
    public static final ItemGroup TOOL_TAB =new ItemGroup("ToolTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(RegistryHandler.MARVEL_SWORD.get());
        }
    };
}