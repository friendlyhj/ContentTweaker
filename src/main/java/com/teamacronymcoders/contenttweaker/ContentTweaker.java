package com.teamacronymcoders.contenttweaker;

import com.teamacronymcoders.base.BaseModFoundation;
import com.teamacronymcoders.base.registry.config.ConfigRegistry;
import com.teamacronymcoders.base.util.files.BaseFileUtils;
import com.teamacronymcoders.contenttweaker.api.ContentTweakerAPI;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

import static com.teamacronymcoders.contenttweaker.ContentTweaker.*;

@Mod(modid = MOD_ID, name = MOD_NAME, version = VERSION, dependencies = DEPENDS)
public class ContentTweaker extends BaseModFoundation<ContentTweaker> {
    public static final String MOD_ID = "contenttweaker";
    public static final String MOD_NAME = "ContentTweaker";
    public static final String VERSION = "1.0.0";
    public static final String DEPENDS = "required-after:base@[0.0.0,);";

    @Instance(MOD_ID)
    public static ContentTweaker instance;

    public File contentFolder;
    public File resourceFolder;

    public ContentTweaker() {
        super(MOD_ID, MOD_NAME, VERSION, CreativeTabs.MISC);
        ContentTweakerAPI.setInstance(new ContentTweakerAPI(new ModWrapper()));
    }

    @EventHandler
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @Override
    public void beforeModuleHandlerInit(FMLPreInitializationEvent event) {
        File modFolder = this.getRegistry(ConfigRegistry.class, "CONFIG").getConfigFolder();
        this.contentFolder = new File(modFolder, "content");
        this.resourceFolder = new File(modFolder, "resources");
        BaseFileUtils.createFolder(this.contentFolder);
        BaseFileUtils.createFolder(this.resourceFolder);
    }

    @EventHandler
    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @EventHandler
    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

    @Override
    public String getConfigFolderName() {
        return this.getName();
    }

    @Override
    public ContentTweaker getInstance() {
        return this;
    }
}
