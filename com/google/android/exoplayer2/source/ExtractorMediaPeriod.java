package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
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
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class ExtractorMediaPeriod implements MediaPeriod, ExtractorOutput, Loader.Callback<ExtractingLoadable>, Loader.ReleaseCallback, SampleQueue.UpstreamFormatChangedListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long DEFAULT_LAST_SAMPLE_DURATION_US = 10000;
    public transient /* synthetic */ FieldHolder $fh;
    public int actualMinLoadableRetryCount;
    public final Allocator allocator;
    public MediaPeriod.Callback callback;
    public final long continueLoadingCheckIntervalBytes;
    public final String customCacheKey;
    public final DataSource dataSource;
    public long durationUs;
    public int enabledTrackCount;
    public final Handler eventHandler;
    public final ExtractorMediaSource.EventListener eventListener;
    public int extractedSamplesCountAtStartOfLoad;
    public final ExtractorHolder extractorHolder;
    public final Handler handler;
    public boolean haveAudioVideoTracks;
    public long lastSeekPositionUs;
    public long length;
    public final Listener listener;
    public final ConditionVariable loadCondition;
    public final Loader loader;
    public boolean loadingFinished;
    public final Runnable maybeFinishPrepareRunnable;
    public final int minLoadableRetryCount;
    public boolean notifyDiscontinuity;
    public final Runnable onContinueLoadingRequestedRunnable;
    public long pendingResetPositionUs;
    public boolean prepared;
    public boolean released;
    public int[] sampleQueueTrackIds;
    public SampleQueue[] sampleQueues;
    public boolean sampleQueuesBuilt;
    public SeekMap seekMap;
    public boolean seenFirstTrackSelection;
    public boolean[] trackEnabledStates;
    public boolean[] trackIsAudioVideoFlags;
    public TrackGroupArray tracks;
    public final Uri uri;

    /* loaded from: classes7.dex */
    public final class ExtractingLoadable implements Loader.Loadable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final DataSource dataSource;
        public final ExtractorHolder extractorHolder;
        public long length;
        public volatile boolean loadCanceled;
        public final ConditionVariable loadCondition;
        public boolean pendingExtractorSeek;
        public final PositionHolder positionHolder;
        public long seekTimeUs;
        public final /* synthetic */ ExtractorMediaPeriod this$0;
        public final Uri uri;

        public ExtractingLoadable(ExtractorMediaPeriod extractorMediaPeriod, Uri uri, DataSource dataSource, ExtractorHolder extractorHolder, ConditionVariable conditionVariable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {extractorMediaPeriod, uri, dataSource, extractorHolder, conditionVariable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = extractorMediaPeriod;
            this.uri = (Uri) Assertions.checkNotNull(uri);
            this.dataSource = (DataSource) Assertions.checkNotNull(dataSource);
            this.extractorHolder = (ExtractorHolder) Assertions.checkNotNull(extractorHolder);
            this.loadCondition = conditionVariable;
            this.positionHolder = new PositionHolder();
            this.pendingExtractorSeek = true;
            this.length = -1L;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void cancelLoad() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.loadCanceled = true;
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public boolean isLoadCanceled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.loadCanceled : invokeV.booleanValue;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void load() throws IOException, InterruptedException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i2 = 0;
                while (i2 == 0 && !this.loadCanceled) {
                    DefaultExtractorInput defaultExtractorInput = null;
                    try {
                        long j2 = this.positionHolder.position;
                        long open = this.dataSource.open(new DataSpec(this.uri, j2, -1L, this.this$0.customCacheKey));
                        this.length = open;
                        if (open != -1) {
                            this.length = open + j2;
                        }
                        DefaultExtractorInput defaultExtractorInput2 = new DefaultExtractorInput(this.dataSource, j2, this.length);
                        try {
                            Extractor selectExtractor = this.extractorHolder.selectExtractor(defaultExtractorInput2, this.dataSource.getUri());
                            if (this.pendingExtractorSeek) {
                                selectExtractor.seek(j2, this.seekTimeUs);
                                this.pendingExtractorSeek = false;
                            }
                            while (i2 == 0 && !this.loadCanceled) {
                                this.loadCondition.block();
                                i2 = selectExtractor.read(defaultExtractorInput2, this.positionHolder);
                                if (defaultExtractorInput2.getPosition() > this.this$0.continueLoadingCheckIntervalBytes + j2) {
                                    j2 = defaultExtractorInput2.getPosition();
                                    this.loadCondition.close();
                                    this.this$0.handler.post(this.this$0.onContinueLoadingRequestedRunnable);
                                }
                            }
                            if (i2 == 1) {
                                i2 = 0;
                            } else {
                                this.positionHolder.position = defaultExtractorInput2.getPosition();
                            }
                            Util.closeQuietly(this.dataSource);
                        } catch (Throwable th) {
                            th = th;
                            defaultExtractorInput = defaultExtractorInput2;
                            if (i2 != 1 && defaultExtractorInput != null) {
                                this.positionHolder.position = defaultExtractorInput.getPosition();
                            }
                            Util.closeQuietly(this.dataSource);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }

        public void setLoadPosition(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                this.positionHolder.position = j2;
                this.seekTimeUs = j3;
                this.pendingExtractorSeek = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class ExtractorHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Extractor extractor;
        public final ExtractorOutput extractorOutput;
        public final Extractor[] extractors;

        public ExtractorHolder(Extractor[] extractorArr, ExtractorOutput extractorOutput) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {extractorArr, extractorOutput};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.extractors = extractorArr;
            this.extractorOutput = extractorOutput;
        }

        public void release() {
            Extractor extractor;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (extractor = this.extractor) == null) {
                return;
            }
            extractor.release();
            this.extractor = null;
        }

        public Extractor selectExtractor(ExtractorInput extractorInput, Uri uri) throws IOException, InterruptedException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, extractorInput, uri)) == null) {
                Extractor extractor = this.extractor;
                if (extractor != null) {
                    return extractor;
                }
                Extractor[] extractorArr = this.extractors;
                int length = extractorArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    Extractor extractor2 = extractorArr[i2];
                    try {
                    } catch (EOFException unused) {
                    } catch (Throwable th) {
                        extractorInput.resetPeekPosition();
                        throw th;
                    }
                    if (extractor2.sniff(extractorInput)) {
                        this.extractor = extractor2;
                        extractorInput.resetPeekPosition();
                        break;
                    }
                    continue;
                    extractorInput.resetPeekPosition();
                    i2++;
                }
                Extractor extractor3 = this.extractor;
                if (extractor3 != null) {
                    extractor3.init(this.extractorOutput);
                    return this.extractor;
                }
                throw new UnrecognizedInputFormatException("None of the available extractors (" + Util.getCommaDelimitedSimpleClassNames(this.extractors) + ") could read the stream.", uri);
            }
            return (Extractor) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface Listener {
        void onSourceInfoRefreshed(long j2, boolean z);
    }

    /* loaded from: classes7.dex */
    public final class SampleStreamImpl implements SampleStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ExtractorMediaPeriod this$0;
        public final int track;

        public SampleStreamImpl(ExtractorMediaPeriod extractorMediaPeriod, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {extractorMediaPeriod, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = extractorMediaPeriod;
            this.track = i2;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.this$0.isReady(this.track) : invokeV.booleanValue;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.this$0.maybeThrowError();
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, formatHolder, decoderInputBuffer, z)) == null) ? this.this$0.readData(this.track, formatHolder, decoderInputBuffer, z) : invokeLLZ.intValue;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) ? this.this$0.skipData(this.track, j2) : invokeJ.intValue;
        }
    }

    public ExtractorMediaPeriod(Uri uri, DataSource dataSource, Extractor[] extractorArr, int i2, Handler handler, ExtractorMediaSource.EventListener eventListener, Listener listener, Allocator allocator, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, dataSource, extractorArr, Integer.valueOf(i2), handler, eventListener, listener, allocator, str, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.uri = uri;
        this.dataSource = dataSource;
        this.minLoadableRetryCount = i2;
        this.eventHandler = handler;
        this.eventListener = eventListener;
        this.listener = listener;
        this.allocator = allocator;
        this.customCacheKey = str;
        this.continueLoadingCheckIntervalBytes = i3;
        this.loader = new Loader("Loader:ExtractorMediaPeriod");
        this.extractorHolder = new ExtractorHolder(extractorArr, this);
        this.loadCondition = new ConditionVariable();
        this.maybeFinishPrepareRunnable = new Runnable(this) { // from class: com.google.android.exoplayer2.source.ExtractorMediaPeriod.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ExtractorMediaPeriod this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i6 = newInitContext2.flag;
                    if ((i6 & 1) != 0) {
                        int i7 = i6 & 2;
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
        this.onContinueLoadingRequestedRunnable = new Runnable(this) { // from class: com.google.android.exoplayer2.source.ExtractorMediaPeriod.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ExtractorMediaPeriod this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i6 = newInitContext2.flag;
                    if ((i6 & 1) != 0) {
                        int i7 = i6 & 2;
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
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.released) {
                    return;
                }
                this.this$0.callback.onContinueLoadingRequested(this.this$0);
            }
        };
        this.handler = new Handler();
        this.sampleQueueTrackIds = new int[0];
        this.sampleQueues = new SampleQueue[0];
        this.pendingResetPositionUs = C.TIME_UNSET;
        this.length = -1L;
        this.actualMinLoadableRetryCount = i2 == -1 ? 3 : i2;
    }

    private void configureRetry(ExtractingLoadable extractingLoadable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, this, extractingLoadable) == null) && this.length == -1) {
            SeekMap seekMap = this.seekMap;
            if (seekMap == null || seekMap.getDurationUs() == C.TIME_UNSET) {
                this.lastSeekPositionUs = 0L;
                this.notifyDiscontinuity = this.prepared;
                for (SampleQueue sampleQueue : this.sampleQueues) {
                    sampleQueue.reset();
                }
                extractingLoadable.setLoadPosition(0L, 0L);
            }
        }
    }

    private void copyLengthFromLoader(ExtractingLoadable extractingLoadable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, this, extractingLoadable) == null) && this.length == -1) {
            this.length = extractingLoadable.length;
        }
    }

    private int getExtractedSamplesCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            int i2 = 0;
            for (SampleQueue sampleQueue : this.sampleQueues) {
                i2 += sampleQueue.getWriteIndex();
            }
            return i2;
        }
        return invokeV.intValue;
    }

    private long getLargestQueuedTimestampUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            long j2 = Long.MIN_VALUE;
            for (SampleQueue sampleQueue : this.sampleQueues) {
                j2 = Math.max(j2, sampleQueue.getLargestQueuedTimestampUs());
            }
            return j2;
        }
        return invokeV.longValue;
    }

    private boolean isLoadableExceptionFatal(IOException iOException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, this, iOException)) == null) ? iOException instanceof UnrecognizedInputFormatException : invokeL.booleanValue;
    }

    private boolean isPendingReset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? this.pendingResetPositionUs != C.TIME_UNSET : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeFinishPrepare() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || this.released || this.prepared || this.seekMap == null || !this.sampleQueuesBuilt) {
            return;
        }
        for (SampleQueue sampleQueue : this.sampleQueues) {
            if (sampleQueue.getUpstreamFormat() == null) {
                return;
            }
        }
        this.loadCondition.close();
        int length = this.sampleQueues.length;
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        this.trackIsAudioVideoFlags = new boolean[length];
        this.trackEnabledStates = new boolean[length];
        this.durationUs = this.seekMap.getDurationUs();
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= length) {
                break;
            }
            Format upstreamFormat = this.sampleQueues[i2].getUpstreamFormat();
            trackGroupArr[i2] = new TrackGroup(upstreamFormat);
            String str = upstreamFormat.sampleMimeType;
            if (!MimeTypes.isVideo(str) && !MimeTypes.isAudio(str)) {
                z = false;
            }
            this.trackIsAudioVideoFlags[i2] = z;
            this.haveAudioVideoTracks = z | this.haveAudioVideoTracks;
            i2++;
        }
        this.tracks = new TrackGroupArray(trackGroupArr);
        if (this.minLoadableRetryCount == -1 && this.length == -1 && this.seekMap.getDurationUs() == C.TIME_UNSET) {
            this.actualMinLoadableRetryCount = 6;
        }
        this.prepared = true;
        this.listener.onSourceInfoRefreshed(this.durationUs, this.seekMap.isSeekable());
        this.callback.onPrepared(this);
    }

    private void notifyLoadError(IOException iOException) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, this, iOException) == null) || (handler = this.eventHandler) == null || this.eventListener == null) {
            return;
        }
        handler.post(new Runnable(this, iOException) { // from class: com.google.android.exoplayer2.source.ExtractorMediaPeriod.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ExtractorMediaPeriod this$0;
            public final /* synthetic */ IOException val$error;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, iOException};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$error = iOException;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.eventListener.onLoadError(this.val$error);
                }
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0028, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean seekInsideBufferUs(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJ = interceptable.invokeJ(65553, this, j2)) != null) {
            return invokeJ.booleanValue;
        }
        int length = this.sampleQueues.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                return true;
            }
            SampleQueue sampleQueue = this.sampleQueues[i2];
            sampleQueue.rewind();
            if ((sampleQueue.advanceTo(j2, true, false) != -1) || (!this.trackIsAudioVideoFlags[i2] && this.haveAudioVideoTracks)) {
                sampleQueue.discardToRead();
                i2++;
            }
        }
    }

    private void startLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            ExtractingLoadable extractingLoadable = new ExtractingLoadable(this, this.uri, this.dataSource, this.extractorHolder, this.loadCondition);
            if (this.prepared) {
                Assertions.checkState(isPendingReset());
                long j2 = this.durationUs;
                if (j2 != C.TIME_UNSET && this.pendingResetPositionUs >= j2) {
                    this.loadingFinished = true;
                    this.pendingResetPositionUs = C.TIME_UNSET;
                    return;
                }
                extractingLoadable.setLoadPosition(this.seekMap.getPosition(this.pendingResetPositionUs), this.pendingResetPositionUs);
                this.pendingResetPositionUs = C.TIME_UNSET;
            }
            this.extractedSamplesCountAtStartOfLoad = getExtractedSamplesCount();
            this.loader.startLoading(extractingLoadable, this, this.actualMinLoadableRetryCount);
        }
    }

    private boolean suppressRead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) ? this.notifyDiscontinuity || isPendingReset() : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            if (this.loadingFinished) {
                return false;
            }
            if (this.prepared && this.enabledTrackCount == 0) {
                return false;
            }
            boolean open = this.loadCondition.open();
            if (this.loader.isLoading()) {
                return open;
            }
            startLoading();
            return true;
        }
        return invokeJ.booleanValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            int length = this.sampleQueues.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.sampleQueues[i2].discardTo(j2, false, this.trackEnabledStates[i2]);
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.sampleQueuesBuilt = true;
            this.handler.post(this.maybeFinishPrepareRunnable);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        InterceptResult invokeV;
        long largestQueuedTimestampUs;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.loadingFinished) {
                return Long.MIN_VALUE;
            }
            if (isPendingReset()) {
                return this.pendingResetPositionUs;
            }
            if (this.haveAudioVideoTracks) {
                largestQueuedTimestampUs = Long.MAX_VALUE;
                int length = this.sampleQueues.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (this.trackIsAudioVideoFlags[i2]) {
                        largestQueuedTimestampUs = Math.min(largestQueuedTimestampUs, this.sampleQueues[i2].getLargestQueuedTimestampUs());
                    }
                }
            } else {
                largestQueuedTimestampUs = getLargestQueuedTimestampUs();
            }
            return largestQueuedTimestampUs == Long.MIN_VALUE ? this.lastSeekPositionUs : largestQueuedTimestampUs;
        }
        return invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.enabledTrackCount == 0) {
                return Long.MIN_VALUE;
            }
            return getBufferedPositionUs();
        }
        return invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.tracks : (TrackGroupArray) invokeV.objValue;
    }

    public boolean isReady(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? !suppressRead() && (this.loadingFinished || this.sampleQueues[i2].hasNextSample()) : invokeI.booleanValue;
    }

    public void maybeThrowError() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.loader.maybeThrowError(this.actualMinLoadableRetryCount);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            maybeThrowError();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public void onLoaderReleased() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.extractorHolder.release();
            for (SampleQueue sampleQueue : this.sampleQueues) {
                sampleQueue.reset();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener
    public void onUpstreamFormatChanged(Format format) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, format) == null) {
            this.handler.post(this.maybeFinishPrepareRunnable);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048593, this, callback, j2) == null) {
            this.callback = callback;
            this.loadCondition.open();
            startLoading();
        }
    }

    public int readData(int i2, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), formatHolder, decoderInputBuffer, Boolean.valueOf(z)})) == null) {
            if (suppressRead()) {
                return -3;
            }
            return this.sampleQueues[i2].read(formatHolder, decoderInputBuffer, z, this.loadingFinished, this.lastSeekPositionUs);
        }
        return invokeCommon.intValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.notifyDiscontinuity) {
                this.notifyDiscontinuity = false;
                return this.lastSeekPositionUs;
            }
            return C.TIME_UNSET;
        }
        return invokeV.longValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048597, this, seekMap) == null) {
            this.seekMap = seekMap;
            this.handler.post(this.maybeFinishPrepareRunnable);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048598, this, j2)) == null) {
            if (!this.seekMap.isSeekable()) {
                j2 = 0;
            }
            this.lastSeekPositionUs = j2;
            this.notifyDiscontinuity = false;
            if (isPendingReset() || !seekInsideBufferUs(j2)) {
                this.pendingResetPositionUs = j2;
                this.loadingFinished = false;
                if (this.loader.isLoading()) {
                    this.loader.cancelLoading();
                } else {
                    for (SampleQueue sampleQueue : this.sampleQueues) {
                        sampleQueue.reset();
                    }
                }
                return j2;
            }
            return j2;
        }
        return invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{trackSelectionArr, zArr, sampleStreamArr, zArr2, Long.valueOf(j2)})) == null) {
            Assertions.checkState(this.prepared);
            int i2 = this.enabledTrackCount;
            int i3 = 0;
            for (int i4 = 0; i4 < trackSelectionArr.length; i4++) {
                if (sampleStreamArr[i4] != null && (trackSelectionArr[i4] == null || !zArr[i4])) {
                    int i5 = ((SampleStreamImpl) sampleStreamArr[i4]).track;
                    Assertions.checkState(this.trackEnabledStates[i5]);
                    this.enabledTrackCount--;
                    this.trackEnabledStates[i5] = false;
                    sampleStreamArr[i4] = null;
                }
            }
            boolean z = !this.seenFirstTrackSelection ? j2 == 0 : i2 != 0;
            for (int i6 = 0; i6 < trackSelectionArr.length; i6++) {
                if (sampleStreamArr[i6] == null && trackSelectionArr[i6] != null) {
                    TrackSelection trackSelection = trackSelectionArr[i6];
                    Assertions.checkState(trackSelection.length() == 1);
                    Assertions.checkState(trackSelection.getIndexInTrackGroup(0) == 0);
                    int indexOf = this.tracks.indexOf(trackSelection.getTrackGroup());
                    Assertions.checkState(!this.trackEnabledStates[indexOf]);
                    this.enabledTrackCount++;
                    this.trackEnabledStates[indexOf] = true;
                    sampleStreamArr[i6] = new SampleStreamImpl(this, indexOf);
                    zArr2[i6] = true;
                    if (!z) {
                        SampleQueue sampleQueue = this.sampleQueues[indexOf];
                        sampleQueue.rewind();
                        z = sampleQueue.advanceTo(j2, true, true) == -1 && sampleQueue.getReadIndex() != 0;
                    }
                }
            }
            if (this.enabledTrackCount == 0) {
                this.notifyDiscontinuity = false;
                if (this.loader.isLoading()) {
                    SampleQueue[] sampleQueueArr = this.sampleQueues;
                    int length = sampleQueueArr.length;
                    while (i3 < length) {
                        sampleQueueArr[i3].discardToEnd();
                        i3++;
                    }
                    this.loader.cancelLoading();
                } else {
                    SampleQueue[] sampleQueueArr2 = this.sampleQueues;
                    int length2 = sampleQueueArr2.length;
                    while (i3 < length2) {
                        sampleQueueArr2[i3].reset();
                        i3++;
                    }
                }
            } else if (z) {
                j2 = seekToUs(j2);
                while (i3 < sampleStreamArr.length) {
                    if (sampleStreamArr[i3] != null) {
                        zArr2[i3] = true;
                    }
                    i3++;
                }
            }
            this.seenFirstTrackSelection = true;
            return j2;
        }
        return invokeCommon.longValue;
    }

    public int skipData(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            if (suppressRead()) {
                return 0;
            }
            SampleQueue sampleQueue = this.sampleQueues[i2];
            if (this.loadingFinished && j2 > sampleQueue.getLargestQueuedTimestampUs()) {
                return sampleQueue.advanceToEnd();
            }
            int advanceTo = sampleQueue.advanceTo(j2, true, true);
            if (advanceTo == -1) {
                return 0;
            }
            return advanceTo;
        }
        return invokeCommon.intValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public TrackOutput track(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048601, this, i2, i3)) == null) {
            int length = this.sampleQueues.length;
            for (int i4 = 0; i4 < length; i4++) {
                if (this.sampleQueueTrackIds[i4] == i2) {
                    return this.sampleQueues[i4];
                }
            }
            SampleQueue sampleQueue = new SampleQueue(this.allocator);
            sampleQueue.setUpstreamFormatChangeListener(this);
            int i5 = length + 1;
            int[] copyOf = Arrays.copyOf(this.sampleQueueTrackIds, i5);
            this.sampleQueueTrackIds = copyOf;
            copyOf[length] = i2;
            SampleQueue[] sampleQueueArr = (SampleQueue[]) Arrays.copyOf(this.sampleQueues, i5);
            this.sampleQueues = sampleQueueArr;
            sampleQueueArr[length] = sampleQueue;
            return sampleQueue;
        }
        return (TrackOutput) invokeII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(ExtractingLoadable extractingLoadable, long j2, long j3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{extractingLoadable, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)}) == null) || z) {
            return;
        }
        copyLengthFromLoader(extractingLoadable);
        for (SampleQueue sampleQueue : this.sampleQueues) {
            sampleQueue.reset();
        }
        if (this.enabledTrackCount > 0) {
            this.callback.onContinueLoadingRequested(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(ExtractingLoadable extractingLoadable, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{extractingLoadable, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            copyLengthFromLoader(extractingLoadable);
            this.loadingFinished = true;
            if (this.durationUs == C.TIME_UNSET) {
                long largestQueuedTimestampUs = getLargestQueuedTimestampUs();
                long j4 = largestQueuedTimestampUs == Long.MIN_VALUE ? 0L : largestQueuedTimestampUs + 10000;
                this.durationUs = j4;
                this.listener.onSourceInfoRefreshed(j4, this.seekMap.isSeekable());
            }
            this.callback.onContinueLoadingRequested(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public int onLoadError(ExtractingLoadable extractingLoadable, long j2, long j3, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{extractingLoadable, Long.valueOf(j2), Long.valueOf(j3), iOException})) == null) {
            copyLengthFromLoader(extractingLoadable);
            notifyLoadError(iOException);
            if (isLoadableExceptionFatal(iOException)) {
                return 3;
            }
            int i2 = getExtractedSamplesCount() > this.extractedSamplesCountAtStartOfLoad ? 1 : 0;
            configureRetry(extractingLoadable);
            this.extractedSamplesCountAtStartOfLoad = getExtractedSamplesCount();
            return i2;
        }
        return invokeCommon.intValue;
    }
}
