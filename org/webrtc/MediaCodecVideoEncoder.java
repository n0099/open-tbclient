package org.webrtc;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.live.tbadk.core.data.ConstantData;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.webrtc.EglBase;
import org.webrtc.EglBase14;
import org.webrtc.VideoFrame;
@TargetApi(19)
@Deprecated
/* loaded from: classes16.dex */
public class MediaCodecVideoEncoder {
    private static final int BITRATE_ADJUSTMENT_FPS = 30;
    private static final double BITRATE_CORRECTION_MAX_SCALE = 4.0d;
    private static final double BITRATE_CORRECTION_SEC = 3.0d;
    private static final int BITRATE_CORRECTION_STEPS = 20;
    private static final int DEQUEUE_TIMEOUT = 0;
    private static final String H264_MIME_TYPE = "video/avc";
    private static final int MAXIMUM_INITIAL_FPS = 30;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final long QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_L_MS = 15000;
    private static final long QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_M_MS = 20000;
    private static final long QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_N_MS = 15000;
    private static final String TAG = "MediaCodecVideoEncoder";
    private static final int VIDEO_AVCLevel3 = 256;
    private static final int VIDEO_AVCProfileHigh = 8;
    private static final int VIDEO_ControlRateConstant = 2;
    private static final int VIDEO_ControlRateDisable = 0;
    private static final int VIDEO_ControlRateVariable = 1;
    private static int VIDEO_HEIGHT = 0;
    private static int VIDEO_WIDTH = 0;
    private static final String VP8_MIME_TYPE = "video/x-vnd.on2.vp8";
    private static final String VP9_MIME_TYPE = "video/x-vnd.on2.vp9";
    private static int bitrateMode = 2;
    private static int codecErrors;
    @Nullable
    private static MediaCodecVideoEncoderErrorCallback errorCallback;
    @Nullable
    private static MediaCodecVideoEncoder runningInstance;
    @Nullable
    private static EglBase staticEglBase;
    private double bitrateAccumulator;
    private double bitrateAccumulatorMax;
    private int bitrateAdjustmentScaleExp;
    private double bitrateObservationTimeMs;
    private int colorFormat;
    @Nullable
    private ByteBuffer configData;
    @Nullable
    private GlRectDrawer drawer;
    @Nullable
    private EglBase14 eglBase;
    private long forcedKeyFrameMs;
    private int height;
    @Nullable
    private Surface inputSurface;
    private long lastKeyFrameMs;
    @Nullable
    private MediaCodec mediaCodec;
    @Nullable
    private Thread mediaCodecThread;
    private ByteBuffer[] outputBuffers;
    private int profile;
    private int targetBitrateBps;
    private int targetFps;
    private VideoCodecType type;
    private int width;
    private static Set<String> hwEncoderDisabledTypes = new HashSet();
    private static final MediaCodecProperties qcomVp8HwProperties = new MediaCodecProperties("OMX.qcom.", 19, BitrateAdjustmentType.NO_ADJUSTMENT);
    private static final MediaCodecProperties exynosVp8HwProperties = new MediaCodecProperties("OMX.Exynos.", 23, BitrateAdjustmentType.DYNAMIC_ADJUSTMENT);
    private static final MediaCodecProperties intelVp8HwProperties = new MediaCodecProperties("OMX.Intel.", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
    private static final MediaCodecProperties qcomVp9HwProperties = new MediaCodecProperties("OMX.qcom.", 24, BitrateAdjustmentType.NO_ADJUSTMENT);
    private static final MediaCodecProperties exynosVp9HwProperties = new MediaCodecProperties("OMX.Exynos.", 24, BitrateAdjustmentType.FRAMERATE_ADJUSTMENT);
    private static final MediaCodecProperties[] vp9HwList = {qcomVp9HwProperties, exynosVp9HwProperties};
    private static final MediaCodecProperties qcomH264HwProperties = new MediaCodecProperties("OMX.qcom.", 19, BitrateAdjustmentType.NO_ADJUSTMENT);
    private static final MediaCodecProperties exynosH264HwProperties = new MediaCodecProperties("OMX.Exynos.", 21, BitrateAdjustmentType.FRAMERATE_ADJUSTMENT);
    private static final MediaCodecProperties FreescaH264HwProperties = new MediaCodecProperties("OMX.Freesca", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
    private static final MediaCodecProperties hisiH264HwProperties = new MediaCodecProperties("OMX.hisi.", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
    private static final MediaCodecProperties myMTKH264HwProperties = new MediaCodecProperties("OMX.MTK.", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
    private static final MediaCodecProperties RockchipH264HwProperties = new MediaCodecProperties("OMX.rk.", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
    private static final MediaCodecProperties AllwinnerH264HwProperties = new MediaCodecProperties("OMX.allwinner.", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
    private static final MediaCodecProperties NvidiaH264HwProperties = new MediaCodecProperties("OMX.Nvidia.", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
    private static final MediaCodecProperties huaweiIMGH264HwProperties = new MediaCodecProperties("OMX.IMG.", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
    private static final MediaCodecProperties googH264HwProperties = new MediaCodecProperties("OMX.google.", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
    private static final MediaCodecProperties sprdH264HwProperties = new MediaCodecProperties("OMX.sprd.", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
    private static final MediaCodecProperties amlogicH264HwProperties = new MediaCodecProperties("OMX.amlogic.", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
    private static final MediaCodecProperties exynosH264HighProfileHwProperties = new MediaCodecProperties("OMX.Exynos.", 23, BitrateAdjustmentType.FRAMERATE_ADJUSTMENT);
    private static final MediaCodecProperties[] h264HighProfileHwList = {exynosH264HighProfileHwProperties};
    private static final String[] H264_HW_EXCEPTION_MODELS = {"SAMSUNG-SGH-I337", "Nexus 7", "Nexus 4"};
    private static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
    private static final int[] supportedColorList = {19, 21, 2141391872, COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m};
    private static final int[] supportedSurfaceColorList = {2130708361};
    private String bitrateModePreset = PeerConnectionFactory.fieldTrialsFindFullName("BRTC-Encoder-BitrateMode");
    private BitrateAdjustmentType bitrateAdjustmentType = BitrateAdjustmentType.NO_ADJUSTMENT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.webrtc.MediaCodecVideoEncoder$1CaughtException  reason: invalid class name */
    /* loaded from: classes16.dex */
    public class C1CaughtException {
        Exception e;

        C1CaughtException() {
        }
    }

    /* loaded from: classes16.dex */
    public enum BitrateAdjustmentType {
        NO_ADJUSTMENT,
        FRAMERATE_ADJUSTMENT,
        DYNAMIC_ADJUSTMENT
    }

    /* loaded from: classes16.dex */
    public static class EncoderProperties {
        public final BitrateAdjustmentType bitrateAdjustmentType;
        public final String codecName;
        public final int colorFormat;

        public EncoderProperties(String str, int i, BitrateAdjustmentType bitrateAdjustmentType) {
            this.codecName = str;
            this.colorFormat = i;
            this.bitrateAdjustmentType = bitrateAdjustmentType;
        }
    }

    /* loaded from: classes16.dex */
    public enum H264Profile {
        CONSTRAINED_BASELINE(0),
        BASELINE(1),
        MAIN(2),
        CONSTRAINED_HIGH(3),
        HIGH(4);
        
        private final int value;

        H264Profile(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class HwEncoderFactory implements VideoEncoderFactory {
        private final VideoCodecInfo[] supportedHardwareCodecs = getSupportedHardwareCodecs();

        HwEncoderFactory() {
        }

        private static VideoCodecInfo[] getSupportedHardwareCodecs() {
            ArrayList arrayList = new ArrayList();
            if (MediaCodecVideoEncoder.isVp8HwSupported()) {
                Logging.d(MediaCodecVideoEncoder.TAG, "VP8 HW Encoder supported.");
                arrayList.add(new VideoCodecInfo("VP8", new HashMap()));
            }
            if (MediaCodecVideoEncoder.isVp9HwSupported()) {
                Logging.d(MediaCodecVideoEncoder.TAG, "VP9 HW Encoder supported.");
                arrayList.add(new VideoCodecInfo("VP9", new HashMap()));
            }
            if (MediaCodecVideoDecoder.isH264HighProfileHwSupported()) {
                Logging.d(MediaCodecVideoEncoder.TAG, "H.264 High Profile HW Encoder supported.");
                arrayList.add(H264Utils.DEFAULT_H264_HIGH_PROFILE_CODEC);
            }
            if (MediaCodecVideoEncoder.isH264HwSupported()) {
                Logging.d(MediaCodecVideoEncoder.TAG, "H.264 HW Encoder supported.");
                arrayList.add(H264Utils.DEFAULT_H264_BASELINE_PROFILE_CODEC);
            }
            return (VideoCodecInfo[]) arrayList.toArray(new VideoCodecInfo[arrayList.size()]);
        }

        private static boolean isCodecSupported(VideoCodecInfo[] videoCodecInfoArr, VideoCodecInfo videoCodecInfo) {
            for (VideoCodecInfo videoCodecInfo2 : videoCodecInfoArr) {
                if (isSameCodec(videoCodecInfo2, videoCodecInfo)) {
                    return true;
                }
            }
            return false;
        }

        private static boolean isSameCodec(VideoCodecInfo videoCodecInfo, VideoCodecInfo videoCodecInfo2) {
            if (videoCodecInfo.name.equalsIgnoreCase(videoCodecInfo2.name)) {
                if (videoCodecInfo.name.equalsIgnoreCase("H264")) {
                    return H264Utils.isSameH264Profile(videoCodecInfo.params, videoCodecInfo2.params);
                }
                return true;
            }
            return false;
        }

        @Override // org.webrtc.VideoEncoderFactory
        @Nullable
        public VideoEncoder createEncoder(final VideoCodecInfo videoCodecInfo) {
            if (isCodecSupported(this.supportedHardwareCodecs, videoCodecInfo)) {
                Logging.d(MediaCodecVideoEncoder.TAG, "Create HW video encoder for " + videoCodecInfo.name);
                return new WrappedNativeVideoEncoder() { // from class: org.webrtc.MediaCodecVideoEncoder.HwEncoderFactory.1
                    @Override // org.webrtc.WrappedNativeVideoEncoder, org.webrtc.VideoEncoder
                    public long createNativeVideoEncoder() {
                        return MediaCodecVideoEncoder.nativeCreateEncoder(videoCodecInfo, MediaCodecVideoEncoder.staticEglBase instanceof EglBase14);
                    }

                    @Override // org.webrtc.WrappedNativeVideoEncoder, org.webrtc.VideoEncoder
                    public boolean isHardwareEncoder() {
                        return true;
                    }
                };
            }
            Logging.d(MediaCodecVideoEncoder.TAG, "No HW video encoder for codec " + videoCodecInfo.name);
            return null;
        }

        @Override // org.webrtc.VideoEncoderFactory
        public VideoCodecInfo[] getSupportedCodecs() {
            return this.supportedHardwareCodecs;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class MediaCodecProperties {
        public final BitrateAdjustmentType bitrateAdjustmentType;
        public final String codecPrefix;
        public final int minSdk;

        MediaCodecProperties(String str, int i, BitrateAdjustmentType bitrateAdjustmentType) {
            this.codecPrefix = str;
            this.minSdk = i;
            this.bitrateAdjustmentType = bitrateAdjustmentType;
        }
    }

    /* loaded from: classes16.dex */
    public interface MediaCodecVideoEncoderErrorCallback {
        void onMediaCodecVideoEncoderCriticalError(int i);
    }

    /* loaded from: classes16.dex */
    static class OutputBufferInfo {
        public final ByteBuffer buffer;
        public final int index;
        public final boolean isKeyFrame;
        public final long presentationTimestampUs;

        public OutputBufferInfo(int i, ByteBuffer byteBuffer, boolean z, long j) {
            this.index = i;
            this.buffer = byteBuffer;
            this.isKeyFrame = z;
            this.presentationTimestampUs = j;
        }

        @CalledByNative("OutputBufferInfo")
        ByteBuffer getBuffer() {
            return this.buffer;
        }

        @CalledByNative("OutputBufferInfo")
        int getIndex() {
            return this.index;
        }

        @CalledByNative("OutputBufferInfo")
        long getPresentationTimestampUs() {
            return this.presentationTimestampUs;
        }

        @CalledByNative("OutputBufferInfo")
        boolean isKeyFrame() {
            return this.isKeyFrame;
        }
    }

    /* loaded from: classes16.dex */
    public enum VideoCodecType {
        VIDEO_CODEC_UNKNOWN,
        VIDEO_CODEC_VP8,
        VIDEO_CODEC_VP9,
        VIDEO_CODEC_H264;

        @CalledByNative("VideoCodecType")
        static VideoCodecType fromNativeIndex(int i) {
            return values()[i];
        }
    }

    @CalledByNative
    MediaCodecVideoEncoder() {
    }

    private void checkOnMediaCodecThread() {
        if (this.mediaCodecThread.getId() != Thread.currentThread().getId()) {
            throw new RuntimeException("MediaCodecVideoEncoder previously operated on " + this.mediaCodecThread + " but is now called on " + Thread.currentThread());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static MediaCodec createByCodecName(String str) {
        try {
            return MediaCodec.createByCodecName(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static VideoEncoderFactory createFactory() {
        return new DefaultVideoEncoderFactory(new HwEncoderFactory());
    }

    public static void disableH264HwCodec() {
        Logging.w(TAG, "H.264 encoding is disabled by application.");
        hwEncoderDisabledTypes.add("video/avc");
    }

    public static void disableVp8HwCodec() {
        Logging.w(TAG, "VP8 encoding is disabled by application.");
        hwEncoderDisabledTypes.add(VP8_MIME_TYPE);
    }

    public static void disableVp9HwCodec() {
        Logging.w(TAG, "VP9 encoding is disabled by application.");
        hwEncoderDisabledTypes.add(VP9_MIME_TYPE);
    }

    public static void disposeEglContext() {
        if (staticEglBase != null) {
            staticEglBase.release();
            staticEglBase = null;
        }
    }

    @Nullable
    private static EncoderProperties findHwEncoder(String str, MediaCodecProperties[] mediaCodecPropertiesArr, int[] iArr, int i, int i2) {
        MediaCodecInfo mediaCodecInfo;
        String str2;
        BitrateAdjustmentType bitrateAdjustmentType;
        boolean z;
        int[] iArr2;
        int[] iArr3;
        if (Build.VERSION.SDK_INT < 19) {
            return null;
        }
        if (str.equals("video/avc") && Arrays.asList(H264_HW_EXCEPTION_MODELS).contains(Build.MODEL)) {
            Logging.w(TAG, "Model: " + Build.MODEL + " has black listed H.264 encoder.");
            return null;
        }
        for (int i3 = 0; i3 < MediaCodecList.getCodecCount(); i3++) {
            try {
                mediaCodecInfo = MediaCodecList.getCodecInfoAt(i3);
            } catch (IllegalArgumentException e) {
                Logging.e(TAG, "Cannot retrieve encoder codec info", e);
                mediaCodecInfo = null;
            }
            if (mediaCodecInfo != null && mediaCodecInfo.isEncoder()) {
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                int length = supportedTypes.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        break;
                    } else if (supportedTypes[i4].equals(str)) {
                        String name = mediaCodecInfo.getName();
                        if (i * i2 >= 25364 || !name.startsWith("OMX.hisi.")) {
                            str2 = name;
                        }
                    } else {
                        i4++;
                    }
                }
                str2 = null;
                if (str2 != null) {
                    Logging.v(TAG, "Found candidate encoder " + str2);
                    BitrateAdjustmentType bitrateAdjustmentType2 = BitrateAdjustmentType.NO_ADJUSTMENT;
                    int length2 = mediaCodecPropertiesArr.length;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length2) {
                            bitrateAdjustmentType = bitrateAdjustmentType2;
                            z = false;
                            break;
                        }
                        MediaCodecProperties mediaCodecProperties = mediaCodecPropertiesArr[i5];
                        if (str2.startsWith(mediaCodecProperties.codecPrefix)) {
                            if (Build.VERSION.SDK_INT < mediaCodecProperties.minSdk) {
                                Logging.w(TAG, "Codec " + str2 + " is disabled due to SDK version " + Build.VERSION.SDK_INT);
                            } else {
                                if (mediaCodecProperties.bitrateAdjustmentType != BitrateAdjustmentType.NO_ADJUSTMENT) {
                                    bitrateAdjustmentType2 = mediaCodecProperties.bitrateAdjustmentType;
                                    Logging.w(TAG, "Codec " + str2 + " requires bitrate adjustment: " + bitrateAdjustmentType2);
                                }
                                bitrateAdjustmentType = bitrateAdjustmentType2;
                                z = true;
                            }
                        }
                        i5++;
                    }
                    if (z) {
                        try {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                            for (int i6 : capabilitiesForType.colorFormats) {
                                Logging.v(TAG, "   Color: 0x" + Integer.toHexString(i6));
                            }
                            for (int i7 : iArr) {
                                for (int i8 : capabilitiesForType.colorFormats) {
                                    if (i8 == i7) {
                                        Logging.d(TAG, "Found target encoder for mime " + str + " : " + str2 + ". Color: 0x" + Integer.toHexString(i8) + ". Bitrate adjustment: " + bitrateAdjustmentType);
                                        return new EncoderProperties(str2, i8, bitrateAdjustmentType);
                                    }
                                }
                            }
                            continue;
                        } catch (IllegalArgumentException e2) {
                            Logging.e(TAG, "Cannot retrieve encoder capabilities", e2);
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    private double getBitrateScale(int i) {
        return Math.pow(BITRATE_CORRECTION_MAX_SCALE, i / 20.0d);
    }

    @Nullable
    static EglBase.Context getEglContext() {
        if (staticEglBase == null) {
            return null;
        }
        return staticEglBase.getEglBaseContext();
    }

    private static final MediaCodecProperties[] h264HwList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(qcomH264HwProperties);
        arrayList.add(exynosH264HwProperties);
        arrayList.add(FreescaH264HwProperties);
        arrayList.add(myMTKH264HwProperties);
        arrayList.add(RockchipH264HwProperties);
        arrayList.add(AllwinnerH264HwProperties);
        arrayList.add(NvidiaH264HwProperties);
        arrayList.add(huaweiIMGH264HwProperties);
        arrayList.add(googH264HwProperties);
        arrayList.add(amlogicH264HwProperties);
        arrayList.add(sprdH264HwProperties);
        PeerConnectionFactory.fieldTrialsFindFullName("WebRTC-MediaTekH264").equals(PeerConnectionFactory.TRIAL_ENABLED);
        return (MediaCodecProperties[]) arrayList.toArray(new MediaCodecProperties[arrayList.size()]);
    }

    public static boolean isH264HighProfileHwSupported() {
        return (hwEncoderDisabledTypes.contains("video/avc") || findHwEncoder("video/avc", h264HighProfileHwList, supportedColorList, 0, 0) == null) ? false : true;
    }

    public static boolean isH264HwSupported() {
        return (hwEncoderDisabledTypes.contains("video/avc") || findHwEncoder("video/avc", h264HwList(), supportedColorList, 0, 0) == null) ? false : true;
    }

    public static boolean isH264HwSupportedUsingTextures() {
        return (hwEncoderDisabledTypes.contains("video/avc") || findHwEncoder("video/avc", h264HwList(), supportedSurfaceColorList, 0, 0) == null) ? false : true;
    }

    @CalledByNative
    static boolean isTextureBuffer(VideoFrame.Buffer buffer) {
        return buffer instanceof VideoFrame.TextureBuffer;
    }

    public static boolean isVp8HwSupported() {
        return (hwEncoderDisabledTypes.contains(VP8_MIME_TYPE) || findHwEncoder(VP8_MIME_TYPE, vp8HwList(), supportedColorList, 0, 0) == null) ? false : true;
    }

    public static boolean isVp8HwSupportedUsingTextures() {
        return (hwEncoderDisabledTypes.contains(VP8_MIME_TYPE) || findHwEncoder(VP8_MIME_TYPE, vp8HwList(), supportedSurfaceColorList, 0, 0) == null) ? false : true;
    }

    public static boolean isVp9HwSupported() {
        return (hwEncoderDisabledTypes.contains(VP9_MIME_TYPE) || findHwEncoder(VP9_MIME_TYPE, vp9HwList, supportedColorList, 0, 0) == null) ? false : true;
    }

    public static boolean isVp9HwSupportedUsingTextures() {
        return (hwEncoderDisabledTypes.contains(VP9_MIME_TYPE) || findHwEncoder(VP9_MIME_TYPE, vp9HwList, supportedSurfaceColorList, 0, 0) == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeCreateEncoder(VideoCodecInfo videoCodecInfo, boolean z);

    private static native void nativeFillInputBuffer(long j, int i, ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, ByteBuffer byteBuffer3, int i4);

    public static void printStackTrace() {
        if (runningInstance == null || runningInstance.mediaCodecThread == null) {
            return;
        }
        StackTraceElement[] stackTrace = runningInstance.mediaCodecThread.getStackTrace();
        if (stackTrace.length > 0) {
            Logging.d(TAG, "MediaCodecVideoEncoder stacks trace:");
            for (StackTraceElement stackTraceElement : stackTrace) {
                Logging.d(TAG, stackTraceElement.toString());
            }
        }
    }

    private void reportEncodedFrame(int i) {
        if (this.targetFps == 0 || this.bitrateAdjustmentType != BitrateAdjustmentType.DYNAMIC_ADJUSTMENT) {
            return;
        }
        this.bitrateAccumulator = (i - (this.targetBitrateBps / (this.targetFps * 8.0d))) + this.bitrateAccumulator;
        this.bitrateObservationTimeMs += 1000.0d / this.targetFps;
        double d = this.bitrateAccumulatorMax * BITRATE_CORRECTION_SEC;
        this.bitrateAccumulator = Math.min(this.bitrateAccumulator, d);
        this.bitrateAccumulator = Math.max(this.bitrateAccumulator, -d);
        if (this.bitrateObservationTimeMs > 3000.0d) {
            Logging.d(TAG, "Acc: " + ((int) this.bitrateAccumulator) + ". Max: " + ((int) this.bitrateAccumulatorMax) + ". ExpScale: " + this.bitrateAdjustmentScaleExp);
            boolean z = true;
            if (this.bitrateAccumulator > this.bitrateAccumulatorMax) {
                this.bitrateAdjustmentScaleExp -= (int) ((this.bitrateAccumulator / this.bitrateAccumulatorMax) + 0.5d);
                this.bitrateAccumulator = this.bitrateAccumulatorMax;
            } else if (this.bitrateAccumulator < (-this.bitrateAccumulatorMax)) {
                this.bitrateAdjustmentScaleExp = ((int) (((-this.bitrateAccumulator) / this.bitrateAccumulatorMax) + 0.5d)) + this.bitrateAdjustmentScaleExp;
                this.bitrateAccumulator = -this.bitrateAccumulatorMax;
            } else {
                z = false;
            }
            if (z) {
                this.bitrateAdjustmentScaleExp = Math.min(this.bitrateAdjustmentScaleExp, 20);
                this.bitrateAdjustmentScaleExp = Math.max(this.bitrateAdjustmentScaleExp, -20);
                Logging.d(TAG, "Adjusting bitrate scale to " + this.bitrateAdjustmentScaleExp + ". Value: " + getBitrateScale(this.bitrateAdjustmentScaleExp));
                setRates(this.targetBitrateBps / 1000, this.targetFps);
            }
            this.bitrateObservationTimeMs = 0.0d;
        }
    }

    public static void setEglContext(EglBase.Context context) {
        if (staticEglBase != null) {
            Logging.w(TAG, "Egl context already set.");
            staticEglBase.release();
        }
        staticEglBase = EglBase_CC.create(context);
    }

    public static void setErrorCallback(MediaCodecVideoEncoderErrorCallback mediaCodecVideoEncoderErrorCallback) {
        Logging.d(TAG, "Set error callback");
        errorCallback = mediaCodecVideoEncoderErrorCallback;
    }

    @CalledByNativeUnchecked
    private boolean setRates(int i, int i2) {
        checkOnMediaCodecThread();
        int i3 = i * 1000;
        if (this.bitrateAdjustmentType == BitrateAdjustmentType.DYNAMIC_ADJUSTMENT) {
            double d = i3;
            this.bitrateAccumulatorMax = d / 8.0d;
            if (this.targetBitrateBps > 0 && i3 < this.targetBitrateBps) {
                this.bitrateAccumulator = (d * this.bitrateAccumulator) / this.targetBitrateBps;
            }
        }
        this.targetBitrateBps = i3;
        this.targetFps = i2;
        if (this.bitrateAdjustmentType == BitrateAdjustmentType.FRAMERATE_ADJUSTMENT && this.targetFps > 0) {
            i3 = (this.targetBitrateBps * 30) / this.targetFps;
            Logging.v(TAG, "setRates: " + i + " -> " + (i3 / 1000) + " kbps. Fps: " + this.targetFps);
        } else if (this.bitrateAdjustmentType == BitrateAdjustmentType.DYNAMIC_ADJUSTMENT) {
            Logging.v(TAG, "setRates: " + i + " kbps. Fps: " + this.targetFps + ". ExpScale: " + this.bitrateAdjustmentScaleExp);
            if (this.bitrateAdjustmentScaleExp != 0) {
                i3 = (int) (i3 * getBitrateScale(this.bitrateAdjustmentScaleExp));
            }
        } else {
            Logging.v(TAG, "setRates: " + i + " kbps. Fps: " + this.targetFps);
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("video-bitrate", i3);
            this.mediaCodec.setParameters(bundle);
            return true;
        } catch (IllegalStateException e) {
            Logging.e(TAG, "setRates failed", e);
            return false;
        }
    }

    @Nullable
    public static EncoderProperties vp8HwEncoderProperties() {
        if (hwEncoderDisabledTypes.contains(VP8_MIME_TYPE)) {
            return null;
        }
        return findHwEncoder(VP8_MIME_TYPE, vp8HwList(), supportedColorList, 0, 0);
    }

    private static MediaCodecProperties[] vp8HwList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(qcomVp8HwProperties);
        arrayList.add(exynosVp8HwProperties);
        if (PeerConnectionFactory.fieldTrialsFindFullName("WebRTC-IntelVP8").equals(PeerConnectionFactory.TRIAL_ENABLED)) {
            arrayList.add(intelVp8HwProperties);
        }
        return (MediaCodecProperties[]) arrayList.toArray(new MediaCodecProperties[arrayList.size()]);
    }

    void checkKeyFrameRequired(boolean z, long j) {
        long j2 = (500 + j) / 1000;
        if (this.lastKeyFrameMs < 0) {
            this.lastKeyFrameMs = j2;
        }
        boolean z2 = !z && this.forcedKeyFrameMs > 0 && j2 > this.lastKeyFrameMs + this.forcedKeyFrameMs;
        if (z || z2) {
            if (z) {
                Logging.d(TAG, "Sync frame request");
            } else {
                Logging.d(TAG, "Sync frame forced");
            }
            Bundle bundle = new Bundle();
            bundle.putInt("request-sync", 0);
            this.mediaCodec.setParameters(bundle);
            this.lastKeyFrameMs = j2;
        }
    }

    @CalledByNativeUnchecked
    int dequeueInputBuffer() {
        checkOnMediaCodecThread();
        try {
            return this.mediaCodec.dequeueInputBuffer(0L);
        } catch (IllegalStateException e) {
            Logging.e(TAG, "dequeueIntputBuffer failed", e);
            return -2;
        }
    }

    @CalledByNativeUnchecked
    @Nullable
    OutputBufferInfo dequeueOutputBuffer() {
        checkOnMediaCodecThread();
        try {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
            if (dequeueOutputBuffer >= 0) {
                if ((bufferInfo.flags & 2) != 0) {
                    Logging.d(TAG, "Config frame generated. Offset: " + bufferInfo.offset + ". Size: " + bufferInfo.size);
                    this.configData = ByteBuffer.allocateDirect(bufferInfo.size);
                    this.outputBuffers[dequeueOutputBuffer].position(bufferInfo.offset);
                    this.outputBuffers[dequeueOutputBuffer].limit(bufferInfo.offset + bufferInfo.size);
                    this.configData.put(this.outputBuffers[dequeueOutputBuffer]);
                    String str = "";
                    int i = 0;
                    while (true) {
                        if (i >= (bufferInfo.size < 8 ? bufferInfo.size : 8)) {
                            break;
                        }
                        i++;
                        str = str + Integer.toHexString(this.configData.get(i) & 255) + " ";
                    }
                    Logging.d(TAG, str);
                    this.mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                    dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
                }
            }
            if (dequeueOutputBuffer < 0) {
                if (dequeueOutputBuffer == -3) {
                    this.outputBuffers = this.mediaCodec.getOutputBuffers();
                    return dequeueOutputBuffer();
                } else if (dequeueOutputBuffer == -2) {
                    return dequeueOutputBuffer();
                } else {
                    if (dequeueOutputBuffer == -1) {
                        return null;
                    }
                    throw new RuntimeException("dequeueOutputBuffer: " + dequeueOutputBuffer);
                }
            }
            ByteBuffer duplicate = this.outputBuffers[dequeueOutputBuffer].duplicate();
            duplicate.position(bufferInfo.offset);
            duplicate.limit(bufferInfo.offset + bufferInfo.size);
            reportEncodedFrame(bufferInfo.size);
            boolean z = (bufferInfo.flags & 1) != 0;
            if (z) {
                Logging.d(TAG, "Sync frame generated");
            }
            if (z && this.type == VideoCodecType.VIDEO_CODEC_H264) {
                Logging.d(TAG, "Appending config frame of size " + this.configData.capacity() + " to output buffer with offset " + bufferInfo.offset + ", size " + bufferInfo.size);
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.configData.capacity() + bufferInfo.size);
                this.configData.rewind();
                allocateDirect.put(this.configData);
                allocateDirect.put(duplicate);
                allocateDirect.position(0);
                return new OutputBufferInfo(dequeueOutputBuffer, allocateDirect, z, bufferInfo.presentationTimeUs);
            }
            return new OutputBufferInfo(dequeueOutputBuffer, duplicate.slice(), z, bufferInfo.presentationTimeUs);
        } catch (IllegalStateException e) {
            Logging.e(TAG, "dequeueOutputBuffer failed", e);
            return new OutputBufferInfo(-1, null, false, -1L);
        }
    }

    @CalledByNativeUnchecked
    boolean encodeBuffer(boolean z, int i, int i2, long j) {
        checkOnMediaCodecThread();
        try {
            checkKeyFrameRequired(z, j);
            this.mediaCodec.queueInputBuffer(i, 0, i2, j, 0);
            return true;
        } catch (IllegalStateException e) {
            Logging.e(TAG, "encodeBuffer failed", e);
            return false;
        }
    }

    @CalledByNativeUnchecked
    boolean encodeFrame(long j, boolean z, VideoFrame videoFrame, int i, long j2) {
        checkOnMediaCodecThread();
        try {
            checkKeyFrameRequired(z, j2);
            VideoFrame.Buffer buffer = videoFrame.getBuffer();
            if (buffer instanceof VideoFrame.TextureBuffer) {
                this.eglBase.makeCurrent();
                GLES20.glClear(16384);
                VideoFrameDrawer.drawTexture(this.drawer, (VideoFrame.TextureBuffer) buffer, new Matrix(), this.width, this.height, 0, 0, this.width, this.height);
                this.eglBase.swapBuffers(TimeUnit.MICROSECONDS.toNanos(j2));
            } else {
                VideoFrame.I420Buffer i420 = buffer.toI420();
                int i2 = (this.height + 1) / 2;
                ByteBuffer dataY = i420.getDataY();
                ByteBuffer dataU = i420.getDataU();
                ByteBuffer dataV = i420.getDataV();
                int strideY = i420.getStrideY();
                int strideU = i420.getStrideU();
                int strideV = i420.getStrideV();
                if (dataY.capacity() < this.height * strideY) {
                    throw new RuntimeException("Y-plane buffer size too small.");
                }
                if (dataU.capacity() < strideU * i2) {
                    throw new RuntimeException("U-plane buffer size too small.");
                }
                if (dataV.capacity() < i2 * strideV) {
                    throw new RuntimeException("V-plane buffer size too small.");
                }
                nativeFillInputBuffer(j, i, dataY, strideY, dataU, strideU, dataV, strideV);
                i420.release();
                this.mediaCodec.queueInputBuffer(i, 0, ((this.width * this.height) * 3) / 2, j2, 0);
            }
            return true;
        } catch (RuntimeException e) {
            Logging.e(TAG, "encodeFrame failed", e);
            return false;
        }
    }

    @CalledByNative
    int getColorFormat() {
        return this.colorFormat;
    }

    @CalledByNativeUnchecked
    ByteBuffer[] getInputBuffers() {
        ByteBuffer[] inputBuffers = this.mediaCodec.getInputBuffers();
        Logging.d(TAG, "Input buffers: " + inputBuffers.length);
        return inputBuffers;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x012a  */
    @CalledByNativeUnchecked
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean initEncode(VideoCodecType videoCodecType, int i, int i2, int i3, int i4, int i5, boolean z) {
        boolean z2;
        EncoderProperties encoderProperties;
        String str;
        boolean z3;
        EncoderProperties findHwEncoder;
        String str2;
        int parseInt;
        Logging.d(TAG, "Java initEncode: " + videoCodecType + ". Profile: " + i + " : " + i2 + " x " + i3 + ". @ " + i4 + " kbps. Fps: " + i5 + ". Encode from texture : " + z);
        VIDEO_WIDTH = i2;
        VIDEO_HEIGHT = i3;
        this.profile = i;
        this.width = i2;
        this.height = i3;
        if (this.mediaCodecThread != null) {
            throw new RuntimeException("Forgot to release()?");
        }
        int i6 = 100;
        if (videoCodecType == VideoCodecType.VIDEO_CODEC_VP8) {
            findHwEncoder = findHwEncoder(VP8_MIME_TYPE, vp8HwList(), z ? supportedSurfaceColorList : supportedColorList, i2, i3);
            str2 = VP8_MIME_TYPE;
        } else if (videoCodecType == VideoCodecType.VIDEO_CODEC_VP9) {
            findHwEncoder = findHwEncoder(VP9_MIME_TYPE, vp9HwList, z ? supportedSurfaceColorList : supportedColorList, i2, i3);
            str2 = VP9_MIME_TYPE;
        } else if (videoCodecType != VideoCodecType.VIDEO_CODEC_H264) {
            throw new RuntimeException("initEncode: Non-supported codec " + videoCodecType);
        } else {
            EncoderProperties findHwEncoder2 = findHwEncoder("video/avc", h264HwList(), z ? supportedSurfaceColorList : supportedColorList, i2, i3);
            if (i == H264Profile.CONSTRAINED_HIGH.getValue()) {
                if (findHwEncoder("video/avc", h264HighProfileHwList, z ? supportedSurfaceColorList : supportedColorList, i2, i3) != null) {
                    Logging.d(TAG, "High profile H.264 encoder supported.");
                    z2 = true;
                    encoderProperties = findHwEncoder2;
                    i6 = 20;
                    str = "video/avc";
                    z3 = z2;
                    if (encoderProperties == null) {
                        throw new RuntimeException("Can not find HW encoder for " + videoCodecType);
                    }
                    runningInstance = this;
                    this.colorFormat = encoderProperties.colorFormat;
                    this.bitrateAdjustmentType = encoderProperties.bitrateAdjustmentType;
                    int min = this.bitrateAdjustmentType != BitrateAdjustmentType.FRAMERATE_ADJUSTMENT ? Math.min(i5, 30) : 30;
                    this.forcedKeyFrameMs = 0L;
                    this.lastKeyFrameMs = -1L;
                    if (videoCodecType == VideoCodecType.VIDEO_CODEC_VP8 && encoderProperties.codecName.startsWith(qcomVp8HwProperties.codecPrefix)) {
                        if (Build.VERSION.SDK_INT == 21 || Build.VERSION.SDK_INT == 22) {
                            this.forcedKeyFrameMs = 15000L;
                        } else if (Build.VERSION.SDK_INT == 23) {
                            this.forcedKeyFrameMs = QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_M_MS;
                        } else if (Build.VERSION.SDK_INT > 23) {
                            this.forcedKeyFrameMs = 15000L;
                        }
                    }
                    if (!TextUtils.isEmpty(this.bitrateModePreset) && ((parseInt = Integer.parseInt(this.bitrateModePreset)) == 0 || parseInt == 1 || parseInt == 2)) {
                        bitrateMode = parseInt;
                    }
                    Logging.d(TAG, "Color format: " + this.colorFormat + ". Bitrate adjustment: " + this.bitrateAdjustmentType + ". Key frame interval: " + this.forcedKeyFrameMs + " . Initial fps: " + min + ". BitrateMode: " + bitrateMode);
                    this.targetBitrateBps = i4 * 1000;
                    this.targetFps = min;
                    this.bitrateAccumulatorMax = ((double) this.targetBitrateBps) / 8.0d;
                    this.bitrateAccumulator = 0.0d;
                    this.bitrateObservationTimeMs = 0.0d;
                    this.bitrateAdjustmentScaleExp = 0;
                    this.mediaCodecThread = Thread.currentThread();
                    try {
                        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, i2, i3);
                        createVideoFormat.setInteger("bitrate", this.targetBitrateBps);
                        createVideoFormat.setInteger("bitrate-mode", bitrateMode);
                        createVideoFormat.setInteger("color-format", encoderProperties.colorFormat);
                        createVideoFormat.setInteger("frame-rate", this.targetFps);
                        createVideoFormat.setInteger("i-frame-interval", i6);
                        if (z3) {
                            createVideoFormat.setInteger(ConstantData.VideoLocationType.PERSON_PROFILE, 8);
                            createVideoFormat.setInteger("level", 256);
                        }
                        Logging.d(TAG, "  Format: " + createVideoFormat);
                        this.mediaCodec = createByCodecName(encoderProperties.codecName);
                        this.type = videoCodecType;
                        if (this.mediaCodec == null) {
                            Logging.e(TAG, "Can not create media encoder");
                            release();
                            return false;
                        }
                        this.mediaCodec.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                        if (z) {
                            this.eglBase = new EglBase14((EglBase14.Context) getEglContext(), EglBase.CONFIG_RECORDABLE);
                            this.inputSurface = this.mediaCodec.createInputSurface();
                            this.eglBase.createSurface(this.inputSurface);
                            this.drawer = new GlRectDrawer();
                        }
                        this.mediaCodec.start();
                        this.outputBuffers = this.mediaCodec.getOutputBuffers();
                        Logging.d(TAG, "Output buffers: " + this.outputBuffers.length);
                        return true;
                    } catch (IllegalStateException e) {
                        Logging.e(TAG, "initEncode failed", e);
                        release();
                        return false;
                    }
                }
                Logging.d(TAG, "High profile H.264 encoder requested, but not supported. Use baseline.");
            }
            z2 = false;
            encoderProperties = findHwEncoder2;
            i6 = 20;
            str = "video/avc";
            z3 = z2;
            if (encoderProperties == null) {
            }
        }
        encoderProperties = findHwEncoder;
        z3 = false;
        str = str2;
        if (encoderProperties == null) {
        }
    }

    @CalledByNativeUnchecked
    void release() {
        boolean z = true;
        Logging.d(TAG, "Java releaseEncoder");
        checkOnMediaCodecThread();
        final C1CaughtException c1CaughtException = new C1CaughtException();
        if (this.mediaCodec != null) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            new Thread(new Runnable() { // from class: org.webrtc.MediaCodecVideoEncoder.1
                @Override // java.lang.Runnable
                public void run() {
                    Logging.d(MediaCodecVideoEncoder.TAG, "Java releaseEncoder on release thread");
                    try {
                        MediaCodecVideoEncoder.this.mediaCodec.stop();
                    } catch (Exception e) {
                        Logging.e(MediaCodecVideoEncoder.TAG, "Media encoder stop failed", e);
                    }
                    try {
                        MediaCodecVideoEncoder.this.mediaCodec.release();
                    } catch (Exception e2) {
                        Logging.e(MediaCodecVideoEncoder.TAG, "Media encoder release failed", e2);
                        c1CaughtException.e = e2;
                    }
                    Logging.d(MediaCodecVideoEncoder.TAG, "Java releaseEncoder on release thread done");
                    countDownLatch.countDown();
                }
            }).start();
            if (ThreadUtils.awaitUninterruptibly(countDownLatch, 5000L)) {
                z = false;
            } else {
                Logging.e(TAG, "Media encoder release timeout");
            }
            this.mediaCodec = null;
        } else {
            z = false;
        }
        this.mediaCodecThread = null;
        if (this.drawer != null) {
            this.drawer.release();
            this.drawer = null;
        }
        if (this.eglBase != null) {
            this.eglBase.release();
            this.eglBase = null;
        }
        if (this.inputSurface != null) {
            this.inputSurface.release();
            this.inputSurface = null;
        }
        runningInstance = null;
        if (!z) {
            if (c1CaughtException.e == null) {
                Logging.d(TAG, "Java releaseEncoder done");
                return;
            }
            RuntimeException runtimeException = new RuntimeException(c1CaughtException.e);
            runtimeException.setStackTrace(ThreadUtils.concatStackTraces(c1CaughtException.e.getStackTrace(), runtimeException.getStackTrace()));
            throw runtimeException;
        }
        codecErrors++;
        if (errorCallback != null) {
            Logging.e(TAG, "Invoke codec error callback. Errors: " + codecErrors);
            errorCallback.onMediaCodecVideoEncoderCriticalError(codecErrors);
        }
        throw new RuntimeException("Media encoder release timeout.");
    }

    @CalledByNativeUnchecked
    boolean releaseOutputBuffer(int i) {
        checkOnMediaCodecThread();
        try {
            this.mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } catch (IllegalStateException e) {
            Logging.e(TAG, "releaseOutputBuffer failed", e);
            return false;
        }
    }
}
