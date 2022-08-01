package fr.mrsuricate.smiteonjoin.managers;

import fr.mrsuricate.smiteonjoin.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;

public class MFiles {

    private final Main main = Main.getInstance();

    public void initFiles() {}

    public void setupResource(String fileName, boolean reset) {
        InputStream in = main.getResource(fileName);
        if (in == null) {
            throw new IllegalArgumentException("La ressource intégrée '" + fileName + "' ne peut être trouvé !");
        }
        File outDir = new File(main.getDataFolder(),"");
        if(!outDir.exists()) {
            outDir.mkdirs();
        }
        if(reset) {
            File outFile = new File(main.getDataFolder(), fileName);
            outFile.exists();
            try {
                OutputStream out = new FileOutputStream(outFile);
                byte[] buf = new byte['?'];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.close();
                in.close();
                return;
            } catch (Exception e) {
                main.logConsole(Level.WARNING, "Fichier " + fileName + " n'a pas été trouvé !");
            }
        }
    }

}

