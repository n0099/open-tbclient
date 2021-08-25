package com.sdk.base.framework.f.i;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.framework.c.f;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes10.dex */
public class a extends com.sdk.base.framework.f.a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f75412a = "com.sdk.base.framework.f.i.a";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f75413b;

    /* renamed from: c  reason: collision with root package name */
    public static String f75414c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1065952297, "Lcom/sdk/base/framework/f/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1065952297, "Lcom/sdk/base/framework/f/i/a;");
                return;
            }
        }
        f75413b = f.f75370b;
        f75414c = "a6Hy5Hb8IfX46D1f";
    }

    public a() {
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

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            Random random = new Random();
            String str = "";
            for (int i3 = 0; i3 < i2; i3++) {
                String str2 = random.nextInt(2) % 2 == 0 ? "char" : "num";
                if ("char".equalsIgnoreCase(str2)) {
                    int i4 = random.nextInt(2) % 2 == 0 ? 65 : 97;
                    str = str + ((char) (random.nextInt(26) + i4));
                } else if ("num".equalsIgnoreCase(str2)) {
                    str = str + String.valueOf(random.nextInt(10));
                }
            }
            return str;
        }
        return (String) invokeI.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            String b2 = com.sdk.base.framework.f.b.a.b(context, f.f75369a);
            if (com.sdk.base.framework.a.a.c.a(b2).booleanValue()) {
                String a2 = a(16);
                com.sdk.base.framework.f.b.a.b(context, f.f75369a, a2);
                return a2;
            }
            return b2;
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) ? b(str, str2, f75414c) : (String) invokeLL.objValue;
    }

    public static String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, str3)) == null) {
            if (str != null) {
                try {
                    if (str.length() != 0 && str.trim().length() != 0) {
                        if (str2 == null) {
                            com.sdk.base.framework.f.a.a(f75412a, "EncryptCbcIv", "encrypt key is null", f75413b);
                            return null;
                        } else if (str2.length() != 16) {
                            com.sdk.base.framework.f.a.a(f75412a, "EncryptCbcIv", "encrypt key length error", f75413b);
                            return null;
                        } else if (str3.length() != 16) {
                            com.sdk.base.framework.f.a.a(f75412a, "EncryptCbcIv", "ivStr length error", f75413b);
                            return null;
                        } else {
                            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                            cipher.init(1, new SecretKeySpec(str2.getBytes("utf-8"), "AES"), new IvParameterSpec(str3.getBytes("utf-8")));
                            return c.a(cipher.doFinal(str.getBytes("utf-8")));
                        }
                    }
                } catch (Exception e2) {
                    com.sdk.base.framework.f.a.a(f75412a, "EncryptCbcIv", e2.getMessage(), f75413b);
                    return null;
                }
            }
            com.sdk.base.framework.f.a.a(f75412a, "EncryptCbcIv", "encrypt content is null", f75413b);
            return null;
        }
        return (String) invokeLLL.objValue;
    }

    public static String b(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2, str3)) == null) {
            if (str != null) {
                try {
                    if (str.length() != 0 && str.trim().length() != 0) {
                        if (str2 != null) {
                            if (str2.length() == 16) {
                                if (str3.length() == 16) {
                                    byte[] a2 = c.a(str);
                                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                                    cipher.init(2, new SecretKeySpec(str2.getBytes("utf-8"), "AES"), new IvParameterSpec(str3.getBytes("utf-8")));
                                    return new String(cipher.doFinal(a2), "utf-8");
                                }
                                throw new Exception(" iv decrypt key length error");
                            }
                            throw new Exception("decrypt key length error");
                        }
                        throw new Exception("decrypt key is null");
                    }
                    return null;
                } catch (Exception e2) {
                    throw new Exception("decrypt errot", e2);
                }
            }
            return null;
        }
        return (String) invokeLLL.objValue;
    }
}
