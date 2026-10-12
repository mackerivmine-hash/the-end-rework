package com.endplus.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.cubemob.Slime;
import net.minecraft.world.level.Level;

public class EnderSlime extends Slime {
	public EnderSlime(EntityType<? extends Slime> type, Level level) {
		super(type, level);
	}
}
