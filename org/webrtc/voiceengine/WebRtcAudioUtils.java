package org.webrtc.voiceengine;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.bumptech.glide.load.engine.GlideException;
import java.util.Arrays;
import java.util.List;
import org.webrtc.ContextUtils;
import org.webrtc.Logging;
/* loaded from: classes8.dex */
public final class WebRtcAudioUtils {
    public static final int DEFAULT_SAMPLE_RATE_HZ = 16000;
    public static final String TAG = "WebRtcAudioUtils";
    public static int defaultSampleRateHz = 16000;
    public static boolean isDefaultSampleRateOverridden;
    public static boolean useWebRtcBasedAcousticEchoCanceler;
    public static boolean useWebRtcBasedNoiseSuppressor;
    public static final String[] BLACKLISTED_OPEN_SL_ES_MODELS = new String[0];
    public static final String[] BLACKLISTED_AEC_MODELS = new String[0];
    public static final String[] BLACKLISTED_NS_MODELS = new String[0];

    public static boolean deviceIsBlacklistedForOpenSLESUsage() {
        return Arrays.asList(BLACKLISTED_OPEN_SL_ES_MODELS).contains(Build.MODEL);
    }

    public static String deviceTypeToString(int i2) {
        switch (i2) {
            case 1:
                return "TYPE_BUILTIN_EARPIECE";
            case 2:
                return "TYPE_BUILTIN_SPEAKER";
            case 3:
                return "TYPE_WIRED_HEADSET";
            case 4:
                return "TYPE_WIRED_HEADPHONES";
            case 5:
                return "TYPE_LINE_ANALOG";
            case 6:
                return "TYPE_LINE_DIGITAL";
            case 7:
                return "TYPE_BLUETOOTH_SCO";
            case 8:
                return "TYPE_BLUETOOTH_A2DP";
            case 9:
                return "TYPE_HDMI";
            case 10:
                return "TYPE_HDMI_ARC";
            case 11:
                return "TYPE_USB_DEVICE";
            case 12:
                return "TYPE_USB_ACCESSORY";
            case 13:
                return "TYPE_DOCK";
            case 14:
                return "TYPE_FM";
            case 15:
                return "TYPE_BUILTIN_MIC";
            case 16:
                return "TYPE_FM_TUNER";
            case 17:
                return "TYPE_TV_TUNER";
            case 18:
                return "TYPE_TELEPHONY";
            case 19:
                return "TYPE_AUX_LINE";
            case 20:
                return "TYPE_IP";
            case 21:
                return "TYPE_BUS";
            case 22:
                return "TYPE_USB_HEADSET";
            default:
                return "TYPE_UNKNOWN";
        }
    }

    public static List<String> getBlackListedModelsForAecUsage() {
        return Arrays.asList(BLACKLISTED_AEC_MODELS);
    }

    public static List<String> getBlackListedModelsForNsUsage() {
        return Arrays.asList(BLACKLISTED_NS_MODELS);
    }

    public static int getDefaultSampleRateHz() {
        int i2;
        synchronized (WebRtcAudioUtils.class) {
            i2 = defaultSampleRateHz;
        }
        return i2;
    }

    public static String getThreadInfo() {
        return "@[name=" + Thread.currentThread().getName() + ", id=" + Thread.currentThread().getId() + PreferencesUtil.RIGHT_MOUNT;
    }

    public static boolean hasMicrophone() {
        return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.microphone");
    }

    public static boolean isAcousticEchoCancelerSupported() {
        return WebRtcAudioEffects.canUseAcousticEchoCanceler();
    }

    public static boolean isAutomaticGainControlSupported() {
        return false;
    }

    public static boolean isDefaultSampleRateOverridden() {
        boolean z;
        synchronized (WebRtcAudioUtils.class) {
            z = isDefaultSampleRateOverridden;
        }
        return z;
    }

    public static boolean isNoiseSuppressorSupported() {
        return WebRtcAudioEffects.canUseNoiseSuppressor();
    }

    public static boolean isVolumeFixed(AudioManager audioManager) {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        return audioManager.isVolumeFixed();
    }

