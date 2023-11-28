package com.kuaishou.weapon.p0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public i() {
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

    public static byte a(byte b, byte b2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Byte.valueOf(b), Byte.valueOf(b2)})) == null) {
            return (byte) (((char) (((char) Byte.decode("0x" + new String(new byte[]{b})).byteValue()) << 4)) ^ ((char) Byte.decode("0x" + new String(new byte[]{b2})).byteValue()));
        }
        return invokeCommon.byteValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (str != null && str2 != null) {
                return new String(c(c(str), str2));
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static byte[] b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
            if (str != null && str2 != null) {
                return c(str.getBytes(), str2);
            }
            return null;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            StringBuffer stringBuffer = new StringBuffer(bArr.length);
            for (byte b : bArr) {
                stringBuffer.append((char) b);
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            byte[] bytes = str.getBytes();
            byte[] bArr = new byte[256];
            for (int i = 0; i < 256; i++) {
                bArr[i] = (byte) i;
            }
            if (bytes != null && bytes.length != 0) {
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < 256; i4++) {
                    i3 = ((bytes[i2] & 255) + (bArr[i4] & 255) + i3) & 255;
                    byte b = bArr[i4];
                    bArr[i4] = bArr[i3];
                    bArr[i3] = b;
                    i2 = (i2 + 1) % bytes.length;
                }
                return bArr;
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            String str2 = "";
            for (int i = 0; i < str.length(); i++) {
                String hexString = Integer.toHexString(str.charAt(i) & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                str2 = str2 + hexString;
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static byte[] a(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bArr, str)) == null) {
            if (bArr != null && str != null) {
                return c(bArr, str);
            }
            return null;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] b(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, bArr, str)) == null) {
            if (bArr != null && str != null) {
                return c(bArr, str);
            }
            return null;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            byte[] bytes = str.getBytes();
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = a(bytes[i2], bytes[i2 + 1]);
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] c(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, bArr, str)) == null) {
            byte[] a = a(str);
            byte[] bArr2 = new byte[bArr.length];
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < bArr.length; i3++) {
                i = (i + 1) & 255;
                i2 = ((a[i] & 255) + i2) & 255;
                byte b = a[i];
                a[i] = a[i2];
                a[i2] = b;
                bArr2[i3] = (byte) (a[((a[i] & 255) + (a[i2] & 255)) & 255] ^ bArr[i3]);
            }
            return bArr2;
        }
        return (byte[]) invokeLL.objValue;
    }
}
