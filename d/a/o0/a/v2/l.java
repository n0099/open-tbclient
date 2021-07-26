package d.a.o0.a.v2;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.a.v2.k0;
import java.io.File;
import java.util.List;
/* loaded from: classes7.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            List<k0.a> d2 = d.a.o0.a.f1.c.a.d();
            if (d2 == null || d2.size() <= 0) {
                return null;
            }
            File file = new File(d2.get(0).f48553a, "/debug/");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new File(d.a.o0.a.f1.c.a.d().get(0).f48553a, "/debug/").getAbsolutePath() : (String) invokeV.objValue;
    }
}
