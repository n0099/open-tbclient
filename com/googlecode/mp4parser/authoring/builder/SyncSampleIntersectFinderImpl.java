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
/* loaded from: classes20.dex */
public class SyncSampleIntersectFinderImpl implements FragmentIntersectionFinder {
    private final int minFragmentDurationSeconds;
    private Movie movie;
    private Track referenceTrack;
    private static Logger LOG = Logger.getLogger(SyncSampleIntersectFinderImpl.class.getName());
    private static Map<CacheTuple, long[]> getTimesCache = new ConcurrentHashMap();
    private static Map<CacheTuple, long[]> getSampleNumbersCache = new ConcurrentHashMap();

    public SyncSampleIntersectFinderImpl(Movie movie, Track track, int i) {
        this.movie = movie;
        this.referenceTrack = track;
        this.minFragmentDurationSeconds = i;
    }

    @Override // com.googlecode.mp4parser.authoring.builder.FragmentIntersectionFinder
    public long[] sampleNumbers(Track track) {
        CacheTuple cacheTuple = new CacheTuple(track, this.movie);
        long[] jArr = getSampleNumbersCache.get(cacheTuple);
        if (jArr == null) {
            if ("vide".equals(track.getHandler())) {
                if (track.getSyncSamples() != null && track.getSyncSamples().length > 0) {
                    List<long[]> syncSamplesTimestamps = getSyncSamplesTimestamps(this.movie, track);
                    long[] commonIndices = getCommonIndices(track.getSyncSamples(), getTimes(track, this.movie), track.getTrackMetaData().getTimescale(), (long[][]) syncSamplesTimestamps.toArray(new long[syncSamplesTimestamps.size()]));
                    getSampleNumbersCache.put(cacheTuple, commonIndices);
                    return commonIndices;
                }
                throw new RuntimeException("Video Tracks need sync samples. Only tracks other than video may have no sync samples.");
            } else if ("soun".equals(track.getHandler())) {
                if (this.referenceTrack == null) {
                    for (Track track2 : this.movie.getTracks()) {
                        if (track2.getSyncSamples() != null && "vide".equals(track2.getHandler()) && track2.getSyncSamples().length > 0) {
                            this.referenceTrack = track2;
                        }
                    }
                }
                if (this.referenceTrack != null) {
                    long[] sampleNumbers = sampleNumbers(this.referenceTrack);
                    int size = this.referenceTrack.getSamples().size();
                    long[] jArr2 = new long[sampleNumbers.length];
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
                                j = audioSampleEntry.getSampleRate();
                                double size2 = next.getSamples().size() / size;
                                long j2 = next.getSampleDurations()[0];
                                for (int i = 0; i < jArr2.length; i++) {
                                    jArr2[i] = (long) Math.ceil((sampleNumbers[i] - 1) * size2 * j2);
                                }
                            }
                        }
                    }
                    long j3 = track.getSampleDurations()[0];
                    double sampleRate = ((AudioSampleEntry) track.getSampleDescriptionBox().getSampleEntry()).getSampleRate() / j;
                    if (sampleRate != Math.rint(sampleRate)) {
                        throw new RuntimeException("Sample rates must be a multiple of the lowest sample rate to create a correct file!");
                    }
                    for (int i2 = 0; i2 < jArr2.length; i2++) {
                        jArr2[i2] = (long) (1.0d + ((jArr2[i2] * sampleRate) / j3));
                    }
                    getSampleNumbersCache.put(cacheTuple, jArr2);
                    return jArr2;
                }
                throw new RuntimeException("There was absolutely no Track with sync samples. I can't work with that!");
            } else {
                for (Track track3 : this.movie.getTracks()) {
                    if (track3.getSyncSamples() != null && track3.getSyncSamples().length > 0) {
                        long[] sampleNumbers2 = sampleNumbers(track3);
                        int size3 = track3.getSamples().size();
                        long[] jArr3 = new long[sampleNumbers2.length];
                        double size4 = track.getSamples().size() / size3;
                        for (int i3 = 0; i3 < jArr3.length; i3++) {
                            jArr3[i3] = ((long) Math.ceil((sampleNumbers2[i3] - 1) * size4)) + 1;
                        }
                        getSampleNumbersCache.put(cacheTuple, jArr3);
                        return jArr3;
                    }
                }
                throw new RuntimeException("There was absolutely no Track with sync samples. I can't work with that!");
            }
        }
        return jArr;
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

    public long[] getCommonIndices(long[] jArr, long[] jArr2, long j, long[]... jArr3) {
        LinkedList linkedList;
        Iterator it;
        String str;
        LinkedList linkedList2 = new LinkedList();
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
        if (linkedList2.size() < jArr.length * 0.25d) {
            String str2 = String.valueOf("") + String.format("%5d - Common:  [", Integer.valueOf(linkedList2.size()));
            while (true) {
                str = str2;
                if (!linkedList2.iterator().hasNext()) {
                    break;
                }
                str2 = String.valueOf(str) + String.format("%10d,", Long.valueOf(((Long) it.next()).longValue()));
            }
            LOG.warning(String.valueOf(str) + "]");
            String str3 = String.valueOf("") + String.format("%5d - In    :  [", Integer.valueOf(jArr.length));
            for (int i2 = 0; i2 < jArr.length; i2++) {
                str3 = String.valueOf(str3) + String.format("%10d,", Long.valueOf(jArr[i2]));
            }
            LOG.warning(String.valueOf(str3) + "]");
            LOG.warning("There are less than 25% of common sync samples in the given track.");
            throw new RuntimeException("There are less than 25% of common sync samples in the given track.");
        }
        if (linkedList2.size() < jArr.length * 0.5d) {
            LOG.fine("There are less than 50% of common sync samples in the given track. This is implausible but I'm ok to continue.");
        } else if (linkedList2.size() < jArr.length) {
            LOG.finest("Common SyncSample positions vs. this tracks SyncSample positions: " + linkedList2.size() + " vs. " + jArr.length);
        }
        LinkedList linkedList4 = new LinkedList();
        if (this.minFragmentDurationSeconds > 0) {
            Iterator it2 = linkedList2.iterator();
            Iterator it3 = linkedList3.iterator();
            long j2 = -1;
            while (true) {
                if (!it2.hasNext()) {
                    linkedList = linkedList4;
                    break;
                } else if (!it3.hasNext()) {
                    linkedList = linkedList4;
                    break;
                } else {
                    long longValue = ((Long) it2.next()).longValue();
                    long longValue2 = ((Long) it3.next()).longValue();
                    if (j2 == -1 || (longValue2 - j2) / j >= this.minFragmentDurationSeconds) {
                        linkedList4.add(Long.valueOf(longValue));
                        j2 = longValue2;
                    }
                }
            }
        } else {
            linkedList = linkedList2;
        }
        long[] jArr5 = new long[linkedList.size()];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < jArr5.length) {
                jArr5[i4] = ((Long) linkedList.get(i4)).longValue();
                i3 = i4 + 1;
            } else {
                return jArr5;
            }
        }
    }

    private static long[] getTimes(Track track, Movie movie) {
        long[] syncSamples = track.getSyncSamples();
        long[] jArr = new long[syncSamples.length];
        long j = 0;
        int i = 0;
        long calculateTracktimesScalingFactor = calculateTracktimesScalingFactor(movie, track);
        for (int i2 = 1; i2 < syncSamples[syncSamples.length - 1]; i2++) {
            if (i2 == syncSamples[i]) {
                jArr[i] = j * calculateTracktimesScalingFactor;
                i++;
            }
            j += track.getSampleDurations()[i2];
        }
        return jArr;
    }

    private static long calculateTracktimesScalingFactor(Movie movie, Track track) {
        long j = 1;
        for (Track track2 : movie.getTracks()) {
            if (track2.getHandler().equals(track.getHandler()) && track2.getTrackMetaData().getTimescale() != track.getTrackMetaData().getTimescale()) {
                j = Math.lcm(j, track2.getTrackMetaData().getTimescale());
            }
        }
        return j;
    }

    /* loaded from: classes20.dex */
    public static class CacheTuple {
        Movie movie;
        Track track;

        public CacheTuple(Track track, Movie movie) {
            this.track = track;
            this.movie = movie;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            CacheTuple cacheTuple = (CacheTuple) obj;
            if (this.movie == null ? cacheTuple.movie != null : !this.movie.equals(cacheTuple.movie)) {
                return false;
            }
            if (this.track != null) {
                if (this.track.equals(cacheTuple.track)) {
                    return true;
                }
            } else if (cacheTuple.track == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((this.track != null ? this.track.hashCode() : 0) * 31) + (this.movie != null ? this.movie.hashCode() : 0);
        }
    }
}
