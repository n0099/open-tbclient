package d.a.l0.h.a;

import android.text.TextUtils;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import d.a.l0.a.a2.e;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.j2.k;
import d.a.l0.h.f0.h;
/* loaded from: classes3.dex */
public class c {
    public static void a(String str, String str2, long j) {
        b bVar = new b();
        bVar.f46862b = str;
        bVar.f46865e = str2;
        if (e.i() != null && e.i().N() != null) {
            b.a N = e.i().N();
            bVar.f46861a = k.m(N.G());
            bVar.f46866f = N.H();
            bVar.f46863c = N.T();
            bVar.a("play_time", Long.valueOf(j));
        }
        k.v("916", "68", bVar);
    }

    public static void b(String str, String str2) {
        String str3;
        b.a aVar;
        if (e.i() == null || e.i().N() == null) {
            str3 = "";
            aVar = null;
        } else {
            aVar = e.i().N();
            str3 = k.m(aVar.G());
        }
        if (aVar == null || !TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
            return;
        }
        b bVar = new b();
        bVar.f46862b = str;
        bVar.f46865e = str2;
        bVar.f46861a = str3;
        bVar.f46866f = aVar.H();
        bVar.f46863c = aVar.T();
        k.v("916", "68", bVar);
    }

    public static void c(String str, String str2, String str3) {
        b bVar = new b();
        bVar.f46862b = str;
        bVar.f46865e = str2;
        if (e.i() != null && e.i().N() != null) {
            b.a N = e.i().N();
            bVar.f46861a = k.m(N.G());
            bVar.f46866f = N.H();
            bVar.f46863c = N.T();
        }
        bVar.k = str3;
        k.v("916", "68", bVar);
    }

    public static void d(String str) {
        b bVar = new b();
        bVar.f46862b = str;
        bVar.f46865e = "show";
        if (e.i() != null && e.i().N() != null) {
            b.a N = e.i().N();
            bVar.f46861a = k.m(N.G());
            bVar.f46866f = N.H();
            bVar.f46863c = N.T();
        }
        bVar.a("early", e() ? "0" : "1");
        k.v("916", "68", bVar);
    }

    public static boolean e() {
        return h.c() > 0 && d.a.l0.h.q.c.b.c() && System.currentTimeMillis() - h.c() > 6000;
    }
}
