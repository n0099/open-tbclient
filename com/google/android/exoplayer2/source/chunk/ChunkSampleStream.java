package com.google.android.exoplayer2.source.chunk;

import android.util.Log;
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
/* loaded from: classes6.dex */
public class ChunkSampleStream<T extends ChunkSource> implements SampleStream, SequenceableLoader, Loader.Callback<Chunk>, Loader.ReleaseCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ChunkSampleStream";
    public transient /* synthetic */ FieldHolder $fh;
    public final SequenceableLoader.Callback<ChunkSampleStream<T>> callback;
    public final T chunkSource;
    public final SampleQueue[] embeddedSampleQueues;
    public final int[] embeddedTrackTypes;
    public final boolean[] embeddedTracksSelected;
    public final AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher;
    public long lastSeekPositionUs;
    public final Loader loader;
    public boolean loadingFinished;
    public final BaseMediaChunkOutput mediaChunkOutput;
    public final LinkedList<BaseMediaChunk> mediaChunks;
    public final int minLoadableRetryCount;
    public final ChunkHolder nextChunkHolder;
    public long pendingResetPositionUs;
    public Format primaryDownstreamTrackFormat;
    public final SampleQueue primarySampleQueue;
    public final int primaryTrackType;
    public final List<BaseMediaChunk> readOnlyMediaChunks;

    /* loaded from: classes6.dex */
    public final class EmbeddedSampleStream implements SampleStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int index;
        public final ChunkSampleStream<T> parent;
        public final SampleQueue sampleQueue;
        public final /* synthetic */ ChunkSampleStream this$0;

        public EmbeddedSampleStream(ChunkSampleStream chunkSampleStream, ChunkSampleStream<T> chunkSampleStream2, SampleQueue sampleQueue, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chunkSampleStream, chunkSampleStream2, sampleQueue, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = chunkSampleStream;
            this.parent = chunkSampleStream2;
            this.sampleQueue = sampleQueue;
            this.index = i;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ChunkSampleStream chunkSampleStream = this.this$0;
                return chunkSampleStream.loadingFinished || (!chunkSampleStream.isPendingReset() && this.sampleQueue.hasNextSample());
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, formatHolder, decoderInputBuffer, z)) == null) {
                if (this.this$0.isPendingReset()) {
                    return -3;
                }
                SampleQueue sampleQueue = this.sampleQueue;
                ChunkSampleStream chunkSampleStream = this.this$0;
                return sampleQueue.read(formatHolder, decoderInputBuffer, z, chunkSampleStream.loadingFinished, chunkSampleStream.lastSeekPositionUs);
            }
            return invokeLLZ.intValue;
        }

        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                Assertions.checkState(this.this$0.embeddedTracksSelected[this.index]);
                this.this$0.embeddedTracksSelected[this.index] = false;
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
                if (this.this$0.loadingFinished && j > this.sampleQueue.getLargestQueuedTimestampUs()) {
                    return this.sampleQueue.advanceToEnd();
                }
                int advanceTo = this.sampleQueue.advanceTo(j, true, true);
                if (advanceTo == -1) {
                    return 0;
                }
                return advanceTo;
            }
            return invokeJ.intValue;
        }
    }

    public ChunkSampleStream(int i, int[] iArr, T t, SequenceableLoader.Callback<ChunkSampleStream<T>> callback, Allocator allocator, long j, int i2, AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), iArr, t, callback, allocator, Long.valueOf(j), Integer.valueOf(i2), eventDispatcher};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.primaryTrackType = i;
        this.embeddedTrackTypes = iArr;
        this.chunkSource = t;
        this.callback = callback;
        this.eventDispatcher = eventDispatcher;
        this.minLoadableRetryCount = i2;
        this.loader = new Loader("Loader:ChunkSampleStream");
        this.nextChunkHolder = new ChunkHolder();
        LinkedList<BaseMediaChunk> linkedList = new LinkedList<>();
        this.mediaChunks = linkedList;
        this.readOnlyMediaChunks = Collections.unmodifiableList(linkedList);
        int i5 = 0;
        int length = iArr == null ? 0 : iArr.length;
        this.embeddedSampleQueues = new SampleQueue[length];
        this.embeddedTracksSelected = new boolean[length];
        int i6 = length + 1;
        int[] iArr2 = new int[i6];
        SampleQueue[] sampleQueueArr = new SampleQueue[i6];
        SampleQueue sampleQueue = new SampleQueue(allocator);
        this.primarySampleQueue = sampleQueue;
        iArr2[0] = i;
        sampleQueueArr[0] = sampleQueue;
        while (i5 < length) {
            SampleQueue sampleQueue2 = new SampleQueue(allocator);
            this.embeddedSampleQueues[i5] = sampleQueue2;
            int i7 = i5 + 1;
            sampleQueueArr[i7] = sampleQueue2;
            iArr2[i7] = iArr[i5];
            i5 = i7;
        }
        this.mediaChunkOutput = new BaseMediaChunkOutput(iArr2, sampleQueueArr);
        this.pendingResetPositionUs = j;
        this.lastSeekPositionUs = j;
    }

    private void discardDownstreamMediaChunks(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65538, this, i) == null) || this.mediaChunks.isEmpty()) {
            return;
        }
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

    private boolean discardUpstreamMediaChunks(int i) {
        InterceptResult invokeI;
        BaseMediaChunk removeLast;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(65539, this, i)) != null) {
            return invokeI.booleanValue;
        }
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
        InterceptResult invokeV;
        int readIndex;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
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
        return invokeV.booleanValue;
    }

    private boolean isMediaChunk(Chunk chunk) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, this, chunk)) == null) ? chunk instanceof BaseMediaChunk : invokeL.booleanValue;
    }

    private void maybeDiscardUpstream(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65542, this, j) == null) {
            discardUpstreamMediaChunks(Math.max(1, this.chunkSource.getPreferredQueueSize(j, this.readOnlyMediaChunks)));
        }
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        InterceptResult invokeJ;
        BaseMediaChunk last;
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
        return invokeJ.booleanValue;
    }

    public void discardEmbeddedTracksTo(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) != null) {
            return;
        }
        int i = 0;
        while (true) {
            SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
            if (i >= sampleQueueArr.length) {
                return;
            }
            sampleQueueArr[i].discardTo(j, true, this.embeddedTracksSelected[i]);
            i++;
        }
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
        return invokeV.longValue;
    }

    public T getChunkSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.chunkSource : (T) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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

    public boolean isPendingReset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.pendingResetPositionUs != C.TIME_UNSET : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.loadingFinished || (!isPendingReset() && this.primarySampleQueue.hasNextSample()) : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.loader.maybeThrowError();
            if (this.loader.isLoading()) {
                return;
            }
            this.chunkSource.maybeThrowError();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public void onLoaderReleased() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.primarySampleQueue.reset();
            for (SampleQueue sampleQueue : this.embeddedSampleQueues) {
                sampleQueue.reset();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048591, this, formatHolder, decoderInputBuffer, z)) == null) {
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
        return invokeLLZ.intValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.loader.release(this)) {
            return;
        }
        this.primarySampleQueue.discardToEnd();
        for (SampleQueue sampleQueue : this.embeddedSampleQueues) {
            sampleQueue.discardToEnd();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void seekToUs(long j) {
        boolean z;
        SampleQueue[] sampleQueueArr;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeJ(1048593, this, j) != null) {
            return;
        }
        this.lastSeekPositionUs = j;
        if (!isPendingReset()) {
            if (this.primarySampleQueue.advanceTo(j, true, j < getNextLoadPositionUs()) != -1) {
                z = true;
                if (!z) {
                    discardDownstreamMediaChunks(this.primarySampleQueue.getReadIndex());
                    this.primarySampleQueue.discardToRead();
                    for (SampleQueue sampleQueue : this.embeddedSampleQueues) {
                        sampleQueue.rewind();
                        sampleQueue.discardTo(j, true, false);
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
                for (SampleQueue sampleQueue2 : this.embeddedSampleQueues) {
                    sampleQueue2.reset();
                }
                return;
            }
        }
        z = false;
        if (!z) {
        }
    }

    public ChunkSampleStream<T>.EmbeddedSampleStream selectEmbeddedTrack(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            for (int i2 = 0; i2 < this.embeddedSampleQueues.length; i2++) {
                if (this.embeddedTrackTypes[i2] == i) {
                    Assertions.checkState(!this.embeddedTracksSelected[i2]);
                    this.embeddedTracksSelected[i2] = true;
                    this.embeddedSampleQueues[i2].rewind();
                    this.embeddedSampleQueues[i2].advanceTo(j, true, true);
                    return new EmbeddedSampleStream(this, this, this.embeddedSampleQueues[i2], i2);
                }
            }
            throw new IllegalStateException();
        }
        return (EmbeddedSampleStream) invokeCommon.objValue;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int skipData(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048595, this, j)) == null) {
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
        return invokeJ.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(Chunk chunk, long j, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{chunk, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.eventDispatcher.loadCanceled(chunk.dataSpec, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j, j2, chunk.bytesLoaded());
            if (z) {
                return;
            }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{chunk, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.chunkSource.onChunkLoadCompleted(chunk);
            this.eventDispatcher.loadCompleted(chunk.dataSpec, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j, j2, chunk.bytesLoaded());
            this.callback.onContinueLoadingRequested(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int onLoadError(Chunk chunk, long j, long j2, IOException iOException) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{chunk, Long.valueOf(j), Long.valueOf(j2), iOException})) != null) {
            return invokeCommon.intValue;
        }
        long bytesLoaded = chunk.bytesLoaded();
        boolean isMediaChunk = isMediaChunk(chunk);
        boolean z2 = (bytesLoaded != 0 && isMediaChunk && haveReadFromLastMediaChunk()) ? false : true;
        if (this.chunkSource.onChunkLoadError(chunk, z2, iOException)) {
            if (!z2) {
                Log.w(TAG, "Ignoring attempt to cancel non-cancelable load.");
            } else {
                if (isMediaChunk) {
                    BaseMediaChunk removeLast = this.mediaChunks.removeLast();
                    Assertions.checkState(removeLast == chunk);
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
                z = true;
                this.eventDispatcher.loadError(chunk.dataSpec, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j, j2, bytesLoaded, iOException, z);
                if (z) {
                    return 0;
                }
                this.callback.onContinueLoadingRequested(this);
                return 2;
            }
        }
        z = false;
        this.eventDispatcher.loadError(chunk.dataSpec, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j, j2, bytesLoaded, iOException, z);
        if (z) {
        }
    }
}
