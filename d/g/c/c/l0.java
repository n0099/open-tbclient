package d.g.c.c;

import java.util.Arrays;
/* loaded from: classes6.dex */
public class l0<K> extends k0<K> {

    /* renamed from: i  reason: collision with root package name */
    public transient long[] f65563i;
    public transient int j;
    public transient int k;

    public l0(int i2) {
        this(i2, 1.0f);
    }

    public final int E(int i2) {
        return (int) (this.f65563i[i2] >>> 32);
    }

    public final int F(int i2) {
        return (int) this.f65563i[i2];
    }

    public final void G(int i2, int i3) {
        long[] jArr = this.f65563i;
        jArr[i2] = (jArr[i2] & 4294967295L) | (i3 << 32);
    }

    public final void H(int i2, int i3) {
        if (i2 == -2) {
            this.j = i3;
        } else {
            I(i2, i3);
        }
        if (i3 == -2) {
            this.k = i2;
        } else {
            G(i3, i2);
        }
    }

    public final void I(int i2, int i3) {
        long[] jArr = this.f65563i;
        jArr[i2] = (jArr[i2] & (-4294967296L)) | (i3 & 4294967295L);
    }

    @Override // d.g.c.c.k0
    public void a() {
        super.a();
        this.j = -2;
        this.k = -2;
    }

    @Override // d.g.c.c.k0
    public int e() {
        int i2 = this.j;
        if (i2 == -2) {
            return -1;
        }
        return i2;
    }

    @Override // d.g.c.c.k0
    public void n(int i2, float f2) {
        super.n(i2, f2);
        this.j = -2;
        this.k = -2;
        long[] jArr = new long[i2];
        this.f65563i = jArr;
        Arrays.fill(jArr, -1L);
    }

    @Override // d.g.c.c.k0
    public void o(int i2, K k, int i3, int i4) {
        super.o(i2, k, i3, i4);
        H(this.k, i2);
        H(i2, -2);
    }

    @Override // d.g.c.c.k0
    public void p(int i2) {
        int C = C() - 1;
        H(E(i2), F(i2));
        if (i2 < C) {
            H(E(C), i2);
            H(i2, F(C));
        }
        super.p(i2);
    }

    @Override // d.g.c.c.k0
    public int s(int i2) {
        int F = F(i2);
        if (F == -2) {
            return -1;
        }
        return F;
    }

    @Override // d.g.c.c.k0
    public int t(int i2, int i3) {
        return i2 == C() ? i3 : i2;
    }

    @Override // d.g.c.c.k0
    public void y(int i2) {
        super.y(i2);
        long[] jArr = this.f65563i;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i2);
        this.f65563i = copyOf;
        Arrays.fill(copyOf, length, i2, -1L);
    }

    public l0(int i2, float f2) {
        super(i2, f2);
    }
}
