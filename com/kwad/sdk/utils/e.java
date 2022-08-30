package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class e {
    public static HashMap<String, ArrayList<String>> amJ = new HashMap<>();
    public static String amK;

    public static String a(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest != null) {
                byte[] digest = messageDigest.digest(byteArray);
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3).toUpperCase());
                    sb.append(":");
                }
                return sb.substring(0, sb.length() - 1);
            }
            return "error!";
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.e("AppSigningUtil", e.getMessage());
            return "error!";
        }
    }

    @Nullable
    public static String bR(Context context) {
        if (TextUtils.isEmpty(amK)) {
            ArrayList<String> w = w(context, "SHA1");
            if (w != null && w.size() != 0) {
                amK = w.get(0);
            }
            return amK;
        }
        return amK;
    }

    @Nullable
    public static ArrayList<String> w(Context context, String str) {
        String packageName;
        Signature[] x;
        if (context == null || (packageName = context.getPackageName()) == null) {
            return null;
        }
        if (amJ.get(str) != null) {
            return amJ.get(str);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            for (Signature signature : x(context, packageName)) {
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
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.e("AppSigningUtil", "签名信息列表获取失败 " + e.getMessage());
        }
        amJ.put(str, arrayList);
        return arrayList;
    }

    public static Signature[] x(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.signatures;
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.e("AppSigningUtil", e.getMessage());
            return null;
        }
    }
}
