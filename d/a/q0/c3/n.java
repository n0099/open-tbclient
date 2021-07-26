package d.a.q0.c3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile m f55399a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized m a() {
        InterceptResult invokeV;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (n.class) {
                if (f55399a == null) {
                    f55399a = new m();
                }
                mVar = f55399a;
            }
            return mVar;
        }
        return (m) invokeV.objValue;
    }
}
