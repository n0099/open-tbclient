package d.a.m0.m0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes3.dex */
public class i extends j {

    /* renamed from: b  reason: collision with root package name */
    public static int f49547b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static int f49548c = 10;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static int f49549a;

        /* renamed from: b  reason: collision with root package name */
        public static int f49550b;

        /* renamed from: c  reason: collision with root package name */
        public static int f49551c;

        public static void a() {
            d.a.c.e.n.a a2 = j.a();
            a2.b("action", "imbusy");
            a2.b("totalNum", String.valueOf(f49549a));
            a2.b("tfailNum", String.valueOf(f49550b));
            a2.b("qfailNum", String.valueOf(f49551c));
            BdStatisticsManager.getInstance().performance("im", a2);
            b();
        }

        public static void b() {
            f49549a = 0;
            f49550b = 0;
            f49551c = 0;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static int f49552a;

        /* renamed from: b  reason: collision with root package name */
        public static long f49553b;

        /* renamed from: c  reason: collision with root package name */
        public static long f49554c;

        /* renamed from: d  reason: collision with root package name */
        public static long f49555d;

        /* renamed from: e  reason: collision with root package name */
        public static int f49556e;

        /* renamed from: f  reason: collision with root package name */
        public static int f49557f;

        /* renamed from: g  reason: collision with root package name */
        public static long f49558g;

        public static void a() {
            d.a.c.e.n.a a2 = j.a();
            a2.b("action", "imcost");
            a2.b("dect", String.valueOf(f49553b));
            a2.b("dlsize", String.valueOf(f49554c));
            a2.b("dbt", String.valueOf(f49555d));
            a2.b("pnum", String.valueOf(f49556e));
            a2.b("reqcost", String.valueOf(f49558g));
            a2.b("cpu", String.valueOf(f49557f));
            a2.b("totalNum", String.valueOf(f49552a));
            BdStatisticsManager.getInstance().performance("im", a2);
            b();
        }

        public static void b() {
            f49552a = 0;
            f49553b = 0L;
            f49554c = 0L;
            f49555d = 0L;
            f49556e = 0;
            f49557f = 0;
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        a.f49549a++;
        if (z2) {
            a.f49550b++;
        } else if (z3) {
            a.f49551c++;
        }
        if (a.f49549a > f49547b) {
            a.a();
        }
    }

    public static void d() {
        if (k.d().g()) {
            if (b.f49552a > f49548c) {
                b.a();
            }
            if (a.f49549a > f49548c) {
                a.a();
            }
        }
    }

    public void c(f fVar) {
        if (k.d().g()) {
            if (b.f49552a < f49547b) {
                b.f49553b += fVar.f49528b;
                b.f49554c += fVar.f49529c;
                b.f49555d += fVar.f49530d;
                b.f49556e += fVar.f49531e;
                b.f49558g += fVar.f49532f;
                b.f49557f += fVar.f49533g;
                b.f49552a++;
                return;
            }
            b.a();
        }
    }
}
