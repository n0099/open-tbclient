package d.a.c.e.l;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.apollon.statistics.g;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static b f39025a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final Object f39026b = new Object();

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public f f39027a;

        /* renamed from: b  reason: collision with root package name */
        public f f39028b;

        /* renamed from: c  reason: collision with root package name */
        public f f39029c;

        /* renamed from: d  reason: collision with root package name */
        public f f39030d;

        public b() {
            this.f39027a = new f();
            this.f39028b = new f();
            this.f39029c = new f();
            this.f39030d = new f();
        }

        public int a() {
            return this.f39027a.f39052g + this.f39028b.f39052g + this.f39029c.f39052g + this.f39030d.f39052g;
        }

        public boolean b() {
            return this.f39029c.f39052g > 0;
        }

        public boolean c() {
            return this.f39028b.f39052g > 0;
        }

        public boolean d() {
            return this.f39027a.f39052g > 0;
        }

        public boolean e() {
            return this.f39030d.f39052g > 0;
        }

        public void f() {
            this.f39027a.a();
            this.f39028b.a();
            this.f39029c.a();
            this.f39030d.a();
        }
    }

    public static f a() {
        if (j.H()) {
            return f39025a.f39030d;
        }
        if (j.v()) {
            return f39025a.f39029c;
        }
        if (j.u()) {
            return f39025a.f39028b;
        }
        return f39025a.f39027a;
    }

    public static String b(int i2) {
        return 1 == i2 ? "2G" : 2 == i2 ? g.f3963b : 3 == i2 ? "4G" : 4 == i2 ? "5G" : 5 == i2 ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : "N";
    }

    public static void c(boolean z, long j) {
        synchronized (f39026b) {
            f a2 = a();
            if (z) {
                a2.l++;
                a2.m += j;
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        f a2 = a();
        if (z) {
            a2.t++;
        }
        if (z2) {
            a2.u++;
        }
        if (z3) {
            a2.v++;
        }
    }

    public static void e(boolean z, long j) {
        f a2 = a();
        if (z) {
            a2.r++;
            a2.s += j;
        }
    }

    public static void f(boolean z, long j) {
        synchronized (f39026b) {
            f a2 = a();
            a2.f39049d++;
            if (z) {
                a2.f39050e++;
                a2.f39051f += j;
            }
        }
    }

    public static void g() {
        if (f39025a.a() > 10) {
            if (f39025a.e()) {
                h(f39025a.f39030d, 5);
            }
            if (f39025a.b()) {
                h(f39025a.f39029c, 3);
            }
            if (f39025a.c()) {
                h(f39025a.f39028b, 2);
            }
            if (f39025a.d()) {
                h(f39025a.f39027a, 1);
            }
            f39025a.f();
        }
    }

    public static void h(f fVar, int i2) {
        if (fVar != null && BdBaseApplication.getInst().isSmallFlow()) {
            d.a.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
            statsItem.b("action", "imgStat");
            statsItem.b("memoryCount", String.valueOf(fVar.f39046a));
            statsItem.b("memorySucCount", String.valueOf(fVar.f39047b));
            statsItem.b("memoryTime", String.valueOf(fVar.f39048c));
            statsItem.b("localCount", String.valueOf(fVar.f39049d));
            statsItem.b("localSucCount", String.valueOf(fVar.f39050e));
            statsItem.b("localTime", String.valueOf(fVar.f39051f));
            statsItem.b("netCount", String.valueOf(fVar.f39052g));
            statsItem.b("netSucCount", String.valueOf(fVar.f39053h));
            statsItem.b("netTime", String.valueOf(fVar.f39054i));
            statsItem.b("taskCount", String.valueOf(fVar.j));
            statsItem.b("taskTime", String.valueOf(fVar.k));
            statsItem.b("decodeCount", String.valueOf(fVar.l));
            statsItem.b("decodeTime", String.valueOf(fVar.m));
            statsItem.b("saveMemoryCount", String.valueOf(fVar.n));
            statsItem.b("saveMemoryTime", String.valueOf(fVar.o));
            statsItem.b("saveLocalCount", String.valueOf(fVar.p));
            statsItem.b("saveLocalTime", String.valueOf(fVar.q));
            statsItem.b("memoryHitCount", String.valueOf(fVar.t));
            statsItem.b("localHitCount", String.valueOf(fVar.u));
            statsItem.b("netHitCount", String.valueOf(fVar.v));
            statsItem.b("totalHitCount", String.valueOf(fVar.t + fVar.u + fVar.v));
            statsItem.b("totalCount", String.valueOf(fVar.r));
            statsItem.b("totalTime", String.valueOf(fVar.s));
            statsItem.b("cdnCount", String.valueOf(fVar.w));
            statsItem.b("ipCount", String.valueOf(fVar.x));
            statsItem.b("cdnAndIpCount", String.valueOf(fVar.y));
            statsItem.b("imgSize", String.valueOf(fVar.z));
            statsItem.b("nettype", b(i2));
            BdStatisticsManager.getInstance().performance("image", statsItem);
        }
    }

    public static void i(boolean z, long j) {
        f a2 = a();
        a2.f39046a++;
        if (z) {
            a2.f39047b++;
            a2.f39048c += j;
        }
    }

    public static void j(boolean z, String str, d.a.c.e.j.a.d dVar, long j, long j2) {
        if (l.D()) {
            synchronized (f39026b) {
                boolean n = n(str);
                boolean z2 = false;
                if (dVar != null && !StringUtils.isNull(dVar.k)) {
                    z2 = true;
                }
                f a2 = a();
                if (n) {
                    a2.w++;
                }
                if (z2) {
                    a2.x++;
                }
                if (n && z2) {
                    a2.y++;
                }
                a2.f39052g++;
                if (z) {
                    a2.f39053h++;
                    a2.f39054i += j;
                    a2.z += j2;
                }
                if (f39025a.a() > 100) {
                    g();
                }
            }
        }
    }

    public static void k(boolean z, long j) {
        synchronized (f39026b) {
            f a2 = a();
            if (z) {
                a2.p++;
                a2.q += j;
            }
        }
    }

    public static void l(boolean z, long j) {
        f a2 = a();
        if (z) {
            a2.n++;
            a2.o += j;
        }
    }

    public static void m(boolean z, long j) {
        synchronized (f39026b) {
            f a2 = a();
            if (z) {
                a2.j++;
                a2.k += j;
            }
        }
    }

    public static boolean n(String str) {
        if (str == null) {
            return false;
        }
        int indexOf = str.indexOf("hiphotos");
        if (indexOf <= 0 || indexOf >= 20) {
            int indexOf2 = str.indexOf("tiebapic");
            return indexOf2 > 0 && indexOf2 < 20;
        }
        return true;
    }
}
