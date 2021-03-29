package d.c.c.a.b.a.h;

import java.util.Arrays;
/* loaded from: classes5.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public int f65390a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f65391b = new int[10];

    public l a(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.f65391b;
            if (i < iArr.length) {
                this.f65390a = (1 << i) | this.f65390a;
                iArr[i] = i2;
            }
        }
        return this;
    }

    public void b() {
        this.f65390a = 0;
        Arrays.fill(this.f65391b, 0);
    }

    public void c(l lVar) {
        for (int i = 0; i < 10; i++) {
            if (lVar.d(i)) {
                a(i, lVar.f(i));
            }
        }
    }

    public boolean d(int i) {
        return ((1 << i) & this.f65390a) != 0;
    }

    public int e() {
        return Integer.bitCount(this.f65390a);
    }

    public int f(int i) {
        return this.f65391b[i];
    }

    public int g() {
        if ((this.f65390a & 2) != 0) {
            return this.f65391b[1];
        }
        return -1;
    }

    public int h(int i) {
        return (this.f65390a & 16) != 0 ? this.f65391b[4] : i;
    }

    public int i() {
        if ((this.f65390a & 128) != 0) {
            return this.f65391b[7];
        }
        return 65535;
    }

    public int j(int i) {
        return (this.f65390a & 32) != 0 ? this.f65391b[5] : i;
    }
}
