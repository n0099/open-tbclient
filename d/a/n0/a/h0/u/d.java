package d.a.n0.a.h0.u;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.c2.f.p0.j;
import d.a.n0.a.k;
import d.a.n0.a.v2.o0;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f45244a;

    /* renamed from: b  reason: collision with root package name */
    public String f45245b;

    /* renamed from: c  reason: collision with root package name */
    public String f45246c;

    /* renamed from: d  reason: collision with root package name */
    public String f45247d;

    /* renamed from: e  reason: collision with root package name */
    public String f45248e;

    /* renamed from: f  reason: collision with root package name */
    public String f45249f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f45250g;

    /* renamed from: h  reason: collision with root package name */
    public String f45251h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f45252i;
    public String j;
    public String k;
    public String l;
    public boolean m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(318586210, "Ld/a/n0/a/h0/u/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(318586210, "Ld/a/n0/a/h0/u/d;");
                return;
            }
        }
        n = k.f45831a;
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static d.a.n0.a.o0.d.b a(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, dVar.f45244a);
            treeMap.put("pagePath", dVar.f45245b);
            treeMap.put("pageType", dVar.f45246c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, dVar.f45248e);
            if (!TextUtils.isEmpty(dVar.f45249f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + dVar.f45249f);
                }
                treeMap.put("initData", dVar.f45249f);
            }
            if (!TextUtils.isEmpty(dVar.f45247d)) {
                treeMap.put("onReachBottomDistance", dVar.f45247d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(dVar.f45250g));
            if (!TextUtils.isEmpty(dVar.f45251h)) {
                treeMap.put("routeId", dVar.f45251h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(dVar.f45252i));
            if (!TextUtils.isEmpty(dVar.j)) {
                treeMap.put("slavePreload", dVar.j);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_ROOT_PATH, dVar.k);
            d.a.n0.a.t1.g.b.a(treeMap, "page ready event");
            j.a(dVar.f45245b, treeMap);
            String f2 = o0.f(j.b(dVar.f45245b));
            d.a.n0.a.e0.d.h("PageReadyEvent", (String) treeMap.get("pagePath"));
            String c2 = d.a.n0.a.a2.n.b.c(dVar.f45244a, f2);
            dVar.l = c2;
            if (!TextUtils.isEmpty(c2)) {
                treeMap.put("pageConfig", dVar.l);
            }
            d.a.n0.a.h0.l.a P = g.N().P();
            if (P != null) {
                treeMap.put("masterId", P.b());
            }
            if (dVar.m) {
                treeMap.put("isFirstPage", "true");
            }
            if (d.a.n0.a.h0.g.b.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            return new d.a.n0.a.o0.d.b("PageReady", treeMap);
        }
        return (d.a.n0.a.o0.d.b) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "PageReadyEvent{appPath='" + this.f45244a + "', pagePath='" + this.f45245b + "', pageType='" + this.f45246c + "', onReachBottomDistance='" + this.f45247d + "', sConsole='" + this.f45248e + "', initData='" + this.f45249f + "', showPerformancePanel=" + this.f45250g + ", routeId='" + this.f45251h + "', isT7Available=" + this.f45252i + ", preloadFile='" + this.j + "', rootPath='" + this.k + "', pageConfig='" + this.l + "'}";
        }
        return (String) invokeV.objValue;
    }
}
