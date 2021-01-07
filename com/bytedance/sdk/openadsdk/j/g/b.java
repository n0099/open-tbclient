package com.bytedance.sdk.openadsdk.j.g;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final MessageDigest f7589a = a();

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f7590b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private b() {
    }

    private static MessageDigest a() {
        try {
            return MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String a(String str) {
        byte[] digest;
        MessageDigest messageDigest = f7589a;
        if (messageDigest == null) {
            return "";
        }
        byte[] bytes = str.getBytes(d.f7593a);
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
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b2 = bArr[i];
            int i3 = i2 + 1;
            cArr[i2] = f7590b[(b2 & 240) >> 4];
            cArr[i3] = f7590b[b2 & 15];
            i++;
            i2 = i3 + 1;
        }
        return new String(cArr);
    }
}
