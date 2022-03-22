package org.webrtc;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class TimestampAligner {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile long nativeTimestampAligner;

    public TimestampAligner() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.nativeTimestampAligner = nativeCreateTimestampAligner();
    }

    private void checkNativeAlignerExists() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.nativeTimestampAligner == 0) {
            throw new IllegalStateException("TimestampAligner has been disposed.");
        }
    }

    public static long getRtcTimeNanos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? nativeRtcTimeNanos() : invokeV.longValue;
    }

    public static native long nativeCreateTimestampAligner();

    public static native void nativeReleaseTimestampAligner(long j);

    public static native long nativeRtcTimeNanos();

    public static native long nativeTranslateTimestamp(long j, long j2);

    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            checkNativeAlignerExists();
            nativeReleaseTimestampAligner(this.nativeTimestampAligner);
            this.nativeTimestampAligner = 0L;
        }
    }

    public long translateTimestamp(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            checkNativeAlignerExists();
            return nativeTranslateTimestamp(this.nativeTimestampAligner, j);
        }
        return invokeJ.longValue;
    }
}
