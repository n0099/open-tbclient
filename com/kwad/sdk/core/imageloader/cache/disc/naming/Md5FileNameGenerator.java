package com.kwad.sdk.core.imageloader.cache.disc.naming;

import com.kwad.sdk.core.imageloader.utils.L;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes4.dex */
public class Md5FileNameGenerator implements FileNameGenerator {
    public static final String HASH_ALGORITHM = "MD5";
    public static final int RADIX = 36;

    private byte[] getMD5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e2) {
            L.e(e2);
            return null;
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator
    public String generate(String str) {
        return new BigInteger(getMD5(str.getBytes())).abs().toString(36);
    }
}
