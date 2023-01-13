package org.webrtc;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.e8a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.webrtc.EglBase;
import org.webrtc.EncodedImage;
import org.webrtc.ThreadUtils;
import org.webrtc.VideoDecoder;
import org.webrtc.VideoFrame;
/* loaded from: classes9.dex */
public class AndroidVideoDecoder implements VideoDecoder, VideoSink {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEQUEUE_INPUT_TIMEOUT_US = 500000;
    public static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT_US = 100000;
    public static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    public static final String MEDIA_FORMAT_KEY_CROP_BOTTOM = "crop-bottom";
    public static final String MEDIA_FORMAT_KEY_CROP_LEFT = "crop-left";
    public static final String MEDIA_FORMAT_KEY_CROP_RIGHT = "crop-right";
    public static final String MEDIA_FORMAT_KEY_CROP_TOP = "crop-top";
    public static final String MEDIA_FORMAT_KEY_SLICE_HEIGHT = "slice-height";
    public static final String MEDIA_FORMAT_KEY_STRIDE = "stride";
    public static final String TAG = "AndroidVideoDecoder";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public VideoDecoder.Callback callback;
    @Nullable
    public MediaCodecWrapper codec;
    public final String codecName;
    public final VideoCodecType codecType;
    public int colorFormat;
    public ThreadUtils.ThreadChecker decoderThreadChecker;
    public final Object dimensionLock;
    public final BlockingDeque<FrameInfo> frameInfos;
    public boolean hasDecodedFirstFrame;
    public int height;
    public boolean keyFrameRequired;
    public final MediaCodecWrapperFactory mediaCodecWrapperFactory;
    @Nullable
    public Thread outputThread;
    public ThreadUtils.ThreadChecker outputThreadChecker;
    @Nullable
    public DecodedTextureMetadata renderedTextureMetadata;
    public final Object renderedTextureMetadataLock;
    public volatile boolean running;
    @Nullable
    public final EglBase.Context sharedContext;
    @Nullable
    public volatile Exception shutdownException;
    public int sliceHeight;
    public int stride;
    @Nullable
    public Surface surface;
    @Nullable
    public SurfaceTextureHelper surfaceTextureHelper;
    public int width;

    @Override // org.webrtc.VideoDecoder
    @CalledByNative
    public /* synthetic */ long createNativeVideoDecoder() {
        return e8a.$default$createNativeVideoDecoder(this);
    }

    @Override // org.webrtc.VideoDecoder
    public boolean getPrefersLateDecoding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes9.dex */
    public static class DecodedTextureMetadata {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Integer decodeTimeMs;
        public final long presentationTimestampUs;

