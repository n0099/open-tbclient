package d.a.n0.a.c1.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile j f43577a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized j a() {
        InterceptResult invokeV;
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (k.class) {
                if (f43577a == null) {
                    f43577a = new j();
                }
                jVar = f43577a;
            }
            return jVar;
        }
        return (j) invokeV.objValue;
    }
}
