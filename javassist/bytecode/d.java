package javassist.bytecode;
/* loaded from: classes.dex */
class d {
    byte[] f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(byte[] bArr) {
        this.f = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        a(this.f[0] & 255, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2) {
        for (int i3 = 0; i3 < i; i3++) {
            i2 = d(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        d(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int d(int i) {
        return b(i + 2, g.a(this.f, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            i = e(i);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int e(int i) {
        return a(i + 4, g.a(this.f, i), g.a(this.f, i + 2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            i = f(i);
        }
        return i;
    }

    final int f(int i) {
        return c(i + 2, g.a(this.f, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i, int i2) {
        return g(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int g(int i) {
        int i2 = this.f[i] & 255;
        if (i2 == 101) {
            b(i, g.a(this.f, i + 1), g.a(this.f, i + 3));
            return i + 5;
        } else if (i2 == 99) {
            e(i, g.a(this.f, i + 1));
            return i + 3;
        } else if (i2 == 64) {
            return a(i + 1);
        } else {
            if (i2 == 91) {
                return f(i + 3, g.a(this.f, i + 1));
            }
            d(i2, g.a(this.f, i + 1));
            return i + 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(int i, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i) {
        return e(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f(int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            i = g(i);
        }
        return i;
    }
}
