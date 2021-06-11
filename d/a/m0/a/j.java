package d.a.m0.a;
/* loaded from: classes3.dex */
public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    public c f52409a;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f52410b = 0;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f52411c = false;

    /* renamed from: d  reason: collision with root package name */
    public int f52412d = 0;

    public j(c cVar) {
        this.f52409a = cVar;
    }

    public synchronized void a(int i2) {
        this.f52410b += i2;
    }

    public long b() {
        return this.f52410b;
    }

    public c c() {
        return this.f52409a;
    }

    public int d() {
        return this.f52412d;
    }

    public boolean e() {
        return this.f52411c;
    }

    public synchronized void f(boolean z) {
        this.f52411c = z;
    }

    public void g(long j) {
        this.f52410b = j;
    }

    public void h(int i2) {
        this.f52412d = i2;
    }
}
