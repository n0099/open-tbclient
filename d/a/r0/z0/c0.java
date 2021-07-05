package d.a.r0.z0;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class c0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f56914a;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (StringUtils.isNull(f56914a)) {
                return null;
            }
            return f56914a;
        }
        return (String) invokeV.objValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            f56914a = str;
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || f56914a == null) {
            return;
        }
        f56914a = null;
    }
}
