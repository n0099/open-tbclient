package d.b.c.a.a;
/* loaded from: classes5.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f65145a;

    /* renamed from: b  reason: collision with root package name */
    public int f65146b;

    /* renamed from: c  reason: collision with root package name */
    public int f65147c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65148d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f65149e;

    /* renamed from: f  reason: collision with root package name */
    public n f65150f;

    /* renamed from: g  reason: collision with root package name */
    public n f65151g;

    public n() {
        this.f65145a = new byte[8192];
        this.f65149e = true;
        this.f65148d = false;
    }

    public final n a() {
        this.f65148d = true;
        return new n(this.f65145a, this.f65146b, this.f65147c, true, false);
    }

    public final n b(int i2) {
        n a2;
        if (i2 > 0 && i2 <= this.f65147c - this.f65146b) {
            if (i2 >= 1024) {
                a2 = a();
            } else {
                a2 = o.a();
                System.arraycopy(this.f65145a, this.f65146b, a2.f65145a, 0, i2);
            }
            a2.f65147c = a2.f65146b + i2;
            this.f65146b += i2;
            this.f65151g.c(a2);
            return a2;
        }
        throw new IllegalArgumentException();
    }

    public final n c(n nVar) {
        nVar.f65151g = this;
        nVar.f65150f = this.f65150f;
        this.f65150f.f65151g = nVar;
        this.f65150f = nVar;
        return nVar;
    }

    public final void d(n nVar, int i2) {
        if (nVar.f65149e) {
            int i3 = nVar.f65147c;
            if (i3 + i2 > 8192) {
                if (!nVar.f65148d) {
                    int i4 = nVar.f65146b;
                    if ((i3 + i2) - i4 <= 8192) {
                        byte[] bArr = nVar.f65145a;
                        System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
                        nVar.f65147c -= nVar.f65146b;
                        nVar.f65146b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f65145a, this.f65146b, nVar.f65145a, nVar.f65147c, i2);
            nVar.f65147c += i2;
            this.f65146b += i2;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final n e() {
        n nVar = this.f65150f;
        if (nVar == this) {
            nVar = null;
        }
        n nVar2 = this.f65151g;
        nVar2.f65150f = this.f65150f;
        this.f65150f.f65151g = nVar2;
        this.f65150f = null;
        this.f65151g = null;
        return nVar;
    }

    public final void f() {
        n nVar = this.f65151g;
        if (nVar != this) {
            if (nVar.f65149e) {
                int i2 = this.f65147c - this.f65146b;
                if (i2 > (8192 - nVar.f65147c) + (nVar.f65148d ? 0 : nVar.f65146b)) {
                    return;
                }
                d(this.f65151g, i2);
                e();
                o.b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public n(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        this.f65145a = bArr;
        this.f65146b = i2;
        this.f65147c = i3;
        this.f65148d = z;
        this.f65149e = z2;
    }
}
