package d.b.h0.r.q;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class d {
    public static final Set<String> j = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    public String f50749a;

    /* renamed from: b  reason: collision with root package name */
    public int f50750b;

    /* renamed from: c  reason: collision with root package name */
    public String f50751c;

    /* renamed from: d  reason: collision with root package name */
    public String f50752d;

    /* renamed from: e  reason: collision with root package name */
    public String f50753e;

    /* renamed from: f  reason: collision with root package name */
    public String f50754f;

    /* renamed from: g  reason: collision with root package name */
    public String f50755g;

    /* renamed from: h  reason: collision with root package name */
    public String f50756h;
    public boolean i;

    public static boolean a(String str) {
        return j.contains(str);
    }

    public static void b(AdvertAppInfo advertAppInfo) {
        d dVar;
        if (advertAppInfo == null || (dVar = advertAppInfo.Y3) == null || dVar.i || a(dVar.f50756h)) {
            return;
        }
        d.b.i0.r2.b0.c b2 = d.b.i0.r2.b0.h.b(advertAppInfo, 3, dVar.f50750b);
        b2.h(dVar.f50749a);
        b2.a("isCache", dVar.f50751c);
        b2.e(dVar.f50753e);
        b2.f(dVar.f50754f);
        b2.g(dVar.f50752d);
        b2.a("vc", dVar.f50755g);
        b2.s(dVar.f50756h);
        d.b.i0.r2.b0.e.b().d(b2);
        d.b.i0.i1.o.h.c.g(d.b.i0.i1.o.h.c.e(advertAppInfo));
        dVar.i = true;
        j.add(dVar.f50756h);
    }

    public static void c(d dVar, int i, boolean z) {
        if (dVar == null || dVar.i || a(dVar.f50756h)) {
            return;
        }
        d.b.i0.r2.b0.c g2 = d.b.i0.r2.b0.h.g(z ? 13 : 3, i, dVar.f50750b);
        g2.h(dVar.f50749a);
        g2.a("isCache", String.valueOf(dVar.f50751c));
        g2.e(dVar.f50753e);
        g2.f(dVar.f50754f);
        g2.g(dVar.f50752d);
        g2.a("vc", dVar.f50755g);
        g2.s(dVar.f50756h);
        d.b.i0.r2.b0.e.b().d(g2);
        dVar.i = true;
        j.add(dVar.f50756h);
    }

    public static void d(d.b.i0.x.e0.d dVar) {
        if (dVar == null || dVar.g() == null || dVar.g().Y3 == null || dVar.g().Y3.i || a(dVar.g().Y3.f50756h)) {
            return;
        }
        dVar.g().c4 = dVar.g().Y3.f50749a;
        d.b.h0.u.a.l().u(dVar.g(), "", 0L, dVar.g().c4, "show", dVar.g().Y3.f50750b);
        d.b.i0.r2.b0.c c2 = d.b.i0.r2.b0.h.c(dVar.g(), 3, dVar.g().Y3.f50750b);
        c2.s(dVar.g().Y3.f50756h);
        d.b.i0.r2.b0.e.b().d(c2);
        d.b.i0.i1.o.h.c.g(d.b.i0.i1.o.h.c.e(dVar.g()));
        dVar.g().Y3.i = true;
        j.add(dVar.g().Y3.f50756h);
    }

    public static void e(d dVar, int i, boolean z) {
        if (dVar == null || dVar.i || a(dVar.f50756h)) {
            return;
        }
        d.b.i0.r2.b0.c g2 = d.b.i0.r2.b0.h.g(z ? 13 : 3, i, dVar.f50750b);
        g2.h(dVar.f50749a);
        g2.s(dVar.f50756h);
        d.b.i0.r2.b0.e.b().d(g2);
        dVar.i = true;
        j.add(dVar.f50756h);
    }

    public static void f(d.b.i0.c3.h0.o oVar) {
        if (oVar == null || oVar.B0() == null) {
            return;
        }
        d dVar = oVar.B0().advertAppContext;
        if (oVar.M0 || !(dVar == null || dVar.i || a(dVar.f50756h))) {
            oVar.B0 = dVar.f50753e;
            oVar.C0 = dVar.f50754f;
            oVar.A0 = dVar.f50752d;
            int i = 3;
            if (oVar != null && oVar.D0() != null && oVar.D0().forFree()) {
                i = 103;
            }
            d.b.i0.r2.b0.c e2 = d.b.i0.r2.b0.h.e(oVar, i);
            e2.s(dVar.f50756h);
            d.b.i0.r2.b0.e.b().d(e2);
            if (!oVar.M0) {
                d.b.i0.i1.o.h.c.g(d.b.i0.i1.o.h.c.e(oVar.J0()));
            }
            dVar.i = true;
            j.add(dVar.f50756h);
        }
    }

    public static void g(d dVar, int i, boolean z) {
        if (dVar == null || dVar.i || a(dVar.f50756h)) {
            return;
        }
        int i2 = z ? 13 : 3;
        d.b.i0.r2.b0.c cVar = new d.b.i0.r2.b0.c();
        cVar.j(i2);
        if ("PB_BANNER".equals(dVar.f50749a)) {
            cVar.d(-1);
            cVar.u(-1);
        } else {
            cVar.d(i);
            cVar.u(dVar.f50750b);
        }
        cVar.h(dVar.f50749a);
        cVar.e(dVar.f50753e);
        cVar.f(dVar.f50754f);
        cVar.g(dVar.f50752d);
        cVar.a("vc", dVar.f50755g);
        cVar.s(dVar.f50756h);
        d.b.i0.r2.b0.e.b().d(cVar);
        dVar.i = true;
        j.add(dVar.f50756h);
    }

    public static void h(d.b.c.d dVar) {
        if (dVar == null || dVar.j() == null || dVar.i || TextUtils.isEmpty(dVar.j().f42493b) || a(dVar.j().f42493b)) {
            return;
        }
        d.b.i0.r2.b0.e.b().d(d.b.i0.r2.b0.h.a(dVar, 3, dVar.n()));
        d.b.i0.i1.o.h.c.g(dVar);
        dVar.i = true;
        j.add(dVar.j().f42493b);
    }
}
