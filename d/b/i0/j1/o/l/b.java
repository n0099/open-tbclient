package d.b.i0.j1.o.l;
/* loaded from: classes4.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public boolean f57409e;

    /* renamed from: f  reason: collision with root package name */
    public int f57410f;

    /* renamed from: g  reason: collision with root package name */
    public int f57411g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57412h = false;
    public n i;

    public b(n nVar) {
        this.i = nVar;
    }

    public void a(int i) {
        this.f57410f = i;
    }

    public void b(boolean z) {
        this.f57409e = z;
    }

    public void c(int i) {
        this.f57411g = i;
    }

    public void d(boolean z) {
        this.f57412h = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar = this.i;
        if (nVar == null) {
            return;
        }
        if (!this.f57412h) {
            nVar.j(this.f57410f, this.f57411g, this.f57409e, 2);
        }
        this.i.j(this.f57410f, this.f57411g, this.f57409e, 1);
    }
}
