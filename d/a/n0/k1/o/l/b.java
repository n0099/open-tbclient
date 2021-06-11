package d.a.n0.k1.o.l;
/* loaded from: classes4.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public boolean f60373e;

    /* renamed from: f  reason: collision with root package name */
    public int f60374f;

    /* renamed from: g  reason: collision with root package name */
    public int f60375g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60376h = false;

    /* renamed from: i  reason: collision with root package name */
    public n f60377i;

    public b(n nVar) {
        this.f60377i = nVar;
    }

    public void a(int i2) {
        this.f60374f = i2;
    }

    public void b(boolean z) {
        this.f60373e = z;
    }

    public void c(int i2) {
        this.f60375g = i2;
    }

    public void d(boolean z) {
        this.f60376h = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar = this.f60377i;
        if (nVar == null) {
            return;
        }
        if (!this.f60376h) {
            nVar.j(this.f60374f, this.f60375g, this.f60373e, 2);
        }
        this.f60377i.j(this.f60374f, this.f60375g, this.f60373e, 1);
    }
}
