package d.a.t.g.b.d.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f70370a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f70371b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f70371b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(c.f70367c).modPow(new BigInteger(c.f70368d), new BigInteger(c.f70369e)).toByteArray();
            f70371b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = f70370a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(c.f70365a).modPow(new BigInteger(c.f70366b), new BigInteger(c.f70369e)).toByteArray();
            f70370a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
