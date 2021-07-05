package d.a.c.e.p;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.hiidostatis.inner.util.cipher.RsaCipher;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
/* loaded from: classes8.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f44458a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2144845438, "Ld/a/c/e/p/s;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2144845438, "Ld/a/c/e/p/s;");
                return;
            }
        }
        Charset.forName("UTF-8");
        f44458a = new byte[]{-92, 11, -56, 52, -42, -107, -13, 19};
    }

    public static byte[] a(SecretKey secretKey, byte[] bArr, int i2, int i3) throws GeneralSecurityException {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65537, null, secretKey, bArr, i2, i3)) == null) {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, secretKey);
            return cipher.doFinal(bArr, i2, i3);
        }
        return (byte[]) invokeLLII.objValue;
    }

    public static byte[] b(Key key, byte[] bArr) throws GeneralSecurityException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, key, bArr)) == null) {
            Cipher cipher = Cipher.getInstance(RsaCipher.RSA_PADDING);
            cipher.init(2, key);
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] c(SecretKey secretKey, byte[] bArr) throws GeneralSecurityException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, secretKey, bArr)) == null) {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(1, secretKey);
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] d(PublicKey publicKey, byte[] bArr) throws GeneralSecurityException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, publicKey, bArr)) == null) {
            Cipher cipher = Cipher.getInstance(RsaCipher.RSA_PADDING);
            cipher.init(1, publicKey);
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static PublicKey e(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bArr)) == null) ? KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr)) : (PublicKey) invokeL.objValue;
    }

    public static SecretKey f(String str) throws NoSuchAlgorithmException, InvalidKeySpecException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            int length = str.length();
            char[] cArr = new char[length];
            for (int i2 = 0; i2 < length; i2++) {
                cArr[i2] = (char) (((byte) str.charAt(i2)) & 255);
            }
            return secretKeyFactory.generateSecret(new PBEKeySpec(cArr, f44458a, 5, 256));
        }
        return (SecretKey) invokeL.objValue;
    }

    public static String g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) {
            String bigInteger = new BigInteger(i2 * 5, new SecureRandom()).toString(36);
            return bigInteger.length() > i2 ? bigInteger.substring(0, bigInteger.length()) : bigInteger;
        }
        return (String) invokeI.objValue;
    }
}
