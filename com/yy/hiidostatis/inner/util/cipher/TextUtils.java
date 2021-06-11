package com.yy.hiidostatis.inner.util.cipher;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes7.dex */
public class TextUtils {
    public static final char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final ThreadLocal<MessageDigest> MD5_DIGEST = new ThreadLocal<MessageDigest>() { // from class: com.yy.hiidostatis.inner.util.cipher.TextUtils.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.ThreadLocal
        public MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
    };

    public static String bytes2hex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = hexDigits;
            cArr[i2] = cArr2[(b2 >>> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public static byte[] decodeBase64(String str) throws IOException {
        return Base64Util.decode(str);
    }

    public static String encodeBase64(byte[] bArr) {
        return Base64Util.encode(bArr);
    }

    public static String format8length(int i2) {
        StringBuffer stringBuffer = new StringBuffer(8);
        int length = 8 - (i2 + "").length();
        while (true) {
            int i3 = length - 1;
            if (length > 0) {
                stringBuffer.append(0);
                length = i3;
            } else {
                stringBuffer.append(i2);
                return stringBuffer.toString();
            }
        }
    }

    public static int getDecimalCharLength(String str) {
        if (str.length() < 8) {
            throw new IllegalArgumentException("Wrong hex size : " + str.length() + ", at least 8 bytes");
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            i2 = ((i2 * 10) + str.charAt(i3)) - 48;
        }
        return i2;
    }

    public static byte[] hex2Bytes(String str) {
        return hex2Bytes(str, 0);
    }

    public static String length2DecimalChar(int i2) {
        return format8length(i2);
    }

    public static byte[] md5byte(byte[] bArr) {
        MessageDigest messageDigest = MD5_DIGEST.get();
        messageDigest.reset();
        messageDigest.update(bArr);
        return messageDigest.digest();
    }

    public static String removeLN(String str) {
        return str.replace("\n", "");
    }

    public static String wrapDecimalLength(String str, int i2) {
        return String.format("%s%s", format8length(i2), str);
    }

    public static byte[] hex2Bytes(String str, int i2) {
        if (str.length() % 2 == 0) {
            if (str.length() > i2) {
                byte[] bArr = new byte[(str.length() - i2) / 2];
                int i3 = 0;
                while (i2 < str.length()) {
                    char charAt = str.charAt(i2);
                    char charAt2 = str.charAt(i2 + 1);
                    bArr[i3] = (byte) (((charAt < 'a' ? charAt - '0' : (charAt + '\n') - 97) << 4) | (charAt2 < 'a' ? charAt2 - '0' : (charAt2 + '\n') - 97));
                    i3++;
                    i2 += 2;
                }
                return bArr;
            }
            throw new IllegalArgumentException("Wrong hex size : " + str.length() + " , expect larger than " + i2);
        }
        throw new IllegalArgumentException("Wrong hex size : " + str.length());
    }
}
