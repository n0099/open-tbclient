package com.qq.e.comm.plugin.ad;

import android.content.Context;
import android.os.Build;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static final String f12191a = Build.BRAND;

    /* renamed from: b  reason: collision with root package name */
    public static final String f12192b = Build.DEVICE;
    public static final String c = Build.FINGERPRINT;
    public static final String d = Build.HARDWARE;
    public static final String e = Build.PRODUCT;
    public static final String f;

    static {
        String str = "";
        try {
            if (Build.VERSION.SDK_INT > 9) {
                str = Build.SERIAL;
            }
        } catch (Throwable th) {
        }
        f = str;
    }

    public static boolean a(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }
}
