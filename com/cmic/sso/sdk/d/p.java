package com.cmic.sso.sdk.d;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes6.dex */
public class p {
    public static String a() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis()));
    }

    public static String b() {
        return a(new Date());
    }

    public static String a(Date date) {
        return a("yyyyMMdd", date);
    }

    public static String a(String str, Date date) {
        if (date == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return new SimpleDateFormat(str).format(date);
    }
}
