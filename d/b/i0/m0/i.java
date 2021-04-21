package d.b.i0.m0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes3.dex */
public class i extends j {

    /* renamed from: b  reason: collision with root package name */
    public static int f51072b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static int f51073c = 10;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static int f51074a;

        /* renamed from: b  reason: collision with root package name */
        public static int f51075b;

        /* renamed from: c  reason: collision with root package name */
        public static int f51076c;

        public static void a() {
            d.b.c.e.n.a a2 = j.a();
            a2.b("action", "imbusy");
            a2.b("totalNum", String.valueOf(f51074a));
            a2.b("tfailNum", String.valueOf(f51075b));
            a2.b("qfailNum", String.valueOf(f51076c));
            BdStatisticsManager.getInstance().performance("im", a2);
            b();
        }

        public static void b() {
            f51074a = 0;
            f51075b = 0;
            f51076c = 0;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static int f51077a;

        /* renamed from: b  reason: collision with root package name */
        public static long f51078b;

        /* renamed from: c  reason: collision with root package name */
        public static long f51079c;

        /* renamed from: d  reason: collision with root package name */
        public static long f51080d;

        /* renamed from: e  reason: collision with root package name */
        public static int f51081e;

        /* renamed from: f  reason: collision with root package name */
        public static int f51082f;

        /* renamed from: g  reason: collision with root package name */
        public static long f51083g;

        public static void a() {
            d.b.c.e.n.a a2 = j.a();
            a2.b("action", "imcost");
            a2.b("dect", String.valueOf(f51078b));
            a2.b("dlsize", String.valueOf(f51079c));
            a2.b("dbt", String.valueOf(f51080d));
            a2.b("pnum", String.valueOf(f51081e));
            a2.b("reqcost", String.valueOf(f51083g));
            a2.b("cpu", String.valueOf(f51082f));
            a2.b("totalNum", String.valueOf(f51077a));
            BdStatisticsManager.getInstance().performance("im", a2);
            b();
        }

        public static void b() {
            f51077a = 0;
            f51078b = 0L;
            f51079c = 0L;
            f51080d = 0L;
            f51081e = 0;
            f51082f = 0;
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        a.f51074a++;
        if (z2) {
            a.f51075b++;
        } else if (z3) {
            a.f51076c++;
        }
        if (a.f51074a > f51072b) {
            a.a();
        }
    }

    public static void d() {
        if (k.d().g()) {
            if (b.f51077a > f51073c) {
                b.a();
            }
            if (a.f51074a > f51073c) {
                a.a();
            }
        }
    }

    public void c(f fVar) {
        if (k.d().g()) {
            if (b.f51077a < f51072b) {
                b.f51078b += fVar.f51055b;
                b.f51079c += fVar.f51056c;
                b.f51080d += fVar.f51057d;
                b.f51081e += fVar.f51058e;
                b.f51083g += fVar.f51059f;
                b.f51082f += fVar.f51060g;
                b.f51077a++;
                return;
            }
            b.a();
        }
    }
}
