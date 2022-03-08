package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
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
    public final ConditionVariable releasingConditionVariable;
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
        public static /* synthetic */ Interceptable $ic = null;
        public static final long FORCE_RESET_WORKAROUND_TIMEOUT_MS = 200;
        public transient /* synthetic */ FieldHolder $fh;
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

        public AudioTrackUtil() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public long getPlaybackHeadPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
            return invokeV.longValue;
        }

        public long getPositionUs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (getPlaybackHeadPosition() * 1000000) / this.sampleRate : invokeV.longValue;
        }

        public long getTimestampFramePosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeV.longValue;
        }

        public long getTimestampNanoTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeV.longValue;
        }

        public void handleEndOfStream(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
                this.stopPlaybackHeadPosition = getPlaybackHeadPosition();
                this.stopTimestampUs = SystemClock.elapsedRealtime() * 1000;
                this.endPlaybackHeadPosition = j2;
                this.audioTrack.stop();
            }
        }

        public boolean needsReset(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) ? this.forceResetWorkaroundTimeMs != C.TIME_UNSET && j2 > 0 && SystemClock.elapsedRealtime() - this.forceResetWorkaroundTimeMs >= 200 : invokeJ.booleanValue;
        }

        public void pause() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.stopTimestampUs == C.TIME_UNSET) {
                this.audioTrack.pause();
            }
        }

        public void reconfigure(AudioTrack audioTrack, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048583, this, audioTrack, z) == null) {
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

        public boolean updateTimestamp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    @TargetApi(19)
    /* loaded from: classes7.dex */
    public static class AudioTrackUtilV19 extends AudioTrackUtil {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AudioTimestamp audioTimestamp;
        public long lastRawTimestampFramePosition;
        public long lastTimestampFramePosition;
        public long rawTimestampFramePositionWrapCount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AudioTrackUtilV19() {
            super();
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.audioTimestamp = new AudioTimestamp();
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioTrackUtil
        public long getTimestampFramePosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.lastTimestampFramePosition : invokeV.longValue;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioTrackUtil
        public long getTimestampNanoTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.audioTimestamp.nanoTime : invokeV.longValue;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioTrackUtil
        public void reconfigure(AudioTrack audioTrack, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, audioTrack, z) == null) {
                super.reconfigure(audioTrack, z);
                this.rawTimestampFramePositionWrapCount = 0L;
                this.lastRawTimestampFramePosition = 0L;
                this.lastTimestampFramePosition = 0L;
            }
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioTrackUtil
        public boolean updateTimestamp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                boolean timestamp = this.audioTrack.getTimestamp(this.audioTimestamp);
                if (timestamp) {
                    long j2 = this.audioTimestamp.framePosition;
                    if (this.lastRawTimestampFramePosition > j2) {
                        this.rawTimestampFramePositionWrapCount++;
                    }
                    this.lastRawTimestampFramePosition = j2;
                    this.lastTimestampFramePosition = j2 + (this.rawTimestampFramePositionWrapCount << 32);
                }
                return timestamp;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidAudioTrackTimestampException(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class PlaybackParametersCheckpoint {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long mediaTimeUs;
        public final PlaybackParameters playbackParameters;
        public final long positionUs;

        public PlaybackParametersCheckpoint(PlaybackParameters playbackParameters, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {playbackParameters, Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.playbackParameters = playbackParameters;
            this.mediaTimeUs = j2;
            this.positionUs = j3;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(278210556, "Lcom/google/android/exoplayer2/audio/DefaultAudioSink;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(278210556, "Lcom/google/android/exoplayer2/audio/DefaultAudioSink;");
        }
    }

    public DefaultAudioSink(@Nullable AudioCapabilities audioCapabilities, AudioProcessor[] audioProcessorArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {audioCapabilities, audioProcessorArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.audioCapabilities = audioCapabilities;
        this.releasingConditionVariable = new ConditionVariable(true);
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

    private long applySpeedup(long j2) {
        long j3;
        long j4;
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, this, j2)) == null) {
            while (!this.playbackParametersCheckpoints.isEmpty() && j2 >= this.playbackParametersCheckpoints.getFirst().positionUs) {
                PlaybackParametersCheckpoint remove = this.playbackParametersCheckpoints.remove();
                this.playbackParameters = remove.playbackParameters;
                this.playbackParametersPositionUs = remove.positionUs;
                this.playbackParametersOffsetUs = remove.mediaTimeUs - this.startMediaTimeUs;
            }
            if (this.playbackParameters.speed == 1.0f) {
                return (j2 + this.playbackParametersOffsetUs) - this.playbackParametersPositionUs;
            }
            if (this.playbackParametersCheckpoints.isEmpty()) {
                j3 = this.playbackParametersOffsetUs;
                j4 = this.sonicAudioProcessor.scaleDurationForSpeedup(j2 - this.playbackParametersPositionUs);
            } else {
                j3 = this.playbackParametersOffsetUs;
                j4 = (long) (this.playbackParameters.speed * (j2 - this.playbackParametersPositionUs));
            }
            return j3 + j4;
        }
        return invokeJ.longValue;
    }

    @TargetApi(21)
    private AudioTrack createAudioTrackV21() {
        InterceptResult invokeV;
        android.media.AudioAttributes audioAttributesV21;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.tunneling) {
                audioAttributesV21 = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
            } else {
                audioAttributesV21 = this.audioAttributes.getAudioAttributesV21();
            }
            android.media.AudioAttributes audioAttributes = audioAttributesV21;
            AudioFormat build = new AudioFormat.Builder().setChannelMask(this.channelConfig).setEncoding(this.outputEncoding).setSampleRate(this.sampleRate).build();
            int i2 = this.audioSessionId;
            return new AudioTrack(audioAttributes, build, this.bufferSize, 1, i2 != 0 ? i2 : 0);
        }
        return (AudioTrack) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0036 -> B:11:0x0016). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean drainAudioProcessorsToEndOfStream() throws AudioSink.WriteException {
        InterceptResult invokeV;
        boolean z;
        int i2;
        AudioProcessor[] audioProcessorArr;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65541, this)) != null) {
            return invokeV.booleanValue;
        }
        if (this.drainingAudioProcessorIndex == -1) {
            this.drainingAudioProcessorIndex = this.passthrough ? this.audioProcessors.length : 0;
            z = true;
            i2 = this.drainingAudioProcessorIndex;
            audioProcessorArr = this.audioProcessors;
            if (i2 < audioProcessorArr.length) {
                AudioProcessor audioProcessor = audioProcessorArr[i2];
                if (z) {
                    audioProcessor.queueEndOfStream();
                }
                processBuffers(C.TIME_UNSET);
                if (!audioProcessor.isEnded()) {
                    return false;
                }
                this.drainingAudioProcessorIndex++;
                z = true;
                i2 = this.drainingAudioProcessorIndex;
                audioProcessorArr = this.audioProcessors;
                if (i2 < audioProcessorArr.length) {
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
            i2 = this.drainingAudioProcessorIndex;
            audioProcessorArr = this.audioProcessors;
            if (i2 < audioProcessorArr.length) {
            }
        }
    }

    private long durationUsToFrames(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65542, this, j2)) == null) ? (j2 * this.sampleRate) / 1000000 : invokeJ.longValue;
    }

    private long framesToDurationUs(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65543, this, j2)) == null) ? (j2 * 1000000) / this.sampleRate : invokeJ.longValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int getEncodingForMimeType(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            switch (str.hashCode()) {
                case -1095064472:
                    if (str.equals(MimeTypes.AUDIO_DTS)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 187078296:
                    if (str.equals(MimeTypes.AUDIO_AC3)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1504578661:
                    if (str.equals(MimeTypes.AUDIO_E_AC3)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1505942594:
                    if (str.equals(MimeTypes.AUDIO_DTS_HD)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        return c2 != 3 ? 0 : 8;
                    }
                    return 7;
                }
                return 6;
            }
            return 5;
        }
        return invokeL.intValue;
    }

    public static int getFramesPerEncodedSample(int i2, ByteBuffer byteBuffer) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65545, null, i2, byteBuffer)) == null) {
            if (i2 == 7 || i2 == 8) {
                return DtsUtil.parseDtsAudioSampleCount(byteBuffer);
            }
            if (i2 == 5) {
                return Ac3Util.getAc3SyncframeAudioSampleCount();
            }
            if (i2 == 6) {
                return Ac3Util.parseEAc3SyncframeAudioSampleCount(byteBuffer);
            }
            throw new IllegalStateException("Unexpected audio encoding: " + i2);
        }
        return invokeIL.intValue;
    }

    private long getSubmittedFrames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.passthrough ? this.submittedEncodedFrames : this.submittedPcmBytes / this.pcmFrameSize : invokeV.longValue;
    }

    private long getWrittenFrames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? this.passthrough ? this.writtenEncodedFrames : this.writtenPcmBytes / this.outputPcmFrameSize : invokeV.longValue;
    }

    private boolean hasCurrentPositionUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? isInitialized() && this.startMediaTimeState != 0 : invokeV.booleanValue;
    }

    private void initialize() throws AudioSink.InitializationException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
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
    }

    private AudioTrack initializeAudioTrack() throws AudioSink.InitializationException {
        InterceptResult invokeV;
        AudioTrack audioTrack;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
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
        return (AudioTrack) invokeV.objValue;
    }

    private AudioTrack initializeKeepSessionIdAudioTrack(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65551, this, i2)) == null) ? new AudioTrack(3, 4000, 4, 2, 2, 0, i2) : (AudioTrack) invokeI.objValue;
    }

    private long inputFramesToDurationUs(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65552, this, j2)) == null) ? (j2 * 1000000) / this.inputSampleRate : invokeJ.longValue;
    }

    private boolean isInitialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) ? this.audioTrack != null : invokeV.booleanValue;
    }

    private void maybeSampleSyncParams() {
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            long positionUs = this.audioTrackUtil.getPositionUs();
            if (positionUs == 0) {
                return;
            }
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - this.lastPlayheadSampleTimeUs >= 30000) {
                long[] jArr = this.playheadOffsets;
                int i2 = this.nextPlayheadOffsetIndex;
                jArr[i2] = positionUs - nanoTime;
                this.nextPlayheadOffsetIndex = (i2 + 1) % 10;
                int i3 = this.playheadOffsetCount;
                if (i3 < 10) {
                    this.playheadOffsetCount = i3 + 1;
                }
                this.lastPlayheadSampleTimeUs = nanoTime;
                this.smoothedPlayheadOffsetUs = 0L;
                int i4 = 0;
                while (true) {
                    int i5 = this.playheadOffsetCount;
                    if (i4 >= i5) {
                        break;
                    }
                    this.smoothedPlayheadOffsetUs += this.playheadOffsets[i4] / i5;
                    i4++;
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
                            this.audioTimestampSet = false;
                        } else {
                            throw new InvalidAudioTrackTimestampException(str);
                        }
                    } else if (Math.abs(framesToDurationUs(timestampFramePosition) - positionUs) > 5000000) {
                        String str2 = "Spurious audio timestamp (frame position mismatch): " + timestampFramePosition + StringUtil.ARRAY_ELEMENT_SEPARATOR + timestampNanoTime + StringUtil.ARRAY_ELEMENT_SEPARATOR + nanoTime + StringUtil.ARRAY_ELEMENT_SEPARATOR + positionUs + StringUtil.ARRAY_ELEMENT_SEPARATOR + getSubmittedFrames() + StringUtil.ARRAY_ELEMENT_SEPARATOR + getWrittenFrames();
                        if (!failOnSpuriousAudioTimestamp) {
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
                            String str3 = "Ignoring impossibly large audio latency: " + this.latencyUs;
                            this.latencyUs = 0L;
                        }
                    } catch (Exception unused) {
                        this.getLatencyMethod = null;
                    }
                }
                this.lastTimestampSampleTimeUs = nanoTime;
            }
        }
    }

    private boolean needsPassthroughWorkarounds() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) ? Util.SDK_INT < 23 && ((i2 = this.outputEncoding) == 5 || i2 == 6) : invokeV.booleanValue;
    }

    private boolean overrideHasPendingData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) ? needsPassthroughWorkarounds() && this.audioTrack.getPlayState() == 2 && this.audioTrack.getPlaybackHeadPosition() == 0 : invokeV.booleanValue;
    }

    private void processBuffers(long j2) throws AudioSink.WriteException {
        ByteBuffer byteBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65557, this, j2) == null) {
            int length = this.audioProcessors.length;
            int i2 = length;
            while (i2 >= 0) {
                if (i2 > 0) {
                    byteBuffer = this.outputBuffers[i2 - 1];
                } else {
                    byteBuffer = this.inputBuffer;
                    if (byteBuffer == null) {
                        byteBuffer = AudioProcessor.EMPTY_BUFFER;
                    }
                }
                if (i2 == length) {
                    writeBuffer(byteBuffer, j2);
                } else {
                    AudioProcessor audioProcessor = this.audioProcessors[i2];
                    audioProcessor.queueInput(byteBuffer);
                    ByteBuffer output = audioProcessor.getOutput();
                    this.outputBuffers[i2] = output;
                    if (output.hasRemaining()) {
                        i2++;
                    }
                }
                if (byteBuffer.hasRemaining()) {
                    return;
                }
                i2--;
            }
        }
    }

    private void releaseKeepSessionIdAudioTrack() {
        AudioTrack audioTrack;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65558, this) == null) || (audioTrack = this.keepSessionIdAudioTrack) == null) {
            return;
        }
        this.keepSessionIdAudioTrack = null;
        new Thread(this, audioTrack) { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DefaultAudioSink this$0;
            public final /* synthetic */ AudioTrack val$toRelease;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, audioTrack};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$toRelease = audioTrack;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.val$toRelease.release();
                }
            }
        }.start();
    }

    private void resetAudioProcessors() {
        AudioProcessor[] audioProcessorArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
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
            for (int i2 = 0; i2 < size; i2++) {
                AudioProcessor audioProcessor2 = this.audioProcessors[i2];
                audioProcessor2.flush();
                this.outputBuffers[i2] = audioProcessor2.getOutput();
            }
        }
    }

    private void resetSyncParams() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            this.smoothedPlayheadOffsetUs = 0L;
            this.playheadOffsetCount = 0;
            this.nextPlayheadOffsetIndex = 0;
            this.lastPlayheadSampleTimeUs = 0L;
            this.audioTimestampSet = false;
            this.lastTimestampSampleTimeUs = 0L;
        }
    }

    private void setVolumeInternal() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65561, this) == null) && isInitialized()) {
            if (Util.SDK_INT >= 21) {
                setVolumeInternalV21(this.audioTrack, this.volume);
            } else {
                setVolumeInternalV3(this.audioTrack, this.volume);
            }
        }
    }

    @TargetApi(21)
    public static void setVolumeInternalV21(AudioTrack audioTrack, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65562, null, audioTrack, f2) == null) {
            audioTrack.setVolume(f2);
        }
    }

    public static void setVolumeInternalV3(AudioTrack audioTrack, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65563, null, audioTrack, f2) == null) {
            audioTrack.setStereoVolume(f2, f2);
        }
    }

    private boolean writeBuffer(ByteBuffer byteBuffer, long j2) throws AudioSink.WriteException {
        InterceptResult invokeLJ;
        int writeNonBlockingV21;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65564, this, byteBuffer, j2)) == null) {
            if (byteBuffer.hasRemaining()) {
                ByteBuffer byteBuffer2 = this.outputBuffer;
                if (byteBuffer2 != null) {
                    Assertions.checkArgument(byteBuffer2 == byteBuffer);
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
                    Assertions.checkState(j2 != C.TIME_UNSET);
                    writeNonBlockingV21 = writeNonBlockingWithAvSyncV21(this.audioTrack, byteBuffer, remaining2, j2);
                } else {
                    writeNonBlockingV21 = writeNonBlockingV21(this.audioTrack, byteBuffer, remaining2);
                }
                this.lastFeedElapsedRealtimeMs = SystemClock.elapsedRealtime();
                if (writeNonBlockingV21 >= 0) {
                    if (!this.passthrough) {
                        this.writtenPcmBytes += writeNonBlockingV21;
                    }
                    if (writeNonBlockingV21 == remaining2) {
                        if (this.passthrough) {
                            this.writtenEncodedFrames += this.framesPerEncodedSample;
                        }
                        this.outputBuffer = null;
                        return true;
                    }
                    return false;
                }
                throw new AudioSink.WriteException(writeNonBlockingV21);
            }
            return true;
        }
        return invokeLJ.booleanValue;
    }

    @TargetApi(21)
    public static int writeNonBlockingV21(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65565, null, audioTrack, byteBuffer, i2)) == null) ? audioTrack.write(byteBuffer, i2, 1) : invokeLLI.intValue;
    }

    @TargetApi(21)
    private int writeNonBlockingWithAvSyncV21(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65566, this, new Object[]{audioTrack, byteBuffer, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            if (this.avSyncHeader == null) {
                ByteBuffer allocate = ByteBuffer.allocate(16);
                this.avSyncHeader = allocate;
                allocate.order(ByteOrder.BIG_ENDIAN);
                this.avSyncHeader.putInt(1431633921);
            }
            if (this.bytesUntilNextAvSync == 0) {
                this.avSyncHeader.putInt(4, i2);
                this.avSyncHeader.putLong(8, j2 * 1000);
                this.avSyncHeader.position(0);
                this.bytesUntilNextAvSync = i2;
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
            int writeNonBlockingV21 = writeNonBlockingV21(audioTrack, byteBuffer, i2);
            if (writeNonBlockingV21 < 0) {
                this.bytesUntilNextAvSync = 0;
                return writeNonBlockingV21;
            }
            this.bytesUntilNextAvSync -= writeNonBlockingV21;
            return writeNonBlockingV21;
        }
        return invokeCommon.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x014e  */
    @Override // com.google.android.exoplayer2.audio.AudioSink
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void configure(String str, int i2, int i3, int i4, int i5, @Nullable int[] iArr, int i6, int i7) throws AudioSink.ConfigurationException {
        boolean z;
        int i8;
        AudioProcessor[] audioProcessorArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr, Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            this.inputSampleRate = i3;
            boolean z2 = !MimeTypes.AUDIO_RAW.equals(str);
            if (!z2) {
                this.pcmFrameSize = Util.getPcmFrameSize(i4, i2);
                this.trimmingAudioProcessor.setTrimSampleCount(i6, i7);
                this.channelMappingAudioProcessor.setChannelMap(iArr);
                z = false;
                for (AudioProcessor audioProcessor : this.availableAudioProcessors) {
                    try {
                        z |= audioProcessor.configure(i3, i2, i4);
                        if (audioProcessor.isActive()) {
                            i2 = audioProcessor.getOutputChannelCount();
                            i3 = audioProcessor.getOutputSampleRateHz();
                            i4 = audioProcessor.getOutputEncoding();
                        }
                    } catch (AudioProcessor.UnhandledFormatException e2) {
                        throw new AudioSink.ConfigurationException(e2);
                    }
                }
                if (z) {
                    resetAudioProcessors();
                }
            } else {
                i4 = getEncodingForMimeType(str);
                z = false;
            }
            int i9 = 252;
            int i10 = 12;
            switch (i2) {
                case 1:
                    i8 = 4;
                    break;
                case 2:
                    i8 = 12;
                    break;
                case 3:
                    i8 = 28;
                    break;
                case 4:
                    i8 = 204;
                    break;
                case 5:
                    i8 = 220;
                    break;
                case 6:
                    i8 = 252;
                    break;
                case 7:
                    i8 = 1276;
                    break;
                case 8:
                    i8 = C.CHANNEL_OUT_7POINT1_SURROUND;
                    break;
                default:
                    throw new AudioSink.ConfigurationException("Unsupported channel count: " + i2);
            }
            if (Util.SDK_INT <= 23 && "foster".equals(Util.DEVICE) && "NVIDIA".equals(Util.MANUFACTURER)) {
                if (i2 != 3 && i2 != 5) {
                    if (i2 == 7) {
                        i9 = C.CHANNEL_OUT_7POINT1_SURROUND;
                    }
                }
                if (Util.SDK_INT <= 25 || !"fugu".equals(Util.DEVICE) || !z2 || i2 != 1) {
                    i10 = i9;
                }
                if (z && isInitialized() && this.encoding == i4 && this.sampleRate == i3 && this.channelConfig == i10) {
                    return;
                }
                reset();
                this.encoding = i4;
                this.passthrough = z2;
                this.sampleRate = i3;
                this.channelConfig = i10;
                if (!z2) {
                    i4 = 2;
                }
                this.outputEncoding = i4;
                this.outputPcmFrameSize = Util.getPcmFrameSize(2, i2);
                if (i5 == 0) {
                    this.bufferSize = i5;
                } else if (z2) {
                    int i11 = this.outputEncoding;
                    if (i11 != 5 && i11 != 6) {
                        this.bufferSize = 49152;
                    } else {
                        this.bufferSize = 20480;
                    }
                } else {
                    int minBufferSize = AudioTrack.getMinBufferSize(i3, i10, this.outputEncoding);
                    Assertions.checkState(minBufferSize != -2);
                    int i12 = minBufferSize * 4;
                    int durationUsToFrames = ((int) durationUsToFrames(250000L)) * this.outputPcmFrameSize;
                    int max = (int) Math.max(minBufferSize, durationUsToFrames(MAX_BUFFER_DURATION_US) * this.outputPcmFrameSize);
                    if (i12 < durationUsToFrames) {
                        i12 = durationUsToFrames;
                    } else if (i12 > max) {
                        i12 = max;
                    }
                    this.bufferSize = i12;
                }
                this.bufferSizeUs = !z2 ? C.TIME_UNSET : framesToDurationUs(this.bufferSize / this.outputPcmFrameSize);
                setPlaybackParameters(this.playbackParameters);
            }
            i9 = i8;
            if (Util.SDK_INT <= 25) {
            }
            i10 = i9;
            if (z) {
            }
            reset();
            this.encoding = i4;
            this.passthrough = z2;
            this.sampleRate = i3;
            this.channelConfig = i10;
            if (!z2) {
            }
            this.outputEncoding = i4;
            this.outputPcmFrameSize = Util.getPcmFrameSize(2, i2);
            if (i5 == 0) {
            }
            this.bufferSizeUs = !z2 ? C.TIME_UNSET : framesToDurationUs(this.bufferSize / this.outputPcmFrameSize);
            setPlaybackParameters(this.playbackParameters);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void disableTunneling() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.tunneling) {
            this.tunneling = false;
            this.audioSessionId = 0;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void enableTunnelingV21(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            Assertions.checkState(Util.SDK_INT >= 21);
            if (this.tunneling && this.audioSessionId == i2) {
                return;
            }
            this.tunneling = true;
            this.audioSessionId = i2;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long getCurrentPositionUs(boolean z) {
        InterceptResult invokeZ;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            if (hasCurrentPositionUs()) {
                if (this.audioTrack.getPlayState() == 3) {
                    maybeSampleSyncParams();
                }
                long nanoTime = System.nanoTime() / 1000;
                if (this.audioTimestampSet) {
                    j2 = framesToDurationUs(this.audioTrackUtil.getTimestampFramePosition() + durationUsToFrames(nanoTime - (this.audioTrackUtil.getTimestampNanoTime() / 1000)));
                } else {
                    if (this.playheadOffsetCount == 0) {
                        j2 = this.audioTrackUtil.getPositionUs();
                    } else {
                        j2 = nanoTime + this.smoothedPlayheadOffsetUs;
                    }
                    if (!z) {
                        j2 -= this.latencyUs;
                    }
                }
                return this.startMediaTimeUs + applySpeedup(Math.min(j2, framesToDurationUs(getWrittenFrames())));
            }
            return Long.MIN_VALUE;
        }
        return invokeZ.longValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public PlaybackParameters getPlaybackParameters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.playbackParameters : (PlaybackParameters) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean handleBuffer(ByteBuffer byteBuffer, long j2) throws AudioSink.InitializationException, AudioSink.WriteException {
        InterceptResult invokeLJ;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, byteBuffer, j2)) == null) {
            ByteBuffer byteBuffer2 = this.inputBuffer;
            Assertions.checkArgument(byteBuffer2 == null || byteBuffer == byteBuffer2);
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
            boolean z = this.hasData;
            boolean hasPendingData = hasPendingData();
            this.hasData = hasPendingData;
            if (z && !hasPendingData && this.audioTrack.getPlayState() != 1 && this.listener != null) {
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
                    this.playbackParametersCheckpoints.add(new PlaybackParametersCheckpoint(this.drainingPlaybackParameters, Math.max(0L, j2), framesToDurationUs(getWrittenFrames())));
                    this.drainingPlaybackParameters = null;
                    resetAudioProcessors();
                }
                if (this.startMediaTimeState == 0) {
                    this.startMediaTimeUs = Math.max(0L, j2);
                    this.startMediaTimeState = 1;
                } else {
                    long inputFramesToDurationUs = this.startMediaTimeUs + inputFramesToDurationUs(getSubmittedFrames());
                    if (this.startMediaTimeState != 1 || Math.abs(inputFramesToDurationUs - j2) <= 200000) {
                        i2 = 2;
                    } else {
                        String str = "Discontinuity detected [expected " + inputFramesToDurationUs + ", got " + j2 + PreferencesUtil.RIGHT_MOUNT;
                        i2 = 2;
                        this.startMediaTimeState = 2;
                    }
                    if (this.startMediaTimeState == i2) {
                        this.startMediaTimeUs += j2 - inputFramesToDurationUs;
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
            }
            if (this.passthrough) {
                writeBuffer(this.inputBuffer, j2);
            } else {
                processBuffers(j2);
            }
            if (!this.inputBuffer.hasRemaining()) {
                this.inputBuffer = null;
                return true;
            } else if (this.audioTrackUtil.needsReset(getWrittenFrames())) {
                reset();
                return true;
            } else {
                return false;
            }
        }
        return invokeLJ.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void handleDiscontinuity() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.startMediaTimeState == 1) {
            this.startMediaTimeState = 2;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean hasPendingData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? isInitialized() && (getWrittenFrames() > this.audioTrackUtil.getPlaybackHeadPosition() || overrideHasPendingData()) : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean isEnded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? !isInitialized() || (this.handledEndOfStream && !hasPendingData()) : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean isPassthroughSupported(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            AudioCapabilities audioCapabilities = this.audioCapabilities;
            return audioCapabilities != null && audioCapabilities.supportsEncoding(getEncodingForMimeType(str));
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.playing = false;
            if (isInitialized()) {
                resetSyncParams();
                this.audioTrackUtil.pause();
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.playing = true;
            if (isInitialized()) {
                this.resumeSystemTimeUs = System.nanoTime() / 1000;
                this.audioTrack.play();
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void playToEndOfStream() throws AudioSink.WriteException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && !this.handledEndOfStream && isInitialized() && drainAudioProcessorsToEndOfStream()) {
            this.audioTrackUtil.handleEndOfStream(getWrittenFrames());
            this.bytesUntilNextAvSync = 0;
            this.handledEndOfStream = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            reset();
            releaseKeepSessionIdAudioTrack();
            for (AudioProcessor audioProcessor : this.availableAudioProcessors) {
                audioProcessor.reset();
            }
            this.audioSessionId = 0;
            this.playing = false;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && isInitialized()) {
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
            int i2 = 0;
            while (true) {
                AudioProcessor[] audioProcessorArr = this.audioProcessors;
                if (i2 >= audioProcessorArr.length) {
                    break;
                }
                AudioProcessor audioProcessor = audioProcessorArr[i2];
                audioProcessor.flush();
                this.outputBuffers[i2] = audioProcessor.getOutput();
                i2++;
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
            AudioTrack audioTrack = this.audioTrack;
            this.audioTrack = null;
            this.audioTrackUtil.reconfigure(null, false);
            this.releasingConditionVariable.close();
            new Thread(this, audioTrack) { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DefaultAudioSink this$0;
                public final /* synthetic */ AudioTrack val$toRelease;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, audioTrack};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$toRelease = audioTrack;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.val$toRelease.flush();
                            this.val$toRelease.release();
                        } finally {
                            this.this$0.releasingConditionVariable.open();
                        }
                    }
                }
            }.start();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioAttributes(AudioAttributes audioAttributes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, audioAttributes) == null) || this.audioAttributes.equals(audioAttributes)) {
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
    public void setAudioSessionId(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || this.audioSessionId == i2) {
            return;
        }
        this.audioSessionId = i2;
        reset();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setListener(AudioSink.Listener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, listener) == null) {
            this.listener = listener;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, playbackParameters)) == null) {
            if (this.passthrough) {
                PlaybackParameters playbackParameters2 = PlaybackParameters.DEFAULT;
                this.playbackParameters = playbackParameters2;
                return playbackParameters2;
            }
            PlaybackParameters playbackParameters3 = new PlaybackParameters(this.sonicAudioProcessor.setSpeed(playbackParameters.speed), this.sonicAudioProcessor.setPitch(playbackParameters.pitch));
            PlaybackParameters playbackParameters4 = this.drainingPlaybackParameters;
            if (playbackParameters4 == null) {
                playbackParameters4 = !this.playbackParametersCheckpoints.isEmpty() ? this.playbackParametersCheckpoints.getLast().playbackParameters : this.playbackParameters;
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
        return (PlaybackParameters) invokeL.objValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048595, this, f2) == null) || this.volume == f2) {
            return;
        }
        this.volume = f2;
        setVolumeInternal();
    }
}
