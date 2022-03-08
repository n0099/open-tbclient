package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
/* loaded from: classes7.dex */
public final class SingleSampleMediaSource implements MediaSource {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public final DataSource.Factory dataSourceFactory;
    public final Handler eventHandler;
    public final EventListener eventListener;
    public final int eventSourceId;
    public final Format format;
    public final int minLoadableRetryCount;
    public final Timeline timeline;
    public final boolean treatLoadErrorsAsEndOfStream;
    public final Uri uri;

    /* loaded from: classes7.dex */
    public interface EventListener {
        void onLoadError(int i2, IOException iOException);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SingleSampleMediaSource(Uri uri, DataSource.Factory factory, Format format, long j2) {
        this(uri, factory, format, j2, 3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, factory, format, Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], (DataSource.Factory) objArr2[1], (Format) objArr2[2], ((Long) objArr2[3]).longValue(), ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mediaPeriodId, allocator)) == null) {
            Assertions.checkArgument(mediaPeriodId.periodIndex == 0);
            return new SingleSampleMediaPeriod(this.uri, this.dataSourceFactory, this.format, this.minLoadableRetryCount, this.eventHandler, this.eventListener, this.eventSourceId, this.treatLoadErrorsAsEndOfStream);
        }
        return (MediaPeriod) invokeLL.objValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(ExoPlayer exoPlayer, boolean z, MediaSource.Listener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{exoPlayer, Boolean.valueOf(z), listener}) == null) {
            listener.onSourceInfoRefreshed(this, this.timeline, null);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mediaPeriod) == null) {
            ((SingleSampleMediaPeriod) mediaPeriod).release();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SingleSampleMediaSource(Uri uri, DataSource.Factory factory, Format format, long j2, int i2) {
        this(uri, factory, format, j2, i2, null, null, 0, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {uri, factory, format, Long.valueOf(j2), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], (DataSource.Factory) objArr2[1], (Format) objArr2[2], ((Long) objArr2[3]).longValue(), ((Integer) objArr2[4]).intValue(), (Handler) objArr2[5], (EventListener) objArr2[6], ((Integer) objArr2[7]).intValue(), ((Boolean) objArr2[8]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public SingleSampleMediaSource(Uri uri, DataSource.Factory factory, Format format, long j2, int i2, Handler handler, EventListener eventListener, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, factory, format, Long.valueOf(j2), Integer.valueOf(i2), handler, eventListener, Integer.valueOf(i3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
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
        this.timeline = new SinglePeriodTimeline(j2, true);
    }
}
