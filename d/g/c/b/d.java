package d.g.c.b;

import d.g.c.a.j;
import d.g.c.a.k;
import d.g.c.a.n;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final long f69985a;

    /* renamed from: b  reason: collision with root package name */
    public final long f69986b;

    /* renamed from: c  reason: collision with root package name */
    public final long f69987c;

    /* renamed from: d  reason: collision with root package name */
    public final long f69988d;

    /* renamed from: e  reason: collision with root package name */
    public final long f69989e;

    /* renamed from: f  reason: collision with root package name */
    public final long f69990f;

    public d(long j, long j2, long j3, long j4, long j5, long j6) {
        n.d(j >= 0);
        n.d(j2 >= 0);
        n.d(j3 >= 0);
        n.d(j4 >= 0);
        n.d(j5 >= 0);
        n.d(j6 >= 0);
        this.f69985a = j;
        this.f69986b = j2;
        this.f69987c = j3;
        this.f69988d = j4;
        this.f69989e = j5;
        this.f69990f = j6;
    }

    public long a() {
        return this.f69990f;
    }

    public long b() {
        return this.f69985a;
    }

    public long c() {
        return this.f69988d;
    }

    public long d() {
        return this.f69987c;
    }

    public long e() {
        return this.f69986b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.f69985a == dVar.f69985a && this.f69986b == dVar.f69986b && this.f69987c == dVar.f69987c && this.f69988d == dVar.f69988d && this.f69989e == dVar.f69989e && this.f69990f == dVar.f69990f;
        }
        return false;
    }

    public long f() {
        return this.f69989e;
    }

    public int hashCode() {
        return k.b(Long.valueOf(this.f69985a), Long.valueOf(this.f69986b), Long.valueOf(this.f69987c), Long.valueOf(this.f69988d), Long.valueOf(this.f69989e), Long.valueOf(this.f69990f));
    }

    public String toString() {
        j.b b2 = d.g.c.a.j.b(this);
        b2.c("hitCount", this.f69985a);
        b2.c("missCount", this.f69986b);
        b2.c("loadSuccessCount", this.f69987c);
        b2.c("loadExceptionCount", this.f69988d);
        b2.c("totalLoadTime", this.f69989e);
        b2.c("evictionCount", this.f69990f);
        return b2.toString();
    }
}
