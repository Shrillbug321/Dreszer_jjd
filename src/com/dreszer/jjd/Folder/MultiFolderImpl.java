package com.dreszer.jjd.Folder;

import com.dreszer.jjd.Folder.Interfaces.Folder;
import com.dreszer.jjd.Folder.Interfaces.MultiFolder;

import java.util.List;

public class MultiFolderImpl extends FolderImpl implements MultiFolder {
    public MultiFolderImpl(String name, String size) {
        super(name, size);
    }

    @Override
    public List<Folder> getFolders() {
        return List.of(new FolderImpl(name, size), new FolderImpl(name, size), new FolderImpl(name, size));
    }
}
