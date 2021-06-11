package org.apache.commons.codec.digest4util;

import org.apache.commons.base.Charsets;
/* loaded from: classes8.dex */
public class Crypt {
    public static String crypt(byte[] bArr) {
        return crypt(bArr, (String) null);
    }

    public static String crypt(byte[] bArr, String str) {
        if (str == null) {
            return Sha2Crypt.sha512Crypt(bArr);
        }
        if (str.startsWith(Sha2Crypt.SHA512_PREFIX)) {
            return Sha2Crypt.sha512Crypt(bArr, str);
        }
        if (str.startsWith(Sha2Crypt.SHA256_PREFIX)) {
            return Sha2Crypt.sha256Crypt(bArr, str);
        }
        if (str.startsWith(Md5Crypt.MD5_PREFIX)) {
            return Md5Crypt.md5Crypt(bArr, str);
        }
        return UnixCrypt.crypt(bArr, str);
    }

    public static String crypt(String str) {
        return crypt(str, (String) null);
    }

    public static String crypt(String str, String str2) {
        return crypt(str.getBytes(Charsets.UTF_8), str2);
    }
}
