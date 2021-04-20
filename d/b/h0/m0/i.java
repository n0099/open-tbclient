package d.b.h0.m0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes3.dex */
public class i extends j {

    /* renamed from: b  reason: collision with root package name */
    public static int f50736b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static int f50737c = 10;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static int f50738a;

        /* renamed from: b  reason: collision with root package name */
        public static int f50739b;

        /* renamed from: c  reason: collision with root package name */
        public static int f50740c;

        public static void a() {
            d.b.c.e.n.a a2 = j.a();
            a2.b("action", "imbusy");
            a2.b("totalNum", String.valueOf(f50738a));
            a2.b("tfailNum", String.valueOf(f50739b));
            a2.b("qfailNum", String.valueOf(f50740c));
            BdStatisticsManager.getInstance().performance("im", a2);
            b();
        }

        public static void b() {
            f50738a = 0;
            f50739b = 0;
            f50740c = 0;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static int f50741a;

        /* renamed from: b  reason: collision with root package name */
        public static long f50742b;

        /* renamed from: c  reason: collision with root package name */
        public static long f50743c;

        /* renamed from: d  reason: collision with root package name */
        public static long f50744d;

        /* renamed from: e  reason: collision with root package name */
        public static int f50745e;

        /* renamed from: f  reason: collision with root package name */
        public static int f50746f;

        /* renamed from: g  reason: collision with root package name */
        public static long f50747g;

        public static void a() {
            d.b.c.e.n.a a2 = j.a();
            a2.b("action", "imcost");
            a2.b("dect", String.valueOf(f50742b));
            a2.b("dlsize", String.valueOf(f50743c));
            a2.b("dbt", String.valueOf(f50744d));
            a2.b("pnum", String.valueOf(f50745e));
            a2.b("reqcost", String.valueOf(f50747g));
            a2.b("cpu", String.valueOf(f50746f));
            a2.b("totalNum", String.valueOf(f50741a));
            BdStatisticsManager.getInstance().performance("im", a2);
            b();
        }

        public static void b() {
            f50741a = 0;
            f50742b = 0L;
            f50743c = 0L;
            f50744d = 0L;
            f50745e = 0;
            f50746f = 0;
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        a.f50738a++;
        if (z2) {
            a.f50739b++;
        } else if (z3) {
            a.f50740c++;
        }
        if (a.f50738a > f50736b) {
            a.a();
        }
    }

    public static void d() {
        if (k.d().g()) {
            if (b.f50741a > f50737c) {
                b.a();
            }
            if (a.f50738a > f50737c) {
                a.a();
            }
        }
    }

    public void c(f fVar) {
        if (k.d().g()) {
            if (b.f50741a < f50736b) {
                b.f50742b += fVar.f50719b;
                b.f50743c += fVar.f50720c;
                b.f50744d += fVar.f50721d;
                b.f50745e += fVar.f50722e;
                b.f50747g += fVar.f50723f;
                b.f50746f += fVar.f50724g;
                b.f50741a++;
                return;
            }
            b.a();
        }
    }
}
