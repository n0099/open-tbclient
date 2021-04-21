package d.c.c.a.a;
/* loaded from: classes5.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f66095a;

    /* renamed from: b  reason: collision with root package name */
    public int f66096b;

    /* renamed from: c  reason: collision with root package name */
    public int f66097c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66098d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66099e;

    /* renamed from: f  reason: collision with root package name */
    public n f66100f;

    /* renamed from: g  reason: collision with root package name */
    public n f66101g;

    public n() {
        this.f66095a = new byte[8192];
        this.f66099e = true;
        this.f66098d = false;
    }

    public final n a() {
        this.f66098d = true;
        return new n(this.f66095a, this.f66096b, this.f66097c, true, false);
    }

    public final n b(int i) {
        n a2;
        if (i > 0 && i <= this.f66097c - this.f66096b) {
            if (i >= 1024) {
                a2 = a();
            } else {
                a2 = o.a();
                System.arraycopy(this.f66095a, this.f66096b, a2.f66095a, 0, i);
            }
            a2.f66097c = a2.f66096b + i;
            this.f66096b += i;
            this.f66101g.c(a2);
            return a2;
        }
        throw new IllegalArgumentException();
    }

    public final n c(n nVar) {
        nVar.f66101g = this;
        nVar.f66100f = this.f66100f;
        this.f66100f.f66101g = nVar;
        this.f66100f = nVar;
        return nVar;
    }

    public final void d(n nVar, int i) {
        if (nVar.f66099e) {
            int i2 = nVar.f66097c;
            if (i2 + i > 8192) {
                if (!nVar.f66098d) {
                    int i3 = nVar.f66096b;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = nVar.f66095a;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        nVar.f66097c -= nVar.f66096b;
                        nVar.f66096b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f66095a, this.f66096b, nVar.f66095a, nVar.f66097c, i);
            nVar.f66097c += i;
            this.f66096b += i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final n e() {
        n nVar = this.f66100f;
        if (nVar == this) {
            nVar = null;
        }
        n nVar2 = this.f66101g;
        nVar2.f66100f = this.f66100f;
        this.f66100f.f66101g = nVar2;
        this.f66100f = null;
        this.f66101g = null;
        return nVar;
    }

    public final void f() {
        n nVar = this.f66101g;
        if (nVar != this) {
            if (nVar.f66099e) {
                int i = this.f66097c - this.f66096b;
                if (i > (8192 - nVar.f66097c) + (nVar.f66098d ? 0 : nVar.f66096b)) {
                    return;
                }
                d(this.f66101g, i);
                e();
                o.b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public n(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f66095a = bArr;
        this.f66096b = i;
        this.f66097c = i2;
        this.f66098d = z;
        this.f66099e = z2;
    }
}
