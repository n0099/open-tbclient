package d.a.q0.h.e;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.a.k;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f53237a;

    /* renamed from: b  reason: collision with root package name */
    public static int f53238b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1035371349, "Ld/a/q0/h/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1035371349, "Ld/a/q0/h/e/b;");
                return;
            }
        }
        f53237a = k.f49133a;
        f53238b = -1;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            a aVar = new a();
            aVar.f53234a = b();
            aVar.f53235b = c();
            aVar.f53236c = d();
            if (f53237a) {
                Log.d("GameCodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + aVar.f53234a + " ,sizeLimit: " + aVar.f53235b);
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f53238b < 0) {
                d.a.q0.a.c1.a.Z().getSwitch("minigame_code_cache_max_count", 20);
                f53238b = 20;
            }
            return f53238b;
        }
        return invokeV.intValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return 102400;
        }
        return invokeV.intValue;
    }

    public static long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? b() * 6 * 1048576 : invokeV.longValue;
    }
}
