package com.meizu.cloud.pushsdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* loaded from: classes2.dex */
public class a {
    public static NetworkInfo a(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static boolean b(Context context) {
        NetworkInfo a2 = a(context);
        return a2 != null && a2.isConnected() && a2.getType() == 1;
    }
}
