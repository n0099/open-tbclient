package h.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import javax.annotation.Nullable;
import org.webrtc.VideoDecoder;
import org.webrtc.VideoDecoderFactory;
/* compiled from: VideoDecoderFactory.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class l0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    @Deprecated
    public static VideoDecoder $default$createDecoder(VideoDecoderFactory videoDecoderFactory, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, videoDecoderFactory, str)) == null) {
            throw new UnsupportedOperationException("Deprecated and not implemented.");
        }
        return (VideoDecoder) invokeLL.objValue;
    }
}
