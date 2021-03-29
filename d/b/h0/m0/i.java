package d.b.h0.m0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes3.dex */
public class i extends j {

    /* renamed from: b  reason: collision with root package name */
    public static int f50329b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static int f50330c = 10;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static int f50331a;

        /* renamed from: b  reason: collision with root package name */
        public static int f50332b;

        /* renamed from: c  reason: collision with root package name */
        public static int f50333c;

        public static void a() {
            d.b.b.e.n.a a2 = j.a();
            a2.b("action", "imbusy");
            a2.b("totalNum", String.valueOf(f50331a));
            a2.b("tfailNum", String.valueOf(f50332b));
            a2.b("qfailNum", String.valueOf(f50333c));
            BdStatisticsManager.getInstance().performance("im", a2);
            b();
        }

        public static void b() {
            f50331a = 0;
            f50332b = 0;
            f50333c = 0;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static int f50334a;

        /* renamed from: b  reason: collision with root package name */
        public static long f50335b;

        /* renamed from: c  reason: collision with root package name */
        public static long f50336c;

        /* renamed from: d  reason: collision with root package name */
        public static long f50337d;

        /* renamed from: e  reason: collision with root package name */
        public static int f50338e;

        /* renamed from: f  reason: collision with root package name */
        public static int f50339f;

        /* renamed from: g  reason: collision with root package name */
        public static long f50340g;

        public static void a() {
            d.b.b.e.n.a a2 = j.a();
            a2.b("action", "imcost");
            a2.b("dect", String.valueOf(f50335b));
            a2.b("dlsize", String.valueOf(f50336c));
            a2.b("dbt", String.valueOf(f50337d));
            a2.b("pnum", String.valueOf(f50338e));
            a2.b("reqcost", String.valueOf(f50340g));
            a2.b("cpu", String.valueOf(f50339f));
            a2.b("totalNum", String.valueOf(f50334a));
            BdStatisticsManager.getInstance().performance("im", a2);
            b();
        }

        public static void b() {
            f50334a = 0;
            f50335b = 0L;
            f50336c = 0L;
            f50337d = 0L;
            f50338e = 0;
            f50339f = 0;
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        a.f50331a++;
        if (z2) {
            a.f50332b++;
        } else if (z3) {
            a.f50333c++;
        }
        if (a.f50331a > f50329b) {
            a.a();
        }
    }

    public static void d() {
        if (k.d().g()) {
            if (b.f50334a > f50330c) {
                b.a();
            }
            if (a.f50331a > f50330c) {
                a.a();
            }
        }
    }

    public void c(f fVar) {
        if (k.d().g()) {
            if (b.f50334a < f50329b) {
                b.f50335b += fVar.f50312b;
                b.f50336c += fVar.f50313c;
                b.f50337d += fVar.f50314d;
                b.f50338e += fVar.f50315e;
                b.f50340g += fVar.f50316f;
                b.f50339f += fVar.f50317g;
                b.f50334a++;
                return;
            }
            b.a();
        }
    }
}
