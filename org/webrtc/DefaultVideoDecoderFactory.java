package org.webrtc;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vu9;
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
public class DefaultVideoDecoderFactory implements VideoDecoderFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final VideoDecoderFactory hardwareVideoDecoderFactory;
    @Nullable
    public final VideoDecoderFactory platformSoftwareVideoDecoderFactory;
    public final VideoDecoderFactory softwareVideoDecoderFactory;

    public DefaultVideoDecoderFactory(@Nullable EglBase.Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.softwareVideoDecoderFactory = new SoftwareVideoDecoderFactory();
        this.hardwareVideoDecoderFactory = new HardwareVideoDecoderFactory(context);
        this.platformSoftwareVideoDecoderFactory = new PlatformSoftwareVideoDecoderFactory(context);
    }

    @Override // org.webrtc.VideoDecoderFactory
    @Nullable
    @Deprecated
    public /* synthetic */ VideoDecoder createDecoder(String str) {
        return vu9.$default$createDecoder(this, str);
    }

    @Override // org.webrtc.VideoDecoderFactory
    @Nullable
    public VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo) {
        InterceptResult invokeL;
        VideoDecoderFactory videoDecoderFactory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoCodecInfo)) == null) {
            VideoDecoder createDecoder = this.softwareVideoDecoderFactory.createDecoder(videoCodecInfo);
            VideoDecoder createDecoder2 = this.hardwareVideoDecoderFactory.createDecoder(videoCodecInfo);
            if (createDecoder == null && (videoDecoderFactory = this.platformSoftwareVideoDecoderFactory) != null) {
                createDecoder = videoDecoderFactory.createDecoder(videoCodecInfo);
            }
            if (createDecoder2 == null || createDecoder == null) {
                return createDecoder2 != null ? createDecoder2 : createDecoder;
            }
            return new VideoDecoderFallback(createDecoder, createDecoder2);
        }
        return (VideoDecoder) invokeL.objValue;
    }

    @Override // org.webrtc.VideoDecoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            linkedHashSet.addAll(Arrays.asList(this.softwareVideoDecoderFactory.getSupportedCodecs()));
            linkedHashSet.addAll(Arrays.asList(this.hardwareVideoDecoderFactory.getSupportedCodecs()));
            VideoDecoderFactory videoDecoderFactory = this.platformSoftwareVideoDecoderFactory;
            if (videoDecoderFactory != null) {
                linkedHashSet.addAll(Arrays.asList(videoDecoderFactory.getSupportedCodecs()));
            }
            return (VideoCodecInfo[]) linkedHashSet.toArray(new VideoCodecInfo[linkedHashSet.size()]);
        }
        return (VideoCodecInfo[]) invokeV.objValue;
    }

    public DefaultVideoDecoderFactory(VideoDecoderFactory videoDecoderFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {videoDecoderFactory};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.softwareVideoDecoderFactory = new SoftwareVideoDecoderFactory();
        this.hardwareVideoDecoderFactory = videoDecoderFactory;
        this.platformSoftwareVideoDecoderFactory = null;
    }
}
