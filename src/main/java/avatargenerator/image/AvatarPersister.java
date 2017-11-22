package avatargenerator.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class AvatarPersister {

    public static void persist(BufferedImage image, FileFormat format, String path) throws IOException {
        ImageIO.write(image, format.getValue(), new File(path));
    }

    public static InputStream getInputStrem(BufferedImage image, FileFormat format) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(image, format.getValue(), os);
        return new ByteArrayInputStream(os.toByteArray());
    }
}
