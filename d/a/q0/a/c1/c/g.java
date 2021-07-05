package d.a.q0.a.c1.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f46877a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized f a() {
        InterceptResult invokeV;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (g.class) {
                if (f46877a == null) {
                    f46877a = new f();
                }
                fVar = f46877a;
            }
            return fVar;
        }
        return (f) invokeV.objValue;
    }
}
