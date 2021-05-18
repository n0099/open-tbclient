package d.b.c.a.b.a.h;

import java.util.Arrays;
/* loaded from: classes6.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public int f65401a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f65402b = new int[10];

    public l a(int i2, int i3) {
        if (i2 >= 0) {
            int[] iArr = this.f65402b;
            if (i2 < iArr.length) {
                this.f65401a = (1 << i2) | this.f65401a;
                iArr[i2] = i3;
            }
        }
        return this;
    }

    public void b() {
        this.f65401a = 0;
        Arrays.fill(this.f65402b, 0);
    }

    public void c(l lVar) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (lVar.d(i2)) {
                a(i2, lVar.f(i2));
            }
        }
    }

    public boolean d(int i2) {
        return ((1 << i2) & this.f65401a) != 0;
    }

    public int e() {
        return Integer.bitCount(this.f65401a);
    }

    public int f(int i2) {
        return this.f65402b[i2];
    }

    public int g() {
        if ((this.f65401a & 2) != 0) {
            return this.f65402b[1];
        }
        return -1;
    }

    public int h(int i2) {
        return (this.f65401a & 16) != 0 ? this.f65402b[4] : i2;
    }

    public int i() {
        if ((this.f65401a & 128) != 0) {
            return this.f65402b[7];
        }
        return 65535;
    }

    public int j(int i2) {
        return (this.f65401a & 32) != 0 ? this.f65402b[5] : i2;
    }
}
