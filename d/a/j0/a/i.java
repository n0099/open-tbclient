package d.a.j0.a;
/* loaded from: classes3.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public b f48711a;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f48712b = 0;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f48713c = false;

    /* renamed from: d  reason: collision with root package name */
    public int f48714d = 0;

    public i(b bVar) {
        this.f48711a = bVar;
    }

    public synchronized void a(int i2) {
        this.f48712b += i2;
    }

    public long b() {
        return this.f48712b;
    }

    public b c() {
        return this.f48711a;
    }

    public int d() {
        return this.f48714d;
    }

    public boolean e() {
        return this.f48713c;
    }

    public synchronized void f(boolean z) {
        this.f48713c = z;
    }

    public void g(long j) {
        this.f48712b = j;
    }

    public void h(int i2) {
        this.f48714d = i2;
    }
}
