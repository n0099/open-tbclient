package d.a.s.g.b.d.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f67906a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f67907b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f67907b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(c.f67903c).modPow(new BigInteger(c.f67904d), new BigInteger(c.f67905e)).toByteArray();
            f67907b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = f67906a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(c.f67901a).modPow(new BigInteger(c.f67902b), new BigInteger(c.f67905e)).toByteArray();
            f67906a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
