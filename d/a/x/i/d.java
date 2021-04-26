package d.a.x.i;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* loaded from: classes2.dex */
public class d {
    public static NetworkInfo a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static boolean b(Context context) {
        NetworkInfo a2 = a(context);
        return a2 != null && a2.isAvailable() && a2.getType() == 1;
    }
}
