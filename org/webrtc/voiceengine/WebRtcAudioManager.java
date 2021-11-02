package org.webrtc.voiceengine;

import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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
import org.webrtc.MediaStreamTrack;
/* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public static class VolumeLogger {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String THREAD_NAME = "WebRtcVolumeLevelLoggerThread";
        public static final int TIMER_PERIOD_IN_SECONDS = 30;
        public transient /* synthetic */ FieldHolder $fh;
        public final AudioManager audioManager;
        @Nullable
        public Timer timer;

        /* loaded from: classes3.dex */
        public class LogVolumeTask extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final int maxRingVolume;
            public final int maxVoiceCallVolume;
            public final /* synthetic */ VolumeLogger this$0;

            public LogVolumeTask(VolumeLogger volumeLogger, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {volumeLogger, Integer.valueOf(i2), Integer.valueOf(i3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = volumeLogger;
                this.maxRingVolume = i2;
                this.maxVoiceCallVolume = i3;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (timer = this.timer) == null) {
                return;
            }
            timer.cancel();
            this.timer = null;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Logging.d(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
        this.nativeAudioManager = j;
        AudioManager audioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        this.audioManager = audioManager;
        this.volumeLogger = new VolumeLogger(audioManager);
        storeAudioParameters();
        nativeCacheAudioParameters(this.sampleRate, this.outputChannels, this.inputChannels, this.hardwareAEC, this.hardwareAGC, this.hardwareNS, this.lowLatencyOutput, this.lowLatencyInput, this.proAudio, this.aAudio, this.outputBufferSize, this.inputBufferSize, j);
        WebRtcAudioUtils.logAudioState(TAG);
    }

    public static void assertTrue(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65537, null, z) == null) && !z) {
            throw new AssertionError("Expected condition to be true");
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
            if (Build.VERSION.SDK_INT >= 17 && (property = this.audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER")) != null) {
                return Integer.parseInt(property);
            }
            return 256;
        }
        return invokeV.intValue;
    }

    public static int getMinInputFrameSize(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.AD_TEXT_ID, null, i2, i3)) == null) {
            return AudioRecord.getMinBufferSize(i2, i3 == 1 ? 16 : 12, 2) / (i3 * 2);
        }
        return invokeII.intValue;
    }

    public static int getMinOutputFrameSize(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.BAIDU_LOGO_ID, null, i2, i3)) == null) {
            return AudioTrack.getMinBufferSize(i2, i3 == 1 ? 4 : 12, 2) / (i3 * 2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.telephony") : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? WebRtcAudioEffects.canUseAcousticEchoCanceler() : invokeV.booleanValue;
    }

    private boolean isCommunicationModeEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) ? this.audioManager.getMode() == 3 : invokeV.booleanValue;
    }

    private boolean isDeviceBlacklistedForOpenSLESUsage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            boolean deviceIsBlacklistedForOpenSLESUsage = blacklistDeviceForOpenSLESUsageIsOverridden ? blacklistDeviceForOpenSLESUsage : WebRtcAudioUtils.deviceIsBlacklistedForOpenSLESUsage();
            if (deviceIsBlacklistedForOpenSLESUsage) {
                Logging.d(TAG, Build.MODEL + " is blacklisted for OpenSL ES usage!");
            }
            return deviceIsBlacklistedForOpenSLESUsage;
        }
        return invokeV.booleanValue;
    }

    private boolean isLowLatencyOutputSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) ? ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.audio.low_latency") : invokeV.booleanValue;
    }

    public static boolean isNoiseSuppressorSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? WebRtcAudioEffects.canUseNoiseSuppressor() : invokeV.booleanValue;
    }

    private boolean isProAudioSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) ? Build.VERSION.SDK_INT >= 23 && ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.audio.pro") : invokeV.booleanValue;
    }

    private native void nativeCacheAudioParameters(int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i5, int i6, long j);

    public static synchronized void setBlacklistDeviceForOpenSLESUsage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65557, null, z) == null) {
            synchronized (WebRtcAudioManager.class) {
                blacklistDeviceForOpenSLESUsageIsOverridden = true;
                blacklistDeviceForOpenSLESUsage = z;
            }
        }
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

    private void storeAudioParameters() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            this.outputChannels = getStereoOutput() ? 2 : 1;
            this.inputChannels = getStereoInput() ? 2 : 1;
            this.sampleRate = getNativeOutputSampleRate();
            this.hardwareAEC = isAcousticEchoCancelerSupported();
            this.hardwareAGC = false;
            this.hardwareNS = isNoiseSuppressorSupported();
            this.lowLatencyOutput = isLowLatencyOutputSupported();
            this.lowLatencyInput = isLowLatencyInputSupported();
            this.proAudio = isProAudioSupported();
            this.aAudio = isAAudioSupported();
            this.outputBufferSize = this.lowLatencyOutput ? getLowLatencyOutputFramesPerBuffer() : getMinOutputFrameSize(this.sampleRate, this.outputChannels);
            this.inputBufferSize = this.lowLatencyInput ? getLowLatencyInputFramesPerBuffer() : getMinInputFrameSize(this.sampleRate, this.inputChannels);
        }
    }

    public boolean isLowLatencyInputSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Build.VERSION.SDK_INT >= 21 && isLowLatencyOutputSupported() : invokeV.booleanValue;
    }
}
