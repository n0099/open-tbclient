package d.a.k0.j2;
/* loaded from: classes5.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public boolean f56634e;

    /* renamed from: f  reason: collision with root package name */
    public int f56635f;

    /* renamed from: g  reason: collision with root package name */
    public int f56636g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56637h = false;

    /* renamed from: i  reason: collision with root package name */
    public i f56638i;

    public b(i iVar) {
        this.f56638i = iVar;
    }

    public void a(int i2) {
        this.f56635f = i2;
    }

    public void b(boolean z) {
        this.f56634e = z;
    }

    public void c(int i2) {
        this.f56636g = i2;
    }

    public void d(boolean z) {
        this.f56637h = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        i iVar = this.f56638i;
        if (iVar == null) {
            return;
        }
        if (!this.f56637h) {
            iVar.m(this.f56635f, this.f56636g, this.f56634e, 2);
        } else {
            iVar.m(this.f56635f, this.f56636g, this.f56634e, 1);
        }
    }
}
