package d.a.m0.m0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
/* loaded from: classes3.dex */
public class l extends j {
    public static l E;

    /* renamed from: b  reason: collision with root package name */
    public boolean f53241b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53242c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f53243d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f53244e = false;

    /* renamed from: f  reason: collision with root package name */
    public long f53245f = -1;

    /* renamed from: g  reason: collision with root package name */
    public long f53246g = -1;

    /* renamed from: h  reason: collision with root package name */
    public long f53247h = -1;

    /* renamed from: i  reason: collision with root package name */
    public long f53248i = -1;
    public long j = -1;
    public long k = -1;
    public long l = -1;
    public long m = -1;
    public long n = -1;
    public long o = -1;
    public long p = -1;
    public long q = -1;
    public long r = -1;
    public long s = -1;
    public long t = -1;
    public long u = -1;
    public long v = -1;
    public long w = -1;
    public long x = -1;
    public long y = -1;
    public long z = -1;
    public long A = -1;
    public long B = -1;
    public long C = -1;
    public long D = -1;

    public static l b() {
        if (E == null) {
            synchronized (l.class) {
                if (E == null) {
                    E = new l();
                }
            }
        }
        return E;
    }

    public void A(boolean z) {
        this.f53241b = z;
    }

    public void B(long j) {
        this.j = j;
    }

    public void C(long j) {
    }

    public void D(boolean z) {
        this.f53244e = z;
    }

    public void E(long j) {
        this.f53248i = j;
    }

    public void F(long j) {
    }

    public void G(long j) {
        this.y = j;
    }

    public void H(long j) {
        if (this.z > 0) {
            return;
        }
        this.z = j;
    }

    public void I(long j) {
        this.A = j;
    }

    public void J(long j) {
        this.f53246g = j;
    }

    public void K(long j) {
        this.o = j;
    }

    public void L(long j) {
        this.n = j;
    }

    public void M(long j) {
        this.x = j;
    }

    public long c() {
        return this.f53245f;
    }

    public long d() {
        return this.w;
    }

    public boolean e() {
        return this.f53242c;
    }

    public void f() {
        long j = 0;
        if (this.D - this.f53245f <= 0 || this.f53243d || this.v <= 0 || !k.d().g()) {
            return;
        }
        long j2 = this.f53246g - this.f53245f;
        long j3 = this.t;
        long j4 = j3 > 0 ? this.u - j3 : -1L;
        this.f53243d = true;
        long j5 = this.D - this.C;
        d.a.c.e.n.a a2 = j.a();
        a2.b("procname", FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT);
        a2.b("appc", String.valueOf(j2));
        a2.b("loadclass", String.valueOf(this.f53247h));
        a2.b("sapiinit", String.valueOf(this.f53248i));
        a2.b("acctinit", String.valueOf(this.A));
        a2.b("iminit", String.valueOf(this.y));
        a2.b("plugininit", String.valueOf(this.z));
        a2.b("patchloaded", String.valueOf(this.j));
        a2.b("naslibinit", String.valueOf(this.k));
        a2.b("websocketinit", String.valueOf(this.l));
        a2.b("settinginit", String.valueOf(this.m));
        a2.b("toastinit", String.valueOf(this.n));
        a2.b("tiebastaticinit", String.valueOf(this.o));
        a2.b("cdninit", String.valueOf(this.p));
        a2.b("messagesetinit", String.valueOf(this.q));
        a2.b("logores", String.valueOf(this.B));
        a2.b("opttest", String.valueOf(d.a.m0.r.x.d.f54024b ? 1 : 0));
        long j6 = this.r;
        if (j6 > 0 && this.t > 0 && j4 > 0) {
            a2.b("adc", String.valueOf(j6 + this.s));
            a2.b("adshow", String.valueOf(j4));
            a2.b("adrequest", String.valueOf(this.s));
            j = this.r + this.s + j4;
            a2.b("hasad", "1");
        } else {
            a2.b("hasad", "0");
            long j7 = this.s;
            if (j7 > 0) {
                j = j7;
            }
        }
        a2.b("tabc", String.valueOf(j5));
        a2.b("costt", String.valueOf(this.w - j));
        a2.b("newinst", this.f53241b ? "1" : "0");
        a2.c("pluginloadsync", Boolean.valueOf(this.f53244e));
        a2.b("hptotal", String.valueOf(this.v));
        a2.b("locationinit", String.valueOf(j2 + this.B + this.r + j4 + this.s + j5 + this.v));
        a2.b("userperceptiont", String.valueOf(this.x - j));
        BdStatisticsManager.getInstance().performance("startt", a2);
        h();
    }

    public void g(long j) {
        if (k.d().g() && j > 0) {
            d.a.c.e.n.a a2 = j.a();
            a2.b("procname", "remote");
            a2.b("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", a2);
        }
    }

    public final void h() {
        this.f53241b = false;
        this.f53242c = false;
        this.f53245f = -1L;
        this.f53246g = -1L;
        this.w = -1L;
        this.f53247h = -1L;
        this.f53248i = -1L;
        this.j = -1L;
        this.B = -1L;
        this.t = -1L;
        this.u = -1L;
        this.r = -1L;
        this.C = -1L;
        this.D = -1L;
        this.k = -1L;
        this.l = -1L;
        this.m = -1L;
        this.n = -1L;
        this.o = -1L;
        this.p = -1L;
        this.q = -1L;
        this.s = -1L;
        this.v = -1L;
        this.x = -1L;
        this.y = -1L;
        this.z = -1L;
        this.A = -1L;
    }

    public void i(long j) {
    }

    public void j(long j) {
        this.r = j;
    }

    public void k(long j) {
        this.s = j;
    }

    public void l(long j) {
        this.u = j;
    }

    public void m(long j) {
        this.t = j;
    }

    public void n(long j) {
        this.p = j;
    }

    public void o(long j) {
        if (this.v > 0) {
            return;
        }
        this.v = j;
        this.w = System.currentTimeMillis() - this.f53245f;
    }

    public void p(long j) {
    }

    public void q(long j) {
        this.k = j;
    }

    public void r(long j) {
        this.m = j;
    }

    public void s(long j) {
        this.l = j;
    }

    public void t(long j) {
        this.f53245f = j;
    }

    public void u(long j) {
        this.f53247h = j;
    }

    public void v(long j) {
    }

    public void w(long j) {
        this.B = j;
    }

    public void x(long j) {
        this.C = j;
    }

    public void y(long j) {
        this.D = j;
        this.f53242c = true;
    }

    public void z(long j) {
        this.q = j;
    }
}
