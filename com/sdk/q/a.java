package com.sdk.q;

import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.sdk.f.g;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes7.dex */
public class a extends com.sdk.i.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "com.sdk.q.a";
    public static boolean isDebug;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1592839641, "Lcom/sdk/q/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1592839641, "Lcom/sdk/q/a;");
                return;
            }
        }
        isDebug = g.b;
    }

    public static String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            Random random = new Random();
            String str = "";
            for (int i2 = 0; i2 < i; i2++) {
                String str2 = random.nextInt(2) % 2 == 0 ? "char" : "num";
                if ("char".equalsIgnoreCase(str2)) {
                    int i3 = random.nextInt(2) % 2 == 0 ? 65 : 97;
                    str = str + ((char) (random.nextInt(26) + i3));
                } else if ("num".equalsIgnoreCase(str2)) {
                    str = str + String.valueOf(random.nextInt(10));
                }
            }
            return str;
        }
        return (String) invokeI.objValue;
    }

    public static String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            if (str != null) {
                try {
                    if (str.length() != 0 && str.trim().length() != 0) {
                        if (str2 != null) {
                            if (str2.length() == 16) {
                                if (str3.length() == 16) {
                                    byte[] a = c.a(str);
                                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                                    cipher.init(2, new SecretKeySpec(str2.getBytes(IMAudioTransRequest.CHARSET), "AES"), new IvParameterSpec(str3.getBytes(IMAudioTransRequest.CHARSET)));
                                    return new String(cipher.doFinal(a), IMAudioTransRequest.CHARSET);
                                }
                                throw new Exception(" iv decrypt key length error");
                            }
                            throw new Exception("decrypt key length error");
                        }
                        throw new Exception("decrypt key is null");
                    }
                    return null;
                } catch (Exception e) {
                    throw new Exception("decrypt errot", e);
                }
            }
            return null;
        }
        return (String) invokeLLL.objValue;
    }

    public static String b(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) {
            if (str != null) {
                try {
                    if (str.length() != 0 && str.trim().length() != 0) {
                        if (str2 == null) {
                            com.sdk.i.a.logError(TAG, "EncryptCbcIv", "encrypt key is null", isDebug);
                            return null;
                        } else if (str2.length() != 16) {
                            com.sdk.i.a.logError(TAG, "EncryptCbcIv", "encrypt key length error", isDebug);
                            return null;
                        } else if (str3.length() != 16) {
                            com.sdk.i.a.logError(TAG, "EncryptCbcIv", "ivStr length error", isDebug);
                            return null;
                        } else {
                            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                            cipher.init(1, new SecretKeySpec(str2.getBytes(IMAudioTransRequest.CHARSET), "AES"), new IvParameterSpec(str3.getBytes(IMAudioTransRequest.CHARSET)));
                            return c.a(cipher.doFinal(str.getBytes(IMAudioTransRequest.CHARSET)));
                        }
                    }
                } catch (Exception e) {
                    com.sdk.i.a.logError(TAG, "EncryptCbcIv", e.getMessage(), isDebug);
                    return null;
                }
            }
            com.sdk.i.a.logError(TAG, "EncryptCbcIv", "encrypt content is null", isDebug);
            return null;
        }
        return (String) invokeLLL.objValue;
    }
}
