package com.win.opensdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import com.win.opensdk.au;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes3.dex */
public final class ak {
    private static HashMap<String, String> pZV = new HashMap<>();
    private static boolean pYL = false;

    public static String R(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(URLEncoder.encode(entry.getKey(), "UTF-8")).append("=").append(URLEncoder.encode(entry.getValue(), "UTF-8")).append(ETAG.ITEM_SEPARATOR);
        }
        return sb.substring(0, sb.length() - 1);
    }

    private static String aaG(String str) {
        try {
            return bc.aaH(str);
        } catch (Exception e) {
            return str;
        }
    }

    public static HashMap<String, String> iM(Context context) {
        HashMap<String, String> hashMap;
        if (pYL) {
            hashMap = pZV;
        } else {
            pZV.put("app", context.getPackageName());
            pZV.put("sdkna", "norm-1.1.3");
            pZV.put("plat", "a");
            pZV.put("model", Build.MODEL);
            pZV.put("manu", Build.MANUFACTURER);
            pZV.put("sysv", String.valueOf(Build.VERSION.SDK_INT));
            pZV.put("h", String.valueOf(bd.iR(context)));
            pZV.put("w", String.valueOf(bd.iQ(context)));
            pZV.put("appv", String.valueOf(bd.a(context)));
            pZV.put("appvn", bd.iO(context));
            pZV.put("rt", ay.java() ? "1" : "0");
            pZV.put("dpi", String.valueOf(context.getResources().getDisplayMetrics().densityDpi));
            String java = bd.java();
            if (!TextUtils.isEmpty(java)) {
                pZV.put("serial", aaG(java));
            }
            String d = bd.d(context);
            if (!TextUtils.isEmpty(d)) {
                pZV.put("imsi", aaG(d));
            }
            pYL = true;
            hashMap = pZV;
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        String c = bd.c(context);
        if (!TextUtils.isEmpty(c)) {
            hashMap2.put("imei", aaG(c));
        }
        String m70a = bd.m70a(context);
        if (!TextUtils.isEmpty(m70a)) {
            hashMap2.put("opcode", m70a);
        }
        String iP = bd.iP(context);
        if (!TextUtils.isEmpty(iP)) {
            hashMap2.put("anid", iP);
        }
        String iP2 = at.iP(context);
        if (!TextUtils.isEmpty(iP2)) {
            hashMap2.put("oaid", aaG(iP2));
        }
        hashMap2.put("lic", az.iO(context));
        hashMap2.put("locale", Locale.getDefault().getLanguage());
        String b2 = bd.b(context);
        if (!TextUtils.isEmpty(b2)) {
            hashMap2.put("net", b2);
        }
        hashMap2.put("bt", az.m61a(context));
        String eGG = bd.eGG();
        if (!TextUtils.isEmpty(eGG)) {
            hashMap2.put("wm", aaG(eGG));
        }
        double d2 = au.a.eGO().qaf;
        if (d2 > 0.0d) {
            hashMap2.put("lau", aaG(String.valueOf(d2)));
            hashMap2.put("lon", aaG(String.valueOf(au.a.eGO().qag)));
        }
        try {
            String java2 = bl.java();
            if (!TextUtils.isEmpty(java2)) {
                hashMap2.put("oid", aaG(java2));
            }
            String a2 = bl.a();
            if (!TextUtils.isEmpty(a2)) {
                hashMap2.put("vid", aaG(a2));
            }
            String eGG2 = bl.eGG();
            if (!TextUtils.isEmpty(eGG2)) {
                hashMap2.put("aid", aaG(eGG2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap2;
    }
}
