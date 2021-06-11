package d.a.n0.k2;
/* loaded from: classes5.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public boolean f60503e;

    /* renamed from: f  reason: collision with root package name */
    public int f60504f;

    /* renamed from: g  reason: collision with root package name */
    public int f60505g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60506h = false;

    /* renamed from: i  reason: collision with root package name */
    public i f60507i;

    public b(i iVar) {
        this.f60507i = iVar;
    }

    public void a(int i2) {
        this.f60504f = i2;
    }

    public void b(boolean z) {
        this.f60503e = z;
    }

    public void c(int i2) {
        this.f60505g = i2;
    }

    public void d(boolean z) {
        this.f60506h = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        i iVar = this.f60507i;
        if (iVar == null) {
            return;
        }
        if (!this.f60506h) {
            iVar.m(this.f60504f, this.f60505g, this.f60503e, 2);
        } else {
            iVar.m(this.f60504f, this.f60505g, this.f60503e, 1);
        }
    }
}
