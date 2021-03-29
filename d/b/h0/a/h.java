package d.b.h0.a;
/* loaded from: classes3.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public b f49592a;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f49593b = 0;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f49594c = false;

    /* renamed from: d  reason: collision with root package name */
    public int f49595d = 0;

    public h(b bVar) {
        this.f49592a = bVar;
    }

    public synchronized void a(int i) {
        this.f49593b += i;
    }

    public long b() {
        return this.f49593b;
    }

    public b c() {
        return this.f49592a;
    }

    public int d() {
        return this.f49595d;
    }

    public boolean e() {
        return this.f49594c;
    }

    public synchronized void f(boolean z) {
        this.f49594c = z;
    }

    public void g(long j) {
        this.f49593b = j;
    }

    public void h(int i) {
        this.f49595d = i;
    }
}
