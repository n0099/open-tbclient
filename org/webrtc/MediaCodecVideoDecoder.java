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
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
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
/* loaded from: classes7.dex */
public class MediaCodecVideoDecoder {
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
    @Nullable
    public static MediaCodecVideoDecoder runningInstance = null;
    public static final String supportedExynosH264HighProfileHwCodecPrefix = "OMX.Exynos.";
    public static final String supportedHisiH264HighProfileHwCodecPrefix = "OMX.hisi.";
    public static final String supportedMediaTekH264HighProfileHwCodecPrefix = "OMX.MTK.";
    public static final String supportedQcomH264HighProfileHwCodecPrefix = "OMX.qcom.";
    public int colorFormat;
    public final Queue<TimeStamps> decodeStartTimeMs = new ArrayDeque();
    public final Queue<DecodedOutputBuffer> dequeuedSurfaceOutputBuffers = new ArrayDeque();
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
    public static Set<String> hwDecoderDisabledTypes = new HashSet();
    public static final String[] supportedVp9HwCodecPrefixes = {"OMX.qcom.", "OMX.Exynos."};
    public static final List<Integer> supportedColorList = Arrays.asList(19, 21, 2141391872, 2141391873, 2141391874, 2141391875, 2141391876);

    /* loaded from: classes7.dex */
    public static class DecodedOutputBuffer {
        public final long decodeTimeMs;
        public final long endDecodeTimeMs;
        public final int index;
        public final long ntpTimeStampMs;
        public final int offset;
        public final long presentationTimeStampMs;
        public final int size;
        public final long timeStampMs;

        public DecodedOutputBuffer(int i2, int i3, int i4, long j, long j2, long j3, long j4, long j5) {
            this.index = i2;
            this.offset = i3;
            this.size = i4;
            this.presentationTimeStampMs = j;
            this.timeStampMs = j2;
            this.ntpTimeStampMs = j3;
            this.decodeTimeMs = j4;
            this.endDecodeTimeMs = j5;
        }

        @CalledByNative("DecodedOutputBuffer")
        public long getDecodeTimeMs() {
            return this.decodeTimeMs;
        }

        @CalledByNative("DecodedOutputBuffer")
        public int getIndex() {
            return this.index;
        }

        @CalledByNative("DecodedOutputBuffer")
        public long getNtpTimestampMs() {
            return this.ntpTimeStampMs;
        }

        @CalledByNative("DecodedOutputBuffer")
        public int getOffset() {
            return this.offset;
        }

        @CalledByNative("DecodedOutputBuffer")
        public long getPresentationTimestampMs() {
            return this.presentationTimeStampMs;
        }

        @CalledByNative("DecodedOutputBuffer")
        public int getSize() {
            return this.size;
        }

        @CalledByNative("DecodedOutputBuffer")
        public long getTimestampMs() {
            return this.timeStampMs;
        }
    }

    /* loaded from: classes7.dex */
    public static class DecodedTextureBuffer {
        public final long decodeTimeMs;
        public final long frameDelayMs;
        public final long ntpTimeStampMs;
        public final long presentationTimeStampMs;
        public final long timeStampMs;
        public final VideoFrame.Buffer videoFrameBuffer;

        public DecodedTextureBuffer(VideoFrame.Buffer buffer, long j, long j2, long j3, long j4, long j5) {
            this.videoFrameBuffer = buffer;
            this.presentationTimeStampMs = j;
            this.timeStampMs = j2;
            this.ntpTimeStampMs = j3;
            this.decodeTimeMs = j4;
            this.frameDelayMs = j5;
        }

        @CalledByNative("DecodedTextureBuffer")
        public long getDecodeTimeMs() {
            return this.decodeTimeMs;
        }

        @CalledByNative("DecodedTextureBuffer")
        public long getFrameDelayMs() {
            return this.frameDelayMs;
        }

        @CalledByNative("DecodedTextureBuffer")
        public long getNtpTimestampMs() {
            return this.ntpTimeStampMs;
        }

        @CalledByNative("DecodedTextureBuffer")
        public long getPresentationTimestampMs() {
            return this.presentationTimeStampMs;
        }

        @CalledByNative("DecodedTextureBuffer")
        public long getTimeStampMs() {
            return this.timeStampMs;
        }

