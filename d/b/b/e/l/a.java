package d.b.b.e.l;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.apollon.statistics.g;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static b f41841a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final Object f41842b = new Object();

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public f f41843a;

        /* renamed from: b  reason: collision with root package name */
        public f f41844b;

        /* renamed from: c  reason: collision with root package name */
        public f f41845c;

        /* renamed from: d  reason: collision with root package name */
        public f f41846d;

        public b() {
            this.f41843a = new f();
            this.f41844b = new f();
            this.f41845c = new f();
            this.f41846d = new f();
        }

        public int a() {
            return this.f41843a.f41867g + this.f41844b.f41867g + this.f41845c.f41867g + this.f41846d.f41867g;
        }

        public boolean b() {
            return this.f41845c.f41867g > 0;
        }

        public boolean c() {
            return this.f41844b.f41867g > 0;
        }

        public boolean d() {
            return this.f41843a.f41867g > 0;
        }

        public boolean e() {
            return this.f41846d.f41867g > 0;
        }

        public void f() {
            this.f41843a.a();
            this.f41844b.a();
            this.f41845c.a();
            this.f41846d.a();
        }
    }

    public static f a() {
        if (j.H()) {
            return f41841a.f41846d;
        }
        if (j.v()) {
            return f41841a.f41845c;
        }
        if (j.u()) {
            return f41841a.f41844b;
        }
        return f41841a.f41843a;
    }

    public static String b(int i) {
        return 1 == i ? "2G" : 2 == i ? g.f3873b : 3 == i ? "4G" : 4 == i ? "5G" : 5 == i ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : "N";
    }

    public static void c(boolean z, long j) {
        synchronized (f41842b) {
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
        synchronized (f41842b) {
            f a2 = a();
            a2.f41864d++;
            if (z) {
                a2.f41865e++;
                a2.f41866f += j;
            }
        }
    }

    public static void g() {
        if (f41841a.a() > 10) {
            if (f41841a.e()) {
                h(f41841a.f41846d, 5);
            }
            if (f41841a.b()) {
                h(f41841a.f41845c, 3);
            }
            if (f41841a.c()) {
                h(f41841a.f41844b, 2);
            }
            if (f41841a.d()) {
                h(f41841a.f41843a, 1);
            }
            f41841a.f();
        }
    }

    public static void h(f fVar, int i) {
        if (fVar != null && BdBaseApplication.getInst().isSmallFlow()) {
            d.b.b.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
            statsItem.b("action", "imgStat");
            statsItem.b("memoryCount", String.valueOf(fVar.f41861a));
            statsItem.b("memorySucCount", String.valueOf(fVar.f41862b));
            statsItem.b("memoryTime", String.valueOf(fVar.f41863c));
            statsItem.b("localCount", String.valueOf(fVar.f41864d));
            statsItem.b("localSucCount", String.valueOf(fVar.f41865e));
            statsItem.b("localTime", String.valueOf(fVar.f41866f));
            statsItem.b("netCount", String.valueOf(fVar.f41867g));
            statsItem.b("netSucCount", String.valueOf(fVar.f41868h));
            statsItem.b("netTime", String.valueOf(fVar.i));
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
            statsItem.b(PmsConstant.Statistic.Key.REV_TOTAL_COUNT, String.valueOf(fVar.r));
            statsItem.b("totalTime", String.valueOf(fVar.s));
            statsItem.b("cdnCount", String.valueOf(fVar.w));
            statsItem.b("ipCount", String.valueOf(fVar.x));
            statsItem.b("cdnAndIpCount", String.valueOf(fVar.y));
            statsItem.b("imgSize", String.valueOf(fVar.z));
            statsItem.b("nettype", b(i));
            BdStatisticsManager.getInstance().performance("image", statsItem);
        }
    }

    public static void i(boolean z, long j) {
        f a2 = a();
        a2.f41861a++;
        if (z) {
            a2.f41862b++;
            a2.f41863c += j;
        }
    }

    public static void j(boolean z, String str, d.b.b.e.j.a.d dVar, long j, long j2) {
        if (l.C()) {
            synchronized (f41842b) {
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
                a2.f41867g++;
                if (z) {
                    a2.f41868h++;
                    a2.i += j;
                    a2.z += j2;
                }
                if (f41841a.a() > 100) {
                    g();
                }
            }
        }
    }

    public static void k(boolean z, long j) {
        synchronized (f41842b) {
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
        synchronized (f41842b) {
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
