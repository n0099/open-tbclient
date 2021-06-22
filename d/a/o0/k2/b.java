package d.a.o0.k2;
/* loaded from: classes5.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public boolean f60628e;

    /* renamed from: f  reason: collision with root package name */
    public int f60629f;

    /* renamed from: g  reason: collision with root package name */
    public int f60630g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60631h = false;

    /* renamed from: i  reason: collision with root package name */
    public i f60632i;

    public b(i iVar) {
        this.f60632i = iVar;
    }

    public void a(int i2) {
        this.f60629f = i2;
    }

    public void b(boolean z) {
        this.f60628e = z;
    }

    public void c(int i2) {
        this.f60630g = i2;
    }

    public void d(boolean z) {
        this.f60631h = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        i iVar = this.f60632i;
        if (iVar == null) {
            return;
        }
        if (!this.f60631h) {
            iVar.m(this.f60629f, this.f60630g, this.f60628e, 2);
        } else {
            iVar.m(this.f60629f, this.f60630g, this.f60628e, 1);
        }
    }
}
