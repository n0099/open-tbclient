package org.webrtc;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import org.webrtc.EglBase;
import org.webrtc.EglBase14;
/* loaded from: classes8.dex */
public class HardwareVideoEncoderFactory implements VideoEncoderFactory {
    public static final List<String> H264_HW_EXCEPTION_MODELS = Arrays.asList("SAMSUNG-SGH-I337", "Nexus 7", "Nexus 4");
    public static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_L_MS = 15000;
    public static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_M_MS = 20000;
    public static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_N_MS = 15000;
    public static final String TAG = "HardwareVideoEncoderFactory";
    public final boolean enableH264HighProfile;
    public final boolean enableIntelVp8Encoder;
    @Nullable
    public final EglBase14.Context sharedContext;

    /* renamed from: org.webrtc.HardwareVideoEncoderFactory$1  reason: invalid class name */
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

    public HardwareVideoEncoderFactory(EglBase.Context context, boolean z, boolean z2) {
        EglBase14.Context context2;
        if (context instanceof EglBase14.Context) {
            context2 = (EglBase14.Context) context;
        } else {
            Logging.w(TAG, "No shared EglBase.Context.  Encoders will not use texture mode.");
            context2 = null;
        }
        this.sharedContext = context2;
        this.enableIntelVp8Encoder = z;
        this.enableH264HighProfile = z2;
    }

    @Deprecated
    public HardwareVideoEncoderFactory(boolean z, boolean z2) {
        this(null, z, z2);
    }

    private BitrateAdjuster createBitrateAdjuster(VideoCodecType videoCodecType, String str) {
        return str.startsWith("OMX.Exynos.") ? videoCodecType == VideoCodecType.VP8 ? new DynamicBitrateAdjuster() : new FramerateBitrateAdjuster() : new BaseBitrateAdjuster();
    }

    @Nullable
    private MediaCodecInfo findCodecForType(VideoCodecType videoCodecType) {
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

    private int getKeyFrameIntervalSec(VideoCodecType videoCodecType) {
        int i2 = AnonymousClass1.$SwitchMap$org$webrtc$VideoCodecType[videoCodecType.ordinal()];
        if (i2 == 1 || i2 == 2) {
            return 100;
        }
        if (i2 == 3) {
            return 20;
        }
        throw new IllegalArgumentException("Unsupported VideoCodecType " + videoCodecType);
    }

    private boolean isH264HighProfileSupported(MediaCodecInfo mediaCodecInfo) {
        return this.enableH264HighProfile && Build.VERSION.SDK_INT > 23 && mediaCodecInfo.getName().startsWith("OMX.Exynos.");
    }

    private boolean isHardwareSupportedInCurrentSdk(MediaCodecInfo mediaCodecInfo, VideoCodecType videoCodecType) {
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

    private boolean isHardwareSupportedInCurrentSdkH264(MediaCodecInfo mediaCodecInfo) {
        if (H264_HW_EXCEPTION_MODELS.contains(Build.MODEL)) {
            return false;
        }
        String name = mediaCodecInfo.getName();
        return (name.startsWith("OMX.qcom.") && Build.VERSION.SDK_INT >= 19) || (name.startsWith("OMX.Exynos.") && Build.VERSION.SDK_INT >= 21);
    }

    private boolean isHardwareSupportedInCurrentSdkVp8(MediaCodecInfo mediaCodecInfo) {
        String name = mediaCodecInfo.getName();
        return (name.startsWith("OMX.qcom.") && Build.VERSION.SDK_INT >= 19) || (name.startsWith("OMX.Exynos.") && Build.VERSION.SDK_INT >= 23) || (name.startsWith(MediaCodecUtils.INTEL_PREFIX) && Build.VERSION.SDK_INT >= 21 && this.enableIntelVp8Encoder);
    }

    private boolean isHardwareSupportedInCurrentSdkVp9(MediaCodecInfo mediaCodecInfo) {
        String name = mediaCodecInfo.getName();
        return (name.startsWith("OMX.qcom.") || name.startsWith("OMX.Exynos.")) && Build.VERSION.SDK_INT >= 24;
    }

    private boolean isSupportedCodec(MediaCodecInfo mediaCodecInfo, VideoCodecType videoCodecType) {
        if (MediaCodecUtils.codecSupportsType(mediaCodecInfo, videoCodecType) && MediaCodecUtils.selectColorFormat(MediaCodecUtils.ENCODER_COLOR_FORMATS, mediaCodecInfo.getCapabilitiesForType(videoCodecType.mimeType())) != null) {
            return isHardwareSupportedInCurrentSdk(mediaCodecInfo, videoCodecType);
        }
        return false;
    }

    @Override // org.webrtc.VideoEncoderFactory
    @Nullable
    public VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo) {
        VideoCodecType valueOf;
        MediaCodecInfo findCodecForType;
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

    @Override // org.webrtc.VideoEncoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
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
}
