package org.webrtc;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Bundle;
import android.view.Surface;
import com.kwai.video.player.KsMediaMeta;
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
/* loaded from: classes.dex */
public class HardwareVideoEncoder implements VideoEncoder {
    public static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT_US = 100000;
    public static final String KEY_BITRATE_MODE = "bitrate-mode";
    public static final int MAX_ENCODER_Q_SIZE = 2;
    public static final int MAX_VIDEO_FRAMERATE = 30;
    public static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    public static final String TAG = "HardwareVideoEncoder";
    public static final int VIDEO_AVC_LEVEL_3 = 256;
    public static final int VIDEO_AVC_PROFILE_HIGH = 8;
    public static final int VIDEO_ControlRateConstant = 2;
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
    public final long forcedKeyFrameNs;
    public int height;
    public final int keyFrameIntervalSec;
    public long lastKeyFrameNs;
    public final MediaCodecWrapperFactory mediaCodecWrapperFactory;
    @Nullable
    public Thread outputThread;
    public final Map<String, String> params;
    public volatile boolean running;
    public final EglBase14.Context sharedContext;
    @Nullable
    public volatile Exception shutdownException;
    public final Integer surfaceColorFormat;
    @Nullable
    public EglBase14 textureEglBase;
    @Nullable
    public Surface textureInputSurface;
    public boolean useSurfaceMode;
    public int width;
    public final Integer yuvColorFormat;
    public final YuvFormat yuvFormat;
    public final GlRectDrawer textureDrawer = new GlRectDrawer();
    public final VideoFrameDrawer videoFrameDrawer = new VideoFrameDrawer();
    public final BlockingDeque<EncodedImage.Builder> outputBuilders = new LinkedBlockingDeque();
    public final ThreadUtils.ThreadChecker encodeThreadChecker = new ThreadUtils.ThreadChecker();
    public final ThreadUtils.ThreadChecker outputThreadChecker = new ThreadUtils.ThreadChecker();

    /* loaded from: classes7.dex */
    public enum YuvFormat {
        I420 { // from class: org.webrtc.HardwareVideoEncoder.YuvFormat.1
            @Override // org.webrtc.HardwareVideoEncoder.YuvFormat
            public void fillBuffer(ByteBuffer byteBuffer, VideoFrame.Buffer buffer) {
                VideoFrame.I420Buffer i420 = buffer.toI420();
                YuvHelper.I420Copy(i420.getDataY(), i420.getStrideY(), i420.getDataU(), i420.getStrideU(), i420.getDataV(), i420.getStrideV(), byteBuffer, i420.getWidth(), i420.getHeight());
                i420.release();
            }
        },
        NV12 { // from class: org.webrtc.HardwareVideoEncoder.YuvFormat.2
            @Override // org.webrtc.HardwareVideoEncoder.YuvFormat
            public void fillBuffer(ByteBuffer byteBuffer, VideoFrame.Buffer buffer) {
                VideoFrame.I420Buffer i420 = buffer.toI420();
                YuvHelper.I420ToNV12(i420.getDataY(), i420.getStrideY(), i420.getDataU(), i420.getStrideU(), i420.getDataV(), i420.getStrideV(), byteBuffer, i420.getWidth(), i420.getHeight());
                i420.release();
            }
        };

        public static YuvFormat valueOf(int i) {
            if (i != 19) {
                if (i == 21 || i == 2141391872 || i == 2141391876) {
                    return NV12;
                }
                throw new IllegalArgumentException("Unsupported colorFormat: " + i);
            }
            return I420;
        }

        public abstract void fillBuffer(ByteBuffer byteBuffer, VideoFrame.Buffer buffer);
    }

    public HardwareVideoEncoder(MediaCodecWrapperFactory mediaCodecWrapperFactory, String str, VideoCodecType videoCodecType, Integer num, Integer num2, Map<String, String> map, int i, int i2, BitrateAdjuster bitrateAdjuster, EglBase14.Context context) {
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
        return (this.sharedContext == null || this.surfaceColorFormat == null) ? false : true;
    }

