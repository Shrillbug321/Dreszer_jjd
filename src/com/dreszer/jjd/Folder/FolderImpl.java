package com.dreszer.jjd.Folder;

import com.dreszer.jjd.Folder.Interfaces.Folder;

public class FolderImpl implements Folder {
    String name;
    String size;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSize() {
        return size;
    }

    public FolderImpl(String name, String size) {
        this.size = size;
        this.name = name;
    }
}
