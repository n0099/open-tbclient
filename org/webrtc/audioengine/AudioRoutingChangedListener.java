package org.webrtc.audioengine;

import android.annotation.TargetApi;
import android.media.AudioDeviceInfo;
import android.media.AudioRouting;
import com.baidu.android.util.devices.RomUtils;
@TargetApi(24)
/* loaded from: classes6.dex */
public class AudioRoutingChangedListener implements AudioRouting.OnRoutingChangedListener {
    private static final String TAG = "[AudioRoutingChangedListener]";

    private String getDeviceTypeStr(int i) {
        switch (i) {
            case 1:
                return "BUILTIN_EARPIECE";
            case 2:
                return "BUILTIN_SPEAKER";
            case 3:
                return "WIRED_HEADSET";
            case 4:
                return "WIRED_HEADPHONES";
            case 5:
                return "LINE_ANALOG";
            case 6:
                return "LINE_DIGITAL";
            case 7:
                return "BLUETOOTH_SCO";
            case 8:
                return "BLUETOOTH_A2DP";
            case 9:
                return "HDMI";
            case 10:
                return "HDMI_ARC";
            case 11:
                return "USB_DEVICE";
            case 12:
                return "USB_ACCESSORY";
            case 13:
                return "DOCK";
            case 14:
                return "FM";
            case 15:
                return "BUILTIN_MIC";
            case 16:
                return "FM_TUNER";
            case 17:
                return "TV_TUNER";
            case 18:
                return "TELEPHONY";
            case 19:
                return "AUX_LINE";
            case 20:
                return "IP";
            case 21:
                return "BUS";
            case 22:
                return "USB_HEADSET";
            default:
                return RomUtils.UNKNOWN;
        }
    }

    @Override // android.media.AudioRouting.OnRoutingChangedListener
    public void onRoutingChanged(AudioRouting audioRouting) {
        AudioDeviceInfo routedDevice;
        if (audioRouting != null && (routedDevice = audioRouting.getRoutedDevice()) != null) {
            AudioManagerAndroid.doLog("[AudioRoutingChangedListener] on routing changed, routed device type: " + routedDevice.getType() + "(" + getDeviceTypeStr(routedDevice.getType()) + ")");
        }
    }
}
