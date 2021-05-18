package d.a.i0.h.y.e;

import android.text.TextUtils;
import android.util.Log;
import d.a.i0.a.k;
import d.a.i0.a.l0.c;
import d.a.i0.h.s.a;
import java.util.HashMap;
import okhttp3.HttpUrl;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47572b = k.f43025a;

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f47573c;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, d.a.i0.h.y.a> f47574a = new HashMap<>();

    public static void a(c cVar, String str) {
        if (cVar == null || cVar.A() == null || TextUtils.isEmpty(str)) {
            return;
        }
        cVar.A().b(str);
    }

    public static b b() {
        if (f47573c == null) {
            synchronized (b.class) {
                if (f47573c == null) {
                    f47573c = new b();
                }
            }
        }
        return f47573c;
    }

    public final String c(String str, int i2) {
        HttpUrl parse;
        if (TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null) {
            return null;
        }
        return parse.url().toString() + i2;
    }

    public synchronized d.a.i0.h.y.a d(c cVar, d.a.i0.a.y.b.a aVar, int i2) {
        if (aVar == null) {
            return null;
        }
        String C = aVar.C("url");
        String c2 = c(C, i2);
        if (TextUtils.isEmpty(c2)) {
            return null;
        }
        d.a.i0.h.y.a remove = this.f47574a.remove(c2);
        if (remove != null) {
            a(cVar, "preload used, url = " + C);
        }
        if (f47572b) {
            Log.d("SwanGamePreloadManager", "obtainRequestTask requestType:" + i2 + ";url:" + C + ";task:" + remove);
        }
        return remove;
    }

    public synchronized void e() {
        this.f47574a.clear();
    }

    public void f(c cVar, a.c cVar2) {
        d.a.i0.h.c0.a.a aVar;
        if (cVar == null || cVar2 == null || (aVar = cVar2.f47500c) == null || aVar.f47086g == null) {
            return;
        }
        e();
        d.a.i0.a.c1.a.Z().getSwitch("swan_game_resource_preload", 0);
    }
}
