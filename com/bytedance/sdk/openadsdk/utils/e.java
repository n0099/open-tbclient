package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, ArrayList<String>> f30107a = new HashMap<>();

    public static ArrayList<String> a(Context context, String str) {
        Signature[] b2;
        ArrayList<String> arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            if (f30107a.get(str) != null) {
                return f30107a.get(str);
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
                u.b(e2.toString());
            }
            f30107a.put(str, arrayList);
        }
        return arrayList;
    }

    public static Signature[] b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e2) {
            u.b(e2.toString());
            return null;
        }
    }

    public static String a(Context context) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> a2 = a(context, "SHA1");
        if (a2 != null && a2.size() != 0) {
            for (int i = 0; i < a2.size(); i++) {
                sb.append(a2.get(i));
                if (i < a2.size() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
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
                return sb.substring(0, sb.length() - 1).toString();
            }
            return "error!";
        } catch (Exception e2) {
            u.b(e2.toString());
            return "error!";
        }
    }
}
