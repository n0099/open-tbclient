package com.xiaomi.metoknlp.a;

import com.xiaomi.mipush.sdk.Constants;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes3.dex */
public final class e {
    private static String a;
    private static String b = null;
    private static String c = null;

    public static String a() {
        if (a != null) {
            return a;
        }
        String b2 = b(d.b());
        if (b2 != null) {
            a = b2;
            return a;
        }
        return b(c.a("ro.ril.miui.imei", ""));
    }

    public static String a(String str) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i = 0;
            for (byte b2 : digest) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b2 >>> 4) & 15];
                i = i2 + 1;
                cArr2[i2] = cArr[b2 & 15];
            }
            return new String(cArr2);
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean a(int i) {
        return i == 1;
    }

    public static String b() {
        if (b == null || b.isEmpty()) {
            b = c.a("ro.product.model", "");
            b = b.replaceAll(" ", "");
            return b;
        }
        return b;
    }

    private static String b(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (str.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SP) || str.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            str = str.replace(Constants.ACCEPT_TIME_SEPARATOR_SP, "");
        }
        if (str.startsWith("0")) {
            try {
                if (Long.parseLong(str) == 0) {
                    return null;
                }
                return str;
            } catch (Exception e) {
                return null;
            }
        }
        return str;
    }

    public static String c() {
        if (c == null || c.isEmpty()) {
            c = c.a("ro.build.version.incremental", "");
            return c;
        }
        return c;
    }

    public static String d() {
        return !a.a() ? a.b() : !c.a("ro.product.locale.region", "CN").equals("CN") ? "global" : a.c() ? "alpha" : a.d() ? "dev" : a.e() ? "stable" : "alpha";
    }

    public static int e() {
        String a2 = d.a();
        if (a2 == null) {
            return -1;
        }
        int length = a2.length();
        if (a2.isEmpty() || length <= 1) {
            return -1;
        }
        try {
            return Integer.parseInt(a2.substring(0, 3));
        } catch (Exception e) {
            return -1;
        }
    }

    public static int f() {
        String a2 = d.a();
        if (a2 == null) {
            return -1;
        }
        int length = a2.length();
        if (a2.isEmpty() || length <= 1) {
            return -1;
        }
        try {
            return Integer.parseInt(a2.substring(3));
        } catch (Exception e) {
            return -1;
        }
    }

    public static String g() {
        try {
            return com.xiaomi.metoknlp.a.a().getPackageManager().getPackageInfo(com.xiaomi.metoknlp.a.a().getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String h() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}
