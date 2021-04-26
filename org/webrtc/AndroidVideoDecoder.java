package org.webrtc;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.view.Surface;
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
/* loaded from: classes7.dex */
public class AndroidVideoDecoder implements VideoDecoder, VideoSink {
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
    @Nullable
    public VideoDecoder.Callback callback;
    @Nullable
    public MediaCodecWrapper codec;
    public final String codecName;
    public final VideoCodecType codecType;
    public int colorFormat;
    public ThreadUtils.ThreadChecker decoderThreadChecker;
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
    public final Object dimensionLock = new Object();
    public final Object renderedTextureMetadataLock = new Object();

    /* loaded from: classes7.dex */
    public static class DecodedTextureMetadata {
        public final Integer decodeTimeMs;
        public final long presentationTimestampUs;

        public DecodedTextureMetadata(long j, Integer num) {
            this.presentationTimestampUs = j;
            this.decodeTimeMs = num;
        }
    }

    /* loaded from: classes7.dex */
    public static class FrameInfo {
        public final long decodeStartTimeMs;
        public final int rotation;

        public FrameInfo(long j, int i2) {
            this.decodeStartTimeMs = j;
            this.rotation = i2;
        }
    }

    public AndroidVideoDecoder(MediaCodecWrapperFactory mediaCodecWrapperFactory, String str, VideoCodecType videoCodecType, int i2, @Nullable EglBase.Context context) {
        if (!isSupportedColorFormat(i2)) {
            throw new IllegalArgumentException("Unsupported color format: " + i2);
        }
        Logging.d(TAG, "ctor name: " + str + " type: " + videoCodecType + " color format: " + i2 + " context: " + context);
        this.mediaCodecWrapperFactory = mediaCodecWrapperFactory;
        this.codecName = str;
        this.codecType = videoCodecType;
        this.colorFormat = i2;
        this.sharedContext = context;
        this.frameInfos = new LinkedBlockingDeque();
    }

    private VideoFrame.Buffer copyI420Buffer(ByteBuffer byteBuffer, int i2, int i3, int i4, int i5) {
        if (i2 % 2 != 0) {
            throw new AssertionError("Stride is not divisible by two: " + i2);
        }
        int i6 = (i4 + 1) / 2;
        int i7 = i3 % 2;
        int i8 = i7 == 0 ? (i5 + 1) / 2 : i5 / 2;
        int i9 = i2 / 2;
        int i10 = (i2 * i3) + 0;
        int i11 = i9 * i8;
        int i12 = i10 + ((i9 * i3) / 2);
        VideoFrame.I420Buffer allocateI420Buffer = allocateI420Buffer(i4, i5);
        byteBuffer.limit((i2 * i5) + 0);
        byteBuffer.position(0);
        copyPlane(byteBuffer.slice(), i2, allocateI420Buffer.getDataY(), allocateI420Buffer.getStrideY(), i4, i5);
        byteBuffer.limit(i10 + i11);
        byteBuffer.position(i10);
        copyPlane(byteBuffer.slice(), i9, allocateI420Buffer.getDataU(), allocateI420Buffer.getStrideU(), i6, i8);
        if (i7 == 1) {
            byteBuffer.position(i10 + ((i8 - 1) * i9));
            ByteBuffer dataU = allocateI420Buffer.getDataU();
            dataU.position(allocateI420Buffer.getStrideU() * i8);
            dataU.put(byteBuffer);
        }
        byteBuffer.limit(i11 + i12);
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

    private VideoFrame.Buffer copyNV12ToI420Buffer(ByteBuffer byteBuffer, int i2, int i3, int i4, int i5) {
        return new NV12Buffer(i4, i5, i2, i3, byteBuffer, null).toI420();
    }

    private Thread createOutputThread() {
        return new Thread("AndroidVideoDecoder.outputThread") { // from class: org.webrtc.AndroidVideoDecoder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                AndroidVideoDecoder.this.outputThreadChecker = new ThreadUtils.ThreadChecker();
                while (AndroidVideoDecoder.this.running) {
                    AndroidVideoDecoder.this.deliverDecodedFrame();
                }
                AndroidVideoDecoder.this.releaseCodecOnOutputThread();
            }
        };
    }

