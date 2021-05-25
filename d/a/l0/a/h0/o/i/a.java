package d.a.l0.a.h0.o.i;

import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.l0.a.a2.e;
import d.a.l0.a.a2.n.g;
import d.a.l0.a.c2.f.p0.j;
import d.a.l0.a.k;
import d.a.l0.a.p.e.b;
import d.a.l0.a.v2.o0;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class a {
    public static final boolean j = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public String f42498a;

    /* renamed from: b  reason: collision with root package name */
    public String f42499b;

    /* renamed from: c  reason: collision with root package name */
    public String f42500c;

    /* renamed from: d  reason: collision with root package name */
    public String f42501d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42502e;

    /* renamed from: f  reason: collision with root package name */
    public String f42503f;

    /* renamed from: g  reason: collision with root package name */
    public String f42504g;

    /* renamed from: h  reason: collision with root package name */
    public String f42505h;

    /* renamed from: i  reason: collision with root package name */
    public String f42506i;

    /* renamed from: d.a.l0.a.h0.o.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0693a extends PrefetchEvent.c {
        public C0693a(@Nullable Map<String, String> map, String str) {
            super(map, str);
        }
    }

    public static a a(b bVar, PrefetchEvent prefetchEvent, e eVar) {
        long currentTimeMillis = j ? System.currentTimeMillis() : 0L;
        a aVar = new a();
        aVar.f42505h = bVar.b();
        aVar.f42498a = prefetchEvent.appPath;
        aVar.f42499b = prefetchEvent.pageUrl;
        aVar.f42503f = prefetchEvent.rootPath;
        SwanAppConfigData F = eVar.F();
        aVar.f42500c = prefetchEvent.pageType;
        String c2 = d.a.l0.a.a2.n.b.c(prefetchEvent.appPath, o0.f(j.b(prefetchEvent.pageUrl)));
        aVar.f42504g = c2;
        aVar.f42501d = g.b(c2, F.f11249e).f40798g;
        aVar.f42502e = prefetchEvent.isT7Available;
        aVar.f42506i = prefetchEvent.sConsole;
        if (j) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SlavePreloadEvent", "build slave preload event cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
        return aVar;
    }

    public C0693a b() {
        long currentTimeMillis = j ? System.currentTimeMillis() : 0L;
        TreeMap treeMap = new TreeMap();
        treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.f42505h);
        treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, this.f42498a);
        treeMap.put("pagePath", this.f42499b);
        treeMap.put("pageType", this.f42500c);
        treeMap.put("onReachBottomDistance", this.f42501d);
        treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(this.f42502e));
        treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, this.f42506i);
        treeMap.put(PrefetchEvent.EVENT_DATA_ROOT_PATH, this.f42503f);
        d.a.l0.a.t1.g.b.a(treeMap, "slave preload ready event");
        j.a(this.f42499b, treeMap);
        treeMap.put("pageConfig", this.f42504g);
        if (j) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SlavePreloadEvent", "build slave preload msg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
        return new C0693a(treeMap, "preload");
    }
}
