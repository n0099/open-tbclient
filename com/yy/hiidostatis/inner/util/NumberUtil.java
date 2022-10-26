package com.yy.hiidostatis.inner.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class NumberUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] getBytes(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Character.valueOf(c)})) == null) ? new byte[]{(byte) c, (byte) (c >> '\b')} : (byte[]) invokeCommon.objValue;
    }

    public static byte[] getBytes(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) ? new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((i & (-16777216)) >> 24)} : (byte[]) invokeI.objValue;
    }

    public static byte[] getBytes(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65541, null, j)) == null) ? new byte[]{(byte) (j & 255), (byte) ((j >> 8) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 56) & 255)} : (byte[]) invokeJ.objValue;
    }

    public NumberUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static byte[] getBytes(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Double.valueOf(d)})) == null) {
            return getBytes(Double.doubleToLongBits(d));
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static double getDouble(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bArr)) == null) {
            return getDouble(bArr, 0);
        }
        return invokeL.doubleValue;
    }

    public static float getFloat(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, bArr)) == null) {
            return getFloat(bArr, 0);
        }
        return invokeL.floatValue;
    }

    public static String toHex(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, bArr)) == null) {
            return toHex(bArr, 0, bArr.length);
        }
        return (String) invokeL.objValue;
    }

    public static byte[] getBytes(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65539, null, f)) == null) {
            return getBytes(Float.floatToIntBits(f));
        }
        return (byte[]) invokeF.objValue;
    }

    public static char getChar(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, bArr, i)) == null) {
            return (char) (((bArr[i + 1] << 8) & 65280) | (bArr[i + 0] & 255));
        }
        return invokeLI.charValue;
    }

    public static double getDouble(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, bArr, i)) == null) {
            long j = getLong(bArr, i);
            System.out.println(j);
            return Double.longBitsToDouble(j);
        }
        return invokeLI.doubleValue;
    }

    public static float getFloat(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, bArr, i)) == null) {
            return Float.intBitsToFloat(getInt(bArr, i));
        }
        return invokeLI.floatValue;
    }

    public static short getShort(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, bArr, i)) == null) {
            return (short) (((bArr[i + 1] << 8) & 65280) | (bArr[i + 0] & 255));
        }
        return invokeLI.shortValue;
    }

    public static int getInt(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bArr)) == null) {
            return ((bArr[3] << 24) & (-16777216)) | (bArr[0] & 255) | ((bArr[1] << 8) & 65280) | ((bArr[2] << 16) & 16711680);
        }
        return invokeL.intValue;
    }

    public static byte[] toBytes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            if (str.isEmpty()) {
                return new byte[0];
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static int getInt(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, bArr, i)) == null) {
            return ((bArr[i + 3] << 24) & (-16777216)) | (bArr[i + 0] & 255) | ((bArr[i + 1] << 8) & 65280) | ((bArr[i + 2] << 16) & 16711680);
        }
        return invokeLI.intValue;
    }

    public static long getLong(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, bArr)) == null) {
            return (bArr[0] & 255) | ((bArr[1] << 8) & 65280) | ((bArr[2] << 16) & 16711680) | ((bArr[3] << 24) & 4278190080L) | ((bArr[4] << 32) & 1095216660480L) | ((bArr[5] << 40) & 280375465082880L) | ((bArr[6] << 48) & 71776119061217280L) | ((bArr[7] << 56) & (-72057594037927936L));
        }
        return invokeL.longValue;
    }

    public static long getLong(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, bArr, i)) == null) {
            return ((bArr[i + 7] << 56) & (-72057594037927936L)) | (bArr[i + 0] & 255) | ((bArr[i + 1] << 8) & 65280) | ((bArr[i + 2] << 16) & 16711680) | ((bArr[i + 3] << 24) & 4278190080L) | ((bArr[i + 4] << 32) & 1095216660480L) | ((bArr[i + 5] << 40) & 280375465082880L) | ((bArr[i + 6] << 48) & 71776119061217280L);
        }
        return invokeLI.longValue;
    }

    public static String toHex(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65554, null, bArr, i, i2)) == null) {
            StringBuilder sb = new StringBuilder(i2 * 2);
            for (int i3 = 0; i3 < i2; i3++) {
                String hexString = Integer.toHexString(bArr[i + i3] & 255);
                if (hexString.length() < 2) {
                    sb.append(0);
                }
                sb.append(hexString);
            }
            return sb.toString().toUpperCase();
        }
        return (String) invokeLII.objValue;
    }
}