        public DecodedTextureMetadata(long j, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), num};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.presentationTimestampUs = j;
            this.decodeTimeMs = num;
        }
    }

    /* loaded from: classes9.dex */
    public static class FrameInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long decodeStartTimeMs;
        public final int rotation;

        public FrameInfo(long j, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.decodeStartTimeMs = j;
            this.rotation = i;
        }
    }

    public AndroidVideoDecoder(MediaCodecWrapperFactory mediaCodecWrapperFactory, String str, VideoCodecType videoCodecType, int i, @Nullable EglBase.Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaCodecWrapperFactory, str, videoCodecType, Integer.valueOf(i), context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.dimensionLock = new Object();
        this.renderedTextureMetadataLock = new Object();
        if (isSupportedColorFormat(i)) {
            Logging.d(TAG, "ctor name: " + str + " type: " + videoCodecType + " color format: " + i + " context: " + context);
            this.mediaCodecWrapperFactory = mediaCodecWrapperFactory;
            this.codecName = str;
            this.codecType = videoCodecType;
            this.colorFormat = i;
            this.sharedContext = context;
            this.frameInfos = new LinkedBlockingDeque();
            return;
        }
        throw new IllegalArgumentException("Unsupported color format: " + i);
    }

    private VideoCodecStatus reinitDecode(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65548, this, i, i2)) == null) {
            this.decoderThreadChecker.checkIsOnValidThread();
            VideoCodecStatus releaseInternal = releaseInternal();
            if (releaseInternal != VideoCodecStatus.OK) {
                return releaseInternal;
            }
            return initDecodeInternal(i, i2);
        }
        return (VideoCodecStatus) invokeII.objValue;
    }

    public VideoFrame.I420Buffer allocateI420Buffer(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            return JavaI420Buffer.allocate(i, i2);
        }
        return (VideoFrame.I420Buffer) invokeII.objValue;
    }

    private boolean isSupportedColorFormat(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, this, i)) == null) {
            for (int i2 : MediaCodecUtils.DECODER_COLOR_FORMATS) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    private void stopOnOutputThread(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, exc) == null) {
            this.outputThreadChecker.checkIsOnValidThread();
            this.running = false;
            this.shutdownException = exc;
        }
    }

    private VideoFrame.Buffer copyI420Buffer(ByteBuffer byteBuffer, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{byteBuffer, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i % 2 == 0) {
                int i6 = (i3 + 1) / 2;
                int i7 = i2 % 2;
                if (i7 == 0) {
                    i5 = (i4 + 1) / 2;
                } else {
                    i5 = i4 / 2;
                }
                int i8 = i5;
                int i9 = i / 2;
                int i10 = (i * i2) + 0;
                int i11 = i9 * i8;
                int i12 = i10 + ((i9 * i2) / 2);
                int i13 = i12 + i11;
                VideoFrame.I420Buffer allocateI420Buffer = allocateI420Buffer(i3, i4);
                byteBuffer.limit((i * i4) + 0);
                byteBuffer.position(0);
                copyPlane(byteBuffer.slice(), i, allocateI420Buffer.getDataY(), allocateI420Buffer.getStrideY(), i3, i4);
                byteBuffer.limit(i10 + i11);
                byteBuffer.position(i10);
                copyPlane(byteBuffer.slice(), i9, allocateI420Buffer.getDataU(), allocateI420Buffer.getStrideU(), i6, i8);
                if (i7 == 1) {
                    byteBuffer.position(i10 + ((i8 - 1) * i9));
                    ByteBuffer dataU = allocateI420Buffer.getDataU();
                    dataU.position(allocateI420Buffer.getStrideU() * i8);
                    dataU.put(byteBuffer);
                }
                byteBuffer.limit(i13);
                byteBuffer.position(i12);
                copyPlane(byteBuffer.slice(), i9, allocateI420Buffer.getDataV(), allocateI420Buffer.getStrideV(), i6, i8);
                if (i7 == 1) {
                    byteBuffer.position(i12 + (i9 * (i8 - 1)));
                    ByteBuffer dataV = allocateI420Buffer.getDataV();
                    dataV.position(allocateI420Buffer.getStrideV() * i8);
                    dataV.put(byteBuffer);
                }
                return allocateI420Buffer;
            }
            throw new AssertionError("Stride is not divisible by two: " + i);
        }
        return (VideoFrame.Buffer) invokeCommon.objValue;
    }

    private VideoFrame.Buffer copyNV12ToI420Buffer(ByteBuffer byteBuffer, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{byteBuffer, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            return new NV12Buffer(i3, i4, i, i2, byteBuffer, null).toI420();
        }
        return (VideoFrame.Buffer) invokeCommon.objValue;
    }

    private Thread createOutputThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            return new Thread(this, "AndroidVideoDecoder.outputThread") { // from class: org.webrtc.AndroidVideoDecoder.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AndroidVideoDecoder this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((String) newInitContext.callArgs[0]);
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
                        this.this$0.outputThreadChecker = new ThreadUtils.ThreadChecker();
                        while (this.this$0.running) {
                            this.this$0.deliverDecodedFrame();
                        }
                        this.this$0.releaseCodecOnOutputThread();
                    }
                }
            };
        }
        return (Thread) invokeV.objValue;
    }

    public SurfaceTextureHelper createSurfaceTextureHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return SurfaceTextureHelper.create("decoder-texture-thread", this.sharedContext);
        }
        return (SurfaceTextureHelper) invokeV.objValue;
    }

    @Override // org.webrtc.VideoDecoder
    public String getImplementationName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.codecName;
        }
        return (String) invokeV.objValue;
    }

    public void releaseSurface() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.surface.release();
        }
    }

    private void deliverByteFrame(int i, MediaCodec.BufferInfo bufferInfo, int i2, Integer num) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        VideoFrame.Buffer copyNV12ToI420Buffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Integer.valueOf(i), bufferInfo, Integer.valueOf(i2), num}) == null) {
            synchronized (this.dimensionLock) {
                i3 = this.width;
                i4 = this.height;
                i5 = this.stride;
                i6 = this.sliceHeight;
            }
            int i8 = bufferInfo.size;
            if (i8 < ((i3 * i4) * 3) / 2) {
                Logging.e(TAG, "Insufficient output buffer size: " + bufferInfo.size);
                return;
            }
            if (i8 < ((i5 * i4) * 3) / 2 && i6 == i4 && i5 > i3) {
                i7 = (i8 * 2) / (i4 * 3);
            } else {
                i7 = i5;
            }
            ByteBuffer byteBuffer = this.codec.getOutputBuffers()[i];
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            ByteBuffer slice = byteBuffer.slice();
            if (this.colorFormat == 19) {
                copyNV12ToI420Buffer = copyI420Buffer(slice, i7, i6, i3, i4);
            } else {
                copyNV12ToI420Buffer = copyNV12ToI420Buffer(slice, i7, i6, i3, i4);
            }
            this.codec.releaseOutputBuffer(i, false);
            VideoFrame videoFrame = new VideoFrame(copyNV12ToI420Buffer, i2, bufferInfo.presentationTimeUs * 1000);
            this.callback.onDecodedFrame(videoFrame, num, null);
            videoFrame.release();
        }
    }

    private void deliverTextureFrame(int i, MediaCodec.BufferInfo bufferInfo, int i2, Integer num) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Integer.valueOf(i), bufferInfo, Integer.valueOf(i2), num}) == null) {
            synchronized (this.dimensionLock) {
                i3 = this.width;
                i4 = this.height;
            }
            synchronized (this.renderedTextureMetadataLock) {
                if (this.renderedTextureMetadata != null) {
                    this.codec.releaseOutputBuffer(i, false);
                    return;
                }
                this.surfaceTextureHelper.setTextureSize(i3, i4);
                this.surfaceTextureHelper.setFrameRotation(i2);
                this.renderedTextureMetadata = new DecodedTextureMetadata(bufferInfo.presentationTimeUs, num);
                this.codec.releaseOutputBuffer(i, true);
            }
        }
    }

    private VideoCodecStatus initDecodeInternal(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65545, this, i, i2)) == null) {
            this.decoderThreadChecker.checkIsOnValidThread();
            Logging.d(TAG, "initDecodeInternal name: " + this.codecName + " type: " + this.codecType + " width: " + i + " height: " + i2);
            if (this.outputThread != null) {
                Logging.e(TAG, "initDecodeInternal called while the codec is already running");
                return VideoCodecStatus.FALLBACK_SOFTWARE;
            }
            this.width = i;
            this.height = i2;
            this.stride = i;
            this.sliceHeight = i2;
            this.hasDecodedFirstFrame = false;
            this.keyFrameRequired = true;
            try {
                this.codec = this.mediaCodecWrapperFactory.createByCodecName(this.codecName);
                try {
                    MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.codecType.mimeType(), i, i2);
                    if (this.sharedContext == null) {
                        createVideoFormat.setInteger("color-format", this.colorFormat);
                    }
                    this.codec.configure(createVideoFormat, this.surface, null, 0);
                    this.codec.start();
                    this.running = true;
                    Thread createOutputThread = createOutputThread();
                    this.outputThread = createOutputThread;
                    createOutputThread.start();
                    Logging.d(TAG, "initDecodeInternal done");
                    return VideoCodecStatus.OK;
                } catch (IllegalStateException e) {
                    Logging.e(TAG, "initDecode failed", e);
                    release();
                    return VideoCodecStatus.FALLBACK_SOFTWARE;
                }
            } catch (IOException | IllegalArgumentException unused) {
                Logging.e(TAG, "Cannot create media decoder " + this.codecName);
                return VideoCodecStatus.FALLBACK_SOFTWARE;
            }
        }
        return (VideoCodecStatus) invokeII.objValue;
    }

    private void reformat(MediaFormat mediaFormat) {
        int integer;
        int integer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, mediaFormat) == null) {
            this.outputThreadChecker.checkIsOnValidThread();
            Logging.d(TAG, "Decoder format changed: " + mediaFormat.toString());
            if (mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) {
                integer = (mediaFormat.getInteger("crop-right") + 1) - mediaFormat.getInteger("crop-left");
                integer2 = (mediaFormat.getInteger("crop-bottom") + 1) - mediaFormat.getInteger("crop-top");
            } else {
                integer = mediaFormat.getInteger("width");
                integer2 = mediaFormat.getInteger("height");
            }
            synchronized (this.dimensionLock) {
                if (this.hasDecodedFirstFrame && (this.width != integer || this.height != integer2)) {
                    stopOnOutputThread(new RuntimeException("Unexpected size change. Configured " + this.width + "*" + this.height + ". New " + integer + "*" + integer2));
                    return;
                }
                this.width = integer;
                this.height = integer2;
                if (this.surfaceTextureHelper == null && mediaFormat.containsKey("color-format")) {
                    this.colorFormat = mediaFormat.getInteger("color-format");
                    Logging.d(TAG, "Color: 0x" + Integer.toHexString(this.colorFormat));
                    if (!isSupportedColorFormat(this.colorFormat)) {
                        stopOnOutputThread(new IllegalStateException("Unsupported color format: " + this.colorFormat));
                        return;
                    }
                }
                synchronized (this.dimensionLock) {
                    if (mediaFormat.containsKey("stride")) {
                        this.stride = mediaFormat.getInteger("stride");
                    }
                    if (mediaFormat.containsKey("slice-height")) {
                        this.sliceHeight = mediaFormat.getInteger("slice-height");
                    }
                    Logging.d(TAG, "Frame stride and slice height: " + this.stride + " x " + this.sliceHeight);
                    this.stride = Math.max(this.width, this.stride);
                    this.sliceHeight = Math.max(this.height, this.sliceHeight);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCodecOnOutputThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.outputThreadChecker.checkIsOnValidThread();
            Logging.d(TAG, "Releasing MediaCodec on output thread");
            try {
                this.codec.stop();
            } catch (Exception e) {
                Logging.e(TAG, "Media decoder stop failed", e);
            }
            try {
                this.codec.release();
            } catch (Exception e2) {
                Logging.e(TAG, "Media decoder release failed", e2);
                this.shutdownException = e2;
            }
            Logging.d(TAG, "Release on output thread done");
        }
    }

    @Override // org.webrtc.VideoDecoder
    public VideoCodecStatus release() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Logging.d(TAG, "release");
            VideoCodecStatus releaseInternal = releaseInternal();
            if (this.surface != null) {
                releaseSurface();
                this.surface = null;
                this.surfaceTextureHelper.stopListening();
                this.surfaceTextureHelper.dispose();
                this.surfaceTextureHelper = null;
            }
            synchronized (this.renderedTextureMetadataLock) {
                this.renderedTextureMetadata = null;
            }
            this.callback = null;
            this.frameInfos.clear();
            return releaseInternal;
        }
        return (VideoCodecStatus) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.webrtc.MediaCodecWrapper, java.lang.Thread] */
    private VideoCodecStatus releaseInternal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            if (!this.running) {
                Logging.d(TAG, "release: Decoder is not running.");
                return VideoCodecStatus.OK;
            }
            try {
                this.running = false;
                if (!ThreadUtils.joinUninterruptibly(this.outputThread, 5000L)) {
                    Logging.e(TAG, "Media decoder release timeout", new RuntimeException());
                    return VideoCodecStatus.TIMEOUT;
                } else if (this.shutdownException != null) {
                    Logging.e(TAG, "Media decoder release error", new RuntimeException(this.shutdownException));
                    this.shutdownException = null;
                    return VideoCodecStatus.ERROR;
                } else {
                    this.codec = null;
                    this.outputThread = null;
                    return VideoCodecStatus.OK;
                }
            } finally {
                this.codec = null;
                this.outputThread = null;
            }
        }
        return (VideoCodecStatus) invokeV.objValue;
    }

    public void deliverDecodedFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.outputThreadChecker.checkIsOnValidThread();
            try {
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                int dequeueOutputBuffer = this.codec.dequeueOutputBuffer(bufferInfo, 100000L);
                if (dequeueOutputBuffer == -2) {
                    reformat(this.codec.getOutputFormat());
                } else if (dequeueOutputBuffer < 0) {
                    Logging.v(TAG, "dequeueOutputBuffer returned " + dequeueOutputBuffer);
                } else {
                    FrameInfo poll = this.frameInfos.poll();
                    Integer num = null;
                    int i = 0;
                    if (poll != null) {
                        num = Integer.valueOf((int) (SystemClock.elapsedRealtime() - poll.decodeStartTimeMs));
                        i = poll.rotation;
                    }
                    this.hasDecodedFirstFrame = true;
                    if (this.surfaceTextureHelper != null) {
                        deliverTextureFrame(dequeueOutputBuffer, bufferInfo, i, num);
                    } else {
                        deliverByteFrame(dequeueOutputBuffer, bufferInfo, i, num);
                    }
                }
            } catch (IllegalStateException e) {
                Logging.e(TAG, "deliverDecodedFrame failed", e);
            }
        }
    }

    public void copyPlane(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{byteBuffer, Integer.valueOf(i), byteBuffer2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            YuvHelper.copyPlane(byteBuffer, i, byteBuffer2, i2, i3, i4);
        }
    }

    @Override // org.webrtc.VideoDecoder
    public VideoCodecStatus decode(EncodedImage encodedImage, VideoDecoder.DecodeInfo decodeInfo) {
        InterceptResult invokeLL;
        int i;
        int i2;
        VideoCodecStatus reinitDecode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, encodedImage, decodeInfo)) == null) {
            this.decoderThreadChecker.checkIsOnValidThread();
            boolean z = false;
            if (this.codec != null && this.callback != null) {
                ByteBuffer byteBuffer = encodedImage.buffer;
                if (byteBuffer == null) {
                    Logging.e(TAG, "decode() - no input data");
                    return VideoCodecStatus.ERR_PARAMETER;
                }
                int remaining = byteBuffer.remaining();
                if (remaining == 0) {
                    Logging.e(TAG, "decode() - input buffer empty");
                    return VideoCodecStatus.ERR_PARAMETER;
                }
                synchronized (this.dimensionLock) {
                    i = this.width;
                    i2 = this.height;
                }
                int i3 = encodedImage.encodedWidth;
                int i4 = encodedImage.encodedHeight;
                if (i3 * i4 > 0 && ((i3 != i || i4 != i2) && (reinitDecode = reinitDecode(encodedImage.encodedWidth, encodedImage.encodedHeight)) != VideoCodecStatus.OK)) {
                    return reinitDecode;
                }
                if (this.keyFrameRequired) {
                    if (encodedImage.frameType != EncodedImage.FrameType.VideoFrameKey) {
                        Logging.e(TAG, "decode() - key frame required first");
                        return VideoCodecStatus.NO_OUTPUT;
                    } else if (!encodedImage.completeFrame) {
                        Logging.e(TAG, "decode() - complete frame required first");
                        return VideoCodecStatus.NO_OUTPUT;
                    }
                }
                try {
                    int dequeueInputBuffer = this.codec.dequeueInputBuffer(500000L);
                    if (dequeueInputBuffer < 0) {
                        Logging.e(TAG, "decode() - no HW buffers available; decoder falling behind");
                        return VideoCodecStatus.ERROR;
                    }
                    try {
                        ByteBuffer byteBuffer2 = this.codec.getInputBuffers()[dequeueInputBuffer];
                        if (byteBuffer2.capacity() < remaining) {
                            Logging.e(TAG, "decode() - HW buffer too small");
                            return VideoCodecStatus.ERROR;
                        }
                        byteBuffer2.put(encodedImage.buffer);
                        this.frameInfos.offer(new FrameInfo(SystemClock.elapsedRealtime(), encodedImage.rotation));
                        try {
                            this.codec.queueInputBuffer(dequeueInputBuffer, 0, remaining, TimeUnit.NANOSECONDS.toMicros(encodedImage.captureTimeNs), 0);
                            if (this.keyFrameRequired) {
                                this.keyFrameRequired = false;
                            }
                            return VideoCodecStatus.OK;
                        } catch (IllegalStateException e) {
                            Logging.e(TAG, "queueInputBuffer failed", e);
                            this.frameInfos.pollLast();
                            return VideoCodecStatus.ERROR;
                        }
                    } catch (IllegalStateException e2) {
                        Logging.e(TAG, "getInputBuffers failed", e2);
                        return VideoCodecStatus.ERROR;
                    }
                } catch (IllegalStateException e3) {
                    Logging.e(TAG, "dequeueInputBuffer failed", e3);
                    return VideoCodecStatus.ERROR;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("decode uninitalized, codec: ");
            if (this.codec != null) {
                z = true;
            }
            sb.append(z);
            sb.append(", callback: ");
            sb.append(this.callback);
            Logging.d(TAG, sb.toString());
            return VideoCodecStatus.UNINITIALIZED;
        }
        return (VideoCodecStatus) invokeLL.objValue;
    }

    @Override // org.webrtc.VideoDecoder
    public VideoCodecStatus initDecode(VideoDecoder.Settings settings, VideoDecoder.Callback callback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, settings, callback)) == null) {
            this.decoderThreadChecker = new ThreadUtils.ThreadChecker();
            this.callback = callback;
            if (this.sharedContext != null) {
                this.surfaceTextureHelper = createSurfaceTextureHelper();
                this.surface = new Surface(this.surfaceTextureHelper.getSurfaceTexture());
                this.surfaceTextureHelper.startListening(this);
            }
            return initDecodeInternal(settings.width, settings.height);
        }
        return (VideoCodecStatus) invokeLL.objValue;
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        long j;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, videoFrame) == null) {
            synchronized (this.renderedTextureMetadataLock) {
                if (this.renderedTextureMetadata != null) {
                    j = this.renderedTextureMetadata.presentationTimestampUs * 1000;
                    intValue = this.renderedTextureMetadata.decodeTimeMs.intValue();
                    this.renderedTextureMetadata = null;
                } else {
                    throw new IllegalStateException("Rendered texture metadata was null in onTextureFrameAvailable.");
                }
            }
            this.callback.onDecodedFrame(new VideoFrame(videoFrame.getBuffer(), videoFrame.getRotation(), j), Integer.valueOf(intValue), null);
        }
    }
}
