package com.sdk.base.framework.f.j;

import com.sdk.base.framework.c.f;
import java.nio.charset.Charset;
import java.security.MessageDigest;
/* loaded from: classes4.dex */
public class e extends com.sdk.base.framework.f.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12862a = e.class.getName();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f12863b = f.f12821b;

    static {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static String a(String str) {
        if (com.sdk.base.framework.a.a.c.a(str).booleanValue()) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(Charset.defaultCharset()));
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (Exception e) {
            a(f12862a, "encrypt", e.getMessage(), f12863b);
            return null;
        }
    }
}
