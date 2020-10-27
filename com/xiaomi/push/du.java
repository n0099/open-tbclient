package com.xiaomi.push;

import android.content.Context;
/* loaded from: classes12.dex */
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
        byte[] m162a = bc.m162a(str);
        try {
            a(m162a);
            return h.a(m162a, bArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] b(String str, byte[] bArr) {
        byte[] m162a = bc.m162a(str);
        try {
            a(m162a);
            return h.b(m162a, bArr);
        } catch (Exception e) {
            return null;
        }
    }
}
