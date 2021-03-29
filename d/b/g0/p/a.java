package d.b.g0.p;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public class a {
    public static int a() {
        DisplayMetrics c2 = c();
        if (c2 != null) {
            return c2.densityDpi;
        }
        return 0;
    }

    public static int b() {
        DisplayMetrics c2 = c();
        if (c2 != null) {
            return c2.heightPixels;
        }
        return 0;
    }

    public static DisplayMetrics c() {
        Context appContext = AppRuntime.getAppContext();
        if (appContext == null) {
            return null;
        }
        return appContext.getResources().getDisplayMetrics();
    }

    public static int d() {
        DisplayMetrics c2 = c();
        if (c2 != null) {
            return c2.widthPixels;
        }
        return 0;
    }

    public static String e() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) AppRuntime.getAppContext().getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return "no";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WiFi";
        }
        if (activeNetworkInfo.getType() == 0) {
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return "2G";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return com.baidu.apollon.statistics.g.f3874b;
                case 13:
                    return "4G";
                default:
                    return "unknown";
            }
        }
        return "unknown";
    }

    public static String f() {
        return "Android";
    }

    public static String g() {
        String str = Build.VERSION.RELEASE;
        return TextUtils.isEmpty(str) ? "0.0" : str.replace("_", "-");
    }
}
