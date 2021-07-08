package com.ta.utdid2.a.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                bArr = a(a(), str.getBytes());
            } catch (Exception unused) {
                bArr = null;
            }
            if (bArr != null) {
                return a(bArr);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            try {
                return new String(b(a(), m57a(str)));
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static byte[] a() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? e.a(new byte[]{PublicSuffixDatabase.EXCEPTION_MARKER, 83, -50, -89, -84, -114, 80, 99, 10, 63, 22, -65, -11, 30, Constants.SHORT_PING_CMD_TYPE, -118}) : (byte[]) invokeV.objValue;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bArr, bArr2)) == null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
            return cipher.doFinal(bArr2);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, bArr, bArr2)) == null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
            return cipher.doFinal(bArr2);
        }
        return (byte[]) invokeLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m57a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = Integer.valueOf(str.substring(i3, i3 + 2), 16).byteValue();
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            if (bArr == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
            for (byte b2 : bArr) {
                a(stringBuffer, b2);
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void a(StringBuffer stringBuffer, byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{stringBuffer, Byte.valueOf(b2)}) == null) {
            stringBuffer.append("0123456789ABCDEF".charAt((b2 >> 4) & 15));
            stringBuffer.append("0123456789ABCDEF".charAt(b2 & 15));
        }
    }
}
