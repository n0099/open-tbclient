package d.a.i0.a;
/* loaded from: classes3.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public b f47872a;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f47873b = 0;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f47874c = false;

    /* renamed from: d  reason: collision with root package name */
    public int f47875d = 0;

    public h(b bVar) {
        this.f47872a = bVar;
    }

    public synchronized void a(int i2) {
        this.f47873b += i2;
    }

    public long b() {
        return this.f47873b;
    }

    public b c() {
        return this.f47872a;
    }

    public int d() {
        return this.f47875d;
    }

    public boolean e() {
        return this.f47874c;
    }

    public synchronized void f(boolean z) {
        this.f47874c = z;
    }

    public void g(long j) {
        this.f47873b = j;
    }

    public void h(int i2) {
        this.f47875d = i2;
    }
}
