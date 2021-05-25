package d.g.c.b;

import com.google.common.cache.LongAddables;
/* loaded from: classes6.dex */
public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final g f66248a = LongAddables.a();

    /* renamed from: b  reason: collision with root package name */
    public final g f66249b = LongAddables.a();

    /* renamed from: c  reason: collision with root package name */
    public final g f66250c = LongAddables.a();

    /* renamed from: d  reason: collision with root package name */
    public final g f66251d = LongAddables.a();

    /* renamed from: e  reason: collision with root package name */
    public final g f66252e = LongAddables.a();

    /* renamed from: f  reason: collision with root package name */
    public final g f66253f = LongAddables.a();

    public static long h(long j) {
        if (j >= 0) {
            return j;
        }
        return Long.MAX_VALUE;
    }

    @Override // d.g.c.b.b
    public void a(int i2) {
        this.f66248a.add(i2);
    }

    @Override // d.g.c.b.b
    public void b() {
        this.f66253f.increment();
    }

    @Override // d.g.c.b.b
    public void c(long j) {
        this.f66250c.increment();
        this.f66252e.add(j);
    }

    @Override // d.g.c.b.b
    public void d(int i2) {
        this.f66249b.add(i2);
    }

    @Override // d.g.c.b.b
    public void e(long j) {
        this.f66251d.increment();
        this.f66252e.add(j);
    }

    @Override // d.g.c.b.b
    public d f() {
        return new d(h(this.f66248a.sum()), h(this.f66249b.sum()), h(this.f66250c.sum()), h(this.f66251d.sum()), h(this.f66252e.sum()), h(this.f66253f.sum()));
    }

    public void g(b bVar) {
        d f2 = bVar.f();
        this.f66248a.add(f2.b());
        this.f66249b.add(f2.e());
        this.f66250c.add(f2.d());
        this.f66251d.add(f2.c());
        this.f66252e.add(f2.f());
        this.f66253f.add(f2.a());
    }
}
