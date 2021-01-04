package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.pm.Signature;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, ArrayList<String>> f7877a = new HashMap<>();

    public static ArrayList<String> a(Context context, String str) {
        String packageName;
        Signature[] b2;
        if (context == null || str == null || (packageName = context.getPackageName()) == null) {
            return null;
        }
        if (f7877a.get(str) != null) {
            return f7877a.get(str);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            for (Signature signature : b(context, packageName)) {
                String str2 = "error!";
                if (EncryptUtils.ENCRYPT_MD5.equals(str)) {
                    str2 = a(signature, EncryptUtils.ENCRYPT_MD5);
                } else if ("SHA1".equals(str)) {
                    str2 = a(signature, "SHA1");
                } else if ("SHA256".equals(str)) {
                    str2 = a(signature, "SHA256");
                }
                arrayList.add(str2);
            }
        } catch (Exception e) {
            u.b(e.toString());
        }
        f7877a.put(str, arrayList);
        return arrayList;
    }

    public static String a(Context context) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> a2 = a(context, "SHA1");
        if (a2 != null && a2.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= a2.size()) {
                    break;
                }
                sb.append(a2.get(i2));
                if (i2 < a2.size() - 1) {
                    sb.append(",");
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    private static Signature[] b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e) {
            u.b(e.toString());
            return null;
        }
    }

    private static String a(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest == null) {
                return "error!";
            }
            byte[] digest = messageDigest.digest(byteArray);
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1).toString();
        } catch (Exception e) {
            u.b(e.toString());
            return "error!";
        }
    }
}
