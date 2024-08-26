import com.dreszer.jjd.Folder.FolderImpl;
import com.dreszer.jjd.Folder.MultiFolderImpl;
import com.dreszer.jjd.Folder.FileCabinet;

public class Main {
    public static void main(String[] args) {
        FileCabinet fileCabinet = new FileCabinet();
        fileCabinet.addFolder(new FolderImpl("red", "SMALL"));
        fileCabinet.addFolder(new FolderImpl("yellow", "SMALL"));
        fileCabinet.addFolder(new FolderImpl("yellow", "MEDIUM"));
        fileCabinet.addFolder(new FolderImpl("red", "MEDIUM"));
        fileCabinet.addFolder(new MultiFolderImpl("pink", "MEDIUM"));

        var yellowFolder = fileCabinet.findFolderByName("yellow");
        var blueFolder = fileCabinet.findFolderByName("blue");
        var pinkFolder = fileCabinet.findFolderByName("pink");
        var mediumFolders = fileCabinet.findFoldersBySize("MEDIUM");
        var count = fileCabinet.count();
    }
}