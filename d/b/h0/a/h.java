package d.b.h0.a;
/* loaded from: classes3.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public b f49984a;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f49985b = 0;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f49986c = false;

    /* renamed from: d  reason: collision with root package name */
    public int f49987d = 0;

    public h(b bVar) {
        this.f49984a = bVar;
    }

    public synchronized void a(int i) {
        this.f49985b += i;
    }

    public long b() {
        return this.f49985b;
    }

    public b c() {
        return this.f49984a;
    }

    public int d() {
        return this.f49987d;
    }

    public boolean e() {
        return this.f49986c;
    }

    public synchronized void f(boolean z) {
        this.f49986c = z;
    }

    public void g(long j) {
        this.f49985b = j;
    }

    public void h(int i) {
        this.f49987d = i;
    }
}
