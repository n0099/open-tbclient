package com.qiniu.android.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* loaded from: classes5.dex */
public final class AndroidNetwork {
    public static boolean dHZ() {
        boolean z;
        Context dIa = ContextGetter.dIa();
        if (dIa == null) {
            return true;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) dIa.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    z = true;
                    return z;
                }
            }
            z = false;
            return z;
        } catch (Exception e) {
            return true;
        }
    }
}
