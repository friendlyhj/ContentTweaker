package com.blamejared.contenttweaker.api.resources;

public enum ImageType {
    BLOCK("block"),
    ITEM("item"),
    GUI("gui");
    
    private final String folderName;
    
    ImageType(String folderName) {
        this.folderName = folderName;
    }
    
    public String getFolderName() {
        return folderName;
    }
}
