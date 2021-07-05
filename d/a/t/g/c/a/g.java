package d.a.t.g.c.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a(byte[] bArr, d.a.t.g.b.e.a aVar) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, bArr, aVar)) == null) {
            d.a.t.g.b.a b2 = d.a.t.g.b.a.b();
            b2.c(2, aVar);
            return b2.a(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }
}
