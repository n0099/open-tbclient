package kascend.core.utils;

import com.baidu.sapi2.utils.h;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes5.dex */
public class KSUtils {
    public static String decrypt(String str, String str2) {
        byte[] bArr = new byte[str2.length() / 2];
        char[] charArray = str2.toCharArray();
        int i = 0;
        int i2 = 0;
        while (i2 < charArray.length) {
            bArr[i] = (byte) Integer.parseInt(new String(charArray, i2, 2), 16);
            i2 += 2;
            i++;
        }
        byte[] bArr2 = new byte[0];
        try {
            return new String(a.decryptByPrivateKey(bArr, str), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] encrypt(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, h.q);
        Cipher cipher = Cipher.getInstance(h.q);
        cipher.init(1, secretKeySpec);
        return cipher.doFinal(bArr2);
    }

    private static byte[] decrypt(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, h.q);
        Cipher cipher = Cipher.getInstance(h.q);
        cipher.init(2, secretKeySpec);
        return cipher.doFinal(bArr2);
    }

    private static byte[] getRawKey(byte[] bArr) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(h.q);
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG", new CryptoProvider());
        secureRandom.setSeed(bArr);
        keyGenerator.init(128, secureRandom);
        return keyGenerator.generateKey().getEncoded();
    }

    private static String toHex(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            appendHex(stringBuffer, b);
        }
        return stringBuffer.toString();
    }

    private static byte[] toByte(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = Integer.valueOf(str.substring(i * 2, (i * 2) + 2), 16).byteValue();
        }
        return bArr;
    }

    private static void appendHex(StringBuffer stringBuffer, byte b) {
        stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15)).append("0123456789ABCDEF".charAt(b & 15));
    }

    public static String encrypt(String str) throws Exception {
        return toHex(encrypt(getRawKey("kascend".getBytes()), str.getBytes()));
    }

    public static String decrypt(String str) throws Exception {
        return new String(decrypt(getRawKey("kascend".getBytes()), toByte(str)));
    }
}
