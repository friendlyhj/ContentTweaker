package com.blamejared.contenttweaker.api.functions;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.openzen.zencode.java.ZenCodeType;

@FunctionalInterface
@ZenRegister
@ZenCodeType.Name("mods.contenttweaker.functions.IBlockNeighborChanged")
@Document("mods/contenttweaker/API/functions/IBlockNeighborChanged")
public interface IBlockNeighborChanged extends ICotFunction {
    @ZenCodeType.Method
    void apply(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving);
}
