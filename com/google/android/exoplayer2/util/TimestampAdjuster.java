package com.google.android.exoplayer2.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
/* loaded from: classes7.dex */
public final class TimestampAdjuster {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long DO_NOT_OFFSET = Long.MAX_VALUE;
    public static final long MAX_PTS_PLUS_ONE = 8589934592L;
    public transient /* synthetic */ FieldHolder $fh;
    public long firstSampleTimestampUs;
    public volatile long lastSampleTimestamp;
    public long timestampOffsetUs;

    public TimestampAdjuster(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.lastSampleTimestamp = C.TIME_UNSET;
        setFirstSampleTimestampUs(j);
    }

    public static long ptsToUs(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j)) == null) ? (j * 1000000) / SapiWebView.DEFAULT_TIMEOUT_MILLIS : invokeJ.longValue;
    }

    public static long usToPts(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) ? (j * SapiWebView.DEFAULT_TIMEOUT_MILLIS) / 1000000 : invokeJ.longValue;
    }

    public long adjustSampleTimestamp(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            if (j == C.TIME_UNSET) {
                return C.TIME_UNSET;
            }
            if (this.lastSampleTimestamp != C.TIME_UNSET) {
                this.lastSampleTimestamp = j;
            } else {
                long j2 = this.firstSampleTimestampUs;
                if (j2 != Long.MAX_VALUE) {
                    this.timestampOffsetUs = j2 - j;
                }
                synchronized (this) {
                    this.lastSampleTimestamp = j;
                    notifyAll();
                }
            }
            return j + this.timestampOffsetUs;
        }
        return invokeJ.longValue;
    }

    public long adjustTsTimestamp(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (j == C.TIME_UNSET) {
                return C.TIME_UNSET;
            }
            if (this.lastSampleTimestamp != C.TIME_UNSET) {
                long usToPts = usToPts(this.lastSampleTimestamp);
                long j2 = (4294967296L + usToPts) / 8589934592L;
                long j3 = ((j2 - 1) * 8589934592L) + j;
                j += j2 * 8589934592L;
                if (Math.abs(j3 - usToPts) < Math.abs(j - usToPts)) {
                    j = j3;
                }
            }
            return adjustSampleTimestamp(ptsToUs(j));
        }
        return invokeJ.longValue;
    }

    public long getFirstSampleTimestampUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.firstSampleTimestampUs : invokeV.longValue;
    }

    public long getLastAdjustedTimestampUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.lastSampleTimestamp != C.TIME_UNSET) {
                return this.lastSampleTimestamp;
            }
            long j = this.firstSampleTimestampUs;
            return j != Long.MAX_VALUE ? j : C.TIME_UNSET;
        }
        return invokeV.longValue;
    }

    public long getTimestampOffsetUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.firstSampleTimestampUs == Long.MAX_VALUE) {
                return 0L;
            }
            return this.lastSampleTimestamp == C.TIME_UNSET ? C.TIME_UNSET : this.timestampOffsetUs;
        }
        return invokeV.longValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.lastSampleTimestamp = C.TIME_UNSET;
        }
    }

    public synchronized void setFirstSampleTimestampUs(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            synchronized (this) {
                Assertions.checkState(this.lastSampleTimestamp == C.TIME_UNSET);
                this.firstSampleTimestampUs = j;
            }
        }
    }

    public synchronized void waitUntilInitialized() throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                while (this.lastSampleTimestamp == C.TIME_UNSET) {
                    wait();
                }
            }
        }
    }
}
