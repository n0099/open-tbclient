package d.b.g0.g.c0;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes3.dex */
public class c {
    public static void a(CallbackHandler callbackHandler, String str) {
        if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            d.b.g0.g.c0.e.d dVar = new d.b.g0.g.c0.e.d();
            dVar.f48027a = str;
            b.c().a(new a(IMConstants.ERROR_BASE, dVar));
        }
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            d.b.g0.g.c0.e.d dVar = new d.b.g0.g.c0.e.d();
            dVar.f48027a = str;
            b.c().a(new a(90000, dVar));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        d.b.g0.g.c0.e.a aVar = new d.b.g0.g.c0.e.a();
        aVar.f48021b = str;
        aVar.f48022c = i;
        aVar.f48023d = z ? 1 : 0;
        aVar.f48027a = str2;
        b.c().a(new a(100000, aVar));
    }

    public static void d(String str) {
        d.b.g0.g.c0.e.d dVar = new d.b.g0.g.c0.e.d();
        dVar.f48027a = str;
        b.c().a(new a(20000, dVar));
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            d.b.g0.g.c0.e.d dVar = new d.b.g0.g.c0.e.d();
            dVar.f48027a = str;
            b.c().a(new a(60000, dVar));
        }
    }

    public static void f(String str) {
        d.b.g0.g.c0.e.d dVar = new d.b.g0.g.c0.e.d();
        dVar.f48027a = str;
        b.c().a(new a(10000, dVar));
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            d.b.g0.g.c0.e.d dVar = new d.b.g0.g.c0.e.d();
            dVar.f48027a = str;
            b.c().a(new a(40000, dVar));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        d.b.g0.g.c0.e.a aVar = new d.b.g0.g.c0.e.a();
        aVar.f48021b = str;
        aVar.f48022c = i;
        aVar.f48023d = z ? 1 : 0;
        aVar.f48027a = str2;
        b.c().a(new a(70000, aVar));
    }

    public static void i(String str, String str2) {
        d.b.g0.g.c0.e.b bVar = new d.b.g0.g.c0.e.b();
        bVar.f48024b = str;
        bVar.f48027a = str2;
        b.c().a(new a(30000, bVar));
    }

    public static void j(String str, int i, String str2) {
        d.b.g0.g.c0.e.c cVar = new d.b.g0.g.c0.e.c();
        cVar.f48025b = str;
        cVar.f48026c = i;
        cVar.f48027a = str2;
        b.c().a(new a(80000, cVar));
    }

    public static void k(String str, int i, String str2, boolean z) {
        d.b.g0.g.c0.e.a aVar = new d.b.g0.g.c0.e.a();
        aVar.f48021b = str;
        aVar.f48022c = i;
        aVar.f48023d = z ? 1 : 0;
        aVar.f48027a = str2;
        b.c().a(new a(110000, aVar));
    }

    public static void l(String str) {
        d.b.g0.g.c0.e.d dVar = new d.b.g0.g.c0.e.d();
        dVar.f48027a = str;
        b.c().a(new a(120000, dVar));
    }
}
