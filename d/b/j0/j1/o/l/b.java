package d.b.j0.j1.o.l;
/* loaded from: classes4.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public boolean f57830e;

    /* renamed from: f  reason: collision with root package name */
    public int f57831f;

    /* renamed from: g  reason: collision with root package name */
    public int f57832g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57833h = false;
    public n i;

    public b(n nVar) {
        this.i = nVar;
    }

    public void a(int i) {
        this.f57831f = i;
    }

    public void b(boolean z) {
        this.f57830e = z;
    }

    public void c(int i) {
        this.f57832g = i;
    }

    public void d(boolean z) {
        this.f57833h = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar = this.i;
        if (nVar == null) {
            return;
        }
        if (!this.f57833h) {
            nVar.j(this.f57831f, this.f57832g, this.f57830e, 2);
        }
        this.i.j(this.f57831f, this.f57832g, this.f57830e, 1);
    }
}
