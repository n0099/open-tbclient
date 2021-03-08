package com.cmic.sso.sdk.e;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes14.dex */
public class p {
    public static String a() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis()));
    }

    private static String a(Date date) {
        return a("yyyyMMdd", date);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b() {
        return a(new Date());
    }

    private static String a(String str, Date date) {
        if (date == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return new SimpleDateFormat(str).format(date);
    }
}
