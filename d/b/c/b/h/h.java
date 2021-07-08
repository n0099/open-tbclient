package d.b.c.b.h;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<Long> f69002a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1867482231, "Ld/b/c/b/h/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1867482231, "Ld/b/c/b/h/h;");
                return;
            }
        }
        f69002a = new AtomicReference<>(0L);
    }

    public static void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeJ(65537, null, j) != null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= 5) {
                return;
            }
            long longValue = f69002a.get().longValue();
            if (f69002a.compareAndSet(Long.valueOf(longValue), Long.valueOf(longValue | j))) {
                return;
            }
            i2 = i3;
        }
    }
}
