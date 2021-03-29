package d.b.i0.i1.o.l;
/* loaded from: classes3.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public boolean f55962e;

    /* renamed from: f  reason: collision with root package name */
    public int f55963f;

    /* renamed from: g  reason: collision with root package name */
    public int f55964g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55965h = false;
    public n i;

    public b(n nVar) {
        this.i = nVar;
    }

    public void a(int i) {
        this.f55963f = i;
    }

    public void b(boolean z) {
        this.f55962e = z;
    }

    public void c(int i) {
        this.f55964g = i;
    }

    public void d(boolean z) {
        this.f55965h = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar = this.i;
        if (nVar == null) {
            return;
        }
        if (!this.f55965h) {
            nVar.j(this.f55963f, this.f55964g, this.f55962e, 2);
        }
        this.i.j(this.f55963f, this.f55964g, this.f55962e, 1);
    }
}
