package d.a.n0.m0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes3.dex */
public class i extends j {

    /* renamed from: b  reason: collision with root package name */
    public static int f53329b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static int f53330c = 10;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static int f53331a;

        /* renamed from: b  reason: collision with root package name */
        public static int f53332b;

        /* renamed from: c  reason: collision with root package name */
        public static int f53333c;

        public static void a() {
            d.a.c.e.n.a a2 = j.a();
            a2.b("action", "imbusy");
            a2.b("totalNum", String.valueOf(f53331a));
            a2.b("tfailNum", String.valueOf(f53332b));
            a2.b("qfailNum", String.valueOf(f53333c));
            BdStatisticsManager.getInstance().performance("im", a2);
            b();
        }

        public static void b() {
            f53331a = 0;
            f53332b = 0;
            f53333c = 0;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static int f53334a;

        /* renamed from: b  reason: collision with root package name */
        public static long f53335b;

        /* renamed from: c  reason: collision with root package name */
        public static long f53336c;

        /* renamed from: d  reason: collision with root package name */
        public static long f53337d;

        /* renamed from: e  reason: collision with root package name */
        public static int f53338e;

        /* renamed from: f  reason: collision with root package name */
        public static int f53339f;

        /* renamed from: g  reason: collision with root package name */
        public static long f53340g;

        public static void a() {
            d.a.c.e.n.a a2 = j.a();
            a2.b("action", "imcost");
            a2.b("dect", String.valueOf(f53335b));
            a2.b("dlsize", String.valueOf(f53336c));
            a2.b("dbt", String.valueOf(f53337d));
            a2.b("pnum", String.valueOf(f53338e));
            a2.b("reqcost", String.valueOf(f53340g));
            a2.b("cpu", String.valueOf(f53339f));
            a2.b("totalNum", String.valueOf(f53334a));
            BdStatisticsManager.getInstance().performance("im", a2);
            b();
        }

        public static void b() {
            f53334a = 0;
            f53335b = 0L;
            f53336c = 0L;
            f53337d = 0L;
            f53338e = 0;
            f53339f = 0;
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        a.f53331a++;
        if (z2) {
            a.f53332b++;
        } else if (z3) {
            a.f53333c++;
        }
        if (a.f53331a > f53329b) {
            a.a();
        }
    }

    public static void d() {
        if (k.d().g()) {
            if (b.f53334a > f53330c) {
                b.a();
            }
            if (a.f53331a > f53330c) {
                a.a();
            }
        }
    }

    public void c(f fVar) {
        if (k.d().g()) {
            if (b.f53334a < f53329b) {
                b.f53335b += fVar.f53310b;
                b.f53336c += fVar.f53311c;
                b.f53337d += fVar.f53312d;
                b.f53338e += fVar.f53313e;
                b.f53340g += fVar.f53314f;
                b.f53339f += fVar.f53315g;
                b.f53334a++;
                return;
            }
            b.a();
        }
    }
}
