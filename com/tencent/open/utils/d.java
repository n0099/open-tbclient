package com.tencent.open.utils;

import android.util.Base64;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f41991a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2036590986, "Lcom/tencent/open/utils/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2036590986, "Lcom/tencent/open/utils/d;");
                return;
            }
        }
        f41991a = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(f41991a);
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), Coder.KEY_DES);
                Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
            } catch (Exception e2) {
                com.tencent.open.a.f.c("DESUtils", "encode " + e2.toString());
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            try {
                byte[] decode = Base64.decode(str, 0);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(f41991a);
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), Coder.KEY_DES);
                Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
                cipher.init(2, secretKeySpec, ivParameterSpec);
                return new String(cipher.doFinal(decode));
            } catch (Exception e2) {
                com.tencent.open.a.f.c("DESUtils", "decode " + e2.toString());
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }
}
