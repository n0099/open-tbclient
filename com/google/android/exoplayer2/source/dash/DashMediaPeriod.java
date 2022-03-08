package com.google.android.exoplayer2.source.dash;

import android.util.Pair;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.CompositeSequenceableLoader;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.Descriptor;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public final class DashMediaPeriod implements MediaPeriod, SequenceableLoader.Callback<ChunkSampleStream<DashChunkSource>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Allocator allocator;
    public MediaPeriod.Callback callback;
    public final DashChunkSource.Factory chunkSourceFactory;
    public final long elapsedRealtimeOffset;
    public final AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher;
    public final int id;
    public DashManifest manifest;
    public final LoaderErrorThrower manifestLoaderErrorThrower;
    public final int minLoadableRetryCount;
    public int periodIndex;
    public ChunkSampleStream<DashChunkSource>[] sampleStreams;
    public CompositeSequenceableLoader sequenceableLoader;
    public final TrackGroupInfo[] trackGroupInfos;
    public final TrackGroupArray trackGroups;

    /* loaded from: classes7.dex */
    public static final class TrackGroupInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int[] adaptationSetIndices;
        public final boolean hasEmbeddedCea608Track;
        public final boolean hasEmbeddedEventMessageTrack;
        public final boolean isPrimary;
        public final int primaryTrackGroupIndex;
        public final int trackType;

        public TrackGroupInfo(int i2, int[] iArr, int i3, boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), iArr, Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.trackType = i2;
            this.adaptationSetIndices = iArr;
            this.primaryTrackGroupIndex = i3;
            this.isPrimary = z;
            this.hasEmbeddedEventMessageTrack = z2;
            this.hasEmbeddedCea608Track = z3;
        }
    }

    public DashMediaPeriod(int i2, DashManifest dashManifest, int i3, DashChunkSource.Factory factory, int i4, AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher, long j2, LoaderErrorThrower loaderErrorThrower, Allocator allocator) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), dashManifest, Integer.valueOf(i3), factory, Integer.valueOf(i4), eventDispatcher, Long.valueOf(j2), loaderErrorThrower, allocator};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.id = i2;
        this.manifest = dashManifest;
        this.periodIndex = i3;
        this.chunkSourceFactory = factory;
        this.minLoadableRetryCount = i4;
        this.eventDispatcher = eventDispatcher;
        this.elapsedRealtimeOffset = j2;
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.allocator = allocator;
        ChunkSampleStream<DashChunkSource>[] newSampleStreamArray = newSampleStreamArray(0);
        this.sampleStreams = newSampleStreamArray;
        this.sequenceableLoader = new CompositeSequenceableLoader(newSampleStreamArray);
        Pair<TrackGroupArray, TrackGroupInfo[]> buildTrackGroups = buildTrackGroups(dashManifest.getPeriod(i3).adaptationSets);
        this.trackGroups = (TrackGroupArray) buildTrackGroups.first;
        this.trackGroupInfos = (TrackGroupInfo[]) buildTrackGroups.second;
    }

    private ChunkSampleStream<DashChunkSource> buildSampleStream(TrackGroupInfo trackGroupInfo, TrackSelection trackSelection, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{trackGroupInfo, trackSelection, Long.valueOf(j2)})) == null) {
            int[] iArr = new int[2];
            boolean z = trackGroupInfo.hasEmbeddedEventMessageTrack;
            int i2 = 0;
            if (z) {
                iArr[0] = 4;
                i2 = 1;
            }
            boolean z2 = trackGroupInfo.hasEmbeddedCea608Track;
            if (z2) {
                iArr[i2] = 3;
                i2++;
            }
            if (i2 < 2) {
                iArr = Arrays.copyOf(iArr, i2);
            }
            return new ChunkSampleStream<>(trackGroupInfo.trackType, iArr, this.chunkSourceFactory.createDashChunkSource(this.manifestLoaderErrorThrower, this.manifest, this.periodIndex, trackGroupInfo.adaptationSetIndices, trackSelection, trackGroupInfo.trackType, this.elapsedRealtimeOffset, z, z2), this, this.allocator, j2, this.minLoadableRetryCount, this.eventDispatcher);
        }
        return (ChunkSampleStream) invokeCommon.objValue;
    }

    public static Pair<TrackGroupArray, TrackGroupInfo[]> buildTrackGroups(List<AdaptationSet> list) {
        InterceptResult invokeL;
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            int[][] groupedAdaptationSetIndices = getGroupedAdaptationSetIndices(list);
            int length = groupedAdaptationSetIndices.length;
            boolean[] zArr = new boolean[length];
            boolean[] zArr2 = new boolean[length];
            char c2 = 0;
            int i3 = length;
            int i4 = 0;
            while (true) {
                i2 = 1;
                if (i4 >= length) {
                    break;
                }
                if (hasEventMessageTrack(list, groupedAdaptationSetIndices[i4])) {
                    zArr[i4] = true;
                    i3++;
                }
                if (hasCea608Track(list, groupedAdaptationSetIndices[i4])) {
                    zArr2[i4] = true;
                    i3++;
                }
                i4++;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i3];
            TrackGroupInfo[] trackGroupInfoArr = new TrackGroupInfo[i3];
            int i5 = 0;
            int i6 = 0;
            while (i5 < length) {
                int[] iArr = groupedAdaptationSetIndices[i5];
                ArrayList arrayList = new ArrayList();
                for (int i7 : iArr) {
                    arrayList.addAll(list.get(i7).representations);
                }
                int size = arrayList.size();
                Format[] formatArr = new Format[size];
                for (int i8 = 0; i8 < size; i8++) {
                    formatArr[i8] = ((Representation) arrayList.get(i8)).format;
                }
                AdaptationSet adaptationSet = list.get(iArr[c2]);
                boolean z = zArr[i5];
                boolean z2 = zArr2[i5];
                trackGroupArr[i6] = new TrackGroup(formatArr);
                int i9 = i6 + 1;
                trackGroupInfoArr[i6] = new TrackGroupInfo(adaptationSet.type, iArr, i6, true, z, z2);
                if (z) {
                    Format[] formatArr2 = new Format[i2];
                    formatArr2[0] = Format.createSampleFormat(adaptationSet.id + ":emsg", MimeTypes.APPLICATION_EMSG, null, -1, null);
                    trackGroupArr[i9] = new TrackGroup(formatArr2);
                    str = null;
                    trackGroupInfoArr[i9] = new TrackGroupInfo(4, iArr, i6, false, false, false);
                    i9++;
                } else {
                    str = null;
                }
                if (z2) {
                    trackGroupArr[i9] = new TrackGroup(Format.createTextSampleFormat(adaptationSet.id + ":cea608", MimeTypes.APPLICATION_CEA608, 0, str));
                    trackGroupInfoArr[i9] = new TrackGroupInfo(3, iArr, i6, false, false, false);
                    i9++;
                }
                i5++;
                i6 = i9;
                c2 = 0;
                i2 = 1;
            }
            return Pair.create(new TrackGroupArray(trackGroupArr), trackGroupInfoArr);
        }
        return (Pair) invokeL.objValue;
    }

    public static Descriptor findAdaptationSetSwitchingProperty(List<Descriptor> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                Descriptor descriptor = list.get(i2);
                if ("urn:mpeg:dash:adaptation-set-switching:2016".equals(descriptor.schemeIdUri)) {
                    return descriptor;
                }
            }
            return null;
        }
        return (Descriptor) invokeL.objValue;
    }

    public static int[][] getGroupedAdaptationSetIndices(List<AdaptationSet> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            int size = list.size();
            SparseIntArray sparseIntArray = new SparseIntArray(size);
            for (int i2 = 0; i2 < size; i2++) {
                sparseIntArray.put(list.get(i2).id, i2);
            }
            int[][] iArr = new int[size];
            boolean[] zArr = new boolean[size];
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                if (!zArr[i4]) {
                    zArr[i4] = true;
                    Descriptor findAdaptationSetSwitchingProperty = findAdaptationSetSwitchingProperty(list.get(i4).supplementalProperties);
                    if (findAdaptationSetSwitchingProperty == null) {
                        int[] iArr2 = new int[1];
                        iArr2[0] = i4;
                        iArr[i3] = iArr2;
                        i3++;
                    } else {
                        String[] split = findAdaptationSetSwitchingProperty.value.split(",");
                        int[] iArr3 = new int[split.length + 1];
                        iArr3[0] = i4;
                        int i5 = 0;
                        while (i5 < split.length) {
                            int i6 = sparseIntArray.get(Integer.parseInt(split[i5]));
                            zArr[i6] = true;
                            i5++;
                            iArr3[i5] = i6;
                        }
                        iArr[i3] = iArr3;
                        i3++;
                    }
                }
            }
            return i3 < size ? (int[][]) Arrays.copyOf(iArr, i3) : iArr;
        }
        return (int[][]) invokeL.objValue;
    }

    public static boolean hasCea608Track(List<AdaptationSet> list, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, iArr)) == null) {
            for (int i2 : iArr) {
                List<Descriptor> list2 = list.get(i2).accessibilityDescriptors;
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    if ("urn:scte:dash:cc:cea-608:2015".equals(list2.get(i3).schemeIdUri)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean hasEventMessageTrack(List<AdaptationSet> list, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, list, iArr)) == null) {
            for (int i2 : iArr) {
                List<Representation> list2 = list.get(i2).representations;
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    if (!list2.get(i3).inbandEventStreams.isEmpty()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static ChunkSampleStream<DashChunkSource>[] newSampleStreamArray(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) ? new ChunkSampleStream[i2] : (ChunkSampleStream[]) invokeI.objValue;
    }

    public static void releaseIfEmbeddedSampleStream(SampleStream sampleStream) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, sampleStream) == null) && (sampleStream instanceof ChunkSampleStream.EmbeddedSampleStream)) {
            ((ChunkSampleStream.EmbeddedSampleStream) sampleStream).release();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) ? this.sequenceableLoader.continueLoading(j2) : invokeJ.booleanValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.sampleStreams) {
                chunkSampleStream.discardEmbeddedTracksTo(j2);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.sequenceableLoader.getBufferedPositionUs() : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.sequenceableLoader.getNextLoadPositionUs() : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.trackGroups : (TrackGroupArray) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.manifestLoaderErrorThrower.maybeThrowError();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, callback, j2) == null) {
            this.callback = callback;
            callback.onPrepared(this);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? C.TIME_UNSET : invokeV.longValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.sampleStreams) {
                chunkSampleStream.release();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j2)) == null) {
            for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.sampleStreams) {
                chunkSampleStream.seekToUs(j2);
            }
            return j2;
        }
        return invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        InterceptResult invokeCommon;
        boolean z;
        SampleStream selectEmbeddedTrack;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{trackSelectionArr, zArr, sampleStreamArr, zArr2, Long.valueOf(j2)})) == null) {
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < trackSelectionArr.length; i2++) {
                if (sampleStreamArr[i2] instanceof ChunkSampleStream) {
                    ChunkSampleStream chunkSampleStream = (ChunkSampleStream) sampleStreamArr[i2];
                    if (trackSelectionArr[i2] != null && zArr[i2]) {
                        hashMap.put(Integer.valueOf(this.trackGroups.indexOf(trackSelectionArr[i2].getTrackGroup())), chunkSampleStream);
                    } else {
                        chunkSampleStream.release();
                        sampleStreamArr[i2] = null;
                    }
                }
                if (sampleStreamArr[i2] == null && trackSelectionArr[i2] != null) {
                    int indexOf = this.trackGroups.indexOf(trackSelectionArr[i2].getTrackGroup());
                    TrackGroupInfo trackGroupInfo = this.trackGroupInfos[indexOf];
                    if (trackGroupInfo.isPrimary) {
                        ChunkSampleStream<DashChunkSource> buildSampleStream = buildSampleStream(trackGroupInfo, trackSelectionArr[i2], j2);
                        hashMap.put(Integer.valueOf(indexOf), buildSampleStream);
                        sampleStreamArr[i2] = buildSampleStream;
                        zArr2[i2] = true;
                    }
                }
            }
            for (int i3 = 0; i3 < trackSelectionArr.length; i3++) {
                if (((sampleStreamArr[i3] instanceof ChunkSampleStream.EmbeddedSampleStream) || (sampleStreamArr[i3] instanceof EmptySampleStream)) && (trackSelectionArr[i3] == null || !zArr[i3])) {
                    releaseIfEmbeddedSampleStream(sampleStreamArr[i3]);
                    sampleStreamArr[i3] = null;
                }
                if (trackSelectionArr[i3] != null) {
                    TrackGroupInfo trackGroupInfo2 = this.trackGroupInfos[this.trackGroups.indexOf(trackSelectionArr[i3].getTrackGroup())];
                    if (!trackGroupInfo2.isPrimary) {
                        ChunkSampleStream chunkSampleStream2 = (ChunkSampleStream) hashMap.get(Integer.valueOf(trackGroupInfo2.primaryTrackGroupIndex));
                        SampleStream sampleStream = sampleStreamArr[i3];
                        if (chunkSampleStream2 == null) {
                            z = sampleStream instanceof EmptySampleStream;
                        } else {
                            z = (sampleStream instanceof ChunkSampleStream.EmbeddedSampleStream) && ((ChunkSampleStream.EmbeddedSampleStream) sampleStream).parent == chunkSampleStream2;
                        }
                        if (!z) {
                            releaseIfEmbeddedSampleStream(sampleStream);
                            if (chunkSampleStream2 == null) {
                                selectEmbeddedTrack = new EmptySampleStream();
                            } else {
                                selectEmbeddedTrack = chunkSampleStream2.selectEmbeddedTrack(j2, trackGroupInfo2.trackType);
                            }
                            sampleStreamArr[i3] = selectEmbeddedTrack;
                            zArr2[i3] = true;
                        }
                    }
                }
            }
            this.sampleStreams = newSampleStreamArray(hashMap.size());
            hashMap.values().toArray(this.sampleStreams);
            this.sequenceableLoader = new CompositeSequenceableLoader(this.sampleStreams);
            return j2;
        }
        return invokeCommon.longValue;
    }

    public void updateManifest(DashManifest dashManifest, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, dashManifest, i2) == null) {
            this.manifest = dashManifest;
            this.periodIndex = i2;
            ChunkSampleStream<DashChunkSource>[] chunkSampleStreamArr = this.sampleStreams;
            if (chunkSampleStreamArr != null) {
                for (ChunkSampleStream<DashChunkSource> chunkSampleStream : chunkSampleStreamArr) {
                    chunkSampleStream.getChunkSource().updateManifest(dashManifest, i2);
                }
                this.callback.onContinueLoadingRequested(this);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(ChunkSampleStream<DashChunkSource> chunkSampleStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, chunkSampleStream) == null) {
            this.callback.onContinueLoadingRequested(this);
        }
    }
}
