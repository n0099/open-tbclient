package d.a.n0.a.u.g;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.k;
import d.a.n0.a.r1.h;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class b implements a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47858b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, d.a.n0.a.r1.k.a> f47859a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(798776977, "Ld/a/n0/a/u/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(798776977, "Ld/a/n0/a/u/g/b;");
                return;
            }
        }
        f47858b = k.f45831a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47859a = new ConcurrentHashMap();
    }

    @Override // d.a.n0.a.u.g.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f47859a.containsKey(str)) {
            return;
        }
        if (f47858b) {
            Log.d("Api-FirstRecorder", "markStart: " + str);
        }
        d.a.n0.a.r1.k.a aVar = new d.a.n0.a.r1.k.a();
        this.f47859a.put(str, aVar);
        aVar.i(System.currentTimeMillis());
        aVar.f(str);
    }

    @Override // d.a.n0.a.u.g.a
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            d.a.n0.a.r1.k.a aVar = this.f47859a.get(str);
            if (aVar == null) {
                if (f47858b) {
                    throw new RuntimeException(str + " markEnd before markStart");
                }
            } else if (aVar.d() > 0) {
            } else {
                aVar.h(System.currentTimeMillis());
                if (f47858b) {
                    Log.d("Api-FirstRecorder", str + " first called cost " + aVar.c());
                }
                if (TextUtils.equals(str, "request")) {
                    if (f47858b) {
                        Log.d("Api-FirstRecorder", "record first request api called " + aVar.toString());
                    }
                    HybridUbcFlow p = h.p("startup");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("first_request_api_call_start");
                    ubcFlowEvent.h(aVar.e());
                    p.C(ubcFlowEvent);
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("first_request_api_call_end");
                    ubcFlowEvent2.h(aVar.d());
                    p.C(ubcFlowEvent2);
                }
            }
        }
    }
}
