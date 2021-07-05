package d.a.q0.a.h0.o.i;

import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.e;
import d.a.q0.a.a2.n.g;
import d.a.q0.a.c2.f.p0.j;
import d.a.q0.a.k;
import d.a.q0.a.p.e.b;
import d.a.q0.a.v2.o0;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f48432a;

    /* renamed from: b  reason: collision with root package name */
    public String f48433b;

    /* renamed from: c  reason: collision with root package name */
    public String f48434c;

    /* renamed from: d  reason: collision with root package name */
    public String f48435d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f48436e;

    /* renamed from: f  reason: collision with root package name */
    public String f48437f;

    /* renamed from: g  reason: collision with root package name */
    public String f48438g;

    /* renamed from: h  reason: collision with root package name */
    public String f48439h;

    /* renamed from: i  reason: collision with root package name */
    public String f48440i;

    /* renamed from: d.a.q0.a.h0.o.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0812a extends PrefetchEvent.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0812a(@Nullable Map<String, String> map, String str) {
            super(map, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Map) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-469640498, "Ld/a/q0/a/h0/o/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-469640498, "Ld/a/q0/a/h0/o/i/a;");
                return;
            }
        }
        j = k.f49133a;
    }

    public a() {
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

    public static a a(b bVar, PrefetchEvent prefetchEvent, e eVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, bVar, prefetchEvent, eVar)) == null) {
            long currentTimeMillis = j ? System.currentTimeMillis() : 0L;
            a aVar = new a();
            aVar.f48439h = bVar.b();
            aVar.f48432a = prefetchEvent.appPath;
            aVar.f48433b = prefetchEvent.pageUrl;
            aVar.f48437f = prefetchEvent.rootPath;
            SwanAppConfigData F = eVar.F();
            aVar.f48434c = prefetchEvent.pageType;
            String c2 = d.a.q0.a.a2.n.b.c(prefetchEvent.appPath, o0.f(j.b(prefetchEvent.pageUrl)));
            aVar.f48438g = c2;
            aVar.f48435d = g.b(c2, F.f11460e).f46732g;
            aVar.f48436e = prefetchEvent.isT7Available;
            aVar.f48440i = prefetchEvent.sConsole;
            if (j) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SlavePreloadEvent", "build slave preload event cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
            return aVar;
        }
        return (a) invokeLLL.objValue;
    }

    public C0812a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long currentTimeMillis = j ? System.currentTimeMillis() : 0L;
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.f48439h);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, this.f48432a);
            treeMap.put("pagePath", this.f48433b);
            treeMap.put("pageType", this.f48434c);
            treeMap.put("onReachBottomDistance", this.f48435d);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(this.f48436e));
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, this.f48440i);
            treeMap.put(PrefetchEvent.EVENT_DATA_ROOT_PATH, this.f48437f);
            d.a.q0.a.t1.g.b.a(treeMap, "slave preload ready event");
            j.a(this.f48433b, treeMap);
            treeMap.put("pageConfig", this.f48438g);
            if (j) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SlavePreloadEvent", "build slave preload msg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
            return new C0812a(treeMap, "preload");
        }
        return (C0812a) invokeV.objValue;
    }
}
