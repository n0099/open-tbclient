package d.b.h0.r.q;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class d {
    public static final Set<String> j = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    public String f51156a;

    /* renamed from: b  reason: collision with root package name */
    public int f51157b;

    /* renamed from: c  reason: collision with root package name */
    public String f51158c;

    /* renamed from: d  reason: collision with root package name */
    public String f51159d;

    /* renamed from: e  reason: collision with root package name */
    public String f51160e;

    /* renamed from: f  reason: collision with root package name */
    public String f51161f;

    /* renamed from: g  reason: collision with root package name */
    public String f51162g;

    /* renamed from: h  reason: collision with root package name */
    public String f51163h;
    public boolean i;

    public static boolean a(String str) {
        return j.contains(str);
    }

    public static void b(AdvertAppInfo advertAppInfo) {
        d dVar;
        if (advertAppInfo == null || (dVar = advertAppInfo.Y3) == null || dVar.i || a(dVar.f51163h)) {
            return;
        }
        d.b.i0.s2.f0.c b2 = d.b.i0.s2.f0.h.b(advertAppInfo, 3, dVar.f51157b);
        b2.h(dVar.f51156a);
        b2.a("isCache", dVar.f51158c);
        b2.e(dVar.f51160e);
        b2.f(dVar.f51161f);
        b2.g(dVar.f51159d);
        b2.a("vc", dVar.f51162g);
        b2.u(dVar.f51163h);
        d.b.i0.s2.f0.e.b().d(b2);
        d.b.i0.j1.o.h.c.g(d.b.i0.j1.o.h.c.e(advertAppInfo));
        dVar.i = true;
        j.add(dVar.f51163h);
    }

    public static void c(d dVar, int i, boolean z) {
        if (dVar == null || dVar.i || a(dVar.f51163h)) {
            return;
        }
        d.b.i0.s2.f0.c g2 = d.b.i0.s2.f0.h.g(z ? 13 : 3, i, dVar.f51157b);
        g2.h(dVar.f51156a);
        g2.a("isCache", String.valueOf(dVar.f51158c));
        g2.e(dVar.f51160e);
        g2.f(dVar.f51161f);
        g2.g(dVar.f51159d);
        g2.a("vc", dVar.f51162g);
        g2.u(dVar.f51163h);
        d.b.i0.s2.f0.e.b().d(g2);
        dVar.i = true;
        j.add(dVar.f51163h);
    }

    public static void d(d.b.i0.x.e0.d dVar) {
        if (dVar == null || dVar.g() == null || dVar.g().Y3 == null || dVar.g().Y3.i || a(dVar.g().Y3.f51163h)) {
            return;
        }
        dVar.g().c4 = dVar.g().Y3.f51156a;
        d.b.h0.u.a.l().u(dVar.g(), "", 0L, dVar.g().c4, "show", dVar.g().Y3.f51157b);
        d.b.i0.s2.f0.c c2 = d.b.i0.s2.f0.h.c(dVar.g(), 3, dVar.g().Y3.f51157b);
        c2.u(dVar.g().Y3.f51163h);
        d.b.i0.s2.f0.e.b().d(c2);
        d.b.i0.j1.o.h.c.g(d.b.i0.j1.o.h.c.e(dVar.g()));
        dVar.g().Y3.i = true;
        j.add(dVar.g().Y3.f51163h);
    }

    public static void e(d dVar, int i, boolean z) {
        if (dVar == null || dVar.i || a(dVar.f51163h)) {
            return;
        }
        d.b.i0.s2.f0.c g2 = d.b.i0.s2.f0.h.g(z ? 13 : 3, i, dVar.f51157b);
        g2.h(dVar.f51156a);
        g2.u(dVar.f51163h);
        d.b.i0.s2.f0.e.b().d(g2);
        dVar.i = true;
        j.add(dVar.f51163h);
    }

    public static void f(d.b.i0.d3.h0.o oVar) {
        if (oVar == null || oVar.D0() == null) {
            return;
        }
        d dVar = oVar.D0().advertAppContext;
        if (oVar.N0 || !(dVar == null || dVar.i || a(dVar.f51163h))) {
            oVar.C0 = dVar.f51160e;
            oVar.D0 = dVar.f51161f;
            oVar.B0 = dVar.f51159d;
            int i = 3;
            if (oVar != null && oVar.F0() != null && oVar.F0().forFree()) {
                i = 103;
            }
            d.b.i0.s2.f0.c e2 = d.b.i0.s2.f0.h.e(oVar, i);
            e2.u(dVar.f51163h);
            d.b.i0.s2.f0.e.b().d(e2);
            if (!oVar.N0) {
                d.b.i0.j1.o.h.c.g(d.b.i0.j1.o.h.c.e(oVar.L0()));
            }
            dVar.i = true;
            j.add(dVar.f51163h);
        }
    }

    public static void g(d dVar, int i, boolean z) {
        if (dVar == null || dVar.i || a(dVar.f51163h)) {
            return;
        }
        int i2 = z ? 13 : 3;
        d.b.i0.s2.f0.c cVar = new d.b.i0.s2.f0.c();
        cVar.j(i2);
        if ("PB_BANNER".equals(dVar.f51156a)) {
            cVar.d(-1);
            cVar.w(-1);
        } else {
            cVar.d(i);
            cVar.w(dVar.f51157b);
        }
        cVar.h(dVar.f51156a);
        cVar.e(dVar.f51160e);
        cVar.f(dVar.f51161f);
        cVar.g(dVar.f51159d);
        cVar.a("vc", dVar.f51162g);
        cVar.u(dVar.f51163h);
        d.b.i0.s2.f0.e.b().d(cVar);
        dVar.i = true;
        j.add(dVar.f51163h);
    }

    public static void h(d.b.d.d dVar) {
        if (dVar == null || dVar.j() == null || dVar.i || TextUtils.isEmpty(dVar.j().f43083b) || a(dVar.j().f43083b)) {
            return;
        }
        d.b.i0.s2.f0.e.b().d(d.b.i0.s2.f0.h.a(dVar, 3, dVar.n()));
        d.b.i0.j1.o.h.c.g(dVar);
        dVar.i = true;
        j.add(dVar.j().f43083b);
    }
}
