package d.a.m0.a.h0.o.i;

import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.m0.a.a2.e;
import d.a.m0.a.a2.n.g;
import d.a.m0.a.c2.f.p0.j;
import d.a.m0.a.k;
import d.a.m0.a.p.e.b;
import d.a.m0.a.v2.o0;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public class a {
    public static final boolean j = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public String f46282a;

    /* renamed from: b  reason: collision with root package name */
    public String f46283b;

    /* renamed from: c  reason: collision with root package name */
    public String f46284c;

    /* renamed from: d  reason: collision with root package name */
    public String f46285d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f46286e;

    /* renamed from: f  reason: collision with root package name */
    public String f46287f;

    /* renamed from: g  reason: collision with root package name */
    public String f46288g;

    /* renamed from: h  reason: collision with root package name */
    public String f46289h;

    /* renamed from: i  reason: collision with root package name */
    public String f46290i;

    /* renamed from: d.a.m0.a.h0.o.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0752a extends PrefetchEvent.c {
        public C0752a(@Nullable Map<String, String> map, String str) {
            super(map, str);
        }
    }

    public static a a(b bVar, PrefetchEvent prefetchEvent, e eVar) {
        long currentTimeMillis = j ? System.currentTimeMillis() : 0L;
        a aVar = new a();
        aVar.f46289h = bVar.b();
        aVar.f46282a = prefetchEvent.appPath;
        aVar.f46283b = prefetchEvent.pageUrl;
        aVar.f46287f = prefetchEvent.rootPath;
        SwanAppConfigData F = eVar.F();
        aVar.f46284c = prefetchEvent.pageType;
        String c2 = d.a.m0.a.a2.n.b.c(prefetchEvent.appPath, o0.f(j.b(prefetchEvent.pageUrl)));
        aVar.f46288g = c2;
        aVar.f46285d = g.b(c2, F.f11393e).f44582g;
        aVar.f46286e = prefetchEvent.isT7Available;
        aVar.f46290i = prefetchEvent.sConsole;
        if (j) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SlavePreloadEvent", "build slave preload event cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
        return aVar;
    }

    public C0752a b() {
        long currentTimeMillis = j ? System.currentTimeMillis() : 0L;
        TreeMap treeMap = new TreeMap();
        treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.f46289h);
        treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, this.f46282a);
        treeMap.put("pagePath", this.f46283b);
        treeMap.put("pageType", this.f46284c);
        treeMap.put("onReachBottomDistance", this.f46285d);
        treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(this.f46286e));
        treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, this.f46290i);
        treeMap.put(PrefetchEvent.EVENT_DATA_ROOT_PATH, this.f46287f);
        d.a.m0.a.t1.g.b.a(treeMap, "slave preload ready event");
        j.a(this.f46283b, treeMap);
        treeMap.put("pageConfig", this.f46288g);
        if (j) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SlavePreloadEvent", "build slave preload msg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
        return new C0752a(treeMap, "preload");
    }
}
