package d.a.q0.a.h0.e;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.a.g1.f;
import d.a.q0.a.k;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(705357649, "Ld/a/q0/a/h0/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(705357649, "Ld/a/q0/a/h0/e/b;");
                return;
            }
        }
        boolean z = k.f49133a;
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("data", str2);
            f.V().m(f.V().q().b(), new d.a.q0.a.o0.d.b(str, hashMap));
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            d.a.q0.a.p.e.d B = f.V().B(f.V().D());
            if (B != null) {
                d.a.q0.a.e0.d.g("ConsoleMessageHelper", "send full San request");
                B.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
            }
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            a("sanFullData2Console", str);
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, str) == null) {
            a("sanIncData2Console", str);
        }
    }
}
