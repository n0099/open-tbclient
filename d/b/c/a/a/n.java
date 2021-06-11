package d.b.c.a.a;
/* loaded from: classes6.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f68919a;

    /* renamed from: b  reason: collision with root package name */
    public int f68920b;

    /* renamed from: c  reason: collision with root package name */
    public int f68921c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f68922d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f68923e;

    /* renamed from: f  reason: collision with root package name */
    public n f68924f;

    /* renamed from: g  reason: collision with root package name */
    public n f68925g;

    public n() {
        this.f68919a = new byte[8192];
        this.f68923e = true;
        this.f68922d = false;
    }

    public final n a() {
        this.f68922d = true;
        return new n(this.f68919a, this.f68920b, this.f68921c, true, false);
    }

    public final n b(int i2) {
        n a2;
        if (i2 > 0 && i2 <= this.f68921c - this.f68920b) {
            if (i2 >= 1024) {
                a2 = a();
            } else {
                a2 = o.a();
                System.arraycopy(this.f68919a, this.f68920b, a2.f68919a, 0, i2);
            }
            a2.f68921c = a2.f68920b + i2;
            this.f68920b += i2;
            this.f68925g.c(a2);
            return a2;
        }
        throw new IllegalArgumentException();
    }

    public final n c(n nVar) {
        nVar.f68925g = this;
        nVar.f68924f = this.f68924f;
        this.f68924f.f68925g = nVar;
        this.f68924f = nVar;
        return nVar;
    }

    public final void d(n nVar, int i2) {
        if (nVar.f68923e) {
            int i3 = nVar.f68921c;
            if (i3 + i2 > 8192) {
                if (!nVar.f68922d) {
                    int i4 = nVar.f68920b;
                    if ((i3 + i2) - i4 <= 8192) {
                        byte[] bArr = nVar.f68919a;
                        System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
                        nVar.f68921c -= nVar.f68920b;
                        nVar.f68920b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f68919a, this.f68920b, nVar.f68919a, nVar.f68921c, i2);
            nVar.f68921c += i2;
            this.f68920b += i2;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final n e() {
        n nVar = this.f68924f;
        if (nVar == this) {
            nVar = null;
        }
        n nVar2 = this.f68925g;
        nVar2.f68924f = this.f68924f;
        this.f68924f.f68925g = nVar2;
        this.f68924f = null;
        this.f68925g = null;
        return nVar;
    }

    public final void f() {
        n nVar = this.f68925g;
        if (nVar != this) {
            if (nVar.f68923e) {
                int i2 = this.f68921c - this.f68920b;
                if (i2 > (8192 - nVar.f68921c) + (nVar.f68922d ? 0 : nVar.f68920b)) {
                    return;
                }
                d(this.f68925g, i2);
                e();
                o.b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public n(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        this.f68919a = bArr;
        this.f68920b = i2;
        this.f68921c = i3;
        this.f68922d = z;
        this.f68923e = z2;
    }
}
