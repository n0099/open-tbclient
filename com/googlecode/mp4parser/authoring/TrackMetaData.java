package com.googlecode.mp4parser.authoring;

import com.coremedia.iso.boxes.EditListBox;
import com.googlecode.mp4parser.util.Matrix;
import java.util.Date;
/* loaded from: classes10.dex */
public class TrackMetaData implements Cloneable {
    public EditListBox editList;
    public double height;
    public int layer;
    public long timescale;
    public float volume;
    public double width;
    public String language = "eng";
    public Date modificationTime = new Date();
    public Date creationTime = new Date();
    public Matrix matrix = Matrix.ROTATE_0;
    public long trackId = 1;
    public int group = 0;

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Date getCreationTime() {
        return this.creationTime;
    }

    public EditListBox getEditList() {
        return this.editList;
    }

    public int getGroup() {
        return this.group;
    }

    public double getHeight() {
        return this.height;
    }

    public String getLanguage() {
        return this.language;
    }

    public int getLayer() {
        return this.layer;
    }

    public Matrix getMatrix() {
        return this.matrix;
    }

    public Date getModificationTime() {
        return this.modificationTime;
    }

    public long getTimescale() {
        return this.timescale;
    }

    public long getTrackId() {
        return this.trackId;
    }

    public float getVolume() {
        return this.volume;
    }

    public double getWidth() {
        return this.width;
    }

    public void setCreationTime(Date date) {
        this.creationTime = date;
    }

    public void setEditList(EditListBox editListBox) {
        this.editList = editListBox;
    }

    public void setGroup(int i) {
        this.group = i;
    }

    public void setHeight(double d) {
        this.height = d;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setLayer(int i) {
        this.layer = i;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    public void setModificationTime(Date date) {
        this.modificationTime = date;
    }

    public void setTimescale(long j) {
        this.timescale = j;
    }

    public void setTrackId(long j) {
        this.trackId = j;
    }

    public void setVolume(float f) {
        this.volume = f;
    }

    public void setWidth(double d) {
        this.width = d;
    }
}
