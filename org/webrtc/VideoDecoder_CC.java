package org.webrtc;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public final /* synthetic */ class VideoDecoder_CC {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @CalledByNative
    public static long $default$createNativeVideoDecoder(VideoDecoder videoDecoder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, videoDecoder)) == null) {
            return 0L;
        }
        return invokeL.longValue;
    }
}
