package d.n.a.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a */
    public static final b f72194a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-629865143, "Ld/n/a/a/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-629865143, "Ld/n/a/a/f;");
                return;
            }
        }
        f72194a = new b(null);
    }

    /* JADX DEBUG: Method not inlined, still used in: [d.n.a.a.b.b():d.n.a.a.b] */
    public static /* synthetic */ b a() {
        return f72194a;
    }
}
