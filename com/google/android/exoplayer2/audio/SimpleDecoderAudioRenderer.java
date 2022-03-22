package com.google.android.exoplayer2.audio;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
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
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.google.android.exoplayer2.decoder.SimpleOutputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
/* loaded from: classes6.dex */
public abstract class SimpleDecoderAudioRenderer extends BaseRenderer implements MediaClock {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REINITIALIZATION_STATE_NONE = 0;
    public static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
    public static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean allowPositionDiscontinuity;
    public final AudioSink audioSink;
    public boolean audioTrackNeedsConfigure;
    public long currentPositionUs;
    public SimpleDecoder<DecoderInputBuffer, ? extends SimpleOutputBuffer, ? extends AudioDecoderException> decoder;
    public DecoderCounters decoderCounters;
    public boolean decoderReceivedBuffers;
    public int decoderReinitializationState;
    public DrmSession<ExoMediaCrypto> drmSession;
    public final DrmSessionManager<ExoMediaCrypto> drmSessionManager;
    public int encoderDelay;
    public int encoderPadding;
    public final AudioRendererEventListener.EventDispatcher eventDispatcher;
    public final DecoderInputBuffer flagsOnlyBuffer;
    public final FormatHolder formatHolder;
    public DecoderInputBuffer inputBuffer;
    public Format inputFormat;
    public boolean inputStreamEnded;
    public SimpleOutputBuffer outputBuffer;
    public boolean outputStreamEnded;
    public DrmSession<ExoMediaCrypto> pendingDrmSession;
    public final boolean playClearSamplesWithoutKeys;
    public boolean waitingForKeys;

