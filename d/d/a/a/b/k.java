package d.d.a.a.b;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static AtomicLong f72030a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2039973253, "Ld/d/a/a/b/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2039973253, "Ld/d/a/a/b/k;");
                return;
            }
        }
        f72030a = new AtomicLong(999L);
    }

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (0 == f72030a.incrementAndGet()) {
                f72030a.set(999L);
            }
            return f72030a.get();
        }
        return invokeV.longValue;
    }

    public static void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, null, j) == null) {
            if (0 == j) {
                j = 999;
            }
            f72030a.set(j);
        }
    }
}
