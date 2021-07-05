package d.a.q0.c.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f52378a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f52379b;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f52380c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(892106430, "Ld/a/q0/c/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(892106430, "Ld/a/q0/c/a/b;");
                return;
            }
        }
        f52378a = d.a.q0.a.d0.a.c();
        f52379b = f52378a + "/bdtls";
        f52380c = new byte[]{0, -98};
    }
}
