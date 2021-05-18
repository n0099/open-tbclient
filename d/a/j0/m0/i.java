package d.a.j0.m0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes3.dex */
public class i extends j {

    /* renamed from: b  reason: collision with root package name */
    public static int f49503b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static int f49504c = 10;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static int f49505a;

        /* renamed from: b  reason: collision with root package name */
        public static int f49506b;

        /* renamed from: c  reason: collision with root package name */
        public static int f49507c;

        public static void a() {
            d.a.c.e.n.a a2 = j.a();
            a2.b("action", "imbusy");
            a2.b("totalNum", String.valueOf(f49505a));
            a2.b("tfailNum", String.valueOf(f49506b));
            a2.b("qfailNum", String.valueOf(f49507c));
            BdStatisticsManager.getInstance().performance("im", a2);
            b();
        }

        public static void b() {
            f49505a = 0;
            f49506b = 0;
            f49507c = 0;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static int f49508a;

        /* renamed from: b  reason: collision with root package name */
        public static long f49509b;

        /* renamed from: c  reason: collision with root package name */
        public static long f49510c;

        /* renamed from: d  reason: collision with root package name */
        public static long f49511d;

        /* renamed from: e  reason: collision with root package name */
        public static int f49512e;

        /* renamed from: f  reason: collision with root package name */
        public static int f49513f;

        /* renamed from: g  reason: collision with root package name */
        public static long f49514g;

        public static void a() {
            d.a.c.e.n.a a2 = j.a();
            a2.b("action", "imcost");
            a2.b("dect", String.valueOf(f49509b));
            a2.b("dlsize", String.valueOf(f49510c));
            a2.b("dbt", String.valueOf(f49511d));
            a2.b("pnum", String.valueOf(f49512e));
            a2.b("reqcost", String.valueOf(f49514g));
            a2.b("cpu", String.valueOf(f49513f));
            a2.b("totalNum", String.valueOf(f49508a));
            BdStatisticsManager.getInstance().performance("im", a2);
            b();
        }

        public static void b() {
            f49508a = 0;
            f49509b = 0L;
            f49510c = 0L;
            f49511d = 0L;
            f49512e = 0;
            f49513f = 0;
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        a.f49505a++;
        if (z2) {
            a.f49506b++;
        } else if (z3) {
            a.f49507c++;
        }
        if (a.f49505a > f49503b) {
            a.a();
        }
    }

    public static void d() {
        if (k.d().g()) {
            if (b.f49508a > f49504c) {
                b.a();
            }
            if (a.f49505a > f49504c) {
                a.a();
            }
        }
    }

    public void c(f fVar) {
        if (k.d().g()) {
            if (b.f49508a < f49503b) {
                b.f49509b += fVar.f49484b;
                b.f49510c += fVar.f49485c;
                b.f49511d += fVar.f49486d;
                b.f49512e += fVar.f49487e;
                b.f49514g += fVar.f49488f;
                b.f49513f += fVar.f49489g;
                b.f49508a++;
                return;
            }
            b.a();
        }
    }
}
