package d.a.o0.z0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static long f53690a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = f53690a;
            if (j > currentTimeMillis) {
                f53690a = currentTimeMillis;
                return false;
            } else if (currentTimeMillis - j < 500) {
                return true;
            } else {
                f53690a = currentTimeMillis;
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
