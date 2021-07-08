package d.a.k.d.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f42821a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f42822b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f42821a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f42816a).modPow(new BigInteger(a.f42817b), new BigInteger(a.f42820e)).toByteArray();
            f42821a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = f42822b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(a.f42818c).modPow(new BigInteger(a.f42819d), new BigInteger(a.f42820e)).toByteArray();
            f42822b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
