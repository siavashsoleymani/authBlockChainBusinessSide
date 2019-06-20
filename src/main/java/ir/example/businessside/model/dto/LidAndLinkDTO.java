package ir.example.businessside.model.dto;

public class LidAndLinkDTO {
    private String link;
    private String lid;

    public LidAndLinkDTO() {
    }

    public LidAndLinkDTO(String link, String lid) {
        this.link = link;
        this.lid = lid;
    }

    public String getLink() {
        return link;
    }

    public String getLid() {
        return lid;
    }
}