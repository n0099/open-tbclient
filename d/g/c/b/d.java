package d.g.c.b;

import d.g.c.a.j;
import d.g.c.a.k;
import d.g.c.a.n;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final long f66963a;

    /* renamed from: b  reason: collision with root package name */
    public final long f66964b;

    /* renamed from: c  reason: collision with root package name */
    public final long f66965c;

    /* renamed from: d  reason: collision with root package name */
    public final long f66966d;

    /* renamed from: e  reason: collision with root package name */
    public final long f66967e;

    /* renamed from: f  reason: collision with root package name */
    public final long f66968f;

    public d(long j, long j2, long j3, long j4, long j5, long j6) {
        n.d(j >= 0);
        n.d(j2 >= 0);
        n.d(j3 >= 0);
        n.d(j4 >= 0);
        n.d(j5 >= 0);
        n.d(j6 >= 0);
        this.f66963a = j;
        this.f66964b = j2;
        this.f66965c = j3;
        this.f66966d = j4;
        this.f66967e = j5;
        this.f66968f = j6;
    }

    public long a() {
        return this.f66968f;
    }

    public long b() {
        return this.f66963a;
    }

    public long c() {
        return this.f66966d;
    }

    public long d() {
        return this.f66965c;
    }

    public long e() {
        return this.f66964b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.f66963a == dVar.f66963a && this.f66964b == dVar.f66964b && this.f66965c == dVar.f66965c && this.f66966d == dVar.f66966d && this.f66967e == dVar.f66967e && this.f66968f == dVar.f66968f;
        }
        return false;
    }

    public long f() {
        return this.f66967e;
    }

    public int hashCode() {
        return k.b(Long.valueOf(this.f66963a), Long.valueOf(this.f66964b), Long.valueOf(this.f66965c), Long.valueOf(this.f66966d), Long.valueOf(this.f66967e), Long.valueOf(this.f66968f));
    }

    public String toString() {
        j.b b2 = d.g.c.a.j.b(this);
        b2.c("hitCount", this.f66963a);
        b2.c("missCount", this.f66964b);
        b2.c("loadSuccessCount", this.f66965c);
        b2.c("loadExceptionCount", this.f66966d);
        b2.c("totalLoadTime", this.f66967e);
        b2.c("evictionCount", this.f66968f);
        return b2.toString();
    }
}
