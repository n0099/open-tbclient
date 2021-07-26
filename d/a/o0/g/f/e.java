package d.a.o0.g.f;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f50213a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized d a() {
        InterceptResult invokeV;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (e.class) {
                if (f50213a == null) {
                    f50213a = new d();
                }
                dVar = f50213a;
            }
            return dVar;
        }
        return (d) invokeV.objValue;
    }
}
