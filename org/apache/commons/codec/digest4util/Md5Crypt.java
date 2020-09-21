package org.apache.commons.codec.digest4util;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.base.Charsets;
/* loaded from: classes16.dex */
public class Md5Crypt {
    static final String APR1_PREFIX = "$apr1$";
    private static final int BLOCKSIZE = 16;
    static final String MD5_PREFIX = "$1$";
    private static final int ROUNDS = 1000;

    public static String apr1Crypt(byte[] bArr) {
        return apr1Crypt(bArr, APR1_PREFIX + B64.getRandomSalt(8));
    }

    public static String apr1Crypt(byte[] bArr, String str) {
        if (str != null && !str.startsWith(APR1_PREFIX)) {
            str = APR1_PREFIX + str;
        }
        return md5Crypt(bArr, str, APR1_PREFIX);
    }

    public static String apr1Crypt(String str) {
        return apr1Crypt(str.getBytes(Charsets.UTF_8));
    }

    public static String apr1Crypt(String str, String str2) {
        return apr1Crypt(str.getBytes(Charsets.UTF_8), str2);
    }

    public static String md5Crypt(byte[] bArr) {
        return md5Crypt(bArr, MD5_PREFIX + B64.getRandomSalt(8));
    }

    public static String md5Crypt(byte[] bArr, String str) {
        return md5Crypt(bArr, str, MD5_PREFIX);
    }

    public static String md5Crypt(byte[] bArr, String str, String str2) {
        String group;
        int length = bArr.length;
        if (str == null) {
            group = B64.getRandomSalt(8);
        } else {
            Matcher matcher = Pattern.compile("^" + str2.replace("$", "\\$") + "([\\.\\/a-zA-Z0-9]{1,8}).*").matcher(str);
            if (!matcher.find()) {
                throw new IllegalArgumentException("Invalid salt value: " + str);
            }
            group = matcher.group(1);
        }
        byte[] bytes = group.getBytes(Charsets.UTF_8);
        MessageDigest md5Digest = DigestUtils.getMd5Digest();
        md5Digest.update(bArr);
        md5Digest.update(str2.getBytes(Charsets.UTF_8));
        md5Digest.update(bytes);
        MessageDigest md5Digest2 = DigestUtils.getMd5Digest();
        md5Digest2.update(bArr);
        md5Digest2.update(bytes);
        md5Digest2.update(bArr);
        byte[] digest = md5Digest2.digest();
        int i = length;
        while (i > 0) {
            md5Digest.update(digest, 0, i > 16 ? 16 : i);
            i -= 16;
        }
        Arrays.fill(digest, (byte) 0);
        for (int i2 = length; i2 > 0; i2 >>= 1) {
            if ((i2 & 1) == 1) {
                md5Digest.update(digest[0]);
            } else {
                md5Digest.update(bArr[0]);
            }
        }
        StringBuilder sb = new StringBuilder(str2 + group + "$");
        byte[] digest2 = md5Digest.digest();
        MessageDigest messageDigest = md5Digest2;
        for (int i3 = 0; i3 < 1000; i3++) {
            messageDigest = DigestUtils.getMd5Digest();
            if ((i3 & 1) != 0) {
                messageDigest.update(bArr);
            } else {
                messageDigest.update(digest2, 0, 16);
            }
            if (i3 % 3 != 0) {
                messageDigest.update(bytes);
            }
            if (i3 % 7 != 0) {
                messageDigest.update(bArr);
            }
            if ((i3 & 1) != 0) {
                messageDigest.update(digest2, 0, 16);
            } else {
                messageDigest.update(bArr);
            }
            digest2 = messageDigest.digest();
        }
        B64.b64from24bit(digest2[0], digest2[6], digest2[12], 4, sb);
        B64.b64from24bit(digest2[1], digest2[7], digest2[13], 4, sb);
        B64.b64from24bit(digest2[2], digest2[8], digest2[14], 4, sb);
        B64.b64from24bit(digest2[3], digest2[9], digest2[15], 4, sb);
        B64.b64from24bit(digest2[4], digest2[10], digest2[5], 4, sb);
        B64.b64from24bit((byte) 0, (byte) 0, digest2[11], 2, sb);
        md5Digest.reset();
        messageDigest.reset();
        Arrays.fill(bArr, (byte) 0);
        Arrays.fill(bytes, (byte) 0);
        Arrays.fill(digest2, (byte) 0);
        return sb.toString();
    }
}
