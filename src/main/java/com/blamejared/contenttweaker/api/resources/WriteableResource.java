package com.blamejared.contenttweaker.api.resources;

import com.blamejared.crafttweaker.api.*;
import net.minecraft.util.*;

import java.io.*;
import java.nio.file.*;
import java.util.function.*;

public class WriteableResource {
    
    private final ResourceType type;
    private final String modId;
    private final String path;
    private final String fileExtension;
    protected Supplier<byte[]> contentSupplier;
    
    public WriteableResource(ResourceType type, FileExtension fileExtension, String modId, String path) {
        this.type = type;
        this.modId = modId;
        this.path = path;
        this.fileExtension = fileExtension.getExtension();
    }
    
    public WriteableResource(ResourceType type, FileExtension fileExtension, String modId, String path, String... prefix) {
        this(type, fileExtension, modId, String.join("/", prefix) + "/" + path);
    }
    
    public WriteableResource(ResourceType type, FileExtension fileExtension, ResourceLocation location) {
        this(type, fileExtension, location.getNamespace(), location.getPath());
    }
    
    public WriteableResource(ResourceType type, FileExtension fileExtension, ResourceLocation location, String... prefixes) {
        this(type, fileExtension, location.getNamespace(), location.getPath(), prefixes);
    }
    
    public static ResourceLocation insertPrefix(ResourceLocation location, String prefix) {
        return new ResourceLocation(location.getNamespace(), prefix + "/" + location.getNamespace());
    }
    
    public String getModId() {
        return modId;
    }
    
    public WriteableResource withContent(String content, Object... args) {
        return withContent(String.format(content, args).getBytes());
    }
    
    public WriteableResource withContent(byte[] content) {
        return withContentSupplier(() -> content);
    }
    
    public WriteableResource withContentSupplier(Supplier<byte[]> contentSupplier) {
        this.contentSupplier = contentSupplier;
        return this;
    }
    
    public WriteableResource withContent(Supplier<String> contentProvider) {
        this.contentSupplier = () -> contentProvider.get().getBytes();
        return this;
    }
    
    public File getFile(File resourcePackFolder) {
        final String file = String.format("%s/%s/%s.%s", type.getFolderName(), modId, path, fileExtension);
        return new File(resourcePackFolder, file);
    }
    
    public void writeContentUsing(File resourcePackDirectory) {
        writeContentUsing(resourcePackDirectory, false);
    }
    
    public void writeContentUsing(File resourcePackDirectory, boolean replace) {
        final Path toWrite = getFile(resourcePackDirectory).toPath();
        if(!replace && Files.exists(toWrite)) {
            return;
        }
        
        try {
            Files.createDirectories(toWrite.getParent());
        } catch(IOException e) {
            CraftTweakerAPI.logThrowing("Could not create directory!", e);
            return;
        }
        
        
        try {
            Files.write(toWrite, contentSupplier.get());
        } catch(IOException e) {
            CraftTweakerAPI.logThrowing("Could not write to file!", e);
        }
    }
    
    public void onWrite() {
    
    }
    
    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        
        WriteableResource that = (WriteableResource) o;
        
        if(type != that.type)
            return false;
        if(!modId.equals(that.modId))
            return false;
        if(!path.equals(that.path))
            return false;
        return fileExtension.equals(that.fileExtension);
    }
    
    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + modId.hashCode();
        result = 31 * result + path.hashCode();
        result = 31 * result + fileExtension.hashCode();
        return result;
    }
}
