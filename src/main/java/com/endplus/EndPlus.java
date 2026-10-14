package com.endplus;

import com.endplus.registry.ModEntities;
import com.endplus.world.EndCastle;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndPlus implements ModInitializer {
	public static final String MOD_ID = "endplus";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		ModEntities.register();
		ServerTickEvents.END_SERVER_TICK.register(EndCastle::tick);
		LOGGER.info("End Plus carregado!");
	}
}
