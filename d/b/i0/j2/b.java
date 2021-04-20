package d.b.i0.j2;
/* loaded from: classes3.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public boolean f57531e;

    /* renamed from: f  reason: collision with root package name */
    public int f57532f;

    /* renamed from: g  reason: collision with root package name */
    public int f57533g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57534h = false;
    public i i;

    public b(i iVar) {
        this.i = iVar;
    }

    public void a(int i) {
        this.f57532f = i;
    }

    public void b(boolean z) {
        this.f57531e = z;
    }

    public void c(int i) {
        this.f57533g = i;
    }

    public void d(boolean z) {
        this.f57534h = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        i iVar = this.i;
        if (iVar == null) {
            return;
        }
        if (!this.f57534h) {
            iVar.m(this.f57532f, this.f57533g, this.f57531e, 2);
        } else {
            iVar.m(this.f57532f, this.f57533g, this.f57531e, 1);
        }
    }
}
