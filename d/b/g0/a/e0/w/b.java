package d.b.g0.a.e0.w;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.b.g0.a.i2.i0;
import d.b.g0.a.k;
import d.b.g0.a.t1.k.p0.j;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class b {
    public static final boolean m = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public String f44709a;

    /* renamed from: b  reason: collision with root package name */
    public String f44710b;

    /* renamed from: c  reason: collision with root package name */
    public String f44711c;

    /* renamed from: d  reason: collision with root package name */
    public String f44712d;

    /* renamed from: e  reason: collision with root package name */
    public String f44713e;

    /* renamed from: f  reason: collision with root package name */
    public String f44714f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f44715g;

    /* renamed from: h  reason: collision with root package name */
    public String f44716h;
    public boolean i;
    public String j;
    public String k;
    public String l;

    public static d.b.g0.a.k0.b.b a(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, bVar.f44709a);
        treeMap.put("pagePath", bVar.f44710b);
        treeMap.put("pageType", bVar.f44711c);
        treeMap.put("devhook", bVar.f44713e);
        if (!TextUtils.isEmpty(bVar.f44714f)) {
            if (m) {
                Log.d("PageReadyEvent", "add initData: " + bVar.f44714f);
            }
            treeMap.put("initData", bVar.f44714f);
        }
        if (!TextUtils.isEmpty(bVar.f44712d)) {
            treeMap.put("onReachBottomDistance", bVar.f44712d);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.f44715g));
        if (!TextUtils.isEmpty(bVar.f44716h)) {
            treeMap.put("routeId", bVar.f44716h);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.i));
        if (!TextUtils.isEmpty(bVar.j)) {
            treeMap.put("slavePreload", bVar.j);
        }
        treeMap.put("root", bVar.k);
        d.b.g0.a.l1.g.b.a(treeMap, "page ready event");
        j.a(bVar.f44710b, treeMap);
        String c2 = d.b.g0.a.r1.n.a.c(bVar.f44709a, i0.d(j.b(bVar.f44710b)));
        bVar.l = c2;
        if (!TextUtils.isEmpty(c2)) {
            treeMap.put("pageConfig", bVar.l);
        }
        d.b.g0.a.e0.o.a N = d.L().N();
        if (N != null) {
            treeMap.put("masterId", N.c());
        }
        return new d.b.g0.a.k0.b.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.f44709a + "', pagePath='" + this.f44710b + "', pageType='" + this.f44711c + "', onReachBottomDistance='" + this.f44712d + "', sConsole='" + this.f44713e + "', initData='" + this.f44714f + "', showPerformancePanel=" + this.f44715g + ", routeId='" + this.f44716h + "', isT7Available=" + this.i + ", preloadFile='" + this.j + "', rootPath='" + this.k + "', pageConfig='" + this.l + "'}";
    }
}
