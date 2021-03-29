package d.c.c.a.a;
/* loaded from: classes5.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f65155a;

    /* renamed from: b  reason: collision with root package name */
    public int f65156b;

    /* renamed from: c  reason: collision with root package name */
    public int f65157c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65158d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f65159e;

    /* renamed from: f  reason: collision with root package name */
    public n f65160f;

    /* renamed from: g  reason: collision with root package name */
    public n f65161g;

    public n() {
        this.f65155a = new byte[8192];
        this.f65159e = true;
        this.f65158d = false;
    }

    public final n a() {
        this.f65158d = true;
        return new n(this.f65155a, this.f65156b, this.f65157c, true, false);
    }

    public final n b(int i) {
        n a2;
        if (i > 0 && i <= this.f65157c - this.f65156b) {
            if (i >= 1024) {
                a2 = a();
            } else {
                a2 = o.a();
                System.arraycopy(this.f65155a, this.f65156b, a2.f65155a, 0, i);
            }
            a2.f65157c = a2.f65156b + i;
            this.f65156b += i;
            this.f65161g.c(a2);
            return a2;
        }
        throw new IllegalArgumentException();
    }

    public final n c(n nVar) {
        nVar.f65161g = this;
        nVar.f65160f = this.f65160f;
        this.f65160f.f65161g = nVar;
        this.f65160f = nVar;
        return nVar;
    }

    public final void d(n nVar, int i) {
        if (nVar.f65159e) {
            int i2 = nVar.f65157c;
            if (i2 + i > 8192) {
                if (!nVar.f65158d) {
                    int i3 = nVar.f65156b;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = nVar.f65155a;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        nVar.f65157c -= nVar.f65156b;
                        nVar.f65156b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f65155a, this.f65156b, nVar.f65155a, nVar.f65157c, i);
            nVar.f65157c += i;
            this.f65156b += i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final n e() {
        n nVar = this.f65160f;
        if (nVar == this) {
            nVar = null;
        }
        n nVar2 = this.f65161g;
        nVar2.f65160f = this.f65160f;
        this.f65160f.f65161g = nVar2;
        this.f65160f = null;
        this.f65161g = null;
        return nVar;
    }

    public final void f() {
        n nVar = this.f65161g;
        if (nVar != this) {
            if (nVar.f65159e) {
                int i = this.f65157c - this.f65156b;
                if (i > (8192 - nVar.f65157c) + (nVar.f65158d ? 0 : nVar.f65156b)) {
                    return;
                }
                d(this.f65161g, i);
                e();
                o.b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public n(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f65155a = bArr;
        this.f65156b = i;
        this.f65157c = i2;
        this.f65158d = z;
        this.f65159e = z2;
    }
}
