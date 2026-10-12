package com.endplus.entity;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.Level;

/**
 * Ender Slime: o slime normal, mas do The End.
 * Por enquanto herda todo o comportamento do Slime vanilla (pulo, divisão ao morrer, tamanhos).
 * Só troca as partículas por partículas de portal.
 */
public class EnderSlime extends Slime {
	public EnderSlime(EntityType<? extends Slime> type, Level level) {
		super(type, level);
	}

	@Override
	protected ParticleOptions getParticleType() {
		return ParticleTypes.PORTAL;
	}
}
