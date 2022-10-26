package com.ss.android.socialbase.appdownloader.f.a;

import java.io.IOException;
/* loaded from: classes8.dex */
public class f {
    public int[] a;
    public int[] b;

    public static final int a(int[] iArr, int i) {
        int i2 = iArr[i / 4];
        if ((i % 4) / 2 == 0) {
            return i2 & 65535;
        }
        return i2 >>> 16;
    }

    public static f a(d dVar) throws IOException {
        int i;
        b.a(dVar, 1835009);
        int b = dVar.b();
        int b2 = dVar.b();
        int b3 = dVar.b();
        dVar.b();
        int b4 = dVar.b();
        int b5 = dVar.b();
        f fVar = new f();
        fVar.a = dVar.b(b2);
        if (b3 != 0) {
            dVar.b(b3);
        }
        if (b5 == 0) {
            i = b;
        } else {
            i = b5;
        }
        int i2 = i - b4;
        if (i2 % 4 == 0) {
            fVar.b = dVar.b(i2 / 4);
            if (b5 != 0) {
                int i3 = b - b5;
                if (i3 % 4 == 0) {
                    dVar.b(i3 / 4);
                } else {
                    throw new IOException("Style data size is not multiple of 4 (" + i3 + ").");
                }
            }
            return fVar;
        }
        throw new IOException("String data size is not multiple of 4 (" + i2 + ").");
    }

    public String a(int i) {
        int[] iArr;
        if (i >= 0 && (iArr = this.a) != null && i < iArr.length) {
            int i2 = iArr[i];
            int a = a(this.b, i2);
            StringBuilder sb = new StringBuilder(a);
            while (a != 0) {
                i2 += 2;
                sb.append((char) a(this.b, i2));
                a--;
            }
            return sb.toString();
        }
        return null;
    }
}
