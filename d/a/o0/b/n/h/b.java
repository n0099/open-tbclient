package d.a.o0.b.n.h;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f49536a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a a() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (b.class) {
                if (f49536a == null) {
                    f49536a = new a();
                }
                aVar = f49536a;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }
}
