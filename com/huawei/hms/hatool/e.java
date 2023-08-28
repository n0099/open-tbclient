package com.huawei.hms.hatool;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.nwb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
/* loaded from: classes10.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(366338661, "Lcom/huawei/hms/hatool/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(366338661, "Lcom/huawei/hms/hatool/e;");
                return;
            }
        }
        Charset.forName("UTF-8");
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            try {
                return a(str, str2.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException unused) {
                y.c("hmsSdk", "Unsupported encoding exception,utf-8");
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String a(String str, byte[] bArr) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                y.f("hmsSdk", "encrypt: content is empty or null");
                return "";
            }
            try {
                return nwb.a(a(bArr, a(nwb.b(str))));
            } catch (NoSuchAlgorithmException unused) {
                str2 = "encrypt(): getInstance - No such algorithm,transformation";
                y.f("hmsSdk", str2);
                return "";
            } catch (InvalidKeySpecException unused2) {
                str2 = "encrypt(): Invalid key specification";
                y.f("hmsSdk", str2);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static PublicKey a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) ? KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr)) : (PublicKey) invokeL.objValue;
    }

    public static byte[] a(byte[] bArr, PublicKey publicKey) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, publicKey)) == null) {
            try {
                if (publicKey != null) {
                    Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
                    cipher.init(1, publicKey);
                    return cipher.doFinal(bArr);
                }
                throw new UnsupportedEncodingException("The loaded public key is null");
            } catch (UnsupportedEncodingException unused) {
                str = "rsaEncrypt(): getBytes - Unsupported coding format!";
                y.f("hmsSdk", str);
                return new byte[0];
            } catch (InvalidKeyException unused2) {
                str = "rsaEncrypt(): init - Invalid key!";
                y.f("hmsSdk", str);
                return new byte[0];
            } catch (NoSuchAlgorithmException unused3) {
                str = "rsaEncrypt(): getInstance - No such algorithm,transformation";
                y.f("hmsSdk", str);
                return new byte[0];
            } catch (BadPaddingException unused4) {
                str = "rsaEncrypt():False filling parameters!";
                y.f("hmsSdk", str);
                return new byte[0];
            } catch (IllegalBlockSizeException unused5) {
                str = "rsaEncrypt(): doFinal - The provided block is not filled with";
                y.f("hmsSdk", str);
                return new byte[0];
            } catch (NoSuchPaddingException unused6) {
                str = "rsaEncrypt():  No such filling parameters ";
                y.f("hmsSdk", str);
                return new byte[0];
            }
        }
        return (byte[]) invokeLL.objValue;
    }
}
