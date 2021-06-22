package d.a.o0.k1.o.l;
/* loaded from: classes4.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public boolean f60498e;

    /* renamed from: f  reason: collision with root package name */
    public int f60499f;

    /* renamed from: g  reason: collision with root package name */
    public int f60500g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60501h = false;

    /* renamed from: i  reason: collision with root package name */
    public n f60502i;

    public b(n nVar) {
        this.f60502i = nVar;
    }

    public void a(int i2) {
        this.f60499f = i2;
    }

    public void b(boolean z) {
        this.f60498e = z;
    }

    public void c(int i2) {
        this.f60500g = i2;
    }

    public void d(boolean z) {
        this.f60501h = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar = this.f60502i;
        if (nVar == null) {
            return;
        }
        if (!this.f60501h) {
            nVar.j(this.f60499f, this.f60500g, this.f60498e, 2);
        }
        this.f60502i.j(this.f60499f, this.f60500g, this.f60498e, 1);
    }
}
