package d.b.c.e.p;

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
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f42532a;

    static {
        Charset.forName("UTF-8");
        f42532a = new byte[]{-92, 11, -56, 52, -42, -107, -13, 19};
    }

    public static byte[] a(SecretKey secretKey, byte[] bArr, int i, int i2) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(2, secretKey);
        return cipher.doFinal(bArr, i, i2);
    }

    public static byte[] b(Key key, byte[] bArr) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, key);
        return cipher.doFinal(bArr);
    }

    public static byte[] c(SecretKey secretKey, byte[] bArr) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(1, secretKey);
        return cipher.doFinal(bArr);
    }

    public static byte[] d(PublicKey publicKey, byte[] bArr) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, publicKey);
        return cipher.doFinal(bArr);
    }

    public static PublicKey e(byte[] bArr) throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
    }

    public static SecretKey f(String str) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        int length = str.length();
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = (char) (((byte) str.charAt(i)) & 255);
        }
        return secretKeyFactory.generateSecret(new PBEKeySpec(cArr, f42532a, 5, 256));
    }

    public static String g(int i) {
        String bigInteger = new BigInteger(i * 5, new SecureRandom()).toString(36);
        return bigInteger.length() > i ? bigInteger.substring(0, bigInteger.length()) : bigInteger;
    }
}
