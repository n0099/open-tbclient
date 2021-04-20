package com.bytedance.sdk.openadsdk.video.d;

import android.text.TextUtils;
import com.baidu.searchbox.pms.db.PackageTable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final MessageDigest f30175a = a();

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f30176b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static MessageDigest a() {
        try {
            return MessageDigest.getInstance(PackageTable.MD5);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String a(String str) {
        byte[] digest;
        MessageDigest messageDigest = f30175a;
        if (messageDigest == null || TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        synchronized (b.class) {
            digest = messageDigest.digest(bytes);
        }
        return a(digest);
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length << 1];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f30176b;
            cArr[i] = cArr2[(b2 & 240) >> 4];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }
}
