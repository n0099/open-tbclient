package d.a.i0.a.h0.u;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.i0.a.c2.f.p0.j;
import d.a.i0.a.k;
import d.a.i0.a.v2.o0;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class d {
    public static final boolean n = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public String f42438a;

    /* renamed from: b  reason: collision with root package name */
    public String f42439b;

    /* renamed from: c  reason: collision with root package name */
    public String f42440c;

    /* renamed from: d  reason: collision with root package name */
    public String f42441d;

    /* renamed from: e  reason: collision with root package name */
    public String f42442e;

    /* renamed from: f  reason: collision with root package name */
    public String f42443f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42444g;

    /* renamed from: h  reason: collision with root package name */
    public String f42445h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f42446i;
    public String j;
    public String k;
    public String l;
    public boolean m;

    public static d.a.i0.a.o0.d.b a(d dVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, dVar.f42438a);
        treeMap.put("pagePath", dVar.f42439b);
        treeMap.put("pageType", dVar.f42440c);
        treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, dVar.f42442e);
        if (!TextUtils.isEmpty(dVar.f42443f)) {
            if (n) {
                Log.d("PageReadyEvent", "add initData: " + dVar.f42443f);
            }
            treeMap.put("initData", dVar.f42443f);
        }
        if (!TextUtils.isEmpty(dVar.f42441d)) {
            treeMap.put("onReachBottomDistance", dVar.f42441d);
        }
        treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(dVar.f42444g));
        if (!TextUtils.isEmpty(dVar.f42445h)) {
            treeMap.put("routeId", dVar.f42445h);
        }
        treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(dVar.f42446i));
        if (!TextUtils.isEmpty(dVar.j)) {
            treeMap.put("slavePreload", dVar.j);
        }
        treeMap.put(PrefetchEvent.EVENT_DATA_ROOT_PATH, dVar.k);
        d.a.i0.a.t1.g.b.a(treeMap, "page ready event");
        j.a(dVar.f42439b, treeMap);
        String f2 = o0.f(j.b(dVar.f42439b));
        d.a.i0.a.e0.d.h("PageReadyEvent", (String) treeMap.get("pagePath"));
        String c2 = d.a.i0.a.a2.n.b.c(dVar.f42438a, f2);
        dVar.l = c2;
        if (!TextUtils.isEmpty(c2)) {
            treeMap.put("pageConfig", dVar.l);
        }
        d.a.i0.a.h0.l.a P = g.N().P();
        if (P != null) {
            treeMap.put("masterId", P.b());
        }
        if (dVar.m) {
            treeMap.put("isFirstPage", "true");
        }
        if (d.a.i0.a.h0.g.b.c()) {
            treeMap.put("offlinePerfTool", String.valueOf(1));
        }
        return new d.a.i0.a.o0.d.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.f42438a + "', pagePath='" + this.f42439b + "', pageType='" + this.f42440c + "', onReachBottomDistance='" + this.f42441d + "', sConsole='" + this.f42442e + "', initData='" + this.f42443f + "', showPerformancePanel=" + this.f42444g + ", routeId='" + this.f42445h + "', isT7Available=" + this.f42446i + ", preloadFile='" + this.j + "', rootPath='" + this.k + "', pageConfig='" + this.l + "'}";
    }
}
