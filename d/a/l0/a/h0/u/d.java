package d.a.l0.a.h0.u;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.l0.a.c2.f.p0.j;
import d.a.l0.a.k;
import d.a.l0.a.v2.o0;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class d {
    public static final boolean n = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public String f42612a;

    /* renamed from: b  reason: collision with root package name */
    public String f42613b;

    /* renamed from: c  reason: collision with root package name */
    public String f42614c;

    /* renamed from: d  reason: collision with root package name */
    public String f42615d;

    /* renamed from: e  reason: collision with root package name */
    public String f42616e;

    /* renamed from: f  reason: collision with root package name */
    public String f42617f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42618g;

    /* renamed from: h  reason: collision with root package name */
    public String f42619h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f42620i;
    public String j;
    public String k;
    public String l;
    public boolean m;

    public static d.a.l0.a.o0.d.b a(d dVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, dVar.f42612a);
        treeMap.put("pagePath", dVar.f42613b);
        treeMap.put("pageType", dVar.f42614c);
        treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, dVar.f42616e);
        if (!TextUtils.isEmpty(dVar.f42617f)) {
            if (n) {
                Log.d("PageReadyEvent", "add initData: " + dVar.f42617f);
            }
            treeMap.put("initData", dVar.f42617f);
        }
        if (!TextUtils.isEmpty(dVar.f42615d)) {
            treeMap.put("onReachBottomDistance", dVar.f42615d);
        }
        treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(dVar.f42618g));
        if (!TextUtils.isEmpty(dVar.f42619h)) {
            treeMap.put("routeId", dVar.f42619h);
        }
        treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(dVar.f42620i));
        if (!TextUtils.isEmpty(dVar.j)) {
            treeMap.put("slavePreload", dVar.j);
        }
        treeMap.put(PrefetchEvent.EVENT_DATA_ROOT_PATH, dVar.k);
        d.a.l0.a.t1.g.b.a(treeMap, "page ready event");
        j.a(dVar.f42613b, treeMap);
        String f2 = o0.f(j.b(dVar.f42613b));
        d.a.l0.a.e0.d.h("PageReadyEvent", (String) treeMap.get("pagePath"));
        String c2 = d.a.l0.a.a2.n.b.c(dVar.f42612a, f2);
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
        return "PageReadyEvent{appPath='" + this.f42612a + "', pagePath='" + this.f42613b + "', pageType='" + this.f42614c + "', onReachBottomDistance='" + this.f42615d + "', sConsole='" + this.f42616e + "', initData='" + this.f42617f + "', showPerformancePanel=" + this.f42618g + ", routeId='" + this.f42619h + "', isT7Available=" + this.f42620i + ", preloadFile='" + this.j + "', rootPath='" + this.k + "', pageConfig='" + this.l + "'}";
    }
}
