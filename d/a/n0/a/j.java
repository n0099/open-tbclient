package d.a.n0.a;
/* loaded from: classes3.dex */
public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    public c f52516a;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f52517b = 0;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f52518c = false;

    /* renamed from: d  reason: collision with root package name */
    public int f52519d = 0;

    public j(c cVar) {
        this.f52516a = cVar;
    }

    public synchronized void a(int i2) {
        this.f52517b += i2;
    }

    public long b() {
        return this.f52517b;
    }

    public c c() {
        return this.f52516a;
    }

    public int d() {
        return this.f52519d;
    }

    public boolean e() {
        return this.f52518c;
    }

    public synchronized void f(boolean z) {
        this.f52518c = z;
    }

    public void g(long j) {
        this.f52517b = j;
    }

    public void h(int i2) {
        this.f52519d = i2;
    }
}
