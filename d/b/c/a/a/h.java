package d.b.c.a.a;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class h extends r {

    /* renamed from: e  reason: collision with root package name */
    public r f68897e;

    public h(r rVar) {
        if (rVar != null) {
            this.f68897e = rVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // d.b.c.a.a.r
    public r a(long j) {
        return this.f68897e.a(j);
    }

    @Override // d.b.c.a.a.r
    public r b(long j, TimeUnit timeUnit) {
        return this.f68897e.b(j, timeUnit);
    }

    @Override // d.b.c.a.a.r
    public long c() {
        return this.f68897e.c();
    }

    @Override // d.b.c.a.a.r
    public boolean d() {
        return this.f68897e.d();
    }

    @Override // d.b.c.a.a.r
    public long e() {
        return this.f68897e.e();
    }

    @Override // d.b.c.a.a.r
    public r f() {
        return this.f68897e.f();
    }

    @Override // d.b.c.a.a.r
    public r g() {
        return this.f68897e.g();
    }

    @Override // d.b.c.a.a.r
    public void h() throws IOException {
        this.f68897e.h();
    }

    public final h i(r rVar) {
        if (rVar != null) {
            this.f68897e = rVar;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final r j() {
        return this.f68897e;
    }
}
