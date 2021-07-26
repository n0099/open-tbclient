package d.a.l.d.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f43325a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f43326b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f43325a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f43320a).modPow(new BigInteger(a.f43321b), new BigInteger(a.f43324e)).toByteArray();
            f43325a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = f43326b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f43322c).modPow(new BigInteger(a.f43323d), new BigInteger(a.f43324e)).toByteArray();
            f43326b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
