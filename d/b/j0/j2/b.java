package d.b.j0.j2;
/* loaded from: classes3.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public boolean f57952e;

    /* renamed from: f  reason: collision with root package name */
    public int f57953f;

    /* renamed from: g  reason: collision with root package name */
    public int f57954g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57955h = false;
    public i i;

    public b(i iVar) {
        this.i = iVar;
    }

    public void a(int i) {
        this.f57953f = i;
    }

    public void b(boolean z) {
        this.f57952e = z;
    }

    public void c(int i) {
        this.f57954g = i;
    }

    public void d(boolean z) {
        this.f57955h = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        i iVar = this.i;
        if (iVar == null) {
            return;
        }
        if (!this.f57955h) {
            iVar.m(this.f57953f, this.f57954g, this.f57952e, 2);
        } else {
            iVar.m(this.f57953f, this.f57954g, this.f57952e, 1);
        }
    }
}
