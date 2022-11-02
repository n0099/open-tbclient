package org.webrtc.voiceengine;

import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
import java.util.TimerTask;
import javax.annotation.Nullable;
import org.webrtc.ContextUtils;
import org.webrtc.Logging;
/* loaded from: classes9.dex */
public class WebRtcAudioManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BITS_PER_SAMPLE = 16;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_FRAME_PER_BUFFER = 256;
    public static final String TAG = "WebRtcAudioManager";
    public static final boolean blacklistDeviceForAAudioUsage = true;
    public static boolean blacklistDeviceForOpenSLESUsage;
    public static boolean blacklistDeviceForOpenSLESUsageIsOverridden;
    public static boolean useStereoInput;
    public static boolean useStereoOutput;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean aAudio;
    public final AudioManager audioManager;
    public boolean hardwareAEC;
    public boolean hardwareAGC;
    public boolean hardwareNS;
    public boolean initialized;
    public int inputBufferSize;
    public int inputChannels;
    public boolean lowLatencyInput;
    public boolean lowLatencyOutput;
    public final long nativeAudioManager;
    public int nativeChannels;
    public int nativeSampleRate;
    public int outputBufferSize;
    public int outputChannels;
    public boolean proAudio;
    public int sampleRate;
    public final VolumeLogger volumeLogger;

    private native void nativeCacheAudioParameters(int i, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i4, int i5, long j);

    /* loaded from: classes9.dex */
    public static class VolumeLogger {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String THREAD_NAME = "WebRtcVolumeLevelLoggerThread";
        public static final int TIMER_PERIOD_IN_SECONDS = 30;
        public transient /* synthetic */ FieldHolder $fh;
        public final AudioManager audioManager;
        @Nullable
        public Timer timer;

        /* loaded from: classes9.dex */
        public class LogVolumeTask extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final int maxRingVolume;
            public final int maxVoiceCallVolume;
            public final /* synthetic */ VolumeLogger this$0;

            public LogVolumeTask(VolumeLogger volumeLogger, int i, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {volumeLogger, Integer.valueOf(i), Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = volumeLogger;
                this.maxRingVolume = i;
                this.maxVoiceCallVolume = i2;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int mode = this.this$0.audioManager.getMode();
                    if (mode == 1) {
                        Logging.d(WebRtcAudioManager.TAG, "STREAM_RING stream volume: " + this.this$0.audioManager.getStreamVolume(2) + " (max=" + this.maxRingVolume + SmallTailInfo.EMOTION_SUFFIX);
                    } else if (mode == 3) {
                        Logging.d(WebRtcAudioManager.TAG, "VOICE_CALL stream volume: " + this.this$0.audioManager.getStreamVolume(0) + " (max=" + this.maxVoiceCallVolume + SmallTailInfo.EMOTION_SUFFIX);
                    }
                }
            }
        }

        public VolumeLogger(AudioManager audioManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {audioManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.audioManager = audioManager;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void stop() {
            Timer timer;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65539, this) == null) && (timer = this.timer) != null) {
                timer.cancel();
                this.timer = null;
            }
        }

        public void start() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Timer timer = new Timer("WebRtcVolumeLevelLoggerThread");
                this.timer = timer;
                timer.schedule(new LogVolumeTask(this, this.audioManager.getStreamMaxVolume(2), this.audioManager.getStreamMaxVolume(0)), 0L, 30000L);
            }
        }
    }

    public WebRtcAudioManager(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Logging.d(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
        this.nativeAudioManager = j;
        AudioManager audioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService("audio");
        this.audioManager = audioManager;
        this.volumeLogger = new VolumeLogger(audioManager);
        storeAudioParameters();
        nativeCacheAudioParameters(this.sampleRate, this.outputChannels, this.inputChannels, this.hardwareAEC, this.hardwareAGC, this.hardwareNS, this.lowLatencyOutput, this.lowLatencyInput, this.proAudio, this.aAudio, this.outputBufferSize, this.inputBufferSize, j);
        WebRtcAudioUtils.logAudioState(TAG);
    }

    public static void assertTrue(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(65537, null, z) != null) || z) {
            return;
        }
        throw new AssertionError("Expected condition to be true");
    }

    public static synchronized void setBlacklistDeviceForOpenSLESUsage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65557, null, z) == null) {
            synchronized (WebRtcAudioManager.class) {
                blacklistDeviceForOpenSLESUsageIsOverridden = true;
                blacklistDeviceForOpenSLESUsage = z;
            }
        }
    }

    private void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            Logging.d(TAG, "dispose" + WebRtcAudioUtils.getThreadInfo());
            if (this.initialized) {
                this.volumeLogger.stop();
            }
        }
    }

    private boolean isDeviceBlacklistedForOpenSLESUsage() {
        InterceptResult invokeV;
        boolean deviceIsBlacklistedForOpenSLESUsage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            if (blacklistDeviceForOpenSLESUsageIsOverridden) {
                deviceIsBlacklistedForOpenSLESUsage = blacklistDeviceForOpenSLESUsage;
            } else {
                deviceIsBlacklistedForOpenSLESUsage = WebRtcAudioUtils.deviceIsBlacklistedForOpenSLESUsage();
            }
            if (deviceIsBlacklistedForOpenSLESUsage) {
                Logging.d(TAG, Build.MODEL + " is blacklisted for OpenSL ES usage!");
            }
            return deviceIsBlacklistedForOpenSLESUsage;
        }
        return invokeV.booleanValue;
    }

    private int getLowLatencyInputFramesPerBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            assertTrue(isLowLatencyInputSupported());
            return getLowLatencyOutputFramesPerBuffer();
        }
        return invokeV.intValue;
    }

    private int getLowLatencyOutputFramesPerBuffer() {
        InterceptResult invokeV;
        String property;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            assertTrue(isLowLatencyOutputSupported());
            if (Build.VERSION.SDK_INT < 17 || (property = this.audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER")) == null) {
                return 256;
            }
            return Integer.parseInt(property);
        }
        return invokeV.intValue;
    }

    private int getSampleRateForApiLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            if (Build.VERSION.SDK_INT < 17) {
                return WebRtcAudioUtils.getDefaultSampleRateHz();
            }
            String property = this.audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
            if (property == null) {
                return WebRtcAudioUtils.getDefaultSampleRateHz();
            }
            return Integer.parseInt(property);
        }
        return invokeV.intValue;
    }

    public static synchronized boolean getStereoInput() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            synchronized (WebRtcAudioManager.class) {
                z = useStereoInput;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static synchronized boolean getStereoOutput() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            synchronized (WebRtcAudioManager.class) {
                z = useStereoOutput;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    private boolean hasEarpiece() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.telephony");
        }
        return invokeV.booleanValue;
    }

    private boolean isAAudioSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            Logging.w(TAG, "AAudio support is currently disabled on all devices!");
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isAcousticEchoCancelerSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return WebRtcAudioEffects.canUseAcousticEchoCanceler();
        }
        return invokeV.booleanValue;
    }

    private boolean isCommunicationModeEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            if (this.audioManager.getMode() == 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean isLowLatencyOutputSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
        }
        return invokeV.booleanValue;
    }

    public static boolean isNoiseSuppressorSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return WebRtcAudioEffects.canUseNoiseSuppressor();
        }
        return invokeV.booleanValue;
    }

    private boolean isProAudioSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            if (Build.VERSION.SDK_INT >= 23 && ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.audio.pro")) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isLowLatencyInputSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (Build.VERSION.SDK_INT >= 21 && isLowLatencyOutputSupported()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static int getMinInputFrameSize(int i, int i2) {
        InterceptResult invokeII;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65541, null, i, i2)) == null) {
            int i4 = i2 * 2;
            if (i2 == 1) {
                i3 = 16;
            } else {
                i3 = 12;
            }
            return AudioRecord.getMinBufferSize(i, i3, 2) / i4;
        }
        return invokeII.intValue;
    }

    public static int getMinOutputFrameSize(int i, int i2) {
        InterceptResult invokeII;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65542, null, i, i2)) == null) {
            int i4 = i2 * 2;
            if (i2 == 1) {
                i3 = 4;
            } else {
                i3 = 12;
            }
            return AudioTrack.getMinBufferSize(i, i3, 2) / i4;
        }
        return invokeII.intValue;
    }

    private int getNativeOutputSampleRate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (WebRtcAudioUtils.runningOnEmulator()) {
                Logging.d(TAG, "Running emulator, overriding sample rate to 8 kHz.");
                return 8000;
            } else if (WebRtcAudioUtils.isDefaultSampleRateOverridden()) {
                Logging.d(TAG, "Default sample rate is overriden to " + WebRtcAudioUtils.getDefaultSampleRateHz() + " Hz");
                return WebRtcAudioUtils.getDefaultSampleRateHz();
            } else {
                int sampleRateForApiLevel = getSampleRateForApiLevel();
                Logging.d(TAG, "Sample rate is set to " + sampleRateForApiLevel + " Hz");
                return sampleRateForApiLevel;
            }
        }
        return invokeV.intValue;
    }

    private void storeAudioParameters() {
        int i;
        int minOutputFrameSize;
        int minInputFrameSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            int i2 = 2;
            if (getStereoOutput()) {
                i = 2;
            } else {
                i = 1;
            }
            this.outputChannels = i;
            if (!getStereoInput()) {
                i2 = 1;
            }
            this.inputChannels = i2;
            this.sampleRate = getNativeOutputSampleRate();
            this.hardwareAEC = isAcousticEchoCancelerSupported();
            this.hardwareAGC = false;
            this.hardwareNS = isNoiseSuppressorSupported();
            this.lowLatencyOutput = isLowLatencyOutputSupported();
            this.lowLatencyInput = isLowLatencyInputSupported();
            this.proAudio = isProAudioSupported();
            this.aAudio = isAAudioSupported();
            if (this.lowLatencyOutput) {
                minOutputFrameSize = getLowLatencyOutputFramesPerBuffer();
            } else {
                minOutputFrameSize = getMinOutputFrameSize(this.sampleRate, this.outputChannels);
            }
            this.outputBufferSize = minOutputFrameSize;
            if (this.lowLatencyInput) {
                minInputFrameSize = getLowLatencyInputFramesPerBuffer();
            } else {
                minInputFrameSize = getMinInputFrameSize(this.sampleRate, this.inputChannels);
            }
            this.inputBufferSize = minInputFrameSize;
        }
    }

    private boolean init() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            Logging.d(TAG, "init" + WebRtcAudioUtils.getThreadInfo());
            if (this.initialized) {
                return true;
            }
            Logging.d(TAG, "audio mode is: " + WebRtcAudioUtils.modeToString(this.audioManager.getMode()));
            this.initialized = true;
            this.volumeLogger.start();
            return true;
        }
        return invokeV.booleanValue;
    }

    public static synchronized void setStereoInput(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65558, null, z) == null) {
            synchronized (WebRtcAudioManager.class) {
                Logging.w(TAG, "Overriding default input behavior: setStereoInput(" + z + ')');
                useStereoInput = z;
            }
        }
    }

    public static synchronized void setStereoOutput(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65559, null, z) == null) {
            synchronized (WebRtcAudioManager.class) {
                Logging.w(TAG, "Overriding default output behavior: setStereoOutput(" + z + ')');
                useStereoOutput = z;
            }
        }
    }
}
