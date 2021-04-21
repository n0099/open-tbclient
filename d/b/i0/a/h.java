package d.b.i0.a;
/* loaded from: classes3.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public b f50320a;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f50321b = 0;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f50322c = false;

    /* renamed from: d  reason: collision with root package name */
    public int f50323d = 0;

    public h(b bVar) {
        this.f50320a = bVar;
    }

    public synchronized void a(int i) {
        this.f50321b += i;
    }

    public long b() {
        return this.f50321b;
    }

    public b c() {
        return this.f50320a;
    }

    public int d() {
        return this.f50323d;
    }

    public boolean e() {
        return this.f50322c;
    }

    public synchronized void f(boolean z) {
        this.f50322c = z;
    }

    public void g(long j) {
        this.f50321b = j;
    }

    public void h(int i) {
        this.f50323d = i;
    }
}