    /* renamed from: com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public final class AudioSinkListener implements AudioSink.Listener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SimpleDecoderAudioRenderer this$0;

        public AudioSinkListener(SimpleDecoderAudioRenderer simpleDecoderAudioRenderer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {simpleDecoderAudioRenderer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = simpleDecoderAudioRenderer;
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onAudioSessionId(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.this$0.eventDispatcher.audioSessionId(i);
                this.this$0.onAudioSessionId(i);
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
        public void onUnderrun(int i, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.this$0.eventDispatcher.audioTrackUnderrun(i, j, j2);
                this.this$0.onAudioTrackUnderrun(i, j, j2);
            }
        }

        public /* synthetic */ AudioSinkListener(SimpleDecoderAudioRenderer simpleDecoderAudioRenderer, AnonymousClass1 anonymousClass1) {
            this(simpleDecoderAudioRenderer);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleDecoderAudioRenderer() {
        this((Handler) null, (AudioRendererEventListener) null, new AudioProcessor[0]);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((Handler) objArr[0], (AudioRendererEventListener) objArr[1], (AudioProcessor[]) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private boolean drainOutputBuffer() throws ExoPlaybackException, AudioDecoderException, AudioSink.ConfigurationException, AudioSink.InitializationException, AudioSink.WriteException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (this.outputBuffer == null) {
                SimpleOutputBuffer dequeueOutputBuffer = this.decoder.dequeueOutputBuffer();
                this.outputBuffer = dequeueOutputBuffer;
                if (dequeueOutputBuffer == null) {
                    return false;
                }
                this.decoderCounters.skippedOutputBufferCount += dequeueOutputBuffer.skippedOutputBufferCount;
            }
            if (this.outputBuffer.isEndOfStream()) {
                if (this.decoderReinitializationState == 2) {
                    releaseDecoder();
                    maybeInitDecoder();
                    this.audioTrackNeedsConfigure = true;
                } else {
                    this.outputBuffer.release();
                    this.outputBuffer = null;
                    processEndOfStream();
                }
                return false;
            }
            if (this.audioTrackNeedsConfigure) {
                Format outputFormat = getOutputFormat();
                this.audioSink.configure(outputFormat.sampleMimeType, outputFormat.channelCount, outputFormat.sampleRate, outputFormat.pcmEncoding, 0, null, this.encoderDelay, this.encoderPadding);
                this.audioTrackNeedsConfigure = false;
            }
            AudioSink audioSink = this.audioSink;
            SimpleOutputBuffer simpleOutputBuffer = this.outputBuffer;
            if (audioSink.handleBuffer(simpleOutputBuffer.data, simpleOutputBuffer.timeUs)) {
                this.decoderCounters.renderedOutputBufferCount++;
                this.outputBuffer.release();
                this.outputBuffer = null;
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean feedInputBuffer() throws AudioDecoderException, ExoPlaybackException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            SimpleDecoder<DecoderInputBuffer, ? extends SimpleOutputBuffer, ? extends AudioDecoderException> simpleDecoder = this.decoder;
            if (simpleDecoder == null || this.decoderReinitializationState == 2 || this.inputStreamEnded) {
                return false;
            }
            if (this.inputBuffer == null) {
                DecoderInputBuffer dequeueInputBuffer = simpleDecoder.dequeueInputBuffer();
                this.inputBuffer = dequeueInputBuffer;
                if (dequeueInputBuffer == null) {
                    return false;
                }
            }
            if (this.decoderReinitializationState == 1) {
                this.inputBuffer.setFlags(4);
                this.decoder.queueInputBuffer((SimpleDecoder<DecoderInputBuffer, ? extends SimpleOutputBuffer, ? extends AudioDecoderException>) this.inputBuffer);
                this.inputBuffer = null;
                this.decoderReinitializationState = 2;
                return false;
            }
            int readSource = this.waitingForKeys ? -4 : readSource(this.formatHolder, this.inputBuffer, false);
            if (readSource == -3) {
                return false;
            }
            if (readSource == -5) {
                onInputFormatChanged(this.formatHolder.format);
                return true;
            } else if (this.inputBuffer.isEndOfStream()) {
                this.inputStreamEnded = true;
                this.decoder.queueInputBuffer((SimpleDecoder<DecoderInputBuffer, ? extends SimpleOutputBuffer, ? extends AudioDecoderException>) this.inputBuffer);
                this.inputBuffer = null;
                return false;
            } else {
                boolean shouldWaitForKeys = shouldWaitForKeys(this.inputBuffer.isEncrypted());
                this.waitingForKeys = shouldWaitForKeys;
                if (shouldWaitForKeys) {
                    return false;
                }
                this.inputBuffer.flip();
                this.decoder.queueInputBuffer((SimpleDecoder<DecoderInputBuffer, ? extends SimpleOutputBuffer, ? extends AudioDecoderException>) this.inputBuffer);
                this.decoderReceivedBuffers = true;
                this.decoderCounters.inputBufferCount++;
                this.inputBuffer = null;
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    private void flushDecoder() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.waitingForKeys = false;
            if (this.decoderReinitializationState != 0) {
                releaseDecoder();
                maybeInitDecoder();
                return;
            }
            this.inputBuffer = null;
            SimpleOutputBuffer simpleOutputBuffer = this.outputBuffer;
            if (simpleOutputBuffer != null) {
                simpleOutputBuffer.release();
                this.outputBuffer = null;
            }
            this.decoder.flush();
            this.decoderReceivedBuffers = false;
        }
    }

    private void maybeInitDecoder() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, this) == null) && this.decoder == null) {
            DrmSession<ExoMediaCrypto> drmSession = this.pendingDrmSession;
            this.drmSession = drmSession;
            ExoMediaCrypto exoMediaCrypto = null;
            if (drmSession != null && (exoMediaCrypto = drmSession.getMediaCrypto()) == null) {
                DrmSession.DrmSessionException error = this.drmSession.getError();
                if (error != null) {
                    throw ExoPlaybackException.createForRenderer(error, getIndex());
                }
                return;
            }
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                TraceUtil.beginSection("createAudioDecoder");
                this.decoder = createDecoder(this.inputFormat, exoMediaCrypto);
                TraceUtil.endSection();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                this.eventDispatcher.decoderInitialized(this.decoder.getName(), elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                this.decoderCounters.decoderInitCount++;
            } catch (AudioDecoderException e2) {
                throw ExoPlaybackException.createForRenderer(e2, getIndex());
            }
        }
    }

    private void onInputFormatChanged(Format format) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, format) == null) {
            Format format2 = this.inputFormat;
            this.inputFormat = format;
            if (!Util.areEqual(format.drmInitData, format2 == null ? null : format2.drmInitData)) {
                if (this.inputFormat.drmInitData != null) {
                    DrmSessionManager<ExoMediaCrypto> drmSessionManager = this.drmSessionManager;
                    if (drmSessionManager != null) {
                        DrmSession<ExoMediaCrypto> acquireSession = drmSessionManager.acquireSession(Looper.myLooper(), this.inputFormat.drmInitData);
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
            if (this.decoderReceivedBuffers) {
                this.decoderReinitializationState = 1;
            } else {
                releaseDecoder();
                maybeInitDecoder();
                this.audioTrackNeedsConfigure = true;
            }
            int i = format.encoderDelay;
            if (i == -1) {
                i = 0;
            }
            this.encoderDelay = i;
            int i2 = format.encoderPadding;
            this.encoderPadding = i2 != -1 ? i2 : 0;
            this.eventDispatcher.inputFormatChanged(format);
        }
    }

    private void processEndOfStream() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.outputStreamEnded = true;
            try {
                this.audioSink.playToEndOfStream();
            } catch (AudioSink.WriteException unused) {
                throw ExoPlaybackException.createForRenderer(this.drmSession.getError(), getIndex());
            }
        }
    }

    private void releaseDecoder() {
        SimpleDecoder<DecoderInputBuffer, ? extends SimpleOutputBuffer, ? extends AudioDecoderException> simpleDecoder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || (simpleDecoder = this.decoder) == null) {
            return;
        }
        this.inputBuffer = null;
        this.outputBuffer = null;
        simpleDecoder.release();
        this.decoder = null;
        this.decoderCounters.decoderReleaseCount++;
        this.decoderReinitializationState = 0;
        this.decoderReceivedBuffers = false;
    }

    private boolean shouldWaitForKeys(boolean z) throws ExoPlaybackException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65550, this, z)) == null) {
            if (this.drmSession == null || (!z && this.playClearSamplesWithoutKeys)) {
                return false;
            }
            int state = this.drmSession.getState();
            if (state != 1) {
                return state != 4;
            }
            throw ExoPlaybackException.createForRenderer(this.drmSession.getError(), getIndex());
        }
        return invokeZ.booleanValue;
    }

    public abstract SimpleDecoder<DecoderInputBuffer, ? extends SimpleOutputBuffer, ? extends AudioDecoderException> createDecoder(Format format, ExoMediaCrypto exoMediaCrypto) throws AudioDecoderException;

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.Renderer
    public MediaClock getMediaClock() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (MediaClock) invokeV.objValue;
    }

    public Format getOutputFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Format format = this.inputFormat;
            return Format.createAudioSampleFormat(null, MimeTypes.AUDIO_RAW, null, -1, -1, format.channelCount, format.sampleRate, 2, null, null, 0, null);
        }
        return (Format) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters getPlaybackParameters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.audioSink.getPlaybackParameters() : (PlaybackParameters) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, obj) == null) {
            if (i == 2) {
                this.audioSink.setVolume(((Float) obj).floatValue());
            } else if (i != 3) {
                super.handleMessage(i, obj);
            } else {
                this.audioSink.setAudioAttributes((AudioAttributes) obj);
            }
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.outputStreamEnded && this.audioSink.isEnded() : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.audioSink.hasPendingData() || !(this.inputFormat == null || this.waitingForKeys || (!isSourceReady() && this.outputBuffer == null)) : invokeV.booleanValue;
    }

    public void onAudioSessionId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
        }
    }

    public void onAudioTrackPositionDiscontinuity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public void onAudioTrackUnderrun(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 4, expect 1 */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.inputFormat = null;
            this.audioTrackNeedsConfigure = true;
            this.waitingForKeys = false;
            try {
                releaseDecoder();
                this.audioSink.release();
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

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            DecoderCounters decoderCounters = new DecoderCounters();
            this.decoderCounters = decoderCounters;
            this.eventDispatcher.enabled(decoderCounters);
            int i = getConfiguration().tunnelingAudioSessionId;
            if (i != 0) {
                this.audioSink.enableTunnelingV21(i);
            } else {
                this.audioSink.disableTunneling();
            }
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.audioSink.reset();
            this.currentPositionUs = j;
            this.allowPositionDiscontinuity = true;
            this.inputStreamEnded = false;
            this.outputStreamEnded = false;
            if (this.decoder != null) {
                flushDecoder();
            }
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.audioSink.play();
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.audioSink.pause();
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (this.outputStreamEnded) {
                try {
                    this.audioSink.playToEndOfStream();
                    return;
                } catch (AudioSink.WriteException e2) {
                    throw ExoPlaybackException.createForRenderer(e2, getIndex());
                }
            }
            if (this.inputFormat == null) {
                this.flagsOnlyBuffer.clear();
                int readSource = readSource(this.formatHolder, this.flagsOnlyBuffer, true);
                if (readSource != -5) {
                    if (readSource == -4) {
                        Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
                        this.inputStreamEnded = true;
                        processEndOfStream();
                        return;
                    }
                    return;
                }
                onInputFormatChanged(this.formatHolder.format);
            }
            maybeInitDecoder();
            if (this.decoder != null) {
                try {
                    TraceUtil.beginSection("drainAndFeed");
                    while (drainOutputBuffer()) {
                    }
                    while (feedInputBuffer()) {
                    }
                    TraceUtil.endSection();
                    this.decoderCounters.ensureUpdated();
                } catch (AudioDecoderException | AudioSink.ConfigurationException | AudioSink.InitializationException | AudioSink.WriteException e3) {
                    throw ExoPlaybackException.createForRenderer(e3, getIndex());
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, playbackParameters)) == null) ? this.audioSink.setPlaybackParameters(playbackParameters) : (PlaybackParameters) invokeL.objValue;
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public final int supportsFormat(Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, format)) == null) {
            int supportsFormatInternal = supportsFormatInternal(this.drmSessionManager, format);
            if (supportsFormatInternal <= 2) {
                return supportsFormatInternal;
            }
            return supportsFormatInternal | (Util.SDK_INT >= 21 ? 32 : 0) | 8;
        }
        return invokeL.intValue;
    }

    public abstract int supportsFormatInternal(DrmSessionManager<ExoMediaCrypto> drmSessionManager, Format format);

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleDecoderAudioRenderer(Handler handler, AudioRendererEventListener audioRendererEventListener, AudioProcessor... audioProcessorArr) {
        this(handler, audioRendererEventListener, null, null, false, audioProcessorArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler, audioRendererEventListener, audioProcessorArr};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Handler) objArr2[0], (AudioRendererEventListener) objArr2[1], (AudioCapabilities) objArr2[2], (DrmSessionManager) objArr2[3], ((Boolean) objArr2[4]).booleanValue(), (AudioProcessor[]) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleDecoderAudioRenderer(Handler handler, AudioRendererEventListener audioRendererEventListener, AudioCapabilities audioCapabilities) {
        this(handler, audioRendererEventListener, audioCapabilities, null, false, new AudioProcessor[0]);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler, audioRendererEventListener, audioCapabilities};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Handler) objArr2[0], (AudioRendererEventListener) objArr2[1], (AudioCapabilities) objArr2[2], (DrmSessionManager) objArr2[3], ((Boolean) objArr2[4]).booleanValue(), (AudioProcessor[]) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleDecoderAudioRenderer(Handler handler, AudioRendererEventListener audioRendererEventListener, AudioCapabilities audioCapabilities, DrmSessionManager<ExoMediaCrypto> drmSessionManager, boolean z, AudioProcessor... audioProcessorArr) {
        this(handler, audioRendererEventListener, drmSessionManager, z, new DefaultAudioSink(audioCapabilities, audioProcessorArr));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {handler, audioRendererEventListener, audioCapabilities, drmSessionManager, Boolean.valueOf(z), audioProcessorArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Handler) objArr2[0], (AudioRendererEventListener) objArr2[1], (DrmSessionManager) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), (AudioSink) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleDecoderAudioRenderer(Handler handler, AudioRendererEventListener audioRendererEventListener, DrmSessionManager<ExoMediaCrypto> drmSessionManager, boolean z, AudioSink audioSink) {
        super(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler, audioRendererEventListener, drmSessionManager, Boolean.valueOf(z), audioSink};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.drmSessionManager = drmSessionManager;
        this.playClearSamplesWithoutKeys = z;
        this.eventDispatcher = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        this.audioSink = audioSink;
        audioSink.setListener(new AudioSinkListener(this, null));
        this.formatHolder = new FormatHolder();
        this.flagsOnlyBuffer = DecoderInputBuffer.newFlagsOnlyInstance();
        this.decoderReinitializationState = 0;
        this.audioTrackNeedsConfigure = true;
    }
}
