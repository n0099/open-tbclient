package com.sdk.base.framework.f.h;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13144a = a.class.getName();

    /* renamed from: b  reason: collision with root package name */
    private static final Boolean f13145b = Boolean.valueOf(com.sdk.base.framework.c.f.f13119b);

    public static c a(Context context, ArrayList<String> arrayList, boolean z) {
        c cVar;
        NetworkInfo activeNetworkInfo;
        c cVar2 = c.c;
        if (context == null) {
            return cVar2;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (z && a(context, arrayList)) {
                NetworkInfo.State state = connectivityManager.getNetworkInfo(2).getState();
                NetworkInfo.State state2 = connectivityManager.getNetworkInfo(0).getState();
                if (state.compareTo(NetworkInfo.State.CONNECTED) == 0 || state2.compareTo(NetworkInfo.State.CONNECTED) == 0) {
                    return c.f13147b;
                }
            }
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th) {
            com.sdk.base.framework.a.a.c.b(f13144a, th.getMessage(), f13145b);
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            String typeName = activeNetworkInfo.getTypeName();
            if ("MOBILE".equalsIgnoreCase(typeName)) {
                cVar = c.f13147b;
            } else if ("WIFI".equalsIgnoreCase(typeName)) {
                cVar = c.f13146a;
            }
            return cVar;
        }
        cVar = cVar2;
        return cVar;
    }

    private static ArrayList<Integer> a(ArrayList<String> arrayList) {
        Throwable th;
        ArrayList<Integer> arrayList2 = null;
        if (arrayList == null) {
            return null;
        }
        try {
            if (arrayList.size() > 0) {
                ArrayList<Integer> arrayList3 = new ArrayList<>();
                for (int i = 0; i < arrayList.size(); i++) {
                    try {
                        byte[] address = InetAddress.getByName(new URL(arrayList.get(i)).getHost()).getAddress();
                        arrayList3.add(Integer.valueOf((address[0] & 255) | ((address[3] & 255) << 24) | ((address[2] & 255) << 16) | ((address[1] & 255) << 8)));
                    } catch (Throwable th2) {
                        th = th2;
                        arrayList2 = arrayList3;
                        com.sdk.base.framework.a.a.c.b(f13144a, th.getMessage(), f13145b);
                        return arrayList2;
                    }
                }
                return arrayList3;
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (Build.VERSION.SDK_INT < 21) {
                NetworkInfo.State state = connectivityManager.getNetworkInfo(2).getState();
                if (state.compareTo(NetworkInfo.State.CONNECTED) == 0 || state.compareTo(NetworkInfo.State.CONNECTING) == 0) {
                    connectivityManager.stopUsingNetworkFeature(0, "enableMMS");
                }
            }
        } catch (Throwable th) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(Context context, ArrayList<String> arrayList) {
        Throwable th;
        boolean z;
        ConnectivityManager connectivityManager;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
        if (connectivityManager == null) {
            com.sdk.base.framework.a.a.c.a(f13144a, "ConnectivityManager 为null", f13145b);
            return false;
        }
        NetworkInfo.State state = connectivityManager.getNetworkInfo(0).getState();
        if (state.compareTo(NetworkInfo.State.CONNECTED) == 0 || state.compareTo(NetworkInfo.State.CONNECTING) == 0) {
            return true;
        }
        connectivityManager.startUsingNetworkFeature(0, "enableMMS");
        ArrayList<Integer> a2 = a(arrayList);
        for (int i = 0; i < 5 && connectivityManager.getNetworkInfo(2).getState().compareTo(NetworkInfo.State.CONNECTED) != 0; i++) {
            Thread.sleep(500L);
        }
        if (a2 == null || a2.size() <= 0) {
            z = false;
        } else {
            boolean z2 = false;
            for (int i2 = 0; i2 < a2.size(); i2++) {
                try {
                    z2 = connectivityManager.requestRouteToHost(2, a2.get(i2).intValue());
                } catch (Throwable th3) {
                    th = th3;
                    z = z2;
                    com.sdk.base.framework.a.a.c.b(f13144a, th.getMessage(), f13145b);
                    boolean z3 = com.sdk.base.framework.c.f.f;
                    if (!z) {
                    }
                    return z;
                }
            }
            z = z2;
        }
        boolean z32 = com.sdk.base.framework.c.f.f;
        if (!z) {
            a(context);
        }
        return z;
    }
}