    public static void logAudioDeviceInfo(String str, AudioManager audioManager) {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        AudioDeviceInfo[] devices = audioManager.getDevices(3);
        if (devices.length == 0) {
            return;
        }
        Logging.d(str, "Audio Devices: ");
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            StringBuilder sb = new StringBuilder();
            sb.append(GlideException.IndentedAppendable.INDENT);
            sb.append(deviceTypeToString(audioDeviceInfo.getType()));
            sb.append(audioDeviceInfo.isSource() ? "(in): " : "(out): ");
            if (audioDeviceInfo.getChannelCounts().length > 0) {
                sb.append("channels=");
                sb.append(Arrays.toString(audioDeviceInfo.getChannelCounts()));
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            if (audioDeviceInfo.getEncodings().length > 0) {
                sb.append("encodings=");
                sb.append(Arrays.toString(audioDeviceInfo.getEncodings()));
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            if (audioDeviceInfo.getSampleRates().length > 0) {
                sb.append("sample rates=");
                sb.append(Arrays.toString(audioDeviceInfo.getSampleRates()));
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("id=");
            sb.append(audioDeviceInfo.getId());
            Logging.d(str, sb.toString());
        }
    }

    public static void logAudioState(String str) {
        logDeviceInfo(str);
        AudioManager audioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService("audio");
        logAudioStateBasic(str, audioManager);
        logAudioStateVolume(str, audioManager);
        logAudioDeviceInfo(str, audioManager);
    }

    public static void logAudioStateBasic(String str, AudioManager audioManager) {
        Logging.d(str, "Audio State: audio mode: " + modeToString(audioManager.getMode()) + ", has mic: " + hasMicrophone() + ", mic muted: " + audioManager.isMicrophoneMute() + ", music active: " + audioManager.isMusicActive() + ", speakerphone: " + audioManager.isSpeakerphoneOn() + ", BT SCO: " + audioManager.isBluetoothScoOn());
    }

    public static void logAudioStateVolume(String str, AudioManager audioManager) {
        int[] iArr = {0, 3, 2, 4, 5, 1};
        Logging.d(str, "Audio State: ");
        boolean isVolumeFixed = isVolumeFixed(audioManager);
        Logging.d(str, "  fixed volume=" + isVolumeFixed);
        if (isVolumeFixed) {
            return;
        }
        for (int i2 = 0; i2 < 6; i2++) {
            int i3 = iArr[i2];
            StringBuilder sb = new StringBuilder();
            sb.append(GlideException.IndentedAppendable.INDENT + streamTypeToString(i3) + ": ");
            sb.append("volume=");
            sb.append(audioManager.getStreamVolume(i3));
            sb.append(", max=");
            sb.append(audioManager.getStreamMaxVolume(i3));
            logIsStreamMute(str, audioManager, i3, sb);
            Logging.d(str, sb.toString());
        }
    }

    public static void logDeviceInfo(String str) {
        Logging.d(str, "Android SDK: " + Build.VERSION.SDK_INT + ", Release: " + Build.VERSION.RELEASE + ", Brand: " + Build.BRAND + ", Device: " + Build.DEVICE + ", Id: " + Build.ID + ", Hardware: " + Build.HARDWARE + ", Manufacturer: " + Build.MANUFACTURER + ", Model: " + Build.MODEL + ", Product: " + Build.PRODUCT);
    }

    public static void logIsStreamMute(String str, AudioManager audioManager, int i2, StringBuilder sb) {
        if (Build.VERSION.SDK_INT >= 23) {
            sb.append(", muted=");
            sb.append(audioManager.isStreamMute(i2));
        }
    }

    public static String modeToString(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "MODE_INVALID" : "MODE_IN_COMMUNICATION" : "MODE_IN_CALL" : "MODE_RINGTONE" : "MODE_NORMAL";
    }

    public static boolean runningOnEmulator() {
        return Build.HARDWARE.equals("goldfish") && Build.BRAND.startsWith("generic_");
    }

    public static void setDefaultSampleRateHz(int i2) {
        synchronized (WebRtcAudioUtils.class) {
            isDefaultSampleRateOverridden = true;
            defaultSampleRateHz = i2;
        }
    }

    public static void setWebRtcBasedAcousticEchoCanceler(boolean z) {
        synchronized (WebRtcAudioUtils.class) {
            useWebRtcBasedAcousticEchoCanceler = z;
        }
    }

    public static void setWebRtcBasedAutomaticGainControl(boolean z) {
        synchronized (WebRtcAudioUtils.class) {
            Logging.w(TAG, "setWebRtcBasedAutomaticGainControl() is deprecated");
        }
    }

    public static void setWebRtcBasedNoiseSuppressor(boolean z) {
        synchronized (WebRtcAudioUtils.class) {
            useWebRtcBasedNoiseSuppressor = z;
        }
    }

    public static String streamTypeToString(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "STREAM_INVALID" : "STREAM_NOTIFICATION" : "STREAM_ALARM" : "STREAM_MUSIC" : "STREAM_RING" : "STREAM_SYSTEM" : "STREAM_VOICE_CALL";
    }

    public static boolean useWebRtcBasedAcousticEchoCanceler() {
        boolean z;
        synchronized (WebRtcAudioUtils.class) {
            if (useWebRtcBasedAcousticEchoCanceler) {
                Logging.w(TAG, "Overriding default behavior; now using WebRTC AEC!");
            }
            z = useWebRtcBasedAcousticEchoCanceler;
        }
        return z;
    }

    public static boolean useWebRtcBasedAutomaticGainControl() {
        synchronized (WebRtcAudioUtils.class) {
        }
        return true;
    }

    public static boolean useWebRtcBasedNoiseSuppressor() {
        boolean z;
        synchronized (WebRtcAudioUtils.class) {
            if (useWebRtcBasedNoiseSuppressor) {
                Logging.w(TAG, "Overriding default behavior; now using WebRTC NS!");
            }
            z = useWebRtcBasedNoiseSuppressor;
        }
        return z;
    }
}
