package d.a.n0.r.q;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class d {
    public static final Set<String> j = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    public String f53762a;

    /* renamed from: b  reason: collision with root package name */
    public int f53763b;

    /* renamed from: c  reason: collision with root package name */
    public String f53764c;

    /* renamed from: d  reason: collision with root package name */
    public String f53765d;

    /* renamed from: e  reason: collision with root package name */
    public String f53766e;

    /* renamed from: f  reason: collision with root package name */
    public String f53767f;

    /* renamed from: g  reason: collision with root package name */
    public String f53768g;

    /* renamed from: h  reason: collision with root package name */
    public String f53769h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f53770i;

    public static boolean a(String str) {
        return j.contains(str);
    }

    public static void b(AdvertAppInfo advertAppInfo) {
        d dVar;
        if (advertAppInfo == null || (dVar = advertAppInfo.S3) == null || dVar.f53770i || a(dVar.f53769h)) {
            return;
        }
        d.a.o0.t2.i0.c b2 = d.a.o0.t2.i0.g.b(advertAppInfo, 3, dVar.f53763b);
        b2.h(dVar.f53762a);
        b2.a("isCache", dVar.f53764c);
        b2.e(dVar.f53766e);
        b2.f(dVar.f53767f);
        b2.g(dVar.f53765d);
        b2.a("vc", dVar.f53768g);
        b2.t(dVar.f53769h);
        d.a.o0.t2.i0.e.b().d(b2);
        d.a.o0.k1.o.h.c.g(d.a.o0.k1.o.h.c.e(advertAppInfo));
        dVar.f53770i = true;
        j.add(dVar.f53769h);
    }

    public static void c(d dVar, int i2, boolean z) {
        if (dVar == null || dVar.f53770i || a(dVar.f53769h)) {
            return;
        }
        d.a.o0.t2.i0.c g2 = d.a.o0.t2.i0.g.g(z ? 13 : 3, i2, dVar.f53763b);
        g2.h(dVar.f53762a);
        g2.a("isCache", String.valueOf(dVar.f53764c));
        g2.e(dVar.f53766e);
        g2.f(dVar.f53767f);
        g2.g(dVar.f53765d);
        g2.a("vc", dVar.f53768g);
        g2.t(dVar.f53769h);
        d.a.o0.t2.i0.e.b().d(g2);
        dVar.f53770i = true;
        j.add(dVar.f53769h);
    }

    public static void d(d.a.o0.z.e0.d dVar) {
        if (dVar == null || dVar.c() == null || dVar.c().S3 == null || dVar.c().S3.f53770i || a(dVar.c().S3.f53769h)) {
            return;
        }
        dVar.c().T3 = dVar.c().S3.f53762a;
        d.a.o0.t2.i0.c c2 = d.a.o0.t2.i0.g.c(dVar.c(), 3, dVar.c().S3.f53763b);
        c2.t(dVar.c().S3.f53769h);
        d.a.o0.t2.i0.e.b().d(c2);
        d.a.o0.k1.o.h.c.g(d.a.o0.k1.o.h.c.e(dVar.c()));
        dVar.c().S3.f53770i = true;
        j.add(dVar.c().S3.f53769h);
    }

    public static void e(d dVar, int i2, boolean z) {
        if (dVar == null || dVar.f53770i || a(dVar.f53769h)) {
            return;
        }
        d.a.o0.t2.i0.c g2 = d.a.o0.t2.i0.g.g(z ? 13 : 3, i2, dVar.f53763b);
        g2.h(dVar.f53762a);
        g2.t(dVar.f53769h);
        d.a.o0.t2.i0.e.b().d(g2);
        dVar.f53770i = true;
        j.add(dVar.f53769h);
    }

    public static void f(d.a.o0.e3.h0.o oVar) {
        if (oVar == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        d dVar = oVar.getAdvertAppInfo().S3;
        if (oVar.L0 || !(dVar == null || dVar.f53770i || a(dVar.f53769h))) {
            oVar.F0 = dVar.f53766e;
            oVar.G0 = dVar.f53767f;
            oVar.E0 = dVar.f53765d;
            int i2 = 3;
            if (oVar != null && oVar.F0() != null && oVar.F0().forFree()) {
                i2 = 103;
            }
            d.a.o0.t2.i0.c e2 = d.a.o0.t2.i0.g.e(oVar, i2);
            e2.t(dVar.f53769h);
            d.a.o0.t2.i0.e.b().d(e2);
            if (!oVar.L0) {
                d.a.o0.k1.o.h.c.g(d.a.o0.k1.o.h.c.e(oVar.getAdvertAppInfo()));
            }
            dVar.f53770i = true;
            j.add(dVar.f53769h);
        }
    }

    public static void g(d dVar, int i2, boolean z) {
        if (dVar == null || dVar.f53770i || a(dVar.f53769h)) {
            return;
        }
        int i3 = z ? 13 : 3;
        d.a.o0.t2.i0.c cVar = new d.a.o0.t2.i0.c();
        cVar.i(i3);
        if ("PB_BANNER".equals(dVar.f53762a)) {
            cVar.d(-1);
            cVar.v(-1);
        } else {
            cVar.d(i2);
            cVar.v(dVar.f53763b);
        }
        cVar.h(dVar.f53762a);
        cVar.e(dVar.f53766e);
        cVar.f(dVar.f53767f);
        cVar.g(dVar.f53765d);
        cVar.a("vc", dVar.f53768g);
        cVar.t(dVar.f53769h);
        d.a.o0.t2.i0.e.b().d(cVar);
        dVar.f53770i = true;
        j.add(dVar.f53769h);
    }

    public static void h(d.a.d.d dVar) {
        if (dVar == null || dVar.g() == null || dVar.f43320i || TextUtils.isEmpty(dVar.g().f43322b) || a(dVar.g().f43322b)) {
            return;
        }
        d.a.o0.t2.i0.e.b().d(d.a.o0.t2.i0.g.a(dVar, 3, dVar.i()));
        d.a.o0.k1.o.h.c.g(dVar);
        dVar.f43320i = true;
        j.add(dVar.g().f43322b);
    }
}
