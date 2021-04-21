package d.h.c.b;

import com.google.common.cache.LongAddables;
/* loaded from: classes6.dex */
public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final g f67104a = LongAddables.a();

    /* renamed from: b  reason: collision with root package name */
    public final g f67105b = LongAddables.a();

    /* renamed from: c  reason: collision with root package name */
    public final g f67106c = LongAddables.a();

    /* renamed from: d  reason: collision with root package name */
    public final g f67107d = LongAddables.a();

    /* renamed from: e  reason: collision with root package name */
    public final g f67108e = LongAddables.a();

    /* renamed from: f  reason: collision with root package name */
    public final g f67109f = LongAddables.a();

    public static long h(long j) {
        if (j >= 0) {
            return j;
        }
        return Long.MAX_VALUE;
    }

    @Override // d.h.c.b.b
    public void a(int i) {
        this.f67104a.add(i);
    }

    @Override // d.h.c.b.b
    public void b(int i) {
        this.f67105b.add(i);
    }

    @Override // d.h.c.b.b
    public void c() {
        this.f67109f.increment();
    }

    @Override // d.h.c.b.b
    public void d(long j) {
        this.f67107d.increment();
        this.f67108e.add(j);
    }

    @Override // d.h.c.b.b
    public void e(long j) {
        this.f67106c.increment();
        this.f67108e.add(j);
    }

    @Override // d.h.c.b.b
    public d f() {
        return new d(h(this.f67104a.sum()), h(this.f67105b.sum()), h(this.f67106c.sum()), h(this.f67107d.sum()), h(this.f67108e.sum()), h(this.f67109f.sum()));
    }

    public void g(b bVar) {
        d f2 = bVar.f();
        this.f67104a.add(f2.b());
        this.f67105b.add(f2.e());
        this.f67106c.add(f2.d());
        this.f67107d.add(f2.c());
        this.f67108e.add(f2.f());
        this.f67109f.add(f2.a());
    }
}
