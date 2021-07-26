package d.a.f0.a.a;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42711a;

    /* renamed from: b  reason: collision with root package name */
    public static String f42712b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-757989290, "Ld/a/f0/a/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-757989290, "Ld/a/f0/a/a/a;");
                return;
            }
        }
        f42711a = d.a.f0.a.b.a.f42713a.get().s();
        f42712b = "https://afd.baidu.com/afd/entry";
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!f42711a || TextUtils.isEmpty(d.a.f0.a.b.a.f42713a.get().c())) {
                return TextUtils.isEmpty(f42712b) ? "https://afd.baidu.com/afd/entry" : f42712b;
            }
            return d.a.f0.a.b.a.f42713a.get().c();
        }
        return (String) invokeV.objValue;
    }
}
