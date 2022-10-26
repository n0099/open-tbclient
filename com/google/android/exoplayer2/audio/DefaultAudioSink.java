package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
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
    public static final int WRITE_NON_BLOCKING = 1;
    public static boolean enablePreV21AudioSessionWorkaround;
    public static boolean failOnSpuriousAudioTimestamp;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioAttributes audioAttributes;
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
    public AudioSink.Listener listener;
    public int nextPlayheadOffsetIndex;
    public ByteBuffer outputBuffer;
    public ByteBuffer[] outputBuffers;
    public int outputEncoding;
    public int outputPcmFrameSize;
    public boolean passthrough;
    public int pcmFrameSize;
    public PlaybackParameters playbackParameters;
    public final LinkedList playbackParametersCheckpoints;
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

    /* loaded from: classes7.dex */
    public class AudioTrackUtil {
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

        public boolean updateTimestamp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public AudioTrackUtil() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public long getPositionUs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return (getPlaybackHeadPosition() * 1000000) / this.sampleRate;
            }
            return invokeV.longValue;
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

        public void pause() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || this.stopTimestampUs != C.TIME_UNSET) {
                return;
            }
            this.audioTrack.pause();
        }

        public void handleEndOfStream(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
                this.stopPlaybackHeadPosition = getPlaybackHeadPosition();
                this.stopTimestampUs = SystemClock.elapsedRealtime() * 1000;
                this.endPlaybackHeadPosition = j;
                this.audioTrack.stop();
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

        public boolean needsReset(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
                if (this.forceResetWorkaroundTimeMs != C.TIME_UNSET && j > 0 && SystemClock.elapsedRealtime() - this.forceResetWorkaroundTimeMs >= 200) {
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
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
    }

    /* loaded from: classes7.dex */
    public class AudioTrackUtilV19 extends AudioTrackUtil {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.lastTimestampFramePosition;
            }
            return invokeV.longValue;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioTrackUtil
        public long getTimestampNanoTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.audioTimestamp.nanoTime;
            }
            return invokeV.longValue;
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
                    long j = this.audioTimestamp.framePosition;
                    if (this.lastRawTimestampFramePosition > j) {
                        this.rawTimestampFramePositionWrapCount++;
                    }
                    this.lastRawTimestampFramePosition = j;
                    this.lastTimestampFramePosition = j + (this.rawTimestampFramePositionWrapCount << 32);
                }
                return timestamp;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public final class InvalidAudioTrackTimestampException extends RuntimeException {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class PlaybackParametersCheckpoint {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long mediaTimeUs;
        public final PlaybackParameters playbackParameters;
        public final long positionUs;

        public PlaybackParametersCheckpoint(PlaybackParameters playbackParameters, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {playbackParameters, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.playbackParameters = playbackParameters;
            this.mediaTimeUs = j;
            this.positionUs = j2;
        }
    }

    public DefaultAudioSink(AudioCapabilities audioCapabilities, AudioProcessor[] audioProcessorArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {audioCapabilities, audioProcessorArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.playbackParametersCheckpoints = new LinkedList();
    }

    private long durationUsToFrames(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65542, this, j)) == null) {
            return (j * this.sampleRate) / 1000000;
        }
        return invokeJ.longValue;
    }

    private long framesToDurationUs(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65543, this, j)) == null) {
            return (j * 1000000) / this.sampleRate;
        }
        return invokeJ.longValue;
    }

    private AudioTrack initializeKeepSessionIdAudioTrack(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65551, this, i)) == null) {
            return new AudioTrack(3, 4000, 4, 2, 2, 0, i);
        }
        return (AudioTrack) invokeI.objValue;
    }

    private long inputFramesToDurationUs(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65552, this, j)) == null) {
            return (j * 1000000) / this.inputSampleRate;
        }
        return invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void enableTunnelingV21(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
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
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean isPassthroughSupported(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            AudioCapabilities audioCapabilities = this.audioCapabilities;
            if (audioCapabilities != null && audioCapabilities.supportsEncoding(getEncodingForMimeType(str))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioAttributes(AudioAttributes audioAttributes) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, audioAttributes) != null) || this.audioAttributes.equals(audioAttributes)) {
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i) == null) && this.audioSessionId != i) {
            this.audioSessionId = i;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setListener(AudioSink.Listener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, listener) == null) {
            this.listener = listener;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048595, this, f) == null) && this.volume != f) {
            this.volume = f;
            setVolumeInternal();
        }
    }

    private long applySpeedup(long j) {
        long j2;
        long j3;
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, this, j)) == null) {
            while (!this.playbackParametersCheckpoints.isEmpty() && j >= ((PlaybackParametersCheckpoint) this.playbackParametersCheckpoints.getFirst()).positionUs) {
                PlaybackParametersCheckpoint playbackParametersCheckpoint = (PlaybackParametersCheckpoint) this.playbackParametersCheckpoints.remove();
                this.playbackParameters = playbackParametersCheckpoint.playbackParameters;
                this.playbackParametersPositionUs = playbackParametersCheckpoint.positionUs;
                this.playbackParametersOffsetUs = playbackParametersCheckpoint.mediaTimeUs - this.startMediaTimeUs;
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
        return invokeJ.longValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int getEncodingForMimeType(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
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
        return invokeL.intValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long getCurrentPositionUs(boolean z) {
        InterceptResult invokeZ;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
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
        return invokeZ.longValue;
    }

    private AudioTrack createAudioTrackV21() {
        InterceptResult invokeV;
        android.media.AudioAttributes audioAttributesV21;
        int i;
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
            if (i2 != 0) {
                i = i2;
            } else {
                i = 0;
            }
            return new AudioTrack(audioAttributes, build, this.bufferSize, 1, i);
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
        int i;
        AudioProcessor[] audioProcessorArr;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
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
        } else {
            return invokeV.booleanValue;
        }
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
            for (int i = 0; i < size; i++) {
                AudioProcessor audioProcessor2 = this.audioProcessors[i];
                audioProcessor2.flush();
                this.outputBuffers[i] = audioProcessor2.getOutput();
            }
        }
    }

    public static int getFramesPerEncodedSample(int i, ByteBuffer byteBuffer) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65545, null, i, byteBuffer)) == null) {
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
        return invokeIL.intValue;
    }

    private long getSubmittedFrames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (this.passthrough) {
                return this.submittedEncodedFrames;
            }
            return this.submittedPcmBytes / this.pcmFrameSize;
        }
        return invokeV.longValue;
    }

    private long getWrittenFrames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (this.passthrough) {
                return this.writtenEncodedFrames;
            }
            return this.writtenPcmBytes / this.outputPcmFrameSize;
        }
        return invokeV.longValue;
    }

    private boolean hasCurrentPositionUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            if (isInitialized() && this.startMediaTimeState != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean isInitialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            if (this.audioTrack != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean needsPassthroughWorkarounds() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            if (Util.SDK_INT < 23 && ((i = this.outputEncoding) == 5 || i == 6)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean overrideHasPendingData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            if (needsPassthroughWorkarounds() && this.audioTrack.getPlayState() == 2 && this.audioTrack.getPlaybackHeadPosition() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void releaseKeepSessionIdAudioTrack() {
        AudioTrack audioTrack;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65558, this) != null) || (audioTrack = this.keepSessionIdAudioTrack) == null) {
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
    public PlaybackParameters getPlaybackParameters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.playbackParameters;
        }
        return (PlaybackParameters) invokeV.objValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (isInitialized() && (getWrittenFrames() > this.audioTrackUtil.getPlaybackHeadPosition() || overrideHasPendingData())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean isEnded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (isInitialized() && (!this.handledEndOfStream || hasPendingData())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
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
    }

    private void processBuffers(long j) throws AudioSink.WriteException {
        ByteBuffer byteBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65557, this, j) == null) {
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
                if (!this.playbackParametersCheckpoints.isEmpty()) {
                    playbackParameters4 = ((PlaybackParametersCheckpoint) this.playbackParametersCheckpoints.getLast()).playbackParameters;
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
        return (PlaybackParameters) invokeL.objValue;
    }

    public static void setVolumeInternalV21(AudioTrack audioTrack, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65562, null, audioTrack, f) == null) {
            audioTrack.setVolume(f);
        }
    }

    public static void setVolumeInternalV3(AudioTrack audioTrack, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65563, null, audioTrack, f) == null) {
            audioTrack.setStereoVolume(f, f);
        }
    }

    private boolean writeBuffer(ByteBuffer byteBuffer, long j) throws AudioSink.WriteException {
        InterceptResult invokeLJ;
        int writeNonBlockingV21;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65564, this, byteBuffer, j)) == null) {
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
        return invokeLJ.booleanValue;
    }

    public static int writeNonBlockingV21(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65565, null, audioTrack, byteBuffer, i)) == null) {
            return audioTrack.write(byteBuffer, i, 1);
        }
        return invokeLLI.intValue;
    }

    private int writeNonBlockingWithAvSyncV21(AudioTrack audioTrack, ByteBuffer byteBuffer, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65566, this, new Object[]{audioTrack, byteBuffer, Integer.valueOf(i), Long.valueOf(j)})) == null) {
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
    public void configure(String str, int i, int i2, int i3, int i4, int[] iArr, int i5, int i6) throws AudioSink.ConfigurationException {
        boolean z;
        int i7;
        long framesToDurationUs;
        AudioProcessor[] audioProcessorArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr, Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
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
                    i7 = PassFaceRecogManager.k;
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
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean handleBuffer(ByteBuffer byteBuffer, long j) throws AudioSink.InitializationException, AudioSink.WriteException {
        InterceptResult invokeLJ;
        boolean z;
        String str;
        String str2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, byteBuffer, j)) == null) {
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
                    LinkedList linkedList = this.playbackParametersCheckpoints;
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
        return invokeLJ.booleanValue;
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
                this.playbackParameters = ((PlaybackParametersCheckpoint) this.playbackParametersCheckpoints.getLast()).playbackParameters;
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
}
