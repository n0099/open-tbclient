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
    public static final boolean j = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public String f46174a;

    /* renamed from: b  reason: collision with root package name */
    public String f46175b;

    /* renamed from: c  reason: collision with root package name */
    public String f46176c;

    /* renamed from: d  reason: collision with root package name */
    public String f46177d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f46178e;

    /* renamed from: f  reason: collision with root package name */
    public String f46179f;

    /* renamed from: g  reason: collision with root package name */
    public String f46180g;

    /* renamed from: h  reason: collision with root package name */
    public String f46181h;

    /* renamed from: i  reason: collision with root package name */
    public String f46182i;

    /* renamed from: d.a.l0.a.h0.o.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0749a extends PrefetchEvent.c {
        public C0749a(@Nullable Map<String, String> map, String str) {
            super(map, str);
        }
    }

    public static a a(b bVar, PrefetchEvent prefetchEvent, e eVar) {
        long currentTimeMillis = j ? System.currentTimeMillis() : 0L;
        a aVar = new a();
        aVar.f46181h = bVar.b();
        aVar.f46174a = prefetchEvent.appPath;
        aVar.f46175b = prefetchEvent.pageUrl;
        aVar.f46179f = prefetchEvent.rootPath;
        SwanAppConfigData F = eVar.F();
        aVar.f46176c = prefetchEvent.pageType;
        String c2 = d.a.l0.a.a2.n.b.c(prefetchEvent.appPath, o0.f(j.b(prefetchEvent.pageUrl)));
        aVar.f46180g = c2;
        aVar.f46177d = g.b(c2, F.f11311e).f44474g;
        aVar.f46178e = prefetchEvent.isT7Available;
        aVar.f46182i = prefetchEvent.sConsole;
        if (j) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SlavePreloadEvent", "build slave preload event cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
        return aVar;
    }

    public C0749a b() {
        long currentTimeMillis = j ? System.currentTimeMillis() : 0L;
        TreeMap treeMap = new TreeMap();
        treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.f46181h);
        treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, this.f46174a);
        treeMap.put("pagePath", this.f46175b);
        treeMap.put("pageType", this.f46176c);
        treeMap.put("onReachBottomDistance", this.f46177d);
        treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(this.f46178e));
        treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, this.f46182i);
        treeMap.put(PrefetchEvent.EVENT_DATA_ROOT_PATH, this.f46179f);
        d.a.l0.a.t1.g.b.a(treeMap, "slave preload ready event");
        j.a(this.f46175b, treeMap);
        treeMap.put("pageConfig", this.f46180g);
        if (j) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SlavePreloadEvent", "build slave preload msg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
        return new C0749a(treeMap, "preload");
    }
}
