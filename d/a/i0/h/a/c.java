package d.a.i0.h.a;

import android.text.TextUtils;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import d.a.i0.a.a2.e;
import d.a.i0.a.f1.e.b;
import d.a.i0.a.j2.k;
import d.a.i0.h.f0.h;
/* loaded from: classes3.dex */
public class c {
    public static void a(String str, String str2, long j) {
        b bVar = new b();
        bVar.f43012b = str;
        bVar.f43015e = str2;
        if (e.i() != null && e.i().N() != null) {
            b.a N = e.i().N();
            bVar.f43011a = k.m(N.G());
            bVar.f43016f = N.H();
            bVar.f43013c = N.T();
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
        bVar.f43012b = str;
        bVar.f43015e = str2;
        bVar.f43011a = str3;
        bVar.f43016f = aVar.H();
        bVar.f43013c = aVar.T();
        k.v("916", "68", bVar);
    }

    public static void c(String str, String str2, String str3) {
        b bVar = new b();
        bVar.f43012b = str;
        bVar.f43015e = str2;
        if (e.i() != null && e.i().N() != null) {
            b.a N = e.i().N();
            bVar.f43011a = k.m(N.G());
            bVar.f43016f = N.H();
            bVar.f43013c = N.T();
        }
        bVar.k = str3;
        k.v("916", "68", bVar);
    }

    public static void d(String str) {
        b bVar = new b();
        bVar.f43012b = str;
        bVar.f43015e = "show";
        if (e.i() != null && e.i().N() != null) {
            b.a N = e.i().N();
            bVar.f43011a = k.m(N.G());
            bVar.f43016f = N.H();
            bVar.f43013c = N.T();
        }
        bVar.a("early", e() ? "0" : "1");
        k.v("916", "68", bVar);
    }

    public static boolean e() {
        return h.c() > 0 && d.a.i0.h.q.c.b.c() && System.currentTimeMillis() - h.c() > 6000;
    }
}
