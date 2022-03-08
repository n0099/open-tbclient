package h.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.webrtc.CalledByNative;
import org.webrtc.VideoDecoder;
/* compiled from: VideoDecoder.java */
/* loaded from: classes8.dex */
public final /* synthetic */ class k0 {
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
