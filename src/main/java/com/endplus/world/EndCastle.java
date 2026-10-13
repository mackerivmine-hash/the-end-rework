package com.endplus.world;

import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.ArrayList;
import java.util.List;

public final class EndCastle {
	private static final int FLOOR_Y = 64;
	private static final double WALL_IN = 64.0;
	private static final double WALL_OUT = 66.5;
	private static final int WALL_H = 16;
	private static final int RING_MAX = 100;
	private static final int PER_TICK = 6000;

	private static final int[] TOWER_ANGLE = {20, 60, 100, 140, 180, 220, 260, 300, 340};
	private static final int[] TOWER_HEIGHT = {42, 58, 36, 64, 46, 52, 38, 60, 48};
	private static final double TOWER_R = 4.5;

	private static final BlockPos MARKER = new BlockPos(0, 61, 0);

	private record Placement(long pos, BlockState state) {}

	private static MinecraftServer lastServer;
	private static boolean done;
	private static List<Placement> queue;
	private static int cursor;
	private static final List<BlockPos> crystalSpots = new