        @CalledByNative("DecodedTextureBuffer")
        public VideoFrame.Buffer getVideoFrameBuffer() {
            return this.videoFrameBuffer;
        }
    }

    /* loaded from: classes7.dex */
    public static class DecoderProperties {
        public final String codecName;
        public final int colorFormat;

        public DecoderProperties(String str, int i2) {
            this.codecName = str;
            this.colorFormat = i2;
        }
    }

    /* loaded from: classes7.dex */
    public static class HwDecoderFactory implements VideoDecoderFactory {
        public final VideoCodecInfo[] supportedHardwareCodecs = getSupportedHardwareCodecs();

        public static VideoCodecInfo[] getSupportedHardwareCodecs() {
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

        public static boolean isCodecSupported(VideoCodecInfo[] videoCodecInfoArr, VideoCodecInfo videoCodecInfo) {
            for (VideoCodecInfo videoCodecInfo2 : videoCodecInfoArr) {
                if (isSameCodec(videoCodecInfo2, videoCodecInfo)) {
                    return true;
                }
            }
            return false;
        }

        public static boolean isSameCodec(VideoCodecInfo videoCodecInfo, VideoCodecInfo videoCodecInfo2) {
            if (videoCodecInfo.name.equalsIgnoreCase(videoCodecInfo2.name)) {
                if (videoCodecInfo.name.equalsIgnoreCase(PeerConnectionClient.VIDEO_CODEC_H264)) {
                    return H264Utils.isSameH264Profile(videoCodecInfo.params, videoCodecInfo2.params);
                }
                return true;
            }
            return false;
        }

        @Override // org.webrtc.VideoDecoderFactory
        @javax.annotation.Nullable
        @Deprecated
        public VideoDecoder createDecoder(String str) {
            return VideoDecoderFactory_CC.$default$createDecoder(this, str);
        }

        @Override // org.webrtc.VideoDecoderFactory
        @Nullable
        public VideoDecoder createDecoder(final VideoCodecInfo videoCodecInfo) {
            if (isCodecSupported(this.supportedHardwareCodecs, videoCodecInfo)) {
                Logging.d(MediaCodecVideoDecoder.TAG, "Create HW video decoder for " + videoCodecInfo.name);
                return new WrappedNativeVideoDecoder() { // from class: org.webrtc.MediaCodecVideoDecoder.HwDecoderFactory.1
                    @Override // org.webrtc.WrappedNativeVideoDecoder, org.webrtc.VideoDecoder
                    public long createNativeVideoDecoder() {
                        return MediaCodecVideoDecoder.nativeCreateDecoder(videoCodecInfo.name, MediaCodecVideoDecoder.useSurface());
                    }
                };
            }
            Logging.d(MediaCodecVideoDecoder.TAG, "No HW video decoder for codec " + videoCodecInfo.name);
            return null;
        }

        @Override // org.webrtc.VideoDecoderFactory
        public VideoCodecInfo[] getSupportedCodecs() {
            return this.supportedHardwareCodecs;
        }
    }

    /* loaded from: classes7.dex */
    public interface MediaCodecVideoDecoderErrorCallback {
        void onMediaCodecVideoDecoderCriticalError(int i2);
    }

    /* loaded from: classes7.dex */
    public class TextureListener implements VideoSink {
        @Nullable
        public DecodedOutputBuffer bufferToRender;
        public final Object newFrameLock = new Object();
        @Nullable
        public DecodedTextureBuffer renderedBuffer;
        public final SurfaceTextureHelper surfaceTextureHelper;

        public TextureListener(SurfaceTextureHelper surfaceTextureHelper) {
            this.surfaceTextureHelper = surfaceTextureHelper;
            surfaceTextureHelper.startListening(this);
        }

        public void addBufferToRender(DecodedOutputBuffer decodedOutputBuffer) {
            if (this.bufferToRender == null) {
                this.bufferToRender = decodedOutputBuffer;
            } else {
                Logging.e(MediaCodecVideoDecoder.TAG, "Unexpected addBufferToRender() called while waiting for a texture.");
                throw new IllegalStateException("Waiting for a texture.");
            }
        }

