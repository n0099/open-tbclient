package org.webrtc;

import android.media.MediaCodecInfo;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class MediaCodecUtils {
    public static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
    public static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar16m4ka = 2141391874;
    public static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar32m4ka = 2141391873;
    public static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar64x32Tile2m8ka = 2141391875;
    public static final String EXYNOS_PREFIX = "OMX.Exynos.";
    public static final String INTEL_PREFIX = "OMX.Intel.";
    public static final String NVIDIA_PREFIX = "OMX.Nvidia.";
    public static final String QCOM_PREFIX = "OMX.qcom.";
    public static final String TAG = "MediaCodecUtils";
    public static final String[] SOFTWARE_IMPLEMENTATION_PREFIXES = {"OMX.google.", "OMX.SEC."};
    public static final int[] DECODER_COLOR_FORMATS = {19, 21, 2141391872, 2141391873, 2141391874, 2141391875, 2141391876};
    public static final int[] ENCODER_COLOR_FORMATS = {19, 21, 2141391872, 2141391876};
    public static final int[] TEXTURE_COLOR_FORMATS = getTextureColorFormats();

    /* renamed from: org.webrtc.MediaCodecUtils$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$webrtc$VideoCodecType;

        static {
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

    public static boolean codecSupportsType(MediaCodecInfo mediaCodecInfo, VideoCodecType videoCodecType) {
        for (String str : mediaCodecInfo.getSupportedTypes()) {
            if (videoCodecType.mimeType().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static Map<String, String> getCodecProperties(VideoCodecType videoCodecType, boolean z) {
        int i2 = AnonymousClass1.$SwitchMap$org$webrtc$VideoCodecType[videoCodecType.ordinal()];
        if (i2 == 1 || i2 == 2) {
            return new HashMap();
        }
        if (i2 == 3) {
            return H264Utils.getDefaultH264Params(z);
        }
        throw new IllegalArgumentException("Unsupported codec: " + videoCodecType);
    }

    public static int[] getTextureColorFormats() {
        return Build.VERSION.SDK_INT >= 18 ? new int[]{2130708361} : new int[0];
    }

    @Nullable
    public static Integer selectColorFormat(int[] iArr, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        int[] iArr2;
        for (int i2 : iArr) {
            for (int i3 : codecCapabilities.colorFormats) {
                if (i3 == i2) {
                    return Integer.valueOf(i3);
                }
            }
        }
        return null;
    }
}
