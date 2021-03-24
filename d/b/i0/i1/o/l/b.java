package d.b.i0.i1.o.l;
/* loaded from: classes4.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public boolean f55961e;

    /* renamed from: f  reason: collision with root package name */
    public int f55962f;

    /* renamed from: g  reason: collision with root package name */
    public int f55963g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55964h = false;
    public n i;

    public b(n nVar) {
        this.i = nVar;
    }

    public void a(int i) {
        this.f55962f = i;
    }

    public void b(boolean z) {
        this.f55961e = z;
    }

    public void c(int i) {
        this.f55963g = i;
    }

    public void d(boolean z) {
        this.f55964h = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar = this.i;
        if (nVar == null) {
            return;
        }
        if (!this.f55964h) {
            nVar.j(this.f55962f, this.f55963g, this.f55961e, 2);
        }
        this.i.j(this.f55962f, this.f55963g, this.f55961e, 1);
    }
}
