package com.endplus.registry;

import com.endplus.EndPlus;
import com.endplus.entity.EnderSlime;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;

public final class ModEntities {
	public static final ResourceKey<EntityType<?>> ENDER_SLIME_KEY =
			ResourceKey.create(Registries.ENTITY_TYPE, EndPlus.id("ender_slime"));

	// Mesmas dimensões do slime vanilla
	public static final EntityType<EnderSlime> ENDER_SLIME = Registry.register(
			BuiltInRegistries.ENTITY_TYPE,
			ENDER_SLIME_KEY,
			EntityType.Builder.of(EnderSlime::new, MobCategory.MONSTER)
					.sized(0.52F, 0.52F)
					.eyeHeight(0.325F)
					.spawnDimensionsScale(4.0F)
					.clientTrackingRange(10)
					.build(ENDER_SLIME_KEY));

	private ModEntities() {}

	public static void register() {
		// Atributos (vida, dano, etc. são definidos pelo tamanho no próprio Slime)
		FabricDefaultAttributeRegistry.register(ENDER_SLIME, Monster.createMonsterAttributes());

		// Regras de spawn: no chão, qualquer luz (o End não tem ciclo de dia), sem Pacífico
		SpawnPlacements.register(
				ENDER_SLIME,
				SpawnPlacementTypes.ON_GROUND,
				Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(type, level, reason, pos, random) ->
						level.getDifficulty() != Difficulty.PEACEFUL
								&& Mob.checkMobSpawnRules(type, level, reason, pos, random));

		// Nasce em todos os biomas do The End (peso 6, grupos de 1 a 2)
		BiomeModifications.addSpawn(
				BiomeSelectors.foundInTheEnd(),
				MobCategory.MONSTER,
				ENDER_SLIME,
				6, 1, 2);
	}
}
