package d.a.n0.h.t.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile m f50306a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized m a() {
        InterceptResult invokeV;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (n.class) {
                if (f50306a == null) {
                    f50306a = new m();
                }
                mVar = f50306a;
            }
            return mVar;
        }
        return (m) invokeV.objValue;
    }
}
