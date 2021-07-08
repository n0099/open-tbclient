package org.webrtc;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class VideoSource extends MediaSource {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NativeCapturerObserver capturerObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoSource(long j) {
        super(j);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.capturerObserver = new NativeCapturerObserver(nativeGetInternalSource(j));
    }

    public static native void nativeAdaptOutputFormat(long j, int i2, int i3, int i4, int i5, int i6);

    public static native long nativeGetInternalSource(long j);

    public void adaptOutputFormat(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) {
            int max = Math.max(i2, i3);
            int min = Math.min(i2, i3);
            adaptOutputFormat(max, min, min, max, i4);
        }
    }

    public void adaptOutputFormat(int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            nativeAdaptOutputFormat(getNativeVideoTrackSource(), i2, i3, i4, i5, i6);
        }
    }

    public CapturerObserver getCapturerObserver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.capturerObserver : (CapturerObserver) invokeV.objValue;
    }

    public long getNativeVideoTrackSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getNativeMediaSource() : invokeV.longValue;
    }
}
