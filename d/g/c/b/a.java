package d.g.c.b;

import com.google.common.cache.LongAddables;
/* loaded from: classes6.dex */
public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final g f70083a = LongAddables.a();

    /* renamed from: b  reason: collision with root package name */
    public final g f70084b = LongAddables.a();

    /* renamed from: c  reason: collision with root package name */
    public final g f70085c = LongAddables.a();

    /* renamed from: d  reason: collision with root package name */
    public final g f70086d = LongAddables.a();

    /* renamed from: e  reason: collision with root package name */
    public final g f70087e = LongAddables.a();

    /* renamed from: f  reason: collision with root package name */
    public final g f70088f = LongAddables.a();

    public static long h(long j) {
        if (j >= 0) {
            return j;
        }
        return Long.MAX_VALUE;
    }

    @Override // d.g.c.b.b
    public void a(int i2) {
        this.f70083a.add(i2);
    }

    @Override // d.g.c.b.b
    public void b() {
        this.f70088f.increment();
    }

    @Override // d.g.c.b.b
    public void c(long j) {
        this.f70085c.increment();
        this.f70087e.add(j);
    }

    @Override // d.g.c.b.b
    public void d(int i2) {
        this.f70084b.add(i2);
    }

    @Override // d.g.c.b.b
    public void e(long j) {
        this.f70086d.increment();
        this.f70087e.add(j);
    }

    @Override // d.g.c.b.b
    public d f() {
        return new d(h(this.f70083a.sum()), h(this.f70084b.sum()), h(this.f70085c.sum()), h(this.f70086d.sum()), h(this.f70087e.sum()), h(this.f70088f.sum()));
    }

    public void g(b bVar) {
        d f2 = bVar.f();
        this.f70083a.add(f2.b());
        this.f70084b.add(f2.e());
        this.f70085c.add(f2.d());
        this.f70086d.add(f2.c());
        this.f70087e.add(f2.f());
        this.f70088f.add(f2.a());
    }
}
