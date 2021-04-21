package d.b.n0.a.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import d.b.n0.a.e.f;
import d.b.n0.a.e.i;
/* loaded from: classes5.dex */
public final class a {
    public static boolean a(Context context, String str) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (!f.i() || i.f(context) == 1) {
                return b.c(b.b(str, "http://absample.baidu.com/appabapp/appapi/applog"), null);
            }
            return false;
        }
        return false;
    }
}
