package d.b.z.n;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class f {
    public static boolean a() {
        NetworkInfo c2 = c();
        return c2 != null && c2.isConnected();
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
                return "1";
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
                return "2";
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
        return "3";
    }

    public static NetworkInfo c() {
        ConnectivityManager connectivityManager;
        Context a2 = g.a();
        if (a2 == null || (connectivityManager = (ConnectivityManager) a2.getSystemService("connectivity")) == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    public static String d() {
        NetworkInfo c2 = c();
        return (c2 == null || !c2.isConnected()) ? "0" : c2.getType() == 1 ? "4" : c2.getType() == 0 ? b(c2.getSubtype(), c2.getSubtypeName()) : "unknown";
    }
}
