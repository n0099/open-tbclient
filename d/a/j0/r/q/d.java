package d.a.j0.r.q;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class d {
    public static final Set<String> j = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    public String f49935a;

    /* renamed from: b  reason: collision with root package name */
    public int f49936b;

    /* renamed from: c  reason: collision with root package name */
    public String f49937c;

    /* renamed from: d  reason: collision with root package name */
    public String f49938d;

    /* renamed from: e  reason: collision with root package name */
    public String f49939e;

    /* renamed from: f  reason: collision with root package name */
    public String f49940f;

    /* renamed from: g  reason: collision with root package name */
    public String f49941g;

    /* renamed from: h  reason: collision with root package name */
    public String f49942h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f49943i;

    public static boolean a(String str) {
        return j.contains(str);
    }

    public static void b(AdvertAppInfo advertAppInfo) {
        d dVar;
        if (advertAppInfo == null || (dVar = advertAppInfo.O3) == null || dVar.f49943i || a(dVar.f49942h)) {
            return;
        }
        d.a.k0.s2.i0.c b2 = d.a.k0.s2.i0.g.b(advertAppInfo, 3, dVar.f49936b);
        b2.h(dVar.f49935a);
        b2.a("isCache", dVar.f49937c);
        b2.e(dVar.f49939e);
        b2.f(dVar.f49940f);
        b2.g(dVar.f49938d);
        b2.a("vc", dVar.f49941g);
        b2.t(dVar.f49942h);
        d.a.k0.s2.i0.e.b().d(b2);
        d.a.k0.j1.o.h.c.g(d.a.k0.j1.o.h.c.e(advertAppInfo));
        dVar.f49943i = true;
        j.add(dVar.f49942h);
    }

    public static void c(d dVar, int i2, boolean z) {
        if (dVar == null || dVar.f49943i || a(dVar.f49942h)) {
            return;
        }
        d.a.k0.s2.i0.c g2 = d.a.k0.s2.i0.g.g(z ? 13 : 3, i2, dVar.f49936b);
        g2.h(dVar.f49935a);
        g2.a("isCache", String.valueOf(dVar.f49937c));
        g2.e(dVar.f49939e);
        g2.f(dVar.f49940f);
        g2.g(dVar.f49938d);
        g2.a("vc", dVar.f49941g);
        g2.t(dVar.f49942h);
        d.a.k0.s2.i0.e.b().d(g2);
        dVar.f49943i = true;
        j.add(dVar.f49942h);
    }

    public static void d(d.a.k0.x.e0.d dVar) {
        if (dVar == null || dVar.h() == null || dVar.h().O3 == null || dVar.h().O3.f49943i || a(dVar.h().O3.f49942h)) {
            return;
        }
        dVar.h().P3 = dVar.h().O3.f49935a;
        d.a.k0.s2.i0.c c2 = d.a.k0.s2.i0.g.c(dVar.h(), 3, dVar.h().O3.f49936b);
        c2.t(dVar.h().O3.f49942h);
        d.a.k0.s2.i0.e.b().d(c2);
        d.a.k0.j1.o.h.c.g(d.a.k0.j1.o.h.c.e(dVar.h()));
        dVar.h().O3.f49943i = true;
        j.add(dVar.h().O3.f49942h);
    }

    public static void e(d dVar, int i2, boolean z) {
        if (dVar == null || dVar.f49943i || a(dVar.f49942h)) {
            return;
        }
        d.a.k0.s2.i0.c g2 = d.a.k0.s2.i0.g.g(z ? 13 : 3, i2, dVar.f49936b);
        g2.h(dVar.f49935a);
        g2.t(dVar.f49942h);
        d.a.k0.s2.i0.e.b().d(g2);
        dVar.f49943i = true;
        j.add(dVar.f49942h);
    }

    public static void f(d.a.k0.d3.h0.o oVar) {
        if (oVar == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        d dVar = oVar.getAdvertAppInfo().O3;
        if (oVar.L0 || !(dVar == null || dVar.f49943i || a(dVar.f49942h))) {
            oVar.A0 = dVar.f49939e;
            oVar.B0 = dVar.f49940f;
            oVar.z0 = dVar.f49938d;
            int i2 = 3;
            if (oVar != null && oVar.F0() != null && oVar.F0().forFree()) {
                i2 = 103;
            }
            d.a.k0.s2.i0.c e2 = d.a.k0.s2.i0.g.e(oVar, i2);
            e2.t(dVar.f49942h);
            d.a.k0.s2.i0.e.b().d(e2);
            if (!oVar.L0) {
                d.a.k0.j1.o.h.c.g(d.a.k0.j1.o.h.c.e(oVar.getAdvertAppInfo()));
            }
            dVar.f49943i = true;
            j.add(dVar.f49942h);
        }
    }

    public static void g(d dVar, int i2, boolean z) {
        if (dVar == null || dVar.f49943i || a(dVar.f49942h)) {
            return;
        }
        int i3 = z ? 13 : 3;
        d.a.k0.s2.i0.c cVar = new d.a.k0.s2.i0.c();
        cVar.i(i3);
        if ("PB_BANNER".equals(dVar.f49935a)) {
            cVar.d(-1);
            cVar.v(-1);
        } else {
            cVar.d(i2);
            cVar.v(dVar.f49936b);
        }
        cVar.h(dVar.f49935a);
        cVar.e(dVar.f49939e);
        cVar.f(dVar.f49940f);
        cVar.g(dVar.f49938d);
        cVar.a("vc", dVar.f49941g);
        cVar.t(dVar.f49942h);
        d.a.k0.s2.i0.e.b().d(cVar);
        dVar.f49943i = true;
        j.add(dVar.f49942h);
    }

    public static void h(d.a.d.d dVar) {
        if (dVar == null || dVar.l() == null || dVar.f39720i || TextUtils.isEmpty(dVar.l().f39722b) || a(dVar.l().f39722b)) {
            return;
        }
        d.a.k0.s2.i0.e.b().d(d.a.k0.s2.i0.g.a(dVar, 3, dVar.m()));
        d.a.k0.j1.o.h.c.g(dVar);
        dVar.f39720i = true;
        j.add(dVar.l().f39722b);
    }
}
