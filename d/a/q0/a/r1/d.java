package d.a.q0.a.r1;

import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
/* loaded from: classes8.dex */
public class d implements d.a.q0.a.v2.e1.b<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f50362e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(126199950, "Ld/a/q0/a/r1/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(126199950, "Ld/a/q0/a/r1/d;");
                return;
            }
        }
        f50362e = k.f49133a;
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.v2.e1.b
    /* renamed from: a */
    public void onCallback(HybridUbcFlow hybridUbcFlow) {
        PMSAppInfo s;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hybridUbcFlow) == null) {
            if (f50362e) {
                Log.i("LaunchCounter", "report: flow=" + hybridUbcFlow);
            }
            if (hybridUbcFlow == null || (s = d.a.q0.n.g.a.h().s(d.a.q0.a.a2.d.g().getAppId())) == null) {
                return;
            }
            UbcFlowEvent f2 = hybridUbcFlow.f("naStart");
            s.countLaunch(f2 == null ? System.currentTimeMillis() : f2.g());
            d.a.q0.n.g.a.h().w(s);
        }
    }
}
