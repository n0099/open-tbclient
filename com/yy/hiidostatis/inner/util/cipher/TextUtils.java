package com.yy.hiidostatis.inner.util.cipher;

import com.huawei.hms.common.internal.TransactionIdCreater;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes8.dex */
public class TextUtils {
    public static final char[] hexDigits = {TransactionIdCreater.FILL_BYTE, '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final ThreadLocal<MessageDigest> MD5_DIGEST = new ThreadLocal<MessageDigest>() { // from class: com.yy.hiidostatis.inner.util.cipher.TextUtils.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.ThreadLocal
        public MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    };

    public static String bytes2hex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = hexDigits;
            cArr[i] = cArr2[(b >>> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static byte[] decodeBase64(String str) throws IOException {
        return Base64Util.decode(str);
    }

    public static String encodeBase64(byte[] bArr) {
        return Base64Util.encode(bArr);
    }

    public static String format8length(int i) {
        StringBuffer stringBuffer = new StringBuffer(8);
        int length = 8 - (i + "").length();
        while (true) {
            int i2 = length - 1;
            if (length > 0) {
                stringBuffer.append(0);
                length = i2;
            } else {
                stringBuffer.append(i);
                return stringBuffer.toString();
            }
        }
    }

    public static byte[] hex2Bytes(String str) {
        return hex2Bytes(str, 0);
    }

    public static String length2DecimalChar(int i) {
        return format8length(i);
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

    public static int getDecimalCharLength(String str) {
        if (str.length() >= 8) {
            int i = 0;
            for (int i2 = 0; i2 < 8; i2++) {
                i = ((i * 10) + str.charAt(i2)) - 48;
            }
            return i;
        }
        throw new IllegalArgumentException("Wrong hex size : " + str.length() + ", at least 8 bytes");
    }

    public static byte[] hex2Bytes(String str, int i) {
        int i2;
        int i3;
        if (str.length() % 2 == 0) {
            if (str.length() > i) {
                byte[] bArr = new byte[(str.length() - i) / 2];
                int i4 = 0;
                while (i < str.length()) {
                    char charAt = str.charAt(i);
                    char charAt2 = str.charAt(i + 1);
                    if (charAt < 'a') {
                        i2 = charAt - '0';
                    } else {
                        i2 = (charAt + '\n') - 97;
                    }
                    if (charAt2 < 'a') {
                        i3 = charAt2 - '0';
                    } else {
                        i3 = (charAt2 + '\n') - 97;
                    }
                    bArr[i4] = (byte) ((i2 << 4) | i3);
                    i4++;
                    i += 2;
                }
                return bArr;
            }
            throw new IllegalArgumentException("Wrong hex size : " + str.length() + " , expect larger than " + i);
        }
        throw new IllegalArgumentException("Wrong hex size : " + str.length());
    }

    public static String wrapDecimalLength(String str, int i) {
        return String.format("%s%s", format8length(i), str);
    }
}
