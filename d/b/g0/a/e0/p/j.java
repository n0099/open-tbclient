package d.b.g0.a.e0.p;
/* loaded from: classes2.dex */
public abstract class j extends d.b.g0.l.h.g implements d.b.g0.a.j0.j.b {

    /* renamed from: e  reason: collision with root package name */
    public final int f44186e;

    /* renamed from: f  reason: collision with root package name */
    public int f44187f;

    public j() {
        int K = K();
        this.f44186e = K;
        this.f44187f = K;
    }

    public int J() {
        int i = this.f44187f;
        return i == 0 ? this.f44186e : i;
    }

    public int K() {
        return 0;
    }

    public j L(int i) {
        int i2 = this.f44187f;
        if ((i2 == 0 || this.f44186e == i2) && i != 0 && i != this.f44187f) {
            this.f44187f = i;
        }
        return this;
    }
}
