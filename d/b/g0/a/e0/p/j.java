package d.b.g0.a.e0.p;
/* loaded from: classes2.dex */
public abstract class j extends d.b.g0.l.h.g implements d.b.g0.a.j0.j.b {

    /* renamed from: e  reason: collision with root package name */
    public final int f44578e;

    /* renamed from: f  reason: collision with root package name */
    public int f44579f;

    public j() {
        int J = J();
        this.f44578e = J;
        this.f44579f = J;
    }

    public int I() {
        int i = this.f44579f;
        return i == 0 ? this.f44578e : i;
    }

    public int J() {
        return 0;
    }

    public j K(int i) {
        int i2 = this.f44579f;
        if ((i2 == 0 || this.f44578e == i2) && i != 0 && i != this.f44579f) {
            this.f44579f = i;
        }
        return this;
    }
}
