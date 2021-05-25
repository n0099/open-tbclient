package d.a.l0.a.h0.u;

import android.text.TextUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.l0.a.c2.f.p0.j;
import d.a.l0.a.v2.o0;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f42601a;

    /* renamed from: b  reason: collision with root package name */
    public String f42602b;

    /* renamed from: c  reason: collision with root package name */
    public String f42603c;

    /* renamed from: d  reason: collision with root package name */
    public String f42604d;

    /* renamed from: e  reason: collision with root package name */
    public String f42605e;

    /* renamed from: f  reason: collision with root package name */
    public String f42606f;

    /* renamed from: g  reason: collision with root package name */
    public String f42607g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42608h;

    /* renamed from: i  reason: collision with root package name */
    public String f42609i;
    public boolean j;
    public String k;
    public boolean l;

    public static Map<String, String> a(a aVar) {
        TreeMap treeMap = new TreeMap();
        if (aVar == null) {
            return treeMap;
        }
        treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, aVar.f42601a);
        treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, aVar.f42602b);
        treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, aVar.f42603c);
        treeMap.put("pageUrl", aVar.f42604d);
        treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, aVar.f42606f);
        treeMap.put(PrefetchEvent.EVENT_DATA_ROOT_PATH, aVar.f42607g);
        if (!TextUtils.isEmpty(aVar.f42605e)) {
            treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, aVar.f42605e);
        }
        treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(aVar.f42608h));
        treeMap.put("pageType", aVar.f42609i);
        treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(aVar.j));
        if (!TextUtils.isEmpty(aVar.k)) {
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, aVar.k);
        }
        d.a.l0.a.t1.g.b.a(treeMap, "app ready event");
        j.a(aVar.f42604d, treeMap);
        if (d.a.l0.a.h0.g.b.c()) {
            treeMap.put("offlinePerfTool", String.valueOf(1));
        }
        treeMap.put("slaveReady", String.valueOf(aVar.l));
        return treeMap;
    }

    public static d.a.l0.a.o0.d.b b(a aVar) {
        Map<String, String> a2 = a(aVar);
        d.a.l0.a.o0.d.b bVar = new d.a.l0.a.o0.d.b("AppReady", a2);
        PrefetchEvent.c a3 = PrefetchEvent.a(a2);
        if (a3 == null) {
            return bVar;
        }
        c cVar = new c();
        cVar.h(a3);
        cVar.h(bVar);
        return cVar;
    }

    public static String c(d.a.l0.a.a2.e eVar, String str) {
        String R = eVar != null ? eVar.R(o0.f(str)) : null;
        return R == null ? "" : R;
    }
}
