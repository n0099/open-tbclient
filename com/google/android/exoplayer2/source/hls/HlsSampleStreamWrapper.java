package com.google.android.exoplayer2.source.hls;

import android.os.Handler;
import android.text.TextUtils;
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
/* loaded from: classes9.dex */
public final class HlsSampleStreamWrapper implements Loader.Callback<Chunk>, Loader.ReleaseCallback, SequenceableLoader, ExtractorOutput, SampleQueue.UpstreamFormatChangedListener {
    public static final int PRIMARY_TYPE_AUDIO = 2;
    public static final int PRIMARY_TYPE_NONE = 0;
    public static final int PRIMARY_TYPE_TEXT = 1;
    public static final int PRIMARY_TYPE_VIDEO = 3;
    public final Allocator allocator;
    public final Callback callback;
    public final HlsChunkSource chunkSource;
    public Format downstreamTrackFormat;
    public int enabledTrackCount;
    public final AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher;
    public boolean haveAudioVideoTrackGroups;
    public long lastSeekPositionUs;
    public boolean loadingFinished;
    public final int minLoadableRetryCount;
    public final Format muxedAudioFormat;
    public long pendingResetPositionUs;
    public boolean pendingResetUpstreamFormats;
    public boolean prepared;
    public int primaryTrackGroupIndex;
    public boolean released;
    public long sampleOffsetUs;
    public boolean sampleQueuesBuilt;
    public boolean seenFirstTrackSelection;
    public boolean[] trackGroupEnabledStates;
    public boolean[] trackGroupIsAudioVideoFlags;
    public TrackGroupArray trackGroups;
    public final int trackType;
    public final Loader loader = new Loader("Loader:HlsSampleStreamWrapper");
    public final HlsChunkSource.HlsChunkHolder nextChunkHolder = new HlsChunkSource.HlsChunkHolder();
    public int[] sampleQueueTrackIds = new int[0];
    public SampleQueue[] sampleQueues = new SampleQueue[0];
    public final LinkedList<HlsMediaChunk> mediaChunks = new LinkedList<>();
    public final Runnable maybeFinishPrepareRunnable = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.1
        @Override // java.lang.Runnable
        public void run() {
            HlsSampleStreamWrapper.this.maybeFinishPrepare();
        }
    };
    public final Handler handler = new Handler();

    /* loaded from: classes9.dex */
    public interface Callback extends SequenceableLoader.Callback<HlsSampleStreamWrapper> {
        void onPlaylistRefreshRequired(HlsMasterPlaylist.HlsUrl hlsUrl);

        void onPrepared();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap) {
    }

    public HlsSampleStreamWrapper(int i, Callback callback, HlsChunkSource hlsChunkSource, Allocator allocator, long j, Format format, int i2, AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher) {
        this.trackType = i;
        this.callback = callback;
        this.chunkSource = hlsChunkSource;
        this.allocator = allocator;
        this.muxedAudioFormat = format;
        this.minLoadableRetryCount = i2;
        this.eventDispatcher = eventDispatcher;
        this.lastSeekPositionUs = j;
        this.pendingResetPositionUs = j;
    }

    private boolean finishedReadingChunk(HlsMediaChunk hlsMediaChunk) {
        int i = hlsMediaChunk.uid;
        int i2 = 0;
        while (true) {
            SampleQueue[] sampleQueueArr = this.sampleQueues;
            if (i2 < sampleQueueArr.length) {
                if (this.trackGroupEnabledStates[i2] && sampleQueueArr[i2].peekSourceId() == i) {
                    return false;
                }
                i2++;
            } else {
                return true;
            }
        }
    }

    public static String getAudioCodecs(String str) {
        return getCodecsOfType(str, 1);
    }

    public static String getVideoCodecs(String str) {
        return getCodecsOfType(str, 2);
    }

    private boolean isMediaChunk(Chunk chunk) {
        return chunk instanceof HlsMediaChunk;
    }

    private boolean seekInsideBufferUs(long j) {
        int length = this.sampleQueues.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                return true;
            }
            SampleQueue sampleQueue = this.sampleQueues[i];
            sampleQueue.rewind();
            if (sampleQueue.advanceTo(j, true, false) == -1) {
                z = false;
            }
            if (z || (!this.trackGroupIsAudioVideoFlags[i] && this.haveAudioVideoTrackGroups)) {
                sampleQueue.discardToRead();
                i++;
            }
        }
        return false;
    }

    public void discardBuffer(long j) {
        int length = this.sampleQueues.length;
        for (int i = 0; i < length; i++) {
            this.sampleQueues[i].discardTo(j, false, this.trackGroupEnabledStates[i]);
        }
    }

    public boolean isReady(int i) {
        if (!this.loadingFinished && (isPendingReset() || !this.sampleQueues[i].hasNextSample())) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener
    public void onUpstreamFormatChanged(Format format) {
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    public void prepareSingleTrack(Format format) {
        track(0, -1).format(format);
        this.sampleQueuesBuilt = true;
        maybeFinishPrepare();
    }

    public void setIsTimestampMaster(boolean z) {
        this.chunkSource.setIsTimestampMaster(z);
    }

    public void setSampleOffsetUs(long j) {
        this.sampleOffsetUs = j;
        for (SampleQueue sampleQueue : this.sampleQueues) {
            sampleQueue.setSampleOffsetUs(j);
        }
    }

    private void buildTracks() {
        boolean z;
        Format format;
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
                } else if (MimeTypes.isText(str)) {
                    c2 = 1;
                } else {
                    c2 = 0;
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
            if (!MimeTypes.isVideo(str2) && !MimeTypes.isAudio(str2)) {
                z = false;
            } else {
                z = true;
            }
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
                if (c == 3 && MimeTypes.isAudio(upstreamFormat.sampleMimeType)) {
                    format = this.muxedAudioFormat;
                } else {
                    format = null;
                }
                trackGroupArr[i4] = new TrackGroup(deriveFormat(format, upstreamFormat));
            }
        }
        this.trackGroups = new TrackGroupArray(trackGroupArr);
    }

    public static Format deriveFormat(Format format, Format format2) {
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

    private void setTrackGroupEnabledState(int i, boolean z) {
        boolean z2;
        int i2 = 1;
        if (this.trackGroupEnabledStates[i] != z) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.checkState(z2);
        this.trackGroupEnabledStates[i] = z;
        int i3 = this.enabledTrackCount;
        if (!z) {
            i2 = -1;
        }
        this.enabledTrackCount = i3 + i2;
    }

    public void init(int i, boolean z) {
        for (SampleQueue sampleQueue : this.sampleQueues) {
            sampleQueue.sourceId(i);
        }
        if (z) {
            for (SampleQueue sampleQueue2 : this.sampleQueues) {
                sampleQueue2.splice();
            }
        }
    }

    public void onPlaylistBlacklisted(HlsMasterPlaylist.HlsUrl hlsUrl, long j) {
        this.chunkSource.onPlaylistBlacklisted(hlsUrl, j);
    }

    public boolean seekToUs(long j, boolean z) {
        this.lastSeekPositionUs = j;
        if (!z && !isPendingReset() && seekInsideBufferUs(j)) {
            return false;
        }
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

    public int skipData(int i, long j) {
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

    private void discardToRead() {
        if (!this.mediaChunks.isEmpty()) {
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
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        LinkedList<HlsMediaChunk> linkedList;
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        long j = this.lastSeekPositionUs;
        HlsMediaChunk last = this.mediaChunks.getLast();
        if (!last.isLoadCompleted()) {
            if (this.mediaChunks.size() > 1) {
                last = this.mediaChunks.get(linkedList.size() - 2);
            } else {
                last = null;
            }
        }
        if (last != null) {
            j = Math.max(j, last.endTimeUs);
        }
        for (SampleQueue sampleQueue : this.sampleQueues) {
            j = Math.max(j, sampleQueue.getLargestQueuedTimestampUs());
        }
        return j;
    }

    public static String getCodecsOfType(String str, int i) {
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
        if (sb.length() <= 0) {
            return null;
        }
        return sb.toString();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public SampleQueue track(int i, int i2) {
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

    private boolean isPendingReset() {
        if (this.pendingResetPositionUs != C.TIME_UNSET) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeFinishPrepare() {
        if (!this.released && !this.prepared && this.sampleQueuesBuilt) {
            for (SampleQueue sampleQueue : this.sampleQueues) {
                if (sampleQueue.getUpstreamFormat() == null) {
                    return;
                }
            }
            buildTracks();
            this.prepared = true;
            this.callback.onPrepared();
        }
    }

    private void resetSampleQueues() {
        for (SampleQueue sampleQueue : this.sampleQueues) {
            sampleQueue.reset(this.pendingResetUpstreamFormats);
        }
        this.pendingResetUpstreamFormats = false;
    }

    public void continuePreparing() {
        if (!this.prepared) {
            continueLoading(this.lastSeekPositionUs);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        this.sampleQueuesBuilt = true;
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        return this.mediaChunks.getLast().endTimeUs;
    }

    public TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    public void maybeThrowError() throws IOException {
        this.loader.maybeThrowError();
        this.chunkSource.maybeThrowError();
    }

    public void maybeThrowPrepareError() throws IOException {
        maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public void onLoaderReleased() {
        resetSampleQueues();
    }

    public void release() {
        boolean release = this.loader.release(this);
        if (this.prepared && !release) {
            for (SampleQueue sampleQueue : this.sampleQueues) {
                sampleQueue.discardToEnd();
            }
        }
        this.handler.removeCallbacksAndMessages(null);
        this.released = true;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        HlsMediaChunk last;
        long j2;
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(Chunk chunk, long j, long j2, boolean z) {
        this.eventDispatcher.loadCanceled(chunk.dataSpec, chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j, j2, chunk.bytesLoaded());
        if (!z) {
            resetSampleQueues();
            if (this.enabledTrackCount > 0) {
                this.callback.onContinueLoadingRequested(this);
            }
        }
    }

    public int readData(int i, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        if (isPendingReset()) {
            return -3;
        }
        int read = this.sampleQueues[i].read(formatHolder, decoderInputBuffer, z, this.loadingFinished, this.lastSeekPositionUs);
        if (read == -4) {
            discardToRead();
        }
        return read;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(Chunk chunk, long j, long j2) {
        this.chunkSource.onChunkLoadCompleted(chunk);
        this.eventDispatcher.loadCompleted(chunk.dataSpec, chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j, j2, chunk.bytesLoaded());
        if (!this.prepared) {
            continueLoading(this.lastSeekPositionUs);
        } else {
            this.callback.onContinueLoadingRequested(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public int onLoadError(Chunk chunk, long j, long j2, IOException iOException) {
        boolean z;
        boolean z2;
        long bytesLoaded = chunk.bytesLoaded();
        boolean isMediaChunk = isMediaChunk(chunk);
        boolean z3 = true;
        if (isMediaChunk && bytesLoaded != 0) {
            z = false;
        } else {
            z = true;
        }
        if (this.chunkSource.onChunkLoadError(chunk, z, iOException)) {
            if (isMediaChunk) {
                if (this.mediaChunks.removeLast() == chunk) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Assertions.checkState(z2);
                if (this.mediaChunks.isEmpty()) {
                    this.pendingResetPositionUs = this.lastSeekPositionUs;
                }
            }
        } else {
            z3 = false;
        }
        this.eventDispatcher.loadError(chunk.dataSpec, chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j, j2, chunk.bytesLoaded(), iOException, z3);
        if (!z3) {
            return 0;
        }
        if (!this.prepared) {
            continueLoading(this.lastSeekPositionUs);
            return 2;
        }
        this.callback.onContinueLoadingRequested(this);
        return 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Assertions.checkState(this.prepared);
        int i = this.enabledTrackCount;
        int i2 = 0;
        for (int i3 = 0; i3 < trackSelectionArr.length; i3++) {
            if (sampleStreamArr[i3] != null && (trackSelectionArr[i3] == null || !zArr[i3])) {
                setTrackGroupEnabledState(((HlsSampleStream) sampleStreamArr[i3]).group, false);
                sampleStreamArr[i3] = null;
            }
        }
        if (!z && (!this.seenFirstTrackSelection ? j == this.lastSeekPositionUs : i != 0)) {
            z2 = false;
        } else {
            z2 = true;
        }
        TrackSelection trackSelection = this.chunkSource.getTrackSelection();
        boolean z6 = z2;
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
                if (!z6) {
                    SampleQueue sampleQueue = this.sampleQueues[indexOf];
                    sampleQueue.rewind();
                    if (sampleQueue.advanceTo(j, true, true) == -1 && sampleQueue.getReadIndex() != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    z6 = z5;
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
                    long j2 = 0;
                    if (j < 0) {
                        j2 = -j;
                    }
                    trackSelection2.updateSelectedTrack(j, j2, C.TIME_UNSET);
                    if (trackSelection2.getSelectedIndexInTrackGroup() == this.chunkSource.getTrackGroup().indexOf(this.mediaChunks.getLast().trackFormat)) {
                        z4 = false;
                        if (z4) {
                            this.pendingResetUpstreamFormats = true;
                            z3 = true;
                            z6 = true;
                            if (z6) {
                                seekToUs(j, z3);
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
                z4 = true;
                if (z4) {
                }
            }
            z3 = z;
            if (z6) {
            }
        }
        this.seenFirstTrackSelection = true;
        return z6;
    }
}
