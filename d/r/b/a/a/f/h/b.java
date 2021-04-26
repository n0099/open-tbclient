package d.r.b.a.a.f.h;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes7.dex */
public class b {
    public static NetworkInfo a(Context context) {
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    return connectivityManager.getActiveNetworkInfo();
                }
                return null;
            } catch (Throwable th) {
                d.r.b.a.a.f.d.d.e("NetworkUtils", "error on getActiveNetworkInfo " + th, new Object[0]);
                return null;
            }
        }
        return null;
    }

    public static boolean b(Context context) {
        String str;
        try {
            if (context == null) {
                d.r.b.a.a.f.d.d.e("NetworkUtil", "isNetworkStrictlyAvailable context is NULL", new Object[0]);
                return false;
            }
            NetworkInfo a2 = a(context);
            if (a2 != null && a2.isAvailable() && a2.isConnected()) {
                return true;
            }
            if (a2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("network type = ");
                sb.append(a2.getType());
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(a2.isAvailable() ? "available" : "inavailable");
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                String str2 = "";
                sb.append(a2.isConnected() ? "" : "not");
                sb.append(" connected, ");
                if (!a2.isConnectedOrConnecting()) {
                    str2 = "not";
                }
                sb.append(str2);
                sb.append(" isConnectedOrConnecting");
                str = sb.toString();
            } else {
                str = "no active network";
            }
            d.r.b.a.a.f.d.d.e("NetworkUtil", "isNetworkStrictlyAvailable network info" + str, new Object[0]);
            return false;
        } catch (Throwable th) {
            d.r.b.a.a.f.d.d.e("NetworkUtils", th.getLocalizedMessage(), new Object[0]);
            return false;
        }
    }
}
