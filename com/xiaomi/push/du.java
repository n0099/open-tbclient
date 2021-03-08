package com.xiaomi.push;

import android.content.Context;
/* loaded from: classes5.dex */
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
        byte[] m166a = bc.m166a(str);
        try {
            a(m166a);
            return h.a(m166a, bArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] b(String str, byte[] bArr) {
        byte[] m166a = bc.m166a(str);
        try {
            a(m166a);
            return h.b(m166a, bArr);
        } catch (Exception e) {
            return null;
        }
    }
}
