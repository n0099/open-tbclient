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
    public static b f42445a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final Object f42446b = new Object();

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public f f42447a;

        /* renamed from: b  reason: collision with root package name */
        public f f42448b;

        /* renamed from: c  reason: collision with root package name */
        public f f42449c;

        /* renamed from: d  reason: collision with root package name */
        public f f42450d;

        public b() {
            this.f42447a = new f();
            this.f42448b = new f();
            this.f42449c = new f();
            this.f42450d = new f();
        }

        public int a() {
            return this.f42447a.f42472g + this.f42448b.f42472g + this.f42449c.f42472g + this.f42450d.f42472g;
        }

        public boolean b() {
            return this.f42449c.f42472g > 0;
        }

        public boolean c() {
            return this.f42448b.f42472g > 0;
        }

        public boolean d() {
            return this.f42447a.f42472g > 0;
        }

        public boolean e() {
            return this.f42450d.f42472g > 0;
        }

        public void f() {
            this.f42447a.a();
            this.f42448b.a();
            this.f42449c.a();
            this.f42450d.a();
        }
    }

    public static f a() {
        if (j.H()) {
            return f42445a.f42450d;
        }
        if (j.v()) {
            return f42445a.f42449c;
        }
        if (j.u()) {
            return f42445a.f42448b;
        }
        return f42445a.f42447a;
    }

    public static String b(int i2) {
        return 1 == i2 ? "2G" : 2 == i2 ? g.f3985b : 3 == i2 ? "4G" : 4 == i2 ? "5G" : 5 == i2 ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : "N";
    }

    public static void c(boolean z, long j) {
        synchronized (f42446b) {
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
        synchronized (f42446b) {
            f a2 = a();
            a2.f42469d++;
            if (z) {
                a2.f42470e++;
                a2.f42471f += j;
            }
        }
    }

    public static void g() {
        if (f42445a.a() > 10) {
            if (f42445a.e()) {
                h(f42445a.f42450d, 5);
            }
            if (f42445a.b()) {
                h(f42445a.f42449c, 3);
            }
            if (f42445a.c()) {
                h(f42445a.f42448b, 2);
            }
            if (f42445a.d()) {
                h(f42445a.f42447a, 1);
            }
            f42445a.f();
        }
    }

    public static void h(f fVar, int i2) {
        if (fVar != null && BdBaseApplication.getInst().isSmallFlow()) {
            d.a.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
            statsItem.b("action", "imgStat");
            statsItem.b("memoryCount", String.valueOf(fVar.f42466a));
            statsItem.b("memorySucCount", String.valueOf(fVar.f42467b));
            statsItem.b("memoryTime", String.valueOf(fVar.f42468c));
            statsItem.b("localCount", String.valueOf(fVar.f42469d));
            statsItem.b("localSucCount", String.valueOf(fVar.f42470e));
            statsItem.b("localTime", String.valueOf(fVar.f42471f));
            statsItem.b("netCount", String.valueOf(fVar.f42472g));
            statsItem.b("netSucCount", String.valueOf(fVar.f42473h));
            statsItem.b("netTime", String.valueOf(fVar.f42474i));
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
        a2.f42466a++;
        if (z) {
            a2.f42467b++;
            a2.f42468c += j;
        }
    }

    public static void j(boolean z, String str, d.a.c.e.j.a.d dVar, long j, long j2) {
        if (l.D()) {
            synchronized (f42446b) {
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
                a2.f42472g++;
                if (z) {
                    a2.f42473h++;
                    a2.f42474i += j;
                    a2.z += j2;
                }
                if (f42445a.a() > 100) {
                    g();
                }
            }
        }
    }

    public static void k(boolean z, long j) {
        synchronized (f42446b) {
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
        synchronized (f42446b) {
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
