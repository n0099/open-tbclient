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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_CROP_BOTTOM = "crop-bottom";
    public static final String KEY_CROP_LEFT = "crop-left";
    public static final String KEY_CROP_RIGHT = "crop-right";
    public static final String KEY_CROP_TOP = "crop-top";
    public static final int MAX_PENDING_OUTPUT_STREAM_OFFSET_COUNT = 10;
    public static final int[] STANDARD_LONG_EDGE_VIDEO_PX;
    public static final String TAG = "MediaCodecVideoRenderer";
    public transient /* synthetic */ FieldHolder $fh;
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

    /* renamed from: com.google.android.exoplayer2.video.MediaCodecVideoRenderer$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public static boolean isBufferLate(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65552, null, j)) == null) ? j < -30000 : invokeJ.booleanValue;
    }

    public static boolean isBufferVeryLate(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65553, null, j)) == null) ? j < -500000 : invokeJ.booleanValue;
    }

    /* loaded from: classes7.dex */
    public static final class CodecMaxValues {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.width = i;
            this.height = i2;
            this.inputSize = i3;
        }
    }

    @TargetApi(23)
    /* loaded from: classes7.dex */
    public final class OnFrameRenderedListenerV23 implements MediaCodec.OnFrameRenderedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaCodecVideoRenderer this$0;

        public OnFrameRenderedListenerV23(MediaCodecVideoRenderer mediaCodecVideoRenderer, MediaCodec mediaCodec) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaCodecVideoRenderer, mediaCodec};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaCodecVideoRenderer;
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }

        public /* synthetic */ OnFrameRenderedListenerV23(MediaCodecVideoRenderer mediaCodecVideoRenderer, MediaCodec mediaCodec, AnonymousClass1 anonymousClass1) {
            this(mediaCodecVideoRenderer, mediaCodec);
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public void onFrameRendered(@NonNull MediaCodec mediaCodec, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{mediaCodec, Long.valueOf(j), Long.valueOf(j2)}) == null) {
                MediaCodecVideoRenderer mediaCodecVideoRenderer = this.this$0;
                if (this != mediaCodecVideoRenderer.tunnelingOnFrameRenderedListener) {
                    return;
                }
                mediaCodecVideoRenderer.maybeNotifyRenderedFirstFrame();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2092533087, "Lcom/google/android/exoplayer2/video/MediaCodecVideoRenderer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2092533087, "Lcom/google/android/exoplayer2/video/MediaCodecVideoRenderer;");
                return;
            }
        }
        STANDARD_LONG_EDGE_VIDEO_PX = new int[]{1920, FeatureCodes.ADVANCE_BEAUTY, 1440, 1280, 960, 854, 640, 540, 480};
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void releaseCodec() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
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
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, 0L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mediaCodecSelector};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (MediaCodecSelector) objArr2[1], ((Long) objArr2[2]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
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
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] formatArr, long j) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048596, this, formatArr, j) == null) {
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
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j) {
        this(context, mediaCodecSelector, j, null, null, -1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mediaCodecSelector, Long.valueOf(j)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (MediaCodecSelector) objArr2[1], ((Long) objArr2[2]).longValue(), (Handler) objArr2[3], (VideoRendererEventListener) objArr2[4], ((Integer) objArr2[5]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i) {
        this(context, mediaCodecSelector, j, null, false, handler, videoRendererEventListener, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mediaCodecSelector, Long.valueOf(j), handler, videoRendererEventListener, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (MediaCodecSelector) objArr2[1], ((Long) objArr2[2]).longValue(), (DrmSessionManager) objArr2[3], ((Boolean) objArr2[4]).booleanValue(), (Handler) objArr2[5], (VideoRendererEventListener) objArr2[6], ((Integer) objArr2[7]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i) {
        super(2, mediaCodecSelector, drmSessionManager, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {context, mediaCodecSelector, Long.valueOf(j), drmSessionManager, Boolean.valueOf(z), handler, videoRendererEventListener, Integer.valueOf(i)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (MediaCodecSelector) objArr2[1], (DrmSessionManager) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
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

    public static boolean areAdaptationCompatible(boolean z, Format format, Format format2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Boolean.valueOf(z), format, format2})) == null) {
            if (format.sampleMimeType.equals(format2.sampleMimeType) && getRotationDegrees(format) == getRotationDegrees(format2) && (z || (format.width == format2.width && format.height == format2.height))) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private void clearRenderedFirstFrame() {
        MediaCodec codec;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.renderedFirstFrame = false;
            if (Util.SDK_INT >= 23 && this.tunneling && (codec = getCodec()) != null) {
                this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(this, codec, null);
            }
        }
    }

    private void clearReportedVideoSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.reportedWidth = -1;
            this.reportedHeight = -1;
            this.reportedPixelWidthHeightRatio = -1.0f;
            this.reportedUnappliedRotationDegrees = -1;
        }
    }

    public static boolean deviceNeedsAutoFrcWorkaround() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (Util.SDK_INT <= 22 && "foster".equals(Util.DEVICE) && "NVIDIA".equals(Util.MANUFACTURER)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void maybeNotifyDroppedFrames() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65554, this) == null) && this.droppedFrames > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, elapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = elapsedRealtime;
        }
    }

    private void maybeRenotifyRenderedFirstFrame() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65556, this) == null) && this.renderedFirstFrame) {
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void maybeRenotifyVideoSizeChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            if (this.reportedWidth != -1 || this.reportedHeight != -1) {
                this.eventDispatcher.videoSizeChanged(this.reportedWidth, this.reportedHeight, this.reportedUnappliedRotationDegrees, this.reportedPixelWidthHeightRatio);
            }
        }
    }

    private void setJoiningDeadlineMs() {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            if (this.allowedJoiningTimeMs > 0) {
                j = SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs;
            } else {
                j = C.TIME_UNSET;
            }
            this.joiningDeadlineMs = j;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void flushCodec() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.flushCodec();
            this.buffersInCodecCount = 0;
            this.forceRenderFrame = false;
        }
    }

    public void maybeNotifyRenderedFirstFrame() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && !this.renderedFirstFrame) {
            this.renderedFirstFrame = true;
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onStarted();
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.joiningDeadlineMs = C.TIME_UNSET;
            maybeNotifyDroppedFrames();
            super.onStopped();
        }
    }

    public static boolean codecNeedsSetOutputSurfaceWorkaround(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (((!"deb".equals(Util.DEVICE) && !"flo".equals(Util.DEVICE)) || !"OMX.qcom.video.decoder.avc".equals(str)) && ((!"tcl_eu".equals(Util.DEVICE) && !"SVP-DTV15".equals(Util.DEVICE) && !"BRAVIA_ATV2".equals(Util.DEVICE)) || !"OMX.MTK.VIDEO.DECODER.AVC".equals(str))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @TargetApi(21)
    public static void configureTunnelingV21(MediaFormat mediaFormat, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, null, mediaFormat, i) == null) {
            mediaFormat.setFeatureEnabled("tunneled-playback", true);
            mediaFormat.setInteger("audio-session-id", i);
        }
    }

    @TargetApi(23)
    public static void setOutputSurfaceV23(MediaCodec mediaCodec, Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, mediaCodec, surface) == null) {
            mediaCodec.setOutputSurface(surface);
        }
    }

    public static void setVideoScalingMode(MediaCodec mediaCodec, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65561, null, mediaCodec, i) == null) {
            mediaCodec.setVideoScalingMode(i);
        }
    }

    public boolean shouldDropBuffersToKeyframe(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            return isBufferVeryLate(j);
        }
        return invokeCommon.booleanValue;
    }

    public boolean shouldDropOutputBuffer(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            return isBufferLate(j);
        }
        return invokeCommon.booleanValue;
    }

    public static Point getCodecMaxSize(MediaCodecInfo mediaCodecInfo, Format format) throws MediaCodecUtil.DecoderQueryException {
        InterceptResult invokeLL;
        boolean z;
        int i;
        int i2;
        int[] iArr;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, mediaCodecInfo, format)) == null) {
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
        return (Point) invokeLL.objValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        boolean z;
        int integer;
        int integer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, mediaCodec, mediaFormat) == null) {
            if (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
            } else {
                integer = mediaFormat.getInteger("width");
            }
            this.currentWidth = integer;
            if (z) {
                integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
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
    }

    public static int getMaxInputSize(Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, format)) == null) {
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
        return invokeL.intValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int getMaxInputSize(String str, int i, int i2) {
        InterceptResult invokeLII;
        char c;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65549, null, str, i, i2)) == null) {
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
                    if (str.equals("video/x-vnd.on2.vp8")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1599127257:
                    if (str.equals("video/x-vnd.on2.vp9")) {
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
        return invokeLII.intValue;
    }

    public CodecMaxValues getCodecMaxValues(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) throws MediaCodecUtil.DecoderQueryException {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, mediaCodecInfo, format, formatArr)) == null) {
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
        return (CodecMaxValues) invokeLLL.objValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int supportsFormat(MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, Format format) throws MediaCodecUtil.DecoderQueryException {
        InterceptResult invokeLLL;
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048605, this, mediaCodecSelector, drmSessionManager, format)) == null) {
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
        return invokeLLL.intValue;
    }

    public static float getPixelWidthHeightRatio(Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, format)) == null) {
            float f = format.pixelWidthHeightRatio;
            if (f == -1.0f) {
                return 1.0f;
            }
            return f;
        }
        return invokeL.floatValue;
    }

    public static int getRotationDegrees(Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, format)) == null) {
            int i = format.rotationDegrees;
            if (i == -1) {
                return 0;
            }
            return i;
        }
        return invokeL.intValue;
    }

    private boolean shouldUseDummySurface(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65562, this, z)) == null) {
            if (Util.SDK_INT >= 23 && !this.tunneling && (!z || DummySurface.isSecureSupported(this.context))) {
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z) throws ExoPlaybackException {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
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
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onInputFormatChanged(Format format) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, format) == null) {
            super.onInputFormatChanged(format);
            this.eventDispatcher.inputFormatChanged(format);
            this.pendingPixelWidthHeightRatio = getPixelWidthHeightRatio(format);
            this.pendingRotationDegrees = getRotationDegrees(format);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void onProcessedOutputBuffer(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.buffersInCodecCount--;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, decoderInputBuffer) == null) {
            this.buffersInCodecCount++;
            if (Util.SDK_INT < 23 && this.tunneling) {
                maybeNotifyRenderedFirstFrame();
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, mediaCodecInfo)) == null) {
            if (this.surface == null && !shouldUseDummySurface(mediaCodecInfo.secure)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void updateDroppedBufferCounters(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
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
    }

    private void maybeNotifyVideoSizeChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
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
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        InterceptResult invokeV;
        Surface surface;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
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
        return invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
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
    }

    private void setSurface(Surface surface) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, surface) == null) {
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
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean canReconfigureCodec(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{mediaCodec, Boolean.valueOf(z), format, format2})) == null) {
            if (areAdaptationCompatible(z, format, format2)) {
                int i = format2.width;
                CodecMaxValues codecMaxValues = this.codecMaxValues;
                if (i <= codecMaxValues.width && format2.height <= codecMaxValues.height && getMaxInputSize(format2) <= this.codecMaxValues.inputSize) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws MediaCodecUtil.DecoderQueryException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaCodecInfo, mediaCodec, format, mediaCrypto) == null) {
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
                this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(this, mediaCodec, null);
            }
        }
    }

    @SuppressLint({"InlinedApi"})
    public MediaFormat getMediaFormat(Format format, CodecMaxValues codecMaxValues, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{format, codecMaxValues, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
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
        return (MediaFormat) invokeCommon.objValue;
    }

    public boolean maybeDropBuffersToKeyframe(MediaCodec mediaCodec, int i, long j, long j2) throws ExoPlaybackException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{mediaCodec, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            int skipSource = skipSource(j2);
            if (skipSource == 0) {
                return false;
            }
            this.decoderCounters.droppedToKeyframeCount++;
            updateDroppedBufferCounters(this.buffersInCodecCount + skipSource);
            flushCodec();
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @TargetApi(21)
    public void renderOutputBufferV21(MediaCodec mediaCodec, int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{mediaCodec, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            maybeNotifyVideoSizeChanged();
            TraceUtil.beginSection("releaseOutputBuffer");
            mediaCodec.releaseOutputBuffer(i, j2);
            TraceUtil.endSection();
            this.decoderCounters.renderedOutputBufferCount++;
            this.consecutiveDroppedFrameCount = 0;
            maybeNotifyRenderedFirstFrame();
        }
    }

    public void dropOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{mediaCodec, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            TraceUtil.beginSection("dropVideoBuffer");
            mediaCodec.releaseOutputBuffer(i, false);
            TraceUtil.endSection();
            updateDroppedBufferCounters(1);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecInitialized(String str, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.eventDispatcher.decoderInitialized(str, j, j2);
            this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(str);
        }
    }

    public void renderOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{mediaCodec, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            maybeNotifyVideoSizeChanged();
            TraceUtil.beginSection("releaseOutputBuffer");
            mediaCodec.releaseOutputBuffer(i, true);
            TraceUtil.endSection();
            this.decoderCounters.renderedOutputBufferCount++;
            this.consecutiveDroppedFrameCount = 0;
            maybeNotifyRenderedFirstFrame();
        }
    }

    public void skipOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{mediaCodec, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            TraceUtil.beginSection("skipVideoBuffer");
            mediaCodec.releaseOutputBuffer(i, false);
            TraceUtil.endSection();
            this.decoderCounters.skippedOutputBufferCount++;
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.ExoPlayer.ExoPlayerComponent
    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, obj) == null) {
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
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean processOutputBuffer(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws ExoPlaybackException {
        InterceptResult invokeCommon;
        long j4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), mediaCodec, byteBuffer, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j3), Boolean.valueOf(z)})) == null) {
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
        return invokeCommon.booleanValue;
    }
}
