package phm.example.retrofit2_study1;

public class Card {

    private String text;
    private String name;
    private String image;
    private String cropImage;

    public String getName() {
        return name;
    } // 이름

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    } // 텍스트

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    } // 이미지

    public void setImage(String image) {
        this.image = image;
    }

    public String getCropImage() { return cropImage; } // 이미지

    public void setCropImage(String cropImage) {
        this.cropImage = cropImage;
    }

}