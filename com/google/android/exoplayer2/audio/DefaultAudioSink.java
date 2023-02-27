package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public final class DefaultAudioSink implements AudioSink {
    public static final int BUFFER_MULTIPLICATION_FACTOR = 4;
    public static final int ERROR_BAD_VALUE = -2;
    public static final long MAX_AUDIO_TIMESTAMP_OFFSET_US = 5000000;
    public static final long MAX_BUFFER_DURATION_US = 750000;
    public static final long MAX_LATENCY_US = 5000000;
    public static final int MAX_PLAYHEAD_OFFSET_COUNT = 10;
    public static final long MIN_BUFFER_DURATION_US = 250000;
    public static final int MIN_PLAYHEAD_OFFSET_SAMPLE_INTERVAL_US = 30000;
    public static final int MIN_TIMESTAMP_SAMPLE_INTERVAL_US = 500000;
    public static final int MODE_STATIC = 0;
    public static final int MODE_STREAM = 1;
    public static final long PASSTHROUGH_BUFFER_DURATION_US = 250000;
    public static final int PLAYSTATE_PAUSED = 2;
    public static final int PLAYSTATE_PLAYING = 3;
    public static final int PLAYSTATE_STOPPED = 1;
    public static final int START_IN_SYNC = 1;
    public static final int START_NEED_SYNC = 2;
    public static final int START_NOT_SET = 0;
    public static final int STATE_INITIALIZED = 1;
    public static final String TAG = "AudioTrack";
    @SuppressLint({"InlinedApi"})
    public static final int WRITE_NON_BLOCKING = 1;
    public static boolean enablePreV21AudioSessionWorkaround;
    public static boolean failOnSpuriousAudioTimestamp;
    public AudioAttributes audioAttributes;
    @Nullable
    public final AudioCapabilities audioCapabilities;
    public AudioProcessor[] audioProcessors;
    public int audioSessionId;
    public boolean audioTimestampSet;
    public AudioTrack audioTrack;
    public final AudioTrackUtil audioTrackUtil;
    public ByteBuffer avSyncHeader;
    public final AudioProcessor[] availableAudioProcessors;
    public int bufferSize;
    public long bufferSizeUs;
    public int bytesUntilNextAvSync;
    public int channelConfig;
    public final ChannelMappingAudioProcessor channelMappingAudioProcessor;
    public int drainingAudioProcessorIndex;
    public PlaybackParameters drainingPlaybackParameters;
    public int encoding;
    public int framesPerEncodedSample;
    public Method getLatencyMethod;
    public boolean handledEndOfStream;
    public boolean hasData;
    public ByteBuffer inputBuffer;
    public int inputSampleRate;
    public AudioTrack keepSessionIdAudioTrack;
    public long lastFeedElapsedRealtimeMs;
    public long lastPlayheadSampleTimeUs;
    public long lastTimestampSampleTimeUs;
    public long latencyUs;
    @Nullable
    public AudioSink.Listener listener;
    public int nextPlayheadOffsetIndex;
    public ByteBuffer outputBuffer;
    public ByteBuffer[] outputBuffers;
    public int outputEncoding;
    public int outputPcmFrameSize;
    public boolean passthrough;
    public int pcmFrameSize;
    public PlaybackParameters playbackParameters;
    public final LinkedList<PlaybackParametersCheckpoint> playbackParametersCheckpoints;
    public long playbackParametersOffsetUs;
    public long playbackParametersPositionUs;
    public int playheadOffsetCount;
    public final long[] playheadOffsets;
    public boolean playing;
    public byte[] preV21OutputBuffer;
    public int preV21OutputBufferOffset;
    public final ConditionVariable releasingConditionVariable = new ConditionVariable(true);
    public long resumeSystemTimeUs;
    public int sampleRate;
    public long smoothedPlayheadOffsetUs;
    public final SonicAudioProcessor sonicAudioProcessor;
    public int startMediaTimeState;
    public long startMediaTimeUs;
    public long submittedEncodedFrames;
    public long submittedPcmBytes;
    public final TrimmingAudioProcessor trimmingAudioProcessor;
    public boolean tunneling;
    public float volume;
    public long writtenEncodedFrames;
    public long writtenPcmBytes;

    /* loaded from: classes7.dex */
    public static class AudioTrackUtil {
        public static final long FORCE_RESET_WORKAROUND_TIMEOUT_MS = 200;
        public AudioTrack audioTrack;
        public long endPlaybackHeadPosition;
        public long forceResetWorkaroundTimeMs;
        public long lastRawPlaybackHeadPosition;
        public boolean needsPassthroughWorkaround;
        public long passthroughWorkaroundPauseOffset;
        public long rawPlaybackHeadWrapCount;
        public int sampleRate;
        public long stopPlaybackHeadPosition;
        public long stopTimestampUs;

        public boolean updateTimestamp() {
            return false;
        }

        public AudioTrackUtil() {
        }

        public long getPositionUs() {
            return (getPlaybackHeadPosition() * 1000000) / this.sampleRate;
        }

        public long getTimestampFramePosition() {
            throw new UnsupportedOperationException();
        }

        public long getTimestampNanoTime() {
            throw new UnsupportedOperationException();
        }

        public void pause() {
            if (this.stopTimestampUs != C.TIME_UNSET) {
                return;
            }
            this.audioTrack.pause();
        }

        public void handleEndOfStream(long j) {
            this.stopPlaybackHeadPosition = getPlaybackHeadPosition();
            this.stopTimestampUs = SystemClock.elapsedRealtime() * 1000;
            this.endPlaybackHeadPosition = j;
            this.audioTrack.stop();
        }

        public boolean needsReset(long j) {
            if (this.forceResetWorkaroundTimeMs != C.TIME_UNSET && j > 0 && SystemClock.elapsedRealtime() - this.forceResetWorkaroundTimeMs >= 200) {
                return true;
            }
            return false;
        }

        public long getPlaybackHeadPosition() {
            if (this.stopTimestampUs != C.TIME_UNSET) {
                return Math.min(this.endPlaybackHeadPosition, this.stopPlaybackHeadPosition + ((((SystemClock.elapsedRealtime() * 1000) - this.stopTimestampUs) * this.sampleRate) / 1000000));
            }
            int playState = this.audioTrack.getPlayState();
            if (playState == 1) {
                return 0L;
            }
            long playbackHeadPosition = 4294967295L & this.audioTrack.getPlaybackHeadPosition();
            if (this.needsPassthroughWorkaround) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.passthroughWorkaroundPauseOffset = this.lastRawPlaybackHeadPosition;
                }
                playbackHeadPosition += this.passthroughWorkaroundPauseOffset;
            }
            if (Util.SDK_INT <= 26) {
                if (playbackHeadPosition == 0 && this.lastRawPlaybackHeadPosition > 0 && playState == 3) {
                    if (this.forceResetWorkaroundTimeMs == C.TIME_UNSET) {
                        this.forceResetWorkaroundTimeMs = SystemClock.elapsedRealtime();
                    }
                    return this.lastRawPlaybackHeadPosition;
                }
                this.forceResetWorkaroundTimeMs = C.TIME_UNSET;
            }
            if (this.lastRawPlaybackHeadPosition > playbackHeadPosition) {
                this.rawPlaybackHeadWrapCount++;
            }
            this.lastRawPlaybackHeadPosition = playbackHeadPosition;
            return playbackHeadPosition + (this.rawPlaybackHeadWrapCount << 32);
        }

        public void reconfigure(AudioTrack audioTrack, boolean z) {
            this.audioTrack = audioTrack;
            this.needsPassthroughWorkaround = z;
            this.stopTimestampUs = C.TIME_UNSET;
            this.forceResetWorkaroundTimeMs = C.TIME_UNSET;
            this.lastRawPlaybackHeadPosition = 0L;
            this.rawPlaybackHeadWrapCount = 0L;
            this.passthroughWorkaroundPauseOffset = 0L;
            if (audioTrack != null) {
                this.sampleRate = audioTrack.getSampleRate();
            }
        }
    }

    @TargetApi(19)
    /* loaded from: classes7.dex */
    public static class AudioTrackUtilV19 extends AudioTrackUtil {
        public final AudioTimestamp audioTimestamp;
        public long lastRawTimestampFramePosition;
        public long lastTimestampFramePosition;
        public long rawTimestampFramePositionWrapCount;

        public AudioTrackUtilV19() {
            super();
            this.audioTimestamp = new AudioTimestamp();
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioTrackUtil
        public long getTimestampFramePosition() {
            return this.lastTimestampFramePosition;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioTrackUtil
        public long getTimestampNanoTime() {
            return this.audioTimestamp.nanoTime;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioTrackUtil
        public boolean updateTimestamp() {
            boolean timestamp = this.audioTrack.getTimestamp(this.audioTimestamp);
            if (timestamp) {
                long j = this.audioTimestamp.framePosition;
                if (this.lastRawTimestampFramePosition > j) {
                    this.rawTimestampFramePositionWrapCount++;
                }
                this.lastRawTimestampFramePosition = j;
                this.lastTimestampFramePosition = j + (this.rawTimestampFramePositionWrapCount << 32);
            }
            return timestamp;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioTrackUtil
        public void reconfigure(AudioTrack audioTrack, boolean z) {
            super.reconfigure(audioTrack, z);
            this.rawTimestampFramePositionWrapCount = 0L;
            this.lastRawTimestampFramePosition = 0L;
            this.lastTimestampFramePosition = 0L;
        }
    }

    /* loaded from: classes7.dex */
    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        public InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    /* loaded from: classes7.dex */
    public static final class PlaybackParametersCheckpoint {
        public final long mediaTimeUs;
        public final PlaybackParameters playbackParameters;
        public final long positionUs;

        public PlaybackParametersCheckpoint(PlaybackParameters playbackParameters, long j, long j2) {
            this.playbackParameters = playbackParameters;
            this.mediaTimeUs = j;
            this.positionUs = j2;
        }
    }

    public DefaultAudioSink(@Nullable AudioCapabilities audioCapabilities, AudioProcessor[] audioProcessorArr) {
        this.audioCapabilities = audioCapabilities;
        if (Util.SDK_INT >= 18) {
            try {
                this.getLatencyMethod = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (Util.SDK_INT >= 19) {
            this.audioTrackUtil = new AudioTrackUtilV19();
        } else {
            this.audioTrackUtil = new AudioTrackUtil();
        }
        this.channelMappingAudioProcessor = new ChannelMappingAudioProcessor();
        this.trimmingAudioProcessor = new TrimmingAudioProcessor();
        this.sonicAudioProcessor = new SonicAudioProcessor();
        AudioProcessor[] audioProcessorArr2 = new AudioProcessor[audioProcessorArr.length + 4];
        this.availableAudioProcessors = audioProcessorArr2;
        audioProcessorArr2[0] = new ResamplingAudioProcessor();
        AudioProcessor[] audioProcessorArr3 = this.availableAudioProcessors;
        audioProcessorArr3[1] = this.channelMappingAudioProcessor;
        audioProcessorArr3[2] = this.trimmingAudioProcessor;
        System.arraycopy(audioProcessorArr, 0, audioProcessorArr3, 3, audioProcessorArr.length);
        this.availableAudioProcessors[audioProcessorArr.length + 3] = this.sonicAudioProcessor;
        this.playheadOffsets = new long[10];
        this.volume = 1.0f;
        this.startMediaTimeState = 0;
        this.audioAttributes = AudioAttributes.DEFAULT;
        this.audioSessionId = 0;
        this.playbackParameters = PlaybackParameters.DEFAULT;
        this.drainingAudioProcessorIndex = -1;
        this.audioProcessors = new AudioProcessor[0];
        this.outputBuffers = new ByteBuffer[0];
        this.playbackParametersCheckpoints = new LinkedList<>();
    }

    private boolean writeBuffer(ByteBuffer byteBuffer, long j) throws AudioSink.WriteException {
        int writeNonBlockingV21;
        boolean z;
        boolean z2;
        if (!byteBuffer.hasRemaining()) {
            return true;
        }
        ByteBuffer byteBuffer2 = this.outputBuffer;
        if (byteBuffer2 != null) {
            if (byteBuffer2 == byteBuffer) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.checkArgument(z2);
        } else {
            this.outputBuffer = byteBuffer;
            if (Util.SDK_INT < 21) {
                int remaining = byteBuffer.remaining();
                byte[] bArr = this.preV21OutputBuffer;
                if (bArr == null || bArr.length < remaining) {
                    this.preV21OutputBuffer = new byte[remaining];
                }
                int position = byteBuffer.position();
                byteBuffer.get(this.preV21OutputBuffer, 0, remaining);
                byteBuffer.position(position);
                this.preV21OutputBufferOffset = 0;
            }
        }
        int remaining2 = byteBuffer.remaining();
        if (Util.SDK_INT < 21) {
            int playbackHeadPosition = this.bufferSize - ((int) (this.writtenPcmBytes - (this.audioTrackUtil.getPlaybackHeadPosition() * this.outputPcmFrameSize)));
            if (playbackHeadPosition > 0) {
                writeNonBlockingV21 = this.audioTrack.write(this.preV21OutputBuffer, this.preV21OutputBufferOffset, Math.min(remaining2, playbackHeadPosition));
                if (writeNonBlockingV21 > 0) {
                    this.preV21OutputBufferOffset += writeNonBlockingV21;
                    byteBuffer.position(byteBuffer.position() + writeNonBlockingV21);
                }
            } else {
                writeNonBlockingV21 = 0;
            }
        } else if (this.tunneling) {
            if (j != C.TIME_UNSET) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkState(z);
            writeNonBlockingV21 = writeNonBlockingWithAvSyncV21(this.audioTrack, byteBuffer, remaining2, j);
        } else {
            writeNonBlockingV21 = writeNonBlockingV21(this.audioTrack, byteBuffer, remaining2);
        }
        this.lastFeedElapsedRealtimeMs = SystemClock.elapsedRealtime();
        if (writeNonBlockingV21 >= 0) {
            if (!this.passthrough) {
                this.writtenPcmBytes += writeNonBlockingV21;
            }
            if (writeNonBlockingV21 != remaining2) {
                return false;
            }
            if (this.passthrough) {
                this.writtenEncodedFrames += this.framesPerEncodedSample;
            }
            this.outputBuffer = null;
            return true;
        }
        throw new AudioSink.WriteException(writeNonBlockingV21);
    }

    private long durationUsToFrames(long j) {
        return (j * this.sampleRate) / 1000000;
    }

    private long framesToDurationUs(long j) {
        return (j * 1000000) / this.sampleRate;
    }

    private AudioTrack initializeKeepSessionIdAudioTrack(int i) {
        return new AudioTrack(3, 4000, 4, 2, 2, 0, i);
    }

    private long inputFramesToDurationUs(long j) {
        return (j * 1000000) / this.inputSampleRate;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void enableTunnelingV21(int i) {
        boolean z;
        if (Util.SDK_INT >= 21) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        if (!this.tunneling || this.audioSessionId != i) {
            this.tunneling = true;
            this.audioSessionId = i;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean isPassthroughSupported(String str) {
        AudioCapabilities audioCapabilities = this.audioCapabilities;
        if (audioCapabilities != null && audioCapabilities.supportsEncoding(getEncodingForMimeType(str))) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioAttributes(AudioAttributes audioAttributes) {
        if (this.audioAttributes.equals(audioAttributes)) {
            return;
        }
        this.audioAttributes = audioAttributes;
        if (this.tunneling) {
            return;
        }
        reset();
        this.audioSessionId = 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioSessionId(int i) {
        if (this.audioSessionId != i) {
            this.audioSessionId = i;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setListener(AudioSink.Listener listener) {
        this.listener = listener;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f) {
        if (this.volume != f) {
            this.volume = f;
            setVolumeInternal();
        }
    }

    private long applySpeedup(long j) {
        long j2;
        long j3;
        while (!this.playbackParametersCheckpoints.isEmpty() && j >= this.playbackParametersCheckpoints.getFirst().positionUs) {
            PlaybackParametersCheckpoint remove = this.playbackParametersCheckpoints.remove();
            this.playbackParameters = remove.playbackParameters;
            this.playbackParametersPositionUs = remove.positionUs;
            this.playbackParametersOffsetUs = remove.mediaTimeUs - this.startMediaTimeUs;
        }
        if (this.playbackParameters.speed == 1.0f) {
            return (j + this.playbackParametersOffsetUs) - this.playbackParametersPositionUs;
        }
        if (this.playbackParametersCheckpoints.isEmpty()) {
            j2 = this.playbackParametersOffsetUs;
            j3 = this.sonicAudioProcessor.scaleDurationForSpeedup(j - this.playbackParametersPositionUs);
        } else {
            j2 = this.playbackParametersOffsetUs;
            j3 = (long) (this.playbackParameters.speed * (j - this.playbackParametersPositionUs));
        }
        return j2 + j3;
    }

    @TargetApi(21)
    private AudioTrack createAudioTrackV21() {
        android.media.AudioAttributes audioAttributesV21;
        int i;
        if (this.tunneling) {
            audioAttributesV21 = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        } else {
            audioAttributesV21 = this.audioAttributes.getAudioAttributesV21();
        }
        android.media.AudioAttributes audioAttributes = audioAttributesV21;
        AudioFormat build = new AudioFormat.Builder().setChannelMask(this.channelConfig).setEncoding(this.outputEncoding).setSampleRate(this.sampleRate).build();
        int i2 = this.audioSessionId;
        if (i2 != 0) {
            i = i2;
        } else {
            i = 0;
        }
        return new AudioTrack(audioAttributes, build, this.bufferSize, 1, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0032 -> B:9:0x0012). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean drainAudioProcessorsToEndOfStream() throws AudioSink.WriteException {
        boolean z;
        int i;
        AudioProcessor[] audioProcessorArr;
        int i2;
        if (this.drainingAudioProcessorIndex == -1) {
            if (this.passthrough) {
                i2 = this.audioProcessors.length;
            } else {
                i2 = 0;
            }
            this.drainingAudioProcessorIndex = i2;
            z = true;
            i = this.drainingAudioProcessorIndex;
            audioProcessorArr = this.audioProcessors;
            if (i < audioProcessorArr.length) {
                AudioProcessor audioProcessor = audioProcessorArr[i];
                if (z) {
                    audioProcessor.queueEndOfStream();
                }
                processBuffers(C.TIME_UNSET);
                if (!audioProcessor.isEnded()) {
                    return false;
                }
                this.drainingAudioProcessorIndex++;
                z = true;
                i = this.drainingAudioProcessorIndex;
                audioProcessorArr = this.audioProcessors;
                if (i < audioProcessorArr.length) {
                    ByteBuffer byteBuffer = this.outputBuffer;
                    if (byteBuffer != null) {
                        writeBuffer(byteBuffer, C.TIME_UNSET);
                        if (this.outputBuffer != null) {
                            return false;
                        }
                    }
                    this.drainingAudioProcessorIndex = -1;
                    return true;
                }
            }
        } else {
            z = false;
            i = this.drainingAudioProcessorIndex;
            audioProcessorArr = this.audioProcessors;
            if (i < audioProcessorArr.length) {
            }
        }
    }

    private void initialize() throws AudioSink.InitializationException {
        this.releasingConditionVariable.block();
        AudioTrack initializeAudioTrack = initializeAudioTrack();
        this.audioTrack = initializeAudioTrack;
        int audioSessionId = initializeAudioTrack.getAudioSessionId();
        if (enablePreV21AudioSessionWorkaround && Util.SDK_INT < 21) {
            AudioTrack audioTrack = this.keepSessionIdAudioTrack;
            if (audioTrack != null && audioSessionId != audioTrack.getAudioSessionId()) {
                releaseKeepSessionIdAudioTrack();
            }
            if (this.keepSessionIdAudioTrack == null) {
                this.keepSessionIdAudioTrack = initializeKeepSessionIdAudioTrack(audioSessionId);
            }
        }
        if (this.audioSessionId != audioSessionId) {
            this.audioSessionId = audioSessionId;
            AudioSink.Listener listener = this.listener;
            if (listener != null) {
                listener.onAudioSessionId(audioSessionId);
            }
        }
        this.audioTrackUtil.reconfigure(this.audioTrack, needsPassthroughWorkarounds());
        setVolumeInternal();
        this.hasData = false;
    }

    private AudioTrack initializeAudioTrack() throws AudioSink.InitializationException {
        AudioTrack audioTrack;
        if (Util.SDK_INT >= 21) {
            audioTrack = createAudioTrackV21();
        } else {
            int streamTypeForAudioUsage = Util.getStreamTypeForAudioUsage(this.audioAttributes.usage);
            if (this.audioSessionId == 0) {
                audioTrack = new AudioTrack(streamTypeForAudioUsage, this.sampleRate, this.channelConfig, this.outputEncoding, this.bufferSize, 1);
            } else {
                audioTrack = new AudioTrack(streamTypeForAudioUsage, this.sampleRate, this.channelConfig, this.outputEncoding, this.bufferSize, 1, this.audioSessionId);
            }
        }
        int state = audioTrack.getState();
        if (state == 1) {
            return audioTrack;
        }
        try {
            audioTrack.release();
        } catch (Exception unused) {
        }
        throw new AudioSink.InitializationException(state, this.sampleRate, this.channelConfig, this.bufferSize);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int getEncodingForMimeType(String str) {
        char c;
        switch (str.hashCode()) {
            case -1095064472:
                if (str.equals(MimeTypes.AUDIO_DTS)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 187078296:
                if (str.equals(MimeTypes.AUDIO_AC3)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1504578661:
                if (str.equals(MimeTypes.AUDIO_E_AC3)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1505942594:
                if (str.equals(MimeTypes.AUDIO_DTS_HD)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        return 0;
                    }
                    return 8;
                }
                return 7;
            }
            return 6;
        }
        return 5;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long getCurrentPositionUs(boolean z) {
        long j;
        if (!hasCurrentPositionUs()) {
            return Long.MIN_VALUE;
        }
        if (this.audioTrack.getPlayState() == 3) {
            maybeSampleSyncParams();
        }
        long nanoTime = System.nanoTime() / 1000;
        if (this.audioTimestampSet) {
            j = framesToDurationUs(this.audioTrackUtil.getTimestampFramePosition() + durationUsToFrames(nanoTime - (this.audioTrackUtil.getTimestampNanoTime() / 1000)));
        } else {
            if (this.playheadOffsetCount == 0) {
                j = this.audioTrackUtil.getPositionUs();
            } else {
                j = nanoTime + this.smoothedPlayheadOffsetUs;
            }
            if (!z) {
                j -= this.latencyUs;
            }
        }
        return this.startMediaTimeUs + applySpeedup(Math.min(j, framesToDurationUs(getWrittenFrames())));
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters) {
        if (this.passthrough) {
            PlaybackParameters playbackParameters2 = PlaybackParameters.DEFAULT;
            this.playbackParameters = playbackParameters2;
            return playbackParameters2;
        }
        PlaybackParameters playbackParameters3 = new PlaybackParameters(this.sonicAudioProcessor.setSpeed(playbackParameters.speed), this.sonicAudioProcessor.setPitch(playbackParameters.pitch));
        PlaybackParameters playbackParameters4 = this.drainingPlaybackParameters;
        if (playbackParameters4 == null) {
            if (!this.playbackParametersCheckpoints.isEmpty()) {
                playbackParameters4 = this.playbackParametersCheckpoints.getLast().playbackParameters;
            } else {
                playbackParameters4 = this.playbackParameters;
            }
        }
        if (!playbackParameters3.equals(playbackParameters4)) {
            if (isInitialized()) {
                this.drainingPlaybackParameters = playbackParameters3;
            } else {
                this.playbackParameters = playbackParameters3;
            }
        }
        return this.playbackParameters;
    }

    public static int getFramesPerEncodedSample(int i, ByteBuffer byteBuffer) {
        if (i != 7 && i != 8) {
            if (i == 5) {
                return Ac3Util.getAc3SyncframeAudioSampleCount();
            }
            if (i == 6) {
                return Ac3Util.parseEAc3SyncframeAudioSampleCount(byteBuffer);
            }
            throw new IllegalStateException("Unexpected audio encoding: " + i);
        }
        return DtsUtil.parseDtsAudioSampleCount(byteBuffer);
    }

    private long getSubmittedFrames() {
        if (this.passthrough) {
            return this.submittedEncodedFrames;
        }
        return this.submittedPcmBytes / this.pcmFrameSize;
    }

    private long getWrittenFrames() {
        if (this.passthrough) {
            return this.writtenEncodedFrames;
        }
        return this.writtenPcmBytes / this.outputPcmFrameSize;
    }

    private boolean hasCurrentPositionUs() {
        if (isInitialized() && this.startMediaTimeState != 0) {
            return true;
        }
        return false;
    }

    private boolean isInitialized() {
        if (this.audioTrack != null) {
            return true;
        }
        return false;
    }

    private boolean needsPassthroughWorkarounds() {
        int i;
        if (Util.SDK_INT < 23 && ((i = this.outputEncoding) == 5 || i == 6)) {
            return true;
        }
        return false;
    }

    private boolean overrideHasPendingData() {
        if (needsPassthroughWorkarounds() && this.audioTrack.getPlayState() == 2 && this.audioTrack.getPlaybackHeadPosition() == 0) {
            return true;
        }
        return false;
    }

    private void releaseKeepSessionIdAudioTrack() {
        final AudioTrack audioTrack = this.keepSessionIdAudioTrack;
        if (audioTrack == null) {
            return;
        }
        this.keepSessionIdAudioTrack = null;
        new Thread() { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                audioTrack.release();
            }
        }.start();
    }

    private void resetSyncParams() {
        this.smoothedPlayheadOffsetUs = 0L;
        this.playheadOffsetCount = 0;
        this.nextPlayheadOffsetIndex = 0;
        this.lastPlayheadSampleTimeUs = 0L;
        this.audioTimestampSet = false;
        this.lastTimestampSampleTimeUs = 0L;
    }

    private void setVolumeInternal() {
        if (isInitialized()) {
            if (Util.SDK_INT >= 21) {
                setVolumeInternalV21(this.audioTrack, this.volume);
            } else {
                setVolumeInternalV3(this.audioTrack, this.volume);
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void disableTunneling() {
        if (this.tunneling) {
            this.tunneling = false;
            this.audioSessionId = 0;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public PlaybackParameters getPlaybackParameters() {
        return this.playbackParameters;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void handleDiscontinuity() {
        if (this.startMediaTimeState == 1) {
            this.startMediaTimeState = 2;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean hasPendingData() {
        if (isInitialized() && (getWrittenFrames() > this.audioTrackUtil.getPlaybackHeadPosition() || overrideHasPendingData())) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean isEnded() {
        if (isInitialized() && (!this.handledEndOfStream || hasPendingData())) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        this.playing = false;
        if (isInitialized()) {
            resetSyncParams();
            this.audioTrackUtil.pause();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        this.playing = true;
        if (isInitialized()) {
            this.resumeSystemTimeUs = System.nanoTime() / 1000;
            this.audioTrack.play();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void playToEndOfStream() throws AudioSink.WriteException {
        if (!this.handledEndOfStream && isInitialized() && drainAudioProcessorsToEndOfStream()) {
            this.audioTrackUtil.handleEndOfStream(getWrittenFrames());
            this.bytesUntilNextAvSync = 0;
            this.handledEndOfStream = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void release() {
        reset();
        releaseKeepSessionIdAudioTrack();
        for (AudioProcessor audioProcessor : this.availableAudioProcessors) {
            audioProcessor.reset();
        }
        this.audioSessionId = 0;
        this.playing = false;
    }

    private void maybeSampleSyncParams() {
        Method method;
        long positionUs = this.audioTrackUtil.getPositionUs();
        if (positionUs == 0) {
            return;
        }
        long nanoTime = System.nanoTime() / 1000;
        if (nanoTime - this.lastPlayheadSampleTimeUs >= 30000) {
            long[] jArr = this.playheadOffsets;
            int i = this.nextPlayheadOffsetIndex;
            jArr[i] = positionUs - nanoTime;
            this.nextPlayheadOffsetIndex = (i + 1) % 10;
            int i2 = this.playheadOffsetCount;
            if (i2 < 10) {
                this.playheadOffsetCount = i2 + 1;
            }
            this.lastPlayheadSampleTimeUs = nanoTime;
            this.smoothedPlayheadOffsetUs = 0L;
            int i3 = 0;
            while (true) {
                int i4 = this.playheadOffsetCount;
                if (i3 >= i4) {
                    break;
                }
                this.smoothedPlayheadOffsetUs += this.playheadOffsets[i3] / i4;
                i3++;
            }
        }
        if (!needsPassthroughWorkarounds() && nanoTime - this.lastTimestampSampleTimeUs >= 500000) {
            boolean updateTimestamp = this.audioTrackUtil.updateTimestamp();
            this.audioTimestampSet = updateTimestamp;
            if (updateTimestamp) {
                long timestampNanoTime = this.audioTrackUtil.getTimestampNanoTime() / 1000;
                long timestampFramePosition = this.audioTrackUtil.getTimestampFramePosition();
                if (timestampNanoTime < this.resumeSystemTimeUs) {
                    this.audioTimestampSet = false;
                } else if (Math.abs(timestampNanoTime - nanoTime) > 5000000) {
                    String str = "Spurious audio timestamp (system clock mismatch): " + timestampFramePosition + StringUtil.ARRAY_ELEMENT_SEPARATOR + timestampNanoTime + StringUtil.ARRAY_ELEMENT_SEPARATOR + nanoTime + StringUtil.ARRAY_ELEMENT_SEPARATOR + positionUs + StringUtil.ARRAY_ELEMENT_SEPARATOR + getSubmittedFrames() + StringUtil.ARRAY_ELEMENT_SEPARATOR + getWrittenFrames();
                    if (!failOnSpuriousAudioTimestamp) {
                        Log.w(TAG, str);
                        this.audioTimestampSet = false;
                    } else {
                        throw new InvalidAudioTrackTimestampException(str);
                    }
                } else if (Math.abs(framesToDurationUs(timestampFramePosition) - positionUs) > 5000000) {
                    String str2 = "Spurious audio timestamp (frame position mismatch): " + timestampFramePosition + StringUtil.ARRAY_ELEMENT_SEPARATOR + timestampNanoTime + StringUtil.ARRAY_ELEMENT_SEPARATOR + nanoTime + StringUtil.ARRAY_ELEMENT_SEPARATOR + positionUs + StringUtil.ARRAY_ELEMENT_SEPARATOR + getSubmittedFrames() + StringUtil.ARRAY_ELEMENT_SEPARATOR + getWrittenFrames();
                    if (!failOnSpuriousAudioTimestamp) {
                        Log.w(TAG, str2);
                        this.audioTimestampSet = false;
                    } else {
                        throw new InvalidAudioTrackTimestampException(str2);
                    }
                }
            }
            if (this.getLatencyMethod != null && !this.passthrough) {
                try {
                    long intValue = (((Integer) method.invoke(this.audioTrack, null)).intValue() * 1000) - this.bufferSizeUs;
                    this.latencyUs = intValue;
                    long max = Math.max(intValue, 0L);
                    this.latencyUs = max;
                    if (max > 5000000) {
                        Log.w(TAG, "Ignoring impossibly large audio latency: " + this.latencyUs);
                        this.latencyUs = 0L;
                    }
                } catch (Exception unused) {
                    this.getLatencyMethod = null;
                }
            }
            this.lastTimestampSampleTimeUs = nanoTime;
        }
    }

    private void processBuffers(long j) throws AudioSink.WriteException {
        ByteBuffer byteBuffer;
        int length = this.audioProcessors.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.outputBuffers[i - 1];
            } else {
                byteBuffer = this.inputBuffer;
                if (byteBuffer == null) {
                    byteBuffer = AudioProcessor.EMPTY_BUFFER;
                }
            }
            if (i == length) {
                writeBuffer(byteBuffer, j);
            } else {
                AudioProcessor audioProcessor = this.audioProcessors[i];
                audioProcessor.queueInput(byteBuffer);
                ByteBuffer output = audioProcessor.getOutput();
                this.outputBuffers[i] = output;
                if (output.hasRemaining()) {
                    i++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            }
            i--;
        }
    }

    private void resetAudioProcessors() {
        AudioProcessor[] audioProcessorArr;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : this.availableAudioProcessors) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.audioProcessors = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.outputBuffers = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            AudioProcessor audioProcessor2 = this.audioProcessors[i];
            audioProcessor2.flush();
            this.outputBuffers[i] = audioProcessor2.getOutput();
        }
    }

    @TargetApi(21)
    public static void setVolumeInternalV21(AudioTrack audioTrack, float f) {
        audioTrack.setVolume(f);
    }

    public static void setVolumeInternalV3(AudioTrack audioTrack, float f) {
        audioTrack.setStereoVolume(f, f);
    }

    @TargetApi(21)
    public static int writeNonBlockingV21(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 1);
    }

    @TargetApi(21)
    private int writeNonBlockingWithAvSyncV21(AudioTrack audioTrack, ByteBuffer byteBuffer, int i, long j) {
        if (this.avSyncHeader == null) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            this.avSyncHeader = allocate;
            allocate.order(ByteOrder.BIG_ENDIAN);
            this.avSyncHeader.putInt(1431633921);
        }
        if (this.bytesUntilNextAvSync == 0) {
            this.avSyncHeader.putInt(4, i);
            this.avSyncHeader.putLong(8, j * 1000);
            this.avSyncHeader.position(0);
            this.bytesUntilNextAvSync = i;
        }
        int remaining = this.avSyncHeader.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.avSyncHeader, remaining, 1);
            if (write < 0) {
                this.bytesUntilNextAvSync = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int writeNonBlockingV21 = writeNonBlockingV21(audioTrack, byteBuffer, i);
        if (writeNonBlockingV21 < 0) {
            this.bytesUntilNextAvSync = 0;
            return writeNonBlockingV21;
        }
        this.bytesUntilNextAvSync -= writeNonBlockingV21;
        return writeNonBlockingV21;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x014a  */
    @Override // com.google.android.exoplayer2.audio.AudioSink
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void configure(String str, int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5, int i6) throws AudioSink.ConfigurationException {
        boolean z;
        int i7;
        long framesToDurationUs;
        AudioProcessor[] audioProcessorArr;
        this.inputSampleRate = i2;
        boolean z2 = true;
        boolean z3 = !MimeTypes.AUDIO_RAW.equals(str);
        if (!z3) {
            this.pcmFrameSize = Util.getPcmFrameSize(i3, i);
            this.trimmingAudioProcessor.setTrimSampleCount(i5, i6);
            this.channelMappingAudioProcessor.setChannelMap(iArr);
            z = false;
            for (AudioProcessor audioProcessor : this.availableAudioProcessors) {
                try {
                    z |= audioProcessor.configure(i2, i, i3);
                    if (audioProcessor.isActive()) {
                        i = audioProcessor.getOutputChannelCount();
                        i2 = audioProcessor.getOutputSampleRateHz();
                        i3 = audioProcessor.getOutputEncoding();
                    }
                } catch (AudioProcessor.UnhandledFormatException e) {
                    throw new AudioSink.ConfigurationException(e);
                }
            }
            if (z) {
                resetAudioProcessors();
            }
        } else {
            i3 = getEncodingForMimeType(str);
            z = false;
        }
        int i8 = GDiffPatcher.COPY_INT_UBYTE;
        int i9 = 12;
        switch (i) {
            case 1:
                i7 = 4;
                break;
            case 2:
                i7 = 12;
                break;
            case 3:
                i7 = 28;
                break;
            case 4:
                i7 = 204;
                break;
            case 5:
                i7 = PassFaceRecogManager.j;
                break;
            case 6:
                i7 = GDiffPatcher.COPY_INT_UBYTE;
                break;
            case 7:
                i7 = 1276;
                break;
            case 8:
                i7 = C.CHANNEL_OUT_7POINT1_SURROUND;
                break;
            default:
                throw new AudioSink.ConfigurationException("Unsupported channel count: " + i);
        }
        if (Util.SDK_INT <= 23 && "foster".equals(Util.DEVICE) && "NVIDIA".equals(Util.MANUFACTURER)) {
            if (i != 3 && i != 5) {
                if (i == 7) {
                    i8 = C.CHANNEL_OUT_7POINT1_SURROUND;
                }
            }
            if (Util.SDK_INT <= 25 || !"fugu".equals(Util.DEVICE) || !z3 || i != 1) {
                i9 = i8;
            }
            if (z && isInitialized() && this.encoding == i3 && this.sampleRate == i2 && this.channelConfig == i9) {
                return;
            }
            reset();
            this.encoding = i3;
            this.passthrough = z3;
            this.sampleRate = i2;
            this.channelConfig = i9;
            if (!z3) {
                i3 = 2;
            }
            this.outputEncoding = i3;
            this.outputPcmFrameSize = Util.getPcmFrameSize(2, i);
            if (i4 == 0) {
                this.bufferSize = i4;
            } else if (z3) {
                int i10 = this.outputEncoding;
                if (i10 != 5 && i10 != 6) {
                    this.bufferSize = 49152;
                } else {
                    this.bufferSize = 20480;
                }
            } else {
                int minBufferSize = AudioTrack.getMinBufferSize(i2, i9, this.outputEncoding);
                if (minBufferSize == -2) {
                    z2 = false;
                }
                Assertions.checkState(z2);
                int i11 = minBufferSize * 4;
                int durationUsToFrames = ((int) durationUsToFrames(250000L)) * this.outputPcmFrameSize;
                int max = (int) Math.max(minBufferSize, durationUsToFrames(MAX_BUFFER_DURATION_US) * this.outputPcmFrameSize);
                if (i11 < durationUsToFrames) {
                    i11 = durationUsToFrames;
                } else if (i11 > max) {
                    i11 = max;
                }
                this.bufferSize = i11;
            }
            if (!z3) {
                framesToDurationUs = C.TIME_UNSET;
            } else {
                framesToDurationUs = framesToDurationUs(this.bufferSize / this.outputPcmFrameSize);
            }
            this.bufferSizeUs = framesToDurationUs;
            setPlaybackParameters(this.playbackParameters);
        }
        i8 = i7;
        if (Util.SDK_INT <= 25) {
        }
        i9 = i8;
        if (z) {
        }
        reset();
        this.encoding = i3;
        this.passthrough = z3;
        this.sampleRate = i2;
        this.channelConfig = i9;
        if (!z3) {
        }
        this.outputEncoding = i3;
        this.outputPcmFrameSize = Util.getPcmFrameSize(2, i);
        if (i4 == 0) {
        }
        if (!z3) {
        }
        this.bufferSizeUs = framesToDurationUs;
        setPlaybackParameters(this.playbackParameters);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean handleBuffer(ByteBuffer byteBuffer, long j) throws AudioSink.InitializationException, AudioSink.WriteException {
        boolean z;
        String str;
        String str2;
        int i;
        ByteBuffer byteBuffer2 = this.inputBuffer;
        if (byteBuffer2 != null && byteBuffer != byteBuffer2) {
            z = false;
        } else {
            z = true;
        }
        Assertions.checkArgument(z);
        if (!isInitialized()) {
            initialize();
            if (this.playing) {
                play();
            }
        }
        if (needsPassthroughWorkarounds()) {
            if (this.audioTrack.getPlayState() == 2) {
                this.hasData = false;
                return false;
            } else if (this.audioTrack.getPlayState() == 1 && this.audioTrackUtil.getPlaybackHeadPosition() != 0) {
                return false;
            }
        }
        boolean z2 = this.hasData;
        boolean hasPendingData = hasPendingData();
        this.hasData = hasPendingData;
        if (z2 && !hasPendingData && this.audioTrack.getPlayState() != 1 && this.listener != null) {
            this.listener.onUnderrun(this.bufferSize, C.usToMs(this.bufferSizeUs), SystemClock.elapsedRealtime() - this.lastFeedElapsedRealtimeMs);
        }
        if (this.inputBuffer == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.passthrough && this.framesPerEncodedSample == 0) {
                this.framesPerEncodedSample = getFramesPerEncodedSample(this.outputEncoding, byteBuffer);
            }
            if (this.drainingPlaybackParameters != null) {
                if (!drainAudioProcessorsToEndOfStream()) {
                    return false;
                }
                LinkedList<PlaybackParametersCheckpoint> linkedList = this.playbackParametersCheckpoints;
                PlaybackParameters playbackParameters = this.drainingPlaybackParameters;
                long max = Math.max(0L, j);
                str2 = TAG;
                linkedList.add(new PlaybackParametersCheckpoint(playbackParameters, max, framesToDurationUs(getWrittenFrames())));
                this.drainingPlaybackParameters = null;
                resetAudioProcessors();
            } else {
                str2 = TAG;
            }
            if (this.startMediaTimeState == 0) {
                this.startMediaTimeUs = Math.max(0L, j);
                this.startMediaTimeState = 1;
                str = str2;
            } else {
                long inputFramesToDurationUs = this.startMediaTimeUs + inputFramesToDurationUs(getSubmittedFrames());
                if (this.startMediaTimeState == 1 && Math.abs(inputFramesToDurationUs - j) > 200000) {
                    str = str2;
                    Log.e(str, "Discontinuity detected [expected " + inputFramesToDurationUs + ", got " + j + PreferencesUtil.RIGHT_MOUNT);
                    i = 2;
                    this.startMediaTimeState = 2;
                } else {
                    str = str2;
                    i = 2;
                }
                if (this.startMediaTimeState == i) {
                    this.startMediaTimeUs += j - inputFramesToDurationUs;
                    this.startMediaTimeState = 1;
                    AudioSink.Listener listener = this.listener;
                    if (listener != null) {
                        listener.onPositionDiscontinuity();
                    }
                }
            }
            if (this.passthrough) {
                this.submittedEncodedFrames += this.framesPerEncodedSample;
            } else {
                this.submittedPcmBytes += byteBuffer.remaining();
            }
            this.inputBuffer = byteBuffer;
        } else {
            str = TAG;
        }
        if (this.passthrough) {
            writeBuffer(this.inputBuffer, j);
        } else {
            processBuffers(j);
        }
        if (!this.inputBuffer.hasRemaining()) {
            this.inputBuffer = null;
            return true;
        } else if (this.audioTrackUtil.needsReset(getWrittenFrames())) {
            Log.w(str, "Resetting stalled audio track");
            reset();
            return true;
        } else {
            return false;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        if (isInitialized()) {
            this.submittedPcmBytes = 0L;
            this.submittedEncodedFrames = 0L;
            this.writtenPcmBytes = 0L;
            this.writtenEncodedFrames = 0L;
            this.framesPerEncodedSample = 0;
            PlaybackParameters playbackParameters = this.drainingPlaybackParameters;
            if (playbackParameters != null) {
                this.playbackParameters = playbackParameters;
                this.drainingPlaybackParameters = null;
            } else if (!this.playbackParametersCheckpoints.isEmpty()) {
                this.playbackParameters = this.playbackParametersCheckpoints.getLast().playbackParameters;
            }
            this.playbackParametersCheckpoints.clear();
            this.playbackParametersOffsetUs = 0L;
            this.playbackParametersPositionUs = 0L;
            this.inputBuffer = null;
            this.outputBuffer = null;
            int i = 0;
            while (true) {
                AudioProcessor[] audioProcessorArr = this.audioProcessors;
                if (i >= audioProcessorArr.length) {
                    break;
                }
                AudioProcessor audioProcessor = audioProcessorArr[i];
                audioProcessor.flush();
                this.outputBuffers[i] = audioProcessor.getOutput();
                i++;
            }
            this.handledEndOfStream = false;
            this.drainingAudioProcessorIndex = -1;
            this.avSyncHeader = null;
            this.bytesUntilNextAvSync = 0;
            this.startMediaTimeState = 0;
            this.latencyUs = 0L;
            resetSyncParams();
            if (this.audioTrack.getPlayState() == 3) {
                this.audioTrack.pause();
            }
            final AudioTrack audioTrack = this.audioTrack;
            this.audioTrack = null;
            this.audioTrackUtil.reconfigure(null, false);
            this.releasingConditionVariable.close();
            new Thread() { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        DefaultAudioSink.this.releasingConditionVariable.open();
                    }
                }
            }.start();
        }
    }
}
