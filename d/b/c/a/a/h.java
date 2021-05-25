package d.b.c.a.a;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class h extends r {

    /* renamed from: e  reason: collision with root package name */
    public r f65166e;

    public h(r rVar) {
        if (rVar != null) {
            this.f65166e = rVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // d.b.c.a.a.r
    public r a(long j) {
        return this.f65166e.a(j);
    }

    @Override // d.b.c.a.a.r
    public r b(long j, TimeUnit timeUnit) {
        return this.f65166e.b(j, timeUnit);
    }

    @Override // d.b.c.a.a.r
    public long c() {
        return this.f65166e.c();
    }

    @Override // d.b.c.a.a.r
    public boolean d() {
        return this.f65166e.d();
    }

    @Override // d.b.c.a.a.r
    public long e() {
        return this.f65166e.e();
    }

    @Override // d.b.c.a.a.r
    public r f() {
        return this.f65166e.f();
    }

    @Override // d.b.c.a.a.r
    public r g() {
        return this.f65166e.g();
    }

    @Override // d.b.c.a.a.r
    public void h() throws IOException {
        this.f65166e.h();
    }

    public final h i(r rVar) {
        if (rVar != null) {
            this.f65166e = rVar;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final r j() {
        return this.f65166e;
    }
}
