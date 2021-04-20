package d.g.c.b;

import com.google.common.cache.LongAddables;
/* loaded from: classes6.dex */
public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final g f66957a = LongAddables.a();

    /* renamed from: b  reason: collision with root package name */
    public final g f66958b = LongAddables.a();

    /* renamed from: c  reason: collision with root package name */
    public final g f66959c = LongAddables.a();

    /* renamed from: d  reason: collision with root package name */
    public final g f66960d = LongAddables.a();

    /* renamed from: e  reason: collision with root package name */
    public final g f66961e = LongAddables.a();

    /* renamed from: f  reason: collision with root package name */
    public final g f66962f = LongAddables.a();

    public static long h(long j) {
        if (j >= 0) {
            return j;
        }
        return Long.MAX_VALUE;
    }

    @Override // d.g.c.b.b
    public void a(int i) {
        this.f66957a.add(i);
    }

    @Override // d.g.c.b.b
    public void b(int i) {
        this.f66958b.add(i);
    }

    @Override // d.g.c.b.b
    public void c() {
        this.f66962f.increment();
    }

    @Override // d.g.c.b.b
    public void d(long j) {
        this.f66960d.increment();
        this.f66961e.add(j);
    }

    @Override // d.g.c.b.b
    public void e(long j) {
        this.f66959c.increment();
        this.f66961e.add(j);
    }

    @Override // d.g.c.b.b
    public d f() {
        return new d(h(this.f66957a.sum()), h(this.f66958b.sum()), h(this.f66959c.sum()), h(this.f66960d.sum()), h(this.f66961e.sum()), h(this.f66962f.sum()));
    }

    public void g(b bVar) {
        d f2 = bVar.f();
        this.f66957a.add(f2.b());
        this.f66958b.add(f2.e());
        this.f66959c.add(f2.d());
        this.f66960d.add(f2.c());
        this.f66961e.add(f2.f());
        this.f66962f.add(f2.a());
    }
}
