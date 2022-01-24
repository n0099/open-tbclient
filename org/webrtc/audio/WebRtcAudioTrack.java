package org.webrtc.audio;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.rtc.logreport.SLIReportInterface;
import com.baidu.rtc.logreport.StuckDataCalculator;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.webrtc.CalledByNative;
import org.webrtc.Logging;
import org.webrtc.ThreadUtils;
import org.webrtc.audio.JavaAudioDeviceModule;
/* loaded from: classes5.dex */
public class WebRtcAudioTrack {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long AUDIO_TRACK_THREAD_JOIN_TIMEOUT_MS = 2000;
    public static final int BITS_PER_SAMPLE = 16;
    public static final int BUFFERS_PER_SECOND = 100;
    public static final int CALLBACK_BUFFER_SIZE_MS = 10;
    public static final int DEFAULT_AUDIO_CONTENT_TYPE = 1;
    public static final int DEFAULT_USAGE;
    public static final String TAG = "WebRtcAudioTrackExternal";
    public static int audioContentType;
    public transient /* synthetic */ FieldHolder $fh;
    public int audioFormat;
    public final AudioManager audioManager;
    public volatile JavaAudioDeviceModule.RemoteSamplesReadyCallback audioSamplesReadyCallback;
    public AudioTrackThread audioThread;
    public AudioTrack audioTrack;
    public ByteBuffer byteBuffer;
    public int channelConfig;
    public final Context context;
    public byte[] emptyBytes;
    public final JavaAudioDeviceModule.AudioTrackErrorCallback errorCallback;
    public boolean isEnableSLIReport;
    public long nativeAudioTrack;
    public int sampleRateInHz;
    public volatile boolean speakerMute;
    public StuckDataCalculator stuckDataCalculator;
    public final ThreadUtils.ThreadChecker threadChecker;
    public final VolumeLogger volumeLogger;

