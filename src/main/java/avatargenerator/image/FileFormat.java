package avatargenerator.image;

public enum FileFormat {
    JPEG("jpeg"),
    JPG("jpg"),
    PNG("png"),
    GIF("gif");

    private String value;

    FileFormat(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
