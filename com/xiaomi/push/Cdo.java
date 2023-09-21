package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
/* renamed from: com.xiaomi.push.do  reason: invalid class name */
/* loaded from: classes10.dex */
public class Cdo {
    public static void a(byte[] bArr) {
        if (bArr.length >= 2) {
            bArr[0] = 99;
            bArr[1] = 100;
        }
    }

    public static boolean a(Context context, String str, long j) {
        if (com.xiaomi.push.service.ba.a(context).a(hm.DCJobMutualSwitch.a(), false)) {
            return (Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) && !ah.a(context, str, j);
        }
        return false;
    }

    public static byte[] a(String str, byte[] bArr) {
        byte[] m299a = bl.m299a(str);
        try {
            a(m299a);
            return h.a(m299a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(String str, byte[] bArr) {
        byte[] m299a = bl.m299a(str);
        try {
            a(m299a);
            return h.b(m299a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
