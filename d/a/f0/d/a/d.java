package d.a.f0.d.a;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f42817a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f42818b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f42819c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-672101744, "Ld/a/f0/d/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-672101744, "Ld/a/f0/d/a/d;");
                return;
            }
        }
        int max = Math.max(200, d.a.f0.a.b.a.f42713a.get().t());
        f42817a = max;
        f42818b = max;
        f42819c = max;
        Log.e("HttpRequestConstan", "static initializer: " + f42817a + " " + f42818b);
    }
}