    private Thread createOutputThread() {
        return new Thread() { // from class: org.webrtc.HardwareVideoEncoder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (HardwareVideoEncoder.this.running) {
                    HardwareVideoEncoder.this.deliverEncodedImage();
                }
                HardwareVideoEncoder.this.releaseCodecOnOutputThread();
            }
        };
    }

    private VideoCodecStatus encodeByteBuffer(VideoFrame videoFrame, VideoFrame.Buffer buffer, int i) {
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

    private VideoCodecStatus encodeTextureBuffer(VideoFrame videoFrame) {
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

    /* JADX WARN: Code restructure failed: missing block: B:28:0x008d, code lost:
        if (r5 == 1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008f, code lost:
        org.webrtc.Logging.w(org.webrtc.HardwareVideoEncoder.TAG, "Unknown profile level id: " + r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private VideoCodecStatus initEncodeInternal() {
        this.encodeThreadChecker.checkIsOnValidThread();
        this.lastKeyFrameNs = -1L;
        try {
            this.codec = this.mediaCodecWrapperFactory.createByCodecName(this.codecName);
            int intValue = (this.useSurfaceMode ? this.surfaceColorFormat : this.yuvColorFormat).intValue();
            try {
                MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.codecType.mimeType(), this.width, this.height);
                createVideoFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, this.adjustedBitrate);
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
                Logging.d(TAG, "Format: " + createVideoFormat);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCodecOnOutputThread() {
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

    private void requestKeyFrame(long j) {
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

    private VideoCodecStatus resetCodec(int i, int i2, boolean z) {
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

    private boolean shouldForceKeyFrame(long j) {
        this.encodeThreadChecker.checkIsOnValidThread();
        long j2 = this.forcedKeyFrameNs;
        return j2 > 0 && j > this.lastKeyFrameNs + j2;
    }

    private VideoCodecStatus updateBitrate() {
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

    @Override // org.webrtc.VideoEncoder
    @CalledByNative
    public long createNativeVideoEncoder() {
        return VideoEncoder_CC.$default$createNativeVideoEncoder(this);
    }

    public void deliverEncodedImage() {
        ByteBuffer slice;
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

    @Override // org.webrtc.VideoEncoder
    public VideoCodecStatus encode(VideoFrame videoFrame, VideoEncoder.EncodeInfo encodeInfo) {
        VideoCodecStatus resetCodec;
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
            VideoCodecStatus encodeTextureBuffer = this.useSurfaceMode ? encodeTextureBuffer(videoFrame) : encodeByteBuffer(videoFrame, buffer, height2);
            if (encodeTextureBuffer != VideoCodecStatus.OK) {
                this.outputBuilders.pollLast();
            }
            return encodeTextureBuffer;
        }
        return resetCodec;
    }

    public void fillInputBuffer(ByteBuffer byteBuffer, VideoFrame.Buffer buffer) {
        this.yuvFormat.fillBuffer(byteBuffer, buffer);
    }

    @Override // org.webrtc.VideoEncoder
    public String getImplementationName() {
        return "HWEncoder";
    }

    @Override // org.webrtc.VideoEncoder
    public VideoEncoder.ScalingSettings getScalingSettings() {
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

    @Override // org.webrtc.VideoEncoder
    public VideoCodecStatus initEncode(VideoEncoder.Settings settings, VideoEncoder.Callback callback) {
        int i;
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

    @Override // org.webrtc.VideoEncoder
    @CalledByNative
    public boolean isHardwareEncoder() {
        return VideoEncoder_CC.$default$isHardwareEncoder(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    @Override // org.webrtc.VideoEncoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public VideoCodecStatus release() {
        VideoCodecStatus videoCodecStatus;
        EglBase14 eglBase14;
        Surface surface;
        this.encodeThreadChecker.checkIsOnValidThread();
        if (this.outputThread != null) {
            this.running = false;
            if (!ThreadUtils.joinUninterruptibly(this.outputThread, 5000L)) {
                Logging.e(TAG, "Media encoder release timeout");
                videoCodecStatus = VideoCodecStatus.TIMEOUT;
            } else if (this.shutdownException != null) {
                Logging.e(TAG, "Media encoder release exception", this.shutdownException);
                videoCodecStatus = VideoCodecStatus.ERROR;
            }
            this.textureDrawer.release();
            this.videoFrameDrawer.release();
            eglBase14 = this.textureEglBase;
            if (eglBase14 != null) {
                eglBase14.release();
                this.textureEglBase = null;
            }
            surface = this.textureInputSurface;
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
        videoCodecStatus = VideoCodecStatus.OK;
        this.textureDrawer.release();
        this.videoFrameDrawer.release();
        eglBase14 = this.textureEglBase;
        if (eglBase14 != null) {
        }
        surface = this.textureInputSurface;
        if (surface != null) {
        }
        this.outputBuilders.clear();
        this.codec = null;
        this.outputThread = null;
        this.encodeThreadChecker.detachThread();
        return videoCodecStatus;
    }

    @Override // org.webrtc.VideoEncoder
    public VideoCodecStatus setRateAllocation(VideoEncoder.BitrateAllocation bitrateAllocation, int i) {
        this.encodeThreadChecker.checkIsOnValidThread();
        if (i > 30) {
            i = 30;
        }
        this.bitrateAdjuster.setTargets(bitrateAllocation.getSum(), i);
        return VideoCodecStatus.OK;
    }
}
