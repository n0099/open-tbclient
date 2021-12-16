package com.yy.hiidostatis.inner.util.cipher;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
/* loaded from: classes4.dex */
public final class Coder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHARSET = "UTF-8";
    public static final String KEY_DES = "DES";
    public static final String KEY_MD5 = "MD5";
    public static final String KEY_SHA = "SHA";
    public transient /* synthetic */ FieldHolder $fh;

    public Coder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static byte[] StringToBytes(String str) throws UnsupportedEncodingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? str.getBytes("UTF-8") : (byte[]) invokeL.objValue;
    }

    public static String bytesToHexString(byte[] bArr) throws UnsupportedEncodingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            if (bArr != null) {
                for (byte b2 : bArr) {
                    sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String bytesToString(byte[] bArr) throws UnsupportedEncodingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) ? new String(bArr, "UTF-8") : (String) invokeL.objValue;
    }

    public static String decryptBASE64(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? bytesToString(Base64Util.decode(str)) : (String) invokeL.objValue;
    }

    public static String decryptDES(String str, String str2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            if (str == null) {
                return null;
            }
            return bytesToString(decryptDES(Base64Util.decode(str), StringToBytes(str2)));
        }
        return (String) invokeLL.objValue;
    }

    public static String encryptBASE64(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? Base64Util.encode(StringToBytes(str)) : (String) invokeL.objValue;
    }

    public static String encryptDES(String str, String str2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) ? Base64Util.encode(encryptDES(StringToBytes(str), StringToBytes(str2))) : (String) invokeLL.objValue;
    }

    public static String encryptMD5(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? bytesToHexString(MessageDigest.getInstance("MD5").digest(StringToBytes(str))) : (String) invokeL.objValue;
    }

    public static String encryptSHA(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
            messageDigest.update(StringToBytes(str));
            return bytesToHexString(messageDigest.digest());
        }
        return (String) invokeL.objValue;
    }

    public static byte[] hexStringToBytes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            char[] charArray = str.toCharArray();
            int length = charArray.length / 2;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                int digit = Character.digit(charArray[i3 + 1], 16) | (Character.digit(charArray[i3], 16) << 4);
                if (digit > 127) {
                    digit -= 256;
                }
                bArr[i2] = (byte) digit;
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static String sha256Encrypt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            byte[] bytes = str.getBytes();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(bytes);
                return bytesToHexString(messageDigest.digest());
            } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static byte[] encryptDES(byte[] bArr, byte[] bArr2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, bArr, bArr2)) == null) {
            SecureRandom secureRandom = new SecureRandom();
            SecretKey generateSecret = SecretKeyFactory.getInstance(KEY_DES).generateSecret(new DESKeySpec(bArr2));
            Cipher cipher = Cipher.getInstance(KEY_DES);
            cipher.init(1, generateSecret, secureRandom);
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] decryptDES(byte[] bArr, byte[] bArr2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, bArr, bArr2)) == null) {
            SecureRandom secureRandom = new SecureRandom();
            SecretKey generateSecret = SecretKeyFactory.getInstance(KEY_DES).generateSecret(new DESKeySpec(bArr2));
            Cipher cipher = Cipher.getInstance(KEY_DES);
            cipher.init(2, generateSecret, secureRandom);
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }
}
