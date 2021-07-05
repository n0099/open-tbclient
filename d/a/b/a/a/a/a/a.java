package d.a.b.a.a.a.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1190452028, "Ld/a/b/a/a/a/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1190452028, "Ld/a/b/a/a/a/a/a;");
        }
    }

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            int i3 = i2 % 3;
            char c2 = 1;
            if (i3 == 1) {
                i2 += 2;
                c2 = 2;
            } else if (i3 == 2) {
                i2++;
            } else {
                c2 = 0;
            }
            int i4 = (i2 / 3) * 2;
            return c2 > 0 ? i4 + 1 : i4;
        }
        return invokeI.intValue;
    }

    public static b b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            int length = (((bArr.length - 1) / 2) * 3) - (bArr.length % 2 != 0 ? bArr[bArr.length - 1] : 0);
            int i2 = length / 8;
            if (length % 8 > 0) {
                i2++;
            }
            byte[] bArr2 = new byte[i2];
            int i3 = 0;
            int i4 = 8;
            for (int i5 = 0; i5 < bArr.length - 1; i5 += 2) {
                byte b2 = (byte) (((bArr[i5] * 3) + bArr[i5 + 1]) & 255);
                for (int i6 = 2; i6 >= 0; i6--) {
                    if (i4 <= 0) {
                        i3++;
                        i4 = 8;
                    }
                    if (i3 >= i2) {
                        break;
                    }
                    bArr2[i3] = (byte) ((bArr2[i3] << 1) | ((b2 >> i6) & 1));
                    i4--;
                }
            }
            if (i4 > 0 && i3 < i2) {
                bArr2[i3] = (byte) (bArr2[i3] << i4);
            }
            return new b(bArr2, length);
        }
        return (b) invokeL.objValue;
    }
}
