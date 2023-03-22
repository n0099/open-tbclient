package com.google.android.exoplayer2.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.nio.ByteBuffer;
@TargetApi(16)
/* loaded from: classes7.dex */
public class MediaCodecVideoRenderer extends MediaCodecRenderer {
    public static final String KEY_CROP_BOTTOM = "crop-bottom";
    public static final String KEY_CROP_LEFT = "crop-left";
    public static final String KEY_CROP_RIGHT = "crop-right";
    public static final String KEY_CROP_TOP = "crop-top";
    public static final int MAX_PENDING_OUTPUT_STREAM_OFFSET_COUNT = 10;
    public static final int[] STANDARD_LONG_EDGE_VIDEO_PX = {1920, FeatureCodes.ADVANCE_BEAUTY, 1440, 1280, 960, 854, 640, 540, 480};
    public static final String TAG = "MediaCodecVideoRenderer";
    public final long allowedJoiningTimeMs;
    public int buffersInCodecCount;
    public CodecMaxValues codecMaxValues;
    public boolean codecNeedsSetOutputSurfaceWorkaround;
    public int consecutiveDroppedFrameCount;
    public final Context context;
    public int currentHeight;
    public float currentPixelWidthHeightRatio;
    public int currentUnappliedRotationDegrees;
    public int currentWidth;
    public final boolean deviceNeedsAutoFrcWorkaround;
    public long droppedFrameAccumulationStartTimeMs;
    public int droppedFrames;
    public Surface dummySurface;
    public final VideoRendererEventListener.EventDispatcher eventDispatcher;
    public boolean forceRenderFrame;
    public final VideoFrameReleaseTimeHelper frameReleaseTimeHelper;
    public long joiningDeadlineMs;
    public final int maxDroppedFramesToNotify;
    public long outputStreamOffsetUs;
    public int pendingOutputStreamOffsetCount;
    public final long[] pendingOutputStreamOffsetsUs;
    public float pendingPixelWidthHeightRatio;
    public int pendingRotationDegrees;
    public boolean renderedFirstFrame;
    public int reportedHeight;
    public float reportedPixelWidthHeightRatio;
    public int reportedUnappliedRotationDegrees;
    public int reportedWidth;
    public int scalingMode;
    public Format[] streamFormats;
    public Surface surface;
    public boolean tunneling;
    public int tunnelingAudioSessionId;
    public OnFrameRenderedListenerV23 tunnelingOnFrameRenderedListener;

    public static boolean isBufferLate(long j) {
        return j < -30000;
    }

    public static boolean isBufferVeryLate(long j) {
        return j < -500000;
    }

