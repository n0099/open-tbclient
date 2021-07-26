package d.a.o0.a.h0.u;

import android.text.TextUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.c2.f.p0.j;
import d.a.o0.a.v2.o0;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f45737a;

    /* renamed from: b  reason: collision with root package name */
    public String f45738b;

    /* renamed from: c  reason: collision with root package name */
    public String f45739c;

    /* renamed from: d  reason: collision with root package name */
    public String f45740d;

    /* renamed from: e  reason: collision with root package name */
    public String f45741e;

    /* renamed from: f  reason: collision with root package name */
    public String f45742f;

    /* renamed from: g  reason: collision with root package name */
    public String f45743g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f45744h;

    /* renamed from: i  reason: collision with root package name */
    public String f45745i;
    public boolean j;
    public String k;
    public boolean l;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Map<String, String> a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            TreeMap treeMap = new TreeMap();
            if (aVar == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, aVar.f45737a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, aVar.f45738b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, aVar.f45739c);
            treeMap.put("pageUrl", aVar.f45740d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, aVar.f45742f);
            treeMap.put(PrefetchEvent.EVENT_DATA_ROOT_PATH, aVar.f45743g);
            if (!TextUtils.isEmpty(aVar.f45741e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, aVar.f45741e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(aVar.f45744h));
            treeMap.put("pageType", aVar.f45745i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(aVar.j));
            if (!TextUtils.isEmpty(aVar.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, aVar.k);
            }
            d.a.o0.a.t1.g.b.a(treeMap, "app ready event");
            j.a(aVar.f45740d, treeMap);
            if (d.a.o0.a.h0.g.b.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            treeMap.put("slaveReady", String.valueOf(aVar.l));
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static d.a.o0.a.o0.d.b b(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, aVar)) == null) {
            Map<String, String> a2 = a(aVar);
            d.a.o0.a.o0.d.b bVar = new d.a.o0.a.o0.d.b("AppReady", a2);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a2);
            if (createFromAppReadyEvent == null) {
                return bVar;
            }
            c cVar = new c();
            cVar.h(createFromAppReadyEvent);
            cVar.h(bVar);
            return cVar;
        }
        return (d.a.o0.a.o0.d.b) invokeL.objValue;
    }

    public static String c(d.a.o0.a.a2.e eVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, eVar, str)) == null) {
            String R = eVar != null ? eVar.R(o0.f(str)) : null;
            return R == null ? "" : R;
        }
        return (String) invokeLL.objValue;
    }
}
