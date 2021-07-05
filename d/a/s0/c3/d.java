package d.a.s0.c3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f58101a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c a() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d.class) {
                if (f58101a == null) {
                    f58101a = new c();
                }
                cVar = f58101a;
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }
}
