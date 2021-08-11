package org.webrtc.audio;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.util.Arrays;
import org.webrtc.Logging;
/* loaded from: classes2.dex */
public final class WebRtcAudioUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "WebRtcAudioUtilsExternal";
    public transient /* synthetic */ FieldHolder $fh;

    public WebRtcAudioUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String deviceTypeToString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
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

    public static String getThreadInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return "@[name=" + Thread.currentThread().getName() + ", id=" + Thread.currentThread().getId() + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    public static boolean hasMicrophone(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? context.getPackageManager().hasSystemFeature("android.hardware.microphone") : invokeL.booleanValue;
    }

    @TargetApi(23)
    public static void logAudioDeviceInfo(String str, AudioManager audioManager) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, audioManager) == null) && runningOnMarshmallowOrHigher()) {
            AudioDeviceInfo[] devices = audioManager.getDevices(3);
            if (devices.length != 0) {
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
        }
    }

    public static void logAudioState(String str, Context context, AudioManager audioManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, str, context, audioManager) == null) {
            logDeviceInfo(str);
            logAudioStateBasic(str, context, audioManager);
            logAudioStateVolume(str, audioManager);
            logAudioDeviceInfo(str, audioManager);
        }
    }

    public static void logAudioStateBasic(String str, Context context, AudioManager audioManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, str, context, audioManager) == null) {
            Logging.d(str, "Audio State: audio mode: " + modeToString(audioManager.getMode()) + ", has mic: " + hasMicrophone(context) + ", mic muted: " + audioManager.isMicrophoneMute() + ", music active: " + audioManager.isMusicActive() + ", speakerphone: " + audioManager.isSpeakerphoneOn() + ", BT SCO: " + audioManager.isBluetoothScoOn());
        }
    }

    @SuppressLint({"NewApi"})
    public static void logAudioStateVolume(String str, AudioManager audioManager) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, audioManager) == null) {
            int[] iArr = {0, 3, 2, 4, 5, 1};
            Logging.d(str, "Audio State: ");
            if (runningOnLollipopOrHigher()) {
                z = audioManager.isVolumeFixed();
                Logging.d(str, "  fixed volume=" + z);
            } else {
                z = false;
            }
            if (z) {
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
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            Logging.d(str, "Android SDK: " + Build.VERSION.SDK_INT + ", Release: " + Build.VERSION.RELEASE + ", Brand: " + Build.BRAND + ", Device: " + Build.DEVICE + ", Id: " + Build.ID + ", Hardware: " + Build.HARDWARE + ", Manufacturer: " + Build.MANUFACTURER + ", Model: " + Build.MODEL + ", Product: " + Build.PRODUCT);
        }
    }

    @TargetApi(23)
    public static void logIsStreamMute(String str, AudioManager audioManager, int i2, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLIL(65545, null, str, audioManager, i2, sb) == null) && runningOnMarshmallowOrHigher()) {
            sb.append(", muted=");
            sb.append(audioManager.isStreamMute(i2));
        }
    }

    public static String modeToString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) ? i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "MODE_INVALID" : "MODE_IN_COMMUNICATION" : "MODE_IN_CALL" : "MODE_RINGTONE" : "MODE_NORMAL" : (String) invokeI.objValue;
    }

    public static boolean runningOnEmulator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? Build.HARDWARE.equals("goldfish") && Build.BRAND.startsWith("generic_") : invokeV.booleanValue;
    }

    public static boolean runningOnJellyBeanMR1OrHigher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? Build.VERSION.SDK_INT >= 17 : invokeV.booleanValue;
    }

    public static boolean runningOnJellyBeanMR2OrHigher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? Build.VERSION.SDK_INT >= 18 : invokeV.booleanValue;
    }

    public static boolean runningOnLollipopOrHigher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? Build.VERSION.SDK_INT >= 21 : invokeV.booleanValue;
    }

    public static boolean runningOnMarshmallowOrHigher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? Build.VERSION.SDK_INT >= 23 : invokeV.booleanValue;
    }

    public static boolean runningOnNougatOrHigher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? Build.VERSION.SDK_INT >= 24 : invokeV.booleanValue;
    }

    public static boolean runningOnOreoMR1OrHigher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? Build.VERSION.SDK_INT >= 27 : invokeV.booleanValue;
    }

    public static boolean runningOnOreoOrHigher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? Build.VERSION.SDK_INT >= 26 : invokeV.booleanValue;
    }

    public static String streamTypeToString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65555, null, i2)) == null) ? i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "STREAM_INVALID" : "STREAM_NOTIFICATION" : "STREAM_ALARM" : "STREAM_MUSIC" : "STREAM_RING" : "STREAM_SYSTEM" : "STREAM_VOICE_CALL" : (String) invokeI.objValue;
    }
}
