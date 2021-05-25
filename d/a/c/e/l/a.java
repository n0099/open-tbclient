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
    public static b f38689a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final Object f38690b = new Object();

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public f f38691a;

        /* renamed from: b  reason: collision with root package name */
        public f f38692b;

        /* renamed from: c  reason: collision with root package name */
        public f f38693c;

        /* renamed from: d  reason: collision with root package name */
        public f f38694d;

        public b() {
            this.f38691a = new f();
            this.f38692b = new f();
            this.f38693c = new f();
            this.f38694d = new f();
        }

        public int a() {
            return this.f38691a.f38716g + this.f38692b.f38716g + this.f38693c.f38716g + this.f38694d.f38716g;
        }

        public boolean b() {
            return this.f38693c.f38716g > 0;
        }

        public boolean c() {
            return this.f38692b.f38716g > 0;
        }

        public boolean d() {
            return this.f38691a.f38716g > 0;
        }

        public boolean e() {
            return this.f38694d.f38716g > 0;
        }

        public void f() {
            this.f38691a.a();
            this.f38692b.a();
            this.f38693c.a();
            this.f38694d.a();
        }
    }

    public static f a() {
        if (j.H()) {
            return f38689a.f38694d;
        }
        if (j.v()) {
            return f38689a.f38693c;
        }
        if (j.u()) {
            return f38689a.f38692b;
        }
        return f38689a.f38691a;
    }

    public static String b(int i2) {
        return 1 == i2 ? "2G" : 2 == i2 ? g.f3966b : 3 == i2 ? "4G" : 4 == i2 ? "5G" : 5 == i2 ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : "N";
    }

    public static void c(boolean z, long j) {
        synchronized (f38690b) {
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
        synchronized (f38690b) {
            f a2 = a();
            a2.f38713d++;
            if (z) {
                a2.f38714e++;
                a2.f38715f += j;
            }
        }
    }

    public static void g() {
        if (f38689a.a() > 10) {
            if (f38689a.e()) {
                h(f38689a.f38694d, 5);
            }
            if (f38689a.b()) {
                h(f38689a.f38693c, 3);
            }
            if (f38689a.c()) {
                h(f38689a.f38692b, 2);
            }
            if (f38689a.d()) {
                h(f38689a.f38691a, 1);
            }
            f38689a.f();
        }
    }

    public static void h(f fVar, int i2) {
        if (fVar != null && BdBaseApplication.getInst().isSmallFlow()) {
            d.a.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
            statsItem.b("action", "imgStat");
            statsItem.b("memoryCount", String.valueOf(fVar.f38710a));
            statsItem.b("memorySucCount", String.valueOf(fVar.f38711b));
            statsItem.b("memoryTime", String.valueOf(fVar.f38712c));
            statsItem.b("localCount", String.valueOf(fVar.f38713d));
            statsItem.b("localSucCount", String.valueOf(fVar.f38714e));
            statsItem.b("localTime", String.valueOf(fVar.f38715f));
            statsItem.b("netCount", String.valueOf(fVar.f38716g));
            statsItem.b("netSucCount", String.valueOf(fVar.f38717h));
            statsItem.b("netTime", String.valueOf(fVar.f38718i));
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
        a2.f38710a++;
        if (z) {
            a2.f38711b++;
            a2.f38712c += j;
        }
    }

    public static void j(boolean z, String str, d.a.c.e.j.a.d dVar, long j, long j2) {
        if (l.D()) {
            synchronized (f38690b) {
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
                a2.f38716g++;
                if (z) {
                    a2.f38717h++;
                    a2.f38718i += j;
                    a2.z += j2;
                }
                if (f38689a.a() > 100) {
                    g();
                }
            }
        }
    }

    public static void k(boolean z, long j) {
        synchronized (f38690b) {
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
        synchronized (f38690b) {
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
