package d.a.o0.j;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile i f50968a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i a() {
        InterceptResult invokeV;
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j.class) {
                if (f50968a == null) {
                    f50968a = new i();
                }
                iVar = f50968a;
            }
            return iVar;
        }
        return (i) invokeV.objValue;
    }
}
