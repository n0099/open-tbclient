package d.a.n0.k1.o.l;
/* loaded from: classes4.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public boolean f56684e;

    /* renamed from: f  reason: collision with root package name */
    public int f56685f;

    /* renamed from: g  reason: collision with root package name */
    public int f56686g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56687h = false;

    /* renamed from: i  reason: collision with root package name */
    public n f56688i;

    public b(n nVar) {
        this.f56688i = nVar;
    }

    public void a(int i2) {
        this.f56685f = i2;
    }

    public void b(boolean z) {
        this.f56684e = z;
    }

    public void c(int i2) {
        this.f56686g = i2;
    }

    public void d(boolean z) {
        this.f56687h = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar = this.f56688i;
        if (nVar == null) {
            return;
        }
        if (!this.f56687h) {
            nVar.j(this.f56685f, this.f56686g, this.f56684e, 2);
        }
        this.f56688i.j(this.f56685f, this.f56686g, this.f56684e, 1);
    }
}
