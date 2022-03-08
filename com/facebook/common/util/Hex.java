package com.facebook.common.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class Hex {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] DIGITS;
    public static final char[] FIRST_CHAR;
    public static final char[] HEX_DIGITS;
    public static final char[] SECOND_CHAR;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(806840, "Lcom/facebook/common/util/Hex;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(806840, "Lcom/facebook/common/util/Hex;");
                return;
            }
        }
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        FIRST_CHAR = new char[256];
        SECOND_CHAR = new char[256];
        for (int i2 = 0; i2 < 256; i2++) {
            char[] cArr = FIRST_CHAR;
            char[] cArr2 = HEX_DIGITS;
            cArr[i2] = cArr2[(i2 >> 4) & 15];
            SECOND_CHAR[i2] = cArr2[i2 & 15];
        }
        DIGITS = new byte[103];
        for (int i3 = 0; i3 <= 70; i3++) {
            DIGITS[i3] = -1;
        }
        for (byte b2 = 0; b2 < 10; b2 = (byte) (b2 + 1)) {
            DIGITS[b2 + 48] = b2;
        }
        for (byte b3 = 0; b3 < 6; b3 = (byte) (b3 + 1)) {
            byte[] bArr = DIGITS;
            byte b4 = (byte) (b3 + 10);
            bArr[b3 + 65] = b4;
            bArr[b3 + 97] = b4;
        }
    }

    public Hex() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String byte2Hex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 <= 255 && i2 >= 0) {
                return String.valueOf(FIRST_CHAR[i2]) + String.valueOf(SECOND_CHAR[i2]);
            }
            throw new IllegalArgumentException("The int converting to hex should be in range 0~255");
        }
        return (String) invokeI.objValue;
    }

    public static byte[] decodeHex(String str) {
        InterceptResult invokeL;
        byte b2;
        byte b3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            int length = str.length();
            if ((length & 1) == 0) {
                byte[] bArr = new byte[length >> 1];
                boolean z = false;
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = i2 + 1;
                    char charAt = str.charAt(i2);
                    if (charAt <= 'f' && (b2 = DIGITS[charAt]) != -1) {
                        int i5 = i4 + 1;
                        char charAt2 = str.charAt(i4);
                        if (charAt2 <= 'f' && (b3 = DIGITS[charAt2]) != -1) {
                            bArr[i3] = (byte) ((b2 << 4) | b3);
                            i3++;
                            i2 = i5;
                        }
                    }
                    z = true;
                }
                if (z) {
                    throw new IllegalArgumentException("Invalid hexadecimal digit: " + str);
                }
                return bArr;
            }
            throw new IllegalArgumentException("Odd number of characters.");
        }
        return (byte[]) invokeL.objValue;
    }

    public static String encodeHex(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, z)) == null) {
            char[] cArr = new char[bArr.length * 2];
            int i3 = 0;
            for (int i4 = 0; i4 < bArr.length && ((i2 = bArr[i4] & 255) != 0 || !z); i4++) {
                int i5 = i3 + 1;
                cArr[i3] = FIRST_CHAR[i2];
                i3 = i5 + 1;
                cArr[i5] = SECOND_CHAR[i2];
            }
            return new String(cArr, 0, i3);
        }
        return (String) invokeLZ.objValue;
    }

    public static byte[] hexStringToByteArray(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? decodeHex(str.replaceAll(" ", "")) : (byte[]) invokeL.objValue;
    }
}
