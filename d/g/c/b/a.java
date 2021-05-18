package d.g.c.b;

import com.google.common.cache.LongAddables;
/* loaded from: classes6.dex */
public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final g f66205a = LongAddables.a();

    /* renamed from: b  reason: collision with root package name */
    public final g f66206b = LongAddables.a();

    /* renamed from: c  reason: collision with root package name */
    public final g f66207c = LongAddables.a();

    /* renamed from: d  reason: collision with root package name */
    public final g f66208d = LongAddables.a();

    /* renamed from: e  reason: collision with root package name */
    public final g f66209e = LongAddables.a();

    /* renamed from: f  reason: collision with root package name */
    public final g f66210f = LongAddables.a();

    public static long h(long j) {
        if (j >= 0) {
            return j;
        }
        return Long.MAX_VALUE;
    }

    @Override // d.g.c.b.b
    public void a(int i2) {
        this.f66205a.add(i2);
    }

    @Override // d.g.c.b.b
    public void b() {
        this.f66210f.increment();
    }

    @Override // d.g.c.b.b
    public void c(long j) {
        this.f66207c.increment();
        this.f66209e.add(j);
    }

    @Override // d.g.c.b.b
    public void d(int i2) {
        this.f66206b.add(i2);
    }

    @Override // d.g.c.b.b
    public void e(long j) {
        this.f66208d.increment();
        this.f66209e.add(j);
    }

    @Override // d.g.c.b.b
    public d f() {
        return new d(h(this.f66205a.sum()), h(this.f66206b.sum()), h(this.f66207c.sum()), h(this.f66208d.sum()), h(this.f66209e.sum()), h(this.f66210f.sum()));
    }

    public void g(b bVar) {
        d f2 = bVar.f();
        this.f66205a.add(f2.b());
        this.f66206b.add(f2.e());
        this.f66207c.add(f2.d());
        this.f66208d.add(f2.c());
        this.f66209e.add(f2.f());
        this.f66210f.add(f2.a());
    }
}
