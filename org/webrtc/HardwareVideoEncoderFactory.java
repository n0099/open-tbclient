package org.webrtc;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import org.webrtc.EglBase;
import org.webrtc.EglBase14;
/* loaded from: classes2.dex */
public class HardwareVideoEncoderFactory implements VideoEncoderFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final List<String> H264_HW_EXCEPTION_MODELS;
    public static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_L_MS = 15000;
    public static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_M_MS = 20000;
    public static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_N_MS = 15000;
    public static final String TAG = "HardwareVideoEncoderFactory";
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean enableH264HighProfile;
    public final boolean enableIntelVp8Encoder;
    @Nullable
    public final EglBase14.Context sharedContext;

    /* renamed from: org.webrtc.HardwareVideoEncoderFactory$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$webrtc$VideoCodecType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1341430472, "Lorg/webrtc/HardwareVideoEncoderFactory$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1341430472, "Lorg/webrtc/HardwareVideoEncoderFactory$1;");
                    return;
                }
            }
            int[] iArr = new int[VideoCodecType.values().length];
            $SwitchMap$org$webrtc$VideoCodecType = iArr;
            try {
                iArr[VideoCodecType.VP8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$webrtc$VideoCodecType[VideoCodecType.VP9.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$webrtc$VideoCodecType[VideoCodecType.H264.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-707540315, "Lorg/webrtc/HardwareVideoEncoderFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-707540315, "Lorg/webrtc/HardwareVideoEncoderFactory;");
                return;
            }
        }
        H264_HW_EXCEPTION_MODELS = Arrays.asList("SAMSUNG-SGH-I337", "Nexus 7", "Nexus 4");
    }

    public HardwareVideoEncoderFactory(EglBase.Context context, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (context instanceof EglBase14.Context) {
            this.sharedContext = (EglBase14.Context) context;
        } else {
            Logging.w(TAG, "No shared EglBase.Context.  Encoders will not use texture mode.");
            this.sharedContext = null;
        }
        this.enableIntelVp8Encoder = z;
        this.enableH264HighProfile = z2;
    }

    private BitrateAdjuster createBitrateAdjuster(VideoCodecType videoCodecType, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, videoCodecType, str)) == null) {
            if (str.startsWith("OMX.Exynos.")) {
                if (videoCodecType == VideoCodecType.VP8) {
                    return new DynamicBitrateAdjuster();
                }
                return new FramerateBitrateAdjuster();
            }
            return new BaseBitrateAdjuster();
        }
        return (BitrateAdjuster) invokeLL.objValue;
    }

    @Nullable
    private MediaCodecInfo findCodecForType(VideoCodecType videoCodecType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, videoCodecType)) != null) {
            return (MediaCodecInfo) invokeL.objValue;
        }
        int i2 = 0;
        while (true) {
            MediaCodecInfo mediaCodecInfo = null;
            if (i2 >= MediaCodecList.getCodecCount()) {
                return null;
            }
            try {
                mediaCodecInfo = MediaCodecList.getCodecInfoAt(i2);
            } catch (IllegalArgumentException e2) {
                Logging.e(TAG, "Cannot retrieve encoder codec info", e2);
            }
            if (mediaCodecInfo != null && mediaCodecInfo.isEncoder() && isSupportedCodec(mediaCodecInfo, videoCodecType)) {
                return mediaCodecInfo;
            }
            i2++;
        }
    }

    private int getForcedKeyFrameIntervalMs(VideoCodecType videoCodecType, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, videoCodecType, str)) == null) {
            if (videoCodecType == VideoCodecType.VP8 && str.startsWith("OMX.qcom.")) {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 != 21 && i2 != 22) {
                    if (i2 == 23) {
                        return 20000;
                    }
                    if (i2 <= 23) {
                        return 0;
                    }
                }
                return 15000;
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    private int getKeyFrameIntervalSec(VideoCodecType videoCodecType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, videoCodecType)) == null) {
            int i2 = AnonymousClass1.$SwitchMap$org$webrtc$VideoCodecType[videoCodecType.ordinal()];
            if (i2 == 1 || i2 == 2) {
                return 100;
            }
            if (i2 == 3) {
                return 20;
            }
            throw new IllegalArgumentException("Unsupported VideoCodecType " + videoCodecType);
        }
        return invokeL.intValue;
    }

    private boolean isH264HighProfileSupported(MediaCodecInfo mediaCodecInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, this, mediaCodecInfo)) == null) ? this.enableH264HighProfile && Build.VERSION.SDK_INT > 23 && mediaCodecInfo.getName().startsWith("OMX.Exynos.") : invokeL.booleanValue;
    }

    private boolean isHardwareSupportedInCurrentSdk(MediaCodecInfo mediaCodecInfo, VideoCodecType videoCodecType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, mediaCodecInfo, videoCodecType)) == null) {
            int i2 = AnonymousClass1.$SwitchMap$org$webrtc$VideoCodecType[videoCodecType.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return false;
                    }
                    return isHardwareSupportedInCurrentSdkH264(mediaCodecInfo);
                }
                return isHardwareSupportedInCurrentSdkVp9(mediaCodecInfo);
            }
            return isHardwareSupportedInCurrentSdkVp8(mediaCodecInfo);
        }
        return invokeLL.booleanValue;
    }

    private boolean isHardwareSupportedInCurrentSdkH264(MediaCodecInfo mediaCodecInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, mediaCodecInfo)) == null) {
            if (H264_HW_EXCEPTION_MODELS.contains(Build.MODEL)) {
                return false;
            }
            String name = mediaCodecInfo.getName();
            return (name.startsWith("OMX.qcom.") && Build.VERSION.SDK_INT >= 19) || (name.startsWith("OMX.Exynos.") && Build.VERSION.SDK_INT >= 21);
        }
        return invokeL.booleanValue;
    }

    private boolean isHardwareSupportedInCurrentSdkVp8(MediaCodecInfo mediaCodecInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, mediaCodecInfo)) == null) {
            String name = mediaCodecInfo.getName();
            return (name.startsWith("OMX.qcom.") && Build.VERSION.SDK_INT >= 19) || (name.startsWith("OMX.Exynos.") && Build.VERSION.SDK_INT >= 23) || (name.startsWith(MediaCodecUtils.INTEL_PREFIX) && Build.VERSION.SDK_INT >= 21 && this.enableIntelVp8Encoder);
        }
        return invokeL.booleanValue;
    }

    private boolean isHardwareSupportedInCurrentSdkVp9(MediaCodecInfo mediaCodecInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, mediaCodecInfo)) == null) {
            String name = mediaCodecInfo.getName();
            return (name.startsWith("OMX.qcom.") || name.startsWith("OMX.Exynos.")) && Build.VERSION.SDK_INT >= 24;
        }
        return invokeL.booleanValue;
    }

    private boolean isSupportedCodec(MediaCodecInfo mediaCodecInfo, VideoCodecType videoCodecType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, mediaCodecInfo, videoCodecType)) == null) {
            if (MediaCodecUtils.codecSupportsType(mediaCodecInfo, videoCodecType) && MediaCodecUtils.selectColorFormat(MediaCodecUtils.ENCODER_COLOR_FORMATS, mediaCodecInfo.getCapabilitiesForType(videoCodecType.mimeType())) != null) {
                return isHardwareSupportedInCurrentSdk(mediaCodecInfo, videoCodecType);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // org.webrtc.VideoEncoderFactory
    @Nullable
    public VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo) {
        InterceptResult invokeL;
        VideoCodecType valueOf;
        MediaCodecInfo findCodecForType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, videoCodecInfo)) == null) {
            if (Build.VERSION.SDK_INT >= 19 && (findCodecForType = findCodecForType((valueOf = VideoCodecType.valueOf(videoCodecInfo.name)))) != null) {
                String name = findCodecForType.getName();
                String mimeType = valueOf.mimeType();
                Integer selectColorFormat = MediaCodecUtils.selectColorFormat(MediaCodecUtils.TEXTURE_COLOR_FORMATS, findCodecForType.getCapabilitiesForType(mimeType));
                Integer selectColorFormat2 = MediaCodecUtils.selectColorFormat(MediaCodecUtils.ENCODER_COLOR_FORMATS, findCodecForType.getCapabilitiesForType(mimeType));
                if (valueOf == VideoCodecType.H264) {
                    boolean isSameH264Profile = H264Utils.isSameH264Profile(videoCodecInfo.params, MediaCodecUtils.getCodecProperties(valueOf, true));
                    boolean isSameH264Profile2 = H264Utils.isSameH264Profile(videoCodecInfo.params, MediaCodecUtils.getCodecProperties(valueOf, false));
                    if (!isSameH264Profile && !isSameH264Profile2) {
                        return null;
                    }
                    if (isSameH264Profile && !isH264HighProfileSupported(findCodecForType)) {
                        return null;
                    }
                }
                return new HardwareVideoEncoder(new MediaCodecWrapperFactoryImpl(), name, valueOf, selectColorFormat, selectColorFormat2, videoCodecInfo.params, getKeyFrameIntervalSec(valueOf), getForcedKeyFrameIntervalMs(valueOf, name), createBitrateAdjuster(valueOf, name), this.sharedContext);
            }
            return null;
        }
        return (VideoEncoder) invokeL.objValue;
    }

    @Override // org.webrtc.VideoEncoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (Build.VERSION.SDK_INT < 19) {
                return new VideoCodecInfo[0];
            }
            ArrayList arrayList = new ArrayList();
            VideoCodecType[] videoCodecTypeArr = {VideoCodecType.VP8, VideoCodecType.VP9, VideoCodecType.H264};
            for (int i2 = 0; i2 < 3; i2++) {
                VideoCodecType videoCodecType = videoCodecTypeArr[i2];
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public HardwareVideoEncoderFactory(boolean z, boolean z2) {
        this(null, z, z2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((EglBase.Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }
}
