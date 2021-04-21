package d.b.j0.r.a.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.advert.sdk.data.WirelessNetworkType;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
/* loaded from: classes4.dex */
public class d {
    public static String a(Context context) {
        String str;
        try {
            str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e2) {
            Log.i("error", e2.getMessage());
            str = "";
        }
        return (str == null || str.equals("")) ? "-" : str;
    }

    public static Integer b(Context context) {
        int value;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        Integer valueOf = Integer.valueOf(WirelessNetworkType.UNKNOWN_NETWORK.getValue());
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            String typeName = activeNetworkInfo.getTypeName();
            if (typeName.equalsIgnoreCase(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING)) {
                return Integer.valueOf(WirelessNetworkType.WIFI.getValue());
            }
            if (typeName.equalsIgnoreCase("MOBILE")) {
                if (TextUtils.isEmpty(Proxy.getDefaultHost())) {
                    value = (g(context) ? WirelessNetworkType.MOBILE_3G : WirelessNetworkType.MOBILE_2G).getValue();
                } else {
                    value = WirelessNetworkType.NETWORKTYPE_WAP.getValue();
                }
                return Integer.valueOf(value);
            }
            return valueOf;
        }
        return Integer.valueOf(WirelessNetworkType.UNKNOWN_NETWORK.getValue());
    }

    public static String c() {
        return Build.MODEL;
    }

    public static String d() {
        return Build.VERSION.RELEASE;
    }

    public static Integer e(Context context) {
        return Integer.valueOf(context.getResources().getDisplayMetrics().heightPixels);
    }

    public static Integer f(Context context) {
        return Integer.valueOf(context.getResources().getDisplayMetrics().widthPixels);
    }

    public static boolean g(Context context) {
        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
            case 15:
                return true;
            case 4:
            case 7:
            case 11:
            default:
                return false;
        }
    }
}
