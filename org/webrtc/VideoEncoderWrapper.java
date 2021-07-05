package org.webrtc;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.webrtc.VideoEncoder;
/* loaded from: classes10.dex */
public class VideoEncoderWrapper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public VideoEncoderWrapper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @CalledByNative
    public static VideoEncoder.Callback createEncoderCallback(final long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j)) == null) ? new VideoEncoder.Callback() { // from class: org.webrtc._$$Lambda$VideoEncoderWrapper$dRHADZXMoanHTOdEf2Act96Dzi0
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // org.webrtc.VideoEncoder.Callback
            public final void onEncodedFrame(EncodedImage encodedImage, VideoEncoder.CodecSpecificInfo codecSpecificInfo) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, encodedImage, codecSpecificInfo) == null) {
                    VideoEncoderWrapper.nativeOnEncodedFrame(j, encodedImage.buffer, encodedImage.encodedWidth, encodedImage.encodedHeight, encodedImage.captureTimeNs, encodedImage.frameType.getNative(), encodedImage.rotation, encodedImage.completeFrame, encodedImage.qp);
                }
            }
        } : (VideoEncoder.Callback) invokeJ.objValue;
    }

    @Nullable
    @CalledByNative
    public static Integer getScalingSettingsHigh(VideoEncoder.ScalingSettings scalingSettings) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, scalingSettings)) == null) ? scalingSettings.high : (Integer) invokeL.objValue;
    }

    @Nullable
    @CalledByNative
    public static Integer getScalingSettingsLow(VideoEncoder.ScalingSettings scalingSettings) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, scalingSettings)) == null) ? scalingSettings.low : (Integer) invokeL.objValue;
    }

    @CalledByNative
    public static boolean getScalingSettingsOn(VideoEncoder.ScalingSettings scalingSettings) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, scalingSettings)) == null) ? scalingSettings.on : invokeL.booleanValue;
    }

    public static native void nativeOnEncodedFrame(long j, ByteBuffer byteBuffer, int i2, int i3, long j2, int i4, int i5, boolean z, Integer num);
}
