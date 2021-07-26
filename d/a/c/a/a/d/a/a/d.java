package d.a.c.a.a.d.a.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f41380a;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f41380a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(c.f41377a).modPow(new BigInteger(c.f41378b), new BigInteger(c.f41379c)).toByteArray();
            f41380a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
