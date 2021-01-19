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
    private static HashMap<String, String> pZW = new HashMap<>();
    private static boolean pYM = false;

    public static String R(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(URLEncoder.encode(entry.getKey(), "UTF-8")).append("=").append(URLEncoder.encode(entry.getValue(), "UTF-8")).append(ETAG.ITEM_SEPARATOR);
        }
        return sb.substring(0, sb.length() - 1);
    }

    private static String aaH(String str) {
        try {
            return bc.aaI(str);
        } catch (Exception e) {
            return str;
        }
    }

    public static HashMap<String, String> iM(Context context) {
        HashMap<String, String> hashMap;
        if (pYM) {
            hashMap = pZW;
        } else {
            pZW.put("app", context.getPackageName());
            pZW.put("sdkna", "norm-1.1.3");
            pZW.put("plat", "a");
            pZW.put("model", Build.MODEL);
            pZW.put("manu", Build.MANUFACTURER);
            pZW.put("sysv", String.valueOf(Build.VERSION.SDK_INT));
            pZW.put("h", String.valueOf(bd.iR(context)));
            pZW.put("w", String.valueOf(bd.iQ(context)));
            pZW.put("appv", String.valueOf(bd.a(context)));
            pZW.put("appvn", bd.iO(context));
            pZW.put("rt", ay.java() ? "1" : "0");
            pZW.put("dpi", String.valueOf(context.getResources().getDisplayMetrics().densityDpi));
            String java = bd.java();
            if (!TextUtils.isEmpty(java)) {
                pZW.put("serial", aaH(java));
            }
            String d = bd.d(context);
            if (!TextUtils.isEmpty(d)) {
                pZW.put("imsi", aaH(d));
            }
            pYM = true;
            hashMap = pZW;
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        String c = bd.c(context);
        if (!TextUtils.isEmpty(c)) {
            hashMap2.put("imei", aaH(c));
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
            hashMap2.put("oaid", aaH(iP2));
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
            hashMap2.put("wm", aaH(eGG));
        }
        double d2 = au.a.eGO().qag;
        if (d2 > 0.0d) {
            hashMap2.put("lau", aaH(String.valueOf(d2)));
            hashMap2.put("lon", aaH(String.valueOf(au.a.eGO().qah)));
        }
        try {
            String java2 = bl.java();
            if (!TextUtils.isEmpty(java2)) {
                hashMap2.put("oid", aaH(java2));
            }
            String a2 = bl.a();
            if (!TextUtils.isEmpty(a2)) {
                hashMap2.put("vid", aaH(a2));
            }
            String eGG2 = bl.eGG();
            if (!TextUtils.isEmpty(eGG2)) {
                hashMap2.put("aid", aaH(eGG2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap2;
    }
}
