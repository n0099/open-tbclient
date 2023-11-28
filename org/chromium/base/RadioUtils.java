package org.chromium.base;

import android.annotation.TargetApi;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Process;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.kuaishou.weapon.p0.g;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
@JNINamespace("base::android")
/* loaded from: classes2.dex */
public class RadioUtils {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static Boolean sHaveAccessNetworkState;
    public static Boolean sHaveAccessWifiState;

    @TargetApi(28)
    @CalledByNative
    public static int getCellDataActivity() {
        try {
            return ((TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone")).getDataActivity();
        } catch (SecurityException unused) {
            return -1;
        }
    }

    @TargetApi(28)
    @CalledByNative
    public static int getCellSignalLevel() {
        try {
            SignalStrength signalStrength = ((TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone")).getSignalStrength();
            if (signalStrength == null) {
                return -1;
            }
            return signalStrength.getLevel();
        } catch (SecurityException unused) {
            return -1;
        }
    }

    public static boolean haveAccessNetworkState() {
        boolean z;
        if (sHaveAccessNetworkState == null) {
            if (ApiCompatibilityUtils.checkPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) == 0) {
                z = true;
            } else {
                z = false;
            }
            sHaveAccessNetworkState = Boolean.valueOf(z);
        }
        return sHaveAccessNetworkState.booleanValue();
    }

    public static boolean haveAccessWifiState() {
        boolean z;
        if (sHaveAccessWifiState == null) {
            if (ApiCompatibilityUtils.checkPermission(ContextUtils.getApplicationContext(), g.d, Process.myPid(), Process.myUid()) == 0) {
                z = true;
            } else {
                z = false;
            }
            sHaveAccessWifiState = Boolean.valueOf(z);
        }
        return sHaveAccessWifiState.booleanValue();
    }

    @CalledByNative
    public static boolean isSupported() {
        if (Build.VERSION.SDK_INT >= 28 && haveAccessNetworkState() && haveAccessWifiState()) {
            return true;
        }
        return false;
    }

    @TargetApi(28)
    @CalledByNative
    public static boolean isWifiConnected() {
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1);
    }
}
