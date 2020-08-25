package com.cmic.sso.sdk.e;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public class d {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return a(str.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return s.a(messageDigest.digest());
        } catch (Exception e) {
            return "";
        }
    }
}
