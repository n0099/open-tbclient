package com.bytedance.sdk.openadsdk.k.g;

import android.text.TextUtils;
import com.baidu.searchbox.pms.db.PackageTable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final MessageDigest f29650a = a();

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f29651b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static MessageDigest a() {
        try {
            return MessageDigest.getInstance(PackageTable.MD5);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String a(String str) {
        byte[] digest;
        MessageDigest messageDigest = f29650a;
        if (messageDigest == null || TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] bytes = str.getBytes(d.f29657a);
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
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = f29651b;
            cArr[i2] = cArr2[(b2 & 240) >> 4];
            i2 = i3 + 1;
            cArr[i3] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }
}
