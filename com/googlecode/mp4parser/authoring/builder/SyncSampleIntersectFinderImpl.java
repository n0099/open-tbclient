package com.googlecode.mp4parser.authoring.builder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public static Logger LOG;
    public static Map<CacheTuple, long[]> getSampleNumbersCache;
    public static Map<CacheTuple, long[]> getTimesCache;
    public transient /* synthetic */ FieldHolder $fh;
    public final int minFragmentDurationSeconds;
    public Movie movie;
    public Track referenceTrack;

    /* loaded from: classes10.dex */
    public static class CacheTuple {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Movie movie;
        public Track track;

        public CacheTuple(Track track, Movie movie) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {track, movie};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.track = track;
            this.movie = movie;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
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
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Track track = this.track;
                int hashCode = (track != null ? track.hashCode() : 0) * 31;
                Movie movie = this.movie;
                return hashCode + (movie != null ? movie.hashCode() : 0);
            }
            return invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1263466357, "Lcom/googlecode/mp4parser/authoring/builder/SyncSampleIntersectFinderImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1263466357, "Lcom/googlecode/mp4parser/authoring/builder/SyncSampleIntersectFinderImpl;");
                return;
            }
        }
        LOG = Logger.getLogger(SyncSampleIntersectFinderImpl.class.getName());
        getTimesCache = new ConcurrentHashMap();
        getSampleNumbersCache = new ConcurrentHashMap();
    }

    public SyncSampleIntersectFinderImpl(Movie movie, Track track, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {movie, track, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.movie = movie;
        this.referenceTrack = track;
        this.minFragmentDurationSeconds = i2;
    }

    public static long calculateTracktimesScalingFactor(Movie movie, Track track) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, movie, track)) == null) {
            long j2 = 1;
            for (Track track2 : movie.getTracks()) {
                if (track2.getHandler().equals(track.getHandler()) && track2.getTrackMetaData().getTimescale() != track.getTrackMetaData().getTimescale()) {
                    j2 = Math.lcm(j2, track2.getTrackMetaData().getTimescale());
                }
            }
            return j2;
        }
        return invokeLL.longValue;
    }

    public static List<long[]> getSyncSamplesTimestamps(Movie movie, Track track) {
        InterceptResult invokeLL;
        long[] syncSamples;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, movie, track)) == null) {
            LinkedList linkedList = new LinkedList();
            for (Track track2 : movie.getTracks()) {
                if (track2.getHandler().equals(track.getHandler()) && (syncSamples = track2.getSyncSamples()) != null && syncSamples.length > 0) {
                    linkedList.add(getTimes(track2, movie));
                }
            }
            return linkedList;
        }
        return (List) invokeLL.objValue;
    }

    public static long[] getTimes(Track track, Movie movie) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, track, movie)) != null) {
            return (long[]) invokeLL.objValue;
        }
        long[] syncSamples = track.getSyncSamples();
        long[] jArr = new long[syncSamples.length];
        long calculateTracktimesScalingFactor = calculateTracktimesScalingFactor(movie, track);
        long j2 = 0;
        int i2 = 0;
        int i3 = 1;
        while (true) {
            long j3 = i3;
            if (j3 >= syncSamples[syncSamples.length - 1]) {
                return jArr;
            }
            if (j3 == syncSamples[i2]) {
                jArr[i2] = j2 * calculateTracktimesScalingFactor;
                i2++;
            }
            j2 += track.getSampleDurations()[i3];
            i3++;
        }
    }

    public long[] getCommonIndices(long[] jArr, long[] jArr2, long j2, long[]... jArr3) {
        InterceptResult invokeCommon;
        LinkedList linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{jArr, jArr2, Long.valueOf(j2), jArr3})) == null) {
            LinkedList<Long> linkedList2 = new LinkedList();
            LinkedList linkedList3 = new LinkedList();
            for (int i2 = 0; i2 < jArr2.length; i2++) {
                boolean z = true;
                for (long[] jArr4 : jArr3) {
                    z &= Arrays.binarySearch(jArr4, jArr2[i2]) >= 0;
                }
                if (z) {
                    linkedList2.add(Long.valueOf(jArr[i2]));
                    linkedList3.add(Long.valueOf(jArr2[i2]));
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
                for (long j3 : jArr) {
                    str2 = String.valueOf(str2) + String.format("%10d,", Long.valueOf(j3));
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
                long j4 = -1;
                long j5 = -1;
                while (it.hasNext() && it2.hasNext()) {
                    long longValue2 = ((Long) it.next()).longValue();
                    long longValue3 = ((Long) it2.next()).longValue();
                    if (j5 == j4 || (longValue3 - j5) / j2 >= this.minFragmentDurationSeconds) {
                        linkedList4.add(Long.valueOf(longValue2));
                        j5 = longValue3;
                    }
                    j4 = -1;
                }
                linkedList = linkedList4;
            } else {
                linkedList = linkedList2;
            }
            int size = linkedList.size();
            long[] jArr5 = new long[size];
            for (int i3 = 0; i3 < size; i3++) {
                jArr5[i3] = ((Long) linkedList.get(i3)).longValue();
            }
            return jArr5;
        }
        return (long[]) invokeCommon.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.builder.FragmentIntersectionFinder
    public long[] sampleNumbers(Track track) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, track)) == null) {
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
            int i2 = 0;
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
                    long j2 = 192000;
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
                                long j3 = next.getSampleDurations()[0];
                                int i3 = 0;
                                while (i3 < length) {
                                    jArr2[i3] = (long) Math.ceil((sampleNumbers[i3] - 1) * size2 * j3);
                                    i3++;
                                    sampleNumbers = sampleNumbers;
                                    length = length;
                                    i2 = 0;
                                }
                                j2 = sampleRate;
                            }
                        }
                    }
                    long j4 = track.getSampleDurations()[i2];
                    double sampleRate2 = ((AudioSampleEntry) track.getSampleDescriptionBox().getSampleEntry()).getSampleRate() / j2;
                    if (sampleRate2 == Math.rint(sampleRate2)) {
                        while (i2 < length) {
                            jArr2[i2] = (long) (((jArr2[i2] * sampleRate2) / j4) + 1.0d);
                            i2++;
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
                    for (int i4 = 0; i4 < length2; i4++) {
                        jArr3[i4] = ((long) Math.ceil((sampleNumbers2[i4] - 1) * size4)) + 1;
                    }
                    getSampleNumbersCache.put(cacheTuple, jArr3);
                    return jArr3;
                }
            }
            throw new RuntimeException("There was absolutely no Track with sync samples. I can't work with that!");
        }
        return (long[]) invokeL.objValue;
    }
}
