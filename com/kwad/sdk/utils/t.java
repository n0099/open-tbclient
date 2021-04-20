package com.kwad.sdk.utils;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f37082a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    @NonNull
    public static String a(String str) {
        return a(str.getBytes());
    }

    public static String a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            int length = digest.length;
            for (int i = 0; i < length; i++) {
                int i2 = digest[i];
                if (i2 < 0) {
                    i2 += 256;
                }
                if (i2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if (i < 0 || i + i2 > bArr.length) {
                throw new IndexOutOfBoundsException();
            }
            int i3 = i2 * 2;
            char[] cArr = new char[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = bArr[i5 + i] & 255;
                int i7 = i4 + 1;
                char[] cArr2 = f37082a;
                cArr[i4] = cArr2[i6 >> 4];
                i4 = i7 + 1;
                cArr[i7] = cArr2[i6 & 15];
            }
            return new String(cArr, 0, i3);
        }
        throw new NullPointerException("bytes is null");
    }

    public static String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            return a(digest, 0, digest.length);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            return "";
        }
    }
}
