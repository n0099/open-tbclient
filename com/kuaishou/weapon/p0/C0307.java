package com.kuaishou.weapon.p0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* renamed from: com.kuaishou.weapon.p0.ʻـ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0307 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public C0307() {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public static byte m181(byte b, byte b2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Byte.valueOf(b), Byte.valueOf(b2)})) == null) {
            return (byte) (((char) (((char) Byte.decode("0x" + new String(new byte[]{b})).byteValue()) << 4)) ^ ((char) Byte.decode("0x" + new String(new byte[]{b2})).byteValue()));
        }
        return invokeCommon.byteValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m182(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (str == null || str2 == null) {
                return null;
            }
            return new String(m185(m184(str), str2));
        }
        return (String) invokeLL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m183(byte[] bArr) {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public static byte[] m184(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            byte[] bytes = str.getBytes();
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = m181(bytes[i2], bytes[i2 + 1]);
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static byte[] m185(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bArr, str)) == null) {
            byte[] m187 = m187(str);
            byte[] bArr2 = new byte[bArr.length];
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < bArr.length; i3++) {
                try {
                    i = (i + 1) & 255;
                    i2 = ((m187[i] & 255) + i2) & 255;
                    byte b = m187[i];
                    m187[i] = m187[i2];
                    m187[i2] = b;
                    bArr2[i3] = (byte) (m187[((m187[i] & 255) + (m187[i2] & 255)) & 255] ^ bArr[i3]);
                } catch (Exception unused) {
                }
            }
            return bArr2;
        }
        return (byte[]) invokeLL.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static String m186(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) ? m190(m183(bArr)) : (String) invokeL.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static byte[] m187(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            byte[] bytes = str.getBytes();
            byte[] bArr = new byte[256];
            for (int i = 0; i < 256; i++) {
                bArr[i] = (byte) i;
            }
            if (bytes == null || bytes.length == 0) {
                return null;
            }
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
        return (byte[]) invokeL.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static byte[] m188(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
            if (str == null || str2 == null) {
                return null;
            }
            return m185(str.getBytes(), str2);
        }
        return (byte[]) invokeLL.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static byte[] m189(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, bArr, str)) == null) {
            if (bArr == null || str == null) {
                return null;
            }
            return m185(bArr, str);
        }
        return (byte[]) invokeLL.objValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static String m190(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
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

    /* renamed from: ʽ  reason: contains not printable characters */
    public static byte[] m191(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, bArr, str)) == null) {
            if (bArr == null || str == null) {
                return null;
            }
            return m185(bArr, str);
        }
        return (byte[]) invokeLL.objValue;
    }
}
