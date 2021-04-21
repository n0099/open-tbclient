package d.h.c.b;

import d.h.c.a.j;
import d.h.c.a.k;
import d.h.c.a.n;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final long f67110a;

    /* renamed from: b  reason: collision with root package name */
    public final long f67111b;

    /* renamed from: c  reason: collision with root package name */
    public final long f67112c;

    /* renamed from: d  reason: collision with root package name */
    public final long f67113d;

    /* renamed from: e  reason: collision with root package name */
    public final long f67114e;

    /* renamed from: f  reason: collision with root package name */
    public final long f67115f;

    public d(long j, long j2, long j3, long j4, long j5, long j6) {
        n.d(j >= 0);
        n.d(j2 >= 0);
        n.d(j3 >= 0);
        n.d(j4 >= 0);
        n.d(j5 >= 0);
        n.d(j6 >= 0);
        this.f67110a = j;
        this.f67111b = j2;
        this.f67112c = j3;
        this.f67113d = j4;
        this.f67114e = j5;
        this.f67115f = j6;
    }

    public long a() {
        return this.f67115f;
    }

    public long b() {
        return this.f67110a;
    }

    public long c() {
        return this.f67113d;
    }

    public long d() {
        return this.f67112c;
    }

    public long e() {
        return this.f67111b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.f67110a == dVar.f67110a && this.f67111b == dVar.f67111b && this.f67112c == dVar.f67112c && this.f67113d == dVar.f67113d && this.f67114e == dVar.f67114e && this.f67115f == dVar.f67115f;
        }
        return false;
    }

    public long f() {
        return this.f67114e;
    }

    public int hashCode() {
        return k.b(Long.valueOf(this.f67110a), Long.valueOf(this.f67111b), Long.valueOf(this.f67112c), Long.valueOf(this.f67113d), Long.valueOf(this.f67114e), Long.valueOf(this.f67115f));
    }

    public String toString() {
        j.b b2 = d.h.c.a.j.b(this);
        b2.c("hitCount", this.f67110a);
        b2.c("missCount", this.f67111b);
        b2.c("loadSuccessCount", this.f67112c);
        b2.c("loadExceptionCount", this.f67113d);
        b2.c("totalLoadTime", this.f67114e);
        b2.c("evictionCount", this.f67115f);
        return b2.toString();
    }
}
