package org.webrtc;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public final /* synthetic */ class VideoEncoder_CC {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @CalledByNative
    public static long $default$createNativeVideoEncoder(VideoEncoder videoEncoder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, videoEncoder)) == null) {
            return 0L;
        }
        return invokeL.longValue;
    }

    @CalledByNative
    public static boolean $default$isHardwareEncoder(VideoEncoder videoEncoder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, videoEncoder)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }
}
