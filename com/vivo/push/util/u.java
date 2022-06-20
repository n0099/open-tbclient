package com.vivo.push.util;

import android.util.Base64;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
/* loaded from: classes8.dex */
public final class u {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "RSA";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(744178759, "Lcom/vivo/push/util/u;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(744178759, "Lcom/vivo/push/util/u;");
        }
    }

    public static String a(Key key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, key)) == null) ? Base64.encodeToString(key.getEncoded(), 2) : (String) invokeL.objValue;
    }

    public static PublicKey a(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                return KeyFactory.getInstance(a).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
            } catch (NullPointerException unused) {
                throw new Exception("公钥数据为空");
            } catch (NoSuchAlgorithmException unused2) {
                throw new Exception("无此算法");
            } catch (InvalidKeySpecException unused3) {
                throw new Exception("公钥非法");
            }
        }
        return (PublicKey) invokeL.objValue;
    }

    public static boolean a(byte[] bArr, PublicKey publicKey, byte[] bArr2) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, bArr, publicKey, bArr2)) == null) {
            Signature signature = Signature.getInstance("MD5withRSA");
            signature.initVerify(publicKey);
            signature.update(bArr);
            return signature.verify(bArr2);
        }
        return invokeLLL.booleanValue;
    }
}
