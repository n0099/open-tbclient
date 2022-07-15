package org.webrtc;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.SystemClock;
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
import com.baidu.ugc.editvideo.record.RecordConstants;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.repackage.mr9;
import com.repackage.pr9;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.webrtc.EglBase;
import org.webrtc.VideoFrame;
@Deprecated
/* loaded from: classes8.dex */
public class MediaCodecVideoDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
    public static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar16m4ka = 2141391874;
    public static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar32m4ka = 2141391873;
    public static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar64x32Tile2m8ka = 2141391875;
    public static final int DEQUEUE_INPUT_TIMEOUT = 500000;
    public static final String FORMAT_KEY_CROP_BOTTOM = "crop-bottom";
    public static final String FORMAT_KEY_CROP_LEFT = "crop-left";
    public static final String FORMAT_KEY_CROP_RIGHT = "crop-right";
    public static final String FORMAT_KEY_CROP_TOP = "crop-top";
    public static final String FORMAT_KEY_SLICE_HEIGHT = "slice-height";
    public static final String FORMAT_KEY_STRIDE = "stride";
    public static final String H264_MIME_TYPE = "video/avc";
    public static final long MAX_DECODE_TIME_MS = 200;
    public static final int MAX_QUEUED_OUTPUTBUFFERS = 3;
    public static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    public static final String TAG = "MediaCodecVideoDecoder";
    public static final String VP8_MIME_TYPE = "video/x-vnd.on2.vp8";
    public static final String VP9_MIME_TYPE = "video/x-vnd.on2.vp9";
    public static int codecErrors = 0;
    @Nullable
    public static EglBase eglBase = null;
    @Nullable
    public static MediaCodecVideoDecoderErrorCallback errorCallback = null;
    public static Set<String> hwDecoderDisabledTypes = null;
    @Nullable
    public static MediaCodecVideoDecoder runningInstance = null;
    public static final List<Integer> supportedColorList;
    public static final String supportedExynosH264HighProfileHwCodecPrefix = "OMX.Exynos.";
    public static final String supportedHisiH264HighProfileHwCodecPrefix = "OMX.hisi.";
    public static final String supportedMediaTekH264HighProfileHwCodecPrefix = "OMX.MTK.";
    public static final String supportedQcomH264HighProfileHwCodecPrefix = "OMX.qcom.";
    public static final String[] supportedVp9HwCodecPrefixes;
    @Nullable
    public static MediaCodecVideoDecoderObserver videoDecoderObserver;
    public transient /* synthetic */ FieldHolder $fh;
    public int colorFormat;
    public final Queue<TimeStamps> decodeStartTimeMs;
    public final Queue<DecodedOutputBuffer> dequeuedSurfaceOutputBuffers;
    public int droppedFrames;
    public boolean hasDecodedFirstFrame;
    public int height;
    public ByteBuffer[] inputBuffers;
    @Nullable
    public MediaCodec mediaCodec;
    @Nullable
    public Thread mediaCodecThread;
    public ByteBuffer[] outputBuffers;
    public int sliceHeight;
    public int stride;
    @Nullable
    public Surface surface;
    @Nullable
    public TextureListener textureListener;
    public int width;

    /* loaded from: classes8.dex */
    public static class DecodedOutputBuffer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long decodeTimeMs;
        public final long endDecodeTimeMs;
        public final int index;
        public final long ntpTimeStampMs;
        public final int offset;
        public final long presentationTimeStampMs;
        public final int size;
        public final long timeStampMs;

        public DecodedOutputBuffer(int i, int i2, int i3, long j, long j2, long j3, long j4, long j5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r4;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.index = i;
            this.offset = i2;
            this.size = i3;
            this.presentationTimeStampMs = j;
            this.timeStampMs = j2;
            this.ntpTimeStampMs = j3;
            this.decodeTimeMs = j4;
            this.endDecodeTimeMs = j5;
        }

        @CalledByNative("DecodedOutputBuffer")
        public long getDecodeTimeMs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.decodeTimeMs : invokeV.longValue;
        }

        @CalledByNative("DecodedOutputBuffer")
        public int getIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.index : invokeV.intValue;
        }

        @CalledByNative("DecodedOutputBuffer")
        public long getNtpTimestampMs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.ntpTimeStampMs : invokeV.longValue;
        }

        @CalledByNative("DecodedOutputBuffer")
        public int getOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.offset : invokeV.intValue;
        }

        @CalledByNative("DecodedOutputBuffer")
        public long getPresentationTimestampMs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.presentationTimeStampMs : invokeV.longValue;
        }

        @CalledByNative("DecodedOutputBuffer")
        public int getSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.size : invokeV.intValue;
        }

        @CalledByNative("DecodedOutputBuffer")
        public long getTimestampMs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.timeStampMs : invokeV.longValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class DecodedTextureBuffer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long decodeTimeMs;
        public final long frameDelayMs;
        public final long ntpTimeStampMs;
        public final long presentationTimeStampMs;
        public final long timeStampMs;
        public final VideoFrame.Buffer videoFrameBuffer;

        public DecodedTextureBuffer(VideoFrame.Buffer buffer, long j, long j2, long j3, long j4, long j5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buffer, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.videoFrameBuffer = buffer;
            this.presentationTimeStampMs = j;
            this.timeStampMs = j2;
            this.ntpTimeStampMs = j3;
            this.decodeTimeMs = j4;
            this.frameDelayMs = j5;
        }

        @CalledByNative("DecodedTextureBuffer")
        public long getDecodeTimeMs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.decodeTimeMs : invokeV.longValue;
        }

        @CalledByNative("DecodedTextureBuffer")
        public long getFrameDelayMs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.frameDelayMs : invokeV.longValue;
        }

        @CalledByNative("DecodedTextureBuffer")
        public long getNtpTimestampMs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.ntpTimeStampMs : invokeV.longValue;
        }

        @CalledByNative("DecodedTextureBuffer")
        public long getPresentationTimestampMs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.presentationTimeStampMs : invokeV.longValue;
        }

        @CalledByNative("DecodedTextureBuffer")
        public long getTimeStampMs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.timeStampMs : invokeV.longValue;
        }

        @CalledByNative("DecodedTextureBuffer")
        public VideoFrame.Buffer getVideoFrameBuffer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.videoFrameBuffer : (VideoFrame.Buffer) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class DecoderProperties {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String codecName;
        public final int colorFormat;

        public DecoderProperties(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.codecName = str;
            this.colorFormat = i;
        }
    }

    /* loaded from: classes8.dex */
    public static class HwDecoderFactory implements VideoDecoderFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final VideoCodecInfo[] supportedHardwareCodecs;

        public HwDecoderFactory() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (MediaCodecVideoDecoder.isVp8HwSupported()) {
                    Logging.d(MediaCodecVideoDecoder.TAG, "VP8 HW Decoder supported.");
                    arrayList.add(new VideoCodecInfo(PeerConnectionClient.VIDEO_CODEC_VP8, new HashMap()));
                }
                if (MediaCodecVideoDecoder.isVp9HwSupported()) {
                    Logging.d(MediaCodecVideoDecoder.TAG, "VP9 HW Decoder supported.");
                    arrayList.add(new VideoCodecInfo(PeerConnectionClient.VIDEO_CODEC_VP9, new HashMap()));
                }
                if (MediaCodecVideoDecoder.isH264HighProfileHwSupported()) {
                    Logging.d(MediaCodecVideoDecoder.TAG, "H.264 High Profile HW Decoder supported.");
                    arrayList.add(H264Utils.DEFAULT_H264_HIGH_PROFILE_CODEC);
                }
                if (MediaCodecVideoDecoder.isH264HwSupported()) {
                    Logging.d(MediaCodecVideoDecoder.TAG, "H.264 HW Decoder supported.");
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

        @Override // org.webrtc.VideoDecoderFactory
        @javax.annotation.Nullable
        @Deprecated
        public /* synthetic */ VideoDecoder createDecoder(String str) {
            return pr9.$default$createDecoder(this, str);
        }

        @Override // org.webrtc.VideoDecoderFactory
        @Nullable
        public VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoCodecInfo)) == null) {
                if (!isCodecSupported(this.supportedHardwareCodecs, videoCodecInfo)) {
                    Logging.d(MediaCodecVideoDecoder.TAG, "No HW video decoder for codec " + videoCodecInfo.name);
                    return null;
                }
                Logging.d(MediaCodecVideoDecoder.TAG, "Create HW video decoder for " + videoCodecInfo.name);
                return new WrappedNativeVideoDecoder(this, videoCodecInfo) { // from class: org.webrtc.MediaCodecVideoDecoder.HwDecoderFactory.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ HwDecoderFactory this$0;
                    public final /* synthetic */ VideoCodecInfo val$codec;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, videoCodecInfo};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$codec = videoCodecInfo;
                    }

                    @Override // org.webrtc.WrappedNativeVideoDecoder, org.webrtc.VideoDecoder
                    public long createNativeVideoDecoder() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? MediaCodecVideoDecoder.nativeCreateDecoder(this.val$codec.name, MediaCodecVideoDecoder.useSurface()) : invokeV.longValue;
                    }
                };
            }
            return (VideoDecoder) invokeL.objValue;
        }

        @Override // org.webrtc.VideoDecoderFactory
        public VideoCodecInfo[] getSupportedCodecs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.supportedHardwareCodecs : (VideoCodecInfo[]) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface MediaCodecVideoDecoderErrorCallback {
        void onMediaCodecVideoDecoderCriticalError(int i);
    }

    /* loaded from: classes8.dex */
    public interface MediaCodecVideoDecoderObserver {
        void onSEIRecv(ByteBuffer byteBuffer);
    }

    /* loaded from: classes8.dex */
    public class TextureListener implements VideoSink {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public DecodedOutputBuffer bufferToRender;
        public final Object newFrameLock;
        @Nullable
        public DecodedTextureBuffer renderedBuffer;
        public final SurfaceTextureHelper surfaceTextureHelper;
        public final /* synthetic */ MediaCodecVideoDecoder this$0;

        public TextureListener(MediaCodecVideoDecoder mediaCodecVideoDecoder, SurfaceTextureHelper surfaceTextureHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaCodecVideoDecoder, surfaceTextureHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaCodecVideoDecoder;
            this.newFrameLock = new Object();
            this.surfaceTextureHelper = surfaceTextureHelper;
            surfaceTextureHelper.startListening(this);
        }

        public void addBufferToRender(DecodedOutputBuffer decodedOutputBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, decodedOutputBuffer) == null) {
                if (this.bufferToRender == null) {
                    this.bufferToRender = decodedOutputBuffer;
                } else {
                    Logging.e(MediaCodecVideoDecoder.TAG, "Unexpected addBufferToRender() called while waiting for a texture.");
                    throw new IllegalStateException("Waiting for a texture.");
                }
            }
        }

        @Nullable
        public DecodedTextureBuffer dequeueTextureBuffer(int i) {
            InterceptResult invokeI;
            DecodedTextureBuffer decodedTextureBuffer;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                synchronized (this.newFrameLock) {
                    if (this.renderedBuffer == null && i > 0 && isWaitingForTexture()) {
                        try {
                            this.newFrameLock.wait(i);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    decodedTextureBuffer = this.renderedBuffer;
                    this.renderedBuffer = null;
                }
                return decodedTextureBuffer;
            }
            return (DecodedTextureBuffer) invokeI.objValue;
        }

        public boolean isWaitingForTexture() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                synchronized (this.newFrameLock) {
                    z = this.bufferToRender != null;
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        @Override // org.webrtc.VideoSink
        public void onFrame(VideoFrame videoFrame) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, videoFrame) == null) {
                synchronized (this.newFrameLock) {
                    if (this.renderedBuffer == null) {
                        VideoFrame.Buffer buffer = videoFrame.getBuffer();
                        buffer.retain();
                        this.renderedBuffer = new DecodedTextureBuffer(buffer, this.bufferToRender.presentationTimeStampMs, this.bufferToRender.timeStampMs, this.bufferToRender.ntpTimeStampMs, this.bufferToRender.decodeTimeMs, SystemClock.elapsedRealtime() - this.bufferToRender.endDecodeTimeMs);
                        this.bufferToRender = null;
                        this.newFrameLock.notifyAll();
                    } else {
                        Logging.e(MediaCodecVideoDecoder.TAG, "Unexpected onFrame() called while already holding a texture.");
                        throw new IllegalStateException("Already holding a texture.");
                    }
                }
            }
        }

        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.surfaceTextureHelper.stopListening();
                synchronized (this.newFrameLock) {
                    if (this.renderedBuffer != null) {
                        this.renderedBuffer.getVideoFrameBuffer().release();
                        this.renderedBuffer = null;
                    }
                }
                this.surfaceTextureHelper.dispose();
            }
        }

        public void setSize(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
                this.surfaceTextureHelper.setTextureSize(i, i2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class TimeStamps {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long decodeStartTimeMs;
        public final long ntpTimeStampMs;
        public final long timeStampMs;

        public TimeStamps(long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.decodeStartTimeMs = j;
            this.timeStampMs = j2;
            this.ntpTimeStampMs = j3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(134722568, "Lorg/webrtc/MediaCodecVideoDecoder$VideoCodecType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(134722568, "Lorg/webrtc/MediaCodecVideoDecoder$VideoCodecType;");
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

        public VideoCodecType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @CalledByNative("VideoCodecType")
        public static VideoCodecType fromNativeIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? values()[i] : (VideoCodecType) invokeI.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(384792789, "Lorg/webrtc/MediaCodecVideoDecoder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(384792789, "Lorg/webrtc/MediaCodecVideoDecoder;");
                return;
            }
        }
        hwDecoderDisabledTypes = new HashSet();
        supportedVp9HwCodecPrefixes = new String[]{"OMX.qcom.", "OMX.Exynos."};
        supportedColorList = Arrays.asList(19, 21, 2141391872, 2141391873, 2141391874, 2141391875, 2141391876);
    }

    @CalledByNative
    public MediaCodecVideoDecoder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.decodeStartTimeMs = new ArrayDeque();
        this.dequeuedSurfaceOutputBuffers = new ArrayDeque();
    }

    private void MaybeRenderDecodedTextureBuffer() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.dequeuedSurfaceOutputBuffers.isEmpty() || this.textureListener.isWaitingForTexture()) {
            return;
        }
        DecodedOutputBuffer remove = this.dequeuedSurfaceOutputBuffers.remove();
        this.textureListener.addBufferToRender(remove);
        this.mediaCodec.releaseOutputBuffer(remove.index, true);
    }

    private void checkOnMediaCodecThread() throws IllegalStateException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || this.mediaCodecThread.getId() == Thread.currentThread().getId()) {
            return;
        }
        throw new IllegalStateException("MediaCodecVideoDecoder previously operated on " + this.mediaCodecThread + " but is now called on " + Thread.currentThread());
    }

    public static VideoDecoderFactory createFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? new DefaultVideoDecoderFactory(new HwDecoderFactory()) : (VideoDecoderFactory) invokeV.objValue;
    }

    @CalledByNativeUnchecked
    private int dequeueInputBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            checkOnMediaCodecThread();
            try {
                return this.mediaCodec.dequeueInputBuffer(500000L);
            } catch (IllegalStateException e) {
                Logging.e(TAG, "dequeueIntputBuffer failed", e);
                return -2;
            }
        }
        return invokeV.intValue;
    }

    @Nullable
    @CalledByNativeUnchecked
    private DecodedOutputBuffer dequeueOutputBuffer(int i) {
        InterceptResult invokeI;
        long j;
        int integer;
        int integer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i)) == null) {
            checkOnMediaCodecThread();
            if (this.decodeStartTimeMs.isEmpty()) {
                return null;
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            while (true) {
                int dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, TimeUnit.MILLISECONDS.toMicros(i));
                if (dequeueOutputBuffer == -3) {
                    this.outputBuffers = this.mediaCodec.getOutputBuffers();
                    Logging.d(TAG, "Decoder output buffers changed: " + this.outputBuffers.length);
                    if (this.hasDecodedFirstFrame) {
                        throw new RuntimeException("Unexpected output buffer change event.");
                    }
                } else if (dequeueOutputBuffer != -2) {
                    if (dequeueOutputBuffer != -1) {
                        this.hasDecodedFirstFrame = true;
                        TimeStamps remove = this.decodeStartTimeMs.remove();
                        long elapsedRealtime = SystemClock.elapsedRealtime() - remove.decodeStartTimeMs;
                        if (elapsedRealtime > 200) {
                            Logging.e(TAG, "Very high decode time: " + elapsedRealtime + "ms. Q size: " + this.decodeStartTimeMs.size() + ". Might be caused by resuming H264 decoding after a pause.");
                            j = 200L;
                        } else {
                            j = elapsedRealtime;
                        }
                        return new DecodedOutputBuffer(dequeueOutputBuffer, bufferInfo.offset, bufferInfo.size, TimeUnit.MICROSECONDS.toMillis(bufferInfo.presentationTimeUs), remove.timeStampMs, remove.ntpTimeStampMs, j, SystemClock.elapsedRealtime());
                    }
                    return null;
                } else {
                    MediaFormat outputFormat = this.mediaCodec.getOutputFormat();
                    Logging.d(TAG, "Decoder format changed: " + outputFormat.toString());
                    if (outputFormat.containsKey("crop-left") && outputFormat.containsKey("crop-right") && outputFormat.containsKey("crop-bottom") && outputFormat.containsKey("crop-top")) {
                        integer = (outputFormat.getInteger("crop-right") + 1) - outputFormat.getInteger("crop-left");
                        integer2 = (outputFormat.getInteger("crop-bottom") + 1) - outputFormat.getInteger("crop-top");
                    } else {
                        integer = outputFormat.getInteger("width");
                        integer2 = outputFormat.getInteger("height");
                    }
                    if (!this.hasDecodedFirstFrame || (integer == this.width && integer2 == this.height)) {
                        this.width = integer;
                        this.height = integer2;
                        TextureListener textureListener = this.textureListener;
                        if (textureListener != null) {
                            textureListener.setSize(integer, integer2);
                        }
                        if (!useSurface() && outputFormat.containsKey("color-format")) {
                            this.colorFormat = outputFormat.getInteger("color-format");
                            Logging.d(TAG, "Color: 0x" + Integer.toHexString(this.colorFormat));
                            if (!supportedColorList.contains(Integer.valueOf(this.colorFormat))) {
                                throw new IllegalStateException("Non supported color format: " + this.colorFormat);
                            }
                        }
                        if (outputFormat.containsKey("stride")) {
                            this.stride = outputFormat.getInteger("stride");
                        }
                        if (outputFormat.containsKey("slice-height")) {
                            this.sliceHeight = outputFormat.getInteger("slice-height");
                        }
                        if (Build.MODEL.contains("NV2001")) {
                            if (this.sliceHeight == 360) {
                                this.sliceHeight = 368;
                            }
                            if (this.sliceHeight == 540) {
                                this.sliceHeight = RecordConstants.VIDEO_CONSTANT_WIDTH_OLD;
                            }
                        }
                        Logging.d(TAG, "Frame stride and slice height: " + this.stride + " x " + this.sliceHeight);
                        this.stride = Math.max(this.width, this.stride);
                        this.sliceHeight = Math.max(this.height, this.sliceHeight);
                    }
                }
            }
            throw new RuntimeException("Unexpected size change. Configured " + this.width + "*" + this.height + ". New " + integer + "*" + integer2);
        }
        return (DecodedOutputBuffer) invokeI.objValue;
    }

    @Nullable
    @CalledByNativeUnchecked
    private DecodedTextureBuffer dequeueTextureBuffer(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, this, i)) == null) {
            checkOnMediaCodecThread();
            if (useSurface()) {
                DecodedOutputBuffer dequeueOutputBuffer = dequeueOutputBuffer(i);
                if (dequeueOutputBuffer != null) {
                    this.dequeuedSurfaceOutputBuffers.add(dequeueOutputBuffer);
                }
                MaybeRenderDecodedTextureBuffer();
                DecodedTextureBuffer dequeueTextureBuffer = this.textureListener.dequeueTextureBuffer(i);
                if (dequeueTextureBuffer != null) {
                    MaybeRenderDecodedTextureBuffer();
                    return dequeueTextureBuffer;
                } else if (this.dequeuedSurfaceOutputBuffers.size() >= Math.min(3, this.outputBuffers.length) || (i > 0 && !this.dequeuedSurfaceOutputBuffers.isEmpty())) {
                    this.droppedFrames++;
                    DecodedOutputBuffer remove = this.dequeuedSurfaceOutputBuffers.remove();
                    if (i > 0) {
                        Logging.w(TAG, "Draining decoder. Dropping frame with TS: " + remove.presentationTimeStampMs + ". Total number of dropped frames: " + this.droppedFrames);
                    } else {
                        Logging.w(TAG, "Too many output buffers " + this.dequeuedSurfaceOutputBuffers.size() + ". Dropping frame with TS: " + remove.presentationTimeStampMs + ". Total number of dropped frames: " + this.droppedFrames);
                    }
                    this.mediaCodec.releaseOutputBuffer(remove.index, false);
                    return new DecodedTextureBuffer(null, remove.presentationTimeStampMs, remove.timeStampMs, remove.ntpTimeStampMs, remove.decodeTimeMs, SystemClock.elapsedRealtime() - remove.endDecodeTimeMs);
                } else {
                    return null;
                }
            }
            throw new IllegalStateException("dequeueTexture() called for byte buffer decoding.");
        }
        return (DecodedTextureBuffer) invokeI.objValue;
    }

    public static void disableH264HwCodec() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            Logging.w(TAG, "H.264 decoding is disabled by application.");
            hwDecoderDisabledTypes.add("video/avc");
        }
    }

    public static void disableVp8HwCodec() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            Logging.w(TAG, "VP8 decoding is disabled by application.");
            hwDecoderDisabledTypes.add("video/x-vnd.on2.vp8");
        }
    }

    public static void disableVp9HwCodec() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            Logging.w(TAG, "VP9 decoding is disabled by application.");
            hwDecoderDisabledTypes.add("video/x-vnd.on2.vp9");
        }
    }

    public static void disposeEglContext() {
        EglBase eglBase2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, null) == null) || (eglBase2 = eglBase) == null) {
            return;
        }
        eglBase2.release();
        eglBase = null;
    }

    @Nullable
    public static DecoderProperties findDecoder(String str, String[] strArr) {
        InterceptResult invokeLL;
        MediaCodecInfo mediaCodecInfo;
        String str2;
        boolean z;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, strArr)) == null) {
            if (Build.VERSION.SDK_INT < 19) {
                return null;
            }
            Logging.d(TAG, "Trying to find HW decoder for mime " + str);
            for (int i = 0; i < MediaCodecList.getCodecCount(); i++) {
                try {
                    mediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
                } catch (IllegalArgumentException e) {
                    Logging.e(TAG, "Cannot retrieve decoder codec info", e);
                    mediaCodecInfo = null;
                }
                if (mediaCodecInfo != null && !mediaCodecInfo.isEncoder()) {
                    String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            str2 = null;
                            break;
                        } else if (supportedTypes[i2].equals(str)) {
                            str2 = mediaCodecInfo.getName();
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (str2 == null) {
                        continue;
                    } else {
                        Logging.d(TAG, "Found candidate decoder " + str2);
                        int length2 = strArr.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length2) {
                                z = false;
                                break;
                            } else if (str2.startsWith(strArr[i3])) {
                                z = true;
                                break;
                            } else {
                                i3++;
                            }
                        }
                        if (z) {
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                                for (int i4 : capabilitiesForType.colorFormats) {
                                    Logging.v(TAG, "   Color: 0x" + Integer.toHexString(i4));
                                }
                                for (Integer num : supportedColorList) {
                                    int intValue = num.intValue();
                                    int[] iArr2 = capabilitiesForType.colorFormats;
                                    int length3 = iArr2.length;
                                    for (int i5 = 0; i5 < length3; i5++) {
                                        int i6 = iArr2[i5];
                                        if (i6 == intValue) {
                                            Logging.d(TAG, "Found target decoder " + str2 + ". Color: 0x" + Integer.toHexString(i6));
                                            if (Build.MODEL.contains("NV2001") || ((Build.MODEL.contains("Y13") || Build.MODEL.contains("R7")) && Build.MANUFACTURER.contains("rockchip"))) {
                                                i6 = 21;
                                                Logging.d(TAG, "On Duer NV2001 .  enforce Color: 0x" + Integer.toHexString(21));
                                            }
                                            return new DecoderProperties(str2, i6);
                                        }
                                    }
                                }
                                continue;
                            } catch (IllegalArgumentException e2) {
                                Logging.e(TAG, "Cannot retrieve decoder capabilities", e2);
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            Logging.d(TAG, "No HW decoder found for mime " + str);
            return null;
        }
        return (DecoderProperties) invokeLL.objValue;
    }

    @CalledByNativeUnchecked
    private void foundSei(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, this, byteBuffer) == null) || byteBuffer == null) {
            return;
        }
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.capacity());
        byteBuffer.rewind();
        allocate.put(byteBuffer);
        byteBuffer.rewind();
        allocate.flip();
        MediaCodecVideoDecoderObserver mediaCodecVideoDecoderObserver = videoDecoderObserver;
        if (mediaCodecVideoDecoderObserver != null) {
            mediaCodecVideoDecoderObserver.onSEIRecv(allocate);
        }
    }

    @CalledByNativeUnchecked
    private boolean initDecode(VideoCodecType videoCodecType, int i, int i2) {
        InterceptResult invokeLII;
        String[] supportedH264HwCodecPrefixes;
        String str;
        SurfaceTextureHelper create;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65552, this, videoCodecType, i, i2)) == null) {
            if (this.mediaCodecThread == null) {
                if (videoCodecType == VideoCodecType.VIDEO_CODEC_VP8) {
                    supportedH264HwCodecPrefixes = supportedVp8HwCodecPrefixes();
                    str = "video/x-vnd.on2.vp8";
                } else if (videoCodecType == VideoCodecType.VIDEO_CODEC_VP9) {
                    supportedH264HwCodecPrefixes = supportedVp9HwCodecPrefixes;
                    str = "video/x-vnd.on2.vp9";
                } else if (videoCodecType == VideoCodecType.VIDEO_CODEC_H264) {
                    supportedH264HwCodecPrefixes = supportedH264HwCodecPrefixes();
                    str = "video/avc";
                } else {
                    throw new RuntimeException("initDecode: Non-supported codec " + videoCodecType);
                }
                DecoderProperties findDecoder = findDecoder(str, supportedH264HwCodecPrefixes);
                if (findDecoder != null) {
                    Logging.d(TAG, "Java initDecode: " + videoCodecType + ZeusCrashHandler.NAME_SEPERATOR + i + " x " + i2 + ". Color: 0x" + Integer.toHexString(findDecoder.colorFormat) + ". Use Surface: " + useSurface());
                    runningInstance = this;
                    this.mediaCodecThread = Thread.currentThread();
                    try {
                        this.width = i;
                        this.height = i2;
                        this.stride = i;
                        this.sliceHeight = i2;
                        if (useSurface() && (create = SurfaceTextureHelper.create("Decoder SurfaceTextureHelper", eglBase.getEglBaseContext())) != null) {
                            TextureListener textureListener = new TextureListener(this, create);
                            this.textureListener = textureListener;
                            textureListener.setSize(i, i2);
                            this.surface = new Surface(create.getSurfaceTexture());
                        }
                        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, i, i2);
                        if (!useSurface()) {
                            createVideoFormat.setInteger("color-format", findDecoder.colorFormat);
                        }
                        Logging.d(TAG, "  Format: " + createVideoFormat);
                        MediaCodec createByCodecName = MediaCodecVideoEncoder.createByCodecName(findDecoder.codecName);
                        this.mediaCodec = createByCodecName;
                        if (createByCodecName == null) {
                            Logging.e(TAG, "Can not create media decoder");
                            return false;
                        }
                        createByCodecName.configure(createVideoFormat, this.surface, (MediaCrypto) null, 0);
                        this.mediaCodec.start();
                        this.colorFormat = findDecoder.colorFormat;
                        this.outputBuffers = this.mediaCodec.getOutputBuffers();
                        this.inputBuffers = this.mediaCodec.getInputBuffers();
                        this.decodeStartTimeMs.clear();
                        this.hasDecodedFirstFrame = false;
                        this.dequeuedSurfaceOutputBuffers.clear();
                        this.droppedFrames = 0;
                        Logging.d(TAG, "Input buffers: " + this.inputBuffers.length + ". Output buffers: " + this.outputBuffers.length);
                        return true;
                    } catch (IllegalStateException e) {
                        Logging.e(TAG, "initDecode failed", e);
                        return false;
                    }
                }
                throw new RuntimeException("Cannot find HW decoder for " + videoCodecType);
            }
            throw new RuntimeException("initDecode: Forgot to release()?");
        }
        return invokeLII.booleanValue;
    }

    public static boolean isH264HighProfileHwSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            if (hwDecoderDisabledTypes.contains("video/avc")) {
                return false;
            }
            if (Build.VERSION.SDK_INT < 21 || findDecoder("video/avc", new String[]{"OMX.qcom."}) == null) {
                if (Build.VERSION.SDK_INT < 23 || findDecoder("video/avc", new String[]{"OMX.Exynos."}) == null) {
                    if (!PeerConnectionFactory.fieldTrialsFindFullName("WebRTC-MediaTekH264").equals(PeerConnectionFactory.TRIAL_ENABLED) || Build.VERSION.SDK_INT < 27 || findDecoder("video/avc", new String[]{supportedMediaTekH264HighProfileHwCodecPrefix}) == null) {
                        return Build.VERSION.SDK_INT >= 23 && findDecoder("video/avc", new String[]{supportedHisiH264HighProfileHwCodecPrefix}) != null;
                    }
                    return true;
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isH264HwSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? (hwDecoderDisabledTypes.contains("video/avc") || findDecoder("video/avc", supportedH264HwCodecPrefixes()) == null) ? false : true : invokeV.booleanValue;
    }

    public static boolean isVp8HwSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? (hwDecoderDisabledTypes.contains("video/x-vnd.on2.vp8") || findDecoder("video/x-vnd.on2.vp8", supportedVp8HwCodecPrefixes()) == null) ? false : true : invokeV.booleanValue;
    }

    public static boolean isVp9HwSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? (hwDecoderDisabledTypes.contains("video/x-vnd.on2.vp9") || findDecoder("video/x-vnd.on2.vp9", supportedVp9HwCodecPrefixes) == null) ? false : true : invokeV.booleanValue;
    }

    public static native long nativeCreateDecoder(String str, boolean z);

    public static void printStackTrace() {
        MediaCodecVideoDecoder mediaCodecVideoDecoder;
        Thread thread;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65558, null) == null) || (mediaCodecVideoDecoder = runningInstance) == null || (thread = mediaCodecVideoDecoder.mediaCodecThread) == null) {
            return;
        }
        StackTraceElement[] stackTrace = thread.getStackTrace();
        if (stackTrace.length > 0) {
            Logging.d(TAG, "MediaCodecVideoDecoder stacks trace:");
            for (StackTraceElement stackTraceElement : stackTrace) {
                Logging.d(TAG, stackTraceElement.toString());
            }
        }
    }

    @CalledByNativeUnchecked
    private boolean queueInputBuffer(int i, int i2, long j, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            checkOnMediaCodecThread();
            try {
                this.inputBuffers[i].position(0);
                this.inputBuffers[i].limit(i2);
                this.decodeStartTimeMs.add(new TimeStamps(SystemClock.elapsedRealtime(), j2, j3));
                this.mediaCodec.queueInputBuffer(i, 0, i2, j, 0);
                return true;
            } catch (IllegalStateException e) {
                Logging.e(TAG, "decode failed", e);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    @CalledByNativeUnchecked
    private void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            Logging.d(TAG, "Java releaseDecoder. Total number of dropped frames: " + this.droppedFrames);
            checkOnMediaCodecThread();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            new Thread(new Runnable(this, countDownLatch) { // from class: org.webrtc.MediaCodecVideoDecoder.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaCodecVideoDecoder this$0;
                public final /* synthetic */ CountDownLatch val$releaseDone;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, countDownLatch};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$releaseDone = countDownLatch;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            Logging.d(MediaCodecVideoDecoder.TAG, "Java releaseDecoder on release thread");
                            this.this$0.mediaCodec.stop();
                            this.this$0.mediaCodec.release();
                            Logging.d(MediaCodecVideoDecoder.TAG, "Java releaseDecoder on release thread done");
                        } catch (Exception e) {
                            Logging.e(MediaCodecVideoDecoder.TAG, "Media decoder release failed", e);
                        }
                        this.val$releaseDone.countDown();
                    }
                }
            }).start();
            if (!ThreadUtils.awaitUninterruptibly(countDownLatch, 5000L)) {
                Logging.e(TAG, "Media decoder release timeout");
                codecErrors++;
                if (errorCallback != null) {
                    Logging.e(TAG, "Invoke codec error callback. Errors: " + codecErrors);
                    errorCallback.onMediaCodecVideoDecoderCriticalError(codecErrors);
                }
            }
            this.mediaCodec = null;
            this.mediaCodecThread = null;
            runningInstance = null;
            if (useSurface()) {
                this.surface.release();
                this.surface = null;
                this.textureListener.release();
            }
            Logging.d(TAG, "Java releaseDecoder done");
        }
    }

    @CalledByNativeUnchecked
    private void reset(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65561, this, i, i2) == null) {
            if (this.mediaCodecThread != null && this.mediaCodec != null) {
                Logging.d(TAG, "Java reset: " + i + " x " + i2);
                this.mediaCodec.flush();
                this.width = i;
                this.height = i2;
                TextureListener textureListener = this.textureListener;
                if (textureListener != null) {
                    textureListener.setSize(i, i2);
                }
                this.decodeStartTimeMs.clear();
                this.dequeuedSurfaceOutputBuffers.clear();
                this.hasDecodedFirstFrame = false;
                this.droppedFrames = 0;
                return;
            }
            throw new RuntimeException("Incorrect reset call for non-initialized decoder.");
        }
    }

    @CalledByNativeUnchecked
    private void returnDecodedOutputBuffer(int i) throws IllegalStateException, MediaCodec.CodecException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65562, this, i) == null) {
            checkOnMediaCodecThread();
            if (!useSurface()) {
                this.mediaCodec.releaseOutputBuffer(i, false);
                return;
            }
            throw new IllegalStateException("returnDecodedOutputBuffer() called for surface decoding.");
        }
    }

    public static void setEglContext(EglBase.Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, context) == null) {
            if (eglBase != null) {
                Logging.w(TAG, "Egl context already set.");
                eglBase.release();
            }
            eglBase = mr9.b(context);
        }
    }

    public static void setErrorCallback(MediaCodecVideoDecoderErrorCallback mediaCodecVideoDecoderErrorCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, mediaCodecVideoDecoderErrorCallback) == null) {
            Logging.d(TAG, "Set error callback");
            errorCallback = mediaCodecVideoDecoderErrorCallback;
        }
    }

    public static void setVideoDecoderObserver(MediaCodecVideoDecoderObserver mediaCodecVideoDecoderObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, null, mediaCodecVideoDecoderObserver) == null) {
            Logging.d(TAG, "Set video decoder observer");
            videoDecoderObserver = mediaCodecVideoDecoderObserver;
        }
    }

    public static final String[] supportedH264HwCodecPrefixes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("OMX.qcom.");
            arrayList.add(MediaCodecUtils.INTEL_PREFIX);
            arrayList.add(supportedHisiH264HighProfileHwCodecPrefix);
            arrayList.add("OMX.Exynos.");
            if (PeerConnectionFactory.fieldTrialsFindFullName("BRTC.MTK.H264.Decode").equals(PeerConnectionFactory.TRIAL_ENABLED)) {
                arrayList.add(supportedMediaTekH264HighProfileHwCodecPrefix);
            }
            arrayList.add("OMX.rk.");
            arrayList.add("OMX.allwinner.");
            arrayList.add(MediaCodecUtils.NVIDIA_PREFIX);
            arrayList.add("OMX.IMG.");
            arrayList.add("OMX.amlogic.");
            arrayList.add("OMX.google.");
            arrayList.add("OMX.sprd.");
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return (String[]) invokeV.objValue;
    }

    public static final String[] supportedVp8HwCodecPrefixes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("OMX.qcom.");
            arrayList.add(MediaCodecUtils.NVIDIA_PREFIX);
            arrayList.add("OMX.Exynos.");
            arrayList.add(MediaCodecUtils.INTEL_PREFIX);
            if (PeerConnectionFactory.fieldTrialsFindFullName("WebRTC-MediaTekVP8").equals(PeerConnectionFactory.TRIAL_ENABLED) && Build.VERSION.SDK_INT >= 24) {
                arrayList.add(supportedMediaTekH264HighProfileHwCodecPrefix);
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return (String[]) invokeV.objValue;
    }

    public static boolean useSurface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) ? eglBase != null : invokeV.booleanValue;
    }

    @CalledByNative
    public int getColorFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.colorFormat : invokeV.intValue;
    }

    @CalledByNative
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.height : invokeV.intValue;
    }

    @CalledByNative
    public ByteBuffer[] getInputBuffers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.inputBuffers : (ByteBuffer[]) invokeV.objValue;
    }

    @CalledByNative
    public ByteBuffer[] getOutputBuffers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.outputBuffers : (ByteBuffer[]) invokeV.objValue;
    }

    @CalledByNative
    public int getSliceHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.sliceHeight : invokeV.intValue;
    }

    @CalledByNative
    public int getStride() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.stride : invokeV.intValue;
    }

    @CalledByNative
    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.width : invokeV.intValue;
    }
}
