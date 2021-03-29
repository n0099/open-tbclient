package d.c.c.a.a;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class h extends r {

    /* renamed from: e  reason: collision with root package name */
    public r f65134e;

    public h(r rVar) {
        if (rVar != null) {
            this.f65134e = rVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // d.c.c.a.a.r
    public r a(long j) {
        return this.f65134e.a(j);
    }

    @Override // d.c.c.a.a.r
    public r b(long j, TimeUnit timeUnit) {
        return this.f65134e.b(j, timeUnit);
    }

    @Override // d.c.c.a.a.r
    public long c() {
        return this.f65134e.c();
    }

    @Override // d.c.c.a.a.r
    public boolean d() {
        return this.f65134e.d();
    }

    @Override // d.c.c.a.a.r
    public long e() {
        return this.f65134e.e();
    }

    @Override // d.c.c.a.a.r
    public r f() {
        return this.f65134e.f();
    }

    @Override // d.c.c.a.a.r
    public r g() {
        return this.f65134e.g();
    }

    @Override // d.c.c.a.a.r
    public void h() throws IOException {
        this.f65134e.h();
    }

    public final h i(r rVar) {
        if (rVar != null) {
            this.f65134e = rVar;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final r j() {
        return this.f65134e;
    }
}
