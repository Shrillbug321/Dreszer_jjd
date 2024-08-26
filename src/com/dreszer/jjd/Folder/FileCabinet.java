package com.dreszer.jjd.Folder;

import com.dreszer.jjd.Folder.Interfaces.Folder;
import com.dreszer.jjd.Folder.Interfaces.MultiFolder;
import com.dreszer.jjd.Folder.Interfaces.Cabinet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class FileCabinet implements Cabinet {
    private List<Folder> folders = new ArrayList<>();

    @Override
    public Optional<Folder> findFolderByName(String name) {
        List<Folder> result = folderIterate(
                multiFolder -> multiFolder.getFolders().stream().filter(b -> b.getName().equals(name)).toList(),
                folder -> folder.getName().equals(name) ? folder : null);
        return result.isEmpty() ? Optional.empty() : Optional.of(result.getFirst());
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {
        return folderIterate(
                (multiFolder -> multiFolder.getFolders().stream().filter(b -> b.getSize().equals(size)).toList()),
                (folder -> folder.getSize().equals(size) ? folder : null));
    }

    @Override
    public int count() {
        return folderIterate(MultiFolder::getFolders, folder -> folder).size();
    }

    public void addFolder(Folder folder) {
        folders.add(folder);
    }

    /**
     * Generyczna metoda iterująca po blokach. W zależności od typu bloku wykonuje odpowiednią przekazaną metodę.
     * @param folderMethod metoda do wykonania dla prostego folderu
     * @param multiFolderMethod metoda dla złożonego folderu
     * @return lista bloków spełniających warunki określone w przekazanych metodach
     */
    private <T> List<T> folderIterate(MultiFolderMethod<T> multiFolderMethod, FolderMethod<T> folderMethod) {
        List<T> result = new ArrayList<>();
        for (Folder folder : folders) {
            if (folder instanceof MultiFolder multiFolder)
                result.addAll(multiFolderMethod.multiFolderMethod(multiFolder));
            else
                result.add(folderMethod.folderMethod(folder));
        }
        return result.stream().filter(Objects::nonNull).toList();
    }

    @FunctionalInterface
    public interface MultiFolderMethod<T> {
        List<T> multiFolderMethod(MultiFolder multiFolder);
    }

    @FunctionalInterface
    public interface FolderMethod<T> {
        T folderMethod(Folder folder);
    }
}