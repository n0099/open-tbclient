package com.xiaomi.push;

import android.content.Context;
/* loaded from: classes8.dex */
public class du {
    private static void a(byte[] bArr) {
        if (bArr.length >= 2) {
            bArr[0] = 99;
            bArr[1] = 100;
        }
    }

    public static boolean a(Context context, String str, long j) {
        return com.xiaomi.push.service.ak.a(context).a(hr.DCJobMutualSwitch.a(), false) && !ag.a(context, str, j);
    }

    public static byte[] a(String str, byte[] bArr) {
        byte[] m156a = bc.m156a(str);
        try {
            a(m156a);
            return h.a(m156a, bArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] b(String str, byte[] bArr) {
        byte[] m156a = bc.m156a(str);
        try {
            a(m156a);
            return h.b(m156a, bArr);
        } catch (Exception e) {
            return null;
        }
    }
}
