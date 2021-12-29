package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.Signature;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class g {
    public static HashMap<String, ArrayList<String>> a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static String f60225b;

    @Nullable
    public static String a(Context context) {
        if (TextUtils.isEmpty(f60225b)) {
            ArrayList<String> a2 = a(context, "SHA1");
            if (a2 != null && a2.size() != 0) {
                f60225b = a2.get(0);
            }
            return f60225b;
        }
        return f60225b;
    }

    public static String a(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest != null) {
                byte[] digest = messageDigest.digest(byteArray);
                StringBuilder sb = new StringBuilder();
                for (byte b2 : digest) {
                    sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3).toUpperCase());
                    sb.append(":");
                }
                return sb.substring(0, sb.length() - 1);
            }
            return "error!";
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.e("AppSigningUtil", e2.getMessage());
            return "error!";
        }
    }

    @Nullable
    public static ArrayList<String> a(Context context, String str) {
        Signature[] b2;
        ArrayList<String> arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            if (a.get(str) != null) {
                return a.get(str);
            }
            arrayList = new ArrayList<>();
            try {
                for (Signature signature : b(context, packageName)) {
                    String str2 = "error!";
                    if ("MD5".equals(str)) {
                        str2 = a(signature, "MD5");
                    } else if ("SHA1".equals(str)) {
                        str2 = a(signature, "SHA1");
                    } else if ("SHA256".equals(str)) {
                        str2 = a(signature, "SHA256");
                    }
                    arrayList.add(str2);
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.e("AppSigningUtil", "签名信息列表获取失败 " + e2.getMessage());
            }
            a.put(str, arrayList);
        }
        return arrayList;
    }

    public static Signature[] b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.e("AppSigningUtil", e2.getMessage());
            return null;
        }
    }
}
