package com.kwad.sdk.core.diskcache.b;

import android.text.TextUtils;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.io.Closeable;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes5.dex */
class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            return String.valueOf(str.hashCode());
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
        if ((obj instanceof String) && TextUtils.isEmpty((String) obj)) {
            throw new NullPointerException(str);
        }
    }
}
