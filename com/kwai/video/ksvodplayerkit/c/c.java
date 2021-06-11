package com.kwai.video.ksvodplayerkit.c;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import java.security.MessageDigest;
import java.util.Locale;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f38059a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b  reason: collision with root package name */
    public static volatile com.kwai.video.ksvodplayerkit.a f38060b;

    public static int a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static String a(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            if (i2 < 0 || i2 + i3 > bArr.length) {
                throw new IndexOutOfBoundsException();
            }
            int i4 = i3 * 2;
            char[] cArr = new char[i4];
            int i5 = 0;
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = bArr[i6 + i2] & 255;
                int i8 = i5 + 1;
                char[] cArr2 = f38059a;
                cArr[i5] = cArr2[i7 >> 4];
                i5 = i8 + 1;
                cArr[i8] = cArr2[i7 & 15];
            }
            return new String(cArr, 0, i4);
        }
        throw new NullPointerException("bytes is null");
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) || str.toLowerCase().startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS);
    }

    public static int b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains(".m3u8");
    }

    public static String c(String str) {
        if (f38060b != null) {
            return f38060b.a(str);
        }
        String lowerCase = d(str).toLowerCase(Locale.US);
        try {
            String path = Uri.parse(str).getPath();
            if (!TextUtils.isEmpty(path)) {
                return e(path) + lowerCase;
            }
        } catch (Exception e2) {
            com.kwai.video.ksvodplayerkit.a.b.e("VodPlayerUtils", e2.getMessage());
        }
        return str;
    }

    public static String d(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            try {
                String path = Uri.parse(str).getPath();
                if (path == null) {
                    return ".xxx";
                }
                int lastIndexOf = path.lastIndexOf(46);
                String substring = path.substring(lastIndexOf);
                return (lastIndexOf < 0 || lastIndexOf >= path.length() + (-2)) ? ".mp4" : substring != null ? substring.toLowerCase() : substring;
            } catch (Throwable th) {
                com.kwai.video.ksvodplayerkit.a.b.e("VodPlayerUtils", "fail to parse ext from url: " + str, th);
            }
        }
        return ".mp4";
    }

    public static String e(String str) {
        String str2 = null;
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    if (messageDigest == null) {
                        return null;
                    }
                    messageDigest.update(str.getBytes("UTF-8"));
                    byte[] digest = messageDigest.digest();
                    if (digest == null || digest.length < 1) {
                        return null;
                    }
                    str2 = a(digest, 0, digest.length);
                    return str2;
                }
                return "";
            } catch (Throwable unused) {
                return str2;
            }
        }
        return "";
    }
}
