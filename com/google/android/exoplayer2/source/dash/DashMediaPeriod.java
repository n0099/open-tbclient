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
/* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public static final class TrackGroupInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int[] adaptationSetIndices;
        public final boolean hasEmbeddedCea608Track;
        public final boolean hasEmbeddedEventMessageTrack;
        public final boolean isPrimary;
        public final int primaryTrackGroupIndex;
        public final int trackType;

        public TrackGroupInfo(int i, int[] iArr, int i2, boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), iArr, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.trackType = i;
            this.adaptationSetIndices = iArr;
            this.primaryTrackGroupIndex = i2;
            this.isPrimary = z;
            this.hasEmbeddedEventMessageTrack = z2;
            this.hasEmbeddedCea608Track = z3;
        }
    }

    public DashMediaPeriod(int i, DashManifest dashManifest, int i2, DashChunkSource.Factory factory, int i3, AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher, long j, LoaderErrorThrower loaderErrorThrower, Allocator allocator) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), dashManifest, Integer.valueOf(i2), factory, Integer.valueOf(i3), eventDispatcher, Long.valueOf(j), loaderErrorThrower, allocator};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.id = i;
        this.manifest = dashManifest;
        this.periodIndex = i2;
        this.chunkSourceFactory = factory;
        this.minLoadableRetryCount = i3;
        this.eventDispatcher = eventDispatcher;
        this.elapsedRealtimeOffset = j;
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.allocator = allocator;
        ChunkSampleStream<DashChunkSource>[] newSampleStreamArray = newSampleStreamArray(0);
        this.sampleStreams = newSampleStreamArray;
        this.sequenceableLoader = new CompositeSequenceableLoader(newSampleStreamArray);
        Pair<TrackGroupArray, TrackGroupInfo[]> buildTrackGroups = buildTrackGroups(dashManifest.getPeriod(i2).adaptationSets);
        this.trackGroups = (TrackGroupArray) buildTrackGroups.first;
        this.trackGroupInfos = (TrackGroupInfo[]) buildTrackGroups.second;
    }

    private ChunkSampleStream<DashChunkSource> buildSampleStream(TrackGroupInfo trackGroupInfo, TrackSelection trackSelection, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{trackGroupInfo, trackSelection, Long.valueOf(j)})) == null) {
            int[] iArr = new int[2];
            boolean z = trackGroupInfo.hasEmbeddedEventMessageTrack;
            int i = 0;
            if (z) {
                iArr[0] = 4;
                i = 1;
            }
            boolean z2 = trackGroupInfo.hasEmbeddedCea608Track;
            if (z2) {
                iArr[i] = 3;
                i++;
            }
            if (i < 2) {
                iArr = Arrays.copyOf(iArr, i);
            }
            return new ChunkSampleStream<>(trackGroupInfo.trackType, iArr, this.chunkSourceFactory.createDashChunkSource(this.manifestLoaderErrorThrower, this.manifest, this.periodIndex, trackGroupInfo.adaptationSetIndices, trackSelection, trackGroupInfo.trackType, this.elapsedRealtimeOffset, z, z2), this, this.allocator, j, this.minLoadableRetryCount, this.eventDispatcher);
        }
        return (ChunkSampleStream) invokeCommon.objValue;
    }

    public static Pair<TrackGroupArray, TrackGroupInfo[]> buildTrackGroups(List<AdaptationSet> list) {
        InterceptResult invokeL;
        int i;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            int[][] groupedAdaptationSetIndices = getGroupedAdaptationSetIndices(list);
            int length = groupedAdaptationSetIndices.length;
            boolean[] zArr = new boolean[length];
            boolean[] zArr2 = new boolean[length];
            char c = 0;
            int i2 = length;
            int i3 = 0;
            while (true) {
                i = 1;
                if (i3 >= length) {
                    break;
                }
                if (hasEventMessageTrack(list, groupedAdaptationSetIndices[i3])) {
                    zArr[i3] = true;
                    i2++;
                }
                if (hasCea608Track(list, groupedAdaptationSetIndices[i3])) {
                    zArr2[i3] = true;
                    i2++;
                }
                i3++;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i2];
            TrackGroupInfo[] trackGroupInfoArr = new TrackGroupInfo[i2];
            int i4 = 0;
            int i5 = 0;
            while (i4 < length) {
                int[] iArr = groupedAdaptationSetIndices[i4];
                ArrayList arrayList = new ArrayList();
                for (int i6 : iArr) {
                    arrayList.addAll(list.get(i6).representations);
                }
                int size = arrayList.size();
                Format[] formatArr = new Format[size];
                for (int i7 = 0; i7 < size; i7++) {
                    formatArr[i7] = ((Representation) arrayList.get(i7)).format;
                }
                AdaptationSet adaptationSet = list.get(iArr[c]);
                boolean z = zArr[i4];
                boolean z2 = zArr2[i4];
                trackGroupArr[i5] = new TrackGroup(formatArr);
                int i8 = i5 + 1;
                trackGroupInfoArr[i5] = new TrackGroupInfo(adaptationSet.type, iArr, i5, true, z, z2);
                if (z) {
                    Format[] formatArr2 = new Format[i];
                    formatArr2[0] = Format.createSampleFormat(adaptationSet.id + ":emsg", MimeTypes.APPLICATION_EMSG, null, -1, null);
                    trackGroupArr[i8] = new TrackGroup(formatArr2);
                    str = null;
                    trackGroupInfoArr[i8] = new TrackGroupInfo(4, iArr, i5, false, false, false);
                    i8++;
                } else {
                    str = null;
                }
                if (z2) {
                    trackGroupArr[i8] = new TrackGroup(Format.createTextSampleFormat(adaptationSet.id + ":cea608", MimeTypes.APPLICATION_CEA608, 0, str));
                    trackGroupInfoArr[i8] = new TrackGroupInfo(3, iArr, i5, false, false, false);
                    i8++;
                }
                i4++;
                i5 = i8;
                c = 0;
                i = 1;
            }
            return Pair.create(new TrackGroupArray(trackGroupArr), trackGroupInfoArr);
        }
        return (Pair) invokeL.objValue;
    }

    public static Descriptor findAdaptationSetSwitchingProperty(List<Descriptor> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            for (int i = 0; i < list.size(); i++) {
                Descriptor descriptor = list.get(i);
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
            for (int i = 0; i < size; i++) {
                sparseIntArray.put(list.get(i).id, i);
            }
            int[][] iArr = new int[size];
            boolean[] zArr = new boolean[size];
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (!zArr[i3]) {
                    zArr[i3] = true;
                    Descriptor findAdaptationSetSwitchingProperty = findAdaptationSetSwitchingProperty(list.get(i3).supplementalProperties);
                    if (findAdaptationSetSwitchingProperty == null) {
                        int[] iArr2 = new int[1];
                        iArr2[0] = i3;
                        iArr[i2] = iArr2;
                        i2++;
                    } else {
                        String[] split = findAdaptationSetSwitchingProperty.value.split(",");
                        int[] iArr3 = new int[split.length + 1];
                        iArr3[0] = i3;
                        int i4 = 0;
                        while (i4 < split.length) {
                            int i5 = sparseIntArray.get(Integer.parseInt(split[i4]));
                            zArr[i5] = true;
                            i4++;
                            iArr3[i4] = i5;
                        }
                        iArr[i2] = iArr3;
                        i2++;
                    }
                }
            }
            return i2 < size ? (int[][]) Arrays.copyOf(iArr, i2) : iArr;
        }
        return (int[][]) invokeL.objValue;
    }

    public static boolean hasCea608Track(List<AdaptationSet> list, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, iArr)) == null) {
            for (int i : iArr) {
                List<Descriptor> list2 = list.get(i).accessibilityDescriptors;
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    if ("urn:scte:dash:cc:cea-608:2015".equals(list2.get(i2).schemeIdUri)) {
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
            for (int i : iArr) {
                List<Representation> list2 = list.get(i).representations;
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    if (!list2.get(i2).inbandEventStreams.isEmpty()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static ChunkSampleStream<DashChunkSource>[] newSampleStreamArray(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) ? new ChunkSampleStream[i] : (ChunkSampleStream[]) invokeI.objValue;
    }

    public static void releaseIfEmbeddedSampleStream(SampleStream sampleStream) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, sampleStream) == null) && (sampleStream instanceof ChunkSampleStream.EmbeddedSampleStream)) {
            ((ChunkSampleStream.EmbeddedSampleStream) sampleStream).release();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? this.sequenceableLoader.continueLoading(j) : invokeJ.booleanValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.sampleStreams) {
                chunkSampleStream.discardEmbeddedTracksTo(j);
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
    public void prepare(MediaPeriod.Callback callback, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, callback, j) == null) {
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
    public long seekToUs(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.sampleStreams) {
                chunkSampleStream.seekToUs(j);
            }
            return j;
        }
        return invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        InterceptResult invokeCommon;
        boolean z;
        SampleStream selectEmbeddedTrack;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{trackSelectionArr, zArr, sampleStreamArr, zArr2, Long.valueOf(j)})) == null) {
            HashMap hashMap = new HashMap();
            for (int i = 0; i < trackSelectionArr.length; i++) {
                if (sampleStreamArr[i] instanceof ChunkSampleStream) {
                    ChunkSampleStream chunkSampleStream = (ChunkSampleStream) sampleStreamArr[i];
                    if (trackSelectionArr[i] != null && zArr[i]) {
                        hashMap.put(Integer.valueOf(this.trackGroups.indexOf(trackSelectionArr[i].getTrackGroup())), chunkSampleStream);
                    } else {
                        chunkSampleStream.release();
                        sampleStreamArr[i] = null;
                    }
                }
                if (sampleStreamArr[i] == null && trackSelectionArr[i] != null) {
                    int indexOf = this.trackGroups.indexOf(trackSelectionArr[i].getTrackGroup());
                    TrackGroupInfo trackGroupInfo = this.trackGroupInfos[indexOf];
                    if (trackGroupInfo.isPrimary) {
                        ChunkSampleStream<DashChunkSource> buildSampleStream = buildSampleStream(trackGroupInfo, trackSelectionArr[i], j);
                        hashMap.put(Integer.valueOf(indexOf), buildSampleStream);
                        sampleStreamArr[i] = buildSampleStream;
                        zArr2[i] = true;
                    }
                }
            }
            for (int i2 = 0; i2 < trackSelectionArr.length; i2++) {
                if (((sampleStreamArr[i2] instanceof ChunkSampleStream.EmbeddedSampleStream) || (sampleStreamArr[i2] instanceof EmptySampleStream)) && (trackSelectionArr[i2] == null || !zArr[i2])) {
                    releaseIfEmbeddedSampleStream(sampleStreamArr[i2]);
                    sampleStreamArr[i2] = null;
                }
                if (trackSelectionArr[i2] != null) {
                    TrackGroupInfo trackGroupInfo2 = this.trackGroupInfos[this.trackGroups.indexOf(trackSelectionArr[i2].getTrackGroup())];
                    if (!trackGroupInfo2.isPrimary) {
                        ChunkSampleStream chunkSampleStream2 = (ChunkSampleStream) hashMap.get(Integer.valueOf(trackGroupInfo2.primaryTrackGroupIndex));
                        SampleStream sampleStream = sampleStreamArr[i2];
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
                                selectEmbeddedTrack = chunkSampleStream2.selectEmbeddedTrack(j, trackGroupInfo2.trackType);
                            }
                            sampleStreamArr[i2] = selectEmbeddedTrack;
                            zArr2[i2] = true;
                        }
                    }
                }
            }
            this.sampleStreams = newSampleStreamArray(hashMap.size());
            hashMap.values().toArray(this.sampleStreams);
            this.sequenceableLoader = new CompositeSequenceableLoader(this.sampleStreams);
            return j;
        }
        return invokeCommon.longValue;
    }

    public void updateManifest(DashManifest dashManifest, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, dashManifest, i) == null) {
            this.manifest = dashManifest;
            this.periodIndex = i;
            ChunkSampleStream<DashChunkSource>[] chunkSampleStreamArr = this.sampleStreams;
            if (chunkSampleStreamArr != null) {
                for (ChunkSampleStream<DashChunkSource> chunkSampleStream : chunkSampleStreamArr) {
                    chunkSampleStream.getChunkSource().updateManifest(dashManifest, i);
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
