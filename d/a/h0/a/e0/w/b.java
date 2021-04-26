package d.a.h0.a.e0.w;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.h0.a.i2.i0;
import d.a.h0.a.k;
import d.a.h0.a.t1.k.p0.j;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class b {
    public static final boolean m = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public String f42345a;

    /* renamed from: b  reason: collision with root package name */
    public String f42346b;

    /* renamed from: c  reason: collision with root package name */
    public String f42347c;

    /* renamed from: d  reason: collision with root package name */
    public String f42348d;

    /* renamed from: e  reason: collision with root package name */
    public String f42349e;

    /* renamed from: f  reason: collision with root package name */
    public String f42350f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42351g;

    /* renamed from: h  reason: collision with root package name */
    public String f42352h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f42353i;
    public String j;
    public String k;
    public String l;

    public static d.a.h0.a.k0.b.b a(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, bVar.f42345a);
        treeMap.put("pagePath", bVar.f42346b);
        treeMap.put("pageType", bVar.f42347c);
        treeMap.put("devhook", bVar.f42349e);
        if (!TextUtils.isEmpty(bVar.f42350f)) {
            if (m) {
                Log.d("PageReadyEvent", "add initData: " + bVar.f42350f);
            }
            treeMap.put("initData", bVar.f42350f);
        }
        if (!TextUtils.isEmpty(bVar.f42348d)) {
            treeMap.put("onReachBottomDistance", bVar.f42348d);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.f42351g));
        if (!TextUtils.isEmpty(bVar.f42352h)) {
            treeMap.put("routeId", bVar.f42352h);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.f42353i));
        if (!TextUtils.isEmpty(bVar.j)) {
            treeMap.put("slavePreload", bVar.j);
        }
        treeMap.put("root", bVar.k);
        d.a.h0.a.l1.g.b.a(treeMap, "page ready event");
        j.a(bVar.f42346b, treeMap);
        String c2 = d.a.h0.a.r1.n.a.c(bVar.f42345a, i0.d(j.b(bVar.f42346b)));
        bVar.l = c2;
        if (!TextUtils.isEmpty(c2)) {
            treeMap.put("pageConfig", bVar.l);
        }
        d.a.h0.a.e0.o.a N = d.L().N();
        if (N != null) {
            treeMap.put("masterId", N.c());
        }
        return new d.a.h0.a.k0.b.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.f42345a + "', pagePath='" + this.f42346b + "', pageType='" + this.f42347c + "', onReachBottomDistance='" + this.f42348d + "', sConsole='" + this.f42349e + "', initData='" + this.f42350f + "', showPerformancePanel=" + this.f42351g + ", routeId='" + this.f42352h + "', isT7Available=" + this.f42353i + ", preloadFile='" + this.j + "', rootPath='" + this.k + "', pageConfig='" + this.l + "'}";
    }
}