    private void deliverByteFrame(int i2, MediaCodec.BufferInfo bufferInfo, int i3, Integer num) {
        int i4;
        int i5;
        int i6;
        int i7;
        synchronized (this.dimensionLock) {
            i4 = this.width;
            i5 = this.height;
            i6 = this.stride;
            i7 = this.sliceHeight;
        }
        int i8 = bufferInfo.size;
        if (i8 < ((i4 * i5) * 3) / 2) {
            Logging.e(TAG, "Insufficient output buffer size: " + bufferInfo.size);
            return;
        }
        int i9 = (i8 >= ((i6 * i5) * 3) / 2 || i7 != i5 || i6 <= i4) ? i6 : (i8 * 2) / (i5 * 3);
        ByteBuffer byteBuffer = this.codec.getOutputBuffers()[i2];
        byteBuffer.position(bufferInfo.offset);
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        ByteBuffer slice = byteBuffer.slice();
        VideoFrame.Buffer copyI420Buffer = this.colorFormat == 19 ? copyI420Buffer(slice, i9, i7, i4, i5) : copyNV12ToI420Buffer(slice, i9, i7, i4, i5);
        this.codec.releaseOutputBuffer(i2, false);
        VideoFrame videoFrame = new VideoFrame(copyI420Buffer, i3, bufferInfo.presentationTimeUs * 1000);
        this.callback.onDecodedFrame(videoFrame, num, null);
        videoFrame.release();
    }

    private void deliverTextureFrame(int i2, MediaCodec.BufferInfo bufferInfo, int i3, Integer num) {
        int i4;
        int i5;
        synchronized (this.dimensionLock) {
            i4 = this.width;
            i5 = this.height;
        }
        synchronized (this.renderedTextureMetadataLock) {
            if (this.renderedTextureMetadata != null) {
                this.codec.releaseOutputBuffer(i2, false);
                return;
            }
            this.surfaceTextureHelper.setTextureSize(i4, i5);
            this.surfaceTextureHelper.setFrameRotation(i3);
            this.renderedTextureMetadata = new DecodedTextureMetadata(bufferInfo.presentationTimeUs, num);
            this.codec.releaseOutputBuffer(i2, true);
        }
    }

