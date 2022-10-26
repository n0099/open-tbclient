package org.webrtc;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.IdentityHashMap;
/* loaded from: classes9.dex */
public class VideoTrack extends MediaStreamTrack {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final IdentityHashMap sinks;

    public static native void nativeAddSink(long j, long j2);

    public static native void nativeFreeSink(long j);

    public static native void nativeRemoveSink(long j, long j2);

    public static native long nativeWrapSink(VideoSink videoSink);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoTrack(long j) {
        super(j);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sinks = new IdentityHashMap();
    }

    public void addSink(VideoSink videoSink) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, videoSink) == null) {
            if (videoSink != null) {
                if (!this.sinks.containsKey(videoSink)) {
                    long nativeWrapSink = nativeWrapSink(videoSink);
                    this.sinks.put(videoSink, Long.valueOf(nativeWrapSink));
                    nativeAddSink(getNativeMediaStreamTrack(), nativeWrapSink);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("The VideoSink is not allowed to be null");
        }
    }

    @Override // org.webrtc.MediaStreamTrack
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (Long l : this.sinks.values()) {
                long longValue = l.longValue();
                nativeRemoveSink(getNativeMediaStreamTrack(), longValue);
                nativeFreeSink(longValue);
            }
            this.sinks.clear();
            super.dispose();
        }
    }

    public long getNativeVideoTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return getNativeMediaStreamTrack();
        }
        return invokeV.longValue;
    }

    public void removeSink(VideoSink videoSink) {
        Long l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, videoSink) == null) && (l = (Long) this.sinks.remove(videoSink)) != null) {
            nativeRemoveSink(getNativeMediaStreamTrack(), l.longValue());
            nativeFreeSink(l.longValue());
        }
    }
}
