package d.a.s.a.a;

import android.content.Context;
import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, context, file) == null) {
            c().b(context, file);
        }
    }

    public static boolean b(Context context, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, file)) == null) ? c().a(context, file) : invokeLL.booleanValue;
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 26) {
                return new d();
            }
            if (i2 >= 23) {
                return new c();
            }
            if (i2 >= 14) {
                return new b();
            }
            return new e();
        }
        return (a) invokeV.objValue;
    }
}
