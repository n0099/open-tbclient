package d.a.q0.e.i;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f52465a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e a() {
        InterceptResult invokeV;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f.class) {
                if (f52465a == null) {
                    f52465a = new e();
                }
                eVar = f52465a;
            }
            return eVar;
        }
        return (e) invokeV.objValue;
    }
}