    private VideoCodecStatus initDecodeInternal(int i2, int i3) {
        this.decoderThreadChecker.checkIsOnValidThread();
        Logging.d(TAG, "initDecodeInternal name: " + this.codecName + " type: " + this.codecType + " width: " + i2 + " height: " + i3);
        if (this.outputThread != null) {
            Logging.e(TAG, "initDecodeInternal called while the codec is already running");
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
        this.width = i2;
        this.height = i3;
        this.stride = i2;
        this.sliceHeight = i3;
        this.hasDecodedFirstFrame = false;
        this.keyFrameRequired = true;
        try {
            this.codec = this.mediaCodecWrapperFactory.createByCodecName(this.codecName);
            try {
                MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.codecType.mimeType(), i2, i3);
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
            } catch (IllegalStateException e2) {
                Logging.e(TAG, "initDecode failed", e2);
                release();
                return VideoCodecStatus.FALLBACK_SOFTWARE;
            }
        } catch (IOException | IllegalArgumentException unused) {
            Logging.e(TAG, "Cannot create media decoder " + this.codecName);
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
    }

    private boolean isSupportedColorFormat(int i2) {
        for (int i3 : MediaCodecUtils.DECODER_COLOR_FORMATS) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    private void reformat(MediaFormat mediaFormat) {
        int integer;
        int integer2;
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

    private VideoCodecStatus reinitDecode(int i2, int i3) {
        this.decoderThreadChecker.checkIsOnValidThread();
        VideoCodecStatus releaseInternal = releaseInternal();
        return releaseInternal != VideoCodecStatus.OK ? releaseInternal : initDecodeInternal(i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCodecOnOutputThread() {
        this.outputThreadChecker.checkIsOnValidThread();
        Logging.d(TAG, "Releasing MediaCodec on output thread");
        try {
            this.codec.stop();
        } catch (Exception e2) {
            Logging.e(TAG, "Media decoder stop failed", e2);
        }
        try {
            this.codec.release();
        } catch (Exception e3) {
            Logging.e(TAG, "Media decoder release failed", e3);
            this.shutdownException = e3;
        }
        Logging.d(TAG, "Release on output thread done");
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.webrtc.MediaCodecWrapper, java.lang.Thread] */
    private VideoCodecStatus releaseInternal() {
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

    private void stopOnOutputThread(Exception exc) {
        this.outputThreadChecker.checkIsOnValidThread();
        this.running = false;
        this.shutdownException = exc;
    }

    public VideoFrame.I420Buffer allocateI420Buffer(int i2, int i3) {
        return JavaI420Buffer.allocate(i2, i3);
    }

    public void copyPlane(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, int i4, int i5) {
        YuvHelper.copyPlane(byteBuffer, i2, byteBuffer2, i3, i4, i5);
    }

    @Override // org.webrtc.VideoDecoder
    @CalledByNative
    public long createNativeVideoDecoder() {
        return VideoDecoder_CC.$default$createNativeVideoDecoder(this);
    }

    public SurfaceTextureHelper createSurfaceTextureHelper() {
        return SurfaceTextureHelper.create("decoder-texture-thread", this.sharedContext);
    }

    @Override // org.webrtc.VideoDecoder
    public VideoCodecStatus decode(EncodedImage encodedImage, VideoDecoder.DecodeInfo decodeInfo) {
        int i2;
        int i3;
        VideoCodecStatus reinitDecode;
        this.decoderThreadChecker.checkIsOnValidThread();
        if (this.codec == null || this.callback == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("decode uninitalized, codec: ");
            sb.append(this.codec != null);
            sb.append(", callback: ");
            sb.append(this.callback);
            Logging.d(TAG, sb.toString());
            return VideoCodecStatus.UNINITIALIZED;
        }
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
            i2 = this.width;
            i3 = this.height;
        }
        int i4 = encodedImage.encodedWidth;
        int i5 = encodedImage.encodedHeight;
        if (i4 * i5 <= 0 || ((i4 == i2 && i5 == i3) || (reinitDecode = reinitDecode(encodedImage.encodedWidth, encodedImage.encodedHeight)) == VideoCodecStatus.OK)) {
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
                    } catch (IllegalStateException e2) {
                        Logging.e(TAG, "queueInputBuffer failed", e2);
                        this.frameInfos.pollLast();
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
        return reinitDecode;
    }

    public void deliverDecodedFrame() {
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
                int i2 = 0;
                if (poll != null) {
                    num = Integer.valueOf((int) (SystemClock.elapsedRealtime() - poll.decodeStartTimeMs));
                    i2 = poll.rotation;
                }
                this.hasDecodedFirstFrame = true;
                if (this.surfaceTextureHelper != null) {
                    deliverTextureFrame(dequeueOutputBuffer, bufferInfo, i2, num);
                } else {
                    deliverByteFrame(dequeueOutputBuffer, bufferInfo, i2, num);
                }
            }
        } catch (IllegalStateException e2) {
            Logging.e(TAG, "deliverDecodedFrame failed", e2);
        }
    }

    @Override // org.webrtc.VideoDecoder
    public String getImplementationName() {
        return this.codecName;
    }

    @Override // org.webrtc.VideoDecoder
    public boolean getPrefersLateDecoding() {
        return true;
    }

    @Override // org.webrtc.VideoDecoder
    public VideoCodecStatus initDecode(VideoDecoder.Settings settings, VideoDecoder.Callback callback) {
        this.decoderThreadChecker = new ThreadUtils.ThreadChecker();
        this.callback = callback;
        if (this.sharedContext != null) {
            this.surfaceTextureHelper = createSurfaceTextureHelper();
            this.surface = new Surface(this.surfaceTextureHelper.getSurfaceTexture());
            this.surfaceTextureHelper.startListening(this);
        }
        return initDecodeInternal(settings.width, settings.height);
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        long j;
        int intValue;
        synchronized (this.renderedTextureMetadataLock) {
            if (this.renderedTextureMetadata == null) {
                throw new IllegalStateException("Rendered texture metadata was null in onTextureFrameAvailable.");
            }
            j = this.renderedTextureMetadata.presentationTimestampUs;
            intValue = this.renderedTextureMetadata.decodeTimeMs.intValue();
            this.renderedTextureMetadata = null;
        }
        this.callback.onDecodedFrame(new VideoFrame(videoFrame.getBuffer(), videoFrame.getRotation(), j * 1000), Integer.valueOf(intValue), null);
    }

    @Override // org.webrtc.VideoDecoder
    public VideoCodecStatus release() {
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

    public void releaseSurface() {
        this.surface.release();
    }
}
