package d.c.c.a.b.a.h;

import java.util.Arrays;
/* loaded from: classes5.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public int f65389a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f65390b = new int[10];

    public l a(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.f65390b;
            if (i < iArr.length) {
                this.f65389a = (1 << i) | this.f65389a;
                iArr[i] = i2;
            }
        }
        return this;
    }

    public void b() {
        this.f65389a = 0;
        Arrays.fill(this.f65390b, 0);
    }

    public void c(l lVar) {
        for (int i = 0; i < 10; i++) {
            if (lVar.d(i)) {
                a(i, lVar.f(i));
            }
        }
    }

    public boolean d(int i) {
        return ((1 << i) & this.f65389a) != 0;
    }

    public int e() {
        return Integer.bitCount(this.f65389a);
    }

    public int f(int i) {
        return this.f65390b[i];
    }

    public int g() {
        if ((this.f65389a & 2) != 0) {
            return this.f65390b[1];
        }
        return -1;
    }

    public int h(int i) {
        return (this.f65389a & 16) != 0 ? this.f65390b[4] : i;
    }

    public int i() {
        if ((this.f65389a & 128) != 0) {
            return this.f65390b[7];
        }
        return 65535;
    }

    public int j(int i) {
        return (this.f65389a & 32) != 0 ? this.f65390b[5] : i;
    }
}
