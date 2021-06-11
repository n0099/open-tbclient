package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes7.dex */
public class l {
    public static String a(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i2])));
        }
        return stringBuffer.toString();
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    public static void a(byte[] bArr, long j, int i2) {
        j.a(bArr, "Buffer must be not null!");
        boolean z = true;
        j.a(j >= 0, "Data offset must be positive!");
        j.a((i2 < 0 || i2 > bArr.length) ? false : false, "Length must be in range [0..buffer.length]");
    }

    public static String b(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Error encoding url", e2);
        }
    }

    public static String c(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Error decoding url", e2);
        }
    }

    public static String d(String str) {
        try {
            return a(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        }
    }
}
