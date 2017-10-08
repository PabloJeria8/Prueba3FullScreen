package cl.empresapjm.prueba3fullscreen.models;

import java.io.Serializable;

/**
 * Created by Pablo on 07-10-2017.
 */

public class MovieComment implements Serializable {

    private String photo, score, key, uid, title, description;
    private long timestamp;

    public MovieComment() {
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getscore() {
        return score;
    }

    public void setscore(String score) {
        this.score = score;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
