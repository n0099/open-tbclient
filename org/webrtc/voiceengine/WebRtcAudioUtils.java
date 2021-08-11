package org.webrtc.voiceengine;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.util.Arrays;
import java.util.List;
import org.webrtc.ContextUtils;
import org.webrtc.Logging;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes2.dex */
public final class WebRtcAudioUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String[] BLACKLISTED_AEC_MODELS;
    public static final String[] BLACKLISTED_NS_MODELS;
    public static final String[] BLACKLISTED_OPEN_SL_ES_MODELS;
    public static final int DEFAULT_SAMPLE_RATE_HZ = 16000;
    public static final String TAG = "WebRtcAudioUtils";
    public static int defaultSampleRateHz = 16000;
    public static boolean isDefaultSampleRateOverridden;
    public static boolean useWebRtcBasedAcousticEchoCanceler;
    public static boolean useWebRtcBasedNoiseSuppressor;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1424264819, "Lorg/webrtc/voiceengine/WebRtcAudioUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1424264819, "Lorg/webrtc/voiceengine/WebRtcAudioUtils;");
                return;
            }
        }
        BLACKLISTED_OPEN_SL_ES_MODELS = new String[0];
        BLACKLISTED_AEC_MODELS = new String[0];
        BLACKLISTED_NS_MODELS = new String[0];
    }

    public WebRtcAudioUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean deviceIsBlacklistedForOpenSLESUsage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Arrays.asList(BLACKLISTED_OPEN_SL_ES_MODELS).contains(Build.MODEL) : invokeV.booleanValue;
    }

    public static String deviceTypeToString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
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
        return (String) invokeI.objValue;
    }

    public static List<String> getBlackListedModelsForAecUsage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? Arrays.asList(BLACKLISTED_AEC_MODELS) : (List) invokeV.objValue;
    }

    public static List<String> getBlackListedModelsForNsUsage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? Arrays.asList(BLACKLISTED_NS_MODELS) : (List) invokeV.objValue;
    }

    public static int getDefaultSampleRateHz() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            synchronized (WebRtcAudioUtils.class) {
                i2 = defaultSampleRateHz;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public static String getThreadInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return "@[name=" + Thread.currentThread().getName() + ", id=" + Thread.currentThread().getId() + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    public static boolean hasMicrophone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.microphone") : invokeV.booleanValue;
    }

    public static boolean isAcousticEchoCancelerSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? WebRtcAudioEffects.canUseAcousticEchoCanceler() : invokeV.booleanValue;
    }

    public static boolean isAutomaticGainControlSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isDefaultSampleRateOverridden() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            synchronized (WebRtcAudioUtils.class) {
                z = isDefaultSampleRateOverridden;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean isNoiseSuppressorSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? WebRtcAudioEffects.canUseNoiseSuppressor() : invokeV.booleanValue;
    }

    public static boolean isVolumeFixed(AudioManager audioManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, audioManager)) == null) {
            if (Build.VERSION.SDK_INT < 21) {
                return false;
            }
            return audioManager.isVolumeFixed();
        }
        return invokeL.booleanValue;
    }

    public static void logAudioDeviceInfo(String str, AudioManager audioManager) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65550, null, str, audioManager) == null) || Build.VERSION.SDK_INT < 23) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            logDeviceInfo(str);
            AudioManager audioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            logAudioStateBasic(str, audioManager);
            logAudioStateVolume(str, audioManager);
            logAudioDeviceInfo(str, audioManager);
        }
    }

    public static void logAudioStateBasic(String str, AudioManager audioManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, str, audioManager) == null) {
            Logging.d(str, "Audio State: audio mode: " + modeToString(audioManager.getMode()) + ", has mic: " + hasMicrophone() + ", mic muted: " + audioManager.isMicrophoneMute() + ", music active: " + audioManager.isMusicActive() + ", speakerphone: " + audioManager.isSpeakerphoneOn() + ", BT SCO: " + audioManager.isBluetoothScoOn());
        }
    }

    public static void logAudioStateVolume(String str, AudioManager audioManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, str, audioManager) == null) {
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
    }

    public static void logDeviceInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, str) == null) {
            Logging.d(str, "Android SDK: " + Build.VERSION.SDK_INT + ", Release: " + Build.VERSION.RELEASE + ", Brand: " + Build.BRAND + ", Device: " + Build.DEVICE + ", Id: " + Build.ID + ", Hardware: " + Build.HARDWARE + ", Manufacturer: " + Build.MANUFACTURER + ", Model: " + Build.MODEL + ", Product: " + Build.PRODUCT);
        }
    }

    public static void logIsStreamMute(String str, AudioManager audioManager, int i2, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLIL(65555, null, str, audioManager, i2, sb) == null) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        sb.append(", muted=");
        sb.append(audioManager.isStreamMute(i2));
    }

    public static String modeToString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65556, null, i2)) == null) ? i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "MODE_INVALID" : "MODE_IN_COMMUNICATION" : "MODE_IN_CALL" : "MODE_RINGTONE" : "MODE_NORMAL" : (String) invokeI.objValue;
    }

    public static boolean runningOnEmulator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? Build.HARDWARE.equals("goldfish") && Build.BRAND.startsWith("generic_") : invokeV.booleanValue;
    }

    public static void setDefaultSampleRateHz(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65558, null, i2) == null) {
            synchronized (WebRtcAudioUtils.class) {
                isDefaultSampleRateOverridden = true;
                defaultSampleRateHz = i2;
            }
        }
    }

    public static void setWebRtcBasedAcousticEchoCanceler(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65559, null, z) == null) {
            synchronized (WebRtcAudioUtils.class) {
                useWebRtcBasedAcousticEchoCanceler = z;
            }
        }
    }

    public static void setWebRtcBasedAutomaticGainControl(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65560, null, z) == null) {
            synchronized (WebRtcAudioUtils.class) {
                Logging.w(TAG, "setWebRtcBasedAutomaticGainControl() is deprecated");
            }
        }
    }

    public static void setWebRtcBasedNoiseSuppressor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65561, null, z) == null) {
            synchronized (WebRtcAudioUtils.class) {
                useWebRtcBasedNoiseSuppressor = z;
            }
        }
    }

    public static String streamTypeToString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65562, null, i2)) == null) ? i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "STREAM_INVALID" : "STREAM_NOTIFICATION" : "STREAM_ALARM" : "STREAM_MUSIC" : "STREAM_RING" : "STREAM_SYSTEM" : "STREAM_VOICE_CALL" : (String) invokeI.objValue;
    }

    public static boolean useWebRtcBasedAcousticEchoCanceler() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            synchronized (WebRtcAudioUtils.class) {
                if (useWebRtcBasedAcousticEchoCanceler) {
                    Logging.w(TAG, "Overriding default behavior; now using WebRTC AEC!");
                }
                z = useWebRtcBasedAcousticEchoCanceler;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean useWebRtcBasedAutomaticGainControl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            synchronized (WebRtcAudioUtils.class) {
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean useWebRtcBasedNoiseSuppressor() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            synchronized (WebRtcAudioUtils.class) {
                if (useWebRtcBasedNoiseSuppressor) {
                    Logging.w(TAG, "Overriding default behavior; now using WebRTC NS!");
                }
                z = useWebRtcBasedNoiseSuppressor;
            }
            return z;
        }
        return invokeV.booleanValue;
    }
}
