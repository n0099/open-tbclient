package d.a.h0.a.a;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45559a;

    /* renamed from: b  reason: collision with root package name */
    public static String f45560b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-77930920, "Ld/a/h0/a/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-77930920, "Ld/a/h0/a/a/a;");
                return;
            }
        }
        f45559a = d.a.h0.a.b.a.f45561a.get().s();
        f45560b = "https://afd.baidu.com/afd/entry";
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!f45559a || TextUtils.isEmpty(d.a.h0.a.b.a.f45561a.get().c())) {
                return TextUtils.isEmpty(f45560b) ? "https://afd.baidu.com/afd/entry" : f45560b;
            }
            return d.a.h0.a.b.a.f45561a.get().c();
        }
        return (String) invokeV.objValue;
    }
}
