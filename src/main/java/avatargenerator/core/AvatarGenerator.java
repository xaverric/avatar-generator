package avatargenerator.core;

import avatargenerator.image.AvatarPersister;
import avatargenerator.image.FileFormat;
import colorify.Colorify;
import colorify.element.Color;
import colorify.element.Palette;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

public class AvatarGenerator {

    private BufferedImage image;
    private Graphics2D graphics2D;
    private int imageSize;
    private Palette colorPalette;

    public AvatarGenerator(int imageSize) {
        init(imageSize);
    }

    public void generateAndSaveAvatar(AvatarType type, int elementSize, FileFormat format, String path) throws IOException {
        generate(type, elementSize);
        AvatarPersister.persist(image, format, path);
    }

    public InputStream generateAvatarToInputStream(AvatarType type, int elementSize, FileFormat format) throws IOException {
        generate(type, elementSize);
        return AvatarPersister.getInputStrem(image,format);
    }

    private void init(int imageSize){
        this.image = new BufferedImage(imageSize, imageSize, BufferedImage.TYPE_INT_RGB);
        this.graphics2D = image.createGraphics();
        this.imageSize = imageSize;
        this.colorPalette = prepatePalette();
    }

    private void generate(AvatarType type, int elementSize){
        Collections.shuffle(colorPalette.getColors());
        for (int i = 0; i < imageSize; i += elementSize) {
            for (int j = 0; j < imageSize; j += elementSize) {
                Collections.shuffle(colorPalette.getColors());
                Color c = colorPalette.getColors().get(0);
                graphics2D.setPaint(c.getAwtColor());
                drawElement(type, i, j, elementSize);
            }
        }
    }

    private void drawElement(AvatarType type, int x, int y, int elementSize) {
        if (type == AvatarType.SQUARE  || type == AvatarType.SQUARE_FACE) {
            graphics2D.fillRect(x, y, elementSize, elementSize);
        } else if (type == AvatarType.OVAL){
            graphics2D.fillOval(x,y,elementSize,elementSize);
        }
    }

    private Palette prepatePalette() {
        Palette palette = new Colorify().getPalette();
        palette.getColors().add(getWhiteColor());
        return palette;
    }

    private Color getWhiteColor() {
        Color color = new Color();
        color.setBlue(255);
        color.setGreen(255);
        color.setRed(255);
        return color;
    }
}
