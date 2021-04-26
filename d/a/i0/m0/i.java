package d.a.i0.m0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes3.dex */
public class i extends j {

    /* renamed from: b  reason: collision with root package name */
    public static int f48674b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static int f48675c = 10;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static int f48676a;

        /* renamed from: b  reason: collision with root package name */
        public static int f48677b;

        /* renamed from: c  reason: collision with root package name */
        public static int f48678c;

        public static void a() {
            d.a.c.e.n.a a2 = j.a();
            a2.b("action", "imbusy");
            a2.b("totalNum", String.valueOf(f48676a));
            a2.b("tfailNum", String.valueOf(f48677b));
            a2.b("qfailNum", String.valueOf(f48678c));
            BdStatisticsManager.getInstance().performance("im", a2);
            b();
        }

        public static void b() {
            f48676a = 0;
            f48677b = 0;
            f48678c = 0;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static int f48679a;

        /* renamed from: b  reason: collision with root package name */
        public static long f48680b;

        /* renamed from: c  reason: collision with root package name */
        public static long f48681c;

        /* renamed from: d  reason: collision with root package name */
        public static long f48682d;

        /* renamed from: e  reason: collision with root package name */
        public static int f48683e;

        /* renamed from: f  reason: collision with root package name */
        public static int f48684f;

        /* renamed from: g  reason: collision with root package name */
        public static long f48685g;

        public static void a() {
            d.a.c.e.n.a a2 = j.a();
            a2.b("action", "imcost");
            a2.b("dect", String.valueOf(f48680b));
            a2.b("dlsize", String.valueOf(f48681c));
            a2.b("dbt", String.valueOf(f48682d));
            a2.b("pnum", String.valueOf(f48683e));
            a2.b("reqcost", String.valueOf(f48685g));
            a2.b("cpu", String.valueOf(f48684f));
            a2.b("totalNum", String.valueOf(f48679a));
            BdStatisticsManager.getInstance().performance("im", a2);
            b();
        }

        public static void b() {
            f48679a = 0;
            f48680b = 0L;
            f48681c = 0L;
            f48682d = 0L;
            f48683e = 0;
            f48684f = 0;
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        a.f48676a++;
        if (z2) {
            a.f48677b++;
        } else if (z3) {
            a.f48678c++;
        }
        if (a.f48676a > f48674b) {
            a.a();
        }
    }

    public static void d() {
        if (k.d().g()) {
            if (b.f48679a > f48675c) {
                b.a();
            }
            if (a.f48676a > f48675c) {
                a.a();
            }
        }
    }

    public void c(f fVar) {
        if (k.d().g()) {
            if (b.f48679a < f48674b) {
                b.f48680b += fVar.f48655b;
                b.f48681c += fVar.f48656c;
                b.f48682d += fVar.f48657d;
                b.f48683e += fVar.f48658e;
                b.f48685g += fVar.f48659f;
                b.f48684f += fVar.f48660g;
                b.f48679a++;
                return;
            }
            b.a();
        }
    }
}
