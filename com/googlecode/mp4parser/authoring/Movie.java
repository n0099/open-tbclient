package com.googlecode.mp4parser.authoring;

import com.googlecode.mp4parser.util.Matrix;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class Movie {
    public Matrix matrix;
    public List<Track> tracks;

    public Movie() {
        this.matrix = Matrix.ROTATE_0;
        this.tracks = new LinkedList();
    }

    public Matrix getMatrix() {
        return this.matrix;
    }

    public long getNextTrackId() {
        long j = 0;
        for (Track track : this.tracks) {
            if (j < track.getTrackMetaData().getTrackId()) {
                j = track.getTrackMetaData().getTrackId();
            }
        }
        return j + 1;
    }

    public List<Track> getTracks() {
        return this.tracks;
    }

    public Movie(List<Track> list) {
        this.matrix = Matrix.ROTATE_0;
        this.tracks = new LinkedList();
        this.tracks = list;
    }

    public void addTrack(Track track) {
        if (getTrackByTrackId(track.getTrackMetaData().getTrackId()) != null) {
            track.getTrackMetaData().setTrackId(getNextTrackId());
        }
        this.tracks.add(track);
    }

    public Track getTrackByTrackId(long j) {
        for (Track track : this.tracks) {
            if (track.getTrackMetaData().getTrackId() == j) {
                return track;
            }
        }
        return null;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    public void setTracks(List<Track> list) {
        this.tracks = list;
    }

    public static long gcd(long j, long j2) {
        if (j2 == 0) {
            return j;
        }
        return gcd(j2, j % j2);
    }

    public long getTimescale() {
        long timescale = getTracks().iterator().next().getTrackMetaData().getTimescale();
        for (Track track : getTracks()) {
            timescale = gcd(track.getTrackMetaData().getTimescale(), timescale);
        }
        return timescale;
    }

    public String toString() {
        String str = "Movie{ ";
        for (Track track : this.tracks) {
            str = String.valueOf(str) + "track_" + track.getTrackMetaData().getTrackId() + " (" + track.getHandler() + ") ";
        }
        return String.valueOf(str) + '}';
    }
}
