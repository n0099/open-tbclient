package d.a.m0.a.h0.u;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.m0.a.c2.f.p0.j;
import d.a.m0.a.k;
import d.a.m0.a.v2.o0;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public final class d {
    public static final boolean n = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public String f46396a;

    /* renamed from: b  reason: collision with root package name */
    public String f46397b;

    /* renamed from: c  reason: collision with root package name */
    public String f46398c;

    /* renamed from: d  reason: collision with root package name */
    public String f46399d;

    /* renamed from: e  reason: collision with root package name */
    public String f46400e;

    /* renamed from: f  reason: collision with root package name */
    public String f46401f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f46402g;

    /* renamed from: h  reason: collision with root package name */
    public String f46403h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f46404i;
    public String j;
    public String k;
    public String l;
    public boolean m;

    public static d.a.m0.a.o0.d.b a(d dVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, dVar.f46396a);
        treeMap.put("pagePath", dVar.f46397b);
        treeMap.put("pageType", dVar.f46398c);
        treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, dVar.f46400e);
        if (!TextUtils.isEmpty(dVar.f46401f)) {
            if (n) {
                Log.d("PageReadyEvent", "add initData: " + dVar.f46401f);
            }
            treeMap.put("initData", dVar.f46401f);
        }
        if (!TextUtils.isEmpty(dVar.f46399d)) {
            treeMap.put("onReachBottomDistance", dVar.f46399d);
        }
        treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(dVar.f46402g));
        if (!TextUtils.isEmpty(dVar.f46403h)) {
            treeMap.put("routeId", dVar.f46403h);
        }
        treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(dVar.f46404i));
        if (!TextUtils.isEmpty(dVar.j)) {
            treeMap.put("slavePreload", dVar.j);
        }
        treeMap.put(PrefetchEvent.EVENT_DATA_ROOT_PATH, dVar.k);
        d.a.m0.a.t1.g.b.a(treeMap, "page ready event");
        j.a(dVar.f46397b, treeMap);
        String f2 = o0.f(j.b(dVar.f46397b));
        d.a.m0.a.e0.d.h("PageReadyEvent", (String) treeMap.get("pagePath"));
        String c2 = d.a.m0.a.a2.n.b.c(dVar.f46396a, f2);
        dVar.l = c2;
        if (!TextUtils.isEmpty(c2)) {
            treeMap.put("pageConfig", dVar.l);
        }
        d.a.m0.a.h0.l.a P = g.N().P();
        if (P != null) {
            treeMap.put("masterId", P.b());
        }
        if (dVar.m) {
            treeMap.put("isFirstPage", "true");
        }
        if (d.a.m0.a.h0.g.b.c()) {
            treeMap.put("offlinePerfTool", String.valueOf(1));
        }
        return new d.a.m0.a.o0.d.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.f46396a + "', pagePath='" + this.f46397b + "', pageType='" + this.f46398c + "', onReachBottomDistance='" + this.f46399d + "', sConsole='" + this.f46400e + "', initData='" + this.f46401f + "', showPerformancePanel=" + this.f46402g + ", routeId='" + this.f46403h + "', isT7Available=" + this.f46404i + ", preloadFile='" + this.j + "', rootPath='" + this.k + "', pageConfig='" + this.l + "'}";
    }
}
