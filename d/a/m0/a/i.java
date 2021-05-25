package d.a.m0.a;
/* loaded from: classes3.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public b f48733a;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f48734b = 0;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f48735c = false;

    /* renamed from: d  reason: collision with root package name */
    public int f48736d = 0;

    public i(b bVar) {
        this.f48733a = bVar;
    }

    public synchronized void a(int i2) {
        this.f48734b += i2;
    }

    public long b() {
        return this.f48734b;
    }

    public b c() {
        return this.f48733a;
    }

    public int d() {
        return this.f48736d;
    }

    public boolean e() {
        return this.f48735c;
    }

    public synchronized void f(boolean z) {
        this.f48735c = z;
    }

    public void g(long j) {
        this.f48734b = j;
    }

    public void h(int i2) {
        this.f48736d = i2;
    }
}
