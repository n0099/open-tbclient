package d.a.m0.a.h0.u;

import android.text.TextUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.m0.a.c2.f.p0.j;
import d.a.m0.a.v2.o0;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f46385a;

    /* renamed from: b  reason: collision with root package name */
    public String f46386b;

    /* renamed from: c  reason: collision with root package name */
    public String f46387c;

    /* renamed from: d  reason: collision with root package name */
    public String f46388d;

    /* renamed from: e  reason: collision with root package name */
    public String f46389e;

    /* renamed from: f  reason: collision with root package name */
    public String f46390f;

    /* renamed from: g  reason: collision with root package name */
    public String f46391g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f46392h;

    /* renamed from: i  reason: collision with root package name */
    public String f46393i;
    public boolean j;
    public String k;
    public boolean l;

    public static Map<String, String> a(a aVar) {
        TreeMap treeMap = new TreeMap();
        if (aVar == null) {
            return treeMap;
        }
        treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, aVar.f46385a);
        treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, aVar.f46386b);
        treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, aVar.f46387c);
        treeMap.put("pageUrl", aVar.f46388d);
        treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, aVar.f46390f);
        treeMap.put(PrefetchEvent.EVENT_DATA_ROOT_PATH, aVar.f46391g);
        if (!TextUtils.isEmpty(aVar.f46389e)) {
            treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, aVar.f46389e);
        }
        treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(aVar.f46392h));
        treeMap.put("pageType", aVar.f46393i);
        treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(aVar.j));
        if (!TextUtils.isEmpty(aVar.k)) {
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, aVar.k);
        }
        d.a.m0.a.t1.g.b.a(treeMap, "app ready event");
        j.a(aVar.f46388d, treeMap);
        if (d.a.m0.a.h0.g.b.c()) {
            treeMap.put("offlinePerfTool", String.valueOf(1));
        }
        treeMap.put("slaveReady", String.valueOf(aVar.l));
        return treeMap;
    }

    public static d.a.m0.a.o0.d.b b(a aVar) {
        Map<String, String> a2 = a(aVar);
        d.a.m0.a.o0.d.b bVar = new d.a.m0.a.o0.d.b("AppReady", a2);
        PrefetchEvent.c a3 = PrefetchEvent.a(a2);
        if (a3 == null) {
            return bVar;
        }
        c cVar = new c();
        cVar.h(a3);
        cVar.h(bVar);
        return cVar;
    }

    public static String c(d.a.m0.a.a2.e eVar, String str) {
        String R = eVar != null ? eVar.R(o0.f(str)) : null;
        return R == null ? "" : R;
    }
}
