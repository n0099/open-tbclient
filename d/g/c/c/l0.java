package d.g.c.c;

import java.util.Arrays;
/* loaded from: classes6.dex */
public class l0<K> extends k0<K> {
    public transient long[] i;
    public transient int j;
    public transient int k;

    public l0(int i) {
        this(i, 1.0f);
    }

    public final int E(int i) {
        return (int) (this.i[i] >>> 32);
    }

    public final int F(int i) {
        return (int) this.i[i];
    }

    public final void G(int i, int i2) {
        long[] jArr = this.i;
        jArr[i] = (jArr[i] & 4294967295L) | (i2 << 32);
    }

    public final void H(int i, int i2) {
        if (i == -2) {
            this.j = i2;
        } else {
            I(i, i2);
        }
        if (i2 == -2) {
            this.k = i;
        } else {
            G(i2, i);
        }
    }

    public final void I(int i, int i2) {
        long[] jArr = this.i;
        jArr[i] = (jArr[i] & (-4294967296L)) | (i2 & 4294967295L);
    }

    @Override // d.g.c.c.k0
    public void a() {
        super.a();
        this.j = -2;
        this.k = -2;
    }

    @Override // d.g.c.c.k0
    public int e() {
        int i = this.j;
        if (i == -2) {
            return -1;
        }
        return i;
    }

    @Override // d.g.c.c.k0
    public void n(int i, float f2) {
        super.n(i, f2);
        this.j = -2;
        this.k = -2;
        long[] jArr = new long[i];
        this.i = jArr;
        Arrays.fill(jArr, -1L);
    }

    @Override // d.g.c.c.k0
    public void o(int i, K k, int i2, int i3) {
        super.o(i, k, i2, i3);
        H(this.k, i);
        H(i, -2);
    }

    @Override // d.g.c.c.k0
    public void p(int i) {
        int C = C() - 1;
        H(E(i), F(i));
        if (i < C) {
            H(E(C), i);
            H(i, F(C));
        }
        super.p(i);
    }

    @Override // d.g.c.c.k0
    public int s(int i) {
        int F = F(i);
        if (F == -2) {
            return -1;
        }
        return F;
    }

    @Override // d.g.c.c.k0
    public int t(int i, int i2) {
        return i == C() ? i2 : i;
    }

    @Override // d.g.c.c.k0
    public void y(int i) {
        super.y(i);
        long[] jArr = this.i;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        this.i = copyOf;
        Arrays.fill(copyOf, length, i, -1L);
    }

    public l0(int i, float f2) {
        super(i, f2);
    }
}
