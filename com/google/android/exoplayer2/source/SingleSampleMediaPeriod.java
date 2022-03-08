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
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.SingleSampleMediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class SingleSampleMediaPeriod implements MediaPeriod, Loader.Callback<SourceLoadable> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INITIAL_SAMPLE_SIZE = 1024;
    public transient /* synthetic */ FieldHolder $fh;
    public final DataSource.Factory dataSourceFactory;
    public int errorCount;
    public final Handler eventHandler;
    public final SingleSampleMediaSource.EventListener eventListener;
    public final int eventSourceId;
    public final Format format;
    public final Loader loader;
    public boolean loadingFinished;
    public boolean loadingSucceeded;
    public final int minLoadableRetryCount;
    public byte[] sampleData;
    public int sampleSize;
    public final ArrayList<SampleStreamImpl> sampleStreams;
    public final TrackGroupArray tracks;
    public final boolean treatLoadErrorsAsEndOfStream;
    public final Uri uri;

    /* loaded from: classes7.dex */
    public final class SampleStreamImpl implements SampleStream {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int STREAM_STATE_END_OF_STREAM = 2;
        public static final int STREAM_STATE_SEND_FORMAT = 0;
        public static final int STREAM_STATE_SEND_SAMPLE = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public int streamState;
        public final /* synthetic */ SingleSampleMediaPeriod this$0;

        public SampleStreamImpl(SingleSampleMediaPeriod singleSampleMediaPeriod) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleSampleMediaPeriod};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = singleSampleMediaPeriod;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.this$0.loadingFinished : invokeV.booleanValue;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SingleSampleMediaPeriod singleSampleMediaPeriod = this.this$0;
                if (singleSampleMediaPeriod.treatLoadErrorsAsEndOfStream) {
                    return;
                }
                singleSampleMediaPeriod.loader.maybeThrowError();
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, formatHolder, decoderInputBuffer, z)) == null) {
                int i2 = this.streamState;
                if (i2 == 2) {
                    decoderInputBuffer.addFlag(4);
                    return -4;
                } else if (!z && i2 != 0) {
                    SingleSampleMediaPeriod singleSampleMediaPeriod = this.this$0;
                    if (singleSampleMediaPeriod.loadingFinished) {
                        if (singleSampleMediaPeriod.loadingSucceeded) {
                            decoderInputBuffer.timeUs = 0L;
                            decoderInputBuffer.addFlag(1);
                            decoderInputBuffer.ensureSpaceForWrite(this.this$0.sampleSize);
                            ByteBuffer byteBuffer = decoderInputBuffer.data;
                            SingleSampleMediaPeriod singleSampleMediaPeriod2 = this.this$0;
                            byteBuffer.put(singleSampleMediaPeriod2.sampleData, 0, singleSampleMediaPeriod2.sampleSize);
                        } else {
                            decoderInputBuffer.addFlag(4);
                        }
                        this.streamState = 2;
                        return -4;
                    }
                    return -3;
                } else {
                    formatHolder.format = this.this$0.format;
                    this.streamState = 1;
                    return -5;
                }
            }
            return invokeLLZ.intValue;
        }

        public void seekToUs(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) && this.streamState == 2) {
                this.streamState = 1;
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) {
                if (j2 <= 0 || this.streamState == 2) {
                    return 0;
                }
                this.streamState = 2;
                return 1;
            }
            return invokeJ.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class SourceLoadable implements Loader.Loadable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final DataSource dataSource;
        public byte[] sampleData;
        public int sampleSize;
        public final Uri uri;

        public SourceLoadable(Uri uri, DataSource dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uri, dataSource};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.uri = uri;
            this.dataSource = dataSource;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void cancelLoad() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public boolean isLoadCanceled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void load() throws IOException, InterruptedException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i2 = 0;
                this.sampleSize = 0;
                try {
                    this.dataSource.open(new DataSpec(this.uri));
                    while (i2 != -1) {
                        int i3 = this.sampleSize + i2;
                        this.sampleSize = i3;
                        if (this.sampleData == null) {
                            this.sampleData = new byte[1024];
                        } else if (i3 == this.sampleData.length) {
                            this.sampleData = Arrays.copyOf(this.sampleData, this.sampleData.length * 2);
                        }
                        i2 = this.dataSource.read(this.sampleData, this.sampleSize, this.sampleData.length - this.sampleSize);
                    }
                } finally {
                    Util.closeQuietly(this.dataSource);
                }
            }
        }
    }

    public SingleSampleMediaPeriod(Uri uri, DataSource.Factory factory, Format format, int i2, Handler handler, SingleSampleMediaSource.EventListener eventListener, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, factory, format, Integer.valueOf(i2), handler, eventListener, Integer.valueOf(i3), Boolean.valueOf(z)};
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
        this.dataSourceFactory = factory;
        this.format = format;
        this.minLoadableRetryCount = i2;
        this.eventHandler = handler;
        this.eventListener = eventListener;
        this.eventSourceId = i3;
        this.treatLoadErrorsAsEndOfStream = z;
        this.tracks = new TrackGroupArray(new TrackGroup(format));
        this.sampleStreams = new ArrayList<>();
        this.loader = new Loader("Loader:SingleSampleMediaPeriod");
    }

    private void notifyLoadError(IOException iOException) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, iOException) == null) || (handler = this.eventHandler) == null || this.eventListener == null) {
            return;
        }
        handler.post(new Runnable(this, iOException) { // from class: com.google.android.exoplayer2.source.SingleSampleMediaPeriod.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SingleSampleMediaPeriod this$0;
            public final /* synthetic */ IOException val$e;

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
                this.val$e = iOException;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.eventListener.onLoadError(this.this$0.eventSourceId, this.val$e);
                }
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            if (this.loadingFinished || this.loader.isLoading()) {
                return false;
            }
            this.loader.startLoading(new SourceLoadable(this.uri, this.dataSourceFactory.createDataSource()), this, this.minLoadableRetryCount);
            return true;
        }
        return invokeJ.booleanValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.loadingFinished ? Long.MIN_VALUE : 0L : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.loadingFinished || this.loader.isLoading()) ? Long.MIN_VALUE : 0L : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.tracks : (TrackGroupArray) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(SourceLoadable sourceLoadable, long j2, long j3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{sourceLoadable, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)}) == null) {
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048588, this, callback, j2) == null) {
            callback.onPrepared(this);
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
            this.loader.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048591, this, j2)) == null) {
            for (int i2 = 0; i2 < this.sampleStreams.size(); i2++) {
                this.sampleStreams.get(i2).seekToUs(j2);
            }
            return j2;
        }
        return invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{trackSelectionArr, zArr, sampleStreamArr, zArr2, Long.valueOf(j2)})) == null) {
            for (int i2 = 0; i2 < trackSelectionArr.length; i2++) {
                if (sampleStreamArr[i2] != null && (trackSelectionArr[i2] == null || !zArr[i2])) {
                    this.sampleStreams.remove(sampleStreamArr[i2]);
                    sampleStreamArr[i2] = null;
                }
                if (sampleStreamArr[i2] == null && trackSelectionArr[i2] != null) {
                    SampleStreamImpl sampleStreamImpl = new SampleStreamImpl();
                    this.sampleStreams.add(sampleStreamImpl);
                    sampleStreamArr[i2] = sampleStreamImpl;
                    zArr2[i2] = true;
                }
            }
            return j2;
        }
        return invokeCommon.longValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(SourceLoadable sourceLoadable, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{sourceLoadable, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.sampleSize = sourceLoadable.sampleSize;
            this.sampleData = sourceLoadable.sampleData;
            this.loadingFinished = true;
            this.loadingSucceeded = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public int onLoadError(SourceLoadable sourceLoadable, long j2, long j3, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{sourceLoadable, Long.valueOf(j2), Long.valueOf(j3), iOException})) == null) {
            notifyLoadError(iOException);
            int i2 = this.errorCount + 1;
            this.errorCount = i2;
            if (!this.treatLoadErrorsAsEndOfStream || i2 < this.minLoadableRetryCount) {
                return 0;
            }
            this.loadingFinished = true;
            return 2;
        }
        return invokeCommon.intValue;
    }
}
