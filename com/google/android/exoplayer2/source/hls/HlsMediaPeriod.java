package com.google.android.exoplayer2.source.hls;

import android.os.Handler;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.CompositeSequenceableLoader;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
/* loaded from: classes6.dex */
public final class HlsMediaPeriod implements MediaPeriod, HlsSampleStreamWrapper.Callback, HlsPlaylistTracker.PlaylistEventListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Allocator allocator;
    public MediaPeriod.Callback callback;
    public final Handler continueLoadingHandler;
    public final HlsDataSourceFactory dataSourceFactory;
    public HlsSampleStreamWrapper[] enabledSampleStreamWrappers;
    public final AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher;
    public final HlsExtractorFactory extractorFactory;
    public final int minLoadableRetryCount;
    public int pendingPrepareCount;
    public final HlsPlaylistTracker playlistTracker;
    public HlsSampleStreamWrapper[] sampleStreamWrappers;
    public CompositeSequenceableLoader sequenceableLoader;
    public final IdentityHashMap<SampleStream, Integer> streamWrapperIndices;
    public final TimestampAdjusterProvider timestampAdjusterProvider;
    public TrackGroupArray trackGroups;

    public HlsMediaPeriod(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, HlsDataSourceFactory hlsDataSourceFactory, int i, AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher, Allocator allocator) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hlsExtractorFactory, hlsPlaylistTracker, hlsDataSourceFactory, Integer.valueOf(i), eventDispatcher, allocator};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.extractorFactory = hlsExtractorFactory;
        this.playlistTracker = hlsPlaylistTracker;
        this.dataSourceFactory = hlsDataSourceFactory;
        this.minLoadableRetryCount = i;
        this.eventDispatcher = eventDispatcher;
        this.allocator = allocator;
        this.streamWrapperIndices = new IdentityHashMap<>();
        this.timestampAdjusterProvider = new TimestampAdjusterProvider();
        this.continueLoadingHandler = new Handler();
        this.sampleStreamWrappers = new HlsSampleStreamWrapper[0];
        this.enabledSampleStreamWrappers = new HlsSampleStreamWrapper[0];
    }

    private void buildAndPrepareSampleStreamWrappers(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65537, this, j) == null) {
            HlsMasterPlaylist masterPlaylist = this.playlistTracker.getMasterPlaylist();
            ArrayList arrayList = new ArrayList(masterPlaylist.variants);
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                HlsMasterPlaylist.HlsUrl hlsUrl = (HlsMasterPlaylist.HlsUrl) arrayList.get(i);
                if (hlsUrl.format.height <= 0 && !variantHasExplicitCodecWithPrefix(hlsUrl, "avc")) {
                    if (variantHasExplicitCodecWithPrefix(hlsUrl, AudioSampleEntry.TYPE3)) {
                        arrayList3.add(hlsUrl);
                    }
                } else {
                    arrayList2.add(hlsUrl);
                }
            }
            if (!arrayList2.isEmpty()) {
                arrayList = arrayList2;
            } else if (arrayList3.size() < arrayList.size()) {
                arrayList.removeAll(arrayList3);
            }
            List<HlsMasterPlaylist.HlsUrl> list = masterPlaylist.audios;
            List<HlsMasterPlaylist.HlsUrl> list2 = masterPlaylist.subtitles;
            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = new HlsSampleStreamWrapper[list.size() + 1 + list2.size()];
            this.sampleStreamWrappers = hlsSampleStreamWrapperArr;
            this.pendingPrepareCount = hlsSampleStreamWrapperArr.length;
            Assertions.checkArgument(!arrayList.isEmpty());
            HlsMasterPlaylist.HlsUrl[] hlsUrlArr = new HlsMasterPlaylist.HlsUrl[arrayList.size()];
            arrayList.toArray(hlsUrlArr);
            HlsSampleStreamWrapper buildSampleStreamWrapper = buildSampleStreamWrapper(0, hlsUrlArr, masterPlaylist.muxedAudioFormat, masterPlaylist.muxedCaptionFormats, j);
            this.sampleStreamWrappers[0] = buildSampleStreamWrapper;
            buildSampleStreamWrapper.setIsTimestampMaster(true);
            buildSampleStreamWrapper.continuePreparing();
            int i2 = 0;
            int i3 = 1;
            while (i2 < list.size()) {
                HlsSampleStreamWrapper buildSampleStreamWrapper2 = buildSampleStreamWrapper(1, new HlsMasterPlaylist.HlsUrl[]{list.get(i2)}, null, Collections.emptyList(), j);
                this.sampleStreamWrappers[i3] = buildSampleStreamWrapper2;
                buildSampleStreamWrapper2.continuePreparing();
                i2++;
                i3++;
            }
            int i4 = 0;
            while (i4 < list2.size()) {
                HlsMasterPlaylist.HlsUrl hlsUrl2 = list2.get(i4);
                HlsSampleStreamWrapper buildSampleStreamWrapper3 = buildSampleStreamWrapper(3, new HlsMasterPlaylist.HlsUrl[]{hlsUrl2}, null, Collections.emptyList(), j);
                buildSampleStreamWrapper3.prepareSingleTrack(hlsUrl2.format);
                this.sampleStreamWrappers[i3] = buildSampleStreamWrapper3;
                i4++;
                i3++;
            }
            this.enabledSampleStreamWrappers = this.sampleStreamWrappers;
        }
    }

    private HlsSampleStreamWrapper buildSampleStreamWrapper(int i, HlsMasterPlaylist.HlsUrl[] hlsUrlArr, Format format, List<Format> list, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i), hlsUrlArr, format, list, Long.valueOf(j)})) == null) ? new HlsSampleStreamWrapper(i, this, new HlsChunkSource(this.extractorFactory, this.playlistTracker, hlsUrlArr, this.dataSourceFactory, this.timestampAdjusterProvider, list), this.allocator, j, format, this.minLoadableRetryCount, this.eventDispatcher) : (HlsSampleStreamWrapper) invokeCommon.objValue;
    }

    private void continuePreparingOrLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (this.trackGroups != null) {
                this.callback.onContinueLoadingRequested(this);
                return;
            }
            for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
                hlsSampleStreamWrapper.continuePreparing();
            }
        }
    }

    public static boolean variantHasExplicitCodecWithPrefix(HlsMasterPlaylist.HlsUrl hlsUrl, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, hlsUrl, str)) == null) {
            String str2 = hlsUrl.format.codecs;
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            for (String str3 : str2.split("(\\s*,\\s*)|(\\s*$)")) {
                if (str3.startsWith(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
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
            for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.enabledSampleStreamWrappers) {
                hlsSampleStreamWrapper.discardBuffer(j);
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
            for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
                hlsSampleStreamWrapper.maybeThrowPrepareError();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
    public void onPlaylistBlacklisted(HlsMasterPlaylist.HlsUrl hlsUrl, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, hlsUrl, j) == null) {
            for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
                hlsSampleStreamWrapper.onPlaylistBlacklisted(hlsUrl, j);
            }
            continuePreparingOrLoading();
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
    public void onPlaylistChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            continuePreparingOrLoading();
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback
    public void onPlaylistRefreshRequired(HlsMasterPlaylist.HlsUrl hlsUrl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, hlsUrl) == null) {
            this.playlistTracker.refreshPlaylist(hlsUrl);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback
    public void onPrepared() {
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            int i = this.pendingPrepareCount - 1;
            this.pendingPrepareCount = i;
            if (i > 0) {
                return;
            }
            int i2 = 0;
            for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
                i2 += hlsSampleStreamWrapper.getTrackGroups().length;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i2];
            int i3 = 0;
            for (HlsSampleStreamWrapper hlsSampleStreamWrapper2 : this.sampleStreamWrappers) {
                int i4 = hlsSampleStreamWrapper2.getTrackGroups().length;
                int i5 = 0;
                while (i5 < i4) {
                    trackGroupArr[i3] = hlsSampleStreamWrapper2.getTrackGroups().get(i5);
                    i5++;
                    i3++;
                }
            }
            this.trackGroups = new TrackGroupArray(trackGroupArr);
            this.callback.onPrepared(this);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048588, this, callback, j) == null) {
            this.callback = callback;
            this.playlistTracker.addListener(this);
            buildAndPrepareSampleStreamWrappers(j);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? C.TIME_UNSET : invokeV.longValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.playlistTracker.removeListener(this);
            this.continueLoadingHandler.removeCallbacksAndMessages(null);
            for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
                hlsSampleStreamWrapper.release();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048591, this, j)) == null) {
            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.enabledSampleStreamWrappers;
            if (hlsSampleStreamWrapperArr.length > 0) {
                boolean seekToUs = hlsSampleStreamWrapperArr[0].seekToUs(j, false);
                int i = 1;
                while (true) {
                    HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = this.enabledSampleStreamWrappers;
                    if (i >= hlsSampleStreamWrapperArr2.length) {
                        break;
                    }
                    hlsSampleStreamWrapperArr2[i].seekToUs(j, seekToUs);
                    i++;
                }
                if (seekToUs) {
                    this.timestampAdjusterProvider.reset();
                }
            }
            return j;
        }
        return invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{trackSelectionArr, zArr, sampleStreamArr, zArr2, Long.valueOf(j)})) == null) {
            SampleStream[] sampleStreamArr2 = sampleStreamArr;
            int[] iArr = new int[trackSelectionArr.length];
            int[] iArr2 = new int[trackSelectionArr.length];
            for (int i = 0; i < trackSelectionArr.length; i++) {
                iArr[i] = sampleStreamArr2[i] == null ? -1 : this.streamWrapperIndices.get(sampleStreamArr2[i]).intValue();
                iArr2[i] = -1;
                if (trackSelectionArr[i] != null) {
                    TrackGroup trackGroup = trackSelectionArr[i].getTrackGroup();
                    int i2 = 0;
                    while (true) {
                        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.sampleStreamWrappers;
                        if (i2 >= hlsSampleStreamWrapperArr.length) {
                            break;
                        } else if (hlsSampleStreamWrapperArr[i2].getTrackGroups().indexOf(trackGroup) != -1) {
                            iArr2[i] = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            this.streamWrapperIndices.clear();
            int length = trackSelectionArr.length;
            SampleStream[] sampleStreamArr3 = new SampleStream[length];
            SampleStream[] sampleStreamArr4 = new SampleStream[trackSelectionArr.length];
            TrackSelection[] trackSelectionArr2 = new TrackSelection[trackSelectionArr.length];
            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = new HlsSampleStreamWrapper[this.sampleStreamWrappers.length];
            int i3 = 0;
            int i4 = 0;
            boolean z = false;
            while (i4 < this.sampleStreamWrappers.length) {
                for (int i5 = 0; i5 < trackSelectionArr.length; i5++) {
                    TrackSelection trackSelection = null;
                    sampleStreamArr4[i5] = iArr[i5] == i4 ? sampleStreamArr2[i5] : null;
                    if (iArr2[i5] == i4) {
                        trackSelection = trackSelectionArr[i5];
                    }
                    trackSelectionArr2[i5] = trackSelection;
                }
                HlsSampleStreamWrapper hlsSampleStreamWrapper = this.sampleStreamWrappers[i4];
                int i6 = i3;
                int i7 = length;
                int i8 = i4;
                TrackSelection[] trackSelectionArr3 = trackSelectionArr2;
                HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr3 = hlsSampleStreamWrapperArr2;
                boolean selectTracks = hlsSampleStreamWrapper.selectTracks(trackSelectionArr2, zArr, sampleStreamArr4, zArr2, j, z);
                int i9 = 0;
                boolean z2 = false;
                while (true) {
                    if (i9 >= trackSelectionArr.length) {
                        break;
                    }
                    if (iArr2[i9] == i8) {
                        Assertions.checkState(sampleStreamArr4[i9] != null);
                        sampleStreamArr3[i9] = sampleStreamArr4[i9];
                        this.streamWrapperIndices.put(sampleStreamArr4[i9], Integer.valueOf(i8));
                        z2 = true;
                    } else if (iArr[i9] == i8) {
                        Assertions.checkState(sampleStreamArr4[i9] == null);
                    }
                    i9++;
                }
                if (z2) {
                    hlsSampleStreamWrapperArr3[i6] = hlsSampleStreamWrapper;
                    i3 = i6 + 1;
                    if (i6 == 0) {
                        hlsSampleStreamWrapper.setIsTimestampMaster(true);
                        if (!selectTracks) {
                            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr4 = this.enabledSampleStreamWrappers;
                            if (hlsSampleStreamWrapperArr4.length != 0) {
                                if (hlsSampleStreamWrapper == hlsSampleStreamWrapperArr4[0]) {
                                }
                                this.timestampAdjusterProvider.reset();
                                z = true;
                            }
                        }
                        this.timestampAdjusterProvider.reset();
                        z = true;
                    } else {
                        hlsSampleStreamWrapper.setIsTimestampMaster(false);
                    }
                } else {
                    i3 = i6;
                }
                i4 = i8 + 1;
                hlsSampleStreamWrapperArr2 = hlsSampleStreamWrapperArr3;
                length = i7;
                trackSelectionArr2 = trackSelectionArr3;
                sampleStreamArr2 = sampleStreamArr;
            }
            System.arraycopy(sampleStreamArr3, 0, sampleStreamArr2, 0, length);
            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr5 = (HlsSampleStreamWrapper[]) Arrays.copyOf(hlsSampleStreamWrapperArr2, i3);
            this.enabledSampleStreamWrappers = hlsSampleStreamWrapperArr5;
            this.sequenceableLoader = new CompositeSequenceableLoader(hlsSampleStreamWrapperArr5);
            return j;
        }
        return invokeCommon.longValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, hlsSampleStreamWrapper) == null) || this.trackGroups == null) {
            return;
        }
        this.callback.onContinueLoadingRequested(this);
    }
}
