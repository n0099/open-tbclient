package org.webrtc;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.LinkedHashSet;
import javax.annotation.Nullable;
import org.webrtc.EglBase;
/* loaded from: classes8.dex */
public class DefaultVideoEncoderFactory implements VideoEncoderFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final VideoEncoderFactory hardwareVideoEncoderFactory;
    public final VideoEncoderFactory softwareVideoEncoderFactory;

    public DefaultVideoEncoderFactory(EglBase.Context context, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.softwareVideoEncoderFactory = new SoftwareVideoEncoderFactory();
        this.hardwareVideoEncoderFactory = new HardwareVideoEncoderFactory(context, z, z2);
    }

    public DefaultVideoEncoderFactory(VideoEncoderFactory videoEncoderFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {videoEncoderFactory};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.softwareVideoEncoderFactory = new SoftwareVideoEncoderFactory();
        this.hardwareVideoEncoderFactory = videoEncoderFactory;
    }

    @Override // org.webrtc.VideoEncoderFactory
    @Nullable
    public VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, videoCodecInfo)) == null) {
            VideoEncoder createEncoder = this.softwareVideoEncoderFactory.createEncoder(videoCodecInfo);
            VideoEncoder createEncoder2 = this.hardwareVideoEncoderFactory.createEncoder(videoCodecInfo);
            if (createEncoder2 != null && createEncoder != null) {
                return new VideoEncoderFallback(createEncoder, createEncoder2);
            }
            if (createEncoder2 != null) {
                return createEncoder2;
            }
            return createEncoder;
        }
        return (VideoEncoder) invokeL.objValue;
    }

    @Override // org.webrtc.VideoEncoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            linkedHashSet.addAll(Arrays.asList(this.softwareVideoEncoderFactory.getSupportedCodecs()));
            linkedHashSet.addAll(Arrays.asList(this.hardwareVideoEncoderFactory.getSupportedCodecs()));
            return (VideoCodecInfo[]) linkedHashSet.toArray(new VideoCodecInfo[linkedHashSet.size()]);
        }
        return (VideoCodecInfo[]) invokeV.objValue;
    }
}
