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
    public interface Listener {
        void onSourceInfoRefreshed(long j, boolean z);
    }

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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.loadCanceled;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void load() throws IOException, InterruptedException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i = 0;
                while (i == 0 && !this.loadCanceled) {
                    DefaultExtractorInput defaultExtractorInput = null;
                    try {
                        long j = this.positionHolder.position;
                        long open = this.dataSource.open(new DataSpec(this.uri, j, -1L, this.this$0.customCacheKey));
                        this.length = open;
                        if (open != -1) {
                            this.length = open + j;
                        }
                        DefaultExtractorInput defaultExtractorInput2 = new DefaultExtractorInput(this.dataSource, j, this.length);
                        try {
                            Extractor selectExtractor = this.extractorHolder.selectExtractor(defaultExtractorInput2, this.dataSource.getUri());
                            if (this.pendingExtractorSeek) {
                                selectExtractor.seek(j, this.seekTimeUs);
                                this.pendingExtractorSeek = false;
                            }
                            while (i == 0 && !this.loadCanceled) {
                                this.loadCondition.block();
                                i = selectExtractor.read(defaultExtractorInput2, this.positionHolder);
                                if (defaultExtractorInput2.getPosition() > this.this$0.continueLoadingCheckIntervalBytes + j) {
                                    j = defaultExtractorInput2.getPosition();
                                    this.loadCondition.close();
                                    this.this$0.handler.post(this.this$0.onContinueLoadingRequestedRunnable);
                                }
                            }
                            if (i == 1) {
                                i = 0;
                            } else {
                                this.positionHolder.position = defaultExtractorInput2.getPosition();
                            }
                            Util.closeQuietly(this.dataSource);
                        } catch (Throwable th) {
                            th = th;
                            defaultExtractorInput = defaultExtractorInput2;
                            if (i != 1 && defaultExtractorInput != null) {
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

        public void setLoadPosition(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.positionHolder.position = j;
                this.seekTimeUs = j2;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (extractor = this.extractor) != null) {
                extractor.release();
                this.extractor = null;
            }
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
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Extractor extractor2 = extractorArr[i];
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
                    i++;
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
    public final class SampleStreamImpl implements SampleStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ExtractorMediaPeriod this$0;
        public final int track;

        public SampleStreamImpl(ExtractorMediaPeriod extractorMediaPeriod, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {extractorMediaPeriod, Integer.valueOf(i)};
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
            this.track = i;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                return this.this$0.skipData(this.track, j);
            }
            return invokeJ.intValue;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.this$0.isReady(this.track);
            }
            return invokeV.booleanValue;
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
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, formatHolder, decoderInputBuffer, z)) == null) {
                return this.this$0.readData(this.track, formatHolder, decoderInputBuffer, z);
            }
            return invokeLLZ.intValue;
        }
    }

    public ExtractorMediaPeriod(Uri uri, DataSource dataSource, Extractor[] extractorArr, int i, Handler handler, ExtractorMediaSource.EventListener eventListener, Listener listener, Allocator allocator, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, dataSource, extractorArr, Integer.valueOf(i), handler, eventListener, listener, allocator, str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.uri = uri;
        this.dataSource = dataSource;
        this.minLoadableRetryCount = i;
        this.eventHandler = handler;
        this.eventListener = eventListener;
        this.listener = listener;
        this.allocator = allocator;
        this.customCacheKey = str;
        this.continueLoadingCheckIntervalBytes = i2;
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
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.this$0.released) {
                    this.this$0.callback.onContinueLoadingRequested(this.this$0);
                }
            }
        };
        this.handler = new Handler();
        this.sampleQueueTrackIds = new int[0];
        this.sampleQueues = new SampleQueue[0];
        this.pendingResetPositionUs = C.TIME_UNSET;
        this.length = -1L;
        this.actualMinLoadableRetryCount = i == -1 ? 3 : i;
    }

    private void copyLengthFromLoader(ExtractingLoadable extractingLoadable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, this, extractingLoadable) == null) && this.length == -1) {
            this.length = extractingLoadable.length;
        }
    }

    private boolean isLoadableExceptionFatal(IOException iOException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, iOException)) == null) {
            return iOException instanceof UnrecognizedInputFormatException;
        }
        return invokeL.booleanValue;
    }

    private void notifyLoadError(IOException iOException) {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65552, this, iOException) == null) && (handler = this.eventHandler) != null && this.eventListener != null) {
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            if (!this.loadingFinished) {
                if (!this.prepared || this.enabledTrackCount != 0) {
                    boolean open = this.loadCondition.open();
                    if (!this.loader.isLoading()) {
                        startLoading();
                        return true;
                    }
                    return open;
                }
                return false;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            int length = this.sampleQueues.length;
            for (int i = 0; i < length; i++) {
                this.sampleQueues[i].discardTo(j, false, this.trackEnabledStates[i]);
            }
        }
    }

    public boolean isReady(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (!suppressRead() && (this.loadingFinished || this.sampleQueues[i].hasNextSample())) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener
    public void onUpstreamFormatChanged(Format format) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, format) == null) {
            this.handler.post(this.maybeFinishPrepareRunnable);
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

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0028, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean seekInsideBufferUs(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65553, this, j)) == null) {
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
                if (z || (!this.trackIsAudioVideoFlags[i] && this.haveAudioVideoTracks)) {
                    sampleQueue.discardToRead();
                    i++;
                }
            }
        } else {
            return invokeJ.booleanValue;
        }
    }

    private int getExtractedSamplesCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            int i = 0;
            for (SampleQueue sampleQueue : this.sampleQueues) {
                i += sampleQueue.getWriteIndex();
            }
            return i;
        }
        return invokeV.intValue;
    }

    private long getLargestQueuedTimestampUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            long j = Long.MIN_VALUE;
            for (SampleQueue sampleQueue : this.sampleQueues) {
                j = Math.max(j, sampleQueue.getLargestQueuedTimestampUs());
            }
            return j;
        }
        return invokeV.longValue;
    }

    private boolean isPendingReset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            if (this.pendingResetPositionUs != C.TIME_UNSET) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean suppressRead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            if (!this.notifyDiscontinuity && !isPendingReset()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.tracks;
        }
        return (TrackGroupArray) invokeV.objValue;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeFinishPrepare() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65551, this) == null) && !this.released && !this.prepared && this.seekMap != null && this.sampleQueuesBuilt) {
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
            int i = 0;
            while (true) {
                boolean z = true;
                if (i >= length) {
                    break;
                }
                Format upstreamFormat = this.sampleQueues[i].getUpstreamFormat();
                trackGroupArr[i] = new TrackGroup(upstreamFormat);
                String str = upstreamFormat.sampleMimeType;
                if (!MimeTypes.isVideo(str) && !MimeTypes.isAudio(str)) {
                    z = false;
                }
                this.trackIsAudioVideoFlags[i] = z;
                this.haveAudioVideoTracks = z | this.haveAudioVideoTracks;
                i++;
            }
            this.tracks = new TrackGroupArray(trackGroupArr);
            if (this.minLoadableRetryCount == -1 && this.length == -1 && this.seekMap.getDurationUs() == C.TIME_UNSET) {
                this.actualMinLoadableRetryCount = 6;
            }
            this.prepared = true;
            this.listener.onSourceInfoRefreshed(this.durationUs, this.seekMap.isSeekable());
            this.callback.onPrepared(this);
        }
    }

    private void startLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            ExtractingLoadable extractingLoadable = new ExtractingLoadable(this, this.uri, this.dataSource, this.extractorHolder, this.loadCondition);
            if (this.prepared) {
                Assertions.checkState(isPendingReset());
                long j = this.durationUs;
                if (j != C.TIME_UNSET && this.pendingResetPositionUs >= j) {
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
                for (int i = 0; i < length; i++) {
                    if (this.trackIsAudioVideoFlags[i]) {
                        largestQueuedTimestampUs = Math.min(largestQueuedTimestampUs, this.sampleQueues[i].getLargestQueuedTimestampUs());
                    }
                }
            } else {
                largestQueuedTimestampUs = getLargestQueuedTimestampUs();
            }
            if (largestQueuedTimestampUs == Long.MIN_VALUE) {
                return this.lastSeekPositionUs;
            }
            return largestQueuedTimestampUs;
        }
        return invokeV.longValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(ExtractingLoadable extractingLoadable, long j, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048585, this, new Object[]{extractingLoadable, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) != null) || z) {
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
    public int onLoadError(ExtractingLoadable extractingLoadable, long j, long j2, IOException iOException) {
        InterceptResult invokeCommon;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{extractingLoadable, Long.valueOf(j), Long.valueOf(j2), iOException})) == null) {
            copyLengthFromLoader(extractingLoadable);
            notifyLoadError(iOException);
            if (isLoadableExceptionFatal(iOException)) {
                return 3;
            }
            if (getExtractedSamplesCount() > this.extractedSamplesCountAtStartOfLoad) {
                i = 1;
            } else {
                i = 0;
            }
            configureRetry(extractingLoadable);
            this.extractedSamplesCountAtStartOfLoad = getExtractedSamplesCount();
            return i;
        }
        return invokeCommon.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(ExtractingLoadable extractingLoadable, long j, long j2) {
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{extractingLoadable, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            copyLengthFromLoader(extractingLoadable);
            this.loadingFinished = true;
            if (this.durationUs == C.TIME_UNSET) {
                long largestQueuedTimestampUs = getLargestQueuedTimestampUs();
                if (largestQueuedTimestampUs == Long.MIN_VALUE) {
                    j3 = 0;
                } else {
                    j3 = largestQueuedTimestampUs + 10000;
                }
                this.durationUs = j3;
                this.listener.onSourceInfoRefreshed(j3, this.seekMap.isSeekable());
            }
            this.callback.onContinueLoadingRequested(this);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048593, this, callback, j) == null) {
            this.callback = callback;
            this.loadCondition.open();
            startLoading();
        }
    }

    public int readData(int i, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i), formatHolder, decoderInputBuffer, Boolean.valueOf(z)})) == null) {
            if (suppressRead()) {
                return -3;
            }
            return this.sampleQueues[i].read(formatHolder, decoderInputBuffer, z, this.loadingFinished, this.lastSeekPositionUs);
        }
        return invokeCommon.intValue;
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

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048598, this, j)) == null) {
            if (!this.seekMap.isSeekable()) {
                j = 0;
            }
            this.lastSeekPositionUs = j;
            this.notifyDiscontinuity = false;
            if (!isPendingReset() && seekInsideBufferUs(j)) {
                return j;
            }
            this.pendingResetPositionUs = j;
            this.loadingFinished = false;
            if (this.loader.isLoading()) {
                this.loader.cancelLoading();
            } else {
                for (SampleQueue sampleQueue : this.sampleQueues) {
                    sampleQueue.reset();
                }
            }
            return j;
        }
        return invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        InterceptResult invokeCommon;
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{trackSelectionArr, zArr, sampleStreamArr, zArr2, Long.valueOf(j)})) == null) {
            Assertions.checkState(this.prepared);
            int i = this.enabledTrackCount;
            int i2 = 0;
            for (int i3 = 0; i3 < trackSelectionArr.length; i3++) {
                if (sampleStreamArr[i3] != null && (trackSelectionArr[i3] == null || !zArr[i3])) {
                    int i4 = ((SampleStreamImpl) sampleStreamArr[i3]).track;
                    Assertions.checkState(this.trackEnabledStates[i4]);
                    this.enabledTrackCount--;
                    this.trackEnabledStates[i4] = false;
                    sampleStreamArr[i3] = null;
                }
            }
            if (!this.seenFirstTrackSelection ? j != 0 : i == 0) {
                z = true;
            } else {
                z = false;
            }
            for (int i5 = 0; i5 < trackSelectionArr.length; i5++) {
                if (sampleStreamArr[i5] == null && trackSelectionArr[i5] != null) {
                    TrackSelection trackSelection = trackSelectionArr[i5];
                    if (trackSelection.length() == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    Assertions.checkState(z2);
                    if (trackSelection.getIndexInTrackGroup(0) == 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    Assertions.checkState(z3);
                    int indexOf = this.tracks.indexOf(trackSelection.getTrackGroup());
                    Assertions.checkState(!this.trackEnabledStates[indexOf]);
                    this.enabledTrackCount++;
                    this.trackEnabledStates[indexOf] = true;
                    sampleStreamArr[i5] = new SampleStreamImpl(this, indexOf);
                    zArr2[i5] = true;
                    if (!z) {
                        SampleQueue sampleQueue = this.sampleQueues[indexOf];
                        sampleQueue.rewind();
                        if (sampleQueue.advanceTo(j, true, true) == -1 && sampleQueue.getReadIndex() != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                }
            }
            if (this.enabledTrackCount == 0) {
                this.notifyDiscontinuity = false;
                if (this.loader.isLoading()) {
                    SampleQueue[] sampleQueueArr = this.sampleQueues;
                    int length = sampleQueueArr.length;
                    while (i2 < length) {
                        sampleQueueArr[i2].discardToEnd();
                        i2++;
                    }
                    this.loader.cancelLoading();
                } else {
                    SampleQueue[] sampleQueueArr2 = this.sampleQueues;
                    int length2 = sampleQueueArr2.length;
                    while (i2 < length2) {
                        sampleQueueArr2[i2].reset();
                        i2++;
                    }
                }
            } else if (z) {
                j = seekToUs(j);
                while (i2 < sampleStreamArr.length) {
                    if (sampleStreamArr[i2] != null) {
                        zArr2[i2] = true;
                    }
                    i2++;
                }
            }
            this.seenFirstTrackSelection = true;
            return j;
        }
        return invokeCommon.longValue;
    }

    public int skipData(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (suppressRead()) {
                return 0;
            }
            SampleQueue sampleQueue = this.sampleQueues[i];
            if (this.loadingFinished && j > sampleQueue.getLargestQueuedTimestampUs()) {
                return sampleQueue.advanceToEnd();
            }
            int advanceTo = sampleQueue.advanceTo(j, true, true);
            if (advanceTo == -1) {
                return 0;
            }
            return advanceTo;
        }
        return invokeCommon.intValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public TrackOutput track(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048601, this, i, i2)) == null) {
            int length = this.sampleQueues.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (this.sampleQueueTrackIds[i3] == i) {
                    return this.sampleQueues[i3];
                }
            }
            SampleQueue sampleQueue = new SampleQueue(this.allocator);
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
        return (TrackOutput) invokeII.objValue;
    }
}
