package d.a.i0.a.h0.m;
/* loaded from: classes2.dex */
public abstract class j extends d.a.i0.n.f.g implements d.a.i0.a.n0.l.b {

    /* renamed from: e  reason: collision with root package name */
    public final int f42193e;

    /* renamed from: f  reason: collision with root package name */
    public int f42194f;

    public j() {
        int J = J();
        this.f42193e = J;
        this.f42194f = J;
    }

    public int I() {
        int i2 = this.f42194f;
        return i2 == 0 ? this.f42193e : i2;
    }

    public int J() {
        return 0;
    }

    public j K(int i2) {
        int i3 = this.f42194f;
        if ((i3 == 0 || this.f42193e == i3) && i2 != 0 && i2 != this.f42194f) {
            this.f42194f = i2;
        }
        return this;
    }
}
