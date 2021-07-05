package d.a.q0.g.f;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f53011a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized d a() {
        InterceptResult invokeV;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (e.class) {
                if (f53011a == null) {
                    f53011a = new d();
                }
                dVar = f53011a;
            }
            return dVar;
        }
        return (d) invokeV.objValue;
    }
}
