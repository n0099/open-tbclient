package d.a.m0.a.h0.m;
/* loaded from: classes3.dex */
public abstract class j extends d.a.m0.n.f.g implements d.a.m0.a.n0.l.b {

    /* renamed from: e  reason: collision with root package name */
    public final int f46151e;

    /* renamed from: f  reason: collision with root package name */
    public int f46152f;

    public j() {
        int J = J();
        this.f46151e = J;
        this.f46152f = J;
    }

    public int I() {
        int i2 = this.f46152f;
        return i2 == 0 ? this.f46151e : i2;
    }

    public int J() {
        return 0;
    }

    public j K(int i2) {
        int i3 = this.f46152f;
        if ((i3 == 0 || this.f46151e == i3) && i2 != 0 && i2 != this.f46152f) {
            this.f46152f = i2;
        }
        return this;
    }
}
