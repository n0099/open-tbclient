package com.facebook.common.util;

import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes12.dex */
public class b {
    static final byte[] mRy = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102};

    public static String al(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(bArr, 0, bArr.length);
            return Base64.encodeToString(messageDigest.digest(), 11);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
