package d.b.g0.a.e0.p;
/* loaded from: classes3.dex */
public abstract class j extends d.b.g0.l.h.g implements d.b.g0.a.j0.j.b {

    /* renamed from: e  reason: collision with root package name */
    public final int f44185e;

    /* renamed from: f  reason: collision with root package name */
    public int f44186f;

    public j() {
        int K = K();
        this.f44185e = K;
        this.f44186f = K;
    }

    public int J() {
        int i = this.f44186f;
        return i == 0 ? this.f44185e : i;
    }

    public int K() {
        return 0;
    }

    public j L(int i) {
        int i2 = this.f44186f;
        if ((i2 == 0 || this.f44185e == i2) && i != 0 && i != this.f44186f) {
            this.f44186f = i;
        }
        return this;
    }
}
