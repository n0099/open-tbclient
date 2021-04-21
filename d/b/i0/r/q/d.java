package d.b.i0.r.q;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class d {
    public static final Set<String> j = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    public String f51492a;

    /* renamed from: b  reason: collision with root package name */
    public int f51493b;

    /* renamed from: c  reason: collision with root package name */
    public String f51494c;

    /* renamed from: d  reason: collision with root package name */
    public String f51495d;

    /* renamed from: e  reason: collision with root package name */
    public String f51496e;

    /* renamed from: f  reason: collision with root package name */
    public String f51497f;

    /* renamed from: g  reason: collision with root package name */
    public String f51498g;

    /* renamed from: h  reason: collision with root package name */
    public String f51499h;
    public boolean i;

    public static boolean a(String str) {
        return j.contains(str);
    }

    public static void b(AdvertAppInfo advertAppInfo) {
        d dVar;
        if (advertAppInfo == null || (dVar = advertAppInfo.Y3) == null || dVar.i || a(dVar.f51499h)) {
            return;
        }
        d.b.j0.s2.f0.c b2 = d.b.j0.s2.f0.h.b(advertAppInfo, 3, dVar.f51493b);
        b2.h(dVar.f51492a);
        b2.a("isCache", dVar.f51494c);
        b2.e(dVar.f51496e);
        b2.f(dVar.f51497f);
        b2.g(dVar.f51495d);
        b2.a("vc", dVar.f51498g);
        b2.u(dVar.f51499h);
        d.b.j0.s2.f0.e.b().d(b2);
        d.b.j0.j1.o.h.c.g(d.b.j0.j1.o.h.c.e(advertAppInfo));
        dVar.i = true;
        j.add(dVar.f51499h);
    }

    public static void c(d dVar, int i, boolean z) {
        if (dVar == null || dVar.i || a(dVar.f51499h)) {
            return;
        }
        d.b.j0.s2.f0.c g2 = d.b.j0.s2.f0.h.g(z ? 13 : 3, i, dVar.f51493b);
        g2.h(dVar.f51492a);
        g2.a("isCache", String.valueOf(dVar.f51494c));
        g2.e(dVar.f51496e);
        g2.f(dVar.f51497f);
        g2.g(dVar.f51495d);
        g2.a("vc", dVar.f51498g);
        g2.u(dVar.f51499h);
        d.b.j0.s2.f0.e.b().d(g2);
        dVar.i = true;
        j.add(dVar.f51499h);
    }

    public static void d(d.b.j0.x.e0.d dVar) {
        if (dVar == null || dVar.g() == null || dVar.g().Y3 == null || dVar.g().Y3.i || a(dVar.g().Y3.f51499h)) {
            return;
        }
        dVar.g().c4 = dVar.g().Y3.f51492a;
        d.b.i0.u.a.l().u(dVar.g(), "", 0L, dVar.g().c4, "show", dVar.g().Y3.f51493b);
        d.b.j0.s2.f0.c c2 = d.b.j0.s2.f0.h.c(dVar.g(), 3, dVar.g().Y3.f51493b);
        c2.u(dVar.g().Y3.f51499h);
        d.b.j0.s2.f0.e.b().d(c2);
        d.b.j0.j1.o.h.c.g(d.b.j0.j1.o.h.c.e(dVar.g()));
        dVar.g().Y3.i = true;
        j.add(dVar.g().Y3.f51499h);
    }

    public static void e(d dVar, int i, boolean z) {
        if (dVar == null || dVar.i || a(dVar.f51499h)) {
            return;
        }
        d.b.j0.s2.f0.c g2 = d.b.j0.s2.f0.h.g(z ? 13 : 3, i, dVar.f51493b);
        g2.h(dVar.f51492a);
        g2.u(dVar.f51499h);
        d.b.j0.s2.f0.e.b().d(g2);
        dVar.i = true;
        j.add(dVar.f51499h);
    }

    public static void f(d.b.j0.d3.h0.o oVar) {
        if (oVar == null || oVar.D0() == null) {
            return;
        }
        d dVar = oVar.D0().advertAppContext;
        if (oVar.N0 || !(dVar == null || dVar.i || a(dVar.f51499h))) {
            oVar.C0 = dVar.f51496e;
            oVar.D0 = dVar.f51497f;
            oVar.B0 = dVar.f51495d;
            int i = 3;
            if (oVar != null && oVar.F0() != null && oVar.F0().forFree()) {
                i = 103;
            }
            d.b.j0.s2.f0.c e2 = d.b.j0.s2.f0.h.e(oVar, i);
            e2.u(dVar.f51499h);
            d.b.j0.s2.f0.e.b().d(e2);
            if (!oVar.N0) {
                d.b.j0.j1.o.h.c.g(d.b.j0.j1.o.h.c.e(oVar.L0()));
            }
            dVar.i = true;
            j.add(dVar.f51499h);
        }
    }

    public static void g(d dVar, int i, boolean z) {
        if (dVar == null || dVar.i || a(dVar.f51499h)) {
            return;
        }
        int i2 = z ? 13 : 3;
        d.b.j0.s2.f0.c cVar = new d.b.j0.s2.f0.c();
        cVar.j(i2);
        if ("PB_BANNER".equals(dVar.f51492a)) {
            cVar.d(-1);
            cVar.w(-1);
        } else {
            cVar.d(i);
            cVar.w(dVar.f51493b);
        }
        cVar.h(dVar.f51492a);
        cVar.e(dVar.f51496e);
        cVar.f(dVar.f51497f);
        cVar.g(dVar.f51495d);
        cVar.a("vc", dVar.f51498g);
        cVar.u(dVar.f51499h);
        d.b.j0.s2.f0.e.b().d(cVar);
        dVar.i = true;
        j.add(dVar.f51499h);
    }

    public static void h(d.b.d.d dVar) {
        if (dVar == null || dVar.j() == null || dVar.i || TextUtils.isEmpty(dVar.j().f43243b) || a(dVar.j().f43243b)) {
            return;
        }
        d.b.j0.s2.f0.e.b().d(d.b.j0.s2.f0.h.a(dVar, 3, dVar.n()));
        d.b.j0.j1.o.h.c.g(dVar);
        dVar.i = true;
        j.add(dVar.j().f43243b);
    }
}
