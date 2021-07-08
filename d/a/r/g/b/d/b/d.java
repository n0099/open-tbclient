package d.a.r.g.b.d.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f67228a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f67229b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f67229b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(c.f67225c).modPow(new BigInteger(c.f67226d), new BigInteger(c.f67227e)).toByteArray();
            f67229b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = f67228a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(c.f67223a).modPow(new BigInteger(c.f67224b), new BigInteger(c.f67227e)).toByteArray();
            f67228a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
