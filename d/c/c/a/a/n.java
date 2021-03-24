package d.c.c.a.a;
/* loaded from: classes4.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f65154a;

    /* renamed from: b  reason: collision with root package name */
    public int f65155b;

    /* renamed from: c  reason: collision with root package name */
    public int f65156c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65157d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f65158e;

    /* renamed from: f  reason: collision with root package name */
    public n f65159f;

    /* renamed from: g  reason: collision with root package name */
    public n f65160g;

    public n() {
        this.f65154a = new byte[8192];
        this.f65158e = true;
        this.f65157d = false;
    }

    public final n a() {
        this.f65157d = true;
        return new n(this.f65154a, this.f65155b, this.f65156c, true, false);
    }

    public final n b(int i) {
        n a2;
        if (i > 0 && i <= this.f65156c - this.f65155b) {
            if (i >= 1024) {
                a2 = a();
            } else {
                a2 = o.a();
                System.arraycopy(this.f65154a, this.f65155b, a2.f65154a, 0, i);
            }
            a2.f65156c = a2.f65155b + i;
            this.f65155b += i;
            this.f65160g.c(a2);
            return a2;
        }
        throw new IllegalArgumentException();
    }

    public final n c(n nVar) {
        nVar.f65160g = this;
        nVar.f65159f = this.f65159f;
        this.f65159f.f65160g = nVar;
        this.f65159f = nVar;
        return nVar;
    }

    public final void d(n nVar, int i) {
        if (nVar.f65158e) {
            int i2 = nVar.f65156c;
            if (i2 + i > 8192) {
                if (!nVar.f65157d) {
                    int i3 = nVar.f65155b;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = nVar.f65154a;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        nVar.f65156c -= nVar.f65155b;
                        nVar.f65155b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f65154a, this.f65155b, nVar.f65154a, nVar.f65156c, i);
            nVar.f65156c += i;
            this.f65155b += i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final n e() {
        n nVar = this.f65159f;
        if (nVar == this) {
            nVar = null;
        }
        n nVar2 = this.f65160g;
        nVar2.f65159f = this.f65159f;
        this.f65159f.f65160g = nVar2;
        this.f65159f = null;
        this.f65160g = null;
        return nVar;
    }

    public final void f() {
        n nVar = this.f65160g;
        if (nVar != this) {
            if (nVar.f65158e) {
                int i = this.f65156c - this.f65155b;
                if (i > (8192 - nVar.f65156c) + (nVar.f65157d ? 0 : nVar.f65155b)) {
                    return;
                }
                d(this.f65160g, i);
                e();
                o.b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public n(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f65154a = bArr;
        this.f65155b = i;
        this.f65156c = i2;
        this.f65157d = z;
        this.f65158e = z2;
    }
}
