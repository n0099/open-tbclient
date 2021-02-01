package com.tencent.ams.a.a.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import cn.mmachina.JniClient;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes15.dex */
public class a {
    public static String a(Context context, String str) {
        String MDString = JniClient.MDString("", context, str);
        com.tencent.ams.a.b.a.a("MMASignature: " + MDString);
        return MDString;
    }

    public static String a(String str) {
        Matcher matcher = Pattern.compile("^([\\w\\d]+):\\/\\/([\\w\\d\\-_]+(?:\\.[\\w\\d\\-_]+)*)").matcher(str);
        return matcher.find() ? matcher.group(0) : "";
    }

    public static String a(String str, com.tencent.ams.a.a.b.a aVar, com.tencent.ams.a.a.b.b bVar) {
        try {
            if (aVar.c) {
                return str == null ? "" : URLEncoder.encode(str, "utf-8");
            }
            return str == null ? "" : str;
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static String a(String str, List<String> list, String str2, String str3) {
        for (String str4 : list) {
            if (str.contains(str2 + str4)) {
                com.tencent.ams.a.b.a.a("mma_" + str2 + str4 + str3 + "[^" + str2 + "]*");
                str = str.replaceAll(str2 + str4 + str3 + "[^" + str2 + "]*", "");
            }
        }
        return str;
    }

    private static List<String> a(List list) {
        Collections.sort(list, new Comparator<String>() { // from class: com.tencent.ams.a.a.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(String str, String str2) {
                return (str != null && (str2 == null || str.length() <= str2.length())) ? 1 : -1;
            }
        });
        return list;
    }

    public static Map a(String str, List<String> list, String str2, String str3, String str4) {
        List<String> a2 = a(list);
        HashMap hashMap = new HashMap();
        for (String str5 : a2) {
            if (str.contains(str2 + str5)) {
                if (str5.equals(str4)) {
                    Matcher matcher = Pattern.compile(str2 + str5 + "[^" + str2 + "]*").matcher(str);
                    if (matcher.find()) {
                        matcher.group(0).replace(str2 + str5, "");
                    }
                }
                str = str.replaceAll(str2 + str5 + str3 + "[^" + str2 + "]*", "");
            }
        }
        hashMap.put("URL", str);
        return hashMap;
    }

    public static boolean a(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (networkInfo = connectivityManager.getNetworkInfo(1)) == null) {
            return false;
        }
        return networkInfo.isAvailable();
    }

    public static String b(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            messageDigest.update(str.getBytes());
            String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
            while (bigInteger.length() < 32) {
                bigInteger = "0" + bigInteger;
            }
            return bigInteger.toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (networkInfo = connectivityManager.getNetworkInfo(0)) == null) {
            return false;
        }
        return networkInfo.isAvailable();
    }

    public static String c(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
