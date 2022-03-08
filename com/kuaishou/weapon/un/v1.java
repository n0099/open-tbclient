package com.kuaishou.weapon.un;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class v1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public v1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static byte a(byte b2, byte b3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3)})) == null) {
            return (byte) (((char) (((char) Byte.decode("0x" + new String(new byte[]{b2})).byteValue()) << 4)) ^ ((char) Byte.decode("0x" + new String(new byte[]{b3})).byteValue()));
        }
        return invokeCommon.byteValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (str == null || str2 == null) {
                return null;
            }
            return new String(a(a(str), str2));
        }
        return (String) invokeLL.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            StringBuffer stringBuffer = new StringBuffer(bArr.length);
            for (byte b2 : bArr) {
                stringBuffer.append((char) b2);
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            byte[] bytes = str.getBytes();
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = a(bytes[i3], bytes[i3 + 1]);
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] a(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bArr, str)) == null) {
            byte[] b2 = b(str);
            byte[] bArr2 = new byte[bArr.length];
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < bArr.length; i4++) {
                i2 = (i2 + 1) & 255;
                i3 = ((b2[i2] & 255) + i3) & 255;
                byte b3 = b2[i2];
                b2[i2] = b2[i3];
                b2[i3] = b3;
                bArr2[i4] = (byte) (b2[((b2[i2] & 255) + (b2[i3] & 255)) & 255] ^ bArr[i4]);
            }
            return bArr2;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static String b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) ? c(a(bArr)) : (String) invokeL.objValue;
    }

    public static byte[] b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            byte[] bytes = str.getBytes();
            byte[] bArr = new byte[256];
            for (int i2 = 0; i2 < 256; i2++) {
                bArr[i2] = (byte) i2;
            }
            if (bytes == null || bytes.length == 0) {
                return null;
            }
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < 256; i5++) {
                i4 = ((bytes[i3] & 255) + (bArr[i5] & 255) + i4) & 255;
                byte b2 = bArr[i5];
                bArr[i5] = bArr[i4];
                bArr[i4] = b2;
                i3 = (i3 + 1) % bytes.length;
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
            if (str == null || str2 == null) {
                return null;
            }
            return a(str.getBytes(), str2);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] b(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, bArr, str)) == null) {
            if (bArr == null || str == null) {
                return null;
            }
            return a(bArr, str);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            String str2 = "";
            for (int i2 = 0; i2 < str.length(); i2++) {
                String hexString = Integer.toHexString(str.charAt(i2) & 255);
                if (hexString.length() == 1) {
                    hexString = '0' + hexString;
                }
                str2 = str2 + hexString;
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, str2)) == null) {
            if (str == null || str2 == null) {
                return null;
            }
            return c(a(b(str, str2)));
        }
        return (String) invokeLL.objValue;
    }

    public static byte[] c(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, bArr, str)) == null) {
            if (bArr == null || str == null) {
                return null;
            }
            return a(bArr, str);
        }
        return (byte[]) invokeLL.objValue;
    }
}
