package d.a.l0.a.h0.u;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.l0.a.c2.f.p0.j;
import d.a.l0.a.k;
import d.a.l0.a.v2.o0;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public final class d {
    public static final boolean n = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public String f46288a;

    /* renamed from: b  reason: collision with root package name */
    public String f46289b;

    /* renamed from: c  reason: collision with root package name */
    public String f46290c;

    /* renamed from: d  reason: collision with root package name */
    public String f46291d;

    /* renamed from: e  reason: collision with root package name */
    public String f46292e;

    /* renamed from: f  reason: collision with root package name */
    public String f46293f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f46294g;

    /* renamed from: h  reason: collision with root package name */
    public String f46295h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f46296i;
    public String j;
    public String k;
    public String l;
    public boolean m;

    public static d.a.l0.a.o0.d.b a(d dVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, dVar.f46288a);
        treeMap.put("pagePath", dVar.f46289b);
        treeMap.put("pageType", dVar.f46290c);
        treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, dVar.f46292e);
        if (!TextUtils.isEmpty(dVar.f46293f)) {
            if (n) {
                Log.d("PageReadyEvent", "add initData: " + dVar.f46293f);
            }
            treeMap.put("initData", dVar.f46293f);
        }
        if (!TextUtils.isEmpty(dVar.f46291d)) {
            treeMap.put("onReachBottomDistance", dVar.f46291d);
        }
        treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(dVar.f46294g));
        if (!TextUtils.isEmpty(dVar.f46295h)) {
            treeMap.put("routeId", dVar.f46295h);
        }
        treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(dVar.f46296i));
        if (!TextUtils.isEmpty(dVar.j)) {
            treeMap.put("slavePreload", dVar.j);
        }
        treeMap.put(PrefetchEvent.EVENT_DATA_ROOT_PATH, dVar.k);
        d.a.l0.a.t1.g.b.a(treeMap, "page ready event");
        j.a(dVar.f46289b, treeMap);
        String f2 = o0.f(j.b(dVar.f46289b));
        d.a.l0.a.e0.d.h("PageReadyEvent", (String) treeMap.get("pagePath"));
        String c2 = d.a.l0.a.a2.n.b.c(dVar.f46288a, f2);
        dVar.l = c2;
        if (!TextUtils.isEmpty(c2)) {
            treeMap.put("pageConfig", dVar.l);
        }
        d.a.l0.a.h0.l.a P = g.N().P();
        if (P != null) {
            treeMap.put("masterId", P.b());
        }
        if (dVar.m) {
            treeMap.put("isFirstPage", "true");
        }
        if (d.a.l0.a.h0.g.b.c()) {
            treeMap.put("offlinePerfTool", String.valueOf(1));
        }
        return new d.a.l0.a.o0.d.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.f46288a + "', pagePath='" + this.f46289b + "', pageType='" + this.f46290c + "', onReachBottomDistance='" + this.f46291d + "', sConsole='" + this.f46292e + "', initData='" + this.f46293f + "', showPerformancePanel=" + this.f46294g + ", routeId='" + this.f46295h + "', isT7Available=" + this.f46296i + ", preloadFile='" + this.j + "', rootPath='" + this.k + "', pageConfig='" + this.l + "'}";
    }
}
