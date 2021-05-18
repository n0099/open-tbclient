package d.a.k0.j1.o.l;
/* loaded from: classes4.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public boolean f56504e;

    /* renamed from: f  reason: collision with root package name */
    public int f56505f;

    /* renamed from: g  reason: collision with root package name */
    public int f56506g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56507h = false;

    /* renamed from: i  reason: collision with root package name */
    public n f56508i;

    public b(n nVar) {
        this.f56508i = nVar;
    }

    public void a(int i2) {
        this.f56505f = i2;
    }

    public void b(boolean z) {
        this.f56504e = z;
    }

    public void c(int i2) {
        this.f56506g = i2;
    }

    public void d(boolean z) {
        this.f56507h = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar = this.f56508i;
        if (nVar == null) {
            return;
        }
        if (!this.f56507h) {
            nVar.j(this.f56505f, this.f56506g, this.f56504e, 2);
        }
        this.f56508i.j(this.f56505f, this.f56506g, this.f56504e, 1);
    }
}
