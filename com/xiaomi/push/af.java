package com.xiaomi.push;

import android.content.Context;
/* loaded from: classes7.dex */
public class af {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f41078a = "0123456789ABCDEF".toCharArray();

    public static String a(byte[] bArr, int i2, int i3) {
        StringBuilder sb = new StringBuilder(i3 * 2);
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = bArr[i2 + i4] & 255;
            sb.append(f41078a[i5 >> 4]);
            sb.append(f41078a[i5 & 15]);
        }
        return sb.toString();
    }

    public static boolean a(Context context) {
        return ae.f102a;
    }
}
