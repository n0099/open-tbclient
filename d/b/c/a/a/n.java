package d.b.c.a.a;
/* loaded from: classes5.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f64459a;

    /* renamed from: b  reason: collision with root package name */
    public int f64460b;

    /* renamed from: c  reason: collision with root package name */
    public int f64461c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64462d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64463e;

    /* renamed from: f  reason: collision with root package name */
    public n f64464f;

    /* renamed from: g  reason: collision with root package name */
    public n f64465g;

    public n() {
        this.f64459a = new byte[8192];
        this.f64463e = true;
        this.f64462d = false;
    }

    public final n a() {
        this.f64462d = true;
        return new n(this.f64459a, this.f64460b, this.f64461c, true, false);
    }

    public final n b(int i2) {
        n a2;
        if (i2 > 0 && i2 <= this.f64461c - this.f64460b) {
            if (i2 >= 1024) {
                a2 = a();
            } else {
                a2 = o.a();
                System.arraycopy(this.f64459a, this.f64460b, a2.f64459a, 0, i2);
            }
            a2.f64461c = a2.f64460b + i2;
            this.f64460b += i2;
            this.f64465g.c(a2);
            return a2;
        }
        throw new IllegalArgumentException();
    }

    public final n c(n nVar) {
        nVar.f64465g = this;
        nVar.f64464f = this.f64464f;
        this.f64464f.f64465g = nVar;
        this.f64464f = nVar;
        return nVar;
    }

    public final void d(n nVar, int i2) {
        if (nVar.f64463e) {
            int i3 = nVar.f64461c;
            if (i3 + i2 > 8192) {
                if (!nVar.f64462d) {
                    int i4 = nVar.f64460b;
                    if ((i3 + i2) - i4 <= 8192) {
                        byte[] bArr = nVar.f64459a;
                        System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
                        nVar.f64461c -= nVar.f64460b;
                        nVar.f64460b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f64459a, this.f64460b, nVar.f64459a, nVar.f64461c, i2);
            nVar.f64461c += i2;
            this.f64460b += i2;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final n e() {
        n nVar = this.f64464f;
        if (nVar == this) {
            nVar = null;
        }
        n nVar2 = this.f64465g;
        nVar2.f64464f = this.f64464f;
        this.f64464f.f64465g = nVar2;
        this.f64464f = null;
        this.f64465g = null;
        return nVar;
    }

    public final void f() {
        n nVar = this.f64465g;
        if (nVar != this) {
            if (nVar.f64463e) {
                int i2 = this.f64461c - this.f64460b;
                if (i2 > (8192 - nVar.f64461c) + (nVar.f64462d ? 0 : nVar.f64460b)) {
                    return;
                }
                d(this.f64465g, i2);
                e();
                o.b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public n(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        this.f64459a = bArr;
        this.f64460b = i2;
        this.f64461c = i3;
        this.f64462d = z;
        this.f64463e = z2;
    }
}
