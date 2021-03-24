package com.googlecode.mp4parser.authoring.builder;

import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.util.Math;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
/* loaded from: classes6.dex */
public class SyncSampleIntersectFinderImpl implements FragmentIntersectionFinder {
    public final int minFragmentDurationSeconds;
    public Movie movie;
    public Track referenceTrack;
    public static Logger LOG = Logger.getLogger(SyncSampleIntersectFinderImpl.class.getName());
    public static Map<CacheTuple, long[]> getTimesCache = new ConcurrentHashMap();
    public static Map<CacheTuple, long[]> getSampleNumbersCache = new ConcurrentHashMap();

    /* loaded from: classes6.dex */
    public static class CacheTuple {
        public Movie movie;
        public Track track;

        public CacheTuple(Track track, Movie movie) {
            this.track = track;
            this.movie = movie;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || CacheTuple.class != obj.getClass()) {
                return false;
            }
            CacheTuple cacheTuple = (CacheTuple) obj;
            Movie movie = this.movie;
            if (movie == null ? cacheTuple.movie == null : movie.equals(cacheTuple.movie)) {
                Track track = this.track;
                Track track2 = cacheTuple.track;
                return track == null ? track2 == null : track.equals(track2);
            }
            return false;
        }

        public int hashCode() {
            Track track = this.track;
            int hashCode = (track != null ? track.hashCode() : 0) * 31;
            Movie movie = this.movie;
            return hashCode + (movie != null ? movie.hashCode() : 0);
        }
    }

    public SyncSampleIntersectFinderImpl(Movie movie, Track track, int i) {
        this.movie = movie;
        this.referenceTrack = track;
        this.minFragmentDurationSeconds = i;
    }

    public static long calculateTracktimesScalingFactor(Movie movie, Track track) {
        long j = 1;
        for (Track track2 : movie.getTracks()) {
            if (track2.getHandler().equals(track.getHandler()) && track2.getTrackMetaData().getTimescale() != track.getTrackMetaData().getTimescale()) {
                j = Math.lcm(j, track2.getTrackMetaData().getTimescale());
            }
        }
        return j;
    }

    public static List<long[]> getSyncSamplesTimestamps(Movie movie, Track track) {
        long[] syncSamples;
        LinkedList linkedList = new LinkedList();
        for (Track track2 : movie.getTracks()) {
            if (track2.getHandler().equals(track.getHandler()) && (syncSamples = track2.getSyncSamples()) != null && syncSamples.length > 0) {
                linkedList.add(getTimes(track2, movie));
            }
        }
        return linkedList;
    }

    public static long[] getTimes(Track track, Movie movie) {
        long[] syncSamples = track.getSyncSamples();
        long[] jArr = new long[syncSamples.length];
        long calculateTracktimesScalingFactor = calculateTracktimesScalingFactor(movie, track);
        long j = 0;
        int i = 0;
        int i2 = 1;
        while (true) {
            long j2 = i2;
            if (j2 >= syncSamples[syncSamples.length - 1]) {
                return jArr;
            }
            if (j2 == syncSamples[i]) {
                jArr[i] = j * calculateTracktimesScalingFactor;
                i++;
            }
            j += track.getSampleDurations()[i2];
            i2++;
        }
    }

    public long[] getCommonIndices(long[] jArr, long[] jArr2, long j, long[]... jArr3) {
        LinkedList linkedList;
        LinkedList<Long> linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        for (int i = 0; i < jArr2.length; i++) {
            boolean z = true;
            for (long[] jArr4 : jArr3) {
                z &= Arrays.binarySearch(jArr4, jArr2[i]) >= 0;
            }
            if (z) {
                linkedList2.add(Long.valueOf(jArr[i]));
                linkedList3.add(Long.valueOf(jArr2[i]));
            }
        }
        double length = jArr.length;
        Double.isNaN(length);
        if (linkedList2.size() < length * 0.25d) {
            String str = "" + String.format("%5d - Common:  [", Integer.valueOf(linkedList2.size()));
            for (Long l : linkedList2) {
                long longValue = l.longValue();
                str = String.valueOf(str) + String.format("%10d,", Long.valueOf(longValue));
            }
            LOG.warning(String.valueOf(str) + "]");
            String str2 = "" + String.format("%5d - In    :  [", Integer.valueOf(jArr.length));
            for (long j2 : jArr) {
                str2 = String.valueOf(str2) + String.format("%10d,", Long.valueOf(j2));
            }
            LOG.warning(String.valueOf(str2) + "]");
            LOG.warning("There are less than 25% of common sync samples in the given track.");
            throw new RuntimeException("There are less than 25% of common sync samples in the given track.");
        }
        double length2 = jArr.length;
        Double.isNaN(length2);
        if (linkedList2.size() < length2 * 0.5d) {
            LOG.fine("There are less than 50% of common sync samples in the given track. This is implausible but I'm ok to continue.");
        } else if (linkedList2.size() < jArr.length) {
            LOG.finest("Common SyncSample positions vs. this tracks SyncSample positions: " + linkedList2.size() + " vs. " + jArr.length);
        }
        LinkedList linkedList4 = new LinkedList();
        if (this.minFragmentDurationSeconds > 0) {
            Iterator it = linkedList2.iterator();
            Iterator it2 = linkedList3.iterator();
            long j3 = -1;
            long j4 = -1;
            while (it.hasNext() && it2.hasNext()) {
                long longValue2 = ((Long) it.next()).longValue();
                long longValue3 = ((Long) it2.next()).longValue();
                if (j4 == j3 || (longValue3 - j4) / j >= this.minFragmentDurationSeconds) {
                    linkedList4.add(Long.valueOf(longValue2));
                    j4 = longValue3;
                }
                j3 = -1;
            }
            linkedList = linkedList4;
        } else {
            linkedList = linkedList2;
        }
        int size = linkedList.size();
        long[] jArr5 = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr5[i2] = ((Long) linkedList.get(i2)).longValue();
        }
        return jArr5;
    }

    @Override // com.googlecode.mp4parser.authoring.builder.FragmentIntersectionFinder
    public long[] sampleNumbers(Track track) {
        CacheTuple cacheTuple = new CacheTuple(track, this.movie);
        long[] jArr = getSampleNumbersCache.get(cacheTuple);
        if (jArr != null) {
            return jArr;
        }
        if ("vide".equals(track.getHandler())) {
            if (track.getSyncSamples() != null && track.getSyncSamples().length > 0) {
                List<long[]> syncSamplesTimestamps = getSyncSamplesTimestamps(this.movie, track);
                long[] commonIndices = getCommonIndices(track.getSyncSamples(), getTimes(track, this.movie), track.getTrackMetaData().getTimescale(), (long[][]) syncSamplesTimestamps.toArray(new long[syncSamplesTimestamps.size()]));
                getSampleNumbersCache.put(cacheTuple, commonIndices);
                return commonIndices;
            }
            throw new RuntimeException("Video Tracks need sync samples. Only tracks other than video may have no sync samples.");
        }
        int i = 0;
        if ("soun".equals(track.getHandler())) {
            if (this.referenceTrack == null) {
                for (Track track2 : this.movie.getTracks()) {
                    if (track2.getSyncSamples() != null && "vide".equals(track2.getHandler()) && track2.getSyncSamples().length > 0) {
                        this.referenceTrack = track2;
                    }
                }
            }
            Track track3 = this.referenceTrack;
            if (track3 != null) {
                long[] sampleNumbers = sampleNumbers(track3);
                int size = this.referenceTrack.getSamples().size();
                int length = sampleNumbers.length;
                long[] jArr2 = new long[length];
                long j = 192000;
                Iterator<Track> it = this.movie.getTracks().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Track next = it.next();
                    if (track.getSampleDescriptionBox().getSampleEntry().getType().equals(next.getSampleDescriptionBox().getSampleEntry().getType())) {
                        AudioSampleEntry audioSampleEntry = (AudioSampleEntry) next.getSampleDescriptionBox().getSampleEntry();
                        if (audioSampleEntry.getSampleRate() < 192000) {
                            long sampleRate = audioSampleEntry.getSampleRate();
                            double d2 = size;
                            Double.isNaN(r11);
                            Double.isNaN(d2);
                            double d3 = r11 / d2;
                            long j2 = next.getSampleDurations()[0];
                            int i2 = 0;
                            while (i2 < length) {
                                double d4 = sampleNumbers[i2] - 1;
                                Double.isNaN(d4);
                                double d5 = j2;
                                Double.isNaN(d5);
                                jArr2[i2] = (long) Math.ceil(d4 * d3 * d5);
                                i2++;
                                sampleNumbers = sampleNumbers;
                                length = length;
                                i = 0;
                            }
                            j = sampleRate;
                        }
                    }
                }
                long j3 = track.getSampleDurations()[i];
                double sampleRate2 = ((AudioSampleEntry) track.getSampleDescriptionBox().getSampleEntry()).getSampleRate();
                double d6 = j;
                Double.isNaN(sampleRate2);
                Double.isNaN(d6);
                double d7 = sampleRate2 / d6;
                if (d7 == Math.rint(d7)) {
                    while (i < length) {
                        double d8 = jArr2[i];
                        Double.isNaN(d8);
                        double d9 = j3;
                        Double.isNaN(d9);
                        jArr2[i] = (long) (((d8 * d7) / d9) + 1.0d);
                        i++;
                    }
                    getSampleNumbersCache.put(cacheTuple, jArr2);
                    return jArr2;
                }
                throw new RuntimeException("Sample rates must be a multiple of the lowest sample rate to create a correct file!");
            }
            throw new RuntimeException("There was absolutely no Track with sync samples. I can't work with that!");
        }
        for (Track track4 : this.movie.getTracks()) {
            if (track4.getSyncSamples() != null && track4.getSyncSamples().length > 0) {
                long[] sampleNumbers2 = sampleNumbers(track4);
                int size2 = track4.getSamples().size();
                int length2 = sampleNumbers2.length;
                long[] jArr3 = new long[length2];
                double d10 = size2;
                Double.isNaN(r8);
                Double.isNaN(d10);
                double d11 = r8 / d10;
                for (int i3 = 0; i3 < length2; i3++) {
                    double d12 = sampleNumbers2[i3] - 1;
                    Double.isNaN(d12);
                    jArr3[i3] = ((long) Math.ceil(d12 * d11)) + 1;
                }
                getSampleNumbersCache.put(cacheTuple, jArr3);
                return jArr3;
            }
        }
        throw new RuntimeException("There was absolutely no Track with sync samples. I can't work with that!");
    }
}
