package com.qiniu.android.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* loaded from: classes6.dex */
public final class AndroidNetwork {
    public static boolean ecw() {
        boolean z;
        Context ecx = ContextGetter.ecx();
        if (ecx == null) {
            return true;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) ecx.getSystemService("connectivity")).getActiveNetworkInfo();
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
