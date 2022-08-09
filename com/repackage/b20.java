package com.repackage;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b20 {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[][] a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] a;

        public a(byte[] bArr, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bArr, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bArr;
        }

        public byte[] a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (byte[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755879023, "Lcom/repackage/b20;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755879023, "Lcom/repackage/b20;");
                return;
            }
        }
        a = new byte[][]{new byte[]{0, 0}, new byte[]{0, 1}, new byte[]{0, 2}, new byte[]{1, 0}, new byte[]{1, 1}, new byte[]{1, 2}, new byte[]{2, 0}, new byte[]{2, 1}};
    }

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            int i2 = i % 3;
            char c = 1;
            if (i2 == 1) {
                i += 2;
                c = 2;
            } else if (i2 == 2) {
                i++;
            } else {
                c = 0;
            }
            int i3 = (i / 3) * 2;
            return c > 0 ? i3 + 1 : i3;
        }
        return invokeI.intValue;
    }

    public static a b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            int length = (((bArr.length - 1) / 2) * 3) - (bArr.length % 2 != 0 ? bArr[bArr.length - 1] : 0);
            int i = length / 8;
            if (length % 8 > 0) {
                i++;
            }
            byte[] bArr2 = new byte[i];
            int i2 = 0;
            int i3 = 8;
            for (int i4 = 0; i4 < bArr.length - 1; i4 += 2) {
                byte b = (byte) (((bArr[i4] * 3) + bArr[i4 + 1]) & 255);
                for (int i5 = 2; i5 >= 0; i5--) {
                    if (i3 <= 0) {
                        i2++;
                        i3 = 8;
                    }
                    if (i2 >= i) {
                        break;
                    }
                    bArr2[i2] = (byte) ((bArr2[i2] << 1) | ((b >> i5) & 1));
                    i3--;
                }
            }
            if (i3 > 0 && i2 < i) {
                bArr2[i2] = (byte) (bArr2[i2] << i3);
            }
            return new a(bArr2, length);
        }
        return (a) invokeL.objValue;
    }

    public static byte[] c(byte[] bArr, int i) {
        InterceptResult invokeLI;
        int i2;
        byte b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, bArr, i)) == null) {
            int i3 = i % 3;
            if (i3 == 1) {
                i2 = i + 2;
                b = 2;
            } else if (i3 == 2) {
                i2 = i + 1;
                b = 1;
            } else {
                i2 = i;
                b = 0;
            }
            int i4 = (i2 / 3) * 2;
            if (b > 0) {
                i4++;
            }
            byte[] bArr2 = new byte[i4];
            int i5 = 0;
            int i6 = 0;
            for (byte b2 : bArr) {
                for (int i7 = 7; i7 >= 0; i7--) {
                    bArr2[i5] = (byte) ((bArr2[i5] << 1) | ((b2 >> i7) & 1));
                    if (i6 % 3 == 2) {
                        byte[][] bArr3 = a;
                        bArr2[i5 + 1] = bArr3[bArr2[i5]][1];
                        bArr2[i5] = bArr3[bArr2[i5]][0];
                        i5 += 2;
                    }
                    i6++;
                    if (i6 == i) {
                        break;
                    }
                }
                if (i6 == i) {
                    break;
                }
            }
            if (b > 0) {
                bArr2[i5] = (byte) (bArr2[i5] << b);
                byte[][] bArr4 = a;
                bArr2[i5 + 1] = bArr4[bArr2[i5]][1];
                bArr2[i5] = bArr4[bArr2[i5]][0];
                bArr2[i5 + 2] = b;
            }
            return bArr2;
        }
        return (byte[]) invokeLI.objValue;
    }
}
