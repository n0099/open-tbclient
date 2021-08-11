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
/* loaded from: classes10.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f76053a;
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
        f76053a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
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
            } catch (Exception e2) {
                SLog.e("DESUtils", "encryptAES", e2);
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
            } catch (Exception e2) {
                SLog.e("DESUtils", "encryptSha", e2);
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
            for (int i2 = 0; i2 < bArr.length; i2++) {
                byte b2 = bArr[i2];
                int i3 = i2 * 2;
                char[] cArr2 = f76053a;
                cArr[i3 + 1] = cArr2[b2 & 15];
                cArr[i3] = cArr2[((byte) (b2 >>> 4)) & 15];
            }
            return new String(cArr);
        }
        return (String) invokeL.objValue;
    }
}