    /* loaded from: classes5.dex */
    public class AudioTrackThread extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean keepAlive;
        public final /* synthetic */ WebRtcAudioTrack this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AudioTrackThread(WebRtcAudioTrack webRtcAudioTrack, String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webRtcAudioTrack, str};
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
            this.this$0 = webRtcAudioTrack;
            this.keepAlive = true;
        }

        @TargetApi(21)
        private int writeOnLollipop(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, this, audioTrack, byteBuffer, i2)) == null) ? audioTrack.write(byteBuffer, i2, 0) : invokeLLI.intValue;
        }

        private int writePreLollipop(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, this, audioTrack, byteBuffer, i2)) == null) ? audioTrack.write(byteBuffer.array(), byteBuffer.arrayOffset(), i2) : invokeLLI.intValue;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(-19);
                Logging.d(WebRtcAudioTrack.TAG, "AudioTrackThread" + WebRtcAudioUtils.getThreadInfo());
                WebRtcAudioTrack.assertTrue(this.this$0.audioTrack.getPlayState() == 3);
                int capacity = this.this$0.byteBuffer.capacity();
                while (this.keepAlive) {
                    WebRtcAudioTrack.nativeGetPlayoutData(this.this$0.nativeAudioTrack, capacity);
                    WebRtcAudioTrack.assertTrue(capacity <= this.this$0.byteBuffer.remaining());
                    if (this.this$0.speakerMute) {
                        this.this$0.byteBuffer.clear();
                        this.this$0.byteBuffer.put(this.this$0.emptyBytes);
                        this.this$0.byteBuffer.position(0);
                    }
                    if (this.this$0.isEnableSLIReport) {
                        this.this$0.stuckDataCalculator.calculateStuck();
                    }
                    if (this.this$0.audioSamplesReadyCallback != null) {
                        byte[] copyOfRange = Arrays.copyOfRange(this.this$0.byteBuffer.array(), this.this$0.byteBuffer.arrayOffset(), this.this$0.byteBuffer.capacity() + this.this$0.byteBuffer.arrayOffset());
                        if (this.this$0.audioSamplesReadyCallback != null) {
                            this.this$0.audioSamplesReadyCallback.onWebRtcAudioRemoteSamplesReady(new JavaAudioDeviceModule.AudioSamples(this.this$0.audioFormat, this.this$0.channelConfig, this.this$0.sampleRateInHz, copyOfRange));
                        }
                    }
                    int writeOnLollipop = WebRtcAudioUtils.runningOnLollipopOrHigher() ? writeOnLollipop(this.this$0.audioTrack, this.this$0.byteBuffer, capacity) : writePreLollipop(this.this$0.audioTrack, this.this$0.byteBuffer, capacity);
                    if (writeOnLollipop != capacity) {
                        Logging.e(WebRtcAudioTrack.TAG, "AudioTrack.write played invalid number of bytes: " + writeOnLollipop);
                        if (writeOnLollipop < 0) {
                            this.keepAlive = false;
                            WebRtcAudioTrack webRtcAudioTrack = this.this$0;
                            webRtcAudioTrack.reportWebRtcAudioTrackError("AudioTrack.write failed: " + writeOnLollipop);
                        }
                    }
                    this.this$0.byteBuffer.rewind();
                }
                if (this.this$0.audioTrack != null) {
                    Logging.d(WebRtcAudioTrack.TAG, "Calling AudioTrack.stop...");
                    try {
                        this.this$0.audioTrack.stop();
                        Logging.d(WebRtcAudioTrack.TAG, "AudioTrack.stop is done.");
                    } catch (IllegalStateException e2) {
                        Logging.e(WebRtcAudioTrack.TAG, "AudioTrack.stop failed: " + e2.getMessage());
                    }
                }
            }
        }

        public void stopThread() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                Logging.d(WebRtcAudioTrack.TAG, "stopThread");
                this.keepAlive = false;
                this.this$0.stuckDataCalculator.reset();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1105465003, "Lorg/webrtc/audio/WebRtcAudioTrack;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1105465003, "Lorg/webrtc/audio/WebRtcAudioTrack;");
                return;
            }
        }
        DEFAULT_USAGE = getDefaultUsageAttribute();
        audioContentType = 1;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @CalledByNative
    public WebRtcAudioTrack(Context context, AudioManager audioManager) {
        this(context, audioManager, 1, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, audioManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AudioManager) objArr2[1], ((Integer) objArr2[2]).intValue(), (JavaAudioDeviceModule.RemoteSamplesReadyCallback) objArr2[3], (JavaAudioDeviceModule.AudioTrackErrorCallback) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void assertTrue(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65553, null, z) == null) && !z) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    private int channelCountToConfiguration(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65554, this, i2)) == null) ? i2 == 1 ? 4 : 12 : invokeI.intValue;
    }

    @TargetApi(21)
    public static AudioTrack createAudioTrackOnLollipopOrHigher(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65555, null, i2, i3, i4)) == null) {
            Logging.d(TAG, "createAudioTrackOnLollipopOrHigher");
            int nativeOutputSampleRate = AudioTrack.getNativeOutputSampleRate(0);
            Logging.d(TAG, "nativeOutputSampleRate: " + nativeOutputSampleRate);
            if (i2 != nativeOutputSampleRate) {
                Logging.w(TAG, "Unable to use fast mode since requested sample rate is not native");
            }
            String str = Build.MODEL;
            if (audioContentType != 2 && !str.contains("NV6001") && !str.contains("NV6101") && !str.contains("XDH-0F-A1") && !str.contains("NV5001")) {
                return new AudioTrack(new AudioAttributes.Builder().setUsage(DEFAULT_USAGE).setContentType(1).build(), new AudioFormat.Builder().setEncoding(2).setSampleRate(i2).setChannelMask(i3).build(), i4, 1, 0);
            }
            return new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(2).build(), new AudioFormat.Builder().setEncoding(2).setSampleRate(i2).setChannelMask(i3).build(), i4, 1, 0);
        }
        return (AudioTrack) invokeIII.objValue;
    }

    public static AudioTrack createAudioTrackOnLowerThanLollipop(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65556, null, i2, i3, i4)) == null) ? new AudioTrack(0, i2, i3, 2, i4, 1) : (AudioTrack) invokeIII.objValue;
    }

    public static int getDefaultUsageAttribute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            if (WebRtcAudioUtils.runningOnLollipopOrHigher()) {
                return getDefaultUsageAttributeOnLollipopOrHigher();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @TargetApi(21)
    public static int getDefaultUsageAttributeOnLollipopOrHigher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @CalledByNative
    private int getStreamMaxVolume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            this.threadChecker.checkIsOnValidThread();
            Logging.d(TAG, "getStreamMaxVolume");
            return this.audioManager.getStreamMaxVolume(0);
        }
        return invokeV.intValue;
    }

    @CalledByNative
    private int getStreamVolume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) {
            this.threadChecker.checkIsOnValidThread();
            Logging.d(TAG, "getStreamVolume");
            return this.audioManager.getStreamVolume(0);
        }
        return invokeV.intValue;
    }

    @CalledByNative
    private boolean initPlayout(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65561, this, i2, i3)) == null) {
            this.threadChecker.checkIsOnValidThread();
            Logging.d(TAG, "initPlayout(sampleRate=" + i2 + ", channels=" + i3 + SmallTailInfo.EMOTION_SUFFIX);
            this.byteBuffer = ByteBuffer.allocateDirect(i3 * 2 * (i2 / 100));
            StringBuilder sb = new StringBuilder();
            sb.append("byteBuffer.capacity: ");
            sb.append(this.byteBuffer.capacity());
            Logging.d(TAG, sb.toString());
            this.emptyBytes = new byte[this.byteBuffer.capacity()];
            nativeCacheDirectBufferAddress(this.nativeAudioTrack, this.byteBuffer);
            int channelCountToConfiguration = channelCountToConfiguration(i3);
            int minBufferSize = AudioTrack.getMinBufferSize(i2, channelCountToConfiguration, 2);
            this.sampleRateInHz = i2;
            this.channelConfig = channelCountToConfiguration;
            this.audioFormat = 2;
            Logging.d(TAG, "AudioTrack.getMinBufferSize: " + minBufferSize);
            if (minBufferSize < this.byteBuffer.capacity()) {
                reportWebRtcAudioTrackInitError("AudioTrack.getMinBufferSize returns an invalid value.");
                return false;
            } else if (this.audioTrack != null) {
                reportWebRtcAudioTrackInitError("Conflict with existing AudioTrack.");
                return false;
            } else {
                try {
                    if (WebRtcAudioUtils.runningOnLollipopOrHigher()) {
                        this.audioTrack = createAudioTrackOnLollipopOrHigher(i2, channelCountToConfiguration, minBufferSize);
                    } else {
                        this.audioTrack = createAudioTrackOnLowerThanLollipop(i2, channelCountToConfiguration, minBufferSize);
                    }
                    AudioTrack audioTrack = this.audioTrack;
                    if (audioTrack != null && audioTrack.getState() == 1) {
                        logMainParameters();
                        logMainParametersExtended();
                        return true;
                    }
                    reportWebRtcAudioTrackInitError("Initialization of audio track failed.");
                    releaseAudioResources();
                    return false;
                } catch (IllegalArgumentException e2) {
                    reportWebRtcAudioTrackInitError(e2.getMessage());
                    releaseAudioResources();
                    return false;
                }
            }
        }
        return invokeII.booleanValue;
    }

    @SuppressLint({"NewApi"})
    private boolean isVolumeFixed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            if (WebRtcAudioUtils.runningOnLollipopOrHigher()) {
                return this.audioManager.isVolumeFixed();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void logMainParameters() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            Logging.d(TAG, "AudioTrack: session ID: " + this.audioTrack.getAudioSessionId() + ", channels: " + this.audioTrack.getChannelCount() + ", sample rate: " + this.audioTrack.getSampleRate() + ", max gain: " + AudioTrack.getMaxVolume());
        }
    }

    @TargetApi(24)
    private void logMainParametersExtended() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            if (WebRtcAudioUtils.runningOnMarshmallowOrHigher()) {
                Logging.d(TAG, "AudioTrack: buffer size in frames: " + this.audioTrack.getBufferSizeInFrames());
            }
            if (WebRtcAudioUtils.runningOnNougatOrHigher()) {
                Logging.d(TAG, "AudioTrack: buffer capacity in frames: " + this.audioTrack.getBufferCapacityInFrames());
            }
        }
    }

    @TargetApi(24)
    private void logUnderrunCount() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65565, this) == null) && WebRtcAudioUtils.runningOnNougatOrHigher()) {
            Logging.d(TAG, "underrun count: " + this.audioTrack.getUnderrunCount());
        }
    }

    public static native void nativeCacheDirectBufferAddress(long j2, ByteBuffer byteBuffer);

    public static native void nativeGetPlayoutData(long j2, int i2);

    private void releaseAudioResources() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            Logging.d(TAG, "releaseAudioResources");
            AudioTrack audioTrack = this.audioTrack;
            if (audioTrack != null) {
                audioTrack.release();
                this.audioTrack = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportWebRtcAudioTrackError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, this, str) == null) {
            Logging.e(TAG, "Run-time playback error: " + str);
            WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
            JavaAudioDeviceModule.AudioTrackErrorCallback audioTrackErrorCallback = this.errorCallback;
            if (audioTrackErrorCallback != null) {
                audioTrackErrorCallback.onWebRtcAudioTrackError(str);
            }
        }
    }

    private void reportWebRtcAudioTrackInitError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, this, str) == null) {
            Logging.e(TAG, "Init playout error: " + str);
            WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
            JavaAudioDeviceModule.AudioTrackErrorCallback audioTrackErrorCallback = this.errorCallback;
            if (audioTrackErrorCallback != null) {
                audioTrackErrorCallback.onWebRtcAudioTrackInitError(str);
            }
        }
    }

    private void reportWebRtcAudioTrackStartError(JavaAudioDeviceModule.AudioTrackStartErrorCode audioTrackStartErrorCode, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65571, this, audioTrackStartErrorCode, str) == null) {
            Logging.e(TAG, "Start playout error: " + audioTrackStartErrorCode + ". " + str);
            WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
            JavaAudioDeviceModule.AudioTrackErrorCallback audioTrackErrorCallback = this.errorCallback;
            if (audioTrackErrorCallback != null) {
                audioTrackErrorCallback.onWebRtcAudioTrackStartError(audioTrackStartErrorCode, str);
            }
        }
    }

    @CalledByNative
    private boolean setStreamVolume(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65572, this, i2)) == null) {
            this.threadChecker.checkIsOnValidThread();
            Logging.d(TAG, "setStreamVolume(" + i2 + SmallTailInfo.EMOTION_SUFFIX);
            if (isVolumeFixed()) {
                Logging.e(TAG, "The device implements a fixed volume policy.");
                return false;
            }
            this.audioManager.setStreamVolume(0, i2, 0);
            return true;
        }
        return invokeI.booleanValue;
    }

    @CalledByNative
    private boolean startPlayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, this)) == null) {
            this.threadChecker.checkIsOnValidThread();
            this.volumeLogger.start();
            Logging.d(TAG, "startPlayout");
            assertTrue(this.audioTrack != null);
            assertTrue(this.audioThread == null);
            try {
                this.audioTrack.play();
                if (this.audioTrack.getPlayState() != 3) {
                    JavaAudioDeviceModule.AudioTrackStartErrorCode audioTrackStartErrorCode = JavaAudioDeviceModule.AudioTrackStartErrorCode.AUDIO_TRACK_START_STATE_MISMATCH;
                    reportWebRtcAudioTrackStartError(audioTrackStartErrorCode, "AudioTrack.play failed - incorrect state :" + this.audioTrack.getPlayState());
                    releaseAudioResources();
                    return false;
                }
                AudioTrackThread audioTrackThread = new AudioTrackThread(this, "AudioTrackJavaThread");
                this.audioThread = audioTrackThread;
                audioTrackThread.start();
                return true;
            } catch (IllegalStateException e2) {
                JavaAudioDeviceModule.AudioTrackStartErrorCode audioTrackStartErrorCode2 = JavaAudioDeviceModule.AudioTrackStartErrorCode.AUDIO_TRACK_START_EXCEPTION;
                reportWebRtcAudioTrackStartError(audioTrackStartErrorCode2, "AudioTrack.play failed: " + e2.getMessage());
                releaseAudioResources();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @CalledByNative
    private boolean stopPlayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, this)) == null) {
            this.threadChecker.checkIsOnValidThread();
            this.volumeLogger.stop();
            Logging.d(TAG, "stopPlayout");
            assertTrue(this.audioThread != null);
            logUnderrunCount();
            this.audioThread.stopThread();
            Logging.d(TAG, "Stopping the AudioTrackThread...");
            this.audioThread.interrupt();
            if (!ThreadUtils.joinUninterruptibly(this.audioThread, 2000L)) {
                Logging.e(TAG, "Join of AudioTrackThread timed out.");
                WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
            }
            Logging.d(TAG, "AudioTrackThread has now been stopped.");
            this.audioThread = null;
            releaseAudioResources();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void setEnableSLIReport(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.isEnableSLIReport = z;
        }
    }

    @CalledByNative
    public void setNativeAudioTrack(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.nativeAudioTrack = j2;
        }
    }

    public void setRemoteSamplesReadyCallback(JavaAudioDeviceModule.RemoteSamplesReadyCallback remoteSamplesReadyCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, remoteSamplesReadyCallback) == null) {
            this.audioSamplesReadyCallback = remoteSamplesReadyCallback;
        }
    }

    public void setSpeakerMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            Logging.w(TAG, "setSpeakerMute(" + z + SmallTailInfo.EMOTION_SUFFIX);
            this.speakerMute = z;
        }
    }

    public void setStuckEventListener(SLIReportInterface sLIReportInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sLIReportInterface) == null) {
            this.stuckDataCalculator.setStuckEventListener(sLIReportInterface);
        }
    }

    public WebRtcAudioTrack(Context context, AudioManager audioManager, int i2, @Nullable JavaAudioDeviceModule.RemoteSamplesReadyCallback remoteSamplesReadyCallback, JavaAudioDeviceModule.AudioTrackErrorCallback audioTrackErrorCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, audioManager, Integer.valueOf(i2), remoteSamplesReadyCallback, audioTrackErrorCallback};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.stuckDataCalculator = new StuckDataCalculator(200);
        this.isEnableSLIReport = false;
        this.threadChecker = new ThreadUtils.ThreadChecker();
        this.audioTrack = null;
        this.audioThread = null;
        this.speakerMute = false;
        this.threadChecker.detachThread();
        this.context = context;
        this.audioManager = audioManager;
        audioContentType = i2;
        this.errorCallback = audioTrackErrorCallback;
        this.audioSamplesReadyCallback = remoteSamplesReadyCallback;
        this.volumeLogger = new VolumeLogger(audioManager);
    }
}
