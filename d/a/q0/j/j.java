package d.a.q0.j;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile i f53766a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i a() {
        InterceptResult invokeV;
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j.class) {
                if (f53766a == null) {
                    f53766a = new i();
                }
                iVar = f53766a;
            }
            return iVar;
        }
        return (i) invokeV.objValue;
    }
}
