package com.qiniu.android.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* loaded from: classes4.dex */
public final class AndroidNetwork {
    public static boolean dEV() {
        boolean z;
        Context dEW = ContextGetter.dEW();
        if (dEW == null) {
            return true;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) dEW.getSystemService("connectivity")).getActiveNetworkInfo();
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
