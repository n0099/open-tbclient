package d.a.j0.j1.o.l;
/* loaded from: classes4.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public boolean f55797e;

    /* renamed from: f  reason: collision with root package name */
    public int f55798f;

    /* renamed from: g  reason: collision with root package name */
    public int f55799g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55800h = false;

    /* renamed from: i  reason: collision with root package name */
    public n f55801i;

    public b(n nVar) {
        this.f55801i = nVar;
    }

    public void a(int i2) {
        this.f55798f = i2;
    }

    public void b(boolean z) {
        this.f55797e = z;
    }

    public void c(int i2) {
        this.f55799g = i2;
    }

    public void d(boolean z) {
        this.f55800h = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar = this.f55801i;
        if (nVar == null) {
            return;
        }
        if (!this.f55800h) {
            nVar.j(this.f55798f, this.f55799g, this.f55797e, 2);
        }
        this.f55801i.j(this.f55798f, this.f55799g, this.f55797e, 1);
    }
}
