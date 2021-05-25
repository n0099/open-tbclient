package d.a.n0.k2;
/* loaded from: classes5.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public boolean f56814e;

    /* renamed from: f  reason: collision with root package name */
    public int f56815f;

    /* renamed from: g  reason: collision with root package name */
    public int f56816g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56817h = false;

    /* renamed from: i  reason: collision with root package name */
    public i f56818i;

    public b(i iVar) {
        this.f56818i = iVar;
    }

    public void a(int i2) {
        this.f56815f = i2;
    }

    public void b(boolean z) {
        this.f56814e = z;
    }

    public void c(int i2) {
        this.f56816g = i2;
    }

    public void d(boolean z) {
        this.f56817h = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        i iVar = this.f56818i;
        if (iVar == null) {
            return;
        }
        if (!this.f56817h) {
            iVar.m(this.f56815f, this.f56816g, this.f56814e, 2);
        } else {
            iVar.m(this.f56815f, this.f56816g, this.f56814e, 1);
        }
    }
}
