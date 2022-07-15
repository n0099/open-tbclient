package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.kwad.sdk.utils.aj;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
/* loaded from: classes5.dex */
public final class k {
    public static String a(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    public static void a(byte[] bArr, long j, int i) {
        aj.a(bArr, "Buffer must be not null!");
        boolean z = true;
        aj.a(j >= 0, "Data offset must be positive!");
        aj.a((i < 0 || i > bArr.length) ? false : false, "Length must be in range [0..buffer.length]");
    }

    public static String b(String str) {
        try {
            return URLEncoder.encode(str, IMAudioTransRequest.CHARSET);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error encoding url", e);
        }
    }

    public static String c(String str) {
        try {
            return URLDecoder.decode(str, IMAudioTransRequest.CHARSET);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error decoding url", e);
        }
    }
}
