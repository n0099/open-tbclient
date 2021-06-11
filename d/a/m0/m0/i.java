package d.a.m0.m0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes3.dex */
public class i extends j {

    /* renamed from: b  reason: collision with root package name */
    public static int f53222b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static int f53223c = 10;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static int f53224a;

        /* renamed from: b  reason: collision with root package name */
        public static int f53225b;

        /* renamed from: c  reason: collision with root package name */
        public static int f53226c;

        public static void a() {
            d.a.c.e.n.a a2 = j.a();
            a2.b("action", "imbusy");
            a2.b("totalNum", String.valueOf(f53224a));
            a2.b("tfailNum", String.valueOf(f53225b));
            a2.b("qfailNum", String.valueOf(f53226c));
            BdStatisticsManager.getInstance().performance("im", a2);
            b();
        }

        public static void b() {
            f53224a = 0;
            f53225b = 0;
            f53226c = 0;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static int f53227a;

        /* renamed from: b  reason: collision with root package name */
        public static long f53228b;

        /* renamed from: c  reason: collision with root package name */
        public static long f53229c;

        /* renamed from: d  reason: collision with root package name */
        public static long f53230d;

        /* renamed from: e  reason: collision with root package name */
        public static int f53231e;

        /* renamed from: f  reason: collision with root package name */
        public static int f53232f;

        /* renamed from: g  reason: collision with root package name */
        public static long f53233g;

        public static void a() {
            d.a.c.e.n.a a2 = j.a();
            a2.b("action", "imcost");
            a2.b("dect", String.valueOf(f53228b));
            a2.b("dlsize", String.valueOf(f53229c));
            a2.b("dbt", String.valueOf(f53230d));
            a2.b("pnum", String.valueOf(f53231e));
            a2.b("reqcost", String.valueOf(f53233g));
            a2.b("cpu", String.valueOf(f53232f));
            a2.b("totalNum", String.valueOf(f53227a));
            BdStatisticsManager.getInstance().performance("im", a2);
            b();
        }

        public static void b() {
            f53227a = 0;
            f53228b = 0L;
            f53229c = 0L;
            f53230d = 0L;
            f53231e = 0;
            f53232f = 0;
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        a.f53224a++;
        if (z2) {
            a.f53225b++;
        } else if (z3) {
            a.f53226c++;
        }
        if (a.f53224a > f53222b) {
            a.a();
        }
    }

    public static void d() {
        if (k.d().g()) {
            if (b.f53227a > f53223c) {
                b.a();
            }
            if (a.f53224a > f53223c) {
                a.a();
            }
        }
    }

    public void c(f fVar) {
        if (k.d().g()) {
            if (b.f53227a < f53222b) {
                b.f53228b += fVar.f53203b;
                b.f53229c += fVar.f53204c;
                b.f53230d += fVar.f53205d;
                b.f53231e += fVar.f53206e;
                b.f53233g += fVar.f53207f;
                b.f53232f += fVar.f53208g;
                b.f53227a++;
                return;
            }
            b.a();
        }
    }
}
