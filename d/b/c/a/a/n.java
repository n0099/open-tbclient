package d.b.c.a.a;
/* loaded from: classes6.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f69023a;

    /* renamed from: b  reason: collision with root package name */
    public int f69024b;

    /* renamed from: c  reason: collision with root package name */
    public int f69025c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f69026d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f69027e;

    /* renamed from: f  reason: collision with root package name */
    public n f69028f;

    /* renamed from: g  reason: collision with root package name */
    public n f69029g;

    public n() {
        this.f69023a = new byte[8192];
        this.f69027e = true;
        this.f69026d = false;
    }

    public final n a() {
        this.f69026d = true;
        return new n(this.f69023a, this.f69024b, this.f69025c, true, false);
    }

    public final n b(int i2) {
        n a2;
        if (i2 > 0 && i2 <= this.f69025c - this.f69024b) {
            if (i2 >= 1024) {
                a2 = a();
            } else {
                a2 = o.a();
                System.arraycopy(this.f69023a, this.f69024b, a2.f69023a, 0, i2);
            }
            a2.f69025c = a2.f69024b + i2;
            this.f69024b += i2;
            this.f69029g.c(a2);
            return a2;
        }
        throw new IllegalArgumentException();
    }

    public final n c(n nVar) {
        nVar.f69029g = this;
        nVar.f69028f = this.f69028f;
        this.f69028f.f69029g = nVar;
        this.f69028f = nVar;
        return nVar;
    }

    public final void d(n nVar, int i2) {
        if (nVar.f69027e) {
            int i3 = nVar.f69025c;
            if (i3 + i2 > 8192) {
                if (!nVar.f69026d) {
                    int i4 = nVar.f69024b;
                    if ((i3 + i2) - i4 <= 8192) {
                        byte[] bArr = nVar.f69023a;
                        System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
                        nVar.f69025c -= nVar.f69024b;
                        nVar.f69024b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f69023a, this.f69024b, nVar.f69023a, nVar.f69025c, i2);
            nVar.f69025c += i2;
            this.f69024b += i2;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final n e() {
        n nVar = this.f69028f;
        if (nVar == this) {
            nVar = null;
        }
        n nVar2 = this.f69029g;
        nVar2.f69028f = this.f69028f;
        this.f69028f.f69029g = nVar2;
        this.f69028f = null;
        this.f69029g = null;
        return nVar;
    }

    public final void f() {
        n nVar = this.f69029g;
        if (nVar != this) {
            if (nVar.f69027e) {
                int i2 = this.f69025c - this.f69024b;
                if (i2 > (8192 - nVar.f69025c) + (nVar.f69026d ? 0 : nVar.f69024b)) {
                    return;
                }
                d(this.f69029g, i2);
                e();
                o.b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public n(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        this.f69023a = bArr;
        this.f69024b = i2;
        this.f69025c = i3;
        this.f69026d = z;
        this.f69027e = z2;
    }
}
