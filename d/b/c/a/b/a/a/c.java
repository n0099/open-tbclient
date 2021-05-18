package d.b.c.a.b.a.a;

import d.b.c.a.b.a.e;
import d.b.c.a.b.a0;
import d.b.c.a.b.c;
import d.b.c.a.b.h;
import d.b.c.a.b.v;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final a0 f65164a;

    /* renamed from: b  reason: collision with root package name */
    public final d.b.c.a.b.c f65165b;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final long f65166a;

        /* renamed from: b  reason: collision with root package name */
        public final a0 f65167b;

        /* renamed from: c  reason: collision with root package name */
        public final d.b.c.a.b.c f65168c;

        /* renamed from: d  reason: collision with root package name */
        public Date f65169d;

        /* renamed from: e  reason: collision with root package name */
        public String f65170e;

        /* renamed from: f  reason: collision with root package name */
        public Date f65171f;

        /* renamed from: g  reason: collision with root package name */
        public String f65172g;

        /* renamed from: h  reason: collision with root package name */
        public Date f65173h;

        /* renamed from: i  reason: collision with root package name */
        public long f65174i;
        public long j;
        public String k;
        public int l;

        public a(long j, a0 a0Var, d.b.c.a.b.c cVar) {
            this.l = -1;
            this.f65166a = j;
            this.f65167b = a0Var;
            this.f65168c = cVar;
            if (cVar != null) {
                this.f65174i = cVar.B();
                this.j = cVar.m();
                v w = cVar.w();
                int a2 = w.a();
                for (int i2 = 0; i2 < a2; i2++) {
                    String b2 = w.b(i2);
                    String e2 = w.e(i2);
                    if ("Date".equalsIgnoreCase(b2)) {
                        this.f65169d = e.f.b(e2);
                        this.f65170e = e2;
                    } else if ("Expires".equalsIgnoreCase(b2)) {
                        this.f65173h = e.f.b(e2);
                    } else if ("Last-Modified".equalsIgnoreCase(b2)) {
                        this.f65171f = e.f.b(e2);
                        this.f65172g = e2;
                    } else if ("ETag".equalsIgnoreCase(b2)) {
                        this.k = e2;
                    } else if ("Age".equalsIgnoreCase(b2)) {
                        this.l = e.g.g(e2, -1);
                    }
                }
            }
        }

        public static boolean b(a0 a0Var) {
            return (a0Var.b("If-Modified-Since") == null && a0Var.b("If-None-Match") == null) ? false : true;
        }

        public c a() {
            c c2 = c();
            return (c2.f65164a == null || !this.f65167b.g().j()) ? c2 : new c(null, null);
        }

        public final c c() {
            if (this.f65168c == null) {
                return new c(this.f65167b, null);
            }
            if (this.f65167b.h() && this.f65168c.v() == null) {
                return new c(this.f65167b, null);
            }
            if (!c.a(this.f65168c, this.f65167b)) {
                return new c(this.f65167b, null);
            }
            h g2 = this.f65167b.g();
            if (!g2.b() && !b(this.f65167b)) {
                h A = this.f65168c.A();
                if (A.k()) {
                    return new c(null, this.f65168c);
                }
                long e2 = e();
                long d2 = d();
                if (g2.d() != -1) {
                    d2 = Math.min(d2, TimeUnit.SECONDS.toMillis(g2.d()));
                }
                long j = 0;
                long millis = g2.i() != -1 ? TimeUnit.SECONDS.toMillis(g2.i()) : 0L;
                if (!A.g() && g2.h() != -1) {
                    j = TimeUnit.SECONDS.toMillis(g2.h());
                }
                if (!A.b()) {
                    long j2 = millis + e2;
                    if (j2 < j + d2) {
                        c.a y = this.f65168c.y();
                        if (j2 >= d2) {
                            y.j("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (e2 > 86400000 && f()) {
                            y.j("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new c(null, y.k());
                    }
                }
                String str = this.k;
                String str2 = "If-Modified-Since";
                if (str != null) {
                    str2 = "If-None-Match";
                } else if (this.f65171f != null) {
                    str = this.f65172g;
                } else if (this.f65169d != null) {
                    str = this.f65170e;
                } else {
                    return new c(this.f65167b, null);
                }
                v.a h2 = this.f65167b.d().h();
                d.b.c.a.b.a.b.f65175a.g(h2, str2, str);
                a0.a f2 = this.f65167b.f();
                f2.b(h2.c());
                return new c(f2.p(), this.f65168c);
            }
            return new c(this.f65167b, null);
        }

        public final long d() {
            h A = this.f65168c.A();
            if (A.d() != -1) {
                return TimeUnit.SECONDS.toMillis(A.d());
            }
            if (this.f65173h != null) {
                Date date = this.f65169d;
                long time = this.f65173h.getTime() - (date != null ? date.getTime() : this.j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            } else if (this.f65171f == null || this.f65168c.n().a().A() != null) {
                return 0L;
            } else {
                Date date2 = this.f65169d;
                long time2 = (date2 != null ? date2.getTime() : this.f65174i) - this.f65171f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0L;
            }
        }

        public final long e() {
            Date date = this.f65169d;
            long max = date != null ? Math.max(0L, this.j - date.getTime()) : 0L;
            int i2 = this.l;
            if (i2 != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i2));
            }
            long j = this.j;
            return max + (j - this.f65174i) + (this.f65166a - j);
        }

        public final boolean f() {
            return this.f65168c.A().d() == -1 && this.f65173h == null;
        }
    }

    public c(a0 a0Var, d.b.c.a.b.c cVar) {
        this.f65164a = a0Var;
        this.f65165b = cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
        if (r3.A().e() == false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(d.b.c.a.b.c cVar, a0 a0Var) {
        int r = cVar.r();
        if (r != 200 && r != 410 && r != 414 && r != 501 && r != 203 && r != 204) {
            if (r != 307) {
                if (r != 308 && r != 404 && r != 405) {
                    switch (r) {
                        case 300:
                        case 301:
                            break;
                        case 302:
                            break;
                        default:
                            return false;
                    }
                }
            }
            if (cVar.o("Expires") == null) {
                if (cVar.A().d() == -1) {
                    if (!cVar.A().f()) {
                    }
                }
            }
        }
        return (cVar.A().c() || a0Var.g().c()) ? false : true;
    }
}
