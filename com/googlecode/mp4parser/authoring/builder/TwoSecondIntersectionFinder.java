package com.googlecode.mp4parser.authoring.builder;

import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import java.util.Arrays;
/* loaded from: classes12.dex */
public class TwoSecondIntersectionFinder implements FragmentIntersectionFinder {
    private int fragmentLength;
    private Movie movie;

    public TwoSecondIntersectionFinder(Movie movie, int i) {
        this.fragmentLength = 2;
        this.movie = movie;
        this.fragmentLength = i;
    }

    @Override // com.googlecode.mp4parser.authoring.builder.FragmentIntersectionFinder
    public long[] sampleNumbers(Track track) {
        double d = 0.0d;
        for (Track track2 : this.movie.getTracks()) {
            double duration = track2.getDuration() / track2.getTrackMetaData().getTimescale();
            if (d < duration) {
                d = duration;
            }
        }
        int ceil = ((int) Math.ceil(d / this.fragmentLength)) - 1;
        if (ceil < 1) {
            ceil = 1;
        }
        long[] jArr = new long[ceil];
        Arrays.fill(jArr, -1L);
        jArr[0] = 1;
        int i = 0;
        long[] sampleDurations = track.getSampleDurations();
        int length = sampleDurations.length;
        int i2 = 0;
        long j = 0;
        while (i2 < length) {
            long j2 = sampleDurations[i2];
            int timescale = ((int) ((j / track.getTrackMetaData().getTimescale()) / this.fragmentLength)) + 1;
            if (timescale >= jArr.length) {
                break;
            }
            jArr[timescale] = i + 1;
            j += j2;
            i2++;
            i++;
        }
        long j3 = i + 1;
        for (int length2 = jArr.length - 1; length2 >= 0; length2--) {
            if (jArr[length2] == -1) {
                jArr[length2] = j3;
            }
            j3 = jArr[length2];
        }
        return jArr;
    }
}
