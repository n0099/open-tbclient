package d.a.h0.g.w.f;

import android.text.TextUtils;
import android.util.Log;
import d.a.h0.a.k;
import d.a.h0.g.e.d.c;
import d.a.h0.g.q.a;
import java.util.HashMap;
import okhttp3.HttpUrl;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46830b = k.f43101a;

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f46831c;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, d.a.h0.g.w.a> f46832a = new HashMap<>();

    public static void a(d.a.h0.g.i.b bVar, String str) {
        if (bVar == null || bVar.y() == null || TextUtils.isEmpty(str)) {
            return;
        }
        bVar.y().b(str);
    }

    public static b b() {
        if (f46831c == null) {
            synchronized (b.class) {
                if (f46831c == null) {
                    f46831c = new b();
                }
            }
        }
        return f46831c;
    }

    public final String c(String str, int i2) {
        HttpUrl parse;
        if (TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null) {
            return null;
        }
        return parse.url().toString() + i2;
    }

    public synchronized d.a.h0.g.w.a d(d.a.h0.g.i.b bVar, c cVar, int i2) {
        if (cVar == null) {
            return null;
        }
        String B = cVar.B("url");
        String c2 = c(B, i2);
        if (TextUtils.isEmpty(c2)) {
            return null;
        }
        d.a.h0.g.w.a remove = this.f46832a.remove(c2);
        if (remove != null) {
            a(bVar, "preload used, url = " + B);
        }
        if (f46830b) {
            Log.d("SwanGamePreloadManager", "obtainRequestTask requestType:" + i2 + ";url:" + B + ";task:" + remove);
        }
        return remove;
    }

    public synchronized void e() {
        this.f46832a.clear();
    }

    public void f(d.a.h0.g.i.b bVar, a.c cVar) {
        d.a.h0.g.z.a.a aVar;
        if (bVar == null || cVar == null || (aVar = cVar.f46762c) == null || aVar.f46921g == null) {
            return;
        }
        e();
        d.a.h0.a.w0.a.N().getSwitch("swan_game_resource_preload", 0);
    }
}
