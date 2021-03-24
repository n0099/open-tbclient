package d.b.g0.o;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public class a {
    public static NetworkInfo a(Context context) {
        ConnectivityManager connectivityManager;
        Context appContext = AppRuntime.getAppContext();
        if (appContext == null || (connectivityManager = (ConnectivityManager) appContext.getSystemService("connectivity")) == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String b(int i, String str) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return "2g";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return "3g";
            case 13:
            case 18:
            case 19:
                break;
            default:
                if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("LTE_CA")) {
                    return "unknown";
                }
                break;
        }
        return "4g";
    }

    public static String c() {
        NetworkInfo a2 = a(AppRuntime.getAppContext());
        return (a2 == null || !a2.isConnected()) ? "no" : a2.getType() == 1 ? "wifi" : a2.getType() == 0 ? b(a2.getSubtype(), a2.getSubtypeName()) : "unknown";
    }
}
