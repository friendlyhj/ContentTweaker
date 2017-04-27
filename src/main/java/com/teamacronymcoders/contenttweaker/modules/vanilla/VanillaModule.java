package com.teamacronymcoders.contenttweaker.modules.vanilla;

import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.modulesystem.ModuleBase;
import com.teamacronymcoders.base.modulesystem.dependencies.IDependency;
import com.teamacronymcoders.base.modulesystem.dependencies.ModuleDependency;
import com.teamacronymcoders.contenttweaker.api.wrappers.world.IWorld;
import com.teamacronymcoders.contenttweaker.modules.vanilla.blocks.IBlock;
import com.teamacronymcoders.contenttweaker.modules.vanilla.utils.commands.Commands;
import com.teamacronymcoders.contenttweaker.modules.vanilla.functions.IItemRightClick;
import com.teamacronymcoders.contenttweaker.modules.vanilla.items.ICreativeTab;
import com.teamacronymcoders.contenttweaker.modules.vanilla.items.IItem;
import com.teamacronymcoders.contenttweaker.modules.vanilla.resources.creativetab.CreativeTabBracketHandler;
import com.teamacronymcoders.contenttweaker.modules.vanilla.resources.materials.MaterialBracketHandler;
import com.teamacronymcoders.contenttweaker.modules.vanilla.resources.sounds.SoundEventBracketHandler;
import com.teamacronymcoders.contenttweaker.modules.vanilla.resources.sounds.SoundTypeBracketHandler;
import minetweaker.MineTweakerAPI;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.List;

import static com.teamacronymcoders.contenttweaker.ContentTweaker.MOD_ID;

@Module(MOD_ID)
public class VanillaModule extends ModuleBase {
    @Override
    public String getName() {
        return "Vanilla CraftTweaker";
    }

    @Override
    public List<IDependency> getDependencies(List<IDependency> dependencies) {
        dependencies.add(new ModuleDependency("CraftTweaker Support"));
        return dependencies;
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);

        MineTweakerAPI.registerBracketHandler(new MaterialBracketHandler());
        MineTweakerAPI.registerBracketHandler(new CreativeTabBracketHandler());
        MineTweakerAPI.registerBracketHandler(new SoundEventBracketHandler());
        MineTweakerAPI.registerBracketHandler(new SoundTypeBracketHandler());

        MineTweakerAPI.registerClass(IWorld.class);

        MineTweakerAPI.registerClass(IItemRightClick.class);

        MineTweakerAPI.registerClass(ICreativeTab.class);
        MineTweakerAPI.registerClass(IBlock.class);
        MineTweakerAPI.registerClass(IItem.class);
        MineTweakerAPI.registerClass(VanillaFactory.class);
        MineTweakerAPI.registerClass(Commands.class);
    }
}