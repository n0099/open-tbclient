package d.a.e0.a.a;

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
    public static final boolean f42207a;

    /* renamed from: b  reason: collision with root package name */
    public static String f42208b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1049465173, "Ld/a/e0/a/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1049465173, "Ld/a/e0/a/a/a;");
                return;
            }
        }
        f42207a = d.a.e0.a.b.a.f42209a.get().s();
        f42208b = "https://afd.baidu.com/afd/entry";
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!f42207a || TextUtils.isEmpty(d.a.e0.a.b.a.f42209a.get().c())) {
                return TextUtils.isEmpty(f42208b) ? "https://afd.baidu.com/afd/entry" : f42208b;
            }
            return d.a.e0.a.b.a.f42209a.get().c();
        }
        return (String) invokeV.objValue;
    }
}
