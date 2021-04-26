package d.a.i0.r.q;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class d {
    public static final Set<String> j = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    public String f49116a;

    /* renamed from: b  reason: collision with root package name */
    public int f49117b;

    /* renamed from: c  reason: collision with root package name */
    public String f49118c;

    /* renamed from: d  reason: collision with root package name */
    public String f49119d;

    /* renamed from: e  reason: collision with root package name */
    public String f49120e;

    /* renamed from: f  reason: collision with root package name */
    public String f49121f;

    /* renamed from: g  reason: collision with root package name */
    public String f49122g;

    /* renamed from: h  reason: collision with root package name */
    public String f49123h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f49124i;

    public static boolean a(String str) {
        return j.contains(str);
    }

    public static void b(AdvertAppInfo advertAppInfo) {
        d dVar;
        if (advertAppInfo == null || (dVar = advertAppInfo.Y3) == null || dVar.f49124i || a(dVar.f49123h)) {
            return;
        }
        d.a.j0.s2.h0.c b2 = d.a.j0.s2.h0.h.b(advertAppInfo, 3, dVar.f49117b);
        b2.h(dVar.f49116a);
        b2.a("isCache", dVar.f49118c);
        b2.e(dVar.f49120e);
        b2.f(dVar.f49121f);
        b2.g(dVar.f49119d);
        b2.a("vc", dVar.f49122g);
        b2.u(dVar.f49123h);
        d.a.j0.s2.h0.e.b().d(b2);
        d.a.j0.j1.o.h.c.g(d.a.j0.j1.o.h.c.e(advertAppInfo));
        dVar.f49124i = true;
        j.add(dVar.f49123h);
    }

    public static void c(d dVar, int i2, boolean z) {
        if (dVar == null || dVar.f49124i || a(dVar.f49123h)) {
            return;
        }
        d.a.j0.s2.h0.c g2 = d.a.j0.s2.h0.h.g(z ? 13 : 3, i2, dVar.f49117b);
        g2.h(dVar.f49116a);
        g2.a("isCache", String.valueOf(dVar.f49118c));
        g2.e(dVar.f49120e);
        g2.f(dVar.f49121f);
        g2.g(dVar.f49119d);
        g2.a("vc", dVar.f49122g);
        g2.u(dVar.f49123h);
        d.a.j0.s2.h0.e.b().d(g2);
        dVar.f49124i = true;
        j.add(dVar.f49123h);
    }

    public static void d(d.a.j0.x.e0.d dVar) {
        if (dVar == null || dVar.h() == null || dVar.h().Y3 == null || dVar.h().Y3.f49124i || a(dVar.h().Y3.f49123h)) {
            return;
        }
        dVar.h().c4 = dVar.h().Y3.f49116a;
        d.a.i0.u.a.l().u(dVar.h(), "", 0L, dVar.h().c4, "show", dVar.h().Y3.f49117b);
        d.a.j0.s2.h0.c c2 = d.a.j0.s2.h0.h.c(dVar.h(), 3, dVar.h().Y3.f49117b);
        c2.u(dVar.h().Y3.f49123h);
        d.a.j0.s2.h0.e.b().d(c2);
        d.a.j0.j1.o.h.c.g(d.a.j0.j1.o.h.c.e(dVar.h()));
        dVar.h().Y3.f49124i = true;
        j.add(dVar.h().Y3.f49123h);
    }

    public static void e(d dVar, int i2, boolean z) {
        if (dVar == null || dVar.f49124i || a(dVar.f49123h)) {
            return;
        }
        d.a.j0.s2.h0.c g2 = d.a.j0.s2.h0.h.g(z ? 13 : 3, i2, dVar.f49117b);
        g2.h(dVar.f49116a);
        g2.u(dVar.f49123h);
        d.a.j0.s2.h0.e.b().d(g2);
        dVar.f49124i = true;
        j.add(dVar.f49123h);
    }

    public static void f(d.a.j0.d3.h0.o oVar) {
        if (oVar == null || oVar.D0() == null) {
            return;
        }
        d dVar = oVar.D0().advertAppContext;
        if (oVar.N0 || !(dVar == null || dVar.f49124i || a(dVar.f49123h))) {
            oVar.C0 = dVar.f49120e;
            oVar.D0 = dVar.f49121f;
            oVar.B0 = dVar.f49119d;
            int i2 = 3;
            if (oVar != null && oVar.F0() != null && oVar.F0().forFree()) {
                i2 = 103;
            }
            d.a.j0.s2.h0.c e2 = d.a.j0.s2.h0.h.e(oVar, i2);
            e2.u(dVar.f49123h);
            d.a.j0.s2.h0.e.b().d(e2);
            if (!oVar.N0) {
                d.a.j0.j1.o.h.c.g(d.a.j0.j1.o.h.c.e(oVar.L0()));
            }
            dVar.f49124i = true;
            j.add(dVar.f49123h);
        }
    }

    public static void g(d dVar, int i2, boolean z) {
        if (dVar == null || dVar.f49124i || a(dVar.f49123h)) {
            return;
        }
        int i3 = z ? 13 : 3;
        d.a.j0.s2.h0.c cVar = new d.a.j0.s2.h0.c();
        cVar.j(i3);
        if ("PB_BANNER".equals(dVar.f49116a)) {
            cVar.d(-1);
            cVar.w(-1);
        } else {
            cVar.d(i2);
            cVar.w(dVar.f49117b);
        }
        cVar.h(dVar.f49116a);
        cVar.e(dVar.f49120e);
        cVar.f(dVar.f49121f);
        cVar.g(dVar.f49119d);
        cVar.a("vc", dVar.f49122g);
        cVar.u(dVar.f49123h);
        d.a.j0.s2.h0.e.b().d(cVar);
        dVar.f49124i = true;
        j.add(dVar.f49123h);
    }

    public static void h(d.a.d.d dVar) {
        if (dVar == null || dVar.l() == null || dVar.f40475i || TextUtils.isEmpty(dVar.l().f40477b) || a(dVar.l().f40477b)) {
            return;
        }
        d.a.j0.s2.h0.e.b().d(d.a.j0.s2.h0.h.a(dVar, 3, dVar.m()));
        d.a.j0.j1.o.h.c.g(dVar);
        dVar.f40475i = true;
        j.add(dVar.l().f40477b);
    }
}
