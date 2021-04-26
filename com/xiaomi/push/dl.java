package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
/* loaded from: classes7.dex */
public class dl {
    public static void a(byte[] bArr) {
        if (bArr.length >= 2) {
            bArr[0] = 99;
            bArr[1] = 100;
        }
    }

    public static boolean a(Context context, String str, long j) {
        if (com.xiaomi.push.service.aq.a(context).a(hk.DCJobMutualSwitch.a(), false)) {
            return (Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) && !ag.a(context, str, j);
        }
        return false;
    }

    public static byte[] a(String str, byte[] bArr) {
        byte[] m168a = bj.m168a(str);
        try {
            a(m168a);
            return h.a(m168a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(String str, byte[] bArr) {
        byte[] m168a = bj.m168a(str);
        try {
            a(m168a);
            return h.b(m168a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
