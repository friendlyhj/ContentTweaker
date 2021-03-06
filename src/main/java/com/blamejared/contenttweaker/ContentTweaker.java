package com.blamejared.contenttweaker;

import com.blamejared.crafttweaker.api.*;
import net.minecraft.block.*;
import net.minecraftforge.event.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.javafmlmod.*;
import org.apache.logging.log4j.*;

@Mod(ContentTweaker.MOD_ID)
public class ContentTweaker {
    
    public static final String MOD_ID = "contenttweaker";
    public static final String NAME = "ContentTweaker";
    
    public static final Logger LOG = LogManager.getLogger(NAME);
    
    public ContentTweaker() {
        VanillaFactory.generateStuffForMyModId(MOD_ID);
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Block.class, EventPriority.LOW, this::registerItems);
    }
    
    
    /**
     * Loads the scripts and registers the items afterwards.
     * <p>
     * Subscribed at low priority so that the blocks <i>should</i> already be there.
     * Hopefully also some items, but I wouldn't count on it
     */
    private void registerItems(final RegistryEvent.Register<Block> registryEvent) {
        final ScriptLoadingOptions scriptLoadingOptions = new ScriptLoadingOptions().setLoaderName(MOD_ID).execute();
        
        CraftTweakerAPI.loadScripts(scriptLoadingOptions);
        VanillaFactory.forbidRegistration();
        VanillaFactory.complete();
    }
}
