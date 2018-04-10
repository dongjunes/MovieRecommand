package depromeet.dongjune.com.movierecommand.model;

/**
 * Created by dongjune on 2018-04-11.
 */

public class MovieInfo {
    private String actor;
    private String director;
    private String image;
    private String link;
    private String pubDate;
    private String subTitle;

    @Override
    public String toString() {
        return "MovieInfo{" +
                "actor='" + actor + '\'' +
                ", director='" + director + '\'' +
                ", image='" + image + '\'' +
                ", link='" + link + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", subTitle='" + subTitle + '\'' +
                '}';
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
