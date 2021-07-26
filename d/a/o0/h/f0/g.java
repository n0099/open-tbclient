package d.a.o0.h.f0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f50504a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized f a() {
        InterceptResult invokeV;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (g.class) {
                if (f50504a == null) {
                    f50504a = new f();
                }
                fVar = f50504a;
            }
            return fVar;
        }
        return (f) invokeV.objValue;
    }
}
