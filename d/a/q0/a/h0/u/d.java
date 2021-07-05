package d.a.q0.a.h0.u;

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
import d.a.q0.a.c2.f.p0.j;
import d.a.q0.a.k;
import d.a.q0.a.v2.o0;
import java.util.TreeMap;
/* loaded from: classes8.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f48546a;

    /* renamed from: b  reason: collision with root package name */
    public String f48547b;

    /* renamed from: c  reason: collision with root package name */
    public String f48548c;

    /* renamed from: d  reason: collision with root package name */
    public String f48549d;

    /* renamed from: e  reason: collision with root package name */
    public String f48550e;

    /* renamed from: f  reason: collision with root package name */
    public String f48551f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48552g;

    /* renamed from: h  reason: collision with root package name */
    public String f48553h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f48554i;
    public String j;
    public String k;
    public String l;
    public boolean m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(705834367, "Ld/a/q0/a/h0/u/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(705834367, "Ld/a/q0/a/h0/u/d;");
                return;
            }
        }
        n = k.f49133a;
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

    public static d.a.q0.a.o0.d.b a(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, dVar.f48546a);
            treeMap.put("pagePath", dVar.f48547b);
            treeMap.put("pageType", dVar.f48548c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, dVar.f48550e);
            if (!TextUtils.isEmpty(dVar.f48551f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + dVar.f48551f);
                }
                treeMap.put("initData", dVar.f48551f);
            }
            if (!TextUtils.isEmpty(dVar.f48549d)) {
                treeMap.put("onReachBottomDistance", dVar.f48549d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(dVar.f48552g));
            if (!TextUtils.isEmpty(dVar.f48553h)) {
                treeMap.put("routeId", dVar.f48553h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(dVar.f48554i));
            if (!TextUtils.isEmpty(dVar.j)) {
                treeMap.put("slavePreload", dVar.j);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_ROOT_PATH, dVar.k);
            d.a.q0.a.t1.g.b.a(treeMap, "page ready event");
            j.a(dVar.f48547b, treeMap);
            String f2 = o0.f(j.b(dVar.f48547b));
            d.a.q0.a.e0.d.h("PageReadyEvent", (String) treeMap.get("pagePath"));
            String c2 = d.a.q0.a.a2.n.b.c(dVar.f48546a, f2);
            dVar.l = c2;
            if (!TextUtils.isEmpty(c2)) {
                treeMap.put("pageConfig", dVar.l);
            }
            d.a.q0.a.h0.l.a P = g.N().P();
            if (P != null) {
                treeMap.put("masterId", P.b());
            }
            if (dVar.m) {
                treeMap.put("isFirstPage", "true");
            }
            if (d.a.q0.a.h0.g.b.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            return new d.a.q0.a.o0.d.b("PageReady", treeMap);
        }
        return (d.a.q0.a.o0.d.b) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "PageReadyEvent{appPath='" + this.f48546a + "', pagePath='" + this.f48547b + "', pageType='" + this.f48548c + "', onReachBottomDistance='" + this.f48549d + "', sConsole='" + this.f48550e + "', initData='" + this.f48551f + "', showPerformancePanel=" + this.f48552g + ", routeId='" + this.f48553h + "', isT7Available=" + this.f48554i + ", preloadFile='" + this.j + "', rootPath='" + this.k + "', pageConfig='" + this.l + "'}";
        }
        return (String) invokeV.objValue;
    }
}
