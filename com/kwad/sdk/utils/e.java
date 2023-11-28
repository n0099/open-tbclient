package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes10.dex */
public final class e {
    public static HashMap<String, ArrayList<String>> aME = new HashMap<>();
    public static String aMF;

    @Nullable
    public static ArrayList<String> K(Context context, String str) {
        String packageName;
        Signature[] L;
        if (context == null || (packageName = context.getPackageName()) == null) {
            return null;
        }
        if (aME.get(str) != null) {
            return aME.get(str);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            for (Signature signature : L(context, packageName)) {
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
            com.kwad.sdk.core.e.c.e("AppSigningUtil", "签名信息列表获取失败 " + e.getMessage());
        }
        aME.put(str, arrayList);
        return arrayList;
    }

    public static Signature[] L(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.signatures;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.e("AppSigningUtil", e.getMessage());
            return null;
        }
    }

    public static String a(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest == null) {
                return "error!";
            }
            byte[] digest = messageDigest.digest(byteArray);
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1);
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.e("AppSigningUtil", e.getMessage());
            return "error!";
        }
    }

    @Nullable
    public static String bG(Context context) {
        if (!TextUtils.isEmpty(aMF)) {
            return aMF;
        }
        ArrayList<String> K = K(context, "SHA1");
        if (K != null && K.size() != 0) {
            aMF = K.get(0);
        }
        return aMF;
    }
}
