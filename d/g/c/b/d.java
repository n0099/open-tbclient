package d.g.c.b;

import d.g.c.a.j;
import d.g.c.a.k;
import d.g.c.a.n;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final long f66211a;

    /* renamed from: b  reason: collision with root package name */
    public final long f66212b;

    /* renamed from: c  reason: collision with root package name */
    public final long f66213c;

    /* renamed from: d  reason: collision with root package name */
    public final long f66214d;

    /* renamed from: e  reason: collision with root package name */
    public final long f66215e;

    /* renamed from: f  reason: collision with root package name */
    public final long f66216f;

    public d(long j, long j2, long j3, long j4, long j5, long j6) {
        n.d(j >= 0);
        n.d(j2 >= 0);
        n.d(j3 >= 0);
        n.d(j4 >= 0);
        n.d(j5 >= 0);
        n.d(j6 >= 0);
        this.f66211a = j;
        this.f66212b = j2;
        this.f66213c = j3;
        this.f66214d = j4;
        this.f66215e = j5;
        this.f66216f = j6;
    }

    public long a() {
        return this.f66216f;
    }

    public long b() {
        return this.f66211a;
    }

    public long c() {
        return this.f66214d;
    }

    public long d() {
        return this.f66213c;
    }

    public long e() {
        return this.f66212b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.f66211a == dVar.f66211a && this.f66212b == dVar.f66212b && this.f66213c == dVar.f66213c && this.f66214d == dVar.f66214d && this.f66215e == dVar.f66215e && this.f66216f == dVar.f66216f;
        }
        return false;
    }

    public long f() {
        return this.f66215e;
    }

    public int hashCode() {
        return k.b(Long.valueOf(this.f66211a), Long.valueOf(this.f66212b), Long.valueOf(this.f66213c), Long.valueOf(this.f66214d), Long.valueOf(this.f66215e), Long.valueOf(this.f66216f));
    }

    public String toString() {
        j.b b2 = d.g.c.a.j.b(this);
        b2.c("hitCount", this.f66211a);
        b2.c("missCount", this.f66212b);
        b2.c("loadSuccessCount", this.f66213c);
        b2.c("loadExceptionCount", this.f66214d);
        b2.c("totalLoadTime", this.f66215e);
        b2.c("evictionCount", this.f66216f);
        return b2.toString();
    }
}
