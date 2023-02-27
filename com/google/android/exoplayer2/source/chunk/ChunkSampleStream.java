package com.google.android.exoplayer2.source.chunk;

import android.util.Log;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class ChunkSampleStream<T extends ChunkSource> implements SampleStream, SequenceableLoader, Loader.Callback<Chunk>, Loader.ReleaseCallback {
    public static final String TAG = "ChunkSampleStream";
    public final SequenceableLoader.Callback<ChunkSampleStream<T>> callback;
    public final T chunkSource;
    public final SampleQueue[] embeddedSampleQueues;
    public final int[] embeddedTrackTypes;
    public final boolean[] embeddedTracksSelected;
    public final AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher;
    public long lastSeekPositionUs;
    public boolean loadingFinished;
    public final BaseMediaChunkOutput mediaChunkOutput;
    public final LinkedList<BaseMediaChunk> mediaChunks;
    public final int minLoadableRetryCount;
    public long pendingResetPositionUs;
    public Format primaryDownstreamTrackFormat;
    public final SampleQueue primarySampleQueue;
    public final int primaryTrackType;
    public final List<BaseMediaChunk> readOnlyMediaChunks;
    public final Loader loader = new Loader("Loader:ChunkSampleStream");
    public final ChunkHolder nextChunkHolder = new ChunkHolder();

    /* loaded from: classes7.dex */
    public final class EmbeddedSampleStream implements SampleStream {
        public final int index;
        public final ChunkSampleStream<T> parent;
        public final SampleQueue sampleQueue;

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws IOException {
        }

        public EmbeddedSampleStream(ChunkSampleStream<T> chunkSampleStream, SampleQueue sampleQueue, int i) {
            this.parent = chunkSampleStream;
            this.sampleQueue = sampleQueue;
            this.index = i;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            ChunkSampleStream chunkSampleStream = ChunkSampleStream.this;
            if (!chunkSampleStream.loadingFinished && (chunkSampleStream.isPendingReset() || !this.sampleQueue.hasNextSample())) {
                return false;
            }
            return true;
        }

        public void release() {
            Assertions.checkState(ChunkSampleStream.this.embeddedTracksSelected[this.index]);
            ChunkSampleStream.this.embeddedTracksSelected[this.index] = false;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            if (ChunkSampleStream.this.isPendingReset()) {
                return -3;
            }
            SampleQueue sampleQueue = this.sampleQueue;
            ChunkSampleStream chunkSampleStream = ChunkSampleStream.this;
            return sampleQueue.read(formatHolder, decoderInputBuffer, z, chunkSampleStream.loadingFinished, chunkSampleStream.lastSeekPositionUs);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            if (ChunkSampleStream.this.loadingFinished && j > this.sampleQueue.getLargestQueuedTimestampUs()) {
                return this.sampleQueue.advanceToEnd();
            }
            int advanceTo = this.sampleQueue.advanceTo(j, true, true);
            if (advanceTo == -1) {
                return 0;
            }
            return advanceTo;
        }
    }

    public ChunkSampleStream(int i, int[] iArr, T t, SequenceableLoader.Callback<ChunkSampleStream<T>> callback, Allocator allocator, long j, int i2, AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher) {
        int length;
        this.primaryTrackType = i;
        this.embeddedTrackTypes = iArr;
        this.chunkSource = t;
        this.callback = callback;
        this.eventDispatcher = eventDispatcher;
        this.minLoadableRetryCount = i2;
        LinkedList<BaseMediaChunk> linkedList = new LinkedList<>();
        this.mediaChunks = linkedList;
        this.readOnlyMediaChunks = Collections.unmodifiableList(linkedList);
        int i3 = 0;
        if (iArr == null) {
            length = 0;
        } else {
            length = iArr.length;
        }
        this.embeddedSampleQueues = new SampleQueue[length];
        this.embeddedTracksSelected = new boolean[length];
        int i4 = length + 1;
        int[] iArr2 = new int[i4];
        SampleQueue[] sampleQueueArr = new SampleQueue[i4];
        SampleQueue sampleQueue = new SampleQueue(allocator);
        this.primarySampleQueue = sampleQueue;
        iArr2[0] = i;
        sampleQueueArr[0] = sampleQueue;
        while (i3 < length) {
            SampleQueue sampleQueue2 = new SampleQueue(allocator);
            this.embeddedSampleQueues[i3] = sampleQueue2;
            int i5 = i3 + 1;
            sampleQueueArr[i5] = sampleQueue2;
            iArr2[i5] = iArr[i3];
            i3 = i5;
        }
        this.mediaChunkOutput = new BaseMediaChunkOutput(iArr2, sampleQueueArr);
        this.pendingResetPositionUs = j;
        this.lastSeekPositionUs = j;
    }

    private boolean isMediaChunk(Chunk chunk) {
        return chunk instanceof BaseMediaChunk;
    }

    private void maybeDiscardUpstream(long j) {
        discardUpstreamMediaChunks(Math.max(1, this.chunkSource.getPreferredQueueSize(j, this.readOnlyMediaChunks)));
    }

    public void discardEmbeddedTracksTo(long j) {
        int i = 0;
        while (true) {
            SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
            if (i < sampleQueueArr.length) {
                sampleQueueArr[i].discardTo(j, true, this.embeddedTracksSelected[i]);
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int skipData(long j) {
        int i = 0;
        if (isPendingReset()) {
            return 0;
        }
        if (this.loadingFinished && j > this.primarySampleQueue.getLargestQueuedTimestampUs()) {
            i = this.primarySampleQueue.advanceToEnd();
        } else {
            int advanceTo = this.primarySampleQueue.advanceTo(j, true, true);
            if (advanceTo != -1) {
                i = advanceTo;
            }
        }
        if (i > 0) {
            this.primarySampleQueue.discardToRead();
        }
        return i;
    }

    private void discardDownstreamMediaChunks(int i) {
        if (!this.mediaChunks.isEmpty()) {
            while (this.mediaChunks.size() > 1 && this.mediaChunks.get(1).getFirstSampleIndex(0) <= i) {
                this.mediaChunks.removeFirst();
            }
            BaseMediaChunk first = this.mediaChunks.getFirst();
            Format format = first.trackFormat;
            if (!format.equals(this.primaryDownstreamTrackFormat)) {
                this.eventDispatcher.downstreamFormatChanged(this.primaryTrackType, format, first.trackSelectionReason, first.trackSelectionData, first.startTimeUs);
            }
            this.primaryDownstreamTrackFormat = format;
        }
    }

    private boolean discardUpstreamMediaChunks(int i) {
        BaseMediaChunk removeLast;
        long j;
        if (this.mediaChunks.size() <= i) {
            return false;
        }
        long j2 = this.mediaChunks.getLast().endTimeUs;
        do {
            removeLast = this.mediaChunks.removeLast();
            j = removeLast.startTimeUs;
        } while (this.mediaChunks.size() > i);
        this.primarySampleQueue.discardUpstreamSamples(removeLast.getFirstSampleIndex(0));
        int i2 = 0;
        while (true) {
            SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
            if (i2 < sampleQueueArr.length) {
                SampleQueue sampleQueue = sampleQueueArr[i2];
                i2++;
                sampleQueue.discardUpstreamSamples(removeLast.getFirstSampleIndex(i2));
            } else {
                this.loadingFinished = false;
                this.eventDispatcher.upstreamDiscarded(this.primaryTrackType, j, j2);
                return true;
            }
        }
    }

    private boolean haveReadFromLastMediaChunk() {
        int readIndex;
        BaseMediaChunk last = this.mediaChunks.getLast();
        if (this.primarySampleQueue.getReadIndex() > last.getFirstSampleIndex(0)) {
            return true;
        }
        int i = 0;
        do {
            SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
            if (i >= sampleQueueArr.length) {
                return false;
            }
            readIndex = sampleQueueArr[i].getReadIndex();
            i++;
        } while (readIndex <= last.getFirstSampleIndex(i));
        return true;
    }

    public T getChunkSource() {
        return this.chunkSource;
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

    public boolean isPendingReset() {
        if (this.pendingResetPositionUs != C.TIME_UNSET) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        if (!this.loadingFinished && (isPendingReset() || !this.primarySampleQueue.hasNextSample())) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() throws IOException {
        this.loader.maybeThrowError();
        if (!this.loader.isLoading()) {
            this.chunkSource.maybeThrowError();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public void onLoaderReleased() {
        this.primarySampleQueue.reset();
        for (SampleQueue sampleQueue : this.embeddedSampleQueues) {
            sampleQueue.reset();
        }
    }

    public void release() {
        if (!this.loader.release(this)) {
            this.primarySampleQueue.discardToEnd();
            for (SampleQueue sampleQueue : this.embeddedSampleQueues) {
                sampleQueue.discardToEnd();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        BaseMediaChunk last;
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
        ChunkHolder chunkHolder = this.nextChunkHolder;
        boolean z = chunkHolder.endOfStream;
        Chunk chunk = chunkHolder.chunk;
        chunkHolder.clear();
        if (z) {
            this.pendingResetPositionUs = C.TIME_UNSET;
            this.loadingFinished = true;
            return true;
        } else if (chunk == null) {
            return false;
        } else {
            if (isMediaChunk(chunk)) {
                this.pendingResetPositionUs = C.TIME_UNSET;
                BaseMediaChunk baseMediaChunk = (BaseMediaChunk) chunk;
                baseMediaChunk.init(this.mediaChunkOutput);
                this.mediaChunks.add(baseMediaChunk);
            }
            this.eventDispatcher.loadStarted(chunk.dataSpec, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, this.loader.startLoading(chunk, this, this.minLoadableRetryCount));
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void seekToUs(long j) {
        boolean z;
        SampleQueue[] sampleQueueArr;
        boolean z2;
        this.lastSeekPositionUs = j;
        if (!isPendingReset()) {
            SampleQueue sampleQueue = this.primarySampleQueue;
            if (j < getNextLoadPositionUs()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (sampleQueue.advanceTo(j, true, z2) != -1) {
                z = true;
                if (!z) {
                    discardDownstreamMediaChunks(this.primarySampleQueue.getReadIndex());
                    this.primarySampleQueue.discardToRead();
                    for (SampleQueue sampleQueue2 : this.embeddedSampleQueues) {
                        sampleQueue2.rewind();
                        sampleQueue2.discardTo(j, true, false);
                    }
                    return;
                }
                this.pendingResetPositionUs = j;
                this.loadingFinished = false;
                this.mediaChunks.clear();
                if (this.loader.isLoading()) {
                    this.loader.cancelLoading();
                    return;
                }
                this.primarySampleQueue.reset();
                for (SampleQueue sampleQueue3 : this.embeddedSampleQueues) {
                    sampleQueue3.reset();
                }
                return;
            }
        }
        z = false;
        if (!z) {
        }
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        long j = this.lastSeekPositionUs;
        BaseMediaChunk last = this.mediaChunks.getLast();
        if (!last.isLoadCompleted()) {
            if (this.mediaChunks.size() > 1) {
                LinkedList<BaseMediaChunk> linkedList = this.mediaChunks;
                last = linkedList.get(linkedList.size() - 2);
            } else {
                last = null;
            }
        }
        if (last != null) {
            j = Math.max(j, last.endTimeUs);
        }
        return Math.max(j, this.primarySampleQueue.getLargestQueuedTimestampUs());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(Chunk chunk, long j, long j2, boolean z) {
        this.eventDispatcher.loadCanceled(chunk.dataSpec, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j, j2, chunk.bytesLoaded());
        if (!z) {
            this.primarySampleQueue.reset();
            for (SampleQueue sampleQueue : this.embeddedSampleQueues) {
                sampleQueue.reset();
            }
            this.callback.onContinueLoadingRequested(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(Chunk chunk, long j, long j2) {
        this.chunkSource.onChunkLoadCompleted(chunk);
        this.eventDispatcher.loadCompleted(chunk.dataSpec, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j, j2, chunk.bytesLoaded());
        this.callback.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        if (isPendingReset()) {
            return -3;
        }
        discardDownstreamMediaChunks(this.primarySampleQueue.getReadIndex());
        int read = this.primarySampleQueue.read(formatHolder, decoderInputBuffer, z, this.loadingFinished, this.lastSeekPositionUs);
        if (read == -4) {
            this.primarySampleQueue.discardToRead();
        }
        return read;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int onLoadError(Chunk chunk, long j, long j2, IOException iOException) {
        boolean z;
        boolean z2;
        boolean z3;
        long bytesLoaded = chunk.bytesLoaded();
        boolean isMediaChunk = isMediaChunk(chunk);
        if (bytesLoaded != 0 && isMediaChunk && haveReadFromLastMediaChunk()) {
            z = false;
        } else {
            z = true;
        }
        if (this.chunkSource.onChunkLoadError(chunk, z, iOException)) {
            if (!z) {
                Log.w(TAG, "Ignoring attempt to cancel non-cancelable load.");
            } else {
                if (isMediaChunk) {
                    BaseMediaChunk removeLast = this.mediaChunks.removeLast();
                    if (removeLast == chunk) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    Assertions.checkState(z3);
                    this.primarySampleQueue.discardUpstreamSamples(removeLast.getFirstSampleIndex(0));
                    int i = 0;
                    while (true) {
                        SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
                        if (i >= sampleQueueArr.length) {
                            break;
                        }
                        SampleQueue sampleQueue = sampleQueueArr[i];
                        i++;
                        sampleQueue.discardUpstreamSamples(removeLast.getFirstSampleIndex(i));
                    }
                    if (this.mediaChunks.isEmpty()) {
                        this.pendingResetPositionUs = this.lastSeekPositionUs;
                    }
                }
                z2 = true;
                this.eventDispatcher.loadError(chunk.dataSpec, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j, j2, bytesLoaded, iOException, z2);
                if (z2) {
                    return 0;
                }
                this.callback.onContinueLoadingRequested(this);
                return 2;
            }
        }
        z2 = false;
        this.eventDispatcher.loadError(chunk.dataSpec, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j, j2, bytesLoaded, iOException, z2);
        if (z2) {
        }
    }

    public ChunkSampleStream<T>.EmbeddedSampleStream selectEmbeddedTrack(long j, int i) {
        for (int i2 = 0; i2 < this.embeddedSampleQueues.length; i2++) {
            if (this.embeddedTrackTypes[i2] == i) {
                Assertions.checkState(!this.embeddedTracksSelected[i2]);
                this.embeddedTracksSelected[i2] = true;
                this.embeddedSampleQueues[i2].rewind();
                this.embeddedSampleQueues[i2].advanceTo(j, true, true);
                return new EmbeddedSampleStream(this, this.embeddedSampleQueues[i2], i2);
            }
        }
        throw new IllegalStateException();
    }
}
