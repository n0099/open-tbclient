package d.b.h0.m0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes3.dex */
public class i extends j {

    /* renamed from: b  reason: collision with root package name */
    public static int f50328b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static int f50329c = 10;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static int f50330a;

        /* renamed from: b  reason: collision with root package name */
        public static int f50331b;

        /* renamed from: c  reason: collision with root package name */
        public static int f50332c;

        public static void a() {
            d.b.b.e.n.a a2 = j.a();
            a2.b("action", "imbusy");
            a2.b("totalNum", String.valueOf(f50330a));
            a2.b("tfailNum", String.valueOf(f50331b));
            a2.b("qfailNum", String.valueOf(f50332c));
            BdStatisticsManager.getInstance().performance("im", a2);
            b();
        }

        public static void b() {
            f50330a = 0;
            f50331b = 0;
            f50332c = 0;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static int f50333a;

        /* renamed from: b  reason: collision with root package name */
        public static long f50334b;

        /* renamed from: c  reason: collision with root package name */
        public static long f50335c;

        /* renamed from: d  reason: collision with root package name */
        public static long f50336d;

        /* renamed from: e  reason: collision with root package name */
        public static int f50337e;

        /* renamed from: f  reason: collision with root package name */
        public static int f50338f;

        /* renamed from: g  reason: collision with root package name */
        public static long f50339g;

        public static void a() {
            d.b.b.e.n.a a2 = j.a();
            a2.b("action", "imcost");
            a2.b("dect", String.valueOf(f50334b));
            a2.b("dlsize", String.valueOf(f50335c));
            a2.b("dbt", String.valueOf(f50336d));
            a2.b("pnum", String.valueOf(f50337e));
            a2.b("reqcost", String.valueOf(f50339g));
            a2.b("cpu", String.valueOf(f50338f));
            a2.b("totalNum", String.valueOf(f50333a));
            BdStatisticsManager.getInstance().performance("im", a2);
            b();
        }

        public static void b() {
            f50333a = 0;
            f50334b = 0L;
            f50335c = 0L;
            f50336d = 0L;
            f50337e = 0;
            f50338f = 0;
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        a.f50330a++;
        if (z2) {
            a.f50331b++;
        } else if (z3) {
            a.f50332c++;
        }
        if (a.f50330a > f50328b) {
            a.a();
        }
    }

    public static void d() {
        if (k.d().g()) {
            if (b.f50333a > f50329c) {
                b.a();
            }
            if (a.f50330a > f50329c) {
                a.a();
            }
        }
    }

    public void c(f fVar) {
        if (k.d().g()) {
            if (b.f50333a < f50328b) {
                b.f50334b += fVar.f50311b;
                b.f50335c += fVar.f50312c;
                b.f50336d += fVar.f50313d;
                b.f50337e += fVar.f50314e;
                b.f50339g += fVar.f50315f;
                b.f50338f += fVar.f50316g;
                b.f50333a++;
                return;
            }
            b.a();
        }
    }
}
