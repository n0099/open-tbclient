package d.g.c.b;

import com.google.common.cache.LongAddables;
/* loaded from: classes6.dex */
public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final g f65519a = LongAddables.a();

    /* renamed from: b  reason: collision with root package name */
    public final g f65520b = LongAddables.a();

    /* renamed from: c  reason: collision with root package name */
    public final g f65521c = LongAddables.a();

    /* renamed from: d  reason: collision with root package name */
    public final g f65522d = LongAddables.a();

    /* renamed from: e  reason: collision with root package name */
    public final g f65523e = LongAddables.a();

    /* renamed from: f  reason: collision with root package name */
    public final g f65524f = LongAddables.a();

    public static long h(long j) {
        if (j >= 0) {
            return j;
        }
        return Long.MAX_VALUE;
    }

    @Override // d.g.c.b.b
    public void a(int i2) {
        this.f65519a.add(i2);
    }

    @Override // d.g.c.b.b
    public void b() {
        this.f65524f.increment();
    }

    @Override // d.g.c.b.b
    public void c(long j) {
        this.f65521c.increment();
        this.f65523e.add(j);
    }

    @Override // d.g.c.b.b
    public void d(int i2) {
        this.f65520b.add(i2);
    }

    @Override // d.g.c.b.b
    public void e(long j) {
        this.f65522d.increment();
        this.f65523e.add(j);
    }

    @Override // d.g.c.b.b
    public d f() {
        return new d(h(this.f65519a.sum()), h(this.f65520b.sum()), h(this.f65521c.sum()), h(this.f65522d.sum()), h(this.f65523e.sum()), h(this.f65524f.sum()));
    }

    public void g(b bVar) {
        d f2 = bVar.f();
        this.f65519a.add(f2.b());
        this.f65520b.add(f2.e());
        this.f65521c.add(f2.d());
        this.f65522d.add(f2.c());
        this.f65523e.add(f2.f());
        this.f65524f.add(f2.a());
    }
}
