package d.g.c.b;

import com.google.common.cache.LongAddables;
/* loaded from: classes6.dex */
public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final g f69979a = LongAddables.a();

    /* renamed from: b  reason: collision with root package name */
    public final g f69980b = LongAddables.a();

    /* renamed from: c  reason: collision with root package name */
    public final g f69981c = LongAddables.a();

    /* renamed from: d  reason: collision with root package name */
    public final g f69982d = LongAddables.a();

    /* renamed from: e  reason: collision with root package name */
    public final g f69983e = LongAddables.a();

    /* renamed from: f  reason: collision with root package name */
    public final g f69984f = LongAddables.a();

    public static long h(long j) {
        if (j >= 0) {
            return j;
        }
        return Long.MAX_VALUE;
    }

    @Override // d.g.c.b.b
    public void a(int i2) {
        this.f69979a.add(i2);
    }

    @Override // d.g.c.b.b
    public void b() {
        this.f69984f.increment();
    }

    @Override // d.g.c.b.b
    public void c(long j) {
        this.f69981c.increment();
        this.f69983e.add(j);
    }

    @Override // d.g.c.b.b
    public void d(int i2) {
        this.f69980b.add(i2);
    }

    @Override // d.g.c.b.b
    public void e(long j) {
        this.f69982d.increment();
        this.f69983e.add(j);
    }

    @Override // d.g.c.b.b
    public d f() {
        return new d(h(this.f69979a.sum()), h(this.f69980b.sum()), h(this.f69981c.sum()), h(this.f69982d.sum()), h(this.f69983e.sum()), h(this.f69984f.sum()));
    }

    public void g(b bVar) {
        d f2 = bVar.f();
        this.f69979a.add(f2.b());
        this.f69980b.add(f2.e());
        this.f69981c.add(f2.d());
        this.f69982d.add(f2.c());
        this.f69983e.add(f2.f());
        this.f69984f.add(f2.a());
    }
}
