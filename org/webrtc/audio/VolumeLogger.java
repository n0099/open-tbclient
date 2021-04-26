package org.webrtc.audio;

import android.media.AudioManager;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.Timer;
import java.util.TimerTask;
import javax.annotation.Nullable;
import org.webrtc.Logging;
/* loaded from: classes7.dex */
public class VolumeLogger {
    public static final String TAG = "VolumeLogger";
    public static final String THREAD_NAME = "WebRtcVolumeLevelLoggerThread";
    public static final int TIMER_PERIOD_IN_SECONDS = 30;
    public final AudioManager audioManager;
    @Nullable
    public Timer timer;

    /* loaded from: classes7.dex */
    public class LogVolumeTask extends TimerTask {
        public final int maxRingVolume;
        public final int maxVoiceCallVolume;

        public LogVolumeTask(int i2, int i3) {
            this.maxRingVolume = i2;
            this.maxVoiceCallVolume = i3;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            StringBuilder sb;
            int i2;
            int mode = VolumeLogger.this.audioManager.getMode();
            if (mode == 1) {
                sb = new StringBuilder();
                sb.append("STREAM_RING stream volume: ");
                sb.append(VolumeLogger.this.audioManager.getStreamVolume(2));
                sb.append(" (max=");
                i2 = this.maxRingVolume;
            } else if (mode != 3) {
                return;
            } else {
                sb = new StringBuilder();
                sb.append("VOICE_CALL stream volume: ");
                sb.append(VolumeLogger.this.audioManager.getStreamVolume(0));
                sb.append(" (max=");
                i2 = this.maxVoiceCallVolume;
            }
            sb.append(i2);
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            Logging.d(VolumeLogger.TAG, sb.toString());
        }
    }

    public VolumeLogger(AudioManager audioManager) {
        this.audioManager = audioManager;
    }

    public void start() {
        Logging.d(TAG, IntentConfig.START + WebRtcAudioUtils.getThreadInfo());
        if (this.timer != null) {
            return;
        }
        Logging.d(TAG, "audio mode is: " + WebRtcAudioUtils.modeToString(this.audioManager.getMode()));
        Timer timer = new Timer("WebRtcVolumeLevelLoggerThread");
        this.timer = timer;
        timer.schedule(new LogVolumeTask(this.audioManager.getStreamMaxVolume(2), this.audioManager.getStreamMaxVolume(0)), 0L, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
    }

    public void stop() {
        Logging.d(TAG, IntentConfig.STOP + WebRtcAudioUtils.getThreadInfo());
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
    }
}
