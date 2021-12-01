package com.sdk.base.framework.f.h;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.f;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
/* loaded from: classes2.dex */
public class b extends com.sdk.base.framework.f.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "RSA/ECB/PKCS1Padding";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1065922537, "Lcom/sdk/base/framework/f/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1065922537, "Lcom/sdk/base/framework/f/h/b;");
                return;
            }
        }
        boolean z = f.f60988b;
    }

    public b() {
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

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) a.a(str2);
            if (c.a(str).booleanValue()) {
                throw new Exception("rsaAes key is null");
            }
            return new String(a(rSAPublicKey, com.sdk.base.framework.f.i.c.a(str)), Charset.defaultCharset()).trim();
        }
        return (String) invokeLL.objValue;
    }

    public static byte[] a(RSAPublicKey rSAPublicKey, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, rSAPublicKey, bArr)) == null) {
            if (rSAPublicKey != null) {
                try {
                    Cipher cipher = Cipher.getInstance(a);
                    cipher.init(2, rSAPublicKey);
                    return cipher.doFinal(bArr);
                } catch (InvalidKeyException unused) {
                    throw new InvalidKeyException("解密公钥非法,请检查");
                } catch (NoSuchAlgorithmException unused2) {
                    throw new NoSuchAlgorithmException("无此解密算法");
                } catch (BadPaddingException unused3) {
                    throw new BadPaddingException("密文数据已损坏");
                } catch (IllegalBlockSizeException unused4) {
                    throw new IllegalBlockSizeException("密文长度非法");
                } catch (NoSuchPaddingException unused5) {
                    throw new NoSuchPaddingException("解密出错！不支持该填充机制");
                }
            }
            throw new Exception("解密公钥为空, 请设置");
        }
        return (byte[]) invokeLL.objValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            PublicKey a2 = a.a(str);
            Cipher cipher = Cipher.getInstance(a);
            cipher.init(1, a2);
            return com.sdk.base.framework.f.i.c.a(cipher.doFinal(str2.getBytes(Charset.defaultCharset()))).toString();
        }
        return (String) invokeLL.objValue;
    }
}
