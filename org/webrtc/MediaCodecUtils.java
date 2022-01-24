package org.webrtc;

import android.media.MediaCodecInfo;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class MediaCodecUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
    public static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar16m4ka = 2141391874;
    public static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar32m4ka = 2141391873;
    public static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar64x32Tile2m8ka = 2141391875;
    public static final int[] DECODER_COLOR_FORMATS;
    public static final int[] ENCODER_COLOR_FORMATS;
    public static final String EXYNOS_PREFIX = "OMX.Exynos.";
    public static final String INTEL_PREFIX = "OMX.Intel.";
    public static final String NVIDIA_PREFIX = "OMX.Nvidia.";
    public static final String QCOM_PREFIX = "OMX.qcom.";
    public static final String[] SOFTWARE_IMPLEMENTATION_PREFIXES;
    public static final String TAG = "MediaCodecUtils";
    public static final int[] TEXTURE_COLOR_FORMATS;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: org.webrtc.MediaCodecUtils$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$webrtc$VideoCodecType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1270003290, "Lorg/webrtc/MediaCodecUtils$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1270003290, "Lorg/webrtc/MediaCodecUtils$1;");
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1208024135, "Lorg/webrtc/MediaCodecUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1208024135, "Lorg/webrtc/MediaCodecUtils;");
                return;
            }
        }
        SOFTWARE_IMPLEMENTATION_PREFIXES = new String[]{"OMX.google.", "OMX.SEC."};
        DECODER_COLOR_FORMATS = new int[]{19, 21, 2141391872, 2141391873, 2141391874, 2141391875, 2141391876};
        ENCODER_COLOR_FORMATS = new int[]{19, 21, 2141391872, 2141391876};
        TEXTURE_COLOR_FORMATS = getTextureColorFormats();
    }

    public MediaCodecUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean codecSupportsType(MediaCodecInfo mediaCodecInfo, VideoCodecType videoCodecType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, mediaCodecInfo, videoCodecType)) == null) {
            for (String str : mediaCodecInfo.getSupportedTypes()) {
                if (videoCodecType.mimeType().equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static Map<String, String> getCodecProperties(VideoCodecType videoCodecType, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, videoCodecType, z)) == null) {
            int i2 = AnonymousClass1.$SwitchMap$org$webrtc$VideoCodecType[videoCodecType.ordinal()];
            if (i2 == 1 || i2 == 2) {
                return new HashMap();
            }
            if (i2 == 3) {
                return H264Utils.getDefaultH264Params(z);
            }
            throw new IllegalArgumentException("Unsupported codec: " + videoCodecType);
        }
        return (Map) invokeLZ.objValue;
    }

    public static int[] getTextureColorFormats() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? Build.VERSION.SDK_INT >= 18 ? new int[]{2130708361} : new int[0] : (int[]) invokeV.objValue;
    }

    @Nullable
    public static Integer selectColorFormat(int[] iArr, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        InterceptResult invokeLL;
        int[] iArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, iArr, codecCapabilities)) == null) {
            for (int i2 : iArr) {
                for (int i3 : codecCapabilities.colorFormats) {
                    if (i3 == i2) {
                        return Integer.valueOf(i3);
                    }
                }
            }
            return null;
        }
        return (Integer) invokeLL.objValue;
    }
}
