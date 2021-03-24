package d.b.h0.a;
/* loaded from: classes3.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public b f49591a;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f49592b = 0;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f49593c = false;

    /* renamed from: d  reason: collision with root package name */
    public int f49594d = 0;

    public h(b bVar) {
        this.f49591a = bVar;
    }

    public synchronized void a(int i) {
        this.f49592b += i;
    }

    public long b() {
        return this.f49592b;
    }

    public b c() {
        return this.f49591a;
    }

    public int d() {
        return this.f49594d;
    }

    public boolean e() {
        return this.f49593c;
    }

    public synchronized void f(boolean z) {
        this.f49593c = z;
    }

    public void g(long j) {
        this.f49592b = j;
    }

    public void h(int i) {
        this.f49594d = i;
    }
}
