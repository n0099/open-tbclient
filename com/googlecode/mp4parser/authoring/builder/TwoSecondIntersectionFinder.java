package com.googlecode.mp4parser.authoring.builder;

import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import java.util.Arrays;
/* loaded from: classes10.dex */
public class TwoSecondIntersectionFinder implements FragmentIntersectionFinder {
    public int fragmentLength;
    public Movie movie;

    public TwoSecondIntersectionFinder(Movie movie, int i) {
        this.fragmentLength = 2;
        this.movie = movie;
        this.fragmentLength = i;
    }

    @Override // com.googlecode.mp4parser.authoring.builder.FragmentIntersectionFinder
    public long[] sampleNumbers(Track track) {
        int i;
        double d = 0.0d;
        for (Track track2 : this.movie.getTracks()) {
            double duration = track2.getDuration() / track2.getTrackMetaData().getTimescale();
            if (d < duration) {
                d = duration;
            }
        }
        int i2 = 1;
        int ceil = ((int) Math.ceil(d / this.fragmentLength)) - 1;
        if (ceil < 1) {
            i = 1;
        } else {
            i = ceil;
        }
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1L);
        int i3 = 0;
        jArr[0] = 1;
        long j = 0;
        long[] sampleDurations = track.getSampleDurations();
        int length = sampleDurations.length;
        int i4 = 0;
        while (i3 < length) {
            long j2 = sampleDurations[i3];
            int timescale = ((int) ((j / track.getTrackMetaData().getTimescale()) / this.fragmentLength)) + i2;
            if (timescale >= i) {
                break;
            }
            i4++;
            jArr[timescale] = i4;
            j += j2;
            i3++;
            i = i;
            i2 = 1;
        }
        long j3 = i4 + i2;
        for (int i5 = i - i2; i5 >= 0; i5--) {
            if (jArr[i5] == -1) {
                jArr[i5] = j3;
            }
            j3 = jArr[i5];
        }
        return jArr;
    }
}
