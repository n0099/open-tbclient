package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
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
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class MediaCodecRenderer extends BaseRenderer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final byte[] ADAPTATION_WORKAROUND_BUFFER;
    public static final int ADAPTATION_WORKAROUND_MODE_ALWAYS = 2;
    public static final int ADAPTATION_WORKAROUND_MODE_NEVER = 0;
    public static final int ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION = 1;
    public static final int ADAPTATION_WORKAROUND_SLICE_WIDTH_HEIGHT = 32;
    public static final long MAX_CODEC_HOTSWAP_TIME_MS = 1000;
    public static final int RECONFIGURATION_STATE_NONE = 0;
    public static final int RECONFIGURATION_STATE_QUEUE_PENDING = 2;
    public static final int RECONFIGURATION_STATE_WRITE_PENDING = 1;
    public static final int REINITIALIZATION_STATE_NONE = 0;
    public static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
    public static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
    public static final String TAG = "MediaCodecRenderer";
    public transient /* synthetic */ FieldHolder $fh;
    public final DecoderInputBuffer buffer;
    public MediaCodec codec;
    public int codecAdaptationWorkaroundMode;
    public long codecHotswapDeadlineMs;
    public MediaCodecInfo codecInfo;
    public boolean codecNeedsAdaptationWorkaroundBuffer;
    public boolean codecNeedsDiscardToSpsWorkaround;
    public boolean codecNeedsEosFlushWorkaround;
    public boolean codecNeedsEosOutputExceptionWorkaround;
    public boolean codecNeedsEosPropagationWorkaround;
    public boolean codecNeedsFlushWorkaround;
    public boolean codecNeedsMonoChannelCountWorkaround;
    public boolean codecReceivedBuffers;
    public boolean codecReceivedEos;
    public int codecReconfigurationState;
    public boolean codecReconfigured;
    public int codecReinitializationState;
    public final List decodeOnlyPresentationTimestamps;
    public DecoderCounters decoderCounters;
    public DrmSession drmSession;
    public final DrmSessionManager drmSessionManager;
    public final DecoderInputBuffer flagsOnlyBuffer;
    public Format format;
    public final FormatHolder formatHolder;
    public ByteBuffer[] inputBuffers;
    public int inputIndex;
    public boolean inputStreamEnded;
    public final MediaCodecSelector mediaCodecSelector;
    public final MediaCodec.BufferInfo outputBufferInfo;
    public ByteBuffer[] outputBuffers;
    public int outputIndex;
    public boolean outputStreamEnded;
    public DrmSession pendingDrmSession;
    public final boolean playClearSamplesWithoutKeys;
    public boolean shouldSkipAdaptationWorkaroundOutputBuffer;
    public boolean shouldSkipOutputBuffer;
    public boolean waitingForFirstSyncFrame;
    public boolean waitingForKeys;

    public boolean canReconfigureCodec(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{mediaCodec, Boolean.valueOf(z), format, format2})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public abstract void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws MediaCodecUtil.DecoderQueryException;

    public long getDequeueOutputBufferTimeoutUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    public void onCodecInitialized(String str, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)}) == null) {
        }
    }

    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, mediaCodec, mediaFormat) == null) {
        }
    }

    public void onProcessedOutputBuffer(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
        }
    }

    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, decoderInputBuffer) == null) {
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    public abstract boolean processOutputBuffer(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws ExoPlaybackException;

    public void renderToEndOfStream() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
        }
    }

    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, mediaCodecInfo)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public abstract int supportsFormat(MediaCodecSelector mediaCodecSelector, DrmSessionManager drmSessionManager, Format format) throws MediaCodecUtil.DecoderQueryException;

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.RendererCapabilities
    public final int supportsMixedMimeTypeAdaptation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return 8;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes7.dex */
    public class DecoderInitializationException extends Exception {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int CUSTOM_ERROR_CODE_BASE = -50000;
        public static final int DECODER_QUERY_ERROR = -49998;
        public static final int NO_SUITABLE_DECODER_ERROR = -49999;
        public transient /* synthetic */ FieldHolder $fh;
        public final String decoderName;
        public final String diagnosticInfo;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DecoderInitializationException(Format format, Throwable th, boolean z, int i) {
            super("Decoder init failed: [" + i + "], " + format, th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {format, th, Boolean.valueOf(z), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mimeType = format.sampleMimeType;
            this.secureDecoderRequired = z;
            this.decoderName = null;
            this.diagnosticInfo = buildCustomDiagnosticInfo(i);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DecoderInitializationException(Format format, Throwable th, boolean z, String str) {
            super("Decoder init failed: " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + format, th);
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {format, th, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mimeType = format.sampleMimeType;
            this.secureDecoderRequired = z;
            this.decoderName = str;
            if (Util.SDK_INT >= 21) {
                str2 = getDiagnosticInfoV21(th);
            } else {
                str2 = null;
            }
            this.diagnosticInfo = str2;
        }

        public static String buildCustomDiagnosticInfo(int i) {
            InterceptResult invokeI;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
                if (i < 0) {
                    str = "neg_";
                } else {
                    str = "";
                }
                return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + str + Math.abs(i);
            }
            return (String) invokeI.objValue;
        }

        public static String getDiagnosticInfoV21(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, th)) == null) {
                if (th instanceof MediaCodec.CodecException) {
                    return ((MediaCodec.CodecException) th).getDiagnosticInfo();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(908998919, "Lcom/google/android/exoplayer2/mediacodec/MediaCodecRenderer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(908998919, "Lcom/google/android/exoplayer2/mediacodec/MediaCodecRenderer;");
                return;
            }
        }
        ADAPTATION_WORKAROUND_BUFFER = Util.getBytesFromHexString("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    }

    private void processEndOfStream() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            if (this.codecReinitializationState == 2) {
                releaseCodec();
                maybeInitCodec();
                return;
            }
            this.outputStreamEnded = true;
            renderToEndOfStream();
        }
    }

    private void processOutputBuffersChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.outputBuffers = this.codec.getOutputBuffers();
        }
    }

    public final MediaCodec getCodec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.codec;
        }
        return (MediaCodec) invokeV.objValue;
    }

    public final MediaCodecInfo getCodecInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.codecInfo;
        }
        return (MediaCodecInfo) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.outputStreamEnded;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaCodecRenderer(int i, MediaCodecSelector mediaCodecSelector, DrmSessionManager drmSessionManager, boolean z) {
        super(i);
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), mediaCodecSelector, drmSessionManager, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (Util.SDK_INT >= 16) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.checkState(z2);
        this.mediaCodecSelector = (MediaCodecSelector) Assertions.checkNotNull(mediaCodecSelector);
        this.drmSessionManager = drmSessionManager;
        this.playClearSamplesWithoutKeys = z;
        this.buffer = new DecoderInputBuffer(0);
        this.flagsOnlyBuffer = DecoderInputBuffer.newFlagsOnlyInstance();
        this.formatHolder = new FormatHolder();
        this.decodeOnlyPresentationTimestamps = new ArrayList();
        this.outputBufferInfo = new MediaCodec.BufferInfo();
        this.codecReconfigurationState = 0;
        this.codecReinitializationState = 0;
    }

    private int codecAdaptationWorkaroundMode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (Util.SDK_INT <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (Util.MODEL.startsWith("SM-T585") || Util.MODEL.startsWith("SM-A510") || Util.MODEL.startsWith("SM-A520") || Util.MODEL.startsWith("SM-J700"))) {
                return 2;
            }
            if (Util.SDK_INT < 24) {
                if ("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) {
                    if ("flounder".equals(Util.DEVICE) || "flounder_lte".equals(Util.DEVICE) || "grouper".equals(Util.DEVICE) || "tilapia".equals(Util.DEVICE)) {
                        return 1;
                    }
                    return 0;
                }
                return 0;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean codecNeedsDiscardToSpsWorkaround(String str, Format format) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, format)) == null) {
            if (Util.SDK_INT < 21 && format.initializationData.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean codecNeedsMonoChannelCountWorkaround(String str, Format format) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, format)) == null) {
            if (Util.SDK_INT <= 18 && format.channelCount == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static MediaCodec.CryptoInfo getFrameworkCryptoInfo(DecoderInputBuffer decoderInputBuffer, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, decoderInputBuffer, i)) == null) {
            MediaCodec.CryptoInfo frameworkCryptoInfoV16 = decoderInputBuffer.cryptoInfo.getFrameworkCryptoInfoV16();
            if (i == 0) {
                return frameworkCryptoInfoV16;
            }
            if (frameworkCryptoInfoV16.numBytesOfClearData == null) {
                frameworkCryptoInfoV16.numBytesOfClearData = new int[1];
            }
            int[] iArr = frameworkCryptoInfoV16.numBytesOfClearData;
            iArr[0] = iArr[0] + i;
            return frameworkCryptoInfoV16;
        }
        return (MediaCodec.CryptoInfo) invokeLI.objValue;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.inputStreamEnded = false;
            this.outputStreamEnded = false;
            if (this.codec != null) {
                flushCodec();
            }
        }
    }

    public static boolean codecNeedsEosFlushWorkaround(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if ((Util.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (Util.SDK_INT <= 19 && "hb2000".equals(Util.DEVICE) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str)))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private boolean shouldSkipOutputBuffer(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65551, this, j)) == null) {
            int size = this.decodeOnlyPresentationTimestamps.size();
            for (int i = 0; i < size; i++) {
                if (((Long) this.decodeOnlyPresentationTimestamps.get(i)).longValue() == j) {
                    this.decodeOnlyPresentationTimestamps.remove(i);
                    return true;
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    private boolean shouldWaitForKeys(boolean z) throws ExoPlaybackException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65552, this, z)) == null) {
            if (this.drmSession == null || (!z && this.playClearSamplesWithoutKeys)) {
                return false;
            }
            int state = this.drmSession.getState();
            if (state != 1) {
                if (state == 4) {
                    return false;
                }
                return true;
            }
            throw ExoPlaybackException.createForRenderer(this.drmSession.getError(), getIndex());
        }
        return invokeZ.booleanValue;
    }

    public static boolean codecNeedsEosOutputExceptionWorkaround(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (Util.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean codecNeedsEosPropagationWorkaround(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (Util.SDK_INT <= 17 && ("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void throwDecoderInitError(DecoderInitializationException decoderInitializationException) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, decoderInitializationException) == null) {
            throw ExoPlaybackException.createForRenderer(decoderInitializationException, getIndex());
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.decoderCounters = new DecoderCounters();
        }
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public final int supportsFormat(Format format) throws ExoPlaybackException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, format)) == null) {
            try {
                return supportsFormat(this.mediaCodecSelector, this.drmSessionManager, format);
            } catch (MediaCodecUtil.DecoderQueryException e) {
                throw ExoPlaybackException.createForRenderer(e, getIndex());
            }
        }
        return invokeL.intValue;
    }

    public static boolean codecNeedsFlushWorkaround(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            int i = Util.SDK_INT;
            if (i >= 18 && ((i != 18 || (!"OMX.SEC.avc.dec".equals(str) && !"OMX.SEC.avc.dec.secure".equals(str))) && (Util.SDK_INT != 19 || !Util.MODEL.startsWith("SM-G800") || (!"OMX.Exynos.avc.dec".equals(str) && !"OMX.Exynos.avc.dec.secure".equals(str))))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean drainOutputBuffer(long j, long j2) throws ExoPlaybackException {
        InterceptResult invokeCommon;
        boolean processOutputBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (this.outputIndex < 0) {
                if (this.codecNeedsEosOutputExceptionWorkaround && this.codecReceivedEos) {
                    try {
                        this.outputIndex = this.codec.dequeueOutputBuffer(this.outputBufferInfo, getDequeueOutputBufferTimeoutUs());
                    } catch (IllegalStateException unused) {
                        processEndOfStream();
                        if (this.outputStreamEnded) {
                            releaseCodec();
                        }
                        return false;
                    }
                } else {
                    this.outputIndex = this.codec.dequeueOutputBuffer(this.outputBufferInfo, getDequeueOutputBufferTimeoutUs());
                }
                int i = this.outputIndex;
                if (i >= 0) {
                    if (this.shouldSkipAdaptationWorkaroundOutputBuffer) {
                        this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
                        this.codec.releaseOutputBuffer(i, false);
                        this.outputIndex = -1;
                        return true;
                    }
                    MediaCodec.BufferInfo bufferInfo = this.outputBufferInfo;
                    if ((bufferInfo.flags & 4) != 0) {
                        processEndOfStream();
                        this.outputIndex = -1;
                        return false;
                    }
                    ByteBuffer byteBuffer = this.outputBuffers[i];
                    if (byteBuffer != null) {
                        byteBuffer.position(bufferInfo.offset);
                        MediaCodec.BufferInfo bufferInfo2 = this.outputBufferInfo;
                        byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                    }
                    this.shouldSkipOutputBuffer = shouldSkipOutputBuffer(this.outputBufferInfo.presentationTimeUs);
                } else if (i == -2) {
                    processOutputFormat();
                    return true;
                } else if (i == -3) {
                    processOutputBuffersChanged();
                    return true;
                } else {
                    if (this.codecNeedsEosPropagationWorkaround && (this.inputStreamEnded || this.codecReinitializationState == 2)) {
                        processEndOfStream();
                    }
                    return false;
                }
            }
            if (this.codecNeedsEosOutputExceptionWorkaround && this.codecReceivedEos) {
                try {
                    processOutputBuffer = processOutputBuffer(j, j2, this.codec, this.outputBuffers[this.outputIndex], this.outputIndex, this.outputBufferInfo.flags, this.outputBufferInfo.presentationTimeUs, this.shouldSkipOutputBuffer);
                } catch (IllegalStateException unused2) {
                    processEndOfStream();
                    if (this.outputStreamEnded) {
                        releaseCodec();
                    }
                    return false;
                }
            } else {
                MediaCodec mediaCodec = this.codec;
                ByteBuffer[] byteBufferArr = this.outputBuffers;
                int i2 = this.outputIndex;
                ByteBuffer byteBuffer2 = byteBufferArr[i2];
                MediaCodec.BufferInfo bufferInfo3 = this.outputBufferInfo;
                processOutputBuffer = processOutputBuffer(j, j2, mediaCodec, byteBuffer2, i2, bufferInfo3.flags, bufferInfo3.presentationTimeUs, this.shouldSkipOutputBuffer);
            }
            if (!processOutputBuffer) {
                return false;
            }
            onProcessedOutputBuffer(this.outputBufferInfo.presentationTimeUs);
            this.outputIndex = -1;
            return true;
        }
        return invokeCommon.booleanValue;
    }

    private boolean feedInputBuffer() throws ExoPlaybackException {
        InterceptResult invokeV;
        int position;
        int readSource;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            MediaCodec mediaCodec = this.codec;
            if (mediaCodec == null || this.codecReinitializationState == 2 || this.inputStreamEnded) {
                return false;
            }
            if (this.inputIndex < 0) {
                int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(0L);
                this.inputIndex = dequeueInputBuffer;
                if (dequeueInputBuffer < 0) {
                    return false;
                }
                DecoderInputBuffer decoderInputBuffer = this.buffer;
                decoderInputBuffer.data = this.inputBuffers[dequeueInputBuffer];
                decoderInputBuffer.clear();
            }
            if (this.codecReinitializationState == 1) {
                if (!this.codecNeedsEosPropagationWorkaround) {
                    this.codecReceivedEos = true;
                    this.codec.queueInputBuffer(this.inputIndex, 0, 0, 0L, 4);
                    this.inputIndex = -1;
                }
                this.codecReinitializationState = 2;
                return false;
            } else if (this.codecNeedsAdaptationWorkaroundBuffer) {
                this.codecNeedsAdaptationWorkaroundBuffer = false;
                this.buffer.data.put(ADAPTATION_WORKAROUND_BUFFER);
                this.codec.queueInputBuffer(this.inputIndex, 0, ADAPTATION_WORKAROUND_BUFFER.length, 0L, 0);
                this.inputIndex = -1;
                this.codecReceivedBuffers = true;
                return true;
            } else {
                if (this.waitingForKeys) {
                    readSource = -4;
                    position = 0;
                } else {
                    if (this.codecReconfigurationState == 1) {
                        for (int i = 0; i < this.format.initializationData.size(); i++) {
                            this.buffer.data.put((byte[]) this.format.initializationData.get(i));
                        }
                        this.codecReconfigurationState = 2;
                    }
                    position = this.buffer.data.position();
                    readSource = readSource(this.formatHolder, this.buffer, false);
                }
                if (readSource == -3) {
                    return false;
                }
                if (readSource == -5) {
                    if (this.codecReconfigurationState == 2) {
                        this.buffer.clear();
                        this.codecReconfigurationState = 1;
                    }
                    onInputFormatChanged(this.formatHolder.format);
                    return true;
                } else if (this.buffer.isEndOfStream()) {
                    if (this.codecReconfigurationState == 2) {
                        this.buffer.clear();
                        this.codecReconfigurationState = 1;
                    }
                    this.inputStreamEnded = true;
                    if (!this.codecReceivedBuffers) {
                        processEndOfStream();
                        return false;
                    }
                    try {
                        if (!this.codecNeedsEosPropagationWorkaround) {
                            this.codecReceivedEos = true;
                            this.codec.queueInputBuffer(this.inputIndex, 0, 0, 0L, 4);
                            this.inputIndex = -1;
                        }
                        return false;
                    } catch (MediaCodec.CryptoException e) {
                        throw ExoPlaybackException.createForRenderer(e, getIndex());
                    }
                } else if (this.waitingForFirstSyncFrame && !this.buffer.isKeyFrame()) {
                    this.buffer.clear();
                    if (this.codecReconfigurationState == 2) {
                        this.codecReconfigurationState = 1;
                    }
                    return true;
                } else {
                    this.waitingForFirstSyncFrame = false;
                    boolean isEncrypted = this.buffer.isEncrypted();
                    boolean shouldWaitForKeys = shouldWaitForKeys(isEncrypted);
                    this.waitingForKeys = shouldWaitForKeys;
                    if (shouldWaitForKeys) {
                        return false;
                    }
                    if (this.codecNeedsDiscardToSpsWorkaround && !isEncrypted) {
                        NalUnitUtil.discardToSps(this.buffer.data);
                        if (this.buffer.data.position() == 0) {
                            return true;
                        }
                        this.codecNeedsDiscardToSpsWorkaround = false;
                    }
                    try {
                        long j = this.buffer.timeUs;
                        if (this.buffer.isDecodeOnly()) {
                            this.decodeOnlyPresentationTimestamps.add(Long.valueOf(j));
                        }
                        this.buffer.flip();
                        onQueueInputBuffer(this.buffer);
                        if (isEncrypted) {
                            this.codec.queueSecureInputBuffer(this.inputIndex, 0, getFrameworkCryptoInfo(this.buffer, position), j, 0);
                        } else {
                            this.codec.queueInputBuffer(this.inputIndex, 0, this.buffer.data.limit(), j, 0);
                        }
                        this.inputIndex = -1;
                        this.codecReceivedBuffers = true;
                        this.codecReconfigurationState = 0;
                        this.decoderCounters.inputBufferCount++;
                        return true;
                    } catch (MediaCodec.CryptoException e2) {
                        throw ExoPlaybackException.createForRenderer(e2, getIndex());
                    }
                }
            }
        }
        return invokeV.booleanValue;
    }

    private void processOutputFormat() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            MediaFormat outputFormat = this.codec.getOutputFormat();
            if (this.codecAdaptationWorkaroundMode != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                this.shouldSkipAdaptationWorkaroundOutputBuffer = true;
                return;
            }
            if (this.codecNeedsMonoChannelCountWorkaround) {
                outputFormat.setInteger("channel-count", 1);
            }
            onOutputFormatChanged(this.codec, outputFormat);
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.format != null && !this.waitingForKeys && (isSourceReady() || this.outputIndex >= 0 || (this.codecHotswapDeadlineMs != C.TIME_UNSET && SystemClock.elapsedRealtime() < this.codecHotswapDeadlineMs))) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void flushCodec() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.codecHotswapDeadlineMs = C.TIME_UNSET;
            this.inputIndex = -1;
            this.outputIndex = -1;
            this.waitingForFirstSyncFrame = true;
            this.waitingForKeys = false;
            this.shouldSkipOutputBuffer = false;
            this.decodeOnlyPresentationTimestamps.clear();
            this.codecNeedsAdaptationWorkaroundBuffer = false;
            this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
            if (!this.codecNeedsFlushWorkaround && (!this.codecNeedsEosFlushWorkaround || !this.codecReceivedEos)) {
                if (this.codecReinitializationState != 0) {
                    releaseCodec();
                    maybeInitCodec();
                } else {
                    this.codec.flush();
                    this.codecReceivedBuffers = false;
                }
            } else {
                releaseCodec();
                maybeInitCodec();
            }
            if (this.codecReconfigured && this.format != null) {
                this.codecReconfigurationState = 1;
            }
        }
    }

    public MediaCodecInfo getDecoderInfo(MediaCodecSelector mediaCodecSelector, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048581, this, mediaCodecSelector, format, z)) == null) {
            return mediaCodecSelector.getDecoderInfo(format.sampleMimeType, z);
        }
        return (MediaCodecInfo) invokeLLZ.objValue;
    }

    public final void maybeInitCodec() throws ExoPlaybackException {
        Format format;
        MediaCrypto mediaCrypto;
        boolean z;
        long j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.codec == null && (format = this.format) != null) {
            DrmSession drmSession = this.pendingDrmSession;
            this.drmSession = drmSession;
            String str = format.sampleMimeType;
            if (drmSession != null) {
                FrameworkMediaCrypto frameworkMediaCrypto = (FrameworkMediaCrypto) drmSession.getMediaCrypto();
                if (frameworkMediaCrypto == null) {
                    DrmSession.DrmSessionException error = this.drmSession.getError();
                    if (error == null) {
                        return;
                    }
                    throw ExoPlaybackException.createForRenderer(error, getIndex());
                }
                mediaCrypto = frameworkMediaCrypto.getWrappedMediaCrypto();
                z = frameworkMediaCrypto.requiresSecureDecoderComponent(str);
            } else {
                mediaCrypto = null;
                z = false;
            }
            if (this.codecInfo == null) {
                try {
                    MediaCodecInfo decoderInfo = getDecoderInfo(this.mediaCodecSelector, this.format, z);
                    this.codecInfo = decoderInfo;
                    if (decoderInfo == null && z) {
                        MediaCodecInfo decoderInfo2 = getDecoderInfo(this.mediaCodecSelector, this.format, false);
                        this.codecInfo = decoderInfo2;
                        if (decoderInfo2 != null) {
                            Log.w(TAG, "Drm session requires secure decoder for " + str + ", but no secure decoder available. Trying to proceed with " + this.codecInfo.name + ".");
                        }
                    }
                } catch (MediaCodecUtil.DecoderQueryException e) {
                    throwDecoderInitError(new DecoderInitializationException(this.format, e, z, (int) DecoderInitializationException.DECODER_QUERY_ERROR));
                }
                if (this.codecInfo == null) {
                    throwDecoderInitError(new DecoderInitializationException(this.format, (Throwable) null, z, (int) DecoderInitializationException.NO_SUITABLE_DECODER_ERROR));
                }
            }
            if (!shouldInitCodec(this.codecInfo)) {
                return;
            }
            String str2 = this.codecInfo.name;
            this.codecAdaptationWorkaroundMode = codecAdaptationWorkaroundMode(str2);
            this.codecNeedsDiscardToSpsWorkaround = codecNeedsDiscardToSpsWorkaround(str2, this.format);
            this.codecNeedsFlushWorkaround = codecNeedsFlushWorkaround(str2);
            this.codecNeedsEosPropagationWorkaround = codecNeedsEosPropagationWorkaround(str2);
            this.codecNeedsEosFlushWorkaround = codecNeedsEosFlushWorkaround(str2);
            this.codecNeedsEosOutputExceptionWorkaround = codecNeedsEosOutputExceptionWorkaround(str2);
            this.codecNeedsMonoChannelCountWorkaround = codecNeedsMonoChannelCountWorkaround(str2, this.format);
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                TraceUtil.beginSection("createCodec:" + str2);
                this.codec = MediaCodec.createByCodecName(str2);
                TraceUtil.endSection();
                TraceUtil.beginSection("configureCodec");
                configureCodec(this.codecInfo, this.codec, this.format, mediaCrypto);
                TraceUtil.endSection();
                TraceUtil.beginSection("startCodec");
                this.codec.start();
                TraceUtil.endSection();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                onCodecInitialized(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                this.inputBuffers = this.codec.getInputBuffers();
                this.outputBuffers = this.codec.getOutputBuffers();
            } catch (Exception e2) {
                throwDecoderInitError(new DecoderInitializationException(this.format, e2, z, str2));
            }
            if (getState() == 2) {
                j = SystemClock.elapsedRealtime() + 1000;
            } else {
                j = C.TIME_UNSET;
            }
            this.codecHotswapDeadlineMs = j;
            this.inputIndex = -1;
            this.outputIndex = -1;
            this.waitingForFirstSyncFrame = true;
            this.decoderCounters.decoderInitCount++;
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 4, expect 1 */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.format = null;
            try {
                releaseCodec();
                try {
                    if (this.drmSession != null) {
                        this.drmSessionManager.releaseSession(this.drmSession);
                    }
                    try {
                        if (this.pendingDrmSession != null && this.pendingDrmSession != this.drmSession) {
                            this.drmSessionManager.releaseSession(this.pendingDrmSession);
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        if (this.pendingDrmSession != null && this.pendingDrmSession != this.drmSession) {
                            this.drmSessionManager.releaseSession(this.pendingDrmSession);
                        }
                        throw th;
                    } finally {
                    }
                }
            } catch (Throwable th2) {
                try {
                    if (this.drmSession != null) {
                        this.drmSessionManager.releaseSession(this.drmSession);
                    }
                    try {
                        if (this.pendingDrmSession != null && this.pendingDrmSession != this.drmSession) {
                            this.drmSessionManager.releaseSession(this.pendingDrmSession);
                        }
                        throw th2;
                    } finally {
                    }
                } catch (Throwable th3) {
                    try {
                        if (this.pendingDrmSession != null && this.pendingDrmSession != this.drmSession) {
                            this.drmSessionManager.releaseSession(this.pendingDrmSession);
                        }
                        throw th3;
                    } finally {
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 4, expect 1 */
    public void releaseCodec() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.codecHotswapDeadlineMs = C.TIME_UNSET;
            this.inputIndex = -1;
            this.outputIndex = -1;
            this.waitingForKeys = false;
            this.shouldSkipOutputBuffer = false;
            this.decodeOnlyPresentationTimestamps.clear();
            this.inputBuffers = null;
            this.outputBuffers = null;
            this.codecInfo = null;
            this.codecReconfigured = false;
            this.codecReceivedBuffers = false;
            this.codecNeedsDiscardToSpsWorkaround = false;
            this.codecNeedsFlushWorkaround = false;
            this.codecAdaptationWorkaroundMode = 0;
            this.codecNeedsEosPropagationWorkaround = false;
            this.codecNeedsEosFlushWorkaround = false;
            this.codecNeedsMonoChannelCountWorkaround = false;
            this.codecNeedsAdaptationWorkaroundBuffer = false;
            this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
            this.codecReceivedEos = false;
            this.codecReconfigurationState = 0;
            this.codecReinitializationState = 0;
            this.buffer.data = null;
            MediaCodec mediaCodec = this.codec;
            if (mediaCodec != null) {
                this.decoderCounters.decoderReleaseCount++;
                try {
                    mediaCodec.stop();
                    try {
                        this.codec.release();
                        this.codec = null;
                        DrmSession drmSession = this.drmSession;
                        if (drmSession != null && this.pendingDrmSession != drmSession) {
                            try {
                                this.drmSessionManager.releaseSession(drmSession);
                            } finally {
                            }
                        }
                    } catch (Throwable th) {
                        this.codec = null;
                        DrmSession drmSession2 = this.drmSession;
                        if (drmSession2 != null && this.pendingDrmSession != drmSession2) {
                            try {
                                this.drmSessionManager.releaseSession(drmSession2);
                            } finally {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    try {
                        this.codec.release();
                        this.codec = null;
                        DrmSession drmSession3 = this.drmSession;
                        if (drmSession3 != null && this.pendingDrmSession != drmSession3) {
                            try {
                                this.drmSessionManager.releaseSession(drmSession3);
                            } finally {
                            }
                        }
                        throw th2;
                    } catch (Throwable th3) {
                        this.codec = null;
                        DrmSession drmSession4 = this.drmSession;
                        if (drmSession4 != null && this.pendingDrmSession != drmSession4) {
                            try {
                                this.drmSessionManager.releaseSession(drmSession4);
                            } finally {
                            }
                        }
                        throw th3;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x007a, code lost:
        if (r5.height == r0.height) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onInputFormatChanged(Format format) throws ExoPlaybackException {
        DrmInitData drmInitData;
        MediaCodec mediaCodec;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, format) == null) {
            Format format2 = this.format;
            this.format = format;
            DrmInitData drmInitData2 = format.drmInitData;
            if (format2 == null) {
                drmInitData = null;
            } else {
                drmInitData = format2.drmInitData;
            }
            boolean areEqual = Util.areEqual(drmInitData2, drmInitData);
            boolean z = true;
            if (!areEqual) {
                if (this.format.drmInitData != null) {
                    DrmSessionManager drmSessionManager = this.drmSessionManager;
                    if (drmSessionManager != null) {
                        DrmSession acquireSession = drmSessionManager.acquireSession(Looper.myLooper(), this.format.drmInitData);
                        this.pendingDrmSession = acquireSession;
                        if (acquireSession == this.drmSession) {
                            this.drmSessionManager.releaseSession(acquireSession);
                        }
                    } else {
                        throw ExoPlaybackException.createForRenderer(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
                    }
                } else {
                    this.pendingDrmSession = null;
                }
            }
            if (this.pendingDrmSession == this.drmSession && (mediaCodec = this.codec) != null && canReconfigureCodec(mediaCodec, this.codecInfo.adaptive, format2, this.format)) {
                this.codecReconfigured = true;
                this.codecReconfigurationState = 1;
                int i = this.codecAdaptationWorkaroundMode;
                if (i != 2) {
                    if (i == 1) {
                        Format format3 = this.format;
                        if (format3.width == format2.width) {
                        }
                    }
                    z = false;
                }
                this.codecNeedsAdaptationWorkaroundBuffer = z;
            } else if (this.codecReceivedBuffers) {
                this.codecReinitializationState = 1;
            } else {
                releaseCodec();
                maybeInitCodec();
            }
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (this.outputStreamEnded) {
                renderToEndOfStream();
                return;
            }
            if (this.format == null) {
                this.flagsOnlyBuffer.clear();
                int readSource = readSource(this.formatHolder, this.flagsOnlyBuffer, true);
                if (readSource == -5) {
                    onInputFormatChanged(this.formatHolder.format);
                } else if (readSource == -4) {
                    Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
                    this.inputStreamEnded = true;
                    processEndOfStream();
                    return;
                } else {
                    return;
                }
            }
            maybeInitCodec();
            if (this.codec != null) {
                TraceUtil.beginSection("drainAndFeed");
                do {
                } while (drainOutputBuffer(j, j2));
                do {
                } while (feedInputBuffer());
                TraceUtil.endSection();
            } else {
                this.decoderCounters.skippedInputBufferCount += skipSource(j);
                this.flagsOnlyBuffer.clear();
                int readSource2 = readSource(this.formatHolder, this.flagsOnlyBuffer, false);
                if (readSource2 == -5) {
                    onInputFormatChanged(this.formatHolder.format);
                } else if (readSource2 == -4) {
                    Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
                    this.inputStreamEnded = true;
                    processEndOfStream();
                }
            }
            this.decoderCounters.ensureUpdated();
        }
    }
}
