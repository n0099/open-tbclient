package d.b.i0.i2;
/* loaded from: classes5.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public boolean f56084e;

    /* renamed from: f  reason: collision with root package name */
    public int f56085f;

    /* renamed from: g  reason: collision with root package name */
    public int f56086g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56087h = false;
    public i i;

    public b(i iVar) {
        this.i = iVar;
    }

    public void a(int i) {
        this.f56085f = i;
    }

    public void b(boolean z) {
        this.f56084e = z;
    }

    public void c(int i) {
        this.f56086g = i;
    }

    public void d(boolean z) {
        this.f56087h = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        i iVar = this.i;
        if (iVar == null) {
            return;
        }
        if (!this.f56087h) {
            iVar.m(this.f56085f, this.f56086g, this.f56084e, 2);
        } else {
            iVar.m(this.f56085f, this.f56086g, this.f56084e, 1);
        }
    }
}
