package d.b.c.e.l;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.apollon.statistics.g;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static b f42339a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final Object f42340b = new Object();

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public f f42341a;

        /* renamed from: b  reason: collision with root package name */
        public f f42342b;

        /* renamed from: c  reason: collision with root package name */
        public f f42343c;

        /* renamed from: d  reason: collision with root package name */
        public f f42344d;

        public b() {
            this.f42341a = new f();
            this.f42342b = new f();
            this.f42343c = new f();
            this.f42344d = new f();
        }

        public int a() {
            return this.f42341a.f42365g + this.f42342b.f42365g + this.f42343c.f42365g + this.f42344d.f42365g;
        }

        public boolean b() {
            return this.f42343c.f42365g > 0;
        }

        public boolean c() {
            return this.f42342b.f42365g > 0;
        }

        public boolean d() {
            return this.f42341a.f42365g > 0;
        }

        public boolean e() {
            return this.f42344d.f42365g > 0;
        }

        public void f() {
            this.f42341a.a();
            this.f42342b.a();
            this.f42343c.a();
            this.f42344d.a();
        }
    }

    public static f a() {
        if (j.H()) {
            return f42339a.f42344d;
        }
        if (j.v()) {
            return f42339a.f42343c;
        }
        if (j.u()) {
            return f42339a.f42342b;
        }
        return f42339a.f42341a;
    }

    public static String b(int i) {
        return 1 == i ? "2G" : 2 == i ? g.f3909b : 3 == i ? "4G" : 4 == i ? "5G" : 5 == i ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : "N";
    }

    public static void c(boolean z, long j) {
        synchronized (f42340b) {
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
        synchronized (f42340b) {
            f a2 = a();
            a2.f42362d++;
            if (z) {
                a2.f42363e++;
                a2.f42364f += j;
            }
        }
    }

    public static void g() {
        if (f42339a.a() > 10) {
            if (f42339a.e()) {
                h(f42339a.f42344d, 5);
            }
            if (f42339a.b()) {
                h(f42339a.f42343c, 3);
            }
            if (f42339a.c()) {
                h(f42339a.f42342b, 2);
            }
            if (f42339a.d()) {
                h(f42339a.f42341a, 1);
            }
            f42339a.f();
        }
    }

    public static void h(f fVar, int i) {
        if (fVar != null && BdBaseApplication.getInst().isSmallFlow()) {
            d.b.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
            statsItem.b("action", "imgStat");
            statsItem.b("memoryCount", String.valueOf(fVar.f42359a));
            statsItem.b("memorySucCount", String.valueOf(fVar.f42360b));
            statsItem.b("memoryTime", String.valueOf(fVar.f42361c));
            statsItem.b("localCount", String.valueOf(fVar.f42362d));
            statsItem.b("localSucCount", String.valueOf(fVar.f42363e));
            statsItem.b("localTime", String.valueOf(fVar.f42364f));
            statsItem.b("netCount", String.valueOf(fVar.f42365g));
            statsItem.b("netSucCount", String.valueOf(fVar.f42366h));
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
        a2.f42359a++;
        if (z) {
            a2.f42360b++;
            a2.f42361c += j;
        }
    }

    public static void j(boolean z, String str, d.b.c.e.j.a.d dVar, long j, long j2) {
        if (l.C()) {
            synchronized (f42340b) {
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
                a2.f42365g++;
                if (z) {
                    a2.f42366h++;
                    a2.i += j;
                    a2.z += j2;
                }
                if (f42339a.a() > 100) {
                    g();
                }
            }
        }
    }

    public static void k(boolean z, long j) {
        synchronized (f42340b) {
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
        synchronized (f42340b) {
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
