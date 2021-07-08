package d.a.b.a.a.d.a.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f40876a;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f40876a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(c.f40873a).modPow(new BigInteger(c.f40874b), new BigInteger(c.f40875c)).toByteArray();
            f40876a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
