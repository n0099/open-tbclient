package d.a.o0.a.p0.f;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.t.d;
import java.io.File;
/* loaded from: classes7.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            File b2 = b();
            if (b2.exists()) {
                d.i(b2);
            }
        }
    }

    public static File b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new File(d.a.o0.a.f1.c.a.d().get(0).f48553a, "/aiapps_debug_extension_core/") : (File) invokeV.objValue;
    }

    public static File c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            File b2 = b();
            if (!b2.exists()) {
                b2.mkdirs();
            }
            return new File(b2, "debugExtensionCore.zip");
        }
        return (File) invokeV.objValue;
    }
}