    /* loaded from: classes7.dex */
    public static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.inputSize = i3;
        }
    }

    @TargetApi(23)
    /* loaded from: classes7.dex */
    public final class OnFrameRenderedListenerV23 implements MediaCodec.OnFrameRenderedListener {
        public OnFrameRenderedListenerV23(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public void onFrameRendered(@NonNull MediaCodec mediaCodec, long j, long j2) {
            MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
            if (this != mediaCodecVideoRenderer.tunnelingOnFrameRenderedListener) {
                return;
            }
            mediaCodecVideoRenderer.maybeNotifyRenderedFirstFrame();
        }
    }

    private void clearRenderedFirstFrame() {
        MediaCodec codec;
        this.renderedFirstFrame = false;
        if (Util.SDK_INT >= 23 && this.tunneling && (codec = getCodec()) != null) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(codec);
        }
    }

    private void clearReportedVideoSize() {
        this.reportedWidth = -1;
        this.reportedHeight = -1;
        this.reportedPixelWidthHeightRatio = -1.0f;
        this.reportedUnappliedRotationDegrees = -1;
    }

    public static boolean deviceNeedsAutoFrcWorkaround() {
        if (Util.SDK_INT <= 22 && "foster".equals(Util.DEVICE) && "NVIDIA".equals(Util.MANUFACTURER)) {
            return true;
        }
        return false;
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, elapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = elapsedRealtime;
        }
    }

    private void maybeRenotifyRenderedFirstFrame() {
        if (this.renderedFirstFrame) {
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void maybeRenotifyVideoSizeChanged() {
        if (this.reportedWidth != -1 || this.reportedHeight != -1) {
            this.eventDispatcher.videoSizeChanged(this.reportedWidth, this.reportedHeight, this.reportedUnappliedRotationDegrees, this.reportedPixelWidthHeightRatio);
        }
    }

    private void setJoiningDeadlineMs() {
        long j;
        if (this.allowedJoiningTimeMs > 0) {
            j = SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs;
        } else {
            j = C.TIME_UNSET;
        }
        this.joiningDeadlineMs = j;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void flushCodec() throws ExoPlaybackException {
        super.flushCodec();
        this.buffersInCodecCount = 0;
        this.forceRenderFrame = false;
    }

    public void maybeNotifyRenderedFirstFrame() {
        if (!this.renderedFirstFrame) {
            this.renderedFirstFrame = true;
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        this.joiningDeadlineMs = C.TIME_UNSET;
        maybeNotifyDroppedFrames();
        super.onStopped();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void releaseCodec() {
        try {
            super.releaseCodec();
        } finally {
            this.buffersInCodecCount = 0;
            this.forceRenderFrame = false;
            Surface surface = this.dummySurface;
            if (surface != null) {
                if (this.surface == surface) {
                    this.surface = null;
                }
                this.dummySurface.release();
                this.dummySurface = null;
            }
        }
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, 0L);
    }

    @TargetApi(21)
    public static void configureTunnelingV21(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i);
    }

    @TargetApi(23)
    public static void setOutputSurfaceV23(MediaCodec mediaCodec, Surface surface) {
        mediaCodec.setOutputSurface(surface);
    }

    public static void setVideoScalingMode(MediaCodec mediaCodec, int i) {
        mediaCodec.setVideoScalingMode(i);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.ExoPlayer.ExoPlayerComponent
    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        if (i == 1) {
            setSurface((Surface) obj);
        } else if (i == 4) {
            this.scalingMode = ((Integer) obj).intValue();
            MediaCodec codec = getCodec();
            if (codec != null) {
                setVideoScalingMode(codec, this.scalingMode);
            }
        } else {
            super.handleMessage(i, obj);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        super.onPositionReset(j, z);
        clearRenderedFirstFrame();
        this.consecutiveDroppedFrameCount = 0;
        int i = this.pendingOutputStreamOffsetCount;
        if (i != 0) {
            this.outputStreamOffsetUs = this.pendingOutputStreamOffsetsUs[i - 1];
            this.pendingOutputStreamOffsetCount = 0;
        }
        if (z) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = C.TIME_UNSET;
        }
    }

    public boolean shouldDropBuffersToKeyframe(long j, long j2) {
        return isBufferVeryLate(j);
    }

    public boolean shouldDropOutputBuffer(long j, long j2) {
        return isBufferLate(j);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j) {
        this(context, mediaCodecSelector, j, null, null, -1);
    }

    public static boolean areAdaptationCompatible(boolean z, Format format, Format format2) {
        if (format.sampleMimeType.equals(format2.sampleMimeType) && getRotationDegrees(format) == getRotationDegrees(format2) && (z || (format.width == format2.width && format.height == format2.height))) {
            return true;
        }
        return false;
    }

    public void dropOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        TraceUtil.beginSection("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        updateDroppedBufferCounters(1);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecInitialized(String str, long j, long j2) {
        this.eventDispatcher.decoderInitialized(str, j, j2);
        this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(str);
    }

    public void renderOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        TraceUtil.endSection();
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    public void skipOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        TraceUtil.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i) {
        this(context, mediaCodecSelector, j, null, false, handler, videoRendererEventListener, i);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i) {
        super(2, mediaCodecSelector, drmSessionManager, z);
        this.allowedJoiningTimeMs = j;
        this.maxDroppedFramesToNotify = i;
        this.context = context.getApplicationContext();
        this.frameReleaseTimeHelper = new VideoFrameReleaseTimeHelper(context);
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.deviceNeedsAutoFrcWorkaround = deviceNeedsAutoFrcWorkaround();
        this.pendingOutputStreamOffsetsUs = new long[10];
        this.outputStreamOffsetUs = C.TIME_UNSET;
        this.joiningDeadlineMs = C.TIME_UNSET;
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.pendingPixelWidthHeightRatio = -1.0f;
        this.scalingMode = 1;
        clearReportedVideoSize();
    }

    public static boolean codecNeedsSetOutputSurfaceWorkaround(String str) {
        if (((!"deb".equals(Util.DEVICE) && !"flo".equals(Util.DEVICE)) || !"OMX.qcom.video.decoder.avc".equals(str)) && ((!"tcl_eu".equals(Util.DEVICE) && !"SVP-DTV15".equals(Util.DEVICE) && !"BRAVIA_ATV2".equals(Util.DEVICE)) || !"OMX.MTK.VIDEO.DECODER.AVC".equals(str))) {
            return false;
        }
        return true;
    }

    public static Point getCodecMaxSize(MediaCodecInfo mediaCodecInfo, Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z;
        int i;
        int i2;
        int[] iArr;
        int i3;
        int i4;
        if (format.height > format.width) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i = format.height;
        } else {
            i = format.width;
        }
        if (z) {
            i2 = format.width;
        } else {
            i2 = format.height;
        }
        float f = i2 / i;
        for (int i5 : STANDARD_LONG_EDGE_VIDEO_PX) {
            int i6 = (int) (i5 * f);
            if (i5 <= i || i6 <= i2) {
                break;
            }
            if (Util.SDK_INT >= 21) {
                if (z) {
                    i4 = i6;
                } else {
                    i4 = i5;
                }
                if (!z) {
                    i5 = i6;
                }
                Point alignVideoSizeV21 = mediaCodecInfo.alignVideoSizeV21(i4, i5);
                if (mediaCodecInfo.isVideoSizeAndRateSupportedV21(alignVideoSizeV21.x, alignVideoSizeV21.y, format.frameRate)) {
                    return alignVideoSizeV21;
                }
            } else {
                int ceilDivide = Util.ceilDivide(i5, 16) * 16;
                int ceilDivide2 = Util.ceilDivide(i6, 16) * 16;
                if (ceilDivide * ceilDivide2 <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                    if (z) {
                        i3 = ceilDivide2;
                    } else {
                        i3 = ceilDivide;
                    }
                    if (!z) {
                        ceilDivide = ceilDivide2;
                    }
                    return new Point(i3, ceilDivide);
                }
            }
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        boolean z;
        int integer;
        int integer2;
        if (mediaFormat.containsKey(KEY_CROP_RIGHT) && mediaFormat.containsKey(KEY_CROP_LEFT) && mediaFormat.containsKey(KEY_CROP_BOTTOM) && mediaFormat.containsKey(KEY_CROP_TOP)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            integer = (mediaFormat.getInteger(KEY_CROP_RIGHT) - mediaFormat.getInteger(KEY_CROP_LEFT)) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        this.currentWidth = integer;
        if (z) {
            integer2 = (mediaFormat.getInteger(KEY_CROP_BOTTOM) - mediaFormat.getInteger(KEY_CROP_TOP)) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        this.currentHeight = integer2;
        this.currentPixelWidthHeightRatio = this.pendingPixelWidthHeightRatio;
        if (Util.SDK_INT >= 21) {
            int i = this.pendingRotationDegrees;
            if (i == 90 || i == 270) {
                int i2 = this.currentWidth;
                this.currentWidth = this.currentHeight;
                this.currentHeight = i2;
                this.currentPixelWidthHeightRatio = 1.0f / this.currentPixelWidthHeightRatio;
            }
        } else {
            this.currentUnappliedRotationDegrees = this.pendingRotationDegrees;
        }
        setVideoScalingMode(mediaCodec, this.scalingMode);
    }

    public static int getMaxInputSize(Format format) {
        if (format.maxInputSize != -1) {
            int size = format.initializationData.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                i += format.initializationData.get(i2).length;
            }
            return format.maxInputSize + i;
        }
        return getMaxInputSize(format.sampleMimeType, format.width, format.height);
    }

    public static float getPixelWidthHeightRatio(Format format) {
        float f = format.pixelWidthHeightRatio;
        if (f == -1.0f) {
            return 1.0f;
        }
        return f;
    }

    public static int getRotationDegrees(Format format) {
        int i = format.rotationDegrees;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    private boolean shouldUseDummySurface(boolean z) {
        if (Util.SDK_INT >= 23 && !this.tunneling && (!z || DummySurface.isSecureSupported(this.context))) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z) throws ExoPlaybackException {
        boolean z2;
        super.onEnabled(z);
        int i = getConfiguration().tunnelingAudioSessionId;
        this.tunnelingAudioSessionId = i;
        if (i != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.tunneling = z2;
        this.eventDispatcher.enabled(this.decoderCounters);
        this.frameReleaseTimeHelper.enable();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onInputFormatChanged(Format format) throws ExoPlaybackException {
        super.onInputFormatChanged(format);
        this.eventDispatcher.inputFormatChanged(format);
        this.pendingPixelWidthHeightRatio = getPixelWidthHeightRatio(format);
        this.pendingRotationDegrees = getRotationDegrees(format);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void onProcessedOutputBuffer(long j) {
        this.buffersInCodecCount--;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        this.buffersInCodecCount++;
        if (Util.SDK_INT < 23 && this.tunneling) {
            maybeNotifyRenderedFirstFrame();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        if (this.surface == null && !shouldUseDummySurface(mediaCodecInfo.secure)) {
            return false;
        }
        return true;
    }

    public void updateDroppedBufferCounters(int i) {
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedBufferCount += i;
        this.droppedFrames += i;
        int i2 = this.consecutiveDroppedFrameCount + i;
        this.consecutiveDroppedFrameCount = i2;
        decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(i2, decoderCounters.maxConsecutiveDroppedBufferCount);
        if (this.droppedFrames >= this.maxDroppedFramesToNotify) {
            maybeNotifyDroppedFrames();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int getMaxInputSize(String str, int i, int i2) {
        char c;
        int i3;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        int i4 = 4;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals(MimeTypes.VIDEO_H263)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1662541442:
                if (str.equals(MimeTypes.VIDEO_H265)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1187890754:
                if (str.equals(MimeTypes.VIDEO_MP4V)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1599127256:
                if (str.equals(MimeTypes.VIDEO_VP8)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1599127257:
                if (str.equals(MimeTypes.VIDEO_VP9)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c != 0 && c != 1) {
            if (c != 2) {
                if (c != 3) {
                    if (c != 4 && c != 5) {
                        return -1;
                    }
                    i3 = i * i2;
                    return (i3 * 3) / (i4 * 2);
                }
            } else if ("BRAVIA 4K 2015".equals(Util.MODEL)) {
                return -1;
            } else {
                i3 = Util.ceilDivide(i, 16) * Util.ceilDivide(i2, 16) * 16 * 16;
                i4 = 2;
                return (i3 * 3) / (i4 * 2);
            }
        }
        i3 = i * i2;
        i4 = 2;
        return (i3 * 3) / (i4 * 2);
    }

    public CodecMaxValues getCodecMaxValues(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) throws MediaCodecUtil.DecoderQueryException {
        boolean z;
        int i = format.width;
        int i2 = format.height;
        int maxInputSize = getMaxInputSize(format);
        if (formatArr.length == 1) {
            return new CodecMaxValues(i, i2, maxInputSize);
        }
        boolean z2 = false;
        for (Format format2 : formatArr) {
            if (areAdaptationCompatible(mediaCodecInfo.adaptive, format, format2)) {
                if (format2.width != -1 && format2.height != -1) {
                    z = false;
                } else {
                    z = true;
                }
                z2 |= z;
                i = Math.max(i, format2.width);
                i2 = Math.max(i2, format2.height);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(format2));
            }
        }
        if (z2) {
            Log.w(TAG, "Resolutions unknown. Codec max resolution: " + i + "x" + i2);
            Point codecMaxSize = getCodecMaxSize(mediaCodecInfo, format);
            if (codecMaxSize != null) {
                i = Math.max(i, codecMaxSize.x);
                i2 = Math.max(i2, codecMaxSize.y);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(format.sampleMimeType, i, i2));
                Log.w(TAG, "Codec max resolution adjusted to: " + i + "x" + i2);
            }
        }
        return new CodecMaxValues(i, i2, maxInputSize);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int supportsFormat(MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        String str = format.sampleMimeType;
        int i5 = 0;
        if (!MimeTypes.isVideo(str)) {
            return 0;
        }
        DrmInitData drmInitData = format.drmInitData;
        if (drmInitData != null) {
            z = false;
            for (int i6 = 0; i6 < drmInitData.schemeDataCount; i6++) {
                z |= drmInitData.get(i6).requiresSecureDecryption;
            }
        } else {
            z = false;
        }
        MediaCodecInfo decoderInfo = mediaCodecSelector.getDecoderInfo(str, z);
        boolean z2 = true;
        if (decoderInfo == null) {
            if (z && mediaCodecSelector.getDecoderInfo(str, false) != null) {
                return 2;
            }
            return 1;
        } else if (!BaseRenderer.supportsFormatDrm(drmSessionManager, drmInitData)) {
            return 2;
        } else {
            boolean isCodecSupported = decoderInfo.isCodecSupported(format.codecs);
            if (isCodecSupported && (i3 = format.width) > 0 && (i4 = format.height) > 0) {
                if (Util.SDK_INT >= 21) {
                    isCodecSupported = decoderInfo.isVideoSizeAndRateSupportedV21(i3, i4, format.frameRate);
                } else {
                    if (i3 * i4 > MediaCodecUtil.maxH264DecodableFrameSize()) {
                        z2 = false;
                    }
                    if (!z2) {
                        Log.d(TAG, "FalseCheck [legacyFrameSize, " + format.width + "x" + format.height + "] [" + Util.DEVICE_DEBUG_INFO + PreferencesUtil.RIGHT_MOUNT);
                    }
                    isCodecSupported = z2;
                }
            }
            if (decoderInfo.adaptive) {
                i = 16;
            } else {
                i = 8;
            }
            if (decoderInfo.tunneling) {
                i5 = 32;
            }
            if (isCodecSupported) {
                i2 = 4;
            } else {
                i2 = 3;
            }
            return i2 | i | i5;
        }
    }

    private void maybeNotifyVideoSizeChanged() {
        if (this.currentWidth != -1 || this.currentHeight != -1) {
            if (this.reportedWidth != this.currentWidth || this.reportedHeight != this.currentHeight || this.reportedUnappliedRotationDegrees != this.currentUnappliedRotationDegrees || this.reportedPixelWidthHeightRatio != this.currentPixelWidthHeightRatio) {
                this.eventDispatcher.videoSizeChanged(this.currentWidth, this.currentHeight, this.currentUnappliedRotationDegrees, this.currentPixelWidthHeightRatio);
                this.reportedWidth = this.currentWidth;
                this.reportedHeight = this.currentHeight;
                this.reportedUnappliedRotationDegrees = this.currentUnappliedRotationDegrees;
                this.reportedPixelWidthHeightRatio = this.currentPixelWidthHeightRatio;
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        Surface surface;
        if (super.isReady() && (this.renderedFirstFrame || (((surface = this.dummySurface) != null && this.surface == surface) || getCodec() == null || this.tunneling))) {
            this.joiningDeadlineMs = C.TIME_UNSET;
            return true;
        } else if (this.joiningDeadlineMs == C.TIME_UNSET) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
                return true;
            }
            this.joiningDeadlineMs = C.TIME_UNSET;
            return false;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.pendingPixelWidthHeightRatio = -1.0f;
        this.outputStreamOffsetUs = C.TIME_UNSET;
        this.pendingOutputStreamOffsetCount = 0;
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        this.frameReleaseTimeHelper.disable();
        this.tunnelingOnFrameRenderedListener = null;
        this.tunneling = false;
        try {
            super.onDisabled();
        } finally {
            this.decoderCounters.ensureUpdated();
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    private void setSurface(Surface surface) throws ExoPlaybackException {
        if (surface == null) {
            Surface surface2 = this.dummySurface;
            if (surface2 != null) {
                surface = surface2;
            } else {
                MediaCodecInfo codecInfo = getCodecInfo();
                if (codecInfo != null && shouldUseDummySurface(codecInfo.secure)) {
                    surface = DummySurface.newInstanceV17(this.context, codecInfo.secure);
                    this.dummySurface = surface;
                }
            }
        }
        if (this.surface != surface) {
            this.surface = surface;
            int state = getState();
            if (state == 1 || state == 2) {
                MediaCodec codec = getCodec();
                if (Util.SDK_INT >= 23 && codec != null && surface != null && !this.codecNeedsSetOutputSurfaceWorkaround) {
                    setOutputSurfaceV23(codec, surface);
                } else {
                    releaseCodec();
                    maybeInitCodec();
                }
            }
            if (surface != null && surface != this.dummySurface) {
                maybeRenotifyVideoSizeChanged();
                clearRenderedFirstFrame();
                if (state == 2) {
                    setJoiningDeadlineMs();
                    return;
                }
                return;
            }
            clearReportedVideoSize();
            clearRenderedFirstFrame();
        } else if (surface != null && surface != this.dummySurface) {
            maybeRenotifyVideoSizeChanged();
            maybeRenotifyRenderedFirstFrame();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean canReconfigureCodec(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        if (areAdaptationCompatible(z, format, format2)) {
            int i = format2.width;
            CodecMaxValues codecMaxValues = this.codecMaxValues;
            if (i <= codecMaxValues.width && format2.height <= codecMaxValues.height && getMaxInputSize(format2) <= this.codecMaxValues.inputSize) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    public MediaFormat getMediaFormat(Format format, CodecMaxValues codecMaxValues, boolean z, int i) {
        MediaFormat frameworkMediaFormatV16 = format.getFrameworkMediaFormatV16();
        frameworkMediaFormatV16.setInteger(CriusAttrConstants.MAX_WIDTH, codecMaxValues.width);
        frameworkMediaFormatV16.setInteger(CriusAttrConstants.MAX_HEIGHT, codecMaxValues.height);
        int i2 = codecMaxValues.inputSize;
        if (i2 != -1) {
            frameworkMediaFormatV16.setInteger("max-input-size", i2);
        }
        if (z) {
            frameworkMediaFormatV16.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            configureTunnelingV21(frameworkMediaFormatV16, i);
        }
        return frameworkMediaFormatV16;
    }

    public boolean maybeDropBuffersToKeyframe(MediaCodec mediaCodec, int i, long j, long j2) throws ExoPlaybackException {
        int skipSource = skipSource(j2);
        if (skipSource == 0) {
            return false;
        }
        this.decoderCounters.droppedToKeyframeCount++;
        updateDroppedBufferCounters(this.buffersInCodecCount + skipSource);
        flushCodec();
        return true;
    }

    @TargetApi(21)
    public void renderOutputBufferV21(MediaCodec mediaCodec, int i, long j, long j2) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        TraceUtil.endSection();
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws MediaCodecUtil.DecoderQueryException {
        CodecMaxValues codecMaxValues = getCodecMaxValues(mediaCodecInfo, format, this.streamFormats);
        this.codecMaxValues = codecMaxValues;
        MediaFormat mediaFormat = getMediaFormat(format, codecMaxValues, this.deviceNeedsAutoFrcWorkaround, this.tunnelingAudioSessionId);
        if (this.surface == null) {
            Assertions.checkState(shouldUseDummySurface(mediaCodecInfo.secure));
            if (this.dummySurface == null) {
                this.dummySurface = DummySurface.newInstanceV17(this.context, mediaCodecInfo.secure);
            }
            this.surface = this.dummySurface;
        }
        mediaCodec.configure(mediaFormat, this.surface, mediaCrypto, 0);
        if (Util.SDK_INT >= 23 && this.tunneling) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(mediaCodec);
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] formatArr, long j) throws ExoPlaybackException {
        this.streamFormats = formatArr;
        if (this.outputStreamOffsetUs == C.TIME_UNSET) {
            this.outputStreamOffsetUs = j;
        } else {
            int i = this.pendingOutputStreamOffsetCount;
            if (i == this.pendingOutputStreamOffsetsUs.length) {
                Log.w(TAG, "Too many stream changes, so dropping offset: " + this.pendingOutputStreamOffsetsUs[this.pendingOutputStreamOffsetCount - 1]);
            } else {
                this.pendingOutputStreamOffsetCount = i + 1;
            }
            this.pendingOutputStreamOffsetsUs[this.pendingOutputStreamOffsetCount - 1] = j;
        }
        super.onStreamChanged(formatArr, j);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean processOutputBuffer(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws ExoPlaybackException {
        long j4;
        while (true) {
            int i3 = this.pendingOutputStreamOffsetCount;
            if (i3 == 0) {
                break;
            }
            long[] jArr = this.pendingOutputStreamOffsetsUs;
            if (j3 < jArr[0]) {
                break;
            }
            this.outputStreamOffsetUs = jArr[0];
            int i4 = i3 - 1;
            this.pendingOutputStreamOffsetCount = i4;
            System.arraycopy(jArr, 1, jArr, 0, i4);
        }
        long j5 = j3 - this.outputStreamOffsetUs;
        if (z) {
            skipOutputBuffer(mediaCodec, i, j5);
            return true;
        }
        long j6 = j3 - j;
        if (this.surface == this.dummySurface) {
            if (!isBufferLate(j6)) {
                return false;
            }
            this.forceRenderFrame = false;
            skipOutputBuffer(mediaCodec, i, j5);
            return true;
        } else if (this.renderedFirstFrame && !this.forceRenderFrame) {
            if (getState() != 2) {
                return false;
            }
            long elapsedRealtime = j6 - ((SystemClock.elapsedRealtime() * 1000) - j2);
            long nanoTime = System.nanoTime();
            long adjustReleaseTime = this.frameReleaseTimeHelper.adjustReleaseTime(j3, nanoTime + (elapsedRealtime * 1000));
            long j7 = (adjustReleaseTime - nanoTime) / 1000;
            if (shouldDropBuffersToKeyframe(j7, j2)) {
                if (maybeDropBuffersToKeyframe(mediaCodec, i, j5, j)) {
                    this.forceRenderFrame = true;
                    return false;
                }
                j4 = j7;
            } else {
                j4 = j7;
            }
            if (shouldDropOutputBuffer(j4, j2)) {
                dropOutputBuffer(mediaCodec, i, j5);
                return true;
            }
            if (Util.SDK_INT >= 21) {
                if (j4 < 50000) {
                    renderOutputBufferV21(mediaCodec, i, j5, adjustReleaseTime);
                    return true;
                }
            } else if (j4 < 30000) {
                if (j4 > 11000) {
                    try {
                        Thread.sleep((j4 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                renderOutputBuffer(mediaCodec, i, j5);
                return true;
            }
            return false;
        } else {
            this.forceRenderFrame = false;
            if (Util.SDK_INT >= 21) {
                renderOutputBufferV21(mediaCodec, i, j5, System.nanoTime());
            } else {
                renderOutputBuffer(mediaCodec, i, j5);
            }
            return true;
        }
    }
}
