package d.c.c.a.a;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class h extends r {

    /* renamed from: e  reason: collision with root package name */
    public r f66074e;

    public h(r rVar) {
        if (rVar != null) {
            this.f66074e = rVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // d.c.c.a.a.r
    public r a(long j) {
        return this.f66074e.a(j);
    }

    @Override // d.c.c.a.a.r
    public r b(long j, TimeUnit timeUnit) {
        return this.f66074e.b(j, timeUnit);
    }

    @Override // d.c.c.a.a.r
    public long c() {
        return this.f66074e.c();
    }

    @Override // d.c.c.a.a.r
    public boolean d() {
        return this.f66074e.d();
    }

    @Override // d.c.c.a.a.r
    public long e() {
        return this.f66074e.e();
    }

    @Override // d.c.c.a.a.r
    public r f() {
        return this.f66074e.f();
    }

    @Override // d.c.c.a.a.r
    public r g() {
        return this.f66074e.g();
    }

    @Override // d.c.c.a.a.r
    public void h() throws IOException {
        this.f66074e.h();
    }

    public final h i(r rVar) {
        if (rVar != null) {
            this.f66074e = rVar;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final r j() {
        return this.f66074e;
    }
}
