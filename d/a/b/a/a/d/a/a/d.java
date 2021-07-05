package d.a.b.a.a.d.a.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f43798a;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = f43798a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(c.f43795a).modPow(new BigInteger(c.f43796b), new BigInteger(c.f43797c)).toByteArray();
            f43798a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}
