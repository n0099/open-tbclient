package com.facebook.common.util;

import android.util.Base64;
import com.baidu.searchbox.ng.ai.apps.util.AiAppEncryptUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes2.dex */
public class b {
    static final byte[] hXK = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    public static String U(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(AiAppEncryptUtils.ENCRYPT_SHA1);
            messageDigest.update(bArr, 0, bArr.length);
            return Base64.encodeToString(messageDigest.digest(), 11);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
