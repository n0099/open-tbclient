package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
/* loaded from: classes6.dex */
public final class n30 {
    public static /* synthetic */ Interceptable $ic;
    public static final SecureRandom a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755520570, "Lcom/repackage/n30;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755520570, "Lcom/repackage/n30;");
                return;
            }
        }
        a = new SecureRandom();
    }

    public static int a(BigInteger bigInteger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bigInteger)) == null) ? (bigInteger.bitLength() + 7) >> 3 : invokeL.intValue;
    }

    public static BigInteger b(byte[] bArr, BigInteger bigInteger) throws BadPaddingException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, bigInteger)) == null) {
            BigInteger bigInteger2 = new BigInteger(1, bArr);
            if (bigInteger2.compareTo(bigInteger) < 0) {
                return bigInteger2;
            }
            throw new BadPaddingException("Message is larger than modulus");
        }
        return (BigInteger) invokeLL.objValue;
    }

    public static byte[] c(BigInteger bigInteger, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, bigInteger, i)) == null) {
            byte[] byteArray = bigInteger.toByteArray();
            int length = byteArray.length;
            if (length == i) {
                return byteArray;
            }
            if (length == i + 1 && byteArray[0] == 0) {
                byte[] bArr = new byte[i];
                System.arraycopy(byteArray, 1, bArr, 0, i);
                return bArr;
            } else if (length >= i) {
                return null;
            } else {
                byte[] bArr2 = new byte[i];
                System.arraycopy(byteArray, 0, bArr2, i - length, length);
                return bArr2;
            }
        }
        return (byte[]) invokeLI.objValue;
    }

    public static byte[] d(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i, i2)) == null) {
            if (i == 0 && i2 == bArr.length) {
                return bArr;
            }
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return bArr2;
        }
        return (byte[]) invokeLII.objValue;
    }

    public static byte[] e(byte[] bArr, v30 v30Var) throws BadPaddingException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bArr, v30Var)) == null) ? f(bArr, v30Var.b(), v30Var.a()) : (byte[]) invokeLL.objValue;
    }

    public static byte[] f(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) throws BadPaddingException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, bArr, bigInteger, bigInteger2)) == null) ? c(b(bArr, bigInteger).modPow(bigInteger2, bigInteger), a(bigInteger)) : (byte[]) invokeLLL.objValue;
    }
}
