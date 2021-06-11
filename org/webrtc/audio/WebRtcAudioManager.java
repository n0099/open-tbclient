package org.webrtc.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Build;
import org.webrtc.CalledByNative;
import org.webrtc.Logging;
/* loaded from: classes8.dex */
public class WebRtcAudioManager {
    public static final int BITS_PER_SAMPLE = 16;
    public static final int DEFAULT_FRAME_PER_BUFFER = 256;
    public static final int DEFAULT_SAMPLE_RATE_HZ = 16000;
    public static final String TAG = "WebRtcAudioManagerExternal";

    @CalledByNative
    public static AudioManager getAudioManager(Context context) {
        return (AudioManager) context.getSystemService("audio");
    }

    @CalledByNative
    public static int getInputBufferSize(Context context, AudioManager audioManager, int i2, int i3) {
        return isLowLatencyInputSupported(context) ? getLowLatencyFramesPerBuffer(audioManager) : getMinInputFrameSize(i2, i3);
    }

    public static int getLowLatencyFramesPerBuffer(AudioManager audioManager) {
        String property;
        if (Build.VERSION.SDK_INT >= 17 && (property = audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER")) != null) {
            return Integer.parseInt(property);
        }
        return 256;
    }

    public static int getMinInputFrameSize(int i2, int i3) {
        return AudioRecord.getMinBufferSize(i2, i3 == 1 ? 16 : 12, 2) / (i3 * 2);
    }

    public static int getMinOutputFrameSize(int i2, int i3) {
        return AudioTrack.getMinBufferSize(i2, i3 == 1 ? 4 : 12, 2) / (i3 * 2);
    }

    @CalledByNative
    public static int getOutputBufferSize(Context context, AudioManager audioManager, int i2, int i3) {
        return isLowLatencyOutputSupported(context) ? getLowLatencyFramesPerBuffer(audioManager) : getMinOutputFrameSize(i2, i3);
    }

    @CalledByNative
    public static int getSampleRate(AudioManager audioManager) {
        if (WebRtcAudioUtils.runningOnEmulator()) {
            Logging.d(TAG, "Running emulator, overriding sample rate to 8 kHz.");
            return 8000;
        }
        int sampleRateForApiLevel = getSampleRateForApiLevel(audioManager);
        Logging.d(TAG, "Sample rate is set to " + sampleRateForApiLevel + " Hz");
        return sampleRateForApiLevel;
    }

    public static int getSampleRateForApiLevel(AudioManager audioManager) {
        String property;
        if (Build.VERSION.SDK_INT >= 17 && (property = audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE")) != null) {
            return Integer.parseInt(property);
        }
        return 16000;
    }

    public static boolean isLowLatencyInputSupported(Context context) {
        return Build.VERSION.SDK_INT >= 21 && isLowLatencyOutputSupported(context);
    }

    public static boolean isLowLatencyOutputSupported(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
    }
}
