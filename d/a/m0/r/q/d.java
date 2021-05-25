package d.a.m0.r.q;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class d {
    public static final Set<String> j = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    public String f49979a;

    /* renamed from: b  reason: collision with root package name */
    public int f49980b;

    /* renamed from: c  reason: collision with root package name */
    public String f49981c;

    /* renamed from: d  reason: collision with root package name */
    public String f49982d;

    /* renamed from: e  reason: collision with root package name */
    public String f49983e;

    /* renamed from: f  reason: collision with root package name */
    public String f49984f;

    /* renamed from: g  reason: collision with root package name */
    public String f49985g;

    /* renamed from: h  reason: collision with root package name */
    public String f49986h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f49987i;

    public static boolean a(String str) {
        return j.contains(str);
    }

    public static void b(AdvertAppInfo advertAppInfo) {
        d dVar;
        if (advertAppInfo == null || (dVar = advertAppInfo.P3) == null || dVar.f49987i || a(dVar.f49986h)) {
            return;
        }
        d.a.n0.t2.i0.c b2 = d.a.n0.t2.i0.g.b(advertAppInfo, 3, dVar.f49980b);
        b2.h(dVar.f49979a);
        b2.a("isCache", dVar.f49981c);
        b2.e(dVar.f49983e);
        b2.f(dVar.f49984f);
        b2.g(dVar.f49982d);
        b2.a("vc", dVar.f49985g);
        b2.t(dVar.f49986h);
        d.a.n0.t2.i0.e.b().d(b2);
        d.a.n0.k1.o.h.c.g(d.a.n0.k1.o.h.c.e(advertAppInfo));
        dVar.f49987i = true;
        j.add(dVar.f49986h);
    }

    public static void c(d dVar, int i2, boolean z) {
        if (dVar == null || dVar.f49987i || a(dVar.f49986h)) {
            return;
        }
        d.a.n0.t2.i0.c g2 = d.a.n0.t2.i0.g.g(z ? 13 : 3, i2, dVar.f49980b);
        g2.h(dVar.f49979a);
        g2.a("isCache", String.valueOf(dVar.f49981c));
        g2.e(dVar.f49983e);
        g2.f(dVar.f49984f);
        g2.g(dVar.f49982d);
        g2.a("vc", dVar.f49985g);
        g2.t(dVar.f49986h);
        d.a.n0.t2.i0.e.b().d(g2);
        dVar.f49987i = true;
        j.add(dVar.f49986h);
    }

    public static void d(d.a.n0.z.e0.d dVar) {
        if (dVar == null || dVar.h() == null || dVar.h().P3 == null || dVar.h().P3.f49987i || a(dVar.h().P3.f49986h)) {
            return;
        }
        dVar.h().Q3 = dVar.h().P3.f49979a;
        d.a.n0.t2.i0.c c2 = d.a.n0.t2.i0.g.c(dVar.h(), 3, dVar.h().P3.f49980b);
        c2.t(dVar.h().P3.f49986h);
        d.a.n0.t2.i0.e.b().d(c2);
        d.a.n0.k1.o.h.c.g(d.a.n0.k1.o.h.c.e(dVar.h()));
        dVar.h().P3.f49987i = true;
        j.add(dVar.h().P3.f49986h);
    }

    public static void e(d dVar, int i2, boolean z) {
        if (dVar == null || dVar.f49987i || a(dVar.f49986h)) {
            return;
        }
        d.a.n0.t2.i0.c g2 = d.a.n0.t2.i0.g.g(z ? 13 : 3, i2, dVar.f49980b);
        g2.h(dVar.f49979a);
        g2.t(dVar.f49986h);
        d.a.n0.t2.i0.e.b().d(g2);
        dVar.f49987i = true;
        j.add(dVar.f49986h);
    }

    public static void f(d.a.n0.e3.h0.o oVar) {
        if (oVar == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        d dVar = oVar.getAdvertAppInfo().P3;
        if (oVar.L0 || !(dVar == null || dVar.f49987i || a(dVar.f49986h))) {
            oVar.A0 = dVar.f49983e;
            oVar.B0 = dVar.f49984f;
            oVar.z0 = dVar.f49982d;
            int i2 = 3;
            if (oVar != null && oVar.F0() != null && oVar.F0().forFree()) {
                i2 = 103;
            }
            d.a.n0.t2.i0.c e2 = d.a.n0.t2.i0.g.e(oVar, i2);
            e2.t(dVar.f49986h);
            d.a.n0.t2.i0.e.b().d(e2);
            if (!oVar.L0) {
                d.a.n0.k1.o.h.c.g(d.a.n0.k1.o.h.c.e(oVar.getAdvertAppInfo()));
            }
            dVar.f49987i = true;
            j.add(dVar.f49986h);
        }
    }

    public static void g(d dVar, int i2, boolean z) {
        if (dVar == null || dVar.f49987i || a(dVar.f49986h)) {
            return;
        }
        int i3 = z ? 13 : 3;
        d.a.n0.t2.i0.c cVar = new d.a.n0.t2.i0.c();
        cVar.i(i3);
        if ("PB_BANNER".equals(dVar.f49979a)) {
            cVar.d(-1);
            cVar.v(-1);
        } else {
            cVar.d(i2);
            cVar.v(dVar.f49980b);
        }
        cVar.h(dVar.f49979a);
        cVar.e(dVar.f49983e);
        cVar.f(dVar.f49984f);
        cVar.g(dVar.f49982d);
        cVar.a("vc", dVar.f49985g);
        cVar.t(dVar.f49986h);
        d.a.n0.t2.i0.e.b().d(cVar);
        dVar.f49987i = true;
        j.add(dVar.f49986h);
    }

    public static void h(d.a.d.d dVar) {
        if (dVar == null || dVar.l() == null || dVar.f39536i || TextUtils.isEmpty(dVar.l().f39538b) || a(dVar.l().f39538b)) {
            return;
        }
        d.a.n0.t2.i0.e.b().d(d.a.n0.t2.i0.g.a(dVar, 3, dVar.m()));
        d.a.n0.k1.o.h.c.g(dVar);
        dVar.f39536i = true;
        j.add(dVar.l().f39538b);
    }
}
