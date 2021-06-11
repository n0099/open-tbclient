package d.a.m0.r.q;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class d {
    public static final Set<String> j = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    public String f53655a;

    /* renamed from: b  reason: collision with root package name */
    public int f53656b;

    /* renamed from: c  reason: collision with root package name */
    public String f53657c;

    /* renamed from: d  reason: collision with root package name */
    public String f53658d;

    /* renamed from: e  reason: collision with root package name */
    public String f53659e;

    /* renamed from: f  reason: collision with root package name */
    public String f53660f;

    /* renamed from: g  reason: collision with root package name */
    public String f53661g;

    /* renamed from: h  reason: collision with root package name */
    public String f53662h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f53663i;

    public static boolean a(String str) {
        return j.contains(str);
    }

    public static void b(AdvertAppInfo advertAppInfo) {
        d dVar;
        if (advertAppInfo == null || (dVar = advertAppInfo.S3) == null || dVar.f53663i || a(dVar.f53662h)) {
            return;
        }
        d.a.n0.t2.i0.c b2 = d.a.n0.t2.i0.g.b(advertAppInfo, 3, dVar.f53656b);
        b2.h(dVar.f53655a);
        b2.a("isCache", dVar.f53657c);
        b2.e(dVar.f53659e);
        b2.f(dVar.f53660f);
        b2.g(dVar.f53658d);
        b2.a("vc", dVar.f53661g);
        b2.t(dVar.f53662h);
        d.a.n0.t2.i0.e.b().d(b2);
        d.a.n0.k1.o.h.c.g(d.a.n0.k1.o.h.c.e(advertAppInfo));
        dVar.f53663i = true;
        j.add(dVar.f53662h);
    }

    public static void c(d dVar, int i2, boolean z) {
        if (dVar == null || dVar.f53663i || a(dVar.f53662h)) {
            return;
        }
        d.a.n0.t2.i0.c g2 = d.a.n0.t2.i0.g.g(z ? 13 : 3, i2, dVar.f53656b);
        g2.h(dVar.f53655a);
        g2.a("isCache", String.valueOf(dVar.f53657c));
        g2.e(dVar.f53659e);
        g2.f(dVar.f53660f);
        g2.g(dVar.f53658d);
        g2.a("vc", dVar.f53661g);
        g2.t(dVar.f53662h);
        d.a.n0.t2.i0.e.b().d(g2);
        dVar.f53663i = true;
        j.add(dVar.f53662h);
    }

    public static void d(d.a.n0.z.e0.d dVar) {
        if (dVar == null || dVar.c() == null || dVar.c().S3 == null || dVar.c().S3.f53663i || a(dVar.c().S3.f53662h)) {
            return;
        }
        dVar.c().T3 = dVar.c().S3.f53655a;
        d.a.n0.t2.i0.c c2 = d.a.n0.t2.i0.g.c(dVar.c(), 3, dVar.c().S3.f53656b);
        c2.t(dVar.c().S3.f53662h);
        d.a.n0.t2.i0.e.b().d(c2);
        d.a.n0.k1.o.h.c.g(d.a.n0.k1.o.h.c.e(dVar.c()));
        dVar.c().S3.f53663i = true;
        j.add(dVar.c().S3.f53662h);
    }

    public static void e(d dVar, int i2, boolean z) {
        if (dVar == null || dVar.f53663i || a(dVar.f53662h)) {
            return;
        }
        d.a.n0.t2.i0.c g2 = d.a.n0.t2.i0.g.g(z ? 13 : 3, i2, dVar.f53656b);
        g2.h(dVar.f53655a);
        g2.t(dVar.f53662h);
        d.a.n0.t2.i0.e.b().d(g2);
        dVar.f53663i = true;
        j.add(dVar.f53662h);
    }

    public static void f(d.a.n0.e3.h0.o oVar) {
        if (oVar == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        d dVar = oVar.getAdvertAppInfo().S3;
        if (oVar.G0 || !(dVar == null || dVar.f53663i || a(dVar.f53662h))) {
            oVar.A0 = dVar.f53659e;
            oVar.B0 = dVar.f53660f;
            oVar.z0 = dVar.f53658d;
            int i2 = 3;
            if (oVar != null && oVar.F0() != null && oVar.F0().forFree()) {
                i2 = 103;
            }
            d.a.n0.t2.i0.c e2 = d.a.n0.t2.i0.g.e(oVar, i2);
            e2.t(dVar.f53662h);
            d.a.n0.t2.i0.e.b().d(e2);
            if (!oVar.G0) {
                d.a.n0.k1.o.h.c.g(d.a.n0.k1.o.h.c.e(oVar.getAdvertAppInfo()));
            }
            dVar.f53663i = true;
            j.add(dVar.f53662h);
        }
    }

    public static void g(d dVar, int i2, boolean z) {
        if (dVar == null || dVar.f53663i || a(dVar.f53662h)) {
            return;
        }
        int i3 = z ? 13 : 3;
        d.a.n0.t2.i0.c cVar = new d.a.n0.t2.i0.c();
        cVar.i(i3);
        if ("PB_BANNER".equals(dVar.f53655a)) {
            cVar.d(-1);
            cVar.v(-1);
        } else {
            cVar.d(i2);
            cVar.v(dVar.f53656b);
        }
        cVar.h(dVar.f53655a);
        cVar.e(dVar.f53659e);
        cVar.f(dVar.f53660f);
        cVar.g(dVar.f53658d);
        cVar.a("vc", dVar.f53661g);
        cVar.t(dVar.f53662h);
        d.a.n0.t2.i0.e.b().d(cVar);
        dVar.f53663i = true;
        j.add(dVar.f53662h);
    }

    public static void h(d.a.d.d dVar) {
        if (dVar == null || dVar.g() == null || dVar.f43217i || TextUtils.isEmpty(dVar.g().f43219b) || a(dVar.g().f43219b)) {
            return;
        }
        d.a.n0.t2.i0.e.b().d(d.a.n0.t2.i0.g.a(dVar, 3, dVar.i()));
        d.a.n0.k1.o.h.c.g(dVar);
        dVar.f43217i = true;
        j.add(dVar.g().f43219b);
    }
}
