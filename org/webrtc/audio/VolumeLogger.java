package org.webrtc.audio;

import android.media.AudioManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
import java.util.TimerTask;
import javax.annotation.Nullable;
import org.webrtc.Logging;
/* loaded from: classes10.dex */
public class VolumeLogger {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "VolumeLogger";
    public static final String THREAD_NAME = "WebRtcVolumeLevelLoggerThread";
    public static final int TIMER_PERIOD_IN_SECONDS = 30;
    public transient /* synthetic */ FieldHolder $fh;
    public final AudioManager audioManager;
    @Nullable
    public Timer timer;

    /* loaded from: classes10.dex */
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
            StringBuilder sb;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int mode = this.this$0.audioManager.getMode();
                if (mode == 1) {
                    sb = new StringBuilder();
                    sb.append("STREAM_RING stream volume: ");
                    sb.append(this.this$0.audioManager.getStreamVolume(2));
                    sb.append(" (max=");
                    i2 = this.maxRingVolume;
                } else if (mode != 3) {
                    return;
                } else {
                    sb = new StringBuilder();
                    sb.append("VOICE_CALL stream volume: ");
                    sb.append(this.this$0.audioManager.getStreamVolume(0));
                    sb.append(" (max=");
                    i2 = this.maxVoiceCallVolume;
                }
                sb.append(i2);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                Logging.d(VolumeLogger.TAG, sb.toString());
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
            Logging.d(TAG, IntentConfig.STOP + WebRtcAudioUtils.getThreadInfo());
            Timer timer = this.timer;
            if (timer != null) {
                timer.cancel();
                this.timer = null;
            }
        }
    }
}
