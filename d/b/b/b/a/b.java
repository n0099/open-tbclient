package d.b.b.b.a;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.mobsec.metasec.ml.MSConfig;
import ms.bd.c.m1;
/* loaded from: classes8.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a a(String str) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            synchronized (b.class) {
                m1.a a2 = m1.a(str);
                aVar = a2 != null ? new a(a2) : null;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public static synchronized boolean b(Context context, MSConfig mSConfig) {
        InterceptResult invokeLL;
        boolean c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, mSConfig)) == null) {
            synchronized (b.class) {
                c2 = m1.c(context, mSConfig.b(), "metasec_ml");
            }
            return c2;
        }
        return invokeLL.booleanValue;
    }
}
