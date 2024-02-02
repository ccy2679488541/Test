package com.ArkOne.creation.entity.render;

import com.ArkOne.creation.Creation;
import com.ArkOne.creation.entity.KiannaEntity;
import com.ArkOne.creation.entity.model.KiannaEntityModel;
import com.ArkOne.creation.util.RegistryHandler;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class KiannaEntityRender extends MobRenderer<KiannaEntity,KiannaEntityModel> {

    //这个是我们的贴图，一般放在我们贴图文件夹下
    private static final ResourceLocation KIANNA_TEXTURES = new ResourceLocation(Creation.Mod_ID,"textures/entity/kianna_entity.png");

    public KiannaEntityRender(EntityRendererManager entityRendererManager, KiannaEntityModel model, float shadowSize) {
        super(entityRendererManager, model, shadowSize);
        this.shadowRadius *=0.8f;//实体阴影
    }

    @Override
    protected void scale(KiannaEntity p_225620_1_, MatrixStack stack, float p_225620_3_) {
        stack.scale(1.0f,1.0f,1.0f);//实体渲染的大小
    }

    @Override
    public ResourceLocation getTextureLocation(KiannaEntity entity) {
        return KIANNA_TEXTURES;
    }
}
