package d.a.i0.a.h0.o.i;

import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.i0.a.a2.e;
import d.a.i0.a.a2.n.g;
import d.a.i0.a.c2.f.p0.j;
import d.a.i0.a.k;
import d.a.i0.a.p.e.b;
import d.a.i0.a.v2.o0;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class a {
    public static final boolean j = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public String f42324a;

    /* renamed from: b  reason: collision with root package name */
    public String f42325b;

    /* renamed from: c  reason: collision with root package name */
    public String f42326c;

    /* renamed from: d  reason: collision with root package name */
    public String f42327d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42328e;

    /* renamed from: f  reason: collision with root package name */
    public String f42329f;

    /* renamed from: g  reason: collision with root package name */
    public String f42330g;

    /* renamed from: h  reason: collision with root package name */
    public String f42331h;

    /* renamed from: i  reason: collision with root package name */
    public String f42332i;

    /* renamed from: d.a.i0.a.h0.o.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0682a extends PrefetchEvent.c {
        public C0682a(@Nullable Map<String, String> map, String str) {
            super(map, str);
        }
    }

    public static a a(b bVar, PrefetchEvent prefetchEvent, e eVar) {
        long currentTimeMillis = j ? System.currentTimeMillis() : 0L;
        a aVar = new a();
        aVar.f42331h = bVar.b();
        aVar.f42324a = prefetchEvent.appPath;
        aVar.f42325b = prefetchEvent.pageUrl;
        aVar.f42329f = prefetchEvent.rootPath;
        SwanAppConfigData F = eVar.F();
        aVar.f42326c = prefetchEvent.pageType;
        String c2 = d.a.i0.a.a2.n.b.c(prefetchEvent.appPath, o0.f(j.b(prefetchEvent.pageUrl)));
        aVar.f42330g = c2;
        aVar.f42327d = g.b(c2, F.f11348e).f40624g;
        aVar.f42328e = prefetchEvent.isT7Available;
        aVar.f42332i = prefetchEvent.sConsole;
        if (j) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SlavePreloadEvent", "build slave preload event cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
        return aVar;
    }

    public C0682a b() {
        long currentTimeMillis = j ? System.currentTimeMillis() : 0L;
        TreeMap treeMap = new TreeMap();
        treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.f42331h);
        treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, this.f42324a);
        treeMap.put("pagePath", this.f42325b);
        treeMap.put("pageType", this.f42326c);
        treeMap.put("onReachBottomDistance", this.f42327d);
        treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(this.f42328e));
        treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, this.f42332i);
        treeMap.put(PrefetchEvent.EVENT_DATA_ROOT_PATH, this.f42329f);
        d.a.i0.a.t1.g.b.a(treeMap, "slave preload ready event");
        j.a(this.f42325b, treeMap);
        treeMap.put("pageConfig", this.f42330g);
        if (j) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SlavePreloadEvent", "build slave preload msg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
        return new C0682a(treeMap, "preload");
    }
}
