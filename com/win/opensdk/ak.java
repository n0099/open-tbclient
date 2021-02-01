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
    private static HashMap<String, String> qka = new HashMap<>();
    private static boolean qiQ = false;

    public static String T(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(URLEncoder.encode(entry.getKey(), "UTF-8")).append("=").append(URLEncoder.encode(entry.getValue(), "UTF-8")).append(ETAG.ITEM_SEPARATOR);
        }
        return sb.substring(0, sb.length() - 1);
    }

    private static String abI(String str) {
        try {
            return bc.abJ(str);
        } catch (Exception e) {
            return str;
        }
    }

    public static HashMap<String, String> iP(Context context) {
        HashMap<String, String> hashMap;
        if (qiQ) {
            hashMap = qka;
        } else {
            qka.put("app", context.getPackageName());
            qka.put("sdkna", "norm-1.1.3");
            qka.put("plat", "a");
            qka.put("model", Build.MODEL);
            qka.put("manu", Build.MANUFACTURER);
            qka.put("sysv", String.valueOf(Build.VERSION.SDK_INT));
            qka.put("h", String.valueOf(bd.iU(context)));
            qka.put("w", String.valueOf(bd.iT(context)));
            qka.put("appv", String.valueOf(bd.a(context)));
            qka.put("appvn", bd.iR(context));
            qka.put("rt", ay.java() ? "1" : "0");
            qka.put("dpi", String.valueOf(context.getResources().getDisplayMetrics().densityDpi));
            String java = bd.java();
            if (!TextUtils.isEmpty(java)) {
                qka.put("serial", abI(java));
            }
            String d = bd.d(context);
            if (!TextUtils.isEmpty(d)) {
                qka.put("imsi", abI(d));
            }
            qiQ = true;
            hashMap = qka;
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        String c = bd.c(context);
        if (!TextUtils.isEmpty(c)) {
            hashMap2.put("imei", abI(c));
        }
        String m70a = bd.m70a(context);
        if (!TextUtils.isEmpty(m70a)) {
            hashMap2.put("opcode", m70a);
        }
        String iS = bd.iS(context);
        if (!TextUtils.isEmpty(iS)) {
            hashMap2.put("anid", iS);
        }
        String iS2 = at.iS(context);
        if (!TextUtils.isEmpty(iS2)) {
            hashMap2.put("oaid", abI(iS2));
        }
        hashMap2.put("lic", az.iR(context));
        hashMap2.put("locale", Locale.getDefault().getLanguage());
        String b2 = bd.b(context);
        if (!TextUtils.isEmpty(b2)) {
            hashMap2.put("net", b2);
        }
        hashMap2.put("bt", az.m61a(context));
        String eIW = bd.eIW();
        if (!TextUtils.isEmpty(eIW)) {
            hashMap2.put("wm", abI(eIW));
        }
        double d2 = au.a.eJe().qkk;
        if (d2 > 0.0d) {
            hashMap2.put("lau", abI(String.valueOf(d2)));
            hashMap2.put("lon", abI(String.valueOf(au.a.eJe().qkl)));
        }
        try {
            String java2 = bl.java();
            if (!TextUtils.isEmpty(java2)) {
                hashMap2.put("oid", abI(java2));
            }
            String a2 = bl.a();
            if (!TextUtils.isEmpty(a2)) {
                hashMap2.put("vid", abI(a2));
            }
            String eIW2 = bl.eIW();
            if (!TextUtils.isEmpty(eIW2)) {
                hashMap2.put("aid", abI(eIW2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap2;
    }
}
