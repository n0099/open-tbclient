package d.g.c.b;

import d.g.c.a.j;
import d.g.c.a.k;
import d.g.c.a.n;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final long f65525a;

    /* renamed from: b  reason: collision with root package name */
    public final long f65526b;

    /* renamed from: c  reason: collision with root package name */
    public final long f65527c;

    /* renamed from: d  reason: collision with root package name */
    public final long f65528d;

    /* renamed from: e  reason: collision with root package name */
    public final long f65529e;

    /* renamed from: f  reason: collision with root package name */
    public final long f65530f;

    public d(long j, long j2, long j3, long j4, long j5, long j6) {
        n.d(j >= 0);
        n.d(j2 >= 0);
        n.d(j3 >= 0);
        n.d(j4 >= 0);
        n.d(j5 >= 0);
        n.d(j6 >= 0);
        this.f65525a = j;
        this.f65526b = j2;
        this.f65527c = j3;
        this.f65528d = j4;
        this.f65529e = j5;
        this.f65530f = j6;
    }

    public long a() {
        return this.f65530f;
    }

    public long b() {
        return this.f65525a;
    }

    public long c() {
        return this.f65528d;
    }

    public long d() {
        return this.f65527c;
    }

    public long e() {
        return this.f65526b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.f65525a == dVar.f65525a && this.f65526b == dVar.f65526b && this.f65527c == dVar.f65527c && this.f65528d == dVar.f65528d && this.f65529e == dVar.f65529e && this.f65530f == dVar.f65530f;
        }
        return false;
    }

    public long f() {
        return this.f65529e;
    }

    public int hashCode() {
        return k.b(Long.valueOf(this.f65525a), Long.valueOf(this.f65526b), Long.valueOf(this.f65527c), Long.valueOf(this.f65528d), Long.valueOf(this.f65529e), Long.valueOf(this.f65530f));
    }

    public String toString() {
        j.b b2 = d.g.c.a.j.b(this);
        b2.c("hitCount", this.f65525a);
        b2.c("missCount", this.f65526b);
        b2.c("loadSuccessCount", this.f65527c);
        b2.c("loadExceptionCount", this.f65528d);
        b2.c("totalLoadTime", this.f65529e);
        b2.c("evictionCount", this.f65530f);
        return b2.toString();
    }
}
