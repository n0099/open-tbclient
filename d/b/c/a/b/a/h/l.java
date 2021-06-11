package d.b.c.a.b.a.h;

import java.util.Arrays;
/* loaded from: classes6.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public int f69175a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f69176b = new int[10];

    public l a(int i2, int i3) {
        if (i2 >= 0) {
            int[] iArr = this.f69176b;
            if (i2 < iArr.length) {
                this.f69175a = (1 << i2) | this.f69175a;
                iArr[i2] = i3;
            }
        }
        return this;
    }

    public void b() {
        this.f69175a = 0;
        Arrays.fill(this.f69176b, 0);
    }

    public void c(l lVar) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (lVar.d(i2)) {
                a(i2, lVar.f(i2));
            }
        }
    }

    public boolean d(int i2) {
        return ((1 << i2) & this.f69175a) != 0;
    }

    public int e() {
        return Integer.bitCount(this.f69175a);
    }

    public int f(int i2) {
        return this.f69176b[i2];
    }

    public int g() {
        if ((this.f69175a & 2) != 0) {
            return this.f69176b[1];
        }
        return -1;
    }

    public int h(int i2) {
        return (this.f69175a & 16) != 0 ? this.f69176b[4] : i2;
    }

    public int i() {
        if ((this.f69175a & 128) != 0) {
            return this.f69176b[7];
        }
        return 65535;
    }

    public int j(int i2) {
        return (this.f69175a & 32) != 0 ? this.f69176b[5] : i2;
    }
}
