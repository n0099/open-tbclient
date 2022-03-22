package org.webrtc;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Bundle;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ssa.SsaDecoder;
import f.c.m0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.webrtc.EglBase14;
import org.webrtc.EncodedImage;
import org.webrtc.ThreadUtils;
import org.webrtc.VideoEncoder;
import org.webrtc.VideoFrame;
@TargetApi(19)
/* loaded from: classes8.dex */
public class HardwareVideoEncoder implements VideoEncoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT_US = 100000;
    public static final String KEY_BITRATE_MODE = "bitrate-mode";
    public static final int MAX_ENCODER_Q_SIZE = 2;
    public static final int MAX_VIDEO_FRAMERATE = 30;
    public static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    public static final String TAG = "HardwareVideoEncoder";
    public static final int VIDEO_AVC_LEVEL_3 = 256;
    public static final int VIDEO_AVC_PROFILE_HIGH = 8;
    public static final int VIDEO_ControlRateConstant = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public int adjustedBitrate;
    public boolean automaticResizeOn;
    public final BitrateAdjuster bitrateAdjuster;
    public VideoEncoder.Callback callback;
    @Nullable
    public MediaCodecWrapper codec;
    public final String codecName;
    public final VideoCodecType codecType;
    @Nullable
    public ByteBuffer configBuffer;
    public final ThreadUtils.ThreadChecker encodeThreadChecker;
    public final long forcedKeyFrameNs;
    public int height;
    public final int keyFrameIntervalSec;
    public long lastKeyFrameNs;
    public final MediaCodecWrapperFactory mediaCodecWrapperFactory;
    public final BlockingDeque<EncodedImage.Builder> outputBuilders;
    @Nullable
    public Thread outputThread;
    public final ThreadUtils.ThreadChecker outputThreadChecker;
    public final Map<String, String> params;
    public volatile boolean running;
    public final EglBase14.Context sharedContext;
    @Nullable
    public volatile Exception shutdownException;
    public final Integer surfaceColorFormat;
    public final GlRectDrawer textureDrawer;
    @Nullable
    public EglBase14 textureEglBase;
    @Nullable
    public Surface textureInputSurface;
    public boolean useSurfaceMode;
    public final VideoFrameDrawer videoFrameDrawer;
    public int width;
    public final Integer yuvColorFormat;
    public final YuvFormat yuvFormat;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static abstract class YuvFormat {
        public static final /* synthetic */ YuvFormat[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final YuvFormat I420;
        public static final YuvFormat NV12;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1492557414, "Lorg/webrtc/HardwareVideoEncoder$YuvFormat;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1492557414, "Lorg/webrtc/HardwareVideoEncoder$YuvFormat;");
                    return;
                }
            }
            I420 = new YuvFormat("I420", 0) { // from class: org.webrtc.HardwareVideoEncoder.YuvFormat.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // org.webrtc.HardwareVideoEncoder.YuvFormat
                public void fillBuffer(ByteBuffer byteBuffer, VideoFrame.Buffer buffer) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, byteBuffer, buffer) == null) {
                        VideoFrame.I420Buffer i420 = buffer.toI420();
                        YuvHelper.I420Copy(i420.getDataY(), i420.getStrideY(), i420.getDataU(), i420.getStrideU(), i420.getDataV(), i420.getStrideV(), byteBuffer, i420.getWidth(), i420.getHeight());
                        i420.release();
                    }
                }
            };
            YuvFormat yuvFormat = new YuvFormat("NV12", 1) { // from class: org.webrtc.HardwareVideoEncoder.YuvFormat.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // org.webrtc.HardwareVideoEncoder.YuvFormat
                public void fillBuffer(ByteBuffer byteBuffer, VideoFrame.Buffer buffer) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, byteBuffer, buffer) == null) {
                        VideoFrame.I420Buffer i420 = buffer.toI420();
                        YuvHelper.I420ToNV12(i420.getDataY(), i420.getStrideY(), i420.getDataU(), i420.getStrideU(), i420.getDataV(), i420.getStrideV(), byteBuffer, i420.getWidth(), i420.getHeight());
                        i420.release();
                    }
                }
            };
            NV12 = yuvFormat;
            $VALUES = new YuvFormat[]{I420, yuvFormat};
        }

        public YuvFormat(String str, int i) {
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

        public static YuvFormat valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (YuvFormat) Enum.valueOf(YuvFormat.class, str) : (YuvFormat) invokeL.objValue;
        }

        public static YuvFormat[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (YuvFormat[]) $VALUES.clone() : (YuvFormat[]) invokeV.objValue;
        }

        public abstract void fillBuffer(ByteBuffer byteBuffer, VideoFrame.Buffer buffer);

        public static YuvFormat valueOf(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
                if (i != 19) {
                    if (i != 21 && i != 2141391872 && i != 2141391876) {
                        throw new IllegalArgumentException("Unsupported colorFormat: " + i);
                    }
                    return NV12;
                }
                return I420;
            }
            return (YuvFormat) invokeI.objValue;
        }
    }

    public HardwareVideoEncoder(MediaCodecWrapperFactory mediaCodecWrapperFactory, String str, VideoCodecType videoCodecType, Integer num, Integer num2, Map<String, String> map, int i, int i2, BitrateAdjuster bitrateAdjuster, EglBase14.Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaCodecWrapperFactory, str, videoCodecType, num, num2, map, Integer.valueOf(i), Integer.valueOf(i2), bitrateAdjuster, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.textureDrawer = new GlRectDrawer();
        this.videoFrameDrawer = new VideoFrameDrawer();
        this.outputBuilders = new LinkedBlockingDeque();
        this.encodeThreadChecker = new ThreadUtils.ThreadChecker();
        this.outputThreadChecker = new ThreadUtils.ThreadChecker();
        this.mediaCodecWrapperFactory = mediaCodecWrapperFactory;
        this.codecName = str;
        this.codecType = videoCodecType;
        this.surfaceColorFormat = num;
        this.yuvColorFormat = num2;
        this.yuvFormat = YuvFormat.valueOf(num2.intValue());
        this.params = map;
        this.keyFrameIntervalSec = i;
        this.forcedKeyFrameNs = TimeUnit.MILLISECONDS.toNanos(i2);
        this.bitrateAdjuster = bitrateAdjuster;
        this.sharedContext = context;
        this.encodeThreadChecker.detachThread();
    }

    private boolean canUseSurface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? (this.sharedContext == null || this.surfaceColorFormat == null) ? false : true : invokeV.booleanValue;
    }

    private Thread createOutputThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? new Thread(this) { // from class: org.webrtc.HardwareVideoEncoder.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HardwareVideoEncoder this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
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
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    while (this.this$0.running) {
                        this.this$0.deliverEncodedImage();
                    }
                    this.this$0.releaseCodecOnOutputThread();
                }
            }
        } : (Thread) invokeV.objValue;
    }

    private VideoCodecStatus encodeByteBuffer(VideoFrame videoFrame, VideoFrame.Buffer buffer, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65541, this, videoFrame, buffer, i)) == null) {
            this.encodeThreadChecker.checkIsOnValidThread();
            long timestampNs = (videoFrame.getTimestampNs() + 500) / 1000;
            try {
                int dequeueInputBuffer = this.codec.dequeueInputBuffer(0L);
                if (dequeueInputBuffer == -1) {
                    Logging.d(TAG, "Dropped frame, no input buffers available");
                    return VideoCodecStatus.NO_OUTPUT;
                }
                try {
                    fillInputBuffer(this.codec.getInputBuffers()[dequeueInputBuffer], buffer);
                    try {
                        this.codec.queueInputBuffer(dequeueInputBuffer, 0, i, timestampNs, 0);
                        return VideoCodecStatus.OK;
                    } catch (IllegalStateException e2) {
                        Logging.e(TAG, "queueInputBuffer failed", e2);
                        return VideoCodecStatus.ERROR;
                    }
                } catch (IllegalStateException e3) {
                    Logging.e(TAG, "getInputBuffers failed", e3);
                    return VideoCodecStatus.ERROR;
                }
            } catch (IllegalStateException e4) {
                Logging.e(TAG, "dequeueInputBuffer failed", e4);
                return VideoCodecStatus.ERROR;
            }
        }
        return (VideoCodecStatus) invokeLLI.objValue;
    }

    private VideoCodecStatus encodeTextureBuffer(VideoFrame videoFrame) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, videoFrame)) == null) {
            this.encodeThreadChecker.checkIsOnValidThread();
            try {
                GLES20.glClear(16384);
                this.videoFrameDrawer.drawFrame(new VideoFrame(videoFrame.getBuffer(), 0, videoFrame.getTimestampNs()), this.textureDrawer, null);
                this.textureEglBase.swapBuffers(videoFrame.getTimestampNs());
                return VideoCodecStatus.OK;
            } catch (RuntimeException e2) {
                Logging.e(TAG, "encodeTexture failed", e2);
                return VideoCodecStatus.ERROR;
            }
        }
        return (VideoCodecStatus) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0091, code lost:
        if (r5 == 1) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0093, code lost:
        org.webrtc.Logging.w(org.webrtc.HardwareVideoEncoder.TAG, "Unknown profile level id: " + r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private VideoCodecStatus initEncodeInternal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            this.encodeThreadChecker.checkIsOnValidThread();
            this.lastKeyFrameNs = -1L;
            try {
                this.codec = this.mediaCodecWrapperFactory.createByCodecName(this.codecName);
                int intValue = (this.useSurfaceMode ? this.surfaceColorFormat : this.yuvColorFormat).intValue();
                try {
                    MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.codecType.mimeType(), this.width, this.height);
                    createVideoFormat.setInteger("bitrate", this.adjustedBitrate);
                    createVideoFormat.setInteger(KEY_BITRATE_MODE, 2);
                    createVideoFormat.setInteger("color-format", intValue);
                    createVideoFormat.setInteger("frame-rate", this.bitrateAdjuster.getCodecConfigFramerate());
                    createVideoFormat.setInteger("i-frame-interval", this.keyFrameIntervalSec);
                    if (this.codecType == VideoCodecType.H264) {
                        String str = this.params.get("profile-level-id");
                        if (str == null) {
                            str = "42e01f";
                        }
                        char c2 = 65535;
                        int hashCode = str.hashCode();
                        if (hashCode != 1537948542) {
                            if (hashCode == 1595523974 && str.equals("640c1f")) {
                                c2 = 0;
                            }
                        } else if (str.equals("42e01f")) {
                            c2 = 1;
                        }
                        createVideoFormat.setInteger("profile", 8);
                        createVideoFormat.setInteger("level", 256);
                    }
                    Logging.d(TAG, SsaDecoder.FORMAT_LINE_PREFIX + createVideoFormat);
                    this.codec.configure(createVideoFormat, null, null, 1);
                    if (this.useSurfaceMode) {
                        this.textureEglBase = new EglBase14(this.sharedContext, EglBase.CONFIG_RECORDABLE);
                        Surface createInputSurface = this.codec.createInputSurface();
                        this.textureInputSurface = createInputSurface;
                        this.textureEglBase.createSurface(createInputSurface);
                        this.textureEglBase.makeCurrent();
                    }
                    this.codec.start();
                    this.running = true;
                    this.outputThreadChecker.detachThread();
                    Thread createOutputThread = createOutputThread();
                    this.outputThread = createOutputThread;
                    createOutputThread.start();
                    return VideoCodecStatus.OK;
                } catch (IllegalStateException e2) {
                    Logging.e(TAG, "initEncodeInternal failed", e2);
                    release();
                    return VideoCodecStatus.FALLBACK_SOFTWARE;
                }
            } catch (IOException | IllegalArgumentException unused) {
                Logging.e(TAG, "Cannot create media encoder " + this.codecName);
                return VideoCodecStatus.FALLBACK_SOFTWARE;
            }
        }
        return (VideoCodecStatus) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCodecOnOutputThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.outputThreadChecker.checkIsOnValidThread();
            Logging.d(TAG, "Releasing MediaCodec on output thread");
            try {
                this.codec.stop();
            } catch (Exception e2) {
                Logging.e(TAG, "Media encoder stop failed", e2);
            }
            try {
                this.codec.release();
            } catch (Exception e3) {
                Logging.e(TAG, "Media encoder release failed", e3);
                this.shutdownException = e3;
            }
            this.configBuffer = null;
            Logging.d(TAG, "Release on output thread done");
        }
    }

    private void requestKeyFrame(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65545, this, j) == null) {
            this.encodeThreadChecker.checkIsOnValidThread();
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("request-sync", 0);
                this.codec.setParameters(bundle);
                this.lastKeyFrameNs = j;
            } catch (IllegalStateException e2) {
                Logging.e(TAG, "requestKeyFrame failed", e2);
            }
        }
    }

    private VideoCodecStatus resetCodec(int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            this.encodeThreadChecker.checkIsOnValidThread();
            VideoCodecStatus release = release();
            if (release != VideoCodecStatus.OK) {
                return release;
            }
            this.width = i;
            this.height = i2;
            this.useSurfaceMode = z;
            return initEncodeInternal();
        }
        return (VideoCodecStatus) invokeCommon.objValue;
    }

    private boolean shouldForceKeyFrame(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65547, this, j)) == null) {
            this.encodeThreadChecker.checkIsOnValidThread();
            long j2 = this.forcedKeyFrameNs;
            return j2 > 0 && j > this.lastKeyFrameNs + j2;
        }
        return invokeJ.booleanValue;
    }

    private VideoCodecStatus updateBitrate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            this.outputThreadChecker.checkIsOnValidThread();
            this.adjustedBitrate = this.bitrateAdjuster.getAdjustedBitrateBps();
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("video-bitrate", this.adjustedBitrate);
                this.codec.setParameters(bundle);
                return VideoCodecStatus.OK;
            } catch (IllegalStateException e2) {
                Logging.e(TAG, "updateBitrate failed", e2);
                return VideoCodecStatus.ERROR;
            }
        }
        return (VideoCodecStatus) invokeV.objValue;
    }

    @Override // org.webrtc.VideoEncoder
    @CalledByNative
    public /* synthetic */ long createNativeVideoEncoder() {
        return m0.$default$createNativeVideoEncoder(this);
    }

    public void deliverEncodedImage() {
        ByteBuffer slice;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.outputThreadChecker.checkIsOnValidThread();
            try {
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                int dequeueOutputBuffer = this.codec.dequeueOutputBuffer(bufferInfo, 100000L);
                if (dequeueOutputBuffer < 0) {
                    return;
                }
                ByteBuffer byteBuffer = this.codec.getOutputBuffers()[dequeueOutputBuffer];
                byteBuffer.position(bufferInfo.offset);
                byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                if ((bufferInfo.flags & 2) != 0) {
                    Logging.d(TAG, "Config frame generated. Offset: " + bufferInfo.offset + ". Size: " + bufferInfo.size);
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bufferInfo.size);
                    this.configBuffer = allocateDirect;
                    allocateDirect.put(byteBuffer);
                } else {
                    this.bitrateAdjuster.reportEncodedFrame(bufferInfo.size);
                    if (this.adjustedBitrate != this.bitrateAdjuster.getAdjustedBitrateBps()) {
                        updateBitrate();
                    }
                    boolean z = true;
                    if ((bufferInfo.flags & 1) == 0) {
                        z = false;
                    }
                    if (z) {
                        Logging.d(TAG, "Sync frame generated");
                    }
                    if (z && this.codecType == VideoCodecType.H264) {
                        Logging.d(TAG, "Prepending config frame of size " + this.configBuffer.capacity() + " to output buffer with offset " + bufferInfo.offset + ", size " + bufferInfo.size);
                        slice = ByteBuffer.allocateDirect(bufferInfo.size + this.configBuffer.capacity());
                        this.configBuffer.rewind();
                        slice.put(this.configBuffer);
                        slice.put(byteBuffer);
                        slice.rewind();
                    } else {
                        slice = byteBuffer.slice();
                    }
                    EncodedImage.FrameType frameType = z ? EncodedImage.FrameType.VideoFrameKey : EncodedImage.FrameType.VideoFrameDelta;
                    EncodedImage.Builder poll = this.outputBuilders.poll();
                    poll.setBuffer(slice).setFrameType(frameType);
                    this.callback.onEncodedFrame(poll.createEncodedImage(), new VideoEncoder.CodecSpecificInfo());
                }
                this.codec.releaseOutputBuffer(dequeueOutputBuffer, false);
            } catch (IllegalStateException e2) {
                Logging.e(TAG, "deliverOutput failed", e2);
            }
        }
    }

    @Override // org.webrtc.VideoEncoder
    public VideoCodecStatus encode(VideoFrame videoFrame, VideoEncoder.EncodeInfo encodeInfo) {
        InterceptResult invokeLL;
        VideoCodecStatus resetCodec;
        VideoCodecStatus encodeByteBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, videoFrame, encodeInfo)) == null) {
            this.encodeThreadChecker.checkIsOnValidThread();
            if (this.codec == null) {
                return VideoCodecStatus.UNINITIALIZED;
            }
            VideoFrame.Buffer buffer = videoFrame.getBuffer();
            boolean z = buffer instanceof VideoFrame.TextureBuffer;
            int width = videoFrame.getBuffer().getWidth();
            int height = videoFrame.getBuffer().getHeight();
            boolean z2 = canUseSurface() && z;
            if ((width == this.width && height == this.height && z2 == this.useSurfaceMode) || (resetCodec = resetCodec(width, height, z2)) == VideoCodecStatus.OK) {
                if (this.outputBuilders.size() > 2) {
                    Logging.e(TAG, "Dropped frame, encoder queue full");
                    return VideoCodecStatus.NO_OUTPUT;
                }
                boolean z3 = false;
                for (EncodedImage.FrameType frameType : encodeInfo.frameTypes) {
                    if (frameType == EncodedImage.FrameType.VideoFrameKey) {
                        z3 = true;
                    }
                }
                if (z3 || shouldForceKeyFrame(videoFrame.getTimestampNs())) {
                    requestKeyFrame(videoFrame.getTimestampNs());
                }
                int height2 = ((buffer.getHeight() * buffer.getWidth()) * 3) / 2;
                this.outputBuilders.offer(EncodedImage.builder().setCaptureTimeNs(videoFrame.getTimestampNs()).setCompleteFrame(true).setEncodedWidth(videoFrame.getBuffer().getWidth()).setEncodedHeight(videoFrame.getBuffer().getHeight()).setRotation(videoFrame.getRotation()));
                if (this.useSurfaceMode) {
                    encodeByteBuffer = encodeTextureBuffer(videoFrame);
                } else {
                    encodeByteBuffer = encodeByteBuffer(videoFrame, buffer, height2);
                }
                if (encodeByteBuffer != VideoCodecStatus.OK) {
                    this.outputBuilders.pollLast();
                }
                return encodeByteBuffer;
            }
            return resetCodec;
        }
        return (VideoCodecStatus) invokeLL.objValue;
    }

    public void fillInputBuffer(ByteBuffer byteBuffer, VideoFrame.Buffer buffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, byteBuffer, buffer) == null) {
            this.yuvFormat.fillBuffer(byteBuffer, buffer);
        }
    }

    @Override // org.webrtc.VideoEncoder
    public String getImplementationName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "HWEncoder" : (String) invokeV.objValue;
    }

    @Override // org.webrtc.VideoEncoder
    public VideoEncoder.ScalingSettings getScalingSettings() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            this.encodeThreadChecker.checkIsOnValidThread();
            if (this.automaticResizeOn) {
                VideoCodecType videoCodecType = this.codecType;
                if (videoCodecType == VideoCodecType.VP8) {
                    return new VideoEncoder.ScalingSettings(29, 95);
                }
                if (videoCodecType == VideoCodecType.H264) {
                    return new VideoEncoder.ScalingSettings(24, 37);
                }
            }
            return VideoEncoder.ScalingSettings.OFF;
        }
        return (VideoEncoder.ScalingSettings) invokeV.objValue;
    }

    @Override // org.webrtc.VideoEncoder
    public VideoCodecStatus initEncode(VideoEncoder.Settings settings, VideoEncoder.Callback callback) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, settings, callback)) == null) {
            this.encodeThreadChecker.checkIsOnValidThread();
            this.callback = callback;
            this.automaticResizeOn = settings.automaticResizeOn;
            this.width = settings.width;
            this.height = settings.height;
            this.useSurfaceMode = canUseSurface();
            int i2 = settings.startBitrate;
            if (i2 != 0 && (i = settings.maxFramerate) != 0) {
                this.bitrateAdjuster.setTargets(i2 * 1000, i);
            }
            this.adjustedBitrate = this.bitrateAdjuster.getAdjustedBitrateBps();
            Logging.d(TAG, "initEncode: " + this.width + " x " + this.height + ". @ " + settings.startBitrate + "kbps. Fps: " + settings.maxFramerate + " Use surface mode: " + this.useSurfaceMode);
            return initEncodeInternal();
        }
        return (VideoCodecStatus) invokeLL.objValue;
    }

    @Override // org.webrtc.VideoEncoder
    @CalledByNative
    public /* synthetic */ boolean isHardwareEncoder() {
        return m0.$default$isHardwareEncoder(this);
    }

    @Override // org.webrtc.VideoEncoder
    public VideoCodecStatus release() {
        InterceptResult invokeV;
        VideoCodecStatus videoCodecStatus;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            this.encodeThreadChecker.checkIsOnValidThread();
            if (this.outputThread == null) {
                videoCodecStatus = VideoCodecStatus.OK;
            } else {
                this.running = false;
                if (!ThreadUtils.joinUninterruptibly(this.outputThread, 5000L)) {
                    Logging.e(TAG, "Media encoder release timeout");
                    videoCodecStatus = VideoCodecStatus.TIMEOUT;
                } else if (this.shutdownException != null) {
                    Logging.e(TAG, "Media encoder release exception", this.shutdownException);
                    videoCodecStatus = VideoCodecStatus.ERROR;
                } else {
                    videoCodecStatus = VideoCodecStatus.OK;
                }
            }
            this.textureDrawer.release();
            this.videoFrameDrawer.release();
            EglBase14 eglBase14 = this.textureEglBase;
            if (eglBase14 != null) {
                eglBase14.release();
                this.textureEglBase = null;
            }
            Surface surface = this.textureInputSurface;
            if (surface != null) {
                surface.release();
                this.textureInputSurface = null;
            }
            this.outputBuilders.clear();
            this.codec = null;
            this.outputThread = null;
            this.encodeThreadChecker.detachThread();
            return videoCodecStatus;
        }
        return (VideoCodecStatus) invokeV.objValue;
    }

    @Override // org.webrtc.VideoEncoder
    public VideoCodecStatus setRateAllocation(VideoEncoder.BitrateAllocation bitrateAllocation, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, bitrateAllocation, i)) == null) {
            this.encodeThreadChecker.checkIsOnValidThread();
            if (i > 30) {
                i = 30;
            }
            this.bitrateAdjuster.setTargets(bitrateAllocation.getSum(), i);
            return VideoCodecStatus.OK;
        }
        return (VideoCodecStatus) invokeLI.objValue;
    }
}
