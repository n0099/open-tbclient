package d.b.c.a.a;
/* loaded from: classes6.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f65188a;

    /* renamed from: b  reason: collision with root package name */
    public int f65189b;

    /* renamed from: c  reason: collision with root package name */
    public int f65190c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65191d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f65192e;

    /* renamed from: f  reason: collision with root package name */
    public n f65193f;

    /* renamed from: g  reason: collision with root package name */
    public n f65194g;

    public n() {
        this.f65188a = new byte[8192];
        this.f65192e = true;
        this.f65191d = false;
    }

    public final n a() {
        this.f65191d = true;
        return new n(this.f65188a, this.f65189b, this.f65190c, true, false);
    }

    public final n b(int i2) {
        n a2;
        if (i2 > 0 && i2 <= this.f65190c - this.f65189b) {
            if (i2 >= 1024) {
                a2 = a();
            } else {
                a2 = o.a();
                System.arraycopy(this.f65188a, this.f65189b, a2.f65188a, 0, i2);
            }
            a2.f65190c = a2.f65189b + i2;
            this.f65189b += i2;
            this.f65194g.c(a2);
            return a2;
        }
        throw new IllegalArgumentException();
    }

    public final n c(n nVar) {
        nVar.f65194g = this;
        nVar.f65193f = this.f65193f;
        this.f65193f.f65194g = nVar;
        this.f65193f = nVar;
        return nVar;
    }

    public final void d(n nVar, int i2) {
        if (nVar.f65192e) {
            int i3 = nVar.f65190c;
            if (i3 + i2 > 8192) {
                if (!nVar.f65191d) {
                    int i4 = nVar.f65189b;
                    if ((i3 + i2) - i4 <= 8192) {
                        byte[] bArr = nVar.f65188a;
                        System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
                        nVar.f65190c -= nVar.f65189b;
                        nVar.f65189b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f65188a, this.f65189b, nVar.f65188a, nVar.f65190c, i2);
            nVar.f65190c += i2;
            this.f65189b += i2;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final n e() {
        n nVar = this.f65193f;
        if (nVar == this) {
            nVar = null;
        }
        n nVar2 = this.f65194g;
        nVar2.f65193f = this.f65193f;
        this.f65193f.f65194g = nVar2;
        this.f65193f = null;
        this.f65194g = null;
        return nVar;
    }

    public final void f() {
        n nVar = this.f65194g;
        if (nVar != this) {
            if (nVar.f65192e) {
                int i2 = this.f65190c - this.f65189b;
                if (i2 > (8192 - nVar.f65190c) + (nVar.f65191d ? 0 : nVar.f65189b)) {
                    return;
                }
                d(this.f65194g, i2);
                e();
                o.b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public n(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        this.f65188a = bArr;
        this.f65189b = i2;
        this.f65190c = i3;
        this.f65191d = z;
        this.f65192e = z2;
    }
}
