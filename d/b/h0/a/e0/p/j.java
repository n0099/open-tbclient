package d.b.h0.a.e0.p;
/* loaded from: classes2.dex */
public abstract class j extends d.b.h0.l.h.g implements d.b.h0.a.j0.j.b {

    /* renamed from: e  reason: collision with root package name */
    public final int f44907e;

    /* renamed from: f  reason: collision with root package name */
    public int f44908f;

    public j() {
        int J = J();
        this.f44907e = J;
        this.f44908f = J;
    }

    public int I() {
        int i = this.f44908f;
        return i == 0 ? this.f44907e : i;
    }

    public int J() {
        return 0;
    }

    public j K(int i) {
        int i2 = this.f44908f;
        if ((i2 == 0 || this.f44907e == i2) && i != 0 && i != this.f44908f) {
            this.f44908f = i;
        }
        return this;
    }
}
