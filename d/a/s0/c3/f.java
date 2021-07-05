package d.a.s0.c3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f58103a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e a() {
        InterceptResult invokeV;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f.class) {
                if (f58103a == null) {
                    f58103a = new e();
                }
                eVar = f58103a;
            }
            return eVar;
        }
        return (e) invokeV.objValue;
    }
}
