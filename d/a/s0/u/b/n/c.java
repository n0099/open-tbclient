package d.a.s0.u.b.n;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f65713a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b a() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c.class) {
                if (f65713a == null) {
                    f65713a = new b();
                }
                bVar = f65713a;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }
}
