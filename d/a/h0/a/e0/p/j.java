package d.a.h0.a.e0.p;
/* loaded from: classes2.dex */
public abstract class j extends d.a.h0.l.h.g implements d.a.h0.a.j0.j.b {

    /* renamed from: e  reason: collision with root package name */
    public final int f42210e;

    /* renamed from: f  reason: collision with root package name */
    public int f42211f;

    public j() {
        int J = J();
        this.f42210e = J;
        this.f42211f = J;
    }

    public int I() {
        int i2 = this.f42211f;
        return i2 == 0 ? this.f42210e : i2;
    }

    public int J() {
        return 0;
    }

    public j K(int i2) {
        int i3 = this.f42211f;
        if ((i3 == 0 || this.f42210e == i3) && i2 != 0 && i2 != this.f42211f) {
            this.f42211f = i2;
        }
        return this;
    }
}
