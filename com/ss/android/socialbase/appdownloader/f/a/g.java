package com.ss.android.socialbase.appdownloader.f.a;

import androidx.core.internal.view.SupportMenu;
import java.io.IOException;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private int[] f13346a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f13347b;

    public static g a(d dVar) throws IOException {
        b.a(dVar, 1835009);
        int b2 = dVar.b();
        int b3 = dVar.b();
        int b4 = dVar.b();
        dVar.b();
        int b5 = dVar.b();
        int b6 = dVar.b();
        g gVar = new g();
        gVar.f13346a = dVar.b(b3);
        if (b4 != 0) {
            dVar.b(b4);
        }
        int i = (b6 == 0 ? b2 : b6) - b5;
        if (i % 4 != 0) {
            throw new IOException("String data size is not multiple of 4 (" + i + ").");
        }
        gVar.f13347b = dVar.b(i / 4);
        if (b6 != 0) {
            int i2 = b2 - b6;
            if (i2 % 4 != 0) {
                throw new IOException("Style data size is not multiple of 4 (" + i2 + ").");
            }
            dVar.b(i2 / 4);
        }
        return gVar;
    }

    public String a(int i) {
        if (i < 0 || this.f13346a == null || i >= this.f13346a.length) {
            return null;
        }
        int i2 = this.f13346a[i];
        int c = c(this.f13347b, i2);
        StringBuilder sb = new StringBuilder(c);
        while (c != 0) {
            i2 += 2;
            sb.append((char) c(this.f13347b, i2));
            c--;
        }
        return sb.toString();
    }

    private g() {
    }

    private static final int c(int[] iArr, int i) {
        int i2 = iArr[i / 4];
        return (i % 4) / 2 == 0 ? i2 & SupportMenu.USER_MASK : i2 >>> 16;
    }
}
