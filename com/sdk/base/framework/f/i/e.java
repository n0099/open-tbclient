package com.sdk.base.framework.f.i;

import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.sdk.base.framework.c.f;
import java.nio.charset.Charset;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public class e extends com.sdk.base.framework.f.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f38952a = "com.sdk.base.framework.f.i.e";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f38953b = f.f38904b;

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
        } catch (Exception e2) {
            com.sdk.base.framework.f.a.a(f38952a, LightappBusinessClient.MTD_ENCRYPT, e2.getMessage(), f38953b);
            return null;
        }
    }
}
