package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.material.internal.ManufacturerUtils;
import java.nio.ByteBuffer;
@TargetApi(16)
/* loaded from: classes7.dex */
public class MediaCodecAudioRenderer extends MediaCodecRenderer implements MediaClock {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean allowPositionDiscontinuity;
    public final AudioSink audioSink;
    public int channelCount;
    public boolean codecNeedsDiscardChannelsWorkaround;
    public long currentPositionUs;
    public int encoderDelay;
    public int encoderPadding;
    public final AudioRendererEventListener.EventDispatcher eventDispatcher;
    public boolean passthroughEnabled;
    public MediaFormat passthroughMediaFormat;
    public int pcmEncoding;

    /* renamed from: com.google.android.exoplayer2.audio.MediaCodecAudioRenderer$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public final class AudioSinkListener implements AudioSink.Listener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaCodecAudioRenderer this$0;

        public AudioSinkListener(MediaCodecAudioRenderer mediaCodecAudioRenderer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaCodecAudioRenderer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaCodecAudioRenderer;
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onAudioSessionId(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.this$0.eventDispatcher.audioSessionId(i2);
                this.this$0.onAudioSessionId(i2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onPositionDiscontinuity() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.this$0.onAudioTrackPositionDiscontinuity();
                this.this$0.allowPositionDiscontinuity = true;
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onUnderrun(int i2, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                this.this$0.eventDispatcher.audioTrackUnderrun(i2, j2, j3);
                this.this$0.onAudioTrackUnderrun(i2, j2, j3);
            }
        }

        public /* synthetic */ AudioSinkListener(MediaCodecAudioRenderer mediaCodecAudioRenderer, AnonymousClass1 anonymousClass1) {
            this(mediaCodecAudioRenderer);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaCodecAudioRenderer(MediaCodecSelector mediaCodecSelector) {
        this(mediaCodecSelector, (DrmSessionManager<FrameworkMediaCrypto>) null, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaCodecSelector};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((MediaCodecSelector) objArr2[0], (DrmSessionManager) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean codecNeedsDiscardChannelsWorkaround(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? Util.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(str) && ManufacturerUtils.SAMSUNG.equals(Util.MANUFACTURER) && (Util.DEVICE.startsWith("zeroflte") || Util.DEVICE.startsWith("herolte") || Util.DEVICE.startsWith("heroqlte")) : invokeL.booleanValue;
    }

    public boolean allowPassthrough(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.audioSink.isPassthroughSupported(str) : invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaCodecInfo, mediaCodec, format, mediaCrypto) == null) {
            this.codecNeedsDiscardChannelsWorkaround = codecNeedsDiscardChannelsWorkaround(mediaCodecInfo.name);
            if (this.passthroughEnabled) {
                MediaFormat frameworkMediaFormatV16 = format.getFrameworkMediaFormatV16();
                this.passthroughMediaFormat = frameworkMediaFormatV16;
                frameworkMediaFormatV16.setString("mime", MimeTypes.AUDIO_RAW);
                mediaCodec.configure(this.passthroughMediaFormat, (Surface) null, mediaCrypto, 0);
                this.passthroughMediaFormat.setString("mime", format.sampleMimeType);
                return;
            }
            mediaCodec.configure(format.getFrameworkMediaFormatV16(), (Surface) null, mediaCrypto, 0);
            this.passthroughMediaFormat = null;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public MediaCodecInfo getDecoderInfo(MediaCodecSelector mediaCodecSelector, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        InterceptResult invokeLLZ;
        MediaCodecInfo passthroughDecoderInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, mediaCodecSelector, format, z)) == null) {
            if (allowPassthrough(format.sampleMimeType) && (passthroughDecoderInfo = mediaCodecSelector.getPassthroughDecoderInfo()) != null) {
                this.passthroughEnabled = true;
                return passthroughDecoderInfo;
            }
            this.passthroughEnabled = false;
            return super.getDecoderInfo(mediaCodecSelector, format, z);
        }
        return (MediaCodecInfo) invokeLLZ.objValue;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.Renderer
    public MediaClock getMediaClock() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (MediaClock) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters getPlaybackParameters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.audioSink.getPlaybackParameters() : (PlaybackParameters) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            long currentPositionUs = this.audioSink.getCurrentPositionUs(isEnded());
            if (currentPositionUs != Long.MIN_VALUE) {
                if (!this.allowPositionDiscontinuity) {
                    currentPositionUs = Math.max(this.currentPositionUs, currentPositionUs);
                }
                this.currentPositionUs = currentPositionUs;
                this.allowPositionDiscontinuity = false;
            }
            return this.currentPositionUs;
        }
        return invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.ExoPlayer.ExoPlayerComponent
    public void handleMessage(int i2, Object obj) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, obj) == null) {
            if (i2 == 2) {
                this.audioSink.setVolume(((Float) obj).floatValue());
            } else if (i2 != 3) {
                super.handleMessage(i2, obj);
            } else {
                this.audioSink.setAudioAttributes((AudioAttributes) obj);
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? super.isEnded() && this.audioSink.isEnded() : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.audioSink.hasPendingData() || super.isReady() : invokeV.booleanValue;
    }

    public void onAudioSessionId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
        }
    }

    public void onAudioTrackPositionDiscontinuity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public void onAudioTrackUnderrun(int i2, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecInitialized(String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.eventDispatcher.decoderInitialized(str, j2, j3);
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            try {
                this.audioSink.release();
                try {
                    super.onDisabled();
                } finally {
                }
            } catch (Throwable th) {
                try {
                    super.onDisabled();
                    throw th;
                } finally {
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            super.onEnabled(z);
            this.eventDispatcher.enabled(this.decoderCounters);
            int i2 = getConfiguration().tunnelingAudioSessionId;
            if (i2 != 0) {
                this.audioSink.enableTunnelingV21(i2);
            } else {
                this.audioSink.disableTunneling();
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onInputFormatChanged(Format format) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, format) == null) {
            super.onInputFormatChanged(format);
            this.eventDispatcher.inputFormatChanged(format);
            this.pcmEncoding = MimeTypes.AUDIO_RAW.equals(format.sampleMimeType) ? format.pcmEncoding : 2;
            this.channelCount = format.channelCount;
            int i2 = format.encoderDelay;
            if (i2 == -1) {
                i2 = 0;
            }
            this.encoderDelay = i2;
            int i3 = format.encoderPadding;
            this.encoderPadding = i3 != -1 ? i3 : 0;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException {
        int[] iArr;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, mediaCodec, mediaFormat) == null) {
            boolean z = this.passthroughMediaFormat != null;
            String string = z ? this.passthroughMediaFormat.getString("mime") : MimeTypes.AUDIO_RAW;
            if (z) {
                mediaFormat = this.passthroughMediaFormat;
            }
            int integer = mediaFormat.getInteger("channel-count");
            int integer2 = mediaFormat.getInteger("sample-rate");
            if (this.codecNeedsDiscardChannelsWorkaround && integer == 6 && (i2 = this.channelCount) < 6) {
                iArr = new int[i2];
                for (int i3 = 0; i3 < this.channelCount; i3++) {
                    iArr[i3] = i3;
                }
            } else {
                iArr = null;
            }
            try {
                this.audioSink.configure(string, integer, integer2, this.pcmEncoding, 0, iArr, this.encoderDelay, this.encoderPadding);
            } catch (AudioSink.ConfigurationException e2) {
                throw ExoPlaybackException.createForRenderer(e2, getIndex());
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j2, boolean z) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            super.onPositionReset(j2, z);
            this.audioSink.reset();
            this.currentPositionUs = j2;
            this.allowPositionDiscontinuity = true;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onStarted();
            this.audioSink.play();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.audioSink.pause();
            super.onStopped();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean processOutputBuffer(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z) throws ExoPlaybackException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), mediaCodec, byteBuffer, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j4), Boolean.valueOf(z)})) == null) {
            if (this.passthroughEnabled && (i3 & 2) != 0) {
                mediaCodec.releaseOutputBuffer(i2, false);
                return true;
            } else if (z) {
                mediaCodec.releaseOutputBuffer(i2, false);
                this.decoderCounters.skippedOutputBufferCount++;
                this.audioSink.handleDiscontinuity();
                return true;
            } else {
                try {
                    if (this.audioSink.handleBuffer(byteBuffer, j4)) {
                        mediaCodec.releaseOutputBuffer(i2, false);
                        this.decoderCounters.renderedOutputBufferCount++;
                        return true;
                    }
                    return false;
                } catch (AudioSink.InitializationException | AudioSink.WriteException e2) {
                    throw ExoPlaybackException.createForRenderer(e2, getIndex());
                }
            }
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void renderToEndOfStream() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            try {
                this.audioSink.playToEndOfStream();
            } catch (AudioSink.WriteException e2) {
                throw ExoPlaybackException.createForRenderer(e2, getIndex());
            }
        }
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, playbackParameters)) == null) ? this.audioSink.setPlaybackParameters(playbackParameters) : (PlaybackParameters) invokeL.objValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int supportsFormat(MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, Format format) throws MediaCodecUtil.DecoderQueryException {
        InterceptResult invokeLLL;
        boolean z;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048599, this, mediaCodecSelector, drmSessionManager, format)) == null) {
            String str = format.sampleMimeType;
            boolean z2 = false;
            if (MimeTypes.isAudio(str)) {
                int i4 = Util.SDK_INT >= 21 ? 32 : 0;
                boolean supportsFormatDrm = BaseRenderer.supportsFormatDrm(drmSessionManager, format.drmInitData);
                if (supportsFormatDrm && allowPassthrough(str) && mediaCodecSelector.getPassthroughDecoderInfo() != null) {
                    return i4 | 8 | 4;
                }
                DrmInitData drmInitData = format.drmInitData;
                if (drmInitData != null) {
                    z = false;
                    for (int i5 = 0; i5 < drmInitData.schemeDataCount; i5++) {
                        z |= drmInitData.get(i5).requiresSecureDecryption;
                    }
                } else {
                    z = false;
                }
                MediaCodecInfo decoderInfo = mediaCodecSelector.getDecoderInfo(str, z);
                if (decoderInfo == null) {
                    return (!z || mediaCodecSelector.getDecoderInfo(str, false) == null) ? 1 : 2;
                } else if (supportsFormatDrm) {
                    if (Util.SDK_INT < 21 || (((i2 = format.sampleRate) == -1 || decoderInfo.isAudioSampleRateSupportedV21(i2)) && ((i3 = format.channelCount) == -1 || decoderInfo.isAudioChannelCountSupportedV21(i3)))) {
                        z2 = true;
                    }
                    return i4 | 8 | (z2 ? 4 : 3);
                } else {
                    return 2;
                }
            }
            return 0;
        }
        return invokeLLL.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaCodecAudioRenderer(MediaCodecSelector mediaCodecSelector, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z) {
        this(mediaCodecSelector, drmSessionManager, z, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaCodecSelector, drmSessionManager, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((MediaCodecSelector) objArr2[0], (DrmSessionManager) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), (Handler) objArr2[3], (AudioRendererEventListener) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaCodecAudioRenderer(MediaCodecSelector mediaCodecSelector, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener) {
        this(mediaCodecSelector, null, true, handler, audioRendererEventListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaCodecSelector, handler, audioRendererEventListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((MediaCodecSelector) objArr2[0], (DrmSessionManager) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), (Handler) objArr2[3], (AudioRendererEventListener) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaCodecAudioRenderer(MediaCodecSelector mediaCodecSelector, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener) {
        this(mediaCodecSelector, drmSessionManager, z, handler, audioRendererEventListener, null, new AudioProcessor[0]);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaCodecSelector, drmSessionManager, Boolean.valueOf(z), handler, audioRendererEventListener};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((MediaCodecSelector) objArr2[0], (DrmSessionManager) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), (Handler) objArr2[3], (AudioRendererEventListener) objArr2[4], (AudioCapabilities) objArr2[5], (AudioProcessor[]) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaCodecAudioRenderer(MediaCodecSelector mediaCodecSelector, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, @Nullable AudioCapabilities audioCapabilities, AudioProcessor... audioProcessorArr) {
        this(mediaCodecSelector, drmSessionManager, z, handler, audioRendererEventListener, new DefaultAudioSink(audioCapabilities, audioProcessorArr));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {mediaCodecSelector, drmSessionManager, Boolean.valueOf(z), handler, audioRendererEventListener, audioCapabilities, audioProcessorArr};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((MediaCodecSelector) objArr2[0], (DrmSessionManager) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), (Handler) objArr2[3], (AudioRendererEventListener) objArr2[4], (AudioSink) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaCodecAudioRenderer(MediaCodecSelector mediaCodecSelector, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        super(1, mediaCodecSelector, drmSessionManager, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaCodecSelector, drmSessionManager, Boolean.valueOf(z), handler, audioRendererEventListener, audioSink};
            interceptable.invokeUnInit(65541, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (MediaCodecSelector) objArr2[1], (DrmSessionManager) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        this.eventDispatcher = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        this.audioSink = audioSink;
        audioSink.setListener(new AudioSinkListener(this, null));
    }
}
