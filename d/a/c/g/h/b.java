package d.a.c.g.h;

import com.baidu.searchbox.live.nps.LiveNPSPluginManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, e> f44611a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2087825991, "Ld/a/c/g/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2087825991, "Ld/a/c/g/h/b;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        f44611a = hashMap;
        hashMap.put(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME, new a());
    }

    public static void a(String str, int i2) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65537, null, str, i2) == null) || (eVar = f44611a.get(str)) == null) {
            return;
        }
        eVar.b(i2);
    }

    public static void b(String str, int i2, long j) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (eVar = f44611a.get(str)) == null) {
            return;
        }
        eVar.c(i2, j);
    }

    public static void c(String str, int i2, int i3) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65539, null, str, i2, i3) == null) || (eVar = f44611a.get(str)) == null) {
            return;
        }
        eVar.d(i2, i3);
    }

    public static void d(String str, int i2, int i3) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65540, null, str, i2, i3) == null) || (eVar = f44611a.get(str)) == null) {
            return;
        }
        eVar.e(i2, i3);
    }
}
