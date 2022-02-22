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
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import h.c.i0;
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
/* loaded from: classes5.dex */
public class MediaCodecVideoEncoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final MediaCodecProperties AllwinnerH264HwProperties;
    public static final int BITRATE_ADJUSTMENT_FPS = 30;
    public static final double BITRATE_CORRECTION_MAX_SCALE = 4.0d;
    public static final double BITRATE_CORRECTION_SEC = 3.0d;
    public static final int BITRATE_CORRECTION_STEPS = 20;
    public static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
    public static final int DEQUEUE_TIMEOUT = 0;
    public static final MediaCodecProperties FreescaH264HwProperties;
    public static final String[] H264_HW_EXCEPTION_MODELS;
    public static final String H264_MIME_TYPE = "video/avc";
    public static final int MAXIMUM_INITIAL_FPS = 30;
    public static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    public static final MediaCodecProperties NvidiaH264HwProperties;
    public static final long QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_L_MS = 15000;
    public static final long QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_M_MS = 20000;
    public static final long QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_N_MS = 15000;
    public static final MediaCodecProperties RockchipH264HwProperties;
    public static final String TAG = "MediaCodecVideoEncoder";
    public static final int VIDEO_AVCLevel3 = 256;
    public static final int VIDEO_AVCProfileHigh = 8;
    public static final int VIDEO_ControlRateConstant = 2;
    public static final int VIDEO_ControlRateDisable = 0;
    public static final int VIDEO_ControlRateVariable = 1;
    public static int VIDEO_HEIGHT = 0;
    public static int VIDEO_WIDTH = 0;
    public static final String VP8_MIME_TYPE = "video/x-vnd.on2.vp8";
    public static final String VP9_MIME_TYPE = "video/x-vnd.on2.vp9";
    public static final MediaCodecProperties amlogicH264HwProperties;
    public static int bitrateMode;
    public static int codecErrors;
    @Nullable
    public static MediaCodecVideoEncoderErrorCallback errorCallback;
    public static final MediaCodecProperties exynosH264HighProfileHwProperties;
    public static final MediaCodecProperties exynosH264HwProperties;
    public static final MediaCodecProperties exynosVp8HwProperties;
    public static final MediaCodecProperties exynosVp9HwProperties;
    public static final MediaCodecProperties googH264HwProperties;
    public static final MediaCodecProperties[] h264HighProfileHwList;
    public static final MediaCodecProperties hisiH264HighProfileHwProperties;
    public static final MediaCodecProperties hisiH264HwProperties;
    public static final MediaCodecProperties huaweiIMGH264HwProperties;
    public static Set<String> hwEncoderDisabledTypes;
    public static final MediaCodecProperties intelVp8HwProperties;
    public static final MediaCodecProperties myMTKH264HighProfileHwProperties;
    public static final MediaCodecProperties myMTKH264HwProperties;
    public static final MediaCodecProperties qcomH264HighProfileHwProperties;
    public static final MediaCodecProperties qcomH264HwProperties;
    public static final MediaCodecProperties qcomVp8HwProperties;
    public static final MediaCodecProperties qcomVp9HwProperties;
    @Nullable
    public static MediaCodecVideoEncoder runningInstance;
    public static final MediaCodecProperties sprdH264HwProperties;
    @Nullable
    public static EglBase staticEglBase;
    public static final int[] supportedColorList;
    public static final int[] supportedSurfaceColorList;
    public static final MediaCodecProperties[] vp9HwList;
    public transient /* synthetic */ FieldHolder $fh;
    public double bitrateAccumulator;
    public double bitrateAccumulatorMax;
    public int bitrateAdjustmentScaleExp;
    public BitrateAdjustmentType bitrateAdjustmentType;
    public String bitrateModePreset;
    public double bitrateObservationTimeMs;
    public int colorFormat;
    @Nullable
    public ByteBuffer configData;
    @Nullable
    public GlRectDrawer drawer;
    @Nullable
    public EglBase14 eglBase;
    public long forcedKeyFrameMs;
    public int height;
    @Nullable
    public Surface inputSurface;
    public long lastKeyFrameMs;
    @Nullable
    public MediaCodec mediaCodec;
    @Nullable
    public Thread mediaCodecThread;
    public ByteBuffer[] outputBuffers;
    public int profile;
    public int targetBitrateBps;
    public int targetFps;
    public VideoCodecType type;
    public int width;

    /* renamed from: org.webrtc.MediaCodecVideoEncoder$1CaughtException  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class C1CaughtException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Exception f62659e;
        public final /* synthetic */ MediaCodecVideoEncoder this$0;

        public C1CaughtException(MediaCodecVideoEncoder mediaCodecVideoEncoder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaCodecVideoEncoder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaCodecVideoEncoder;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class BitrateAdjustmentType {
        public static final /* synthetic */ BitrateAdjustmentType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BitrateAdjustmentType DYNAMIC_ADJUSTMENT;
        public static final BitrateAdjustmentType FRAMERATE_ADJUSTMENT;
        public static final BitrateAdjustmentType NO_ADJUSTMENT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1653064237, "Lorg/webrtc/MediaCodecVideoEncoder$BitrateAdjustmentType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1653064237, "Lorg/webrtc/MediaCodecVideoEncoder$BitrateAdjustmentType;");
                    return;
                }
            }
            NO_ADJUSTMENT = new BitrateAdjustmentType("NO_ADJUSTMENT", 0);
            FRAMERATE_ADJUSTMENT = new BitrateAdjustmentType("FRAMERATE_ADJUSTMENT", 1);
            BitrateAdjustmentType bitrateAdjustmentType = new BitrateAdjustmentType("DYNAMIC_ADJUSTMENT", 2);
            DYNAMIC_ADJUSTMENT = bitrateAdjustmentType;
            $VALUES = new BitrateAdjustmentType[]{NO_ADJUSTMENT, FRAMERATE_ADJUSTMENT, bitrateAdjustmentType};
        }

        public BitrateAdjustmentType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static BitrateAdjustmentType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BitrateAdjustmentType) Enum.valueOf(BitrateAdjustmentType.class, str) : (BitrateAdjustmentType) invokeL.objValue;
        }

        public static BitrateAdjustmentType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BitrateAdjustmentType[]) $VALUES.clone() : (BitrateAdjustmentType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class EncoderProperties {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BitrateAdjustmentType bitrateAdjustmentType;
        public final String codecName;
        public final int colorFormat;

        public EncoderProperties(String str, int i2, BitrateAdjustmentType bitrateAdjustmentType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), bitrateAdjustmentType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.codecName = str;
            this.colorFormat = i2;
            this.bitrateAdjustmentType = bitrateAdjustmentType;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class H264Profile {
        public static final /* synthetic */ H264Profile[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final H264Profile BASELINE;
        public static final H264Profile CONSTRAINED_BASELINE;
        public static final H264Profile CONSTRAINED_HIGH;
        public static final H264Profile HIGH;
        public static final H264Profile MAIN;
        public transient /* synthetic */ FieldHolder $fh;
        public final int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1736210144, "Lorg/webrtc/MediaCodecVideoEncoder$H264Profile;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1736210144, "Lorg/webrtc/MediaCodecVideoEncoder$H264Profile;");
                    return;
                }
            }
            CONSTRAINED_BASELINE = new H264Profile("CONSTRAINED_BASELINE", 0, 0);
            BASELINE = new H264Profile("BASELINE", 1, 1);
            MAIN = new H264Profile("MAIN", 2, 2);
            CONSTRAINED_HIGH = new H264Profile("CONSTRAINED_HIGH", 3, 3);
            H264Profile h264Profile = new H264Profile("HIGH", 4, 4);
            HIGH = h264Profile;
            $VALUES = new H264Profile[]{CONSTRAINED_BASELINE, BASELINE, MAIN, CONSTRAINED_HIGH, h264Profile};
        }

        public H264Profile(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = i3;
        }

        public static H264Profile valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (H264Profile) Enum.valueOf(H264Profile.class, str) : (H264Profile) invokeL.objValue;
        }

        public static H264Profile[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (H264Profile[]) $VALUES.clone() : (H264Profile[]) invokeV.objValue;
        }

        public int getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class HwEncoderFactory implements VideoEncoderFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final VideoCodecInfo[] supportedHardwareCodecs;

        public HwEncoderFactory() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.supportedHardwareCodecs = getSupportedHardwareCodecs();
        }

        public static VideoCodecInfo[] getSupportedHardwareCodecs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                ArrayList arrayList = new ArrayList();
                if (MediaCodecVideoEncoder.isVp8HwSupported()) {
                    Logging.d(MediaCodecVideoEncoder.TAG, "VP8 HW Encoder supported.");
                    arrayList.add(new VideoCodecInfo(PeerConnectionClient.VIDEO_CODEC_VP8, new HashMap()));
                }
                if (MediaCodecVideoEncoder.isVp9HwSupported()) {
                    Logging.d(MediaCodecVideoEncoder.TAG, "VP9 HW Encoder supported.");
                    arrayList.add(new VideoCodecInfo(PeerConnectionClient.VIDEO_CODEC_VP9, new HashMap()));
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
            return (VideoCodecInfo[]) invokeV.objValue;
        }

        public static boolean isCodecSupported(VideoCodecInfo[] videoCodecInfoArr, VideoCodecInfo videoCodecInfo) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, videoCodecInfoArr, videoCodecInfo)) == null) {
                for (VideoCodecInfo videoCodecInfo2 : videoCodecInfoArr) {
                    if (isSameCodec(videoCodecInfo2, videoCodecInfo)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public static boolean isSameCodec(VideoCodecInfo videoCodecInfo, VideoCodecInfo videoCodecInfo2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, videoCodecInfo, videoCodecInfo2)) == null) {
                if (videoCodecInfo.name.equalsIgnoreCase(videoCodecInfo2.name)) {
                    if (videoCodecInfo.name.equalsIgnoreCase(PeerConnectionClient.VIDEO_CODEC_H264)) {
                        return H264Utils.isSameH264Profile(videoCodecInfo.params, videoCodecInfo2.params);
                    }
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // org.webrtc.VideoEncoderFactory
        @Nullable
        public VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, videoCodecInfo)) == null) {
                if (!isCodecSupported(this.supportedHardwareCodecs, videoCodecInfo)) {
                    Logging.d(MediaCodecVideoEncoder.TAG, "No HW video encoder for codec " + videoCodecInfo.name);
                    return null;
                }
                Logging.d(MediaCodecVideoEncoder.TAG, "Create HW video encoder for " + videoCodecInfo.name);
                return new WrappedNativeVideoEncoder(this, videoCodecInfo) { // from class: org.webrtc.MediaCodecVideoEncoder.HwEncoderFactory.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ HwEncoderFactory this$0;
                    public final /* synthetic */ VideoCodecInfo val$info;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, videoCodecInfo};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$info = videoCodecInfo;
                    }

                    @Override // org.webrtc.WrappedNativeVideoEncoder, org.webrtc.VideoEncoder
                    public long createNativeVideoEncoder() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? MediaCodecVideoEncoder.nativeCreateEncoder(this.val$info, MediaCodecVideoEncoder.staticEglBase instanceof EglBase14) : invokeV.longValue;
                    }

                    @Override // org.webrtc.WrappedNativeVideoEncoder, org.webrtc.VideoEncoder
                    public boolean isHardwareEncoder() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            return true;
                        }
                        return invokeV.booleanValue;
                    }
                };
            }
            return (VideoEncoder) invokeL.objValue;
        }

        @Override // org.webrtc.VideoEncoderFactory
        public VideoCodecInfo[] getSupportedCodecs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.supportedHardwareCodecs : (VideoCodecInfo[]) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class MediaCodecProperties {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BitrateAdjustmentType bitrateAdjustmentType;
        public final String codecPrefix;
        public final int minSdk;

        public MediaCodecProperties(String str, int i2, BitrateAdjustmentType bitrateAdjustmentType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), bitrateAdjustmentType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.codecPrefix = str;
            this.minSdk = i2;
            this.bitrateAdjustmentType = bitrateAdjustmentType;
        }
    }

    /* loaded from: classes5.dex */
    public interface MediaCodecVideoEncoderErrorCallback {
        void onMediaCodecVideoEncoderCriticalError(int i2);
    }

    /* loaded from: classes5.dex */
    public static class OutputBufferInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ByteBuffer buffer;
        public final int index;
        public final boolean isKeyFrame;
        public final long presentationTimestampUs;

        public OutputBufferInfo(int i2, ByteBuffer byteBuffer, boolean z, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), byteBuffer, Boolean.valueOf(z), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.index = i2;
            this.buffer = byteBuffer;
            this.isKeyFrame = z;
            this.presentationTimestampUs = j2;
        }

        @CalledByNative("OutputBufferInfo")
        public ByteBuffer getBuffer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.buffer : (ByteBuffer) invokeV.objValue;
        }

        @CalledByNative("OutputBufferInfo")
        public int getIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.index : invokeV.intValue;
        }

        @CalledByNative("OutputBufferInfo")
        public long getPresentationTimestampUs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.presentationTimestampUs : invokeV.longValue;
        }

        @CalledByNative("OutputBufferInfo")
        public boolean isKeyFrame() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.isKeyFrame : invokeV.booleanValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class VideoCodecType {
        public static final /* synthetic */ VideoCodecType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final VideoCodecType VIDEO_CODEC_H264;
        public static final VideoCodecType VIDEO_CODEC_UNKNOWN;
        public static final VideoCodecType VIDEO_CODEC_VP8;
        public static final VideoCodecType VIDEO_CODEC_VP9;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(216849632, "Lorg/webrtc/MediaCodecVideoEncoder$VideoCodecType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(216849632, "Lorg/webrtc/MediaCodecVideoEncoder$VideoCodecType;");
                    return;
                }
            }
            VIDEO_CODEC_UNKNOWN = new VideoCodecType("VIDEO_CODEC_UNKNOWN", 0);
            VIDEO_CODEC_VP8 = new VideoCodecType("VIDEO_CODEC_VP8", 1);
            VIDEO_CODEC_VP9 = new VideoCodecType("VIDEO_CODEC_VP9", 2);
            VideoCodecType videoCodecType = new VideoCodecType("VIDEO_CODEC_H264", 3);
            VIDEO_CODEC_H264 = videoCodecType;
            $VALUES = new VideoCodecType[]{VIDEO_CODEC_UNKNOWN, VIDEO_CODEC_VP8, VIDEO_CODEC_VP9, videoCodecType};
        }

        public VideoCodecType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @CalledByNative("VideoCodecType")
        public static VideoCodecType fromNativeIndex(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? values()[i2] : (VideoCodecType) invokeI.objValue;
        }

        public static VideoCodecType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (VideoCodecType) Enum.valueOf(VideoCodecType.class, str) : (VideoCodecType) invokeL.objValue;
        }

        public static VideoCodecType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (VideoCodecType[]) $VALUES.clone() : (VideoCodecType[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1525201661, "Lorg/webrtc/MediaCodecVideoEncoder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1525201661, "Lorg/webrtc/MediaCodecVideoEncoder;");
                return;
            }
        }
        hwEncoderDisabledTypes = new HashSet();
        qcomVp8HwProperties = new MediaCodecProperties("OMX.qcom.", 19, BitrateAdjustmentType.NO_ADJUSTMENT);
        exynosVp8HwProperties = new MediaCodecProperties("OMX.Exynos.", 23, BitrateAdjustmentType.DYNAMIC_ADJUSTMENT);
        intelVp8HwProperties = new MediaCodecProperties(MediaCodecUtils.INTEL_PREFIX, 21, BitrateAdjustmentType.NO_ADJUSTMENT);
        qcomVp9HwProperties = new MediaCodecProperties("OMX.qcom.", 24, BitrateAdjustmentType.NO_ADJUSTMENT);
        MediaCodecProperties mediaCodecProperties = new MediaCodecProperties("OMX.Exynos.", 24, BitrateAdjustmentType.FRAMERATE_ADJUSTMENT);
        exynosVp9HwProperties = mediaCodecProperties;
        vp9HwList = new MediaCodecProperties[]{qcomVp9HwProperties, mediaCodecProperties};
        qcomH264HwProperties = new MediaCodecProperties("OMX.qcom.", 19, BitrateAdjustmentType.NO_ADJUSTMENT);
        exynosH264HwProperties = new MediaCodecProperties("OMX.Exynos.", 21, BitrateAdjustmentType.FRAMERATE_ADJUSTMENT);
        FreescaH264HwProperties = new MediaCodecProperties("OMX.Freesca", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
        hisiH264HwProperties = new MediaCodecProperties(MediaCodecVideoDecoder.supportedHisiH264HighProfileHwCodecPrefix, 21, BitrateAdjustmentType.DYNAMIC_ADJUSTMENT);
        myMTKH264HwProperties = new MediaCodecProperties(MediaCodecVideoDecoder.supportedMediaTekH264HighProfileHwCodecPrefix, 21, BitrateAdjustmentType.NO_ADJUSTMENT);
        RockchipH264HwProperties = new MediaCodecProperties("OMX.rk.", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
        AllwinnerH264HwProperties = new MediaCodecProperties("OMX.allwinner.", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
        NvidiaH264HwProperties = new MediaCodecProperties(MediaCodecUtils.NVIDIA_PREFIX, 21, BitrateAdjustmentType.NO_ADJUSTMENT);
        huaweiIMGH264HwProperties = new MediaCodecProperties("OMX.IMG.", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
        googH264HwProperties = new MediaCodecProperties("OMX.google.", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
        sprdH264HwProperties = new MediaCodecProperties("OMX.sprd.", 19, BitrateAdjustmentType.NO_ADJUSTMENT);
        amlogicH264HwProperties = new MediaCodecProperties("OMX.amlogic.", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
        exynosH264HighProfileHwProperties = new MediaCodecProperties("OMX.Exynos.", 23, BitrateAdjustmentType.FRAMERATE_ADJUSTMENT);
        qcomH264HighProfileHwProperties = new MediaCodecProperties("OMX.qcom.", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
        hisiH264HighProfileHwProperties = new MediaCodecProperties(MediaCodecVideoDecoder.supportedHisiH264HighProfileHwCodecPrefix, 23, BitrateAdjustmentType.DYNAMIC_ADJUSTMENT);
        MediaCodecProperties mediaCodecProperties2 = new MediaCodecProperties(MediaCodecVideoDecoder.supportedMediaTekH264HighProfileHwCodecPrefix, 27, BitrateAdjustmentType.NO_ADJUSTMENT);
        myMTKH264HighProfileHwProperties = mediaCodecProperties2;
        h264HighProfileHwList = new MediaCodecProperties[]{exynosH264HighProfileHwProperties, qcomH264HighProfileHwProperties, hisiH264HighProfileHwProperties, mediaCodecProperties2};
        H264_HW_EXCEPTION_MODELS = new String[]{"SAMSUNG-SGH-I337", "Nexus 7", "Nexus 4"};
        bitrateMode = 2;
        supportedColorList = new int[]{19, 21, 2141391872, 2141391876};
        supportedSurfaceColorList = new int[]{2130708361};
    }

    @CalledByNative
    public MediaCodecVideoEncoder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.bitrateModePreset = PeerConnectionFactory.fieldTrialsFindFullName("BRTC-Encoder-BitrateMode");
        this.bitrateAdjustmentType = BitrateAdjustmentType.NO_ADJUSTMENT;
    }

    private void checkOnMediaCodecThread() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || this.mediaCodecThread.getId() == Thread.currentThread().getId()) {
            return;
        }
        throw new RuntimeException("MediaCodecVideoEncoder previously operated on " + this.mediaCodecThread + " but is now called on " + Thread.currentThread());
    }

    @Nullable
    public static MediaCodec createByCodecName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            try {
                return MediaCodec.createByCodecName(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return (MediaCodec) invokeL.objValue;
    }

    public static VideoEncoderFactory createFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new DefaultVideoEncoderFactory(new HwEncoderFactory()) : (VideoEncoderFactory) invokeV.objValue;
    }

    public static void disableH264HwCodec() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            Logging.w(TAG, "H.264 encoding is disabled by application.");
            hwEncoderDisabledTypes.add("video/avc");
        }
    }

    public static void disableVp8HwCodec() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            Logging.w(TAG, "VP8 encoding is disabled by application.");
            hwEncoderDisabledTypes.add("video/x-vnd.on2.vp8");
        }
    }

    public static void disableVp9HwCodec() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            Logging.w(TAG, "VP9 encoding is disabled by application.");
            hwEncoderDisabledTypes.add("video/x-vnd.on2.vp9");
        }
    }

    public static void disposeEglContext() {
        EglBase eglBase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, null) == null) || (eglBase = staticEglBase) == null) {
            return;
        }
        eglBase.release();
        staticEglBase = null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0087 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: android.media.MediaCodecInfo */
    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: android.media.MediaCodecInfo */
    /* JADX DEBUG: Multi-variable search result rejected for r9v3, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r9v8, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v4 */
    @Nullable
    public static EncoderProperties findHwEncoder(String str, MediaCodecProperties[] mediaCodecPropertiesArr, int[] iArr, int i2, int i3) {
        InterceptResult invokeCommon;
        MediaCodecInfo mediaCodecInfo;
        String str2;
        boolean z;
        String str3;
        boolean z2;
        int[] iArr2;
        int[] iArr3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{str, mediaCodecPropertiesArr, iArr, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            int i4 = 19;
            EncoderProperties encoderProperties = null;
            if (Build.VERSION.SDK_INT < 19) {
                return null;
            }
            if (str.equals("video/avc") && Arrays.asList(H264_HW_EXCEPTION_MODELS).contains(Build.MODEL)) {
                Logging.w(TAG, "Model: " + Build.MODEL + " has black listed H.264 encoder.");
                return null;
            }
            int i5 = 0;
            while (i5 < MediaCodecList.getCodecCount()) {
                try {
                    mediaCodecInfo = MediaCodecList.getCodecInfoAt(i5);
                } catch (IllegalArgumentException e2) {
                    Logging.e(TAG, "Cannot retrieve encoder codec info", e2);
                    mediaCodecInfo = encoderProperties;
                }
                if (mediaCodecInfo != 0 && mediaCodecInfo.isEncoder()) {
                    String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i6 = 0;
                    while (true) {
                        if (i6 >= length) {
                            str2 = encoderProperties;
                            break;
                        } else if (supportedTypes[i6].equals(str)) {
                            String name = mediaCodecInfo.getName();
                            str2 = name;
                            if (i2 * i3 < 25364) {
                                boolean startsWith = name.startsWith(MediaCodecVideoDecoder.supportedHisiH264HighProfileHwCodecPrefix);
                                str2 = name;
                                if (startsWith) {
                                    str2 = encoderProperties;
                                }
                            }
                            if (str2 != null && str2.startsWith("OMX.IMG.TOPAZ")) {
                                z = true;
                                str3 = str2;
                            }
                        } else {
                            i6++;
                        }
                    }
                    z = false;
                    str3 = str2;
                    if (str3 == null) {
                        continue;
                    } else {
                        Logging.v(TAG, "Found candidate encoder " + str3);
                        BitrateAdjustmentType bitrateAdjustmentType = BitrateAdjustmentType.NO_ADJUSTMENT;
                        int length2 = mediaCodecPropertiesArr.length;
                        int i7 = 0;
                        while (true) {
                            if (i7 >= length2) {
                                z2 = false;
                                break;
                            }
                            MediaCodecProperties mediaCodecProperties = mediaCodecPropertiesArr[i7];
                            if (str3.startsWith(mediaCodecProperties.codecPrefix)) {
                                if (Build.VERSION.SDK_INT < mediaCodecProperties.minSdk) {
                                    Logging.w(TAG, "Codec " + str3 + " is disabled due to SDK version " + Build.VERSION.SDK_INT);
                                } else {
                                    BitrateAdjustmentType bitrateAdjustmentType2 = mediaCodecProperties.bitrateAdjustmentType;
                                    if (bitrateAdjustmentType2 != BitrateAdjustmentType.NO_ADJUSTMENT) {
                                        Logging.w(TAG, "Codec " + str3 + " requires bitrate adjustment: " + bitrateAdjustmentType2);
                                        bitrateAdjustmentType = bitrateAdjustmentType2;
                                    }
                                    z2 = true;
                                }
                            }
                            i7++;
                        }
                        if (z2) {
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                                for (int i8 : capabilitiesForType.colorFormats) {
                                    Logging.v(TAG, "   Color: 0x" + Integer.toHexString(i8));
                                }
                                int length3 = iArr.length;
                                int i9 = 0;
                                while (i9 < length3) {
                                    int i10 = iArr[i9];
                                    if (z && i10 == i4) {
                                        Logging.d(TAG, "OMX.IMG.TOPAZ not support color formate 19");
                                    } else {
                                        for (int i11 : capabilitiesForType.colorFormats) {
                                            if (i11 == i10) {
                                                Logging.d(TAG, "Found target encoder for mime " + str + ZeusCrashHandler.NAME_SEPERATOR + str3 + ". Color: 0x" + Integer.toHexString(i11) + ". Bitrate adjustment: " + bitrateAdjustmentType);
                                                return new EncoderProperties(str3, i11, bitrateAdjustmentType);
                                            }
                                        }
                                        continue;
                                    }
                                    i9++;
                                    i4 = 19;
                                }
                                continue;
                            } catch (IllegalArgumentException e3) {
                                Logging.e(TAG, "Cannot retrieve encoder capabilities", e3);
                            }
                        } else {
                            continue;
                        }
                    }
                }
                i5++;
                i4 = 19;
                encoderProperties = null;
            }
            return encoderProperties;
        }
        return (EncoderProperties) invokeCommon.objValue;
    }

    private double getBitrateScale(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65549, this, i2)) == null) ? Math.pow(4.0d, i2 / 20.0d) : invokeI.doubleValue;
    }

    @Nullable
    public static EglBase.Context getEglContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            EglBase eglBase = staticEglBase;
            if (eglBase == null) {
                return null;
            }
            return eglBase.getEglBaseContext();
        }
        return (EglBase.Context) invokeV.objValue;
    }

    public static final MediaCodecProperties[] h264HwList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(qcomH264HwProperties);
            arrayList.add(exynosH264HwProperties);
            arrayList.add(FreescaH264HwProperties);
            if (PeerConnectionFactory.fieldTrialsFindFullName("BRTC.HisiH264HW").equals(PeerConnectionFactory.TRIAL_ENABLED)) {
                Logging.v(TAG, "enable hisiH264HW");
                arrayList.add(hisiH264HwProperties);
            }
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
        return (MediaCodecProperties[]) invokeV.objValue;
    }

    public static boolean isH264HighProfileHwSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? (hwEncoderDisabledTypes.contains("video/avc") || findHwEncoder("video/avc", h264HighProfileHwList, supportedColorList, 0, 0) == null) ? false : true : invokeV.booleanValue;
    }

    public static boolean isH264HwSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? (hwEncoderDisabledTypes.contains("video/avc") || findHwEncoder("video/avc", h264HwList(), supportedColorList, 0, 0) == null) ? false : true : invokeV.booleanValue;
    }

    public static boolean isH264HwSupportedUsingTextures() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? (hwEncoderDisabledTypes.contains("video/avc") || findHwEncoder("video/avc", h264HwList(), supportedSurfaceColorList, 0, 0) == null) ? false : true : invokeV.booleanValue;
    }

    @CalledByNative
    public static boolean isTextureBuffer(VideoFrame.Buffer buffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, buffer)) == null) ? buffer instanceof VideoFrame.TextureBuffer : invokeL.booleanValue;
    }

    public static boolean isVp8HwSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? (hwEncoderDisabledTypes.contains("video/x-vnd.on2.vp8") || findHwEncoder("video/x-vnd.on2.vp8", vp8HwList(), supportedColorList, 0, 0) == null) ? false : true : invokeV.booleanValue;
    }

    public static boolean isVp8HwSupportedUsingTextures() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? (hwEncoderDisabledTypes.contains("video/x-vnd.on2.vp8") || findHwEncoder("video/x-vnd.on2.vp8", vp8HwList(), supportedSurfaceColorList, 0, 0) == null) ? false : true : invokeV.booleanValue;
    }

    public static boolean isVp9HwSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? (hwEncoderDisabledTypes.contains("video/x-vnd.on2.vp9") || findHwEncoder("video/x-vnd.on2.vp9", vp9HwList, supportedColorList, 0, 0) == null) ? false : true : invokeV.booleanValue;
    }

    public static boolean isVp9HwSupportedUsingTextures() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? (hwEncoderDisabledTypes.contains("video/x-vnd.on2.vp9") || findHwEncoder("video/x-vnd.on2.vp9", vp9HwList, supportedSurfaceColorList, 0, 0) == null) ? false : true : invokeV.booleanValue;
    }

    public static native long nativeCreateEncoder(VideoCodecInfo videoCodecInfo, boolean z);

    public static native void nativeFillInputBuffer(long j2, int i2, ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2, int i4, ByteBuffer byteBuffer3, int i5);

    public static void printStackTrace() {
        MediaCodecVideoEncoder mediaCodecVideoEncoder;
        Thread thread;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, null) == null) || (mediaCodecVideoEncoder = runningInstance) == null || (thread = mediaCodecVideoEncoder.mediaCodecThread) == null) {
            return;
        }
        StackTraceElement[] stackTrace = thread.getStackTrace();
        if (stackTrace.length > 0) {
            Logging.d(TAG, "MediaCodecVideoEncoder stacks trace:");
            for (StackTraceElement stackTraceElement : stackTrace) {
                Logging.d(TAG, stackTraceElement.toString());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void reportEncodedFrame(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65563, this, i2) == null) && (i3 = this.targetFps) != 0 && this.bitrateAdjustmentType == BitrateAdjustmentType.DYNAMIC_ADJUSTMENT) {
            double d2 = this.bitrateAccumulator + (i2 - (this.targetBitrateBps / (i3 * 8.0d)));
            this.bitrateAccumulator = d2;
            this.bitrateObservationTimeMs += 1000.0d / i3;
            double d3 = this.bitrateAccumulatorMax * 3.0d;
            double min = Math.min(d2, d3);
            this.bitrateAccumulator = min;
            this.bitrateAccumulator = Math.max(min, -d3);
            if (this.bitrateObservationTimeMs > 3000.0d) {
                Logging.d(TAG, "Acc: " + ((int) this.bitrateAccumulator) + ". Max: " + ((int) this.bitrateAccumulatorMax) + ". ExpScale: " + this.bitrateAdjustmentScaleExp);
                boolean z = false;
                double d4 = this.bitrateAccumulator;
                double d5 = this.bitrateAccumulatorMax;
                if (d4 > d5) {
                    this.bitrateAdjustmentScaleExp -= (int) ((d4 / d5) + 0.5d);
                    this.bitrateAccumulator = d5;
                } else {
                    if (d4 < (-d5)) {
                        this.bitrateAdjustmentScaleExp += (int) (((-d4) / d5) + 0.5d);
                        this.bitrateAccumulator = -d5;
                    }
                    if (z) {
                        int min2 = Math.min(this.bitrateAdjustmentScaleExp, 20);
                        this.bitrateAdjustmentScaleExp = min2;
                        this.bitrateAdjustmentScaleExp = Math.max(min2, -20);
                        Logging.d(TAG, "Adjusting bitrate scale to " + this.bitrateAdjustmentScaleExp + ". Value: " + getBitrateScale(this.bitrateAdjustmentScaleExp));
                        setRates(this.targetBitrateBps / 1000, this.targetFps);
                    }
                    this.bitrateObservationTimeMs = 0.0d;
                }
                z = true;
                if (z) {
                }
                this.bitrateObservationTimeMs = 0.0d;
            }
        }
    }

    public static void setEglContext(EglBase.Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, context) == null) {
            if (staticEglBase != null) {
                Logging.w(TAG, "Egl context already set.");
                staticEglBase.release();
            }
            staticEglBase = i0.b(context);
        }
    }

    public static void setErrorCallback(MediaCodecVideoEncoderErrorCallback mediaCodecVideoEncoderErrorCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, null, mediaCodecVideoEncoderErrorCallback) == null) {
            Logging.d(TAG, "Set error callback");
            errorCallback = mediaCodecVideoEncoderErrorCallback;
        }
    }

    @CalledByNativeUnchecked
    private boolean setRates(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65566, this, i2, i3)) == null) {
            checkOnMediaCodecThread();
            int i4 = i2 * 1000;
            if (this.bitrateAdjustmentType == BitrateAdjustmentType.DYNAMIC_ADJUSTMENT) {
                double d2 = i4;
                this.bitrateAccumulatorMax = d2 / 8.0d;
                int i5 = this.targetBitrateBps;
                if (i5 > 0 && i4 < i5) {
                    this.bitrateAccumulator = (this.bitrateAccumulator * d2) / i5;
                }
            }
            this.targetBitrateBps = i4;
            this.targetFps = i3;
            if (this.bitrateAdjustmentType == BitrateAdjustmentType.FRAMERATE_ADJUSTMENT && i3 > 0) {
                i4 = (i4 * 30) / i3;
                Logging.v(TAG, "setRates: " + i2 + LoadErrorCode.TOKEN_NEXT + (i4 / 1000) + " kbps. Fps: " + this.targetFps);
            } else if (this.bitrateAdjustmentType == BitrateAdjustmentType.DYNAMIC_ADJUSTMENT) {
                Logging.v(TAG, "setRates: " + i2 + " kbps. Fps: " + this.targetFps + ". ExpScale: " + this.bitrateAdjustmentScaleExp);
                int i6 = this.bitrateAdjustmentScaleExp;
                if (i6 != 0) {
                    i4 = (int) (i4 * getBitrateScale(i6));
                }
            } else {
                Logging.v(TAG, "setRates: " + i2 + " kbps. Fps: " + this.targetFps);
            }
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("video-bitrate", i4);
                this.mediaCodec.setParameters(bundle);
                return true;
            } catch (IllegalStateException e2) {
                Logging.e(TAG, "setRates failed", e2);
                return false;
            }
        }
        return invokeII.booleanValue;
    }

    @Nullable
    public static EncoderProperties vp8HwEncoderProperties() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            if (hwEncoderDisabledTypes.contains("video/x-vnd.on2.vp8")) {
                return null;
            }
            return findHwEncoder("video/x-vnd.on2.vp8", vp8HwList(), supportedColorList, 0, 0);
        }
        return (EncoderProperties) invokeV.objValue;
    }

    public static MediaCodecProperties[] vp8HwList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(qcomVp8HwProperties);
            arrayList.add(exynosVp8HwProperties);
            if (PeerConnectionFactory.fieldTrialsFindFullName("WebRTC-IntelVP8").equals(PeerConnectionFactory.TRIAL_ENABLED)) {
                arrayList.add(intelVp8HwProperties);
            }
            return (MediaCodecProperties[]) arrayList.toArray(new MediaCodecProperties[arrayList.size()]);
        }
        return (MediaCodecProperties[]) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void checkKeyFrameRequired(boolean z, long j2) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2)}) == null) {
            long j3 = (j2 + 500) / 1000;
            if (this.lastKeyFrameMs < 0) {
                this.lastKeyFrameMs = j3;
            }
            if (!z) {
                long j4 = this.forcedKeyFrameMs;
                if (j4 > 0 && j3 > this.lastKeyFrameMs + j4) {
                    z2 = true;
                    if (!z || z2) {
                        if (!z) {
                            Logging.d(TAG, "Sync frame request");
                        } else {
                            Logging.d(TAG, "Sync frame forced");
                        }
                        Bundle bundle = new Bundle();
                        bundle.putInt("request-sync", 0);
                        this.mediaCodec.setParameters(bundle);
                        this.lastKeyFrameMs = j3;
                    }
                    return;
                }
            }
            z2 = false;
            if (z) {
            }
            if (!z) {
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("request-sync", 0);
            this.mediaCodec.setParameters(bundle2);
            this.lastKeyFrameMs = j3;
        }
    }

    @CalledByNativeUnchecked
    public int dequeueInputBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            checkOnMediaCodecThread();
            try {
                return this.mediaCodec.dequeueInputBuffer(0L);
            } catch (IllegalStateException e2) {
                Logging.e(TAG, "dequeueIntputBuffer failed", e2);
                return -2;
            }
        }
        return invokeV.intValue;
    }

    @Nullable
    @CalledByNativeUnchecked
    public OutputBufferInfo dequeueOutputBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            checkOnMediaCodecThread();
            try {
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                int dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
                boolean z = true;
                if (dequeueOutputBuffer >= 0) {
                    if ((bufferInfo.flags & 2) != 0) {
                        Logging.d(TAG, "Config frame generated. Offset: " + bufferInfo.offset + ". Size: " + bufferInfo.size);
                        this.configData = ByteBuffer.allocateDirect(bufferInfo.size);
                        this.outputBuffers[dequeueOutputBuffer].position(bufferInfo.offset);
                        this.outputBuffers[dequeueOutputBuffer].limit(bufferInfo.offset + bufferInfo.size);
                        this.configData.put(this.outputBuffers[dequeueOutputBuffer]);
                        String str = "";
                        int i2 = 0;
                        while (true) {
                            if (i2 >= (bufferInfo.size < 8 ? bufferInfo.size : 8)) {
                                break;
                            }
                            str = str + Integer.toHexString(this.configData.get(i2) & 255) + " ";
                            i2++;
                        }
                        Logging.d(TAG, str);
                        this.mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                        dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
                    }
                }
                int i3 = dequeueOutputBuffer;
                if (i3 < 0) {
                    if (i3 == -3) {
                        this.outputBuffers = this.mediaCodec.getOutputBuffers();
                        return dequeueOutputBuffer();
                    } else if (i3 == -2) {
                        return dequeueOutputBuffer();
                    } else {
                        if (i3 == -1) {
                            return null;
                        }
                        throw new RuntimeException("dequeueOutputBuffer: " + i3);
                    }
                }
                ByteBuffer duplicate = this.outputBuffers[i3].duplicate();
                duplicate.position(bufferInfo.offset);
                duplicate.limit(bufferInfo.offset + bufferInfo.size);
                reportEncodedFrame(bufferInfo.size);
                if ((bufferInfo.flags & 1) == 0) {
                    z = false;
                }
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
                    return new OutputBufferInfo(i3, allocateDirect, z, bufferInfo.presentationTimeUs);
                }
                return new OutputBufferInfo(i3, duplicate.slice(), z, bufferInfo.presentationTimeUs);
            } catch (IllegalStateException e2) {
                Logging.e(TAG, "dequeueOutputBuffer failed", e2);
                return new OutputBufferInfo(-1, null, false, -1L);
            }
        }
        return (OutputBufferInfo) invokeV.objValue;
    }

    @CalledByNativeUnchecked
    public boolean encodeBuffer(boolean z, int i2, int i3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)})) == null) {
            checkOnMediaCodecThread();
            try {
                checkKeyFrameRequired(z, j2);
                this.mediaCodec.queueInputBuffer(i2, 0, i3, j2, 0);
                return true;
            } catch (IllegalStateException e2) {
                Logging.e(TAG, "encodeBuffer failed", e2);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    @CalledByNativeUnchecked
    public boolean encodeFrame(long j2, boolean z, VideoFrame videoFrame, int i2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), videoFrame, Integer.valueOf(i2), Long.valueOf(j3)})) == null) {
            checkOnMediaCodecThread();
            try {
                checkKeyFrameRequired(z, j3);
                VideoFrame.Buffer buffer = videoFrame.getBuffer();
                if (buffer instanceof VideoFrame.TextureBuffer) {
                    this.eglBase.makeCurrent();
                    GLES20.glClear(16384);
                    VideoFrameDrawer.drawTexture(this.drawer, (VideoFrame.TextureBuffer) buffer, new Matrix(), this.width, this.height, 0, 0, this.width, this.height);
                    this.eglBase.swapBuffers(TimeUnit.MICROSECONDS.toNanos(j3));
                } else {
                    VideoFrame.I420Buffer i420 = buffer.toI420();
                    int i3 = (this.height + 1) / 2;
                    ByteBuffer dataY = i420.getDataY();
                    ByteBuffer dataU = i420.getDataU();
                    ByteBuffer dataV = i420.getDataV();
                    int strideY = i420.getStrideY();
                    int strideU = i420.getStrideU();
                    int strideV = i420.getStrideV();
                    if (dataY.capacity() >= this.height * strideY) {
                        if (dataU.capacity() >= strideU * i3) {
                            if (dataV.capacity() >= i3 * strideV) {
                                nativeFillInputBuffer(j2, i2, dataY, strideY, dataU, strideU, dataV, strideV);
                                i420.release();
                                this.mediaCodec.queueInputBuffer(i2, 0, ((this.width * this.height) * 3) / 2, j3, 0);
                            } else {
                                throw new RuntimeException("V-plane buffer size too small.");
                            }
                        } else {
                            throw new RuntimeException("U-plane buffer size too small.");
                        }
                    } else {
                        throw new RuntimeException("Y-plane buffer size too small.");
                    }
                }
                return true;
            } catch (RuntimeException e2) {
                Logging.e(TAG, "encodeFrame failed", e2);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    @CalledByNative
    public int getColorFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.colorFormat : invokeV.intValue;
    }

    @CalledByNativeUnchecked
    public ByteBuffer[] getInputBuffers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ByteBuffer[] inputBuffers = this.mediaCodec.getInputBuffers();
            Logging.d(TAG, "Input buffers: " + inputBuffers.length);
            return inputBuffers;
        }
        return (ByteBuffer[]) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0253  */
    @CalledByNativeUnchecked
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean initEncode(VideoCodecType videoCodecType, int i2, int i3, int i4, int i5, int i6, boolean z) {
        InterceptResult invokeCommon;
        boolean z2;
        boolean z3;
        EncoderProperties encoderProperties;
        int i7;
        int parseInt;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{videoCodecType, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z)})) != null) {
            return invokeCommon.booleanValue;
        }
        Logging.d(TAG, "Java initEncode: " + videoCodecType + ". Profile: " + i2 + ZeusCrashHandler.NAME_SEPERATOR + i3 + " x " + i4 + ". @ " + i5 + " kbps. Fps: " + i6 + ". Encode from texture : " + z);
        VIDEO_WIDTH = i3;
        VIDEO_HEIGHT = i4;
        this.profile = i2;
        this.width = i3;
        this.height = i4;
        if (this.mediaCodecThread == null) {
            int i8 = 100;
            String str = "video/x-vnd.on2.vp9";
            if (videoCodecType == VideoCodecType.VIDEO_CODEC_VP8) {
                encoderProperties = findHwEncoder("video/x-vnd.on2.vp8", vp8HwList(), z ? supportedSurfaceColorList : supportedColorList, i3, i4);
                str = "video/x-vnd.on2.vp8";
            } else if (videoCodecType == VideoCodecType.VIDEO_CODEC_VP9) {
                encoderProperties = findHwEncoder("video/x-vnd.on2.vp9", vp9HwList, z ? supportedSurfaceColorList : supportedColorList, i3, i4);
            } else if (videoCodecType == VideoCodecType.VIDEO_CODEC_H264) {
                EncoderProperties findHwEncoder = findHwEncoder("video/avc", h264HwList(), z ? supportedSurfaceColorList : supportedColorList, i3, i4);
                if (i2 == H264Profile.CONSTRAINED_HIGH.getValue()) {
                    if (findHwEncoder("video/avc", h264HighProfileHwList, z ? supportedSurfaceColorList : supportedColorList, i3, i4) != null) {
                        Logging.d(TAG, "High profile H.264 encoder supported.");
                        z2 = true;
                        i8 = 20;
                        str = "video/avc";
                        z3 = z2;
                        encoderProperties = findHwEncoder;
                        if (encoderProperties != null) {
                            runningInstance = this;
                            this.colorFormat = encoderProperties.colorFormat;
                            BitrateAdjustmentType bitrateAdjustmentType = encoderProperties.bitrateAdjustmentType;
                            this.bitrateAdjustmentType = bitrateAdjustmentType;
                            int min = bitrateAdjustmentType != BitrateAdjustmentType.FRAMERATE_ADJUSTMENT ? Math.min(i6, 30) : 30;
                            this.forcedKeyFrameMs = 0L;
                            this.lastKeyFrameMs = -1L;
                            if (videoCodecType == VideoCodecType.VIDEO_CODEC_VP8 && encoderProperties.codecName.startsWith(qcomVp8HwProperties.codecPrefix)) {
                                int i9 = Build.VERSION.SDK_INT;
                                i7 = min;
                                if (i9 == 21 || i9 == 22) {
                                    this.forcedKeyFrameMs = 15000L;
                                } else if (i9 == 23) {
                                    this.forcedKeyFrameMs = 20000L;
                                } else if (i9 > 23) {
                                    this.forcedKeyFrameMs = 15000L;
                                }
                            } else {
                                i7 = min;
                            }
                            if (!TextUtils.isEmpty(this.bitrateModePreset) && ((parseInt = Integer.parseInt(this.bitrateModePreset)) == 0 || parseInt == 1 || parseInt == 2)) {
                                bitrateMode = parseInt;
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append("Color format: ");
                            sb.append(this.colorFormat);
                            sb.append(". Bitrate adjustment: ");
                            sb.append(this.bitrateAdjustmentType);
                            sb.append(". Key frame interval: ");
                            sb.append(this.forcedKeyFrameMs);
                            sb.append(" . Initial fps: ");
                            int i10 = i7;
                            sb.append(i10);
                            sb.append(". BitrateMode: ");
                            sb.append(bitrateMode);
                            Logging.d(TAG, sb.toString());
                            int i11 = i5 * 1000;
                            this.targetBitrateBps = i11;
                            this.targetFps = i10;
                            this.bitrateAccumulatorMax = i11 / 8.0d;
                            this.bitrateAccumulator = 0.0d;
                            this.bitrateObservationTimeMs = 0.0d;
                            this.bitrateAdjustmentScaleExp = 0;
                            this.mediaCodecThread = Thread.currentThread();
                            try {
                                MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, i3, i4);
                                createVideoFormat.setInteger("bitrate", this.targetBitrateBps);
                                createVideoFormat.setInteger(HardwareVideoEncoder.KEY_BITRATE_MODE, bitrateMode);
                                createVideoFormat.setInteger("color-format", encoderProperties.colorFormat);
                                createVideoFormat.setInteger("frame-rate", this.targetFps);
                                createVideoFormat.setInteger("i-frame-interval", i8);
                                if (z3) {
                                    createVideoFormat.setInteger("profile", 8);
                                    createVideoFormat.setInteger("level", 256);
                                }
                                Logging.d(TAG, "  Format: " + createVideoFormat);
                                MediaCodec createByCodecName = createByCodecName(encoderProperties.codecName);
                                this.mediaCodec = createByCodecName;
                                this.type = videoCodecType;
                                if (createByCodecName == null) {
                                    Logging.e(TAG, "Can not create media encoder");
                                    release();
                                    return false;
                                }
                                createByCodecName.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                                if (z) {
                                    this.eglBase = new EglBase14((EglBase14.Context) getEglContext(), EglBase.CONFIG_RECORDABLE);
                                    Surface createInputSurface = this.mediaCodec.createInputSurface();
                                    this.inputSurface = createInputSurface;
                                    this.eglBase.createSurface(createInputSurface);
                                    this.drawer = new GlRectDrawer();
                                }
                                this.mediaCodec.start();
                                this.outputBuffers = this.mediaCodec.getOutputBuffers();
                                Logging.d(TAG, "Output buffers: " + this.outputBuffers.length);
                                return true;
                            } catch (IllegalStateException e2) {
                                Logging.e(TAG, "initEncode failed", e2);
                                release();
                                return false;
                            }
                        }
                        throw new RuntimeException("Can not find HW encoder for " + videoCodecType);
                    }
                    Logging.d(TAG, "High profile H.264 encoder requested, but not supported. Use baseline.");
                }
                z2 = false;
                i8 = 20;
                str = "video/avc";
                z3 = z2;
                encoderProperties = findHwEncoder;
                if (encoderProperties != null) {
                }
            } else {
                throw new RuntimeException("initEncode: Non-supported codec " + videoCodecType);
            }
            z3 = false;
            if (encoderProperties != null) {
            }
        } else {
            throw new RuntimeException("Forgot to release()?");
        }
    }

    @CalledByNativeUnchecked
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Logging.d(TAG, "Java releaseEncoder");
            checkOnMediaCodecThread();
            C1CaughtException c1CaughtException = new C1CaughtException(this);
            boolean z = false;
            if (this.mediaCodec != null) {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                new Thread(new Runnable(this, c1CaughtException, countDownLatch) { // from class: org.webrtc.MediaCodecVideoEncoder.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaCodecVideoEncoder this$0;
                    public final /* synthetic */ C1CaughtException val$caughtException;
                    public final /* synthetic */ CountDownLatch val$releaseDone;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, c1CaughtException, countDownLatch};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$caughtException = c1CaughtException;
                        this.val$releaseDone = countDownLatch;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Logging.d(MediaCodecVideoEncoder.TAG, "Java releaseEncoder on release thread");
                            try {
                                this.this$0.mediaCodec.stop();
                            } catch (Exception e2) {
                                Logging.e(MediaCodecVideoEncoder.TAG, "Media encoder stop failed", e2);
                            }
                            try {
                                this.this$0.mediaCodec.release();
                            } catch (Exception e3) {
                                Logging.e(MediaCodecVideoEncoder.TAG, "Media encoder release failed", e3);
                                this.val$caughtException.f62659e = e3;
                            }
                            Logging.d(MediaCodecVideoEncoder.TAG, "Java releaseEncoder on release thread done");
                            this.val$releaseDone.countDown();
                        }
                    }
                }).start();
                if (!ThreadUtils.awaitUninterruptibly(countDownLatch, 5000L)) {
                    Logging.e(TAG, "Media encoder release timeout");
                    z = true;
                }
                this.mediaCodec = null;
            }
            this.mediaCodecThread = null;
            GlRectDrawer glRectDrawer = this.drawer;
            if (glRectDrawer != null) {
                glRectDrawer.release();
                this.drawer = null;
            }
            EglBase14 eglBase14 = this.eglBase;
            if (eglBase14 != null) {
                eglBase14.release();
                this.eglBase = null;
            }
            Surface surface = this.inputSurface;
            if (surface != null) {
                surface.release();
                this.inputSurface = null;
            }
            runningInstance = null;
            if (z) {
                codecErrors++;
                if (errorCallback != null) {
                    Logging.e(TAG, "Invoke codec error callback. Errors: " + codecErrors);
                    errorCallback.onMediaCodecVideoEncoderCriticalError(codecErrors);
                }
                throw new RuntimeException("Media encoder release timeout.");
            } else if (c1CaughtException.f62659e == null) {
                Logging.d(TAG, "Java releaseEncoder done");
            } else {
                RuntimeException runtimeException = new RuntimeException(c1CaughtException.f62659e);
                runtimeException.setStackTrace(ThreadUtils.concatStackTraces(c1CaughtException.f62659e.getStackTrace(), runtimeException.getStackTrace()));
                throw runtimeException;
            }
        }
    }

    @CalledByNativeUnchecked
    public boolean releaseOutputBuffer(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            checkOnMediaCodecThread();
            try {
                this.mediaCodec.releaseOutputBuffer(i2, false);
                return true;
            } catch (IllegalStateException e2) {
                Logging.e(TAG, "releaseOutputBuffer failed", e2);
                return false;
            }
        }
        return invokeI.booleanValue;
    }
}
