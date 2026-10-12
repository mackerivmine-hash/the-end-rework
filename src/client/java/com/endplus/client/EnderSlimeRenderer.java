package com.endplus.client;

import com.endplus.EndPlus;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SlimeRenderer;
import net.minecraft.client.renderer.entity.state.SlimeRenderState;
import net.minecraft.resources.Identifier;

/** Usa o modelo do slime vanilla, só com a textura do Ender Slime. */
public class EnderSlimeRenderer extends SlimeRenderer {
	private static final Identifier TEXTURE = EndPlus.id("textures/entity/ender_slime.png");

	public EnderSlimeRenderer(EntityRendererProvider.Context context) {
		super(context);
	}

	@Override
	public Identifier getTextureLocation(SlimeRenderState state) {
		return TEXTURE;
	}
}
