package d.g.c.b;

import d.g.c.a.j;
import d.g.c.a.k;
import d.g.c.a.n;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final long f66254a;

    /* renamed from: b  reason: collision with root package name */
    public final long f66255b;

    /* renamed from: c  reason: collision with root package name */
    public final long f66256c;

    /* renamed from: d  reason: collision with root package name */
    public final long f66257d;

    /* renamed from: e  reason: collision with root package name */
    public final long f66258e;

    /* renamed from: f  reason: collision with root package name */
    public final long f66259f;

    public d(long j, long j2, long j3, long j4, long j5, long j6) {
        n.d(j >= 0);
        n.d(j2 >= 0);
        n.d(j3 >= 0);
        n.d(j4 >= 0);
        n.d(j5 >= 0);
        n.d(j6 >= 0);
        this.f66254a = j;
        this.f66255b = j2;
        this.f66256c = j3;
        this.f66257d = j4;
        this.f66258e = j5;
        this.f66259f = j6;
    }

    public long a() {
        return this.f66259f;
    }

    public long b() {
        return this.f66254a;
    }

    public long c() {
        return this.f66257d;
    }

    public long d() {
        return this.f66256c;
    }

    public long e() {
        return this.f66255b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.f66254a == dVar.f66254a && this.f66255b == dVar.f66255b && this.f66256c == dVar.f66256c && this.f66257d == dVar.f66257d && this.f66258e == dVar.f66258e && this.f66259f == dVar.f66259f;
        }
        return false;
    }

    public long f() {
        return this.f66258e;
    }

    public int hashCode() {
        return k.b(Long.valueOf(this.f66254a), Long.valueOf(this.f66255b), Long.valueOf(this.f66256c), Long.valueOf(this.f66257d), Long.valueOf(this.f66258e), Long.valueOf(this.f66259f));
    }

    public String toString() {
        j.b b2 = d.g.c.a.j.b(this);
        b2.c("hitCount", this.f66254a);
        b2.c("missCount", this.f66255b);
        b2.c("loadSuccessCount", this.f66256c);
        b2.c("loadExceptionCount", this.f66257d);
        b2.c("totalLoadTime", this.f66258e);
        b2.c("evictionCount", this.f66259f);
        return b2.toString();
    }
}
