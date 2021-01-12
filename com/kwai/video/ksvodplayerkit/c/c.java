package com.kwai.video.ksvodplayerkit.c;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.security.MessageDigest;
import java.util.Locale;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f11061a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b  reason: collision with root package name */
    private static volatile com.kwai.video.ksvodplayerkit.a f11062b;

    public static int a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static String a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        if (i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        char[] cArr = new char[i2 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = bArr[i4 + i] & 255;
            int i6 = i3 + 1;
            cArr[i3] = f11061a[i5 >> 4];
            i3 = i6 + 1;
            cArr[i6] = f11061a[i5 & 15];
        }
        return new String(cArr, 0, i2 * 2);
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
        if (f11062b != null) {
            return f11062b.a(str);
        }
        String lowerCase = d(str).toLowerCase(Locale.US);
        try {
            String path = Uri.parse(str).getPath();
            return !TextUtils.isEmpty(path) ? e(path) + lowerCase : str;
        } catch (Exception e) {
            com.kwai.video.ksvodplayerkit.a.b.e("VodPlayerUtils", e.getMessage());
            return str;
        }
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
                    MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
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
            } catch (Throwable th) {
                return str2;
            }
        }
        return "";
    }
}
