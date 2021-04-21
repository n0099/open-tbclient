package d.b.h0.a.e0.w;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.b.h0.a.i2.i0;
import d.b.h0.a.k;
import d.b.h0.a.t1.k.p0.j;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class b {
    public static final boolean m = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public String f45038a;

    /* renamed from: b  reason: collision with root package name */
    public String f45039b;

    /* renamed from: c  reason: collision with root package name */
    public String f45040c;

    /* renamed from: d  reason: collision with root package name */
    public String f45041d;

    /* renamed from: e  reason: collision with root package name */
    public String f45042e;

    /* renamed from: f  reason: collision with root package name */
    public String f45043f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f45044g;

    /* renamed from: h  reason: collision with root package name */
    public String f45045h;
    public boolean i;
    public String j;
    public String k;
    public String l;

    public static d.b.h0.a.k0.b.b a(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, bVar.f45038a);
        treeMap.put("pagePath", bVar.f45039b);
        treeMap.put("pageType", bVar.f45040c);
        treeMap.put("devhook", bVar.f45042e);
        if (!TextUtils.isEmpty(bVar.f45043f)) {
            if (m) {
                Log.d("PageReadyEvent", "add initData: " + bVar.f45043f);
            }
            treeMap.put("initData", bVar.f45043f);
        }
        if (!TextUtils.isEmpty(bVar.f45041d)) {
            treeMap.put("onReachBottomDistance", bVar.f45041d);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.f45044g));
        if (!TextUtils.isEmpty(bVar.f45045h)) {
            treeMap.put("routeId", bVar.f45045h);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.i));
        if (!TextUtils.isEmpty(bVar.j)) {
            treeMap.put("slavePreload", bVar.j);
        }
        treeMap.put("root", bVar.k);
        d.b.h0.a.l1.g.b.a(treeMap, "page ready event");
        j.a(bVar.f45039b, treeMap);
        String c2 = d.b.h0.a.r1.n.a.c(bVar.f45038a, i0.d(j.b(bVar.f45039b)));
        bVar.l = c2;
        if (!TextUtils.isEmpty(c2)) {
            treeMap.put("pageConfig", bVar.l);
        }
        d.b.h0.a.e0.o.a N = d.L().N();
        if (N != null) {
            treeMap.put("masterId", N.c());
        }
        return new d.b.h0.a.k0.b.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.f45038a + "', pagePath='" + this.f45039b + "', pageType='" + this.f45040c + "', onReachBottomDistance='" + this.f45041d + "', sConsole='" + this.f45042e + "', initData='" + this.f45043f + "', showPerformancePanel=" + this.f45044g + ", routeId='" + this.f45045h + "', isT7Available=" + this.i + ", preloadFile='" + this.j + "', rootPath='" + this.k + "', pageConfig='" + this.l + "'}";
    }
}
