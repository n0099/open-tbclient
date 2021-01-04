package com.xiaomi.push;

import android.content.Context;
/* loaded from: classes6.dex */
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
        byte[] m181a = bc.m181a(str);
        try {
            a(m181a);
            return h.a(m181a, bArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] b(String str, byte[] bArr) {
        byte[] m181a = bc.m181a(str);
        try {
            a(m181a);
            return h.b(m181a, bArr);
        } catch (Exception e) {
            return null;
        }
    }
}
