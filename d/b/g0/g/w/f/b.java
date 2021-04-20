package d.b.g0.g.w.f;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.k;
import d.b.g0.g.e.d.c;
import d.b.g0.g.q.a;
import java.util.HashMap;
import okhttp3.HttpUrl;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f49005b = k.f45443a;

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f49006c;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, d.b.g0.g.w.a> f49007a = new HashMap<>();

    public static void a(d.b.g0.g.i.b bVar, String str) {
        if (bVar == null || bVar.a0() == null || TextUtils.isEmpty(str)) {
            return;
        }
        bVar.a0().b(str);
    }

    public static b b() {
        if (f49006c == null) {
            synchronized (b.class) {
                if (f49006c == null) {
                    f49006c = new b();
                }
            }
        }
        return f49006c;
    }

    public final String c(String str, int i) {
        HttpUrl parse;
        if (TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null) {
            return null;
        }
        return parse.url().toString() + i;
    }

    public synchronized d.b.g0.g.w.a d(d.b.g0.g.i.b bVar, c cVar, int i) {
        if (cVar == null) {
            return null;
        }
        String B = cVar.B("url");
        String c2 = c(B, i);
        if (TextUtils.isEmpty(c2)) {
            return null;
        }
        d.b.g0.g.w.a remove = this.f49007a.remove(c2);
        if (remove != null) {
            a(bVar, "preload used, url = " + B);
        }
        if (f49005b) {
            Log.d("SwanGamePreloadManager", "obtainRequestTask requestType:" + i + ";url:" + B + ";task:" + remove);
        }
        return remove;
    }

    public synchronized void e() {
        this.f49007a.clear();
    }

    public void f(d.b.g0.g.i.b bVar, a.c cVar) {
        d.b.g0.g.z.a.a aVar;
        if (bVar == null || cVar == null || (aVar = cVar.f48939c) == null || aVar.f49092g == null) {
            return;
        }
        e();
        d.b.g0.a.w0.a.N().getSwitch("swan_game_resource_preload", 0);
    }
}
