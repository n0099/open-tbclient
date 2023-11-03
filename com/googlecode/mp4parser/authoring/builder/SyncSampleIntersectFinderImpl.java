package com.googlecode.mp4parser.authoring.builder;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
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
/* loaded from: classes10.dex */
public class SyncSampleIntersectFinderImpl implements FragmentIntersectionFinder {
    public final int minFragmentDurationSeconds;
    public Movie movie;
    public Track referenceTrack;
    public static Logger LOG = Logger.getLogger(SyncSampleIntersectFinderImpl.class.getName());
    public static Map<CacheTuple, long[]> getTimesCache = new ConcurrentHashMap();
    public static Map<CacheTuple, long[]> getSampleNumbersCache = new ConcurrentHashMap();

    /* loaded from: classes10.dex */
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
            if (movie == null ? cacheTuple.movie != null : !movie.equals(cacheTuple.movie)) {
                return false;
            }
            Track track = this.track;
            Track track2 = cacheTuple.track;
            if (track == null ? track2 == null : track.equals(track2)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            Track track = this.track;
            int i2 = 0;
            if (track != null) {
                i = track.hashCode();
            } else {
                i = 0;
            }
            int i3 = i * 31;
            Movie movie = this.movie;
            if (movie != null) {
                i2 = movie.hashCode();
            }
            return i3 + i2;
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
        boolean z;
        LinkedList<Long> linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        for (int i = 0; i < jArr2.length; i++) {
            boolean z2 = true;
            for (long[] jArr4 : jArr3) {
                if (Arrays.binarySearch(jArr4, jArr2[i]) >= 0) {
                    z = true;
                } else {
                    z = false;
                }
                z2 &= z;
            }
            if (z2) {
                linkedList2.add(Long.valueOf(jArr[i]));
                linkedList3.add(Long.valueOf(jArr2[i]));
            }
        }
        if (linkedList2.size() < jArr.length * 0.25d) {
            String str = "" + String.format("%5d - Common:  [", Integer.valueOf(linkedList2.size()));
            for (Long l : linkedList2) {
                long longValue = l.longValue();
                str = String.valueOf(str) + String.format("%10d,", Long.valueOf(longValue));
            }
            LOG.warning(String.valueOf(str) + PreferencesUtil.RIGHT_MOUNT);
            String str2 = "" + String.format("%5d - In    :  [", Integer.valueOf(jArr.length));
            for (long j2 : jArr) {
                str2 = String.valueOf(str2) + String.format("%10d,", Long.valueOf(j2));
            }
            LOG.warning(String.valueOf(str2) + PreferencesUtil.RIGHT_MOUNT);
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
                            double size2 = next.getSamples().size() / size;
                            long j2 = next.getSampleDurations()[0];
                            int i2 = 0;
                            while (i2 < length) {
                                jArr2[i2] = (long) Math.ceil((sampleNumbers[i2] - 1) * size2 * j2);
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
                double sampleRate2 = ((AudioSampleEntry) track.getSampleDescriptionBox().getSampleEntry()).getSampleRate() / j;
                if (sampleRate2 == Math.rint(sampleRate2)) {
                    while (i < length) {
                        jArr2[i] = (long) (((jArr2[i] * sampleRate2) / j3) + 1.0d);
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
                int size3 = track4.getSamples().size();
                int length2 = sampleNumbers2.length;
                long[] jArr3 = new long[length2];
                double size4 = track.getSamples().size() / size3;
                for (int i3 = 0; i3 < length2; i3++) {
                    jArr3[i3] = ((long) Math.ceil((sampleNumbers2[i3] - 1) * size4)) + 1;
                }
                getSampleNumbersCache.put(cacheTuple, jArr3);
                return jArr3;
            }
        }
        throw new RuntimeException("There was absolutely no Track with sync samples. I can't work with that!");
    }
}
