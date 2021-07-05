package d.a.u0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f70645a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized h a() {
        InterceptResult invokeV;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (i.class) {
                if (f70645a == null) {
                    f70645a = new h();
                }
                hVar = f70645a;
            }
            return hVar;
        }
        return (h) invokeV.objValue;
    }
}
