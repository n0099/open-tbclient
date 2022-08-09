package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.SlidingPercentile;
/* loaded from: classes5.dex */
public final class DefaultBandwidthMeter implements BandwidthMeter, TransferListener<Object> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BYTES_TRANSFERRED_FOR_ESTIMATE = 524288;
    public static final int DEFAULT_MAX_WEIGHT = 2000;
    public static final int ELAPSED_MILLIS_FOR_ESTIMATE = 2000;
    public transient /* synthetic */ FieldHolder $fh;
    public long bitrateEstimate;
    public final Clock clock;
    public final Handler eventHandler;
    public final BandwidthMeter.EventListener eventListener;
    public long sampleBytesTransferred;
    public long sampleStartTimeMs;
    public final SlidingPercentile slidingPercentile;
    public int streamCount;
    public long totalBytesTransferred;
    public long totalElapsedTimeMs;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultBandwidthMeter() {
        this(null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((Handler) objArr[0], (BandwidthMeter.EventListener) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void notifyBandwidthSample(int i, long j, long j2) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) || (handler = this.eventHandler) == null || this.eventListener == null) {
            return;
        }
        handler.post(new Runnable(this, i, j, j2) { // from class: com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DefaultBandwidthMeter this$0;
            public final /* synthetic */ long val$bitrate;
            public final /* synthetic */ long val$bytes;
            public final /* synthetic */ int val$elapsedMs;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)};
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
                this.val$elapsedMs = i;
                this.val$bytes = j;
                this.val$bitrate = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.eventListener.onBandwidthSample(this.val$elapsedMs, this.val$bytes, this.val$bitrate);
                }
            }
        });
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public synchronized long getBitrateEstimate() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                j = this.bitrateEstimate;
            }
            return j;
        }
        return invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void onBytesTransferred(Object obj, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            synchronized (this) {
                this.sampleBytesTransferred += i;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void onTransferEnd(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            synchronized (this) {
                Assertions.checkState(this.streamCount > 0);
                long elapsedRealtime = this.clock.elapsedRealtime();
                int i = (int) (elapsedRealtime - this.sampleStartTimeMs);
                long j = i;
                this.totalElapsedTimeMs += j;
                this.totalBytesTransferred += this.sampleBytesTransferred;
                if (i > 0) {
                    this.slidingPercentile.addSample((int) Math.sqrt(this.sampleBytesTransferred), (float) ((this.sampleBytesTransferred * 8000) / j));
                    if (this.totalElapsedTimeMs >= 2000 || this.totalBytesTransferred >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                        float percentile = this.slidingPercentile.getPercentile(0.5f);
                        this.bitrateEstimate = Float.isNaN(percentile) ? -1L : percentile;
                    }
                }
                notifyBandwidthSample(i, this.sampleBytesTransferred, this.bitrateEstimate);
                int i2 = this.streamCount - 1;
                this.streamCount = i2;
                if (i2 > 0) {
                    this.sampleStartTimeMs = elapsedRealtime;
                }
                this.sampleBytesTransferred = 0L;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void onTransferStart(Object obj, DataSpec dataSpec) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, dataSpec) == null) {
            synchronized (this) {
                if (this.streamCount == 0) {
                    this.sampleStartTimeMs = this.clock.elapsedRealtime();
                }
                this.streamCount++;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventListener) {
        this(handler, eventListener, 2000);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler, eventListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Handler) objArr2[0], (BandwidthMeter.EventListener) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventListener, int i) {
        this(handler, eventListener, i, Clock.DEFAULT);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler, eventListener, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Handler) objArr2[0], (BandwidthMeter.EventListener) objArr2[1], ((Integer) objArr2[2]).intValue(), (Clock) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventListener, int i, Clock clock) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler, eventListener, Integer.valueOf(i), clock};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.eventHandler = handler;
        this.eventListener = eventListener;
        this.slidingPercentile = new SlidingPercentile(i);
        this.clock = clock;
        this.bitrateEstimate = -1L;
    }
}
