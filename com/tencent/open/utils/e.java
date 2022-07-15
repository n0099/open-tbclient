package com.tencent.open.utils;

import android.util.Base64;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.open.log.SLog;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2036590955, "Lcom/tencent/open/utils/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2036590955, "Lcom/tencent/open/utils/e;");
                return;
            }
        }
        a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static String a(String str, String str2, byte[] bArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, bArr)) == null) {
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
            } catch (Exception e) {
                SLog.e("DESUtils", "encryptAES", e);
                return null;
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(str.getBytes());
                return messageDigest.digest();
            } catch (Exception e) {
                SLog.e("DESUtils", "encryptSha", e);
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                return "";
            }
            char[] cArr = new char[bArr.length * 2];
            for (int i = 0; i < bArr.length; i++) {
                byte b = bArr[i];
                int i2 = i * 2;
                char[] cArr2 = a;
                cArr[i2 + 1] = cArr2[b & 15];
                cArr[i2] = cArr2[((byte) (b >>> 4)) & 15];
            }
            return new String(cArr);
        }
        return (String) invokeL.objValue;
    }
}
