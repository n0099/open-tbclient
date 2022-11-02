package org.webrtc;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.VideoFrame;
/* loaded from: classes9.dex */
public class NativeCapturerObserver implements CapturerObserver {
    public static /* synthetic */ Interceptable $ic;
    public static VideoSink myHookSink;
    public transient /* synthetic */ FieldHolder $fh;
    public final long nativeSource;
    public final SurfaceTextureHelper surfaceTextureHelper;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(351834231, "Lorg/webrtc/NativeCapturerObserver;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(351834231, "Lorg/webrtc/NativeCapturerObserver;");
        }
    }

    public static native void nativeCapturerStarted(long j, boolean z);

    public static native void nativeCapturerStopped(long j);

    public static native void nativeOnFrameCaptured(long j, int i, int i2, int i3, long j2, VideoFrame.Buffer buffer);

    @CalledByNative
    public NativeCapturerObserver(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.nativeSource = j;
        this.surfaceTextureHelper = null;
    }

    @Override // org.webrtc.CapturerObserver
    public void onFrameCaptured(VideoFrame videoFrame) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, videoFrame) == null) {
            VideoSink videoSink = myHookSink;
            if (videoSink != null) {
                videoSink.onFrame(videoFrame);
            }
            nativeOnFrameCaptured(this.nativeSource, videoFrame.getBuffer().getWidth(), videoFrame.getBuffer().getHeight(), videoFrame.getRotation(), videoFrame.getTimestampNs(), videoFrame.getBuffer());
        }
    }

    public NativeCapturerObserver(long j, SurfaceTextureHelper surfaceTextureHelper) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), surfaceTextureHelper};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.nativeSource = j;
        this.surfaceTextureHelper = surfaceTextureHelper;
    }

    public static void setMyHookSink(VideoSink videoSink) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, videoSink) == null) {
            myHookSink = videoSink;
        }
    }

    @Override // org.webrtc.CapturerObserver
    public void onCapturerStarted(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            nativeCapturerStarted(this.nativeSource, z);
        }
    }

    public void dispose() {
        SurfaceTextureHelper surfaceTextureHelper;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (surfaceTextureHelper = this.surfaceTextureHelper) != null) {
            surfaceTextureHelper.dispose();
        }
    }

    @Override // org.webrtc.CapturerObserver
    public void onCapturerStopped() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            nativeCapturerStopped(this.nativeSource);
        }
    }
}
