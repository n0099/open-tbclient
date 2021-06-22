package d.g.c.b;

import d.g.c.a.j;
import d.g.c.a.k;
import d.g.c.a.n;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final long f70089a;

    /* renamed from: b  reason: collision with root package name */
    public final long f70090b;

    /* renamed from: c  reason: collision with root package name */
    public final long f70091c;

    /* renamed from: d  reason: collision with root package name */
    public final long f70092d;

    /* renamed from: e  reason: collision with root package name */
    public final long f70093e;

    /* renamed from: f  reason: collision with root package name */
    public final long f70094f;

    public d(long j, long j2, long j3, long j4, long j5, long j6) {
        n.d(j >= 0);
        n.d(j2 >= 0);
        n.d(j3 >= 0);
        n.d(j4 >= 0);
        n.d(j5 >= 0);
        n.d(j6 >= 0);
        this.f70089a = j;
        this.f70090b = j2;
        this.f70091c = j3;
        this.f70092d = j4;
        this.f70093e = j5;
        this.f70094f = j6;
    }

    public long a() {
        return this.f70094f;
    }

    public long b() {
        return this.f70089a;
    }

    public long c() {
        return this.f70092d;
    }

    public long d() {
        return this.f70091c;
    }

    public long e() {
        return this.f70090b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.f70089a == dVar.f70089a && this.f70090b == dVar.f70090b && this.f70091c == dVar.f70091c && this.f70092d == dVar.f70092d && this.f70093e == dVar.f70093e && this.f70094f == dVar.f70094f;
        }
        return false;
    }

    public long f() {
        return this.f70093e;
    }

    public int hashCode() {
        return k.b(Long.valueOf(this.f70089a), Long.valueOf(this.f70090b), Long.valueOf(this.f70091c), Long.valueOf(this.f70092d), Long.valueOf(this.f70093e), Long.valueOf(this.f70094f));
    }

    public String toString() {
        j.b b2 = d.g.c.a.j.b(this);
        b2.c("hitCount", this.f70089a);
        b2.c("missCount", this.f70090b);
        b2.c("loadSuccessCount", this.f70091c);
        b2.c("loadExceptionCount", this.f70092d);
        b2.c("totalLoadTime", this.f70093e);
        b2.c("evictionCount", this.f70094f);
        return b2.toString();
    }
}
