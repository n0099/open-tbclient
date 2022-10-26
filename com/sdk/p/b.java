package com.sdk.p;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.f.g;
import com.sdk.q.c;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
/* loaded from: classes8.dex */
public class b extends com.sdk.i.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "RSA/ECB/PKCS1Padding";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1592869401, "Lcom/sdk/p/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1592869401, "Lcom/sdk/p/b;");
                return;
            }
        }
        boolean z = g.b;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            PublicKey a2 = a.a(str);
            Cipher cipher = Cipher.getInstance(a);
            cipher.init(1, a2);
            return c.a(cipher.doFinal(str2.getBytes(Charset.defaultCharset()))).toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) a.a(str2);
            if (!com.sdk.n.a.a(str).booleanValue()) {
                byte[] a2 = c.a(str);
                if (rSAPublicKey != null) {
                    try {
                        Cipher cipher = Cipher.getInstance(a);
                        cipher.init(2, rSAPublicKey);
                        return new String(cipher.doFinal(a2), Charset.defaultCharset()).trim();
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
            throw new Exception("rsaAes key is null");
        }
        return (String) invokeLL.objValue;
    }
}
