package d.a.k.d;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f44067a;

    /* renamed from: b  reason: collision with root package name */
    public static String f44068b;

    public static String a() {
        return TextUtils.isEmpty(f44068b) ? "armeabi-v7a" : f44068b;
    }

    public static String b(Context context) {
        return e(context, "rtc");
    }

    public static String c(Context context, String str) {
        return d(context, str, b(context));
    }

    public static String d(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = b(context);
        }
        return str2 + File.separator + j(str);
    }

    public static String e(Context context, String str) {
        if (context == null) {
            return null;
        }
        String absolutePath = context.getFilesDir().getAbsolutePath();
        StringBuilder sb = new StringBuilder();
        sb.append(absolutePath);
        sb.append(File.separator);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb.append(str);
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String f() {
        String str = "https://b.bdstatic.com/searchbox/androidvideo/" + h();
        f44067a = str;
        return str;
    }

    public static String g(Context context) {
        if (TextUtils.isEmpty(f44067a)) {
            f();
        }
        return c(context, f44067a) + File.separator + "jniLibs" + File.separator + a();
    }

    public static String h() {
        return a() + "_rtc_5.4.19.zip";
    }

    public static boolean i(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        String d2 = d(context, str, str2);
        return d.a.k.e.a.c(d2 + File.separator + "jniLibs" + File.separator + a() + File.separator + "libjingle_peerconnection_so.so");
    }

    public static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String str2 = "";
            for (byte b2 : MessageDigest.getInstance("MD5").digest(str.getBytes())) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                str2 = str2 + hexString;
            }
            return str2.toLowerCase();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void k(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "armeabi-v7a";
        }
        f44068b = str;
    }
}
