package com.ss.android.socialbase.appdownloader.f.a;

import java.io.IOException;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private int[] f7765a;
    private int[] b;

    public static g a(d dVar) throws IOException {
        b.a(dVar, 1835009);
        int b = dVar.b();
        int b2 = dVar.b();
        int b3 = dVar.b();
        dVar.b();
        int b4 = dVar.b();
        int b5 = dVar.b();
        g gVar = new g();
        gVar.f7765a = dVar.b(b2);
        if (b3 != 0) {
            dVar.b(b3);
        }
        int i = (b5 == 0 ? b : b5) - b4;
        if (i % 4 != 0) {
            throw new IOException("String data size is not multiple of 4 (" + i + ").");
        }
        gVar.b = dVar.b(i / 4);
        if (b5 != 0) {
            int i2 = b - b5;
            if (i2 % 4 != 0) {
                throw new IOException("Style data size is not multiple of 4 (" + i2 + ").");
            }
            dVar.b(i2 / 4);
        }
        return gVar;
    }

    public String a(int i) {
        if (i < 0 || this.f7765a == null || i >= this.f7765a.length) {
            return null;
        }
        int i2 = this.f7765a[i];
        int c = c(this.b, i2);
        StringBuilder sb = new StringBuilder(c);
        while (c != 0) {
            i2 += 2;
            sb.append((char) c(this.b, i2));
            c--;
        }
        return sb.toString();
    }

    private g() {
    }

    private static final int c(int[] iArr, int i) {
        int i2 = iArr[i / 4];
        return (i % 4) / 2 == 0 ? i2 & 65535 : i2 >>> 16;
    }
}
