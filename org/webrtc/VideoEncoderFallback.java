package org.webrtc;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.VideoEncoder;
/* loaded from: classes10.dex */
public class VideoEncoderFallback extends WrappedNativeVideoEncoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final VideoEncoder fallback;
    public final VideoEncoder primary;

    public VideoEncoderFallback(VideoEncoder videoEncoder, VideoEncoder videoEncoder2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {videoEncoder, videoEncoder2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fallback = videoEncoder;
        this.primary = videoEncoder2;
    }

    public static native long nativeCreateEncoder(VideoEncoder videoEncoder, VideoEncoder videoEncoder2);

    @Override // org.webrtc.WrappedNativeVideoEncoder, org.webrtc.VideoEncoder
    public long createNativeVideoEncoder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? nativeCreateEncoder(this.fallback, this.primary) : invokeV.longValue;
    }

    @Override // org.webrtc.WrappedNativeVideoEncoder, org.webrtc.VideoEncoder
    public /* bridge */ /* synthetic */ VideoCodecStatus encode(VideoFrame videoFrame, VideoEncoder.EncodeInfo encodeInfo) {
        return super.encode(videoFrame, encodeInfo);
    }

    @Override // org.webrtc.WrappedNativeVideoEncoder, org.webrtc.VideoEncoder
    public /* bridge */ /* synthetic */ String getImplementationName() {
        return super.getImplementationName();
    }

    @Override // org.webrtc.WrappedNativeVideoEncoder, org.webrtc.VideoEncoder
    public /* bridge */ /* synthetic */ VideoEncoder.ScalingSettings getScalingSettings() {
        return super.getScalingSettings();
    }

    @Override // org.webrtc.WrappedNativeVideoEncoder, org.webrtc.VideoEncoder
    public /* bridge */ /* synthetic */ VideoCodecStatus initEncode(VideoEncoder.Settings settings, VideoEncoder.Callback callback) {
        return super.initEncode(settings, callback);
    }

    @Override // org.webrtc.WrappedNativeVideoEncoder, org.webrtc.VideoEncoder
    public boolean isHardwareEncoder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.primary.isHardwareEncoder() : invokeV.booleanValue;
    }

    @Override // org.webrtc.WrappedNativeVideoEncoder, org.webrtc.VideoEncoder
    public /* bridge */ /* synthetic */ VideoCodecStatus release() {
        return super.release();
    }

    @Override // org.webrtc.WrappedNativeVideoEncoder, org.webrtc.VideoEncoder
    public /* bridge */ /* synthetic */ VideoCodecStatus setRateAllocation(VideoEncoder.BitrateAllocation bitrateAllocation, int i2) {
        return super.setRateAllocation(bitrateAllocation, i2);
    }
}