        @Nullable
        public DecodedTextureBuffer dequeueTextureBuffer(int i2) {
            DecodedTextureBuffer decodedTextureBuffer;
            synchronized (this.newFrameLock) {
                if (this.renderedBuffer == null && i2 > 0 && isWaitingForTexture()) {
                    try {
                        this.newFrameLock.wait(i2);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                decodedTextureBuffer = this.renderedBuffer;
                this.renderedBuffer = null;
            }
            return decodedTextureBuffer;
        }

        public boolean isWaitingForTexture() {
            boolean z;
            synchronized (this.newFrameLock) {
                z = this.bufferToRender != null;
            }
            return z;
        }

        @Override // org.webrtc.VideoSink
        public void onFrame(VideoFrame videoFrame) {
            synchronized (this.newFrameLock) {
                if (this.renderedBuffer != null) {
                    Logging.e(MediaCodecVideoDecoder.TAG, "Unexpected onFrame() called while already holding a texture.");
                    throw new IllegalStateException("Already holding a texture.");
                }
                VideoFrame.Buffer buffer = videoFrame.getBuffer();
                buffer.retain();
                this.renderedBuffer = new DecodedTextureBuffer(buffer, this.bufferToRender.presentationTimeStampMs, this.bufferToRender.timeStampMs, this.bufferToRender.ntpTimeStampMs, this.bufferToRender.decodeTimeMs, SystemClock.elapsedRealtime() - this.bufferToRender.endDecodeTimeMs);
                this.bufferToRender = null;
                this.newFrameLock.notifyAll();
            }
        }

        public void release() {
            this.surfaceTextureHelper.stopListening();
            synchronized (this.newFrameLock) {
                if (this.renderedBuffer != null) {
                    this.renderedBuffer.getVideoFrameBuffer().release();
                    this.renderedBuffer = null;
                }
            }
            this.surfaceTextureHelper.dispose();
        }

        public void setSize(int i2, int i3) {
            this.surfaceTextureHelper.setTextureSize(i2, i3);
        }
    }

    /* loaded from: classes7.dex */
    public static class TimeStamps {
        public final long decodeStartTimeMs;
        public final long ntpTimeStampMs;
        public final long timeStampMs;

        public TimeStamps(long j, long j2, long j3) {
            this.decodeStartTimeMs = j;
            this.timeStampMs = j2;
            this.ntpTimeStampMs = j3;
        }
    }

    /* loaded from: classes7.dex */
    public enum VideoCodecType {
        VIDEO_CODEC_UNKNOWN,
        VIDEO_CODEC_VP8,
        VIDEO_CODEC_VP9,
        VIDEO_CODEC_H264;

        @CalledByNative("VideoCodecType")
        public static VideoCodecType fromNativeIndex(int i2) {
            return values()[i2];
        }
    }

    private void MaybeRenderDecodedTextureBuffer() {
        if (this.dequeuedSurfaceOutputBuffers.isEmpty() || this.textureListener.isWaitingForTexture()) {
            return;
        }
        DecodedOutputBuffer remove = this.dequeuedSurfaceOutputBuffers.remove();
        this.textureListener.addBufferToRender(remove);
        this.mediaCodec.releaseOutputBuffer(remove.index, true);
    }

    private void checkOnMediaCodecThread() throws IllegalStateException {
        if (this.mediaCodecThread.getId() == Thread.currentThread().getId()) {
            return;
        }
        throw new IllegalStateException("MediaCodecVideoDecoder previously operated on " + this.mediaCodecThread + " but is now called on " + Thread.currentThread());
    }

    public static VideoDecoderFactory createFactory() {
        return new DefaultVideoDecoderFactory(new HwDecoderFactory());
    }

    @CalledByNativeUnchecked
    private int dequeueInputBuffer() {
        checkOnMediaCodecThread();
        try {
            return this.mediaCodec.dequeueInputBuffer(500000L);
        } catch (IllegalStateException e2) {
            Logging.e(TAG, "dequeueIntputBuffer failed", e2);
            return -2;
        }
    }

    @Nullable
    @CalledByNativeUnchecked
    private DecodedOutputBuffer dequeueOutputBuffer(int i2) {
        long j;
        int integer;
        int integer2;
        checkOnMediaCodecThread();
        if (this.decodeStartTimeMs.isEmpty()) {
            return null;
        }
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        while (true) {
            int dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, TimeUnit.MILLISECONDS.toMicros(i2));
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
                            this.sliceHeight = PayBeanFactory.BEAN_ID_PAY_SETTING;
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

    @Nullable
    @CalledByNativeUnchecked
    private DecodedTextureBuffer dequeueTextureBuffer(int i2) {
        StringBuilder sb;
        String str;
        checkOnMediaCodecThread();
        if (useSurface()) {
            DecodedOutputBuffer dequeueOutputBuffer = dequeueOutputBuffer(i2);
            if (dequeueOutputBuffer != null) {
                this.dequeuedSurfaceOutputBuffers.add(dequeueOutputBuffer);
            }
            MaybeRenderDecodedTextureBuffer();
            DecodedTextureBuffer dequeueTextureBuffer = this.textureListener.dequeueTextureBuffer(i2);
            if (dequeueTextureBuffer != null) {
                MaybeRenderDecodedTextureBuffer();
                return dequeueTextureBuffer;
            } else if (this.dequeuedSurfaceOutputBuffers.size() >= Math.min(3, this.outputBuffers.length) || (i2 > 0 && !this.dequeuedSurfaceOutputBuffers.isEmpty())) {
                this.droppedFrames++;
                DecodedOutputBuffer remove = this.dequeuedSurfaceOutputBuffers.remove();
                if (i2 > 0) {
                    sb = new StringBuilder();
                    str = "Draining decoder. Dropping frame with TS: ";
                } else {
                    sb = new StringBuilder();
                    sb.append("Too many output buffers ");
                    sb.append(this.dequeuedSurfaceOutputBuffers.size());
                    str = ". Dropping frame with TS: ";
                }
                sb.append(str);
                sb.append(remove.presentationTimeStampMs);
                sb.append(". Total number of dropped frames: ");
                sb.append(this.droppedFrames);
                Logging.w(TAG, sb.toString());
                this.mediaCodec.releaseOutputBuffer(remove.index, false);
                return new DecodedTextureBuffer(null, remove.presentationTimeStampMs, remove.timeStampMs, remove.ntpTimeStampMs, remove.decodeTimeMs, SystemClock.elapsedRealtime() - remove.endDecodeTimeMs);
            } else {
                return null;
            }
        }
        throw new IllegalStateException("dequeueTexture() called for byte buffer decoding.");
    }

    public static void disableH264HwCodec() {
        Logging.w(TAG, "H.264 decoding is disabled by application.");
        hwDecoderDisabledTypes.add("video/avc");
    }

    public static void disableVp8HwCodec() {
        Logging.w(TAG, "VP8 decoding is disabled by application.");
        hwDecoderDisabledTypes.add("video/x-vnd.on2.vp8");
    }

    public static void disableVp9HwCodec() {
        Logging.w(TAG, "VP9 decoding is disabled by application.");
        hwDecoderDisabledTypes.add("video/x-vnd.on2.vp9");
    }

    public static void disposeEglContext() {
        EglBase eglBase2 = eglBase;
        if (eglBase2 != null) {
            eglBase2.release();
            eglBase = null;
        }
    }

    @Nullable
    public static DecoderProperties findDecoder(String str, String[] strArr) {
        MediaCodecInfo mediaCodecInfo;
        String str2;
        boolean z;
        int[] iArr;
        if (Build.VERSION.SDK_INT < 19) {
            return null;
        }
        Logging.d(TAG, "Trying to find HW decoder for mime " + str);
        for (int i2 = 0; i2 < MediaCodecList.getCodecCount(); i2++) {
            try {
                mediaCodecInfo = MediaCodecList.getCodecInfoAt(i2);
            } catch (IllegalArgumentException e2) {
                Logging.e(TAG, "Cannot retrieve decoder codec info", e2);
                mediaCodecInfo = null;
            }
            if (mediaCodecInfo != null && !mediaCodecInfo.isEncoder()) {
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                int length = supportedTypes.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        str2 = null;
                        break;
                    } else if (supportedTypes[i3].equals(str)) {
                        str2 = mediaCodecInfo.getName();
                        break;
                    } else {
                        i3++;
                    }
                }
                if (str2 == null) {
                    continue;
                } else {
                    Logging.d(TAG, "Found candidate decoder " + str2);
                    int length2 = strArr.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length2) {
                            z = false;
                            break;
                        } else if (str2.startsWith(strArr[i4])) {
                            z = true;
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (z) {
                        try {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                            for (int i5 : capabilitiesForType.colorFormats) {
                                Logging.v(TAG, "   Color: 0x" + Integer.toHexString(i5));
                            }
                            for (Integer num : supportedColorList) {
                                int intValue = num.intValue();
                                int[] iArr2 = capabilitiesForType.colorFormats;
                                int length3 = iArr2.length;
                                for (int i6 = 0; i6 < length3; i6++) {
                                    int i7 = iArr2[i6];
                                    if (i7 == intValue) {
                                        Logging.d(TAG, "Found target decoder " + str2 + ". Color: 0x" + Integer.toHexString(i7));
                                        if (Build.MODEL.contains("NV2001") || ((Build.MODEL.contains("Y13") || Build.MODEL.contains("R7")) && Build.MANUFACTURER.contains("rockchip"))) {
                                            Logging.d(TAG, "On Duer NV2001 .  enforce Color: 0x" + Integer.toHexString(21));
                                            i7 = 21;
                                        }
                                        return new DecoderProperties(str2, i7);
                                    }
                                }
                            }
                            continue;
                        } catch (IllegalArgumentException e3) {
                            Logging.e(TAG, "Cannot retrieve decoder capabilities", e3);
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

    @CalledByNativeUnchecked
    private boolean initDecode(VideoCodecType videoCodecType, int i2, int i3) {
        String[] supportedH264HwCodecPrefixes;
        String str;
        SurfaceTextureHelper create;
        if (this.mediaCodecThread == null) {
            if (videoCodecType == VideoCodecType.VIDEO_CODEC_VP8) {
                supportedH264HwCodecPrefixes = supportedVp8HwCodecPrefixes();
                str = "video/x-vnd.on2.vp8";
            } else if (videoCodecType == VideoCodecType.VIDEO_CODEC_VP9) {
                supportedH264HwCodecPrefixes = supportedVp9HwCodecPrefixes;
                str = "video/x-vnd.on2.vp9";
            } else if (videoCodecType != VideoCodecType.VIDEO_CODEC_H264) {
                throw new RuntimeException("initDecode: Non-supported codec " + videoCodecType);
            } else {
                supportedH264HwCodecPrefixes = supportedH264HwCodecPrefixes();
                str = "video/avc";
            }
            DecoderProperties findDecoder = findDecoder(str, supportedH264HwCodecPrefixes);
            if (findDecoder == null) {
                throw new RuntimeException("Cannot find HW decoder for " + videoCodecType);
            }
            Logging.d(TAG, "Java initDecode: " + videoCodecType + ZeusCrashHandler.NAME_SEPERATOR + i2 + " x " + i3 + ". Color: 0x" + Integer.toHexString(findDecoder.colorFormat) + ". Use Surface: " + useSurface());
            runningInstance = this;
            this.mediaCodecThread = Thread.currentThread();
            try {
                this.width = i2;
                this.height = i3;
                this.stride = i2;
                this.sliceHeight = i3;
                if (useSurface() && (create = SurfaceTextureHelper.create("Decoder SurfaceTextureHelper", eglBase.getEglBaseContext())) != null) {
                    TextureListener textureListener = new TextureListener(create);
                    this.textureListener = textureListener;
                    textureListener.setSize(i2, i3);
                    this.surface = new Surface(create.getSurfaceTexture());
                }
                MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, i2, i3);
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
            } catch (IllegalStateException e2) {
                Logging.e(TAG, "initDecode failed", e2);
                return false;
            }
        }
        throw new RuntimeException("initDecode: Forgot to release()?");
    }

    public static boolean isH264HighProfileHwSupported() {
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

    public static boolean isH264HwSupported() {
        return (hwDecoderDisabledTypes.contains("video/avc") || findDecoder("video/avc", supportedH264HwCodecPrefixes()) == null) ? false : true;
    }

    public static boolean isVp8HwSupported() {
        return (hwDecoderDisabledTypes.contains("video/x-vnd.on2.vp8") || findDecoder("video/x-vnd.on2.vp8", supportedVp8HwCodecPrefixes()) == null) ? false : true;
    }

    public static boolean isVp9HwSupported() {
        return (hwDecoderDisabledTypes.contains("video/x-vnd.on2.vp9") || findDecoder("video/x-vnd.on2.vp9", supportedVp9HwCodecPrefixes) == null) ? false : true;
    }

    public static native long nativeCreateDecoder(String str, boolean z);

    public static void printStackTrace() {
        Thread thread;
        MediaCodecVideoDecoder mediaCodecVideoDecoder = runningInstance;
        if (mediaCodecVideoDecoder == null || (thread = mediaCodecVideoDecoder.mediaCodecThread) == null) {
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
    private boolean queueInputBuffer(int i2, int i3, long j, long j2, long j3) {
        checkOnMediaCodecThread();
        try {
            this.inputBuffers[i2].position(0);
            this.inputBuffers[i2].limit(i3);
            this.decodeStartTimeMs.add(new TimeStamps(SystemClock.elapsedRealtime(), j2, j3));
            this.mediaCodec.queueInputBuffer(i2, 0, i3, j, 0);
            return true;
        } catch (IllegalStateException e2) {
            Logging.e(TAG, "decode failed", e2);
            return false;
        }
    }

    @CalledByNativeUnchecked
    private void release() {
        Logging.d(TAG, "Java releaseDecoder. Total number of dropped frames: " + this.droppedFrames);
        checkOnMediaCodecThread();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() { // from class: org.webrtc.MediaCodecVideoDecoder.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Logging.d(MediaCodecVideoDecoder.TAG, "Java releaseDecoder on release thread");
                    MediaCodecVideoDecoder.this.mediaCodec.stop();
                    MediaCodecVideoDecoder.this.mediaCodec.release();
                    Logging.d(MediaCodecVideoDecoder.TAG, "Java releaseDecoder on release thread done");
                } catch (Exception e2) {
                    Logging.e(MediaCodecVideoDecoder.TAG, "Media decoder release failed", e2);
                }
                countDownLatch.countDown();
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

    @CalledByNativeUnchecked
    private void reset(int i2, int i3) {
        if (this.mediaCodecThread == null || this.mediaCodec == null) {
            throw new RuntimeException("Incorrect reset call for non-initialized decoder.");
        }
        Logging.d(TAG, "Java reset: " + i2 + " x " + i3);
        this.mediaCodec.flush();
        this.width = i2;
        this.height = i3;
        TextureListener textureListener = this.textureListener;
        if (textureListener != null) {
            textureListener.setSize(i2, i3);
        }
        this.decodeStartTimeMs.clear();
        this.dequeuedSurfaceOutputBuffers.clear();
        this.hasDecodedFirstFrame = false;
        this.droppedFrames = 0;
    }

    @CalledByNativeUnchecked
    private void returnDecodedOutputBuffer(int i2) throws IllegalStateException, MediaCodec.CodecException {
        checkOnMediaCodecThread();
        if (useSurface()) {
            throw new IllegalStateException("returnDecodedOutputBuffer() called for surface decoding.");
        }
        this.mediaCodec.releaseOutputBuffer(i2, false);
    }

    public static void setEglContext(EglBase.Context context) {
        if (eglBase != null) {
            Logging.w(TAG, "Egl context already set.");
            eglBase.release();
        }
        eglBase = EglBase_CC.create(context);
    }

    public static void setErrorCallback(MediaCodecVideoDecoderErrorCallback mediaCodecVideoDecoderErrorCallback) {
        Logging.d(TAG, "Set error callback");
        errorCallback = mediaCodecVideoDecoderErrorCallback;
    }

    public static final String[] supportedH264HwCodecPrefixes() {
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

    public static final String[] supportedVp8HwCodecPrefixes() {
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

    public static boolean useSurface() {
        return eglBase != null;
    }

    @CalledByNative
    public int getColorFormat() {
        return this.colorFormat;
    }

    @CalledByNative
    public int getHeight() {
        return this.height;
    }

    @CalledByNative
    public ByteBuffer[] getInputBuffers() {
        return this.inputBuffers;
    }

    @CalledByNative
    public ByteBuffer[] getOutputBuffers() {
        return this.outputBuffers;
    }

    @CalledByNative
    public int getSliceHeight() {
        return this.sliceHeight;
    }

    @CalledByNative
    public int getStride() {
        return this.stride;
    }

    @CalledByNative
    public int getWidth() {
        return this.width;
    }
}
