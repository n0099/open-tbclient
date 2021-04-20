package d.c.c.a.a;
/* loaded from: classes5.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f66000a;

    /* renamed from: b  reason: collision with root package name */
    public int f66001b;

    /* renamed from: c  reason: collision with root package name */
    public int f66002c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66003d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66004e;

    /* renamed from: f  reason: collision with root package name */
    public n f66005f;

    /* renamed from: g  reason: collision with root package name */
    public n f66006g;

    public n() {
        this.f66000a = new byte[8192];
        this.f66004e = true;
        this.f66003d = false;
    }

    public final n a() {
        this.f66003d = true;
        return new n(this.f66000a, this.f66001b, this.f66002c, true, false);
    }

    public final n b(int i) {
        n a2;
        if (i > 0 && i <= this.f66002c - this.f66001b) {
            if (i >= 1024) {
                a2 = a();
            } else {
                a2 = o.a();
                System.arraycopy(this.f66000a, this.f66001b, a2.f66000a, 0, i);
            }
            a2.f66002c = a2.f66001b + i;
            this.f66001b += i;
            this.f66006g.c(a2);
            return a2;
        }
        throw new IllegalArgumentException();
    }

    public final n c(n nVar) {
        nVar.f66006g = this;
        nVar.f66005f = this.f66005f;
        this.f66005f.f66006g = nVar;
        this.f66005f = nVar;
        return nVar;
    }

    public final void d(n nVar, int i) {
        if (nVar.f66004e) {
            int i2 = nVar.f66002c;
            if (i2 + i > 8192) {
                if (!nVar.f66003d) {
                    int i3 = nVar.f66001b;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = nVar.f66000a;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        nVar.f66002c -= nVar.f66001b;
                        nVar.f66001b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f66000a, this.f66001b, nVar.f66000a, nVar.f66002c, i);
            nVar.f66002c += i;
            this.f66001b += i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final n e() {
        n nVar = this.f66005f;
        if (nVar == this) {
            nVar = null;
        }
        n nVar2 = this.f66006g;
        nVar2.f66005f = this.f66005f;
        this.f66005f.f66006g = nVar2;
        this.f66005f = null;
        this.f66006g = null;
        return nVar;
    }

    public final void f() {
        n nVar = this.f66006g;
        if (nVar != this) {
            if (nVar.f66004e) {
                int i = this.f66002c - this.f66001b;
                if (i > (8192 - nVar.f66002c) + (nVar.f66003d ? 0 : nVar.f66001b)) {
                    return;
                }
                d(this.f66006g, i);
                e();
                o.b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public n(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f66000a = bArr;
        this.f66001b = i;
        this.f66002c = i2;
        this.f66003d = z;
        this.f66004e = z2;
    }
}
