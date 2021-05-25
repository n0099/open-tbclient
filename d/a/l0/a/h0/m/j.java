package d.a.l0.a.h0.m;
/* loaded from: classes2.dex */
public abstract class j extends d.a.l0.n.f.g implements d.a.l0.a.n0.l.b {

    /* renamed from: e  reason: collision with root package name */
    public final int f42367e;

    /* renamed from: f  reason: collision with root package name */
    public int f42368f;

    public j() {
        int J = J();
        this.f42367e = J;
        this.f42368f = J;
    }

    public int I() {
        int i2 = this.f42368f;
        return i2 == 0 ? this.f42367e : i2;
    }

    public int J() {
        return 0;
    }

    public j K(int i2) {
        int i3 = this.f42368f;
        if ((i3 == 0 || this.f42367e == i3) && i2 != 0 && i2 != this.f42368f) {
            this.f42368f = i2;
        }
        return this;
    }
}
