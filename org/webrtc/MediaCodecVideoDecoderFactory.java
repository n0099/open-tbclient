package org.webrtc;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.x2a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import javax.annotation.Nullable;
import org.webrtc.EglBase;
/* loaded from: classes9.dex */
public class MediaCodecVideoDecoderFactory implements VideoDecoderFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MediaCodecVideoDecoderFactory";
    public transient /* synthetic */ FieldHolder $fh;
    public final String[] prefixBlacklist;
    public final String[] prefixWhitelist;
    @Nullable
    public final EglBase.Context sharedContext;

    @Override // org.webrtc.VideoDecoderFactory
    @Nullable
    @Deprecated
    public /* synthetic */ VideoDecoder createDecoder(String str) {
        return x2a.$default$createDecoder(this, str);
    }

    public MediaCodecVideoDecoderFactory(@Nullable EglBase.Context context, String[] strArr, String[] strArr2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, strArr, strArr2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sharedContext = context;
        this.prefixWhitelist = (String[]) Arrays.copyOf(strArr, strArr.length);
        this.prefixBlacklist = (String[]) Arrays.copyOf(strArr2, strArr2.length);
    }

    @Nullable
    private MediaCodecInfo findCodecForType(VideoCodecType videoCodecType) {
        InterceptResult invokeL;
        MediaCodecInfo mediaCodecInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, videoCodecType)) == null) {
            if (Build.VERSION.SDK_INT < 19) {
                return null;
            }
            for (int i = 0; i < MediaCodecList.getCodecCount(); i++) {
                try {
                    mediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
                } catch (IllegalArgumentException e) {
                    Logging.e(TAG, "Cannot retrieve decoder codec info", e);
                    mediaCodecInfo = null;
                }
                if (mediaCodecInfo != null && !mediaCodecInfo.isEncoder() && isSupportedCodec(mediaCodecInfo, videoCodecType)) {
                    return mediaCodecInfo;
                }
            }
            return null;
        }
        return (MediaCodecInfo) invokeL.objValue;
    }

    private boolean isH264HighProfileSupported(MediaCodecInfo mediaCodecInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, mediaCodecInfo)) == null) {
            String name = mediaCodecInfo.getName();
            if (Build.VERSION.SDK_INT >= 21 && name.startsWith("OMX.qcom.")) {
                return true;
            }
            if (Build.VERSION.SDK_INT >= 23 && name.startsWith("OMX.Exynos.")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private boolean isBlacklisted(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            for (String str2 : this.prefixBlacklist) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private boolean isWhitelisted(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            for (String str2 : this.prefixWhitelist) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private boolean isSupportedCodec(MediaCodecInfo mediaCodecInfo, VideoCodecType videoCodecType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, mediaCodecInfo, videoCodecType)) == null) {
            String name = mediaCodecInfo.getName();
            if (!MediaCodecUtils.codecSupportsType(mediaCodecInfo, videoCodecType) || MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, mediaCodecInfo.getCapabilitiesForType(videoCodecType.mimeType())) == null || !isWhitelisted(name) || isBlacklisted(name)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // org.webrtc.VideoDecoderFactory
    @Nullable
    public VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoCodecInfo)) == null) {
            VideoCodecType valueOf = VideoCodecType.valueOf(videoCodecInfo.getName());
            MediaCodecInfo findCodecForType = findCodecForType(valueOf);
            if (findCodecForType == null) {
                return null;
            }
            return new AndroidVideoDecoder(new MediaCodecWrapperFactoryImpl(), findCodecForType.getName(), valueOf, MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, findCodecForType.getCapabilitiesForType(valueOf.mimeType())).intValue(), this.sharedContext);
        }
        return (VideoDecoder) invokeL.objValue;
    }

    @Override // org.webrtc.VideoDecoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            VideoCodecType[] videoCodecTypeArr = {VideoCodecType.VP8, VideoCodecType.VP9, VideoCodecType.H264};
            for (int i = 0; i < 3; i++) {
                VideoCodecType videoCodecType = videoCodecTypeArr[i];
                MediaCodecInfo findCodecForType = findCodecForType(videoCodecType);
                if (findCodecForType != null) {
                    String name = videoCodecType.name();
                    if (videoCodecType == VideoCodecType.H264 && isH264HighProfileSupported(findCodecForType)) {
                        arrayList.add(new VideoCodecInfo(name, MediaCodecUtils.getCodecProperties(videoCodecType, true)));
                    }
                    arrayList.add(new VideoCodecInfo(name, MediaCodecUtils.getCodecProperties(videoCodecType, false)));
                }
            }
            return (VideoCodecInfo[]) arrayList.toArray(new VideoCodecInfo[arrayList.size()]);
        }
        return (VideoCodecInfo[]) invokeV.objValue;
    }
}
