package d.b.i0.i2;
/* loaded from: classes5.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public boolean f56083e;

    /* renamed from: f  reason: collision with root package name */
    public int f56084f;

    /* renamed from: g  reason: collision with root package name */
    public int f56085g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56086h = false;
    public i i;

    public b(i iVar) {
        this.i = iVar;
    }

    public void a(int i) {
        this.f56084f = i;
    }

    public void b(boolean z) {
        this.f56083e = z;
    }

    public void c(int i) {
        this.f56085g = i;
    }

    public void d(boolean z) {
        this.f56086h = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        i iVar = this.i;
        if (iVar == null) {
            return;
        }
        if (!this.f56086h) {
            iVar.m(this.f56084f, this.f56085g, this.f56083e, 2);
        } else {
            iVar.m(this.f56084f, this.f56085g, this.f56083e, 1);
        }
    }
}
