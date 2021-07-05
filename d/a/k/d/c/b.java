package d.a.k.d.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f45938a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f45939b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f45938a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f45933a).modPow(new BigInteger(a.f45934b), new BigInteger(a.f45937e)).toByteArray();
            f45938a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = f45939b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f45935c).modPow(new BigInteger(a.f45936d), new BigInteger(a.f45937e)).toByteArray();
            f45939b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
