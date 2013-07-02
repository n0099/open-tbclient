package com.mofamulu.tieba.ch;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.tieba.TiebaApplication;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class am {
    private static AtomicBoolean a = null;

    public static void a(Context context) {
        NetworkInfo[] allNetworkInfo;
        if (context == null) {
            context = TiebaApplication.f();
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
            for (int i = 0; i < allNetworkInfo.length; i++) {
                if (allNetworkInfo[i].getTypeName().equalsIgnoreCase("WIFI") && allNetworkInfo[i].isConnected()) {
                    a.set(true);
                    return;
                }
            }
        }
        a.set(false);
    }

    public static boolean a() {
        if (a == null) {
            a = new AtomicBoolean();
            a(null);
        }
        return a.get();
    }
}
