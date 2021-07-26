package d.a.q0.c3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile k f55398a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized k a() {
        InterceptResult invokeV;
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (l.class) {
                if (f55398a == null) {
                    f55398a = new k();
                }
                kVar = f55398a;
            }
            return kVar;
        }
        return (k) invokeV.objValue;
    }
}
