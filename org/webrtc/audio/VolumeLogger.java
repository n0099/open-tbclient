package org.webrtc.audio;

import android.media.AudioManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
import java.util.TimerTask;
import javax.annotation.Nullable;
import org.webrtc.Logging;
/* loaded from: classes9.dex */
public class VolumeLogger {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "VolumeLogger";
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
                    Logging.d(VolumeLogger.TAG, "STREAM_RING stream volume: " + this.this$0.audioManager.getStreamVolume(2) + " (max=" + this.maxRingVolume + SmallTailInfo.EMOTION_SUFFIX);
                } else if (mode == 3) {
                    Logging.d(VolumeLogger.TAG, "VOICE_CALL stream volume: " + this.this$0.audioManager.getStreamVolume(0) + " (max=" + this.maxVoiceCallVolume + SmallTailInfo.EMOTION_SUFFIX);
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

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Logging.d(TAG, "start" + WebRtcAudioUtils.getThreadInfo());
            if (this.timer != null) {
                return;
            }
            Logging.d(TAG, "audio mode is: " + WebRtcAudioUtils.modeToString(this.audioManager.getMode()));
            Timer timer = new Timer("WebRtcVolumeLevelLoggerThread");
            this.timer = timer;
            timer.schedule(new LogVolumeTask(this, this.audioManager.getStreamMaxVolume(2), this.audioManager.getStreamMaxVolume(0)), 0L, 30000L);
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Logging.d(TAG, "stop" + WebRtcAudioUtils.getThreadInfo());
            Timer timer = this.timer;
            if (timer != null) {
                timer.cancel();
                this.timer = null;
            }
        }
    }
}
