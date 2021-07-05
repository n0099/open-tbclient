package d.a.s0.c3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile g f58104a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized g a() {
        InterceptResult invokeV;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (h.class) {
                if (f58104a == null) {
                    f58104a = new g();
                }
                gVar = f58104a;
            }
            return gVar;
        }
        return (g) invokeV.objValue;
    }
}
