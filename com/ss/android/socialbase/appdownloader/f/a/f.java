package com.ss.android.socialbase.appdownloader.f.a;

import java.io.IOException;
/* loaded from: classes7.dex */
public class f {
    public int[] a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f43085b;

    public static f a(d dVar) throws IOException {
        b.a(dVar, 1835009);
        int b2 = dVar.b();
        int b3 = dVar.b();
        int b4 = dVar.b();
        dVar.b();
        int b5 = dVar.b();
        int b6 = dVar.b();
        f fVar = new f();
        fVar.a = dVar.b(b3);
        if (b4 != 0) {
            dVar.b(b4);
        }
        int i = (b6 == 0 ? b2 : b6) - b5;
        if (i % 4 == 0) {
            fVar.f43085b = dVar.b(i / 4);
            if (b6 != 0) {
                int i2 = b2 - b6;
                if (i2 % 4 == 0) {
                    dVar.b(i2 / 4);
                } else {
                    throw new IOException("Style data size is not multiple of 4 (" + i2 + ").");
                }
            }
            return fVar;
        }
        throw new IOException("String data size is not multiple of 4 (" + i + ").");
    }

    public String a(int i) {
        int[] iArr;
        if (i < 0 || (iArr = this.a) == null || i >= iArr.length) {
            return null;
        }
        int i2 = iArr[i];
        int a = a(this.f43085b, i2);
        StringBuilder sb = new StringBuilder(a);
        while (a != 0) {
            i2 += 2;
            sb.append((char) a(this.f43085b, i2));
            a--;
        }
        return sb.toString();
    }

    public static final int a(int[] iArr, int i) {
        int i2 = iArr[i / 4];
        return (i % 4) / 2 == 0 ? i2 & 65535 : i2 >>> 16;
    }
}
