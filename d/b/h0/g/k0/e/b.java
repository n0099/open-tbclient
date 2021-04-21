package d.b.h0.g.k0.e;

import d.b.h0.a.r1.e;
import d.b.h0.a.y0.e.b;
import d.b.h0.a.z1.h;
import d.b.h0.g.c0.d;
/* loaded from: classes3.dex */
public class b {
    public static void a(String str, String str2, long j) {
        a aVar = new a();
        aVar.f47973b = str;
        aVar.f47975d = str2;
        if (e.y() != null && e.y().L() != null) {
            b.a L = e.y().L();
            aVar.f47972a = h.n(L.F());
            aVar.f47976e = L.G();
            aVar.f47974c = L.S();
            aVar.a("play_time", Long.valueOf(j));
        }
        h.v("916", "68", aVar);
    }

    public static void b(String str, String str2) {
        a aVar = new a();
        aVar.f47973b = str;
        aVar.f47975d = str2;
        if (e.y() != null && e.y().L() != null) {
            b.a L = e.y().L();
            aVar.f47972a = h.n(L.F());
            aVar.f47976e = L.G();
            aVar.f47974c = L.S();
        }
        h.v("916", "68", aVar);
    }

    public static void c(String str, String str2, String str3) {
        a aVar = new a();
        aVar.f47973b = str;
        aVar.f47975d = str2;
        if (e.y() != null && e.y().L() != null) {
            b.a L = e.y().L();
            aVar.f47972a = h.n(L.F());
            aVar.f47976e = L.G();
            aVar.f47974c = L.S();
        }
        aVar.j = str3;
        h.v("916", "68", aVar);
    }

    public static void d(String str) {
        a aVar = new a();
        aVar.f47973b = str;
        aVar.f47975d = "show";
        if (e.y() != null && e.y().L() != null) {
            b.a L = e.y().L();
            aVar.f47972a = h.n(L.F());
            aVar.f47976e = L.G();
            aVar.f47974c = L.S();
        }
        aVar.a("early", e() ? "0" : "1");
        h.v("916", "68", aVar);
    }

    public static boolean e() {
        return d.c() > 0 && d.b.h0.g.o.c.b.c() && System.currentTimeMillis() - d.c() > 6000;
    }
}
