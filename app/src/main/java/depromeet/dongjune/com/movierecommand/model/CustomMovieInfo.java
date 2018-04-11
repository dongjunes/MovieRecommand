package depromeet.dongjune.com.movierecommand.model;

public class CustomMovieInfo {

    int image;
    String movieName;
    String subName;
    String actor;
    String pd;

    public CustomMovieInfo(int image, String movieName, String subName, String actor, String pd) {
        this.image = image;
        this.movieName = movieName;
        this.subName = subName;
        this.actor = actor;
        this.pd = pd;
    }

    public int getImage() {
        return image;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getSubName() {
        return subName;
    }

    public String getActor() {
        return actor;
    }

    public String getPd() {
        return pd;
    }
}
