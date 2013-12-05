package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
/* loaded from: classes.dex */
final class a {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.zxing.common.a f2879a;
    private o b;
    private n c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.google.zxing.common.a aVar) {
        int d = aVar.d();
        if (d < 21 || (d & 3) != 1) {
            throw FormatException.getFormatInstance();
        }
        this.f2879a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n a() {
        int i = 0;
        if (this.c != null) {
            return this.c;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            i2 = a(i3, 8, i2);
        }
        int a2 = a(8, 7, a(8, 8, a(7, 8, i2)));
        for (int i4 = 5; i4 >= 0; i4--) {
            a2 = a(8, i4, a2);
        }
        int d = this.f2879a.d();
        int i5 = d - 7;
        for (int i6 = d - 1; i6 >= i5; i6--) {
            i = a(8, i6, i);
        }
        for (int i7 = d - 8; i7 < d; i7++) {
            i = a(i7, 8, i);
        }
        this.c = n.b(a2, i);
        if (this.c != null) {
            return this.c;
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o b() {
        if (this.b != null) {
            return this.b;
        }
        int d = this.f2879a.d();
        int i = (d - 17) >> 2;
        if (i <= 6) {
            return o.b(i);
        }
        int i2 = d - 11;
        int i3 = 0;
        for (int i4 = 5; i4 >= 0; i4--) {
            for (int i5 = d - 9; i5 >= i2; i5--) {
                i3 = a(i5, i4, i3);
            }
        }
        o c = o.c(i3);
        if (c != null && c.d() == d) {
            this.b = c;
            return c;
        }
        int i6 = 0;
        for (int i7 = 5; i7 >= 0; i7--) {
            for (int i8 = d - 9; i8 >= i2; i8--) {
                i6 = a(i7, i8, i6);
            }
        }
        o c2 = o.c(i6);
        if (c2 != null && c2.d() == d) {
            this.b = c2;
            return c2;
        }
        throw FormatException.getFormatInstance();
    }

    private int a(int i, int i2, int i3) {
        return this.f2879a.a(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] c() {
        n a2 = a();
        o b = b();
        c a3 = c.a(a2.b());
        int d = this.f2879a.d();
        a3.a(this.f2879a, d);
        com.google.zxing.common.a e = b.e();
        byte[] bArr = new byte[b.c()];
        int i = d - 1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = true;
        while (i > 0) {
            if (i == 6) {
                i--;
            }
            for (int i5 = 0; i5 < d; i5++) {
                int i6 = z ? (d - 1) - i5 : i5;
                for (int i7 = 0; i7 < 2; i7++) {
                    if (!e.a(i - i7, i6)) {
                        i2++;
                        i3 <<= 1;
                        if (this.f2879a.a(i - i7, i6)) {
                            i3 |= 1;
                        }
                        if (i2 == 8) {
                            bArr[i4] = (byte) i3;
                            i3 = 0;
                            i4++;
                            i2 = 0;
                        }
                    }
                }
            }
            i -= 2;
            z = !z;
        }
        if (i4 != b.c()) {
            throw FormatException.getFormatInstance();
        }
        return bArr;
    }
}
