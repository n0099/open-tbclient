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
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.hls.HlsChunkSource;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public final class HlsSampleStreamWrapper implements Loader.Callback<Chunk>, Loader.ReleaseCallback, SequenceableLoader, ExtractorOutput, SampleQueue.UpstreamFormatChangedListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PRIMARY_TYPE_AUDIO = 2;
    public static final int PRIMARY_TYPE_NONE = 0;
    public static final int PRIMARY_TYPE_TEXT = 1;
    public static final int PRIMARY_TYPE_VIDEO = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public final Allocator allocator;
    public final Callback callback;
    public final HlsChunkSource chunkSource;
    public Format downstreamTrackFormat;
    public int enabledTrackCount;
    public final AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher;
    public final Handler handler;
    public boolean haveAudioVideoTrackGroups;
    public long lastSeekPositionUs;
    public final Loader loader;
    public boolean loadingFinished;
    public final Runnable maybeFinishPrepareRunnable;
    public final LinkedList<HlsMediaChunk> mediaChunks;
    public final int minLoadableRetryCount;
    public final Format muxedAudioFormat;
    public final HlsChunkSource.HlsChunkHolder nextChunkHolder;
    public long pendingResetPositionUs;
    public boolean pendingResetUpstreamFormats;
    public boolean prepared;
    public int primaryTrackGroupIndex;
    public boolean released;
    public long sampleOffsetUs;
    public int[] sampleQueueTrackIds;
    public SampleQueue[] sampleQueues;
    public boolean sampleQueuesBuilt;
    public boolean seenFirstTrackSelection;
    public boolean[] trackGroupEnabledStates;
    public boolean[] trackGroupIsAudioVideoFlags;
    public TrackGroupArray trackGroups;
    public final int trackType;

    /* loaded from: classes4.dex */
    public interface Callback extends SequenceableLoader.Callback<HlsSampleStreamWrapper> {
        void onPlaylistRefreshRequired(HlsMasterPlaylist.HlsUrl hlsUrl);

        void onPrepared();
    }

    public HlsSampleStreamWrapper(int i, Callback callback, HlsChunkSource hlsChunkSource, Allocator allocator, long j, Format format, int i2, AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), callback, hlsChunkSource, allocator, Long.valueOf(j), format, Integer.valueOf(i2), eventDispatcher};
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
        this.callback = callback;
        this.chunkSource = hlsChunkSource;
        this.allocator = allocator;
        this.muxedAudioFormat = format;
        this.minLoadableRetryCount = i2;
        this.eventDispatcher = eventDispatcher;
        this.loader = new Loader("Loader:HlsSampleStreamWrapper");
        this.nextChunkHolder = new HlsChunkSource.HlsChunkHolder();
        this.sampleQueueTrackIds = new int[0];
        this.sampleQueues = new SampleQueue[0];
        this.mediaChunks = new LinkedList<>();
        this.maybeFinishPrepareRunnable = new Runnable(this) { // from class: com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HlsSampleStreamWrapper this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.maybeFinishPrepare();
                }
            }
        };
        this.handler = new Handler();
        this.lastSeekPositionUs = j;
        this.pendingResetPositionUs = j;
    }

    private void buildTracks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            int length = this.sampleQueues.length;
            int i = 0;
            char c = 0;
            int i2 = -1;
            while (true) {
                char c2 = 3;
                if (i >= length) {
                    break;
                }
                String str = this.sampleQueues[i].getUpstreamFormat().sampleMimeType;
                if (!MimeTypes.isVideo(str)) {
                    if (MimeTypes.isAudio(str)) {
                        c2 = 2;
                    } else {
                        c2 = MimeTypes.isText(str) ? (char) 1 : (char) 0;
                    }
                }
                if (c2 > c) {
                    i2 = i;
                    c = c2;
                } else if (c2 == c && i2 != -1) {
                    i2 = -1;
                }
                i++;
            }
            TrackGroup trackGroup = this.chunkSource.getTrackGroup();
            int i3 = trackGroup.length;
            this.primaryTrackGroupIndex = -1;
            this.trackGroupEnabledStates = new boolean[length];
            this.trackGroupIsAudioVideoFlags = new boolean[length];
            TrackGroup[] trackGroupArr = new TrackGroup[length];
            for (int i4 = 0; i4 < length; i4++) {
                Format upstreamFormat = this.sampleQueues[i4].getUpstreamFormat();
                String str2 = upstreamFormat.sampleMimeType;
                boolean z = MimeTypes.isVideo(str2) || MimeTypes.isAudio(str2);
                this.trackGroupIsAudioVideoFlags[i4] = z;
                this.haveAudioVideoTrackGroups = z | this.haveAudioVideoTrackGroups;
                if (i4 == i2) {
                    Format[] formatArr = new Format[i3];
                    for (int i5 = 0; i5 < i3; i5++) {
                        formatArr[i5] = deriveFormat(trackGroup.getFormat(i5), upstreamFormat);
                    }
                    trackGroupArr[i4] = new TrackGroup(formatArr);
                    this.primaryTrackGroupIndex = i4;
                } else {
                    trackGroupArr[i4] = new TrackGroup(deriveFormat((c == 3 && MimeTypes.isAudio(upstreamFormat.sampleMimeType)) ? this.muxedAudioFormat : null, upstreamFormat));
                }
            }
            this.trackGroups = new TrackGroupArray(trackGroupArr);
        }
    }

    public static Format deriveFormat(Format format, Format format2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, format, format2)) == null) {
            if (format == null) {
                return format2;
            }
            String str = null;
            int trackType = MimeTypes.getTrackType(format2.sampleMimeType);
            if (trackType == 1) {
                str = getAudioCodecs(format.codecs);
            } else if (trackType == 2) {
                str = getVideoCodecs(format.codecs);
            }
            return format2.copyWithContainerInfo(format.id, str, format.bitrate, format.width, format.height, format.selectionFlags, format.language);
        }
        return (Format) invokeLL.objValue;
    }

    private void discardToRead() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || this.mediaChunks.isEmpty()) {
            return;
        }
        while (this.mediaChunks.size() > 1 && finishedReadingChunk(this.mediaChunks.getFirst())) {
            this.mediaChunks.removeFirst();
        }
        HlsMediaChunk first = this.mediaChunks.getFirst();
        Format format = first.trackFormat;
        if (!format.equals(this.downstreamTrackFormat)) {
            this.eventDispatcher.downstreamFormatChanged(this.trackType, format, first.trackSelectionReason, first.trackSelectionData, first.startTimeUs);
        }
        this.downstreamTrackFormat = format;
    }

    private boolean finishedReadingChunk(HlsMediaChunk hlsMediaChunk) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65541, this, hlsMediaChunk)) != null) {
            return invokeL.booleanValue;
        }
        int i = hlsMediaChunk.uid;
        int i2 = 0;
        while (true) {
            SampleQueue[] sampleQueueArr = this.sampleQueues;
            if (i2 >= sampleQueueArr.length) {
                return true;
            }
            if (this.trackGroupEnabledStates[i2] && sampleQueueArr[i2].peekSourceId() == i) {
                return false;
            }
            i2++;
        }
    }

    public static String getAudioCodecs(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? getCodecsOfType(str, 1) : (String) invokeL.objValue;
    }

    public static String getCodecsOfType(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String[] split = str.split("(\\s*,\\s*)|(\\s*$)");
            StringBuilder sb = new StringBuilder();
            for (String str2 : split) {
                if (i == MimeTypes.getTrackTypeOfCodec(str2)) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(str2);
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
            return null;
        }
        return (String) invokeLI.objValue;
    }

    public static String getVideoCodecs(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? getCodecsOfType(str, 2) : (String) invokeL.objValue;
    }

    private boolean isMediaChunk(Chunk chunk) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, this, chunk)) == null) ? chunk instanceof HlsMediaChunk : invokeL.booleanValue;
    }

    private boolean isPendingReset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.pendingResetPositionUs != C.TIME_UNSET : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeFinishPrepare() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || this.released || this.prepared || !this.sampleQueuesBuilt) {
            return;
        }
        for (SampleQueue sampleQueue : this.sampleQueues) {
            if (sampleQueue.getUpstreamFormat() == null) {
                return;
            }
        }
        buildTracks();
        this.prepared = true;
        this.callback.onPrepared();
    }

    private void resetSampleQueues() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            for (SampleQueue sampleQueue : this.sampleQueues) {
                sampleQueue.reset(this.pendingResetUpstreamFormats);
            }
            this.pendingResetUpstreamFormats = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0028, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean seekInsideBufferUs(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJ = interceptable.invokeJ(65549, this, j)) != null) {
            return invokeJ.booleanValue;
        }
        int length = this.sampleQueues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                return true;
            }
            SampleQueue sampleQueue = this.sampleQueues[i];
            sampleQueue.rewind();
            if ((sampleQueue.advanceTo(j, true, false) != -1) || (!this.trackGroupIsAudioVideoFlags[i] && this.haveAudioVideoTrackGroups)) {
                sampleQueue.discardToRead();
                i++;
            }
        }
    }

    private void setTrackGroupEnabledState(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            Assertions.checkState(this.trackGroupEnabledStates[i] != z);
            this.trackGroupEnabledStates[i] = z;
            this.enabledTrackCount += z ? 1 : -1;
        }
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        InterceptResult invokeJ;
        HlsMediaChunk last;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            if (this.loadingFinished || this.loader.isLoading()) {
                return false;
            }
            if (isPendingReset()) {
                last = null;
                j2 = this.pendingResetPositionUs;
            } else {
                last = this.mediaChunks.getLast();
                j2 = last.endTimeUs;
            }
            this.chunkSource.getNextChunk(last, j, j2, this.nextChunkHolder);
            HlsChunkSource.HlsChunkHolder hlsChunkHolder = this.nextChunkHolder;
            boolean z = hlsChunkHolder.endOfStream;
            Chunk chunk = hlsChunkHolder.chunk;
            HlsMasterPlaylist.HlsUrl hlsUrl = hlsChunkHolder.playlist;
            hlsChunkHolder.clear();
            if (z) {
                this.pendingResetPositionUs = C.TIME_UNSET;
                this.loadingFinished = true;
                return true;
            } else if (chunk == null) {
                if (hlsUrl != null) {
                    this.callback.onPlaylistRefreshRequired(hlsUrl);
                }
                return false;
            } else {
                if (isMediaChunk(chunk)) {
                    this.pendingResetPositionUs = C.TIME_UNSET;
                    HlsMediaChunk hlsMediaChunk = (HlsMediaChunk) chunk;
                    hlsMediaChunk.init(this);
                    this.mediaChunks.add(hlsMediaChunk);
                }
                this.eventDispatcher.loadStarted(chunk.dataSpec, chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, this.loader.startLoading(chunk, this, this.minLoadableRetryCount));
                return true;
            }
        }
        return invokeJ.booleanValue;
    }

    public void continuePreparing() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.prepared) {
            return;
        }
        continueLoading(this.lastSeekPositionUs);
    }

    public void discardBuffer(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            int length = this.sampleQueues.length;
            for (int i = 0; i < length; i++) {
                this.sampleQueues[i].discardTo(j, false, this.trackGroupEnabledStates[i]);
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.sampleQueuesBuilt = true;
            this.handler.post(this.maybeFinishPrepareRunnable);
        }
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        InterceptResult invokeV;
        LinkedList<HlsMediaChunk> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.loadingFinished) {
                return Long.MIN_VALUE;
            }
            if (isPendingReset()) {
                return this.pendingResetPositionUs;
            }
            long j = this.lastSeekPositionUs;
            HlsMediaChunk last = this.mediaChunks.getLast();
            if (!last.isLoadCompleted()) {
                last = this.mediaChunks.size() > 1 ? this.mediaChunks.get(linkedList.size() - 2) : null;
            }
            if (last != null) {
                j = Math.max(j, last.endTimeUs);
            }
            for (SampleQueue sampleQueue : this.sampleQueues) {
                j = Math.max(j, sampleQueue.getLargestQueuedTimestampUs());
            }
            return j;
        }
        return invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (isPendingReset()) {
                return this.pendingResetPositionUs;
            }
            if (this.loadingFinished) {
                return Long.MIN_VALUE;
            }
            return this.mediaChunks.getLast().endTimeUs;
        }
        return invokeV.longValue;
    }

    public TrackGroupArray getTrackGroups() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.trackGroups : (TrackGroupArray) invokeV.objValue;
    }

    public void init(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            for (SampleQueue sampleQueue : this.sampleQueues) {
                sampleQueue.sourceId(i);
            }
            if (z) {
                for (SampleQueue sampleQueue2 : this.sampleQueues) {
                    sampleQueue2.splice();
                }
            }
        }
    }

    public boolean isReady(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? this.loadingFinished || (!isPendingReset() && this.sampleQueues[i].hasNextSample()) : invokeI.booleanValue;
    }

    public void maybeThrowError() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.loader.maybeThrowError();
            this.chunkSource.maybeThrowError();
        }
    }

    public void maybeThrowPrepareError() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            maybeThrowError();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public void onLoaderReleased() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            resetSampleQueues();
        }
    }

    public void onPlaylistBlacklisted(HlsMasterPlaylist.HlsUrl hlsUrl, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048594, this, hlsUrl, j) == null) {
            this.chunkSource.onPlaylistBlacklisted(hlsUrl, j);
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener
    public void onUpstreamFormatChanged(Format format) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, format) == null) {
            this.handler.post(this.maybeFinishPrepareRunnable);
        }
    }

    public void prepareSingleTrack(Format format) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, format) == null) {
            track(0, -1).format(format);
            this.sampleQueuesBuilt = true;
            maybeFinishPrepare();
        }
    }

    public int readData(int i, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), formatHolder, decoderInputBuffer, Boolean.valueOf(z)})) == null) {
            if (isPendingReset()) {
                return -3;
            }
            int read = this.sampleQueues[i].read(formatHolder, decoderInputBuffer, z, this.loadingFinished, this.lastSeekPositionUs);
            if (read == -4) {
                discardToRead();
            }
            return read;
        }
        return invokeCommon.intValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            boolean release = this.loader.release(this);
            if (this.prepared && !release) {
                for (SampleQueue sampleQueue : this.sampleQueues) {
                    sampleQueue.discardToEnd();
                }
            }
            this.handler.removeCallbacksAndMessages(null);
            this.released = true;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, seekMap) == null) {
        }
    }

    public boolean seekToUs(long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            this.lastSeekPositionUs = j;
            if (z || isPendingReset() || !seekInsideBufferUs(j)) {
                this.pendingResetPositionUs = j;
                this.loadingFinished = false;
                this.mediaChunks.clear();
                if (this.loader.isLoading()) {
                    this.loader.cancelLoading();
                    return true;
                }
                resetSampleQueues();
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j, boolean z) {
        InterceptResult invokeCommon;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{trackSelectionArr, zArr, sampleStreamArr, zArr2, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            Assertions.checkState(this.prepared);
            int i = this.enabledTrackCount;
            int i2 = 0;
            for (int i3 = 0; i3 < trackSelectionArr.length; i3++) {
                if (sampleStreamArr[i3] != null && (trackSelectionArr[i3] == null || !zArr[i3])) {
                    setTrackGroupEnabledState(((HlsSampleStream) sampleStreamArr[i3]).group, false);
                    sampleStreamArr[i3] = null;
                }
            }
            boolean z4 = z || (!this.seenFirstTrackSelection ? j == this.lastSeekPositionUs : i != 0);
            TrackSelection trackSelection = this.chunkSource.getTrackSelection();
            boolean z5 = z4;
            TrackSelection trackSelection2 = trackSelection;
            for (int i4 = 0; i4 < trackSelectionArr.length; i4++) {
                if (sampleStreamArr[i4] == null && trackSelectionArr[i4] != null) {
                    TrackSelection trackSelection3 = trackSelectionArr[i4];
                    int indexOf = this.trackGroups.indexOf(trackSelection3.getTrackGroup());
                    setTrackGroupEnabledState(indexOf, true);
                    if (indexOf == this.primaryTrackGroupIndex) {
                        this.chunkSource.selectTracks(trackSelection3);
                        trackSelection2 = trackSelection3;
                    }
                    sampleStreamArr[i4] = new HlsSampleStream(this, indexOf);
                    zArr2[i4] = true;
                    if (!z5) {
                        SampleQueue sampleQueue = this.sampleQueues[indexOf];
                        sampleQueue.rewind();
                        z5 = sampleQueue.advanceTo(j, true, true) == -1 && sampleQueue.getReadIndex() != 0;
                    }
                }
            }
            if (this.enabledTrackCount == 0) {
                this.chunkSource.reset();
                this.downstreamTrackFormat = null;
                this.mediaChunks.clear();
                if (this.loader.isLoading()) {
                    SampleQueue[] sampleQueueArr = this.sampleQueues;
                    int length = sampleQueueArr.length;
                    while (i2 < length) {
                        sampleQueueArr[i2].discardToEnd();
                        i2++;
                    }
                    this.loader.cancelLoading();
                } else {
                    resetSampleQueues();
                }
            } else {
                if (!this.mediaChunks.isEmpty() && !Util.areEqual(trackSelection2, trackSelection)) {
                    if (!this.seenFirstTrackSelection) {
                        trackSelection2.updateSelectedTrack(j, j < 0 ? -j : 0L, C.TIME_UNSET);
                        if (trackSelection2.getSelectedIndexInTrackGroup() == this.chunkSource.getTrackGroup().indexOf(this.mediaChunks.getLast().trackFormat)) {
                            z3 = false;
                            if (z3) {
                                this.pendingResetUpstreamFormats = true;
                                z2 = true;
                                z5 = true;
                                if (z5) {
                                    seekToUs(j, z2);
                                    while (i2 < sampleStreamArr.length) {
                                        if (sampleStreamArr[i2] != null) {
                                            zArr2[i2] = true;
                                        }
                                        i2++;
                                    }
                                }
                            }
                        }
                    }
                    z3 = true;
                    if (z3) {
                    }
                }
                z2 = z;
                if (z5) {
                }
            }
            this.seenFirstTrackSelection = true;
            return z5;
        }
        return invokeCommon.booleanValue;
    }

    public void setIsTimestampMaster(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.chunkSource.setIsTimestampMaster(z);
        }
    }

    public void setSampleOffsetUs(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048603, this, j) == null) {
            this.sampleOffsetUs = j;
            for (SampleQueue sampleQueue : this.sampleQueues) {
                sampleQueue.setSampleOffsetUs(j);
            }
        }
    }

    public int skipData(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            int i2 = 0;
            if (isPendingReset()) {
                return 0;
            }
            SampleQueue sampleQueue = this.sampleQueues[i];
            if (this.loadingFinished && j > sampleQueue.getLargestQueuedTimestampUs()) {
                i2 = sampleQueue.advanceToEnd();
            } else {
                int advanceTo = sampleQueue.advanceTo(j, true, true);
                if (advanceTo != -1) {
                    i2 = advanceTo;
                }
            }
            if (i2 > 0) {
                discardToRead();
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(Chunk chunk, long j, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{chunk, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.eventDispatcher.loadCanceled(chunk.dataSpec, chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j, j2, chunk.bytesLoaded());
            if (z) {
                return;
            }
            resetSampleQueues();
            if (this.enabledTrackCount > 0) {
                this.callback.onContinueLoadingRequested(this);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(Chunk chunk, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{chunk, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.chunkSource.onChunkLoadCompleted(chunk);
            this.eventDispatcher.loadCompleted(chunk.dataSpec, chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j, j2, chunk.bytesLoaded());
            if (!this.prepared) {
                continueLoading(this.lastSeekPositionUs);
            } else {
                this.callback.onContinueLoadingRequested(this);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public int onLoadError(Chunk chunk, long j, long j2, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{chunk, Long.valueOf(j), Long.valueOf(j2), iOException})) == null) {
            long bytesLoaded = chunk.bytesLoaded();
            boolean isMediaChunk = isMediaChunk(chunk);
            boolean z = true;
            if (!this.chunkSource.onChunkLoadError(chunk, !isMediaChunk || bytesLoaded == 0, iOException)) {
                z = false;
            } else if (isMediaChunk) {
                Assertions.checkState(this.mediaChunks.removeLast() == chunk);
                if (this.mediaChunks.isEmpty()) {
                    this.pendingResetPositionUs = this.lastSeekPositionUs;
                }
            }
            this.eventDispatcher.loadError(chunk.dataSpec, chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j, j2, chunk.bytesLoaded(), iOException, z);
            if (z) {
                if (!this.prepared) {
                    continueLoading(this.lastSeekPositionUs);
                    return 2;
                }
                this.callback.onContinueLoadingRequested(this);
                return 2;
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public SampleQueue track(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048606, this, i, i2)) == null) {
            int length = this.sampleQueues.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (this.sampleQueueTrackIds[i3] == i) {
                    return this.sampleQueues[i3];
                }
            }
            SampleQueue sampleQueue = new SampleQueue(this.allocator);
            sampleQueue.setSampleOffsetUs(this.sampleOffsetUs);
            sampleQueue.setUpstreamFormatChangeListener(this);
            int i4 = length + 1;
            int[] copyOf = Arrays.copyOf(this.sampleQueueTrackIds, i4);
            this.sampleQueueTrackIds = copyOf;
            copyOf[length] = i;
            SampleQueue[] sampleQueueArr = (SampleQueue[]) Arrays.copyOf(this.sampleQueues, i4);
            this.sampleQueues = sampleQueueArr;
            sampleQueueArr[length] = sampleQueue;
            return sampleQueue;
        }
        return (SampleQueue) invokeII.objValue;
    }
}
